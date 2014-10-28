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
package hu.bme.mit.massif.communication.commandevaluation;

import hu.bme.mit.massif.communication.ConnectorCreationException;
import hu.bme.mit.massif.communication.ICommandEvaluator;
import hu.bme.mit.massif.communication.ICommandEvaluatorFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import br.com.embraer.massif.commandevaluation.client.MatlabClient;
import br.com.embraer.massif.commandevaluation.client.util.MatlabProcessInformation;
import br.com.embraer.massif.commandevaluation.client.util.MatlabRunningManager;
import br.com.embraer.massif.commandevaluation.exception.MatlabRMIException;
import br.com.embraer.massif.commandevaluation.exception.MatlabRegistryException;
import br.com.embraer.massif.commandevaluation.util.MatlabProviderProperties;

/**
 * This class is responsible for returning the appropriate object with the ICommandEvaluator interface for command
 * execution.
 */
public class CEServerCommandEvaluatorFactory implements ICommandEvaluatorFactory {

    private static final String MATLAB_NOT_FOUND_WITH_GIVEN_PARAMETERS = "No running MATLAB server was found with the given parameters specified in Window/Preferences/Simulink Preferences";
    protected static final String MATLAB_RUNNING_CHECK_ERROR = "Exception occurred checking running Matlabs!";

	@Override
	public ICommandEvaluator createCommandEvaluator(
			Map<String, Object> parameters) throws ConnectorCreationException {
		ICommandEvaluator result = null;
		
		// Get the required parameters from the parameter map and cast them to the right type
		String hostAddress = (String) parameters.get("hostAddress");
		int hostPort = (Integer) parameters.get("hostPort");
		String serviceName = (String) parameters.get("serviceName");

		boolean existingSession = checkExistingMatlabSession(serviceName);

        if (!existingSession) {
            String errorMsg = MATLAB_NOT_FOUND_WITH_GIVEN_PARAMETERS;
            throw new ConnectorCreationException(errorMsg, null);
        }
        
        try {
            MatlabClient matlabClient = new MatlabClient(hostAddress, hostPort, serviceName);
            result = new CommandEvaluatorImpl(matlabClient);
        } catch (MatlabRMIException e) {
            throw new ConnectorCreationException("Exception occurred while preparing command evaluator!", e);
        }
        return result;
	}

    protected boolean checkExistingMatlabSession(String serviceName) throws ConnectorCreationException {
        List<MatlabProcessInformation> matlabs = new ArrayList<MatlabProcessInformation>();
        try {
            matlabs = MatlabRunningManager.getRunningMatlabs();
        } catch (MatlabRegistryException e) {
            throw new ConnectorCreationException(MATLAB_RUNNING_CHECK_ERROR, e);
        }
        for (MatlabProcessInformation matlabProcessInformation : matlabs) {
            if (serviceName.replace(MatlabProviderProperties.MATLAB_SERVER_DEFAULT_SERVICE_NAME, "").equalsIgnoreCase(
                    matlabProcessInformation.release + matlabProcessInformation.pid))
                return true;
        }
        return false;
    }

	
	@Override
	public String getConnectorName() {
		return "Command Evaluation Server";
	}

}
