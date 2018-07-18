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

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;

import org.junit.Before;
import org.junit.Test;

import com.mathworks.engine.EngineException;
import com.mathworks.matlab.types.Struct;

import br.com.embraer.massif.commandevaluation.exception.MatlabRMIException;
import hu.bme.mit.massif.communication.ICommandEvaluator;
import hu.bme.mit.massif.communication.command.MatlabCommand;
import hu.bme.mit.massif.communication.command.MatlabCommandFactory;
import hu.bme.mit.massif.examples.api.common.MassifExampleHelper;
import hu.bme.mit.massif.examples.api.settings.ImporterExampleSettings;
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
		commandEvaluator = MassifExampleHelper.createCommandEvaluator();
	}

	@Test
	public void exampleImport() throws IOException, MatlabRMIException, SimulinkApiException {
		
//		FastClasspathScanner scanner = new FastClasspathScanner();
//		String uniqueClasspathElementsAsPathStr = scanner.getUniqueClasspathElementsAsPathStr();
//		System.out.println(uniqueClasspathElementsAsPathStr);
		
		MatlabCommandFactory factory = new MatlabCommandFactory(commandEvaluator);

		
		
		 
//		URLClassLoader oscl = (URLClassLoader) sun.misc.Launcher.getLauncher().getClassLoader();
//		try {
//			Method addURL = URLClassLoader.class.getDeclaredMethod("addURL", URL.class);
//			
////			URL jarUrl = new URL("file:///usr/local/MATLAB/R2018a/extern/engines/java/jar/engine.jar");
////			addURL.setAccessible(true);
////			addURL.invoke(oscl, jarUrl);
//			
//			oscl.loadClass(Struct.class.toString());
//		} catch (ClassNotFoundException | NoSuchMethodException | SecurityException | IllegalArgumentException e) {
//			e.printStackTrace();
//		}
////		URLClassLoader child = new URLClassLoader (myJar.toURL(), this.getClass().getClassLoader());

		String modelPath = ImporterExampleSettings.SIMULINK_MODEL_PATH;
		String modelName = ImporterExampleSettings.SIMULINK_MODEL_NAME;

		System.out.println("Importing model: " + modelPath + modelName);

		MatlabCommand addModelPath = factory.addPath();
		addModelPath.addParam(modelPath);
		addModelPath.execute();

		// Model name to save the imported Simulink library
		String importedModelName = ImporterExampleSettings.OUTPUT_DIRECTORY + File.separator + modelName;

		ModelObject model = new ModelObject(modelName, commandEvaluator);
		model.setLoadPath(modelPath);

		// Import each model using the FAM Leaf filter
		model.registerApplicableFilters("famfilter");

		Importer importer = new Importer(model);
		importer.traverseAndCreateEMFModel(ImporterExampleSettings.IMPORT_MODE);
		importer.saveEMFModel(importedModelName);

		MatlabCommand closeSystem = factory.closeSystem();
		closeSystem.addParam(modelName);
		closeSystem.execute();

	}
}
