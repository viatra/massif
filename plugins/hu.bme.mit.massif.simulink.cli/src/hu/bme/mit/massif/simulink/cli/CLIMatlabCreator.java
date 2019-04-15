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
import hu.bme.mit.massif.communication.command.MatlabCommandFactory;
import hu.bme.mit.massif.communication.localscript.LocalScriptEvaluator;
import hu.bme.mit.massif.simulink.SimulinkModel;
import hu.bme.mit.massif.simulink.api.Exporter;
import hu.bme.mit.massif.simulink.api.exception.SimulinkApiException;
import hu.bme.mit.massif.simulink.api.layout.DummyExporterLayoutProvider;
import hu.bme.mit.massif.simulink.api.layout.IExporterLayoutProvider;
import hu.bme.mit.massif.simulink.cli.util.CLIInitializationUtil;
import hu.bme.mit.massif.simulink.cli.util.CLISimulinkAPILogger;

/**
 * This class provides functions to load Massif EMF models into MATLAB
 * 
 * @author Peter Lunk
 */
public class CLIMatlabCreator {
    
    private boolean debugMode = false;
    
    public void setDebugMode(boolean debugMode) {
        this.debugMode = debugMode;
    }

    public void createMatlabModel(String modelName, String modelPath) throws SimulinkApiException, ViatraQueryException {
        createMatlabModel(modelName, modelPath, "slx", new DummyExporterLayoutProvider());
    }
    
    public void createMatlabModel(String modelName, String modelPath, String extension) throws SimulinkApiException, ViatraQueryException {
        createMatlabModel(modelName, modelPath, extension, new DummyExporterLayoutProvider());
    }

    public void createMatlabModel(String modelName, String modelPath, String extension, IExporterLayoutProvider layoutProvider) throws SimulinkApiException, ViatraQueryException {
        CLIInitializationUtil.setupEnvironment();
        CLISimulinkAPILogger logger = new CLISimulinkAPILogger();
 
        MatlabController controller = new MatlabController();
        controller.setDebug(debugMode);
        LocalScriptEvaluator localScriptEvaluator = new LocalScriptEvaluator(controller);
        Exporter exporter = new Exporter(logger);
        exporter.setLayoutProvider(layoutProvider);
        SimulinkModel loadedModel;
        logger.debug("Loading Simulink model...");
        loadedModel = exporter.loadSimulinkModel(modelPath +File.separator+ modelName);
        logger.debug("Simulink model loaded");
        MatlabCommandFactory commandFactory = new MatlabCommandFactory(localScriptEvaluator);
        exporter.export(loadedModel, commandFactory);
        String fqn = loadedModel.getSimulinkRef().getFQN();
        exporter.saveSimulinkModel(fqn, extension);
    }

}
