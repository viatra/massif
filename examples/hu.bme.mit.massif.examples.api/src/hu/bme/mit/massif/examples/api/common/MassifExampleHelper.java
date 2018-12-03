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
import hu.bme.mit.massif.communication.command.MatlabCommand;
import hu.bme.mit.massif.communication.command.MatlabCommandFactory;
import hu.bme.mit.massif.communication.commandevaluation.CommandEvaluatorImpl;
import hu.bme.mit.massif.communication.matlabcontrol.MatlabControlEvaluator;
import hu.bme.mit.massif.communication.matlabengine.MatlabEngineEvaluator;
import hu.bme.mit.massif.examples.api.settings.GenericExampleSettings;
import hu.bme.mit.massif.examples.api.settings.MatlabControlExampleSettings;
import hu.bme.mit.massif.examples.api.settings.MatlabServerExampleSettings;
import hu.bme.mit.massif.simulink.SimulinkModel;
import hu.bme.mit.massif.simulink.api.Exporter;
import hu.bme.mit.massif.simulink.api.Importer;
import hu.bme.mit.massif.simulink.api.ModelObject;
import hu.bme.mit.massif.simulink.api.exception.SimulinkApiException;

import java.io.File;
import java.io.IOException;

import com.mathworks.engine.EngineException;

import br.com.embraer.massif.commandevaluation.client.MatlabClient;
import br.com.embraer.massif.commandevaluation.exception.MatlabRMIException;

public class MassifExampleHelper {
    
    public static void  exampleImport(ICommandEvaluator commandEvaluator) throws SimulinkApiException, IOException {

        MatlabCommandFactory commandFactory = new MatlabCommandFactory(commandEvaluator);

        // EMF model to read and export
        String modelPath = GenericExampleSettings.EMF_MODEL_PATH;
        String modelName = GenericExampleSettings.EMF_MODEL_NAME;

        Exporter exporter = new Exporter();
        SimulinkModel loadedModel = exporter.loadSimulinkModel(modelPath + modelName);
        
        exporter.export(loadedModel, commandFactory);
        String fqn = loadedModel.getSimulinkRef().getFQN();
        exporter.saveSimulinkModel(fqn,"slx");
        
    }
    
    public static void  exampleExport(ICommandEvaluator commandEvaluator) throws SimulinkApiException, IOException {
        
        MatlabCommandFactory factory = new MatlabCommandFactory(commandEvaluator);

        String modelPath = GenericExampleSettings.SIMULINK_MODEL_PATH;
        String modelName = GenericExampleSettings.SIMULINK_MODEL_NAME;

        System.out.println("Importing model: " + modelPath + modelName);

        MatlabCommand addModelPath = factory.addPath();
        addModelPath.addParam(modelPath);
        addModelPath.execute();

        // Model name to save the imported Simulink library
        String importedModelName = GenericExampleSettings.OUTPUT_DIRECTORY + File.separator + modelName;

        ModelObject model = new ModelObject(modelName, commandEvaluator);
        model.setLoadPath(modelPath);

        // Import each model using the FAM Leaf filter
        model.registerApplicableFilters("famfilter");

        Importer importer = new Importer(model);
        importer.traverseAndCreateEMFModel(GenericExampleSettings.IMPORT_MODE);
        importer.saveEMFModel(importedModelName);

        MatlabCommand closeSystem = factory.closeSystem();
        closeSystem.addParam(modelName);
        closeSystem.execute();
        
    }
    
    public static ICommandEvaluator createCommandEvaluator(MatlabConnector connector) throws MatlabRMIException, SimulinkApiException, EngineException, InterruptedException { 	
    	switch (connector) {
    	case COMMAND_EVALUATION_SERVER:
    		String hostAddress = MatlabServerExampleSettings.HOST_ADDRESS;
    		int hostPort = MatlabServerExampleSettings.HOST_PORT;
    		String serviceName = MatlabServerExampleSettings.SERVICE_NAME;    		
    		MatlabClient matlabClient = new MatlabClient(hostAddress, hostPort, serviceName);
    		return new CommandEvaluatorImpl(matlabClient);			    		
		case MATLAB_CONTROL:			
			return new MatlabControlEvaluator(MatlabControlExampleSettings.MATLAB_PATH, GenericExampleSettings.PRINT_ISSUED_COMMANDS);
		case MATLAB_ENGINE:
			return new MatlabEngineEvaluator(GenericExampleSettings.PRINT_ISSUED_COMMANDS);			
		default:
			throw new SimulinkApiException("Not supported connector was set: " + connector);
		}
    }
	
}