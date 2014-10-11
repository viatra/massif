package hu.bme.mit.massif.simulink.filters;

import hu.bme.mit.massif.communication.command.MatlabCommand;
import hu.bme.mit.massif.communication.command.MatlabCommandFactory;
import hu.bme.mit.massif.communication.datatype.Handle;
import hu.bme.mit.massif.simulink.Property;
import hu.bme.mit.massif.simulink.api.extension.ISimulinkImportFilter;
import hu.bme.mit.massif.simulink.api.util.BasicSimulinkEMFOperationsAPI;

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
