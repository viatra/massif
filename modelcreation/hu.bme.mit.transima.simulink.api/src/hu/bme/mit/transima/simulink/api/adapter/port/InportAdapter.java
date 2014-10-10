package hu.bme.mit.transima.simulink.api.adapter.port;

import hu.bme.mit.transima.Simulink.Block;
import hu.bme.mit.transima.Simulink.EnableBlock;
import hu.bme.mit.transima.Simulink.InPort;
import hu.bme.mit.transima.Simulink.InPortBlock;
import hu.bme.mit.transima.Simulink.OutPortBlock;
import hu.bme.mit.transima.Simulink.Port;
import hu.bme.mit.transima.Simulink.PortBlock;
import hu.bme.mit.transima.Simulink.SimulinkFactory;
import hu.bme.mit.transima.Simulink.TriggerBlock;
import hu.bme.mit.transima.simulink.api.Importer;
import hu.bme.mit.transima.simulink.api.exception.SimulinkApiException;
import hu.bme.mit.transima.simulink.communication.command.MatlabCommand;
import hu.bme.mit.transima.simulink.communication.command.MatlabCommandFactory;
import hu.bme.mit.transima.simulink.communication.datatype.Handle;
import hu.bme.mit.transima.simulink.communication.datatype.IVisitableMatlabData;
import hu.bme.mit.transima.simulink.communication.datatype.MatlabString;

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
