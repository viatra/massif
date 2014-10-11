package hu.bme.mit.massif.simulink.api.adapter.port;

import hu.bme.mit.massif.communication.command.MatlabCommand;
import hu.bme.mit.massif.communication.command.MatlabCommandFactory;
import hu.bme.mit.massif.communication.datatype.Handle;
import hu.bme.mit.massif.communication.datatype.IVisitableMatlabData;
import hu.bme.mit.massif.communication.datatype.MatlabString;
import hu.bme.mit.massif.simulink.Block;
import hu.bme.mit.massif.simulink.InPortBlock;
import hu.bme.mit.massif.simulink.OutPort;
import hu.bme.mit.massif.simulink.OutPortBlock;
import hu.bme.mit.massif.simulink.Port;
import hu.bme.mit.massif.simulink.PortBlock;
import hu.bme.mit.massif.simulink.SimulinkFactory;
import hu.bme.mit.massif.simulink.api.Importer;

import java.util.Map;
import java.util.Set;

public class OutportAdapter implements IPortAdapter {

    @SuppressWarnings("unchecked")
    @Override
    public Port createPort(Block parent, IVisitableMatlabData currentPortHandle, Map<Double, ? extends Port> outPorts) {
        OutPort port = SimulinkFactory.eINSTANCE.createOutPort();
        parent.getPorts().add(port);
        ((Map<Double, OutPort>) outPorts).put(Handle.getHandleData(currentPortHandle), port);
        return port;
    }

    @Override
    public PortBlock connectToBlock(Port port, IVisitableMatlabData portHandle, Integer portNum,
            Set<InPortBlock> inPortBlockSet, Set<OutPortBlock> outPortBlockSet, Importer traverser) {

        MatlabCommandFactory commandFactory = traverser.getCommandFactory();
        OutPortBlock portBlock = null;
        for (OutPortBlock outPortBlock : (Set<OutPortBlock>) outPortBlockSet) {
            if (portNum == getPortBlockPortCount(outPortBlock, commandFactory))
                portBlock = outPortBlock;
        }
        return portBlock;
    }

    private int getPortBlockPortCount(PortBlock portBlock, MatlabCommandFactory commandFactory) {
		MatlabCommand getPortCount = commandFactory.getParam().addParam(portBlock.getSimulinkRef().getFQN()).addParam("Port");
		return Integer.parseInt(MatlabString.getMatlabStringData(getPortCount.execute()));
	}

}
