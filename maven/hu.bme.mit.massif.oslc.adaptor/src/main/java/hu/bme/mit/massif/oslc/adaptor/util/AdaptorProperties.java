package hu.bme.mit.massif.oslc.adaptor.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Level;

public class AdaptorProperties {

    private static final String CONFIG_FOLDER =  "SimulinkAdaptorConfig";
    private static final String CONFIG_NAME =  "client.properties";
    private static final String LOG_NAME =  "log.txt";
    
    private static final String MATLAB_SERVICE_NAME_KEY = "service.name";
    private static final String MATLAB_SERVICE_PORT_KEY = "service.port";
    private static final String LOG_LEVEL_KEY = "log.level";
    
    public static String logLocation = "";
    public static Level logLevel;
    
    public static String matlabServiceName = "";
    public static int matlabServicePort = 0;
    
    static {
        String userDir = System.getProperty("user.home");
        String configLocation = userDir + File.separator + CONFIG_FOLDER + File.separator + CONFIG_NAME;
        logLocation = userDir + File.separator + CONFIG_FOLDER + File.separator + LOG_NAME;
        try {          
            FileInputStream propertiesFile = new FileInputStream(new File(configLocation));
            Properties prop = new Properties();
            prop.load(propertiesFile);
            
            matlabServiceName = (String) prop.get(MATLAB_SERVICE_NAME_KEY);
            matlabServicePort = Integer.parseInt((String) prop.get(MATLAB_SERVICE_PORT_KEY));
            logLevel = Level.toLevel((String) prop.get(LOG_LEVEL_KEY));
            
        } catch (IOException e) {
        }
    }    
}
