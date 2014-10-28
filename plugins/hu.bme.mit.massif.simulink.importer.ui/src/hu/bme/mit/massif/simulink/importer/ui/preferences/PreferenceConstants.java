/*******************************************************************************
 * Copyright (c) 2010, 2014, Embraer S.A., Budapest University of Technology and Economics
 * All rights reserved. This program and the accompanying materials 
 * are made available under the terms of the Eclipse Public License v1.0 
 * which accompanies this distribution, and is available at 
 * http://www.eclipse.org/legal/epl-v10.html 
 *
 * Contributors: 
 *     Abel Hegedus - initial API and implementation 
 *******************************************************************************/
package hu.bme.mit.massif.simulink.importer.ui.preferences;

/**
 * Constant definitions for plug-in preferences
 */
public class PreferenceConstants {
	
	// Global
	public static final String PREFERRED_MATLAB_PID = "preferredMatlabPid";
	public static final String HOST_ADDRESS = "hostAddress";
	public static final String HOST_PORT = "hostPort";
	public static final String SERVICE_NAME = "serviceName";
	public static final String MATLAB_CONNECTOR = "matlab_connector";
	
	// Import
	public static final String IMPORT_TRAVERSE_MODE = "traverseMode";
	public static final String IMPORT_RESULT_MODEL_PATH = "importResultModelPath";
	public static final String IMPORT_ADDITIONAL_MATLAB_PATH = "importAdditionalMatlabPath";
	public static final String IMPORT_STARTUP_SCRIPTS = "importStartupScripts";
	public static final String IMPORT_FILTER = "importFilter";
	public static final String FAM_LEAF_FILTER = "famLeafFilter";
	public static final String LIBRARY_FILTER = "libraryFilter";
	

	// Export
	public static final String EXPORT_RESULT_MODEL_PATH = "exportResultModelPath";
	public static final String EXPORT_SCRIPT_NAMES = "exportScriptNames";
	public static final String EXPORT_ADDITIONAL_MATLAB_PATH = "exportAdditionalMatlabPath";
	public static final String MATLAB_CONTROL_ID = "massif.connectors.matlab.control";
	public static final String COMMAND_EVALUATION_SERVER_ID = "massif.connectors.command.evaluation.server";
	
}
