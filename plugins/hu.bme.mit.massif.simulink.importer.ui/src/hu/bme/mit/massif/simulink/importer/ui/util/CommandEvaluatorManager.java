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
package hu.bme.mit.massif.simulink.importer.ui.util;

import hu.bme.mit.massif.communication.ICommandEvaluator;
import hu.bme.mit.massif.communication.commandevaluation.CommandEvaluatorImpl;
import hu.bme.mit.massif.simulink.importer.ui.Activator;

import java.util.Map;

import org.eclipse.core.runtime.Status;

import br.com.embraer.massif.commandevaluation.client.MatlabClient;
import br.com.embraer.massif.commandevaluation.exception.MatlabRMIException;

/**
 * This class is responsible for returning the appropriate object with the ICommandEvaluator interface for command
 * execution.
 */
public class CommandEvaluatorManager {

    /**
     * Enumeration for the different MATLAB client providers
     */
    public enum MatlabProvider {
        COMMAND_EVALUATION_SERVER, MATLABCONTROL
    }

    /**
     * A static function to get the appropriate command evaluator object.
     * 
     * @param provider the enum of the desired provider
     * @param parameters a map containing the required parameters for the connection to the MATLAB session
     * @return the object with the ICommandEvaluator interface
     */
    public static ICommandEvaluator getCommandEvaluator(MatlabProvider provider, Map<String, Object> parameters) {
        ICommandEvaluator result = null;
        switch (provider) {
        case COMMAND_EVALUATION_SERVER:
            // Get the required parameters from the parameter map and cast them to the right type
            String hostAddress = (String) parameters.get("hostAddress");
            int hostPort = (Integer) parameters.get("hostPort");
            String serviceName = (String) parameters.get("serviceName");
            try {
                MatlabClient matlabClient = new MatlabClient(hostAddress, hostPort, serviceName);
                result = new CommandEvaluatorImpl(matlabClient);
            } catch (MatlabRMIException e) {
                Status status = new Status(Status.ERROR, Activator.PLUGIN_ID,
                        "Exception occurred while preparing command evaluator!", e);
                Activator.getDefault().getLog().log(status);
            }
            break;

        case MATLABCONTROL:
            // TODO implement it for the matlabcontrol solution
            break;

        default:
            break;
        }

        return result;
    }

}
