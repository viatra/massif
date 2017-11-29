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

import java.io.File;

import org.eclipse.viatra.query.runtime.exception.ViatraQueryException;

import br.com.embraer.massif.commandevaluation.commands.MatlabController;
import hu.bme.mit.massif.communication.localscript.LocalScriptEvaluator;
import hu.bme.mit.massif.simulink.api.Importer;
import hu.bme.mit.massif.simulink.api.ModelObject;
import hu.bme.mit.massif.simulink.api.exception.SimulinkApiException;
import hu.bme.mit.massif.simulink.api.util.ImportMode;
import hu.bme.mit.massif.simulink.cli.util.CLIInitializationUtil;
import hu.bme.mit.massif.simulink.cli.util.CLISimulinkAPILogger;

/**
 * This class provides functions to import and save Simulink models to EMF models
 */
public class CLIEMFCreator {

    public void createSimulinkModel(String modelName, String outputDir, ImportMode importMode) throws SimulinkApiException, ViatraQueryException {
        CLIInitializationUtil.setupEnvironment();
        CLISimulinkAPILogger logger = new CLISimulinkAPILogger();
        
        logger.debug("Creating controller..");
        MatlabController controller = new MatlabController();
        logger.debug("Controller created");
        logger.debug("Creating Local Script Evaluator");
        LocalScriptEvaluator localScriptEvaluator = new LocalScriptEvaluator(controller);
        logger.debug("Local Script Evaluator Created");
        final ModelObject model = new ModelObject(modelName, localScriptEvaluator);
        model.setLoadPath(modelName);
        logger.debug("Importing model: " + modelName);

        // Model name to save the imported Simulink library
        String importedModelName = outputDir + File.separator + modelName;

        Importer importer = new Importer(model, logger);
        
        Thread thread = new Thread(new Runnable() {
            
            @Override
            public void run() {
                try {
                    importer.traverseAndCreateEMFModel(importMode);
                    importer.saveEMFModel(importedModelName);
                } catch (SimulinkApiException e) {
                    e.printStackTrace();
                }
                
            }
        });
        
        thread.start();
        
    }
    
    public void createSimulinkModel(String modelName, String outputDir) throws SimulinkApiException, ViatraQueryException {
        createSimulinkModel(modelName, outputDir, ImportMode.FLATTENING);
    }
}
