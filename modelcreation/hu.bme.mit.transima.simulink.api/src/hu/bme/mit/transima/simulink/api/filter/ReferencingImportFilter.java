package hu.bme.mit.transima.simulink.api.filter;

import hu.bme.mit.transima.simulink.api.extension.ISimulinkImportFilter;
import hu.bme.mit.transima.simulink.communication.command.MatlabCommand;
import hu.bme.mit.transima.simulink.communication.command.MatlabCommandFactory;
import hu.bme.mit.transima.simulink.communication.datatype.MatlabString;

public class ReferencingImportFilter implements ISimulinkImportFilter {

    @Override
    public boolean filter(MatlabCommandFactory commandFactory , String blockFQN) {
        MatlabCommand getLinkStatus = commandFactory.getParam().addParam(blockFQN).addParam("LinkStatus");
        String linkStatus = MatlabString.getMatlabStringData(getLinkStatus.execute());
        return "resolved".equals(linkStatus) || "implicit".equals(linkStatus);
    }

}
