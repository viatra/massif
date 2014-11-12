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


public class ExporterExampleSettings {	

	/*
	 * Exporter example settings
	 * TODO fill out the parameters before running the export example
	 */	
	// The address of the machine where MatlabServer runs
	public static String HOST_ADDRESS = "127.0.0.1";
	// The port where MatlabServer listens
	public static int HOST_PORT = 1098;
	// The registered service name
	public static String SERVICE_NAME = "MatlabModelProviderr2012a1772";
	// The path to the Simulink model, end it with a filesystem separator (the file name is not part of this path)
	public static String EMF_MODEL_PATH = "resources\\exporter\\";
	// The name of the of the Simulink model (the .slx or .mdl file without file extension)
	public static String EMF_MODEL_NAME = "sldemo_engine_export";
	// The traversal strategy of the importer
	// public static String OUTPUT_DIRECTORY = "c:\\" + File.separator + "output";

}
