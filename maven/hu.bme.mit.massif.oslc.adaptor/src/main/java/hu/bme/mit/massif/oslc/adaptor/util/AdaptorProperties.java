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
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Properties;
import java.util.stream.Stream;

import org.apache.log4j.Level;

/**
 * This class helps retrieve information from the configuration properties file.
 * 
 * @author Dóczi Róbert
 *
 */
public class AdaptorProperties {

    private static final String CONFIG_FOLDER = ".massif";
    private static final String CONFIG_NAME = "olscClient.properties";
    private static final String LOG_NAME = "log.txt";

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

        File configDir = new File(userDir + File.separator + CONFIG_FOLDER);
        if (!configDir.exists())
            configDir.mkdir();

        File configFile = null;

        for (File f : configDir.listFiles()) {
            if (f.getName().equalsIgnoreCase(CONFIG_NAME)) {
                configFile = f;
                break;
            }
        }
        
        if(configFile == null) {
            configFile = new File(userDir + File.separator + CONFIG_FOLDER + File.separator + CONFIG_NAME);
            try {
                configFile.createNewFile();
                
                FileOutputStream fileOS = new FileOutputStream(configFile);
                Properties prop = new Properties();
                
                prop.setProperty(MATLAB_SERVER_IP_KEY, "127.0.0.1");
                prop.setProperty(MATLAB_SERVICE_PORT_KEY, "");
                prop.setProperty(MATLAB_SERVICE_NAME_KEY, "");
                
                prop.setProperty(LOG_LEVEL_KEY, "WARN");
                
                prop.store(fileOS, "This is a generated configuration file for the Simulink OSLC adapter. Please fill in the missing information.");
                
                
            } catch (IOException e) {
            }
        }

        logLocation = userDir + File.separator + CONFIG_FOLDER + File.separator + LOG_NAME;
        try {
            FileInputStream propertiesFile = new FileInputStream(configFile);
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
