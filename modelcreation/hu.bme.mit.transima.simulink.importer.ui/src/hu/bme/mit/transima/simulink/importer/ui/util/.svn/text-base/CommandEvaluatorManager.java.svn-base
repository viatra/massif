package hu.bme.mit.transima.simulink.importer.ui.util;

import hu.bme.mit.transima.commandevaluatorcontribution.Activator;
import hu.bme.mit.transima.commandevaluatorcontribution.CommandEvaluatorImpl;
import hu.bme.mit.transima.simulink.api.util.ICommandEvaluator;

import java.util.Map;

import org.eclipse.core.runtime.Status;

import br.com.embraer.transima.matlab.commandevaluation.client.MatlabClient;
import br.com.embraer.transima.matlab.commandevaluation.exception.MatlabRMIException;

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
