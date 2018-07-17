/*******************************************************************************
 * Copyright (c) 2010-2018, IncQuery Labs Ltd., logi.cals GmbH, McGill University
 * All rights reserved. This program and the accompanying materials 
 * are made available under the terms of the Eclipse Public License v1.0 
 * which accompanies this distribution, and is available at 
 * http://www.eclipse.org/legal/epl-v10.html 
 *
 * Contributors: 
 *     Marton Bur - initial API and implementation 
 *******************************************************************************/
package hu.bme.mit.massif.communication.matlabengine;

import com.mathworks.engine.EngineException;
import com.mathworks.engine.MatlabEngine;

import hu.bme.mit.massif.communication.ICommandAccess;

/**
 * @author Marton Bur
 */
public class MatlabEngineAccess implements ICommandAccess {

	private MatlabEngine engine;

	public MatlabEngineAccess() throws EngineException, InterruptedException {

		engine = MatlabEngine.connectMatlab();

	}

	@Override
	public Object[] executeFeval(String name, Object[] inputArgs, int numberOfOutputs) throws Exception {
		return engine.<Object[]>feval(name, inputArgs);
	}

	@Override
	public Object[] executeEval(String command, int numberOfOutputs) throws Exception {
		Object[] retVal = null;
		if (command.contentEquals("GetImporterTmpResult")) {
			if (numberOfOutputs == 0) {
				retVal = new Object[] {};
			} else if (numberOfOutputs == 1) {
				retVal = new Object[] { engine.getVariable("ImporterTmpResult") };
			} else {
				retVal = engine.getVariable("ImporterTmpResult");
			}
		} else {
			engine.eval(command);
		}
		return retVal;
	}

}
