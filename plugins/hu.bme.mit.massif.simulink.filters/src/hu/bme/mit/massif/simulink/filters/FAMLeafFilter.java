package hu.bme.mit.massif.simulink.filters;

import hu.bme.mit.massif.communication.command.MatlabCommand;
import hu.bme.mit.massif.communication.command.MatlabCommandFactory;
import hu.bme.mit.massif.communication.datatype.MatlabString;
import hu.bme.mit.massif.simulink.api.extension.ISimulinkImportFilter;

/**
 * This class is a subsystem filter extension for the importer. Only the non-leaf FAM elements are not filtered.
 */
public class FAMLeafFilter implements ISimulinkImportFilter {

    @Override
    public boolean filter(MatlabCommandFactory commandFactory, String blockFQN) {

    	MatlabCommand getTagValue = commandFactory.getParam().addParam(blockFQN).addParam("Tag");
        String tagValue = MatlabString.getMatlabStringData(getTagValue.execute());

        return tagValue.startsWith("FAM_Leaf");
    }

}
