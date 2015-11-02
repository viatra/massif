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
package hu.bme.mit.massif.simulink.importer.ui.handlers;

import hu.bme.mit.massif.communication.ConnectorCreationException;
import hu.bme.mit.massif.communication.ICommandEvaluator;
import hu.bme.mit.massif.communication.command.CustomCommand;
import hu.bme.mit.massif.communication.command.MatlabCommand;
import hu.bme.mit.massif.communication.command.MatlabCommandFactory;
import hu.bme.mit.massif.communication.manager.CommandEvaluatorManager;
import hu.bme.mit.massif.simulink.importer.ui.MassifSimulinkUIPlugin;
import hu.bme.mit.massif.simulink.importer.ui.preferences.PreferenceConstants;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Display;

public abstract class AbstractSimulinkHandler extends AbstractHandler {

    private static final String SEPARATOR_REGEXP = "\\|";
    
    public AbstractSimulinkHandler() {
        super();
    }

    protected String getPreferenceStringValue(String preferenceId, String defaultValue) {
        String preferenceValue = Platform.getPreferencesService().getString(MassifSimulinkUIPlugin.PLUGIN_ID, preferenceId,
                defaultValue, null);
        return preferenceValue;
    }

    protected ICommandEvaluator prepareCommandEvaluator() {
    	String serviceName = getPreferenceStringValue(PreferenceConstants.SERVICE_NAME, "");
        String hostAddress = getPreferenceStringValue(PreferenceConstants.HOST_ADDRESS, "127.0.0.1");
        String hostPortString = getPreferenceStringValue(PreferenceConstants.HOST_PORT, "0");
        int hostPort = Integer.parseInt(hostPortString);
        String matlabPath = getPreferenceStringValue(PreferenceConstants.MATLAB_PATH, "");
        
        // Adding the current path of the model to the MATLAB path so that it is able to find it
        Map<String, Object> evaluatorParameters = new HashMap<String, Object>();
        evaluatorParameters.put(PreferenceConstants.HOST_ADDRESS, hostAddress);
        evaluatorParameters.put(PreferenceConstants.HOST_PORT, hostPort);
        evaluatorParameters.put(PreferenceConstants.SERVICE_NAME, serviceName);
        evaluatorParameters.put(PreferenceConstants.MATLAB_PATH, matlabPath);

        String matlabConnectorId = getMatlabConnector();
    	ICommandEvaluator commandEvaluator = null;
		try {
			commandEvaluator = CommandEvaluatorManager.INSTANCE.getCommandEvaluator(
					matlabConnectorId, evaluatorParameters);
		} catch (ConnectorCreationException e) {
			final String errorMsg = e.getLocalizedMessage();
            Status status = new Status(Status.ERROR, MassifSimulinkUIPlugin.PLUGIN_ID, "Exception occured when creating Massif Matlab connector", e);
            MassifSimulinkUIPlugin.getDefault().getLog().log(status);

            Display.getDefault().syncExec(new Runnable() {
                @Override
                public void run() {
                    MessageDialog.openError(Display.getDefault().getActiveShell(),
                            "Exception occured when creating Massif Matlab connector", errorMsg);
                }
            });
		}
    	return commandEvaluator;
    }

	private String getMatlabConnector() {
        String connectorId = getPreferenceStringValue(PreferenceConstants.MATLAB_CONNECTOR, null);
        if(connectorId == null){
        	final String errorMsg = "No connector selected in preferences";
            Status status = new Status(Status.ERROR, MassifSimulinkUIPlugin.PLUGIN_ID, errorMsg);
            MassifSimulinkUIPlugin.getDefault().getLog().log(status);

            Display.getDefault().syncExec(new Runnable() {
                @Override
                public void run() {
                    MessageDialog.openError(Display.getDefault().getActiveShell(),
                            "Exception occured when choosing Massif Matlab connector", errorMsg);
                }
            });
        }
		return connectorId;
	}


    protected ICommandEvaluator getCommandEvaluator() {
    	ICommandEvaluator commandEvaluator = prepareCommandEvaluator();
        return commandEvaluator;
    }

    protected void setup(ICommandEvaluator evaluator, String path, String scripts) {
        String[] pathArray = getPreferenceStringValue(path, "").split(SEPARATOR_REGEXP);
        String[] scriptArray = getPreferenceStringValue(scripts, "").split(SEPARATOR_REGEXP);
        if(pathArray.length > 1 || pathArray[0].length() > 0){
        	MatlabCommandFactory factory = new MatlabCommandFactory(evaluator);
            for (String s : pathArray) {
                MatlabCommand addpath = factory.addPath();
                addpath.addParam(s);
                addpath.execute();
            }
        }
        if (pathArray.length > 1 || scriptArray[0].length() > 0) {
            for (String s : scriptArray) {
                CustomCommand script = new CustomCommand(evaluator);
                script.setCommandName(s);
                script.execute();
            }
        }
    }

}