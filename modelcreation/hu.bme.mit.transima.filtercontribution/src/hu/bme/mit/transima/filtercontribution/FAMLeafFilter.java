package hu.bme.mit.transima.filtercontribution;

import hu.bme.mit.transima.simulink.api.extension.ISimulinkImportFilter;
import hu.bme.mit.transima.simulink.communication.command.MatlabCommand;
import hu.bme.mit.transima.simulink.communication.command.MatlabCommandFactory;
import hu.bme.mit.transima.simulink.communication.datatype.MatlabString;

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
