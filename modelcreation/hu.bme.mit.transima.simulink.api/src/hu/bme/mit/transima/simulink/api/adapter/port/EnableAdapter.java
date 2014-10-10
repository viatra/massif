package hu.bme.mit.transima.simulink.api.adapter.port;

import hu.bme.mit.transima.Simulink.Block;
import hu.bme.mit.transima.Simulink.Enable;
import hu.bme.mit.transima.Simulink.EnableBlock;
import hu.bme.mit.transima.Simulink.EnableStates;
import hu.bme.mit.transima.Simulink.InPort;
import hu.bme.mit.transima.Simulink.InPortBlock;
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

public class EnableAdapter implements IPortAdapter {

    @SuppressWarnings("unchecked")
    @Override
    public Port createPort(Block parent, IVisitableMatlabData currentPortHandle, Map<Double, ? extends Port> inPorts) {
        InPort port = SimulinkFactory.eINSTANCE.createEnable();
        parent.getPorts().add(port);
        ((Map<Double, InPort>) inPorts).put(Handle.getHandleData(currentPortHandle), port);
        return port;
    }

    @Override
    public PortBlock connectToBlock(Port port, IVisitableMatlabData portHandle, Integer portNum,
            Set<InPortBlock> inPortBlockSet, Set<OutPortBlock> outPortBlockSet, Importer traverser) {
        // The type is known more specifically
        Enable enable = (Enable) port;
        MatlabCommandFactory commandFactory = traverser.getCommandFactory();
        // In the following Enable port specific setting is set
        // They should be set, even the internal blocks are not processed,
        // so that the corresponding EnablePort block is queried from MATLAB directly

        // Retrieve the name of the port's parent (the block to whom belongs the port)
        MatlabCommand getPortParentName = commandFactory.getParam().addParam(portHandle).addParam("Parent");
        IVisitableMatlabData portParentName = getPortParentName.execute();

        // Get the EnablePort block's handle - this should exist, while there was an enable port on
        // the parent
        MatlabCommand findEnablePortBlockHandle = commandFactory.findSystem().addParam(portParentName).addParam("SearchDepth").addParam(1.0)
                .addParam("LookUnderMasks").addParam("all").addParam("FindAll").addParam("on").addParam("BlockType")
                .addParam("EnablePort");
        IVisitableMatlabData enablePortBlockHandle = findEnablePortBlockHandle.execute();

        // Query states when enabling parameter
        MatlabCommand getStatesWhenEnabling = commandFactory.getParam().addParam(enablePortBlockHandle).addParam("StatesWhenEnabling");
        String statesWhenEnabling = MatlabString.getMatlabStringData(getStatesWhenEnabling.execute());
        enable.setStatesWhenEnabling(EnableStates.getByName(statesWhenEnabling.toUpperCase()));

        PortBlock portBlock = null;
        for (InPortBlock inPortBlock : (Set<InPortBlock>) inPortBlockSet) {
            if (inPortBlock instanceof EnableBlock) {
                portBlock = inPortBlock;
            }
        }

        return portBlock;

    }

}
