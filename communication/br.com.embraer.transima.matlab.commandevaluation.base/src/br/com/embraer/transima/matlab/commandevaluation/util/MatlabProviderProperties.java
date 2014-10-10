package br.com.embraer.transima.matlab.commandevaluation.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import br.com.embraer.transima.matlab.commandevaluation.exception.MatlabError;
import br.com.embraer.transima.matlab.commandevaluation.exception.MatlabPropertiesException;

public class MatlabProviderProperties {
	
	/** default value for server service name **/
	public static final String MATLAB_SERVER_DEFAULT_SERVICE_NAME = "MatlabModelProvider";
	
	/** matlab server properties key **/
	public static final String MATLAB_SERVER_ADDRESS = "serveraddress";
	public static final String MATLAB_SERVER_PORT = "serverport";
	public static final String MATLAB_SERVER_SERVICE_NAME = "serverservice";
    public static final String MATLAB_SERVER_DEBUG_MODE = "debug";
	
	/** matlab config properties file name */
	public static final String MATLAB_DEFAULT_CONFIG_FILE_NAME = "matlabserverconfig.properties";
	
	private Properties properties;
	
	/** path for configuration properties file */
	private String configPath;
	
	/**
	 * Default Constructor. Tries to load the properties file
	 * from default path
	 * @throws MatlabPropertiesException
	 */
	public MatlabProviderProperties() throws MatlabPropertiesException {
		loadPropertiesFile(MATLAB_DEFAULT_CONFIG_FILE_NAME);
	}
	
	/**
	 * Constructor. Tries to load the properties file from
	 * a given path
	 * @param configPath Config file path
	 * @throws MatlabPropertiesException
	 */
	public MatlabProviderProperties(String configPath) throws MatlabPropertiesException {
		loadPropertiesFile(configPath);
	}
	
	/**
	 * Load the properties file from a given path
	 * @param configPath
	 * @throws MatlabPropertiesException
	 */
	private void loadPropertiesFile(String configPath) throws MatlabPropertiesException {
		this.configPath = configPath;
		
		properties = new Properties();
        FileInputStream fileInputStream = null;
    	try {
    		//load a properties file
            fileInputStream = new FileInputStream(configPath);
            properties.load(fileInputStream);
    	} catch (IOException ex) {
    		MatlabPropertiesException exception =
					new MatlabPropertiesException(MatlabError.READ_PROPERTIES_FILE_ERROR, ex);
    		exception.set("File path", configPath);
			throw exception;
        } finally {
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    throw new IllegalStateException("Should never happen!");
                }
            }
        }
	}
	
	/**
	 * Gets a property from file using a key
	 * @param key Key
	 * @return Property value from the key, will return null
	 * 		   if not found
	 * @throws MatlabPropertiesException
	 */
	public String getProperty(String key) throws MatlabPropertiesException {
		String property = null;
		if (properties != null) {
			property = properties.getProperty(key);
		} else {
			MatlabPropertiesException exception =
					new MatlabPropertiesException(MatlabError.PROPERTY_NOT_EXIST_ERROR, null);
    		exception.set("File path", configPath);
    		exception.set("Property", key);
    		throw exception;
		}
		return property;
	}
	
	/**
	 * Returns the configuration file path
	 * @return configuration file path
	 */
	public String getConfigPath() {
		return this.configPath;
	}
}
