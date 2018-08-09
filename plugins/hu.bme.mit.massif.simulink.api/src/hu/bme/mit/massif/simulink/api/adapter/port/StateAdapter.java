/*******************************************************************************
 * Copyright (c) 2010-2018, IncQuery Labs Ltd., logi.cals GmbH, McGill University
 * All rights reserved. This program and the accompanying materials 
 * are made available under the terms of the Eclipse Public License v1.0 
 * which accompanies this distribution, and is available at 
 * http://www.eclipse.org/legal/epl-v10.html 
 *
 * Contributors: 
 *     Marton Bur - initial API and implementation 
 *******************************************************************************/
package hu.bme.mit.massif.simulink.api.adapter.port;

import java.util.Map;
import java.util.Set;

import hu.bme.mit.massif.communication.datatype.Handle;
import hu.bme.mit.massif.communication.datatype.IVisitableMatlabData;
import hu.bme.mit.massif.simulink.Block;
import hu.bme.mit.massif.simulink.InPortBlock;
import hu.bme.mit.massif.simulink.OutPort;
import hu.bme.mit.massif.simulink.OutPortBlock;
import hu.bme.mit.massif.simulink.Port;
import hu.bme.mit.massif.simulink.PortBlock;
import hu.bme.mit.massif.simulink.SimulinkFactory;
import hu.bme.mit.massif.simulink.State;
import hu.bme.mit.massif.simulink.api.Importer;

public class StateAdapter implements IPortAdapter {

    @SuppressWarnings("unchecked")
    @Override
    public Port createPort(Block parent, IVisitableMatlabData currentPortHandle, Map<Double, ? extends Port> outPorts) {
        State port = SimulinkFactory.eINSTANCE.createState();
        parent.getPorts().add(port);
        ((Map<Double, OutPort>) outPorts).put(Handle.getHandleData(currentPortHandle), port);
        return port;
    }

    @Override
    public PortBlock connectToBlock(Port port, IVisitableMatlabData portHandle, Integer portNum,
            Set<InPortBlock> portBlockSet, Set<OutPortBlock> outPortBlockSet, Importer importerApi) {
        // A state port never has a corresponding state port block
        return null;
    }

}
