/*******************************************************************************
 * Copyright (c) 2010-2017, IncQuery Labs Ltd., Embraer S.A., Budapest University of Technology and Economics
 * All rights reserved. This program and the accompanying materials 
 * are made available under the terms of the Eclipse Public License v1.0 
 * which accompanies this distribution, and is available at 
 * http://www.eclipse.org/legal/epl-v10.html 
 *
 * Contributors: 
 *     Rodrigo Rizzi Starr, Lincoln Nascimento - initial API and implementation 
 *     Peter Lunk - Separated MATLAB commands and RMI server
 *******************************************************************************/
package br.com.embraer.massif.commandevaluation.commands;

import java.util.UUID;

import br.com.embraer.massif.commandevaluation.exception.MatlabError;
import br.com.embraer.massif.commandevaluation.exception.MatlabException;
import br.com.embraer.massif.commandevaluation.exception.MatlabOutputException;
import br.com.embraer.massif.commandevaluation.exception.MatlabRMIException;

/**
 * Interaction commands, such as eval or feval commands
 * 
 * @author ldnascim
 */
abstract public class InteractionCommand {

	private int numberOfOutputsArguments;

	/** Object used to notify when a server command has finished **/
	private Object finishLock;
	private boolean waitingForFinish;

	private UUID idNumber;
	private boolean finished;
	private Object output;
	private MatlabException exception;

	/**
	 * Constructor
	 * @param numberOfOutputsArguments number of outputs
	 */
	public InteractionCommand(int numberOfOutputsArguments) {
		this.numberOfOutputsArguments = numberOfOutputsArguments;
		this.idNumber = UUID.randomUUID();
		this.finished = false;
		this.finishLock = new Object();
		this.waitingForFinish = false;
	}

	/**
	 * Returns the number of outputs
	 * @return Number of outputs
	 */
	public int getNumberOfOutputsArguments() {
		return numberOfOutputsArguments;
	}

	/**
	 * Returns the output of the command
	 * @throws MatlabOutputException
	 */
	public Object[] getOutput() throws MatlabOutputException {
		Object[] returnOutput = null;

		// if output is not null, return it, otherwise
		// throws an exception warning the user the output is null
		if (output != null) {
			if (getNumberOfOutputsArguments() <= 1) {
				returnOutput = new Object[]{output};
			} else {
				returnOutput = (Object[]) output;
			}
		} else {
            MatlabOutputException _exception = new MatlabOutputException(MatlabError.COMMAND_OUTPUT_NULL_ERROR, null);
            _exception.set("Command", this.toString());
            exception = _exception;
            throw _exception;
		}

		return returnOutput;
	}

	/**
	 * Returns identifier for the command
	 * 
	 * @return Identifier for the command
	 */
	public UUID getIdNumber() {
		return idNumber;
	}

	/**
	 * Returns the command has finished its execution
	 * 
	 * @return true if the command has finished, false otherwise
	 */
	public boolean isFinished() {
		return finished;
	}

	/**
	 * Sets the "finished" status for the command
	 * 
	 * @param finished
	 *            true if the command has finished, false otherwise
	 */
	private void setFinished() {
		this.finished = true;

		if (this.waitingForFinish && this.finished) {
			synchronized (finishLock) {
				// notifies that a command was added
				finishLock.notify();
			}
		}
	}

	/**
	 * Waits for the command to finish its execution
	 */
	public void waitToFinish() {
		this.waitingForFinish = true;

		while (!this.finished){
			synchronized (finishLock) {
                // wait for a command to finish
				try {
					if (!this.finished) {
						finishLock.wait();
					}
				} catch (InterruptedException e) {
				}
			}
		}
	}

	/**
	 * Sets the output object for the command
	 * 
	 * @param output
	 *            response from the command execution
	 */
	private void setOutput(Object output) {
		this.output = output;
	}

	/**
	 * Sets the exception for the command, in case
	 * of a error ocurred during its execution
	 * @param exception Exception object
	 */
	private void setException(MatlabException exception) {
		this.exception = exception;
	}

	/**
	 * Gets the exception for the command, in case
	 * of a error ocurred during its execution
	 * @return exception object
	 */
	public Exception getException() {
		return this.exception;
	}

	/**
	 * Executes the command in server and stores its result
	 */
	public void executeCommand() {
        Object _output = null;
		try {
            _output = execute();
		} catch (MatlabRMIException e) {
			setException(e);
		}

        setOutput(_output);
		setFinished();
	}
	
	/**
	 * It will execute the command logic through a matlab
	 * RMI command
	 * @return Object containing the results of the command execution
	 * @throws MatlabRMIException
	 */
	abstract protected Object execute() throws MatlabRMIException;
}
