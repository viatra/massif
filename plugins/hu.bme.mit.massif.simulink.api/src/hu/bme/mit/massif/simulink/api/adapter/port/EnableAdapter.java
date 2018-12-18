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
import java.util.Set;

import hu.bme.mit.massif.communication.command.MatlabCommand;
import hu.bme.mit.massif.communication.command.MatlabCommandFactory;
import hu.bme.mit.massif.communication.datatype.Handle;
import hu.bme.mit.massif.communication.datatype.IVisitableMatlabData;
import hu.bme.mit.massif.communication.datatype.MatlabString;
import hu.bme.mit.massif.simulink.Block;
import hu.bme.mit.massif.simulink.Enable;
import hu.bme.mit.massif.simulink.EnableBlock;
import hu.bme.mit.massif.simulink.EnableStates;
import hu.bme.mit.massif.simulink.InPortBlock;
import hu.bme.mit.massif.simulink.Parameter;
import hu.bme.mit.massif.simulink.Port;
import hu.bme.mit.massif.simulink.PortBlock;
import hu.bme.mit.massif.simulink.SimulinkFactory;
import hu.bme.mit.massif.simulink.api.adapter.ParameterHelper;
import hu.bme.mit.massif.simulink.api.dto.PortDTO;

public class EnableAdapter implements IPortAdapter {

    @SuppressWarnings("unchecked")
    @Override
    public Port createPort(PortDTO dto, Block parent) {
        Enable port = SimulinkFactory.eINSTANCE.createEnable();
        parent.getPorts().add(port);
        dto.getInPorts().put(Handle.getHandleData(dto.getHandle()), port);
        List<Parameter> portParams = ParameterHelper.collectParameters(dto);
        port.getParameters().addAll(portParams);
        return port;
    }

    @Override
    public PortBlock connectToBlock(PortDTO dto, Port port, Integer portNum) {
        // The type is known more specifically
        Enable enable = (Enable) port;
        MatlabCommandFactory commandFactory = dto.getCommandFactory();
        // In the following Enable port specific setting is set
        // They should be set, even the internal blocks are not processed,
        // so that the corresponding EnablePort block is queried from MATLAB directly

        // Retrieve the name of the port's parent (the block to whom belongs the port)
        MatlabCommand getPortParentName = commandFactory.getParam().addParam(dto.getHandle()).addParam("Parent");
        IVisitableMatlabData portParentName = getPortParentName.execute();

        // Get the EnablePort block's handle - this should exist, while there was an enable port on
        // the parent
        MatlabCommand findEnablePortBlockHandle = commandFactory.findSystem().addParam(portParentName)
                .addParam("IncludeCommented").addParam("on").addParam("SearchDepth").addParam(1.0)
                .addParam("LookUnderMasks").addParam("all").addParam("FindAll").addParam("on").addParam("BlockType")
                .addParam("EnablePort");
        IVisitableMatlabData enablePortBlockHandle = findEnablePortBlockHandle.execute();

        // Query states when enabling parameter
        MatlabCommand getStatesWhenEnabling = commandFactory.getParam().addParam(enablePortBlockHandle).addParam("StatesWhenEnabling");
        String statesWhenEnabling = MatlabString.getMatlabStringData(getStatesWhenEnabling.execute());
        enable.setStatesWhenEnabling(EnableStates.getByName(statesWhenEnabling.toUpperCase()));

        PortBlock portBlock = null;
        for (InPortBlock inPortBlock : (Set<InPortBlock>) dto.getInPortBlockSet()) {
            if (inPortBlock instanceof EnableBlock) {
                portBlock = inPortBlock;
            }
        }

        return portBlock;

    }

}
