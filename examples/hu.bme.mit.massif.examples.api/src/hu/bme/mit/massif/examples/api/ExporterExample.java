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
package hu.bme.mit.massif.examples.api;

import hu.bme.mit.massif.communication.ICommandEvaluator;
import hu.bme.mit.massif.communication.command.MatlabCommandFactory;
import hu.bme.mit.massif.examples.api.common.MassifExampleHelper;
import hu.bme.mit.massif.examples.api.settings.ExporterExampleSettings;
import hu.bme.mit.massif.simulink.SimulinkModel;
import hu.bme.mit.massif.simulink.api.Exporter;
import hu.bme.mit.massif.simulink.api.exception.SimulinkApiException;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import br.com.embraer.massif.commandevaluation.exception.MatlabRMIException;

/**
 * This class demonstrates how to use the Simulink Importer from code via a
 * basic example.
 * 
 * Run it as a JUnit plug-in test.
 * 
 * @author Marton Bur
 *
 */
public class ExporterExample {

	private ICommandEvaluator commandEvaluator;

	@Before
	public void initializeCommandEvaluator() throws MatlabRMIException {
		commandEvaluator = MassifExampleHelper.createCommandEvaluator();
	}

	@Test
	public void exampleExport() throws SimulinkApiException, IOException {

		MatlabCommandFactory commandFactory = new MatlabCommandFactory(commandEvaluator);

		// EMF model to read and export
		String modelPath = ExporterExampleSettings.EMF_MODEL_PATH;
		String modelName = ExporterExampleSettings.EMF_MODEL_NAME;

		Exporter exporter = new Exporter();
		SimulinkModel loadedModel = exporter.loadSimulinkModel(modelPath + modelName);
		
		exporter.export(loadedModel, commandFactory);
		String fqn = loadedModel.getSimulinkRef().getFQN();
		exporter.saveSimulinkModel(fqn,"slx");
	}

}
