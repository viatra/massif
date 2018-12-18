/*******************************************************************************
 * Copyright (c) 2010-2018, IncQuery Labs Ltd., logi.cals GmbH, McGill University
 * All rights reserved. This program and the accompanying materials 
 * are made available under the terms of the Eclipse Public License v1.0 
 * which accompanies this distribution, and is available at 
 * http://www.eclipse.org/legal/epl-v10.html 
 *
 * Contributors: 
 *     Marton Bur - initial API and implementation 
 *     Krisztian Gabor Mayer - additional features        
 *******************************************************************************/
package hu.bme.mit.massif.simulink.api.adapter.port;

import java.util.List;

import hu.bme.mit.massif.communication.datatype.Handle;
import hu.bme.mit.massif.simulink.Block;
import hu.bme.mit.massif.simulink.Parameter;
import hu.bme.mit.massif.simulink.Port;
import hu.bme.mit.massif.simulink.PortBlock;
import hu.bme.mit.massif.simulink.SimulinkFactory;
import hu.bme.mit.massif.simulink.State;
import hu.bme.mit.massif.simulink.api.adapter.ParameterHelper;
import hu.bme.mit.massif.simulink.api.dto.PortDTO;

public class StateAdapter implements IPortAdapter {

    @SuppressWarnings("unchecked")
    @Override
    public Port createPort(PortDTO dto, Block parent) {
        State port = SimulinkFactory.eINSTANCE.createState();
        parent.getPorts().add(port);
        dto.getOutPorts().put(Handle.getHandleData(dto.getHandle()), port);
        List<Parameter> portParams = ParameterHelper.collectParameters(dto);
        port.getParameters().addAll(portParams);
        return port;
    }

    @Override
    public PortBlock connectToBlock(PortDTO dto, Port port, Integer portNum) {
        // A state port never has a corresponding state port block
        return null;
    }

}
