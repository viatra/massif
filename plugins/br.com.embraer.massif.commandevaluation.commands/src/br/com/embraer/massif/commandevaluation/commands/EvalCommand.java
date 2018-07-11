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

import br.com.embraer.massif.commandevaluation.exception.MatlabError;
import br.com.embraer.massif.commandevaluation.exception.MatlabRMIException;

/**
 * Wrapper class for the "eval" command
 * 
 * @author ldnascim
 */
public class EvalCommand extends InteractionCommand {

	/** eval command **/
	private String command;
	
	/**
	 * Constructor
	 * @param numberOfOutputsArguments Number of outputs
	 * @param command Eval command
	 */
	public EvalCommand(int numberOfOutputsArguments, String command) {
		super(numberOfOutputsArguments);
		this.command = command;
	}
	
	/**
	 * Retrieves the command
	 * @return eval command
	 */
	public String getCommand() {
		return command;
	}

	@Override
	protected Object execute() throws MatlabRMIException {
		Object output = null;
		int numberOfOutputArguments = getNumberOfOutputsArguments();
		try {
			output = com.mathworks.jmi.Matlab.mtEval(command, numberOfOutputArguments);
		} catch (Exception e) {
			MatlabRMIException exception =
					new MatlabRMIException(MatlabError.EXECUTING_COMMAND_ON_MATLAB_ERROR, e);
			exception.set("Type", "mtEval");
			exception.set("command", command);
			exception.set("numberOfOutputArguments", numberOfOutputArguments);
			throw exception;
		}
		return output;
	}
	
	@Override
	public String toString() {
		String str = "Type: mtEval, command: " + command +
				", numberOfOutputArguments: " + getNumberOfOutputsArguments();   
		return str;
	}
}