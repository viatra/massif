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

import hu.bme.mit.massif.communication.localscript.LocalScriptEvaluator;
import hu.bme.mit.massif.simulink.api.Importer;
import hu.bme.mit.massif.simulink.api.ModelObject;
import hu.bme.mit.massif.simulink.api.exception.SimulinkApiException;
import hu.bme.mit.massif.simulink.api.util.ImportMode;

/**
 * This class provides functions to import and save Simulink models to EMF models
 */
public class CLIEMFCreator {

    public void createSimulinkModel(String modelName, String outputDir, ImportMode importMode) throws SimulinkApiException {
        LocalScriptEvaluator localScriptEvaluator = new LocalScriptEvaluator();
        
        final ModelObject model = new ModelObject(modelName, localScriptEvaluator);
        model.setLoadPath(modelName);
        
        System.out.println("Importing model: " + modelName);

        // Model name to save the imported Simulink library
        String importedModelName = outputDir + File.separator + modelName;

        Importer importer = new Importer(model);
        importer.traverseAndCreateEMFModel(importMode);
        importer.saveEMFModel(importedModelName);
    }
    
    public void createSimulinkModel(String modelName, String outputDir) throws SimulinkApiException {
        createSimulinkModel(modelName, outputDir, ImportMode.FLATTENING);
    }
}
