/*******************************************************************************
 * Copyright (c) 2010-2013, Embraer S.A., Budapest University of Technology and Economics
 * All rights reserved. This program and the accompanying materials 
 * are made available under the terms of the Eclipse Public License v1.0 
 * which accompanies this distribution, and is available at 
 * http://www.eclipse.org/legal/epl-v10.html 
 *
 * Contributors: 
 *     Marton Bur, Abel Hegedus, Akos Horvath - initial API and implementation 
 *******************************************************************************/
package hu.bme.mit.massif.simulink.api.adapter.port;

import hu.bme.mit.massif.communication.datatype.Handle;
import hu.bme.mit.massif.communication.datatype.IVisitableMatlabData;
import hu.bme.mit.massif.simulink.Block;
import hu.bme.mit.massif.simulink.InPortBlock;
import hu.bme.mit.massif.simulink.OutPortBlock;
import hu.bme.mit.massif.simulink.Parameter;
import hu.bme.mit.massif.simulink.Port;
import hu.bme.mit.massif.simulink.PortBlock;
import hu.bme.mit.massif.simulink.SimulinkFactory;
import hu.bme.mit.massif.simulink.api.Importer;
import hu.bme.mit.massif.simulink.api.adapter.ParameterHelper;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class DefaultPortAdapter implements IPortAdapter {

    @Override
    public Port createPort(Importer importer, Block parent, IVisitableMatlabData currentPortHandle, Map<Double, ? extends Port> inPorts) {
        // Default to inport
        // Reason: the outport types are assumed to be explicitly checked when calling 
        // IPortAdapter#createPort from Importer#createAndAddPort method
        Port port = SimulinkFactory.eINSTANCE.createInPort();
        List<Parameter> portParams = ParameterHelper.collectParameters(importer, importer.getCommandFactory(), (Handle) currentPortHandle);
        port.getParameters().addAll(portParams);
        return port;
    }

    @Override
    public PortBlock connectToBlock(Port port, IVisitableMatlabData portHandle, Integer portNum,
            Set<InPortBlock> portBlockSet, Set<OutPortBlock> outPortBlockSet, Importer importerApi) {
        // By default, a port is not assigned a port block
        return null;
    }
}
