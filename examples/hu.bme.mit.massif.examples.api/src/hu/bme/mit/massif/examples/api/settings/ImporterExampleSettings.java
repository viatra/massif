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
package hu.bme.mit.massif.examples.api.settings;

import hu.bme.mit.massif.simulink.api.util.ImportMode;

import java.io.File;

public class ImporterExampleSettings {
	
	/*
	 * Importer example settings
	 * TODO fill out the parameters before running the import example
	 */
	// The address of the machine where MatlabServer runs
	public static String HOST_ADDRESS = "127.0.0.1";
	// The port where MatlabServer listens
	public static int HOST_PORT = 1098;
	// The registered service name
	public static String SERVICE_NAME = "MatlabModelProviderr2012a1772";
	// The path to the Simulink model, end it with a filesystem separator (the file name is not part of this path)
	public static String SIMULINK_MODEL_PATH = "resources\\importer\\";
	// The name of the of the Simulink model (the .slx or .mdl file without file extension)
	public static String SIMULINK_MODEL_NAME = "sldemo_clutch_import";
	// The traversal strategy of the importer
	public static ImportMode IMPORT_MODE = ImportMode.FLATTENING;
	// The path where the imported models are saved
	public static String OUTPUT_DIRECTORY = /*e.g.:*/ "c:\\" + File.separator + "output";

}
