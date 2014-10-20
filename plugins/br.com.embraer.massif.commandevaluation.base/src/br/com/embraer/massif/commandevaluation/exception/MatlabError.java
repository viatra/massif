/*******************************************************************************
 * Copyright (c) 2010-2013, Embraer S.A., Budapest University of Technology and Economics
 * All rights reserved. This program and the accompanying materials 
 * are made available under the terms of the Eclipse Public License v1.0 
 * which accompanies this distribution, and is available at 
 * http://www.eclipse.org/legal/epl-v10.html 
 *
 * Contributors: 
 *     Rodrigo Rizzi Starr, Lincoln Nascimento - initial API and implementation 
 *******************************************************************************/
package br.com.embraer.massif.commandevaluation.exception;

/**
 * Enumeration containing the errors (with code and description)
 * could be thrown throughout the code
 * 
 * @author ldnascim
 */
public enum MatlabError {
	
	SERVER_CONFIG_NOT_EXIST(0, "The given file matlabserverconfig.properties" +
			" does not exists"),
	INVALID_PROPERTY_CONTENT_ERROR(1, "Invalid property content in the config file"),
	READING_REGISTRY_ERROR(2, "Error on reading from windows registry the" +
			" current installed matlabs"),
	CONNECTING_RMI_ERROR(3, "Error on connecting RMI server with client"),
	EXECUTING_COMMAND_ON_MATLAB_ERROR(4, "Error on executing command in matlab"),
	INVOKING_COMMAND_ON_MATLAB_ERROR(5, "Error on invoking command in matlab server"),
	WAITING_NOTIFY_ERROR(6, "Error on waiting for commands to be executed"),
	RETRIEVE_JAR_LOCATION_ERROR(7, "Error on trying to get the jar location in order" +
			" to retrieve the properties file content"),
	READ_PROPERTIES_FILE_ERROR(8, "Error on trying to read the properties file"),
	CREATE_RMI_SERVER_ERROR(9, "Error on creating RMI server"),
	PROPERTY_NOT_EXIST_ERROR(10, "Error on reading property from properties file"),
	COMMAND_OUTPUT_NULL_ERROR(11, "Command output null");
	
	private final int code;
	private final String description;

	/**
	 * Constructor
	 * @param code Error identifier
	 * @param description Error description
	 */
	private MatlabError(int code, String description) {
		this.code = code;
		this.description = description;
	}

	/**
	 * Returns a textual description for the error
	 * @return description for the error
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Returns the error code 
	 * @return error code
	 */
	public int getCode() {
		return code;
	}
}