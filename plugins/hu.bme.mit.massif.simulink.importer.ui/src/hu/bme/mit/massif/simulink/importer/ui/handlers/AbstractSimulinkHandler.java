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
package hu.bme.mit.massif.simulink.importer.ui.handlers;

import hu.bme.mit.massif.communication.ICommandEvaluator;
import hu.bme.mit.massif.communication.command.CustomCommand;
import hu.bme.mit.massif.communication.command.MatlabCommand;
import hu.bme.mit.massif.communication.command.MatlabCommandFactory;
import hu.bme.mit.massif.simulink.importer.ui.Activator;
import hu.bme.mit.massif.simulink.importer.ui.preferences.PreferenceConstants;
import hu.bme.mit.massif.simulink.importer.ui.util.CommandEvaluatorManager;
import hu.bme.mit.massif.simulink.importer.ui.util.CommandEvaluatorManager.MatlabProvider;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Display;

import br.com.embraer.massif.commandevaluation.client.util.MatlabProcessInformation;
import br.com.embraer.massif.commandevaluation.client.util.MatlabRunningManager;
import br.com.embraer.massif.commandevaluation.exception.MatlabRegistryException;
import br.com.embraer.massif.commandevaluation.util.MatlabProviderProperties;

public abstract class AbstractSimulinkHandler extends AbstractHandler {

    private static final String SEPARATOR_REGEXP = "\\|";
    private static final String MATLAB_SERVER_NOT_FOUND_MESSAGE_TITLE = "Matlab Server Not Found";
    private static final String MATLAB_NOT_FOUND_WITH_GIVEN_PARAMETERS = "No running MATLAB server was found with the given parameters specified in Window/Preferences/Simulink Preferences";
    protected static final String MATLAB_RUNNING_CHECK_ERROR = "Exception occurred checking running Matlabs!";

    public AbstractSimulinkHandler() {
        super();
    }

    protected String getPreferenceStringValue(String importTraverseMode, String defaultValue) {
        String traverseModeString = Platform.getPreferencesService().getString(Activator.PLUGIN_ID, importTraverseMode,
                defaultValue, null);
        return traverseModeString;
    }

    protected ICommandEvaluator prepareCommandEvaluator() {
    	String serviceName = getPreferenceStringValue(PreferenceConstants.SERVICE_NAME, "");
        String hostAddress = getPreferenceStringValue(PreferenceConstants.HOST_ADDRESS, "127.0.0.1");
        String hostPortString = getPreferenceStringValue(PreferenceConstants.HOST_PORT, "0");
        int hostPort = Integer.parseInt(hostPortString);
        // Adding the current path of the model to the MATLAB path so that it is able to find it
        Map<String, Object> evaluatorParameters = new HashMap<String, Object>();
        evaluatorParameters.put(PreferenceConstants.HOST_ADDRESS, hostAddress);
        evaluatorParameters.put(PreferenceConstants.HOST_PORT, hostPort);
        evaluatorParameters.put(PreferenceConstants.SERVICE_NAME, serviceName);

        MatlabProvider matlabConnector = getMatlabConnector();
    	ICommandEvaluator commandEvaluator = CommandEvaluatorManager.getCommandEvaluator(
    			matlabConnector, evaluatorParameters);
    	return commandEvaluator;
    }

	private MatlabProvider getMatlabConnector() {
		MatlabProvider connector = null;
        String connectorId = getPreferenceStringValue(PreferenceConstants.MATLAB_CONNECTOR, null);
        if(connectorId != null){
        	if(PreferenceConstants.COMMAND_EVALUATION_SERVER_ID.equals(connectorId)){
        		connector = MatlabProvider.COMMAND_EVALUATION_SERVER;
        		
        		// Reading MATLAB connection parameters from the preferences
                String serviceName = getPreferenceStringValue(PreferenceConstants.SERVICE_NAME, "");
                boolean existingSession = checkExistingMatlabSession(serviceName);

                if (!existingSession) {
                    String errorMsg = MATLAB_NOT_FOUND_WITH_GIVEN_PARAMETERS;
                    Status status = new Status(Status.ERROR, Activator.PLUGIN_ID, errorMsg);
                    Activator.getDefault().getLog().log(status);

                    Display.getDefault().syncExec(new Runnable() {

                        @Override
                        public void run() {
                            MessageDialog.openError(Display.getDefault().getActiveShell(),
                                    MATLAB_SERVER_NOT_FOUND_MESSAGE_TITLE, MATLAB_NOT_FOUND_WITH_GIVEN_PARAMETERS);
                        }
                    });

                }
        	} else if(PreferenceConstants.MATLAB_CONTROL_ID.equals(connectorId)) {
        		connector = MatlabProvider.MATLABCONTROL;
        	}
        }
		return connector;
	}

    protected boolean checkExistingMatlabSession(String serviceName) {
        List<MatlabProcessInformation> matlabs = new ArrayList<MatlabProcessInformation>();
        try {
            matlabs = MatlabRunningManager.getRunningMatlabs();
        } catch (MatlabRegistryException e) {
            Status status = new Status(Status.ERROR, Activator.PLUGIN_ID, MATLAB_RUNNING_CHECK_ERROR, e);
            Activator.getDefault().getLog().log(status);
        }
        for (MatlabProcessInformation matlabProcessInformation : matlabs) {
            if (serviceName.replace(MatlabProviderProperties.MATLAB_SERVER_DEFAULT_SERVICE_NAME, "").equalsIgnoreCase(
                    matlabProcessInformation.release + matlabProcessInformation.pid))
                return true;
        }
        return false;
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