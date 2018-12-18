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
package hu.bme.mit.massif.examples.api.settings;

public class MatlabServerExampleSettings {
    
     /*
      *  TODO The example is set to use the default HOST_ADDRESS and the HOST_PORT of the Command Evaluation Server,
      *  however you always have to set the SERVICE_NAME which is returned by MATLAB after starting up the 
      *  Command Evaluation Server with setup_remote.m script. 
      *   
      */ 
    
    // The address of the machine where MatlabServer runs
    public static String HOST_ADDRESS = "127.0.0.1";
    // The port where MatlabServer listens
    public static int HOST_PORT = 1098;
    // The registered service name, should be edited according to what MatlabControl returns from MATLAB
    public static String SERVICE_NAME = "MatlabModelProviderr2018b6328";// "MatlabModelProviderr2012a1772";
    
}
