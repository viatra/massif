package br.com.embraer.transima.matlab.commandevaluation.server;

import java.util.UUID;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.Semaphore;

import br.com.embraer.transima.matlab.commandevaluation.command.InteractionCommand;
import br.com.embraer.transima.matlab.commandevaluation.exception.MatlabError;
import br.com.embraer.transima.matlab.commandevaluation.exception.MatlabOutputException;
import br.com.embraer.transima.matlab.commandevaluation.exception.MatlabRMIException;

import com.mathworks.jmi.Matlab;

/**
 * Class responsible for executing the matlab evals and fevals
 * in background. Its main code is run in a thread, then the matlab
 * command line is not locked
 *
 * @author ldnascim
 */
public class MatlabServerController implements Runnable {
	
	/** Flag to indicate if the thread is running**/
	private boolean running;

    private boolean debug;

	/** Contains the commands to be executed in matlab **/
	private BlockingQueue<InteractionCommand> commands;

	/** Contains the outputs for the commands executed in matlab **/
	private ConcurrentMap<UUID, InteractionCommand> commandsResponses;

	/**
	 * Semaphore used to control that commands were received
	 * This is used in order to "notify" the server controller thread
	 * that a command was added, in order to avoid using a Thread-poll
	 * solution, which consumes CPU resource
	 */
	private Semaphore commandsSemaphore;

	/**
	 * Default constructor. A thread is started here
	 * in order to enable the execution of the commands
	 * in background
	 */
	public MatlabServerController() {
		commands = new LinkedBlockingQueue<InteractionCommand>();
		commandsResponses = new ConcurrentHashMap<UUID, InteractionCommand>();
		commandsSemaphore = new Semaphore(0);

		// starts thread
		new Thread(this).start();
	}

	/**
	 * This method will execute the eval/feval commands in the matlab
	 * thread by using the method "whenAtPrompt"
	 * @param command Command to be executed
	 */
	private void executeCommand(final InteractionCommand command) {
        if (debug) {
            System.out.println("Executing command: " + command.toString());
        }
		// executes command in the matlab thread
        Matlab.whenAtPrompt(new Runnable() {
			@Override
			public void run() {
				command.executeCommand();
			}
		});
	}

	/**
	 * Adds a command in the queue to be executed
	 * @param command Command to be executed
	 */
	public void addCommand(InteractionCommand command) {
		boolean wasEmpty = commands.isEmpty();
		commands.add(command);
		
		// checks if command expects output objects
		if (command.getNumberOfOutputsArguments() > 0)
		{
			commandsResponses.put(command.getIdNumber(), command);
		}

		// if the list was empty then notify the thread
		// that a new command to be executed was added
		if (wasEmpty) {
			// notifies that a command was added
			commandsSemaphore.release();
		}
	}

	/**
	 * Returns the thread is running or not
	 * @return true if the thread is running,
	 * 		   false otherwise
	 */
	public boolean isRunning() {
		return running;
	}

    public void setDebug(boolean debug) {
        this.debug = debug;
    }

	/**
	 * Retrieves the output from an executed command
	 * using the UUID provided in the execution.
	 * @param idCommand Identifier for the execution
	 * @return Output for the command
	 * @throws MatlabOutputException
	 */
	public Object[] getCommandOutput(UUID idCommand) throws MatlabOutputException {
		InteractionCommand command = commandsResponses.remove(idCommand);

		// waits until the command finish its execution
		if (!command.isFinished()) {
			command.waitToFinish();
		}

		return command.getOutput();
	}

	@Override
	public void run() {
		running = true;

        while (running) {
			if (commands.isEmpty()) {
				// waits until receive at least one new command
				try {
					commandsSemaphore.acquire();
				} catch (InterruptedException e) {
					MatlabRMIException exception =
							new MatlabRMIException(MatlabError.WAITING_NOTIFY_ERROR, e);
					// Since we can't throw the exception, print
					// the error message
					exception.printStackTrace();
				}
			}

			// if the execution reaches here, then we have at least
			// one command to execute
			if (!commands.isEmpty()) {
				InteractionCommand command = commands.poll();
				if (command != null) {
					executeCommand(command);
				}
			}
		}
	}
}
