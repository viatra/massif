/*******************************************************************************
 * Copyright (c) 2010-2013, Embraer S.A., Budapest University of Technology and Economics
 * All rights reserved. This program and the accompanying materials 
 * are made available under the terms of the Eclipse Public License v1.0 
 * which accompanies this distribution, and is available at 
 * http://www.eclipse.org/legal/epl-v10.html 
 *
 * Contributors: 
 *     Marton Bur, Abel Hegedus, Akos Horvath - initial API and implementation
 *     Krisztian Gabor Mayer - additional features  
 *******************************************************************************/
package hu.bme.mit.massif.simulink.api.adapter.port;

import java.util.List;

import hu.bme.mit.massif.communication.command.MatlabCommand;
import hu.bme.mit.massif.communication.command.MatlabCommandFactory;
import hu.bme.mit.massif.communication.datatype.Handle;
import hu.bme.mit.massif.communication.datatype.IVisitableMatlabData;
import hu.bme.mit.massif.communication.datatype.MatlabString;
import hu.bme.mit.massif.simulink.Block;
import hu.bme.mit.massif.simulink.EnableStates;
import hu.bme.mit.massif.simulink.InPort;
import hu.bme.mit.massif.simulink.InPortBlock;
import hu.bme.mit.massif.simulink.Parameter;
import hu.bme.mit.massif.simulink.Port;
import hu.bme.mit.massif.simulink.PortBlock;
import hu.bme.mit.massif.simulink.SimulinkFactory;
import hu.bme.mit.massif.simulink.Trigger;
import hu.bme.mit.massif.simulink.TriggerBlock;
import hu.bme.mit.massif.simulink.TriggerType;
import hu.bme.mit.massif.simulink.api.adapter.ParameterHelper;
import hu.bme.mit.massif.simulink.api.data.PortData;

public class TriggerAdapter implements IPortAdapter {

    @SuppressWarnings("unchecked")
    @Override
    public Port createPort(PortData dto, Block parent) {
        InPort port = SimulinkFactory.eINSTANCE.createTrigger();
        parent.getPorts().add(port);
        dto.getInPorts().put(Handle.getHandleData(dto.getHandle()), port);
        List<Parameter> portParams = ParameterHelper.collectParameters(dto);
        port.getParameters().addAll(portParams);
        return port;
    }

    @Override
    public PortBlock connectToBlock(PortData dto, Port port, Integer portNum) {
        // The type is known more specifically
        Trigger trigger = (Trigger) port;
        MatlabCommandFactory commandFactory = dto.getCommandFactory();

        // In the following Enable port specific setting is set
        // They should be set, even the internal blocks are not processed,
        // so that the corresponding EnablePort block is queried from MATLAB directly

        // Retrieve the name of the port's parent (the block to whom belongs the port)
        MatlabCommand getPortParentName = commandFactory.getParam().addParam(dto.getHandle()).addParam("Parent");
        String portParentName = MatlabString.getMatlabStringData(getPortParentName.execute());

        // Get the TiggerPort block's handle - this sould exist, while there was an enable port on
        // the parent
        MatlabCommand findTriggerPortBlockHandle = commandFactory.findSystem().addParam(portParentName)
                .addParam("IncludeCommented").addParam("on").addParam("SearchDepth").addParam(1.0)
                .addParam("LookUnderMasks").addParam("all").addParam("FindAll").addParam("on").addParam("BlockType")
                .addParam("TriggerPort");
        IVisitableMatlabData triggerPortBlockHandle = findTriggerPortBlockHandle.execute();

        // Query states when enabling parameter
        MatlabCommand getStatesWhenEnabling = commandFactory.getParam().addParam(triggerPortBlockHandle).addParam("StatesWhenEnabling");
        String statesWhenEnabling = MatlabString.getMatlabStringData(getStatesWhenEnabling.execute());
        trigger.setStatesWhenEnabling(EnableStates.getByName(statesWhenEnabling.toUpperCase()));

        // Query trigger type from the trigger block
        MatlabCommand getTriggerType = commandFactory.getParam().addParam(triggerPortBlockHandle).addParam("TriggerType");
        String triggerType = MatlabString.getMatlabStringData(getTriggerType.execute());
        trigger.setTriggerType(TriggerType.getByName(triggerType.toUpperCase()));

        PortBlock portBlock = null;
        for (InPortBlock inPortBlock : dto.getInPortBlockSet()) {
            if (inPortBlock instanceof TriggerBlock) {
                portBlock = inPortBlock;
            }
        }
        return portBlock;
    }

}
