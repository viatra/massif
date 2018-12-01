/*******************************************************************************
 * Copyright (c) 2010-2013, Embraer S.A., Budapest University of Technology and Economics
 * All rights reserved. This program and the accompanying materials 
 * are made available under the terms of the Eclipse Public License v1.0 
 * which accompanies this distribution, and is available at 
 * http://www.eclipse.org/legal/epl-v10.html 
 *
 * Contributors: 
 *     Marton Bur, Abel Hegedus, Akos Horvath - initial API and implementation 
 *     Krisztian Gabor Mayer - additional features     
 *******************************************************************************/
package hu.bme.mit.massif.examples.api.matlabcontrol;

import java.io.File;
import java.io.IOException;
import org.junit.Before;
import org.junit.Test;

import com.mathworks.engine.EngineException;
import br.com.embraer.massif.commandevaluation.exception.MatlabRMIException;
import hu.bme.mit.massif.communication.ICommandEvaluator;
import hu.bme.mit.massif.communication.command.MatlabCommand;
import hu.bme.mit.massif.communication.command.MatlabCommandFactory;
import hu.bme.mit.massif.communication.matlabcontrol.MatlabControlEvaluator;
import hu.bme.mit.massif.simulink.api.Importer;
import hu.bme.mit.massif.simulink.api.ModelObject;
import hu.bme.mit.massif.simulink.api.exception.SimulinkApiException;

/**
 * This class demonstrates how to use the Simulink Importer from code via a
 * basic example.
 * 
 * Run it as a JUnit plug-in test.
 * 
 * @author Marton Bur
 *
 */
public class ImporterExample {
	private ICommandEvaluator commandEvaluator;

	@Before
	public void initializeCommandEvaluator() throws MatlabRMIException, EngineException, SimulinkApiException, InterruptedException {
	    commandEvaluator = new MatlabControlEvaluator(MatlabControlExampleSettings.MATLAB_PATH, MatlabControlExampleSettings.PRINT_ISSUED_COMMANDS);
	}

	@Test
	public void exampleImport() throws IOException, MatlabRMIException, SimulinkApiException {
		
		MatlabCommandFactory factory = new MatlabCommandFactory(commandEvaluator);

		String modelPath = MatlabControlExampleSettings.SIMULINK_MODEL_PATH;
		String modelName = MatlabControlExampleSettings.SIMULINK_MODEL_NAME;

		System.out.println("Importing model: " + modelPath + modelName);

		MatlabCommand addModelPath = factory.addPath();
		addModelPath.addParam(modelPath);
		addModelPath.execute();

		// Model name to save the imported Simulink library
		String importedModelName = MatlabControlExampleSettings.OUTPUT_DIRECTORY + File.separator + modelName;

		ModelObject model = new ModelObject(modelName, commandEvaluator);
		model.setLoadPath(modelPath);

		// Import each model using the FAM Leaf filter
		model.registerApplicableFilters("famfilter");

		Importer importer = new Importer(model);
		importer.traverseAndCreateEMFModel(MatlabControlExampleSettings.IMPORT_MODE);
		importer.saveEMFModel(importedModelName);

		MatlabCommand closeSystem = factory.closeSystem();
		closeSystem.addParam(modelName);
		closeSystem.execute();

	}
}
