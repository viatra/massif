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
import hu.bme.mit.massif.communication.datatype.MatlabString;
import hu.bme.mit.massif.simulink.Block;
import hu.bme.mit.massif.simulink.EnableBlock;
import hu.bme.mit.massif.simulink.InPort;
import hu.bme.mit.massif.simulink.InPortBlock;
import hu.bme.mit.massif.simulink.Parameter;
import hu.bme.mit.massif.simulink.Port;
import hu.bme.mit.massif.simulink.PortBlock;
import hu.bme.mit.massif.simulink.SimulinkFactory;
import hu.bme.mit.massif.simulink.TriggerBlock;
import hu.bme.mit.massif.simulink.api.adapter.ParameterHelper;
import hu.bme.mit.massif.simulink.api.data.PortData;
import hu.bme.mit.massif.simulink.api.exception.SimulinkApiException;

public class InportAdapter implements IPortAdapter {

    @SuppressWarnings("unchecked")
    @Override
    public Port createPort(PortData dto, Block parent) {
        InPort port = SimulinkFactory.eINSTANCE.createInPort();
        parent.getPorts().add(port);
        dto.getInPorts().put(Handle.getHandleData(dto.getHandle()), port);
        List<Parameter> portParams = ParameterHelper.collectParameters(dto);
        port.getParameters().addAll(portParams);
        return port;
    }

    @Override
    public PortBlock connectToBlock(PortData dto, Port port, Integer portNum) {
        MatlabCommandFactory commandFactory = dto.getCommandFactory();
        InPortBlock portBlock = null;
        for (InPortBlock inPortBlock : dto.getInPortBlockSet()) {
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
     * TODO might cause indexing errors in case of extra block types
     * 
     * @param portBlock
     * @return
     * @throws SimulinkApiException
     */
    private int getPortBlockPortCount(PortBlock portBlock, MatlabCommandFactory commandFactory) {
    	if(portBlock instanceof TriggerBlock){
    		// Trigger is the last in the list
    		return portBlock.getParent().getPorts().size();
    	}
    	else if(portBlock instanceof EnableBlock ){
    		// Calculate the position
    		// Enable is the port before the Trigger, if exists, otherwise the last
    		if(portBlock.getParent().getTrigger() != null){
    			return portBlock.getParent().getPorts().size() - 1;
    		}
    		return portBlock.getParent().getPorts().size();
    	} else {
	        MatlabCommand getPortCount = commandFactory.getParam().addParam(portBlock.getSimulinkRef().getFQN()).addParam("Port");
	        return Integer.parseInt(MatlabString.getMatlabStringData(getPortCount.execute()));
    	}
    }

}
