package br.com.embraer.transima.matlab.commandevaluation.server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.UUID;

import br.com.embraer.transima.matlab.commandevaluation.base.MatlabRemoteInterface;
import br.com.embraer.transima.matlab.commandevaluation.command.EvalCommand;
import br.com.embraer.transima.matlab.commandevaluation.command.FevalCommand;
import br.com.embraer.transima.matlab.commandevaluation.command.InteractionCommand;
import br.com.embraer.transima.matlab.commandevaluation.exception.MatlabOutputException;

public class MatlabRemoteImpl extends java.rmi.server.UnicastRemoteObject
	implements MatlabRemoteInterface {
	
	/**
	 * Generated UUID
	 */
	private static final long serialVersionUID = -4980200238447184775L;
	
	private MatlabServerController matlabServerController;

	/**
	 * Default constructor.
	 * The MatlabServerController is instantiated here in order
	 * to start the thread that will invoke in matlab the execution
	 * of eval and feval commands
	 * @throws java.rmi.RemoteException
	 */
    public MatlabRemoteImpl(boolean debug) throws java.rmi.RemoteException {
		super();
		UnicastRemoteObject.unexportObject(this, true);
		matlabServerController = new MatlabServerController();
        matlabServerController.setDebug(debug);
	}
	
	@Override
	public synchronized Object[] executeFeval(String name, Object[] inputArgs,
			int numberOfOutputs) throws RemoteException, MatlabOutputException {
		InteractionCommand fevalCommand = new FevalCommand(numberOfOutputs, name, inputArgs);
		matlabServerController.addCommand(fevalCommand);
		
		Object[] returnOutput = null;
		if (numberOfOutputs > 0) {
			UUID idCommand = fevalCommand.getIdNumber();
			returnOutput = matlabServerController.getCommandOutput(idCommand);
		}
		
		return returnOutput;
	}

	@Override
	public synchronized Object[] executeEval(String command, int numberOfOutputs)
			throws RemoteException, MatlabOutputException {
		InteractionCommand evalCommand = new EvalCommand(numberOfOutputs, command);
		matlabServerController.addCommand(evalCommand);
		
		Object[] returnOutput = null;
		if (numberOfOutputs > 0) {
			UUID idCommand = evalCommand.getIdNumber();
			returnOutput = matlabServerController.getCommandOutput(idCommand);
		}
		
		return returnOutput;
	}

}
