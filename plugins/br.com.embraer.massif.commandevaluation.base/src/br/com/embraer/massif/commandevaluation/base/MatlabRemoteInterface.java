/*******************************************************************************
 * Copyright (c) 2010-2013, Embraer S.A., Budapest University of Technology and Economics
 * All rights reserved. This program and the accompanying materials 
 * are made available under the terms of the Eclipse Public License v1.0 
 * which accompanies this distribution, and is available at 
 * http://www.eclipse.org/legal/epl-v10.html 
 *
 * Contributors: 
 *     Rodrigo Rizzi Starr, Lincoln Nascimento - initial API and implementation 
 *******************************************************************************/
package br.com.embraer.massif.commandevaluation.base;

import java.rmi.RemoteException;

import br.com.embraer.massif.commandevaluation.exception.MatlabOutputException;

/**
 * RMI interface for matlab server
 * 
 * @author ldnascim
 */
public interface MatlabRemoteInterface extends java.rmi.Remote {

    /**
	 * Executes feval("function evaluation") command in the matlab RMI server
	 * and retrieves its output(if any is expected)
	 * @param name Function name
	 * @param inputArgs Array of objects containing the function inputs
	 * @param numberOfOutputs Number of outputs
	 * @return Array of objects containing the feval output
	 * @throws RemoteException
	 */
    Object[] executeFeval(String name, Object[] inputArgs, int numberOfOutputs)
    		throws java.rmi.RemoteException, MatlabOutputException;
    
    /**
	 * Executes eval("evaluation") command in the matlab RMI server
	 * and retrieves its output(if any is expected)
	 * @param command Evaluation command to be executed
	 * @param numberOfOutputs Number of outputs
	 * @return Array of objects containing the eval output
	 * @throws RemoteException
	 */
    Object[] executeEval(String command, int numberOfOutputs)
    		throws java.rmi.RemoteException, MatlabOutputException;
}
