package hu.bme.mit.transima.filtercontribution;

import hu.bme.mit.transima.Simulink.Property;
//import hu.bme.mit.transima.filtercontribution.internal.Activator;
//import hu.bme.mit.transima.simulink.api.exception.SimulinkApiException;
import hu.bme.mit.transima.simulink.api.extension.ISimulinkImportFilter;
import hu.bme.mit.transima.simulink.api.util.BasicSimulinkEMFOperationsAPI;
import hu.bme.mit.transima.simulink.communication.command.MatlabCommand;
import hu.bme.mit.transima.simulink.communication.command.MatlabCommandFactory;
import hu.bme.mit.transima.simulink.communication.datatype.Handle;

import java.util.List;

/**
 * An example filter class. It filters blocks with mask parameter named "Filter".
 */
public class FilterImpl implements ISimulinkImportFilter {

    @Override
    public boolean filter(MatlabCommandFactory commandFactory, String blockFQN) {
    	MatlabCommand getHandle = commandFactory.getParam().addParam(blockFQN).addParam("Handle");
        Handle blockHandle = Handle.asHandle(getHandle.execute());

        List<Property> parameters = BasicSimulinkEMFOperationsAPI.getMaskParameters(commandFactory, blockHandle);
        for (Property prop : parameters) {
            // The parameter name to filter can be set here
            if (prop.getName().equals("Filter"))
                return true;
        }

        return false;
    }

}
