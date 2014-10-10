package hu.bme.mit.transima.simulink.api.adapter.port;

import hu.bme.mit.transima.Simulink.Block;
import hu.bme.mit.transima.Simulink.InPortBlock;
import hu.bme.mit.transima.Simulink.OutPort;
import hu.bme.mit.transima.Simulink.OutPortBlock;
import hu.bme.mit.transima.Simulink.Port;
import hu.bme.mit.transima.Simulink.PortBlock;
import hu.bme.mit.transima.Simulink.SimulinkFactory;
import hu.bme.mit.transima.simulink.api.Importer;
import hu.bme.mit.transima.simulink.communication.command.MatlabCommand;
import hu.bme.mit.transima.simulink.communication.command.MatlabCommandFactory;
import hu.bme.mit.transima.simulink.communication.datatype.Handle;
import hu.bme.mit.transima.simulink.communication.datatype.IVisitableMatlabData;
import hu.bme.mit.transima.simulink.communication.datatype.MatlabString;

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
