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

import hu.bme.mit.massif.communication.command.MatlabCommandFactory;
import hu.bme.mit.massif.communication.localscript.LocalScriptEvaluator;
import hu.bme.mit.massif.simulink.SimulinkModel;
import hu.bme.mit.massif.simulink.api.Exporter;
import hu.bme.mit.massif.simulink.api.exception.SimulinkApiException;

/**
 * This class provides functions to export and save Simulink models represented by EMF models
 */
public class CLIMatlabCreator {

    public void createMatlabModel(String modelName, String modelPath) throws SimulinkApiException {
        LocalScriptEvaluator evaluator = new LocalScriptEvaluator();
        
        Exporter exporter = new Exporter();
        SimulinkModel loadedModel;
        loadedModel = exporter.loadSimulinkModel(modelPath + modelName);
        MatlabCommandFactory commandFactory = new MatlabCommandFactory(evaluator);
        exporter.export(loadedModel, commandFactory);

    }
}
