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

import hu.bme.mit.massif.communication.command.MatlabCommand;
import hu.bme.mit.massif.communication.command.MatlabCommandFactory;
import hu.bme.mit.massif.communication.datatype.Handle;
import hu.bme.mit.massif.communication.datatype.IVisitableMatlabData;
import hu.bme.mit.massif.communication.datatype.MatlabString;
import hu.bme.mit.massif.simulink.Block;
import hu.bme.mit.massif.simulink.InPortBlock;
import hu.bme.mit.massif.simulink.OutPort;
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

public class OutportAdapter implements IPortAdapter {

    @SuppressWarnings("unchecked")
    @Override
    public Port createPort(Importer importer, Block parent, IVisitableMatlabData currentPortHandle, Map<Double, ? extends Port> outPorts) {
        OutPort port = SimulinkFactory.eINSTANCE.createOutPort();
        parent.getPorts().add(port);
        ((Map<Double, OutPort>) outPorts).put(Handle.getHandleData(currentPortHandle), port);
        List<Parameter> portParams = ParameterHelper.collectParameters(importer, importer.getCommandFactory(), (Handle) currentPortHandle);
        port.getParameters().addAll(portParams);
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
