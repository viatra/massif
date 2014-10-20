/*******************************************************************************
 * Copyright (c) 2010-2013, Embraer S.A., Budapest University of Technology and Economics
 * All rights reserved. This program and the accompanying materials 
 * are made available under the terms of the Eclipse Public License v1.0 
 * which accompanies this distribution, and is available at 
 * http://www.eclipse.org/legal/epl-v10.html 
 *
 * Contributors: 
 *     Marton Bur, Abel Hegedus, Akos Horvath - initial API and implementation 
 *******************************************************************************/
package hu.bme.mit.massif.communication;

import hu.bme.mit.massif.communication.datatype.IVisitableMatlabData;

/**
 * Class responsible for the low level operations with MATLAB
 * 
 * (The successor class of the removed <code>BasicOperationsApi</code> utility class)
 */
public interface ICommandEvaluator {

    /**
     * Evaluate a given sting as a MATLAB command
     * 
     * @param command
     *            the MATLAB command
     * @param nargout
     *            the number of expected return values in MATLAB
     * @return the result data
     */
    public IVisitableMatlabData evaluateCommand(String command, int nargout);

    /**
     * Evaluate given string array as an array of commands. The return values are put into a newly created
     * CellMatlabData.
     * 
     * @param commandStrings
     *            the array containig the command strings
     * @param outputArgumentCount
     *            the output argument count for each command (must be the same for every command in the given array)
     * @return
     */
    public IVisitableMatlabData evaluateCommands(String[] commandStrings, int outputArgumentCount);

}
