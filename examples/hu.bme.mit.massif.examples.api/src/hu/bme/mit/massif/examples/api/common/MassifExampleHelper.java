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
package hu.bme.mit.massif.examples.api.common;

import hu.bme.mit.massif.communication.ICommandEvaluator;
import hu.bme.mit.massif.communication.commandevaluation.CommandEvaluatorImpl;
import hu.bme.mit.massif.communication.matlabcontrol.MatlabControlEvaluator;
import hu.bme.mit.massif.communication.matlabengine.MatlabEngineEvaluator;
import hu.bme.mit.massif.examples.api.settings.ImporterExampleSettings;
import hu.bme.mit.massif.simulink.api.exception.SimulinkApiException;

import com.mathworks.engine.EngineException;

import br.com.embraer.massif.commandevaluation.client.MatlabClient;
import br.com.embraer.massif.commandevaluation.exception.MatlabRMIException;

public class MassifExampleHelper {

    public static ICommandEvaluator createCommandEvaluator() throws MatlabRMIException, SimulinkApiException, EngineException, InterruptedException {
    	
    	switch (ImporterExampleSettings.MATLAB_CONNECTOR) {
    	case COMMAND_EVALUATION_SERVER:
    		String hostAddress = ImporterExampleSettings.HOST_ADDRESS;
    		int hostPort = ImporterExampleSettings.HOST_PORT;
    		String serviceName = ImporterExampleSettings.SERVICE_NAME;
    		
    		MatlabClient matlabClient = new MatlabClient(hostAddress, hostPort, serviceName);
    		return new CommandEvaluatorImpl(matlabClient);			    		
		case MATLAB_CONTROL:
			
			return new MatlabControlEvaluator(ImporterExampleSettings.MATLAB_PATH, ImporterExampleSettings.PRINT_ISSUED_COMMANDS);
		case MATLAB_ENGINE:
			return new MatlabEngineEvaluator(ImporterExampleSettings.PRINT_ISSUED_COMMANDS);			
		default:
			throw new SimulinkApiException("Not supported connector was set: " + ImporterExampleSettings.MATLAB_CONNECTOR);
		}
    }
	
}
