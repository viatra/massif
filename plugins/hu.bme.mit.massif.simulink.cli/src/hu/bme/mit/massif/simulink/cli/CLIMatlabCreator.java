/*******************************************************************************
 * Copyright (c) 2010-2017, IncQueryLabs Ltd.
 * All rights reserved. This program and the accompanying materials 
 * are made available under the terms of the Eclipse Public License v1.0 
 * which accompanies this distribution, and is available at 
 * http://www.eclipse.org/legal/epl-v10.html 
 *
 * Contributors: 
 *     Peter Lunk - initial API and implementation 
 *******************************************************************************/
package hu.bme.mit.massif.simulink.cli;

import org.eclipse.viatra.query.runtime.exception.ViatraQueryException;

import br.com.embraer.massif.commandevaluation.commands.MatlabController;
import hu.bme.mit.massif.communication.command.MatlabCommandFactory;
import hu.bme.mit.massif.communication.localscript.LocalScriptEvaluator;
import hu.bme.mit.massif.simulink.SimulinkModel;
import hu.bme.mit.massif.simulink.api.Exporter;
import hu.bme.mit.massif.simulink.api.exception.SimulinkApiException;
import hu.bme.mit.massif.simulink.cli.util.CLIInitializationUtil;
import hu.bme.mit.massif.simulink.cli.util.CLISimulinkAPILogger;

/**
 * This class provides functions to export and save Simulink models represented by EMF models
 */
public class CLIMatlabCreator {

    public void createMatlabModel(String modelName, String modelPath) throws SimulinkApiException, ViatraQueryException {
        CLIInitializationUtil.setupEnvironment();
        CLISimulinkAPILogger logger = new CLISimulinkAPILogger();
        
        MatlabController controller = new MatlabController();
        controller.setDebug(true);
        LocalScriptEvaluator localScriptEvaluator = new LocalScriptEvaluator(controller);
        Exporter exporter = new Exporter(logger);
        SimulinkModel loadedModel;
        logger.debug("Loading Simulunk model...");
        loadedModel = exporter.loadSimulinkModel("file:/"+modelPath + modelName);
        logger.debug("Simulink model loaded");
        MatlabCommandFactory commandFactory = new MatlabCommandFactory(localScriptEvaluator);
        logger.debug("Loading model into MATLAB...");
        
        Thread thread = new Thread(new Runnable() {
            
            @Override
            public void run() {
                try {
                    exporter.export(loadedModel, commandFactory);
                    
                    String fqn = loadedModel.getSimulinkRef().getFQN();
                    exporter.saveSimulinkModel(fqn,"slx");
                } catch (SimulinkApiException e) {
                    e.printStackTrace();
                }
                
            }
        });
        
        thread.start();
        
        logger.debug("Model loaded into MATLAB");
    }
    
}
