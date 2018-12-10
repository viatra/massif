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

import org.eclipse.viatra.query.runtime.api.ViatraQueryEngineOptions;
import org.eclipse.viatra.query.runtime.localsearch.matcher.integration.LocalSearchEMFBackendFactory;
import org.eclipse.viatra.query.runtime.rete.matcher.ReteBackendFactory;

import br.com.embraer.massif.commandevaluation.commands.MatlabController;
import hu.bme.mit.massif.communication.ICommandEvaluator;
import hu.bme.mit.massif.simulink.api.Importer;
import hu.bme.mit.massif.simulink.api.ModelObject;
import hu.bme.mit.massif.simulink.api.exception.SimulinkApiException;
import hu.bme.mit.massif.simulink.api.util.ImportMode;
import hu.bme.mit.massif.simulink.cli.util.CLIInitializationUtil;
import hu.bme.mit.massif.simulink.cli.util.CLISimulinkAPILogger;

/**
 * This class provides functions to create and save Massif .simulink models based on Simulink models loaded into MATLAB.
 * 
 * @author Peter Lunk
 */
public abstract class CLIEMFCreator {

    public abstract ICommandEvaluator getEvaluator();

    protected boolean debugMode = false;

    public CLIEMFCreator() {
        ViatraQueryEngineOptions.setSystemDefaultBackends(ReteBackendFactory.INSTANCE, ReteBackendFactory.INSTANCE,
                LocalSearchEMFBackendFactory.INSTANCE);
    }

    public void setDebugMode(boolean debugMode) {
        this.debugMode = debugMode;
    }

    public void createSimulinkModel(String modelName, String outputDir, ImportMode importMode)
            throws SimulinkApiException, InterruptedException {

        CLIInitializationUtil.setupEnvironment();
        CLISimulinkAPILogger logger = new CLISimulinkAPILogger();

        logger.debug("Creating controller..");
        MatlabController controller = new MatlabController();
        controller.setDebug(debugMode);
        logger.debug("Controller created");
        logger.debug("Creating Evaluator");
        ICommandEvaluator evaluator = getEvaluator();
        logger.debug("Evaluator Created");
        final ModelObject model = new ModelObject(modelName, evaluator);
        model.setLoadPath(modelName);
        logger.debug("Importing model: " + modelName);

        // Model name to save the imported Simulink library
        String importedModelPath = outputDir + File.separator + modelName;

        Importer importer = new Importer(model, logger);

        Thread thread = new Thread(new Runnable() {

            @Override
            public void run() {
                try {
                    importer.traverseAndCreateEMFModel(importMode);
                    importer.saveEMFModel(importedModelPath);
                } catch (SimulinkApiException e) {
                    e.printStackTrace();
                }

            }
        });

        thread.start();

    }

    public void createSimulinkModel(String modelName, String outputDir) throws SimulinkApiException, InterruptedException {
        createSimulinkModel(modelName, outputDir, ImportMode.FLATTENING);
    }
}
