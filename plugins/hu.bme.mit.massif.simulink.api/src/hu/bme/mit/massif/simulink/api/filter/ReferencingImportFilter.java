package hu.bme.mit.massif.simulink.api.filter;

import hu.bme.mit.massif.communication.command.MatlabCommand;
import hu.bme.mit.massif.communication.command.MatlabCommandFactory;
import hu.bme.mit.massif.communication.datatype.MatlabString;
import hu.bme.mit.massif.simulink.api.extension.ISimulinkImportFilter;

public class ReferencingImportFilter implements ISimulinkImportFilter {

    @Override
    public boolean filter(MatlabCommandFactory commandFactory , String blockFQN) {
        MatlabCommand getLinkStatus = commandFactory.getParam().addParam(blockFQN).addParam("LinkStatus");
        String linkStatus = MatlabString.getMatlabStringData(getLinkStatus.execute());
        return "resolved".equals(linkStatus) || "implicit".equals(linkStatus);
    }

}
