/*******************************************************************************
 * Copyright (c) 2010-2013, Embraer S.A., Budapest University of Technology and Economics
 * All rights reserved. This program and the accompanying materials 
 * are made available under the terms of the Eclipse Public License v1.0 
 * which accompanies this distribution, and is available at 
 * http://www.eclipse.org/legal/epl-v10.html 
 *
 * Contributors: 
 *    Krisztian Gabor Mayer - initial API and implementation 
 *******************************************************************************/
package hu.bme.mit.massif.examples.api.matlabengine;

import hu.bme.mit.massif.simulink.api.util.ImportMode;

class MatlabEngineExampleSettings{

    /*
     * Example MatlabEngine based settings
     * TODO fill out the parameters before running the example 
     * Values provided here are supposed to serve as examples.
     */
    
     /*
      *  Generic Settings - Used by importer and exporter
      *   
      */ 
    // The path where the imported and exported models are saved
    public static String OUTPUT_DIRECTORY = "/folder/to/place/the/model/in/";
    // Set to true to make MATLAB print issued commands (CE Server configured in its corresponding properties file)
    public static boolean PRINT_ISSUED_COMMANDS = false;
    // The path to the MATLAB executable
    public static String MATLAB_PATH = "/usr/local/MATLAB/R2018a/bin/matlab";
    
    /*
     *  Importer Settings 
     *   
     */ 
    // The path to the Simulink model, end it with a filesystem separator (the file name is not part of this path)
    public static String SIMULINK_MODEL_PATH = "/folder/where/the/model/is/";
    // The name of the of the Simulink model (the .slx or .mdl file without file extension)
    public static String SIMULINK_MODEL_NAME = "sldemo_clutch_import";      
    // The traversal strategy of the importer
    public static ImportMode IMPORT_MODE = ImportMode.FLATTENING;
    
    /*
     *  Exporter Settings 
     *   
     */ 
    // The path to the EMF model, end it with a filesystem separator (the file name is not part of this path)
    public static String EMF_MODEL_PATH = "resources\\exporter\\";
    // The name of the of the EMF model (the .simulink file without file extension)
    public static String EMF_MODEL_NAME = "sldemo_engine_export";
    
}
