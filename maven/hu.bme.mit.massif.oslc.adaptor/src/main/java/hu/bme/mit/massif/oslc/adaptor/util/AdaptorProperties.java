/*******************************************************************************
 * Copyright (c) 2010-2013, Embraer S.A., Budapest University of Technology and Economics
 * All rights reserved. This program and the accompanying materials 
 * are made available under the terms of the Eclipse Public License v1.0 
 * which accompanies this distribution, and is available at 
 * http://www.eclipse.org/legal/epl-v10.html 
 *
 * Contributors: 
 *     Robert Doczi, Akos Horvath - initial API and implementation 
 *******************************************************************************/
package hu.bme.mit.massif.oslc.adaptor.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Level;

/**
 * This class helps retrieve information from the configuration properties file.
 * @author Dóczi Róbert
 *
 */
public class AdaptorProperties {

    private static final String CONFIG_FOLDER =  "SimulinkAdaptorConfig";
    private static final String CONFIG_NAME =  "client.properties";
    private static final String LOG_NAME =  "log.txt";
    
    private static final String MATLAB_SERVER_IP_KEY = "server.address";
    private static final String MATLAB_SERVICE_NAME_KEY = "service.name";
    private static final String MATLAB_SERVICE_PORT_KEY = "service.port";
    private static final String LOG_LEVEL_KEY = "log.level";
    
    public static String logLocation = "";
    public static Level logLevel;
    
    /**
     * The address where the matlab server is located.
     */
    public static String matlabServerIp = "";
    
    /**
     * The port of the matlab server.
     */
    public static int matlabServicePort = 0;
    
    /**
     * The name of the matlab server service.
     */
    public static String matlabServiceName = "";    
    
    static {
        String userDir = System.getProperty("user.home");
        String configLocation = userDir + File.separator + CONFIG_FOLDER + File.separator + CONFIG_NAME;
        logLocation = userDir + File.separator + CONFIG_FOLDER + File.separator + LOG_NAME;
        try {          
            FileInputStream propertiesFile = new FileInputStream(new File(configLocation));
            Properties prop = new Properties();
            prop.load(propertiesFile);
            
            matlabServerIp = (String) prop.get(MATLAB_SERVER_IP_KEY);
            matlabServiceName = (String) prop.get(MATLAB_SERVICE_NAME_KEY);
            matlabServicePort = Integer.parseInt((String) prop.get(MATLAB_SERVICE_PORT_KEY));
            logLevel = Level.toLevel((String) prop.get(LOG_LEVEL_KEY));
            
        } catch (IOException e) {
        }
    }    
}
