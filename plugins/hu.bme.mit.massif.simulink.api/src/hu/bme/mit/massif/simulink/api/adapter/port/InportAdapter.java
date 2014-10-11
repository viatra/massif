package hu.bme.mit.massif.simulink.api.adapter.port;

import hu.bme.mit.massif.communication.command.MatlabCommand;
import hu.bme.mit.massif.communication.command.MatlabCommandFactory;
import hu.bme.mit.massif.communication.datatype.Handle;
import hu.bme.mit.massif.communication.datatype.IVisitableMatlabData;
import hu.bme.mit.massif.communication.datatype.MatlabString;
import hu.bme.mit.massif.simulink.Block;
import hu.bme.mit.massif.simulink.EnableBlock;
import hu.bme.mit.massif.simulink.InPort;
import hu.bme.mit.massif.simulink.InPortBlock;
import hu.bme.mit.massif.simulink.OutPortBlock;
import hu.bme.mit.massif.simulink.Port;
import hu.bme.mit.massif.simulink.PortBlock;
import hu.bme.mit.massif.simulink.SimulinkFactory;
import hu.bme.mit.massif.simulink.TriggerBlock;
import hu.bme.mit.massif.simulink.api.Importer;
import hu.bme.mit.massif.simulink.api.exception.SimulinkApiException;

import java.util.Map;
import java.util.Set;

public class InportAdapter implements IPortAdapter {

    @SuppressWarnings("unchecked")
    @Override
    public Port createPort(Block parent, IVisitableMatlabData currentPortHandle, Map<Double, ? extends Port> inPorts) {
        InPort port = SimulinkFactory.eINSTANCE.createInPort();
        parent.getPorts().add(port);
        ((Map<Double, InPort>) inPorts).put(Handle.getHandleData(currentPortHandle), port);
        return port;
    }

    @Override
    public PortBlock connectToBlock(Port port, IVisitableMatlabData portHandle, Integer portNum,
            Set<InPortBlock> inPortBlockSet, Set<OutPortBlock> outPortBlockSet, Importer traverser) {
        MatlabCommandFactory commandFactory = traverser.getCommandFactory();
        InPortBlock portBlock = null;
        for (InPortBlock inPortBlock : inPortBlockSet) {
            boolean triggerOrEnableBlock = (inPortBlock instanceof TriggerBlock)
                    || (inPortBlock instanceof EnableBlock);
            boolean samePortNumber = portNum == getPortBlockPortCount(inPortBlock, commandFactory);
            if (!triggerOrEnableBlock && samePortNumber)
                portBlock = inPortBlock;
        }
        return portBlock;
    }

    /**
     * Extracted function for better code readability
     * 
     * @param portBlock
     * @return
     * @throws SimulinkApiException
     */
    private int getPortBlockPortCount(PortBlock portBlock, MatlabCommandFactory commandFactory) {
        MatlabCommand getPortCount = commandFactory.getParam().addParam(portBlock.getSimulinkRef().getFQN()).addParam("Port");
        return Integer.parseInt(MatlabString.getMatlabStringData(getPortCount.execute()));
    }

}
