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
package hu.bme.mit.massif.simulink.api.adapter.block;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.EList;

import hu.bme.mit.massif.communication.command.MatlabCommand;
import hu.bme.mit.massif.communication.command.MatlabCommandFactory;
import hu.bme.mit.massif.communication.datatype.CellMatlabData;
import hu.bme.mit.massif.communication.datatype.Handle;
import hu.bme.mit.massif.communication.datatype.IVisitableMatlabData;
import hu.bme.mit.massif.communication.datatype.StructMatlabData;
import hu.bme.mit.massif.simulink.Block;
import hu.bme.mit.massif.simulink.BusSelector;
import hu.bme.mit.massif.simulink.Parameter;
import hu.bme.mit.massif.simulink.SimulinkFactory;
import hu.bme.mit.massif.simulink.api.data.BlockData;
import hu.bme.mit.massif.simulink.api.util.ImportMode;

/**
 * Adapter class for the bus selector
 */
public class BusSelectorAdapter extends DefaultBlockAdapter {

    @Override
    public Block getBlock(ImportMode importMode) {
        return SimulinkFactory.eINSTANCE.createBusSelector();
    }

    @Override
    public void process(BlockData dto) {
        super.process(dto);

        // Cast block to the correct type
        BusSelector busSelector = (BusSelector) dto.getBlockToProcess();

        // Cache the FQN for the block
        String busSelectorFQN = busSelector.getSimulinkRef().getFQN();
        // Cache the command evaluator instance
        MatlabCommandFactory commandFactory = dto.getCommandFactory();
        // Cache bus selector mappings
        Map<BusSelector, List<Handle>> selectorToDestinationPorts = dto.getBusSelectorToDestinationPorts();

        // Get relevant properties - don't have to be queried again from MATLAB, super.process() already obtained all
        // mask/dialog
        // parameters
        Parameter outputSignalsProperty = null;
        Parameter outputAsBusProperty = null;
        EList<Parameter> parameters = busSelector.getParameters();
        for (Parameter parameter : parameters) {
            if ("OutputAsBus".equalsIgnoreCase(parameter.getName())) {
                outputAsBusProperty = parameter;
            } else if ("OutputSignals".equalsIgnoreCase(parameter.getName())) {
                outputSignalsProperty = parameter;
            }
        }

        if (outputAsBusProperty != null && "on".equals(outputAsBusProperty.getValue())) {
            busSelector.setOutputAsBus(true);
        } else {
            busSelector.setOutputAsBus(false);
        }

        String signals = "";
        if(outputSignalsProperty != null) {
            signals = outputSignalsProperty.getValue();
        }
        // Signal FQNs to trace back
        String[] outputSignals = signals.split(",");

        MatlabCommand getPortHandles = commandFactory.getParam().addParam(busSelectorFQN).addParam("PortHandles");
        IVisitableMatlabData portHandles = getPortHandles.execute();
        
        List<IVisitableMatlabData> outportHandles = CellMatlabData.getCellMatlabDataData(StructMatlabData.asStructMatlabData(portHandles).getData("Outport"));
        List<Handle> outportHandleList = new LinkedList<Handle>();
        List<Handle> outgoingLineHandleList = new LinkedList<Handle>();
        for (int i = 0; i < outputSignals.length; i++) {
            if (busSelector.isOutputAsBus()) {
                Handle outportHandle = Handle.asHandle(outportHandles.get(0));

                // Get the outgoing line handle
                MatlabCommand getOutgoingLineHandle = commandFactory.getParam().addParam(outportHandle).addParam("Line");
                Handle outgoingLineHandle = Handle.asHandle(getOutgoingLineHandle.execute());

                // Fill the array with the same handle
                for (int j = 0; j < outputSignals.length; j++) {
                    outportHandleList.add(outportHandle);
                    outgoingLineHandleList.add(outgoingLineHandle);
                }
                break;
            } else {
                Handle outportHandle = Handle.asHandle(outportHandles.get(i));

                // Get the outgoing line handle
                MatlabCommand getOutgoingLineHandle = commandFactory.getParam().addParam(outportHandle).addParam("Line");
                Handle outgoingLineHandle = Handle.asHandle(getOutgoingLineHandle.execute());
                
                outportHandleList.add(outportHandle);
                outgoingLineHandleList.add(outgoingLineHandle);
            }
        }
        selectorToDestinationPorts.put(busSelector, outportHandleList);

    }

}