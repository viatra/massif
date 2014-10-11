package hu.bme.mit.massif.simulink.api.adapter.block;

import hu.bme.mit.massif.communication.command.MatlabCommand;
import hu.bme.mit.massif.communication.command.MatlabCommandFactory;
import hu.bme.mit.massif.communication.datatype.CellMatlabData;
import hu.bme.mit.massif.communication.datatype.Handle;
import hu.bme.mit.massif.communication.datatype.IVisitableMatlabData;
import hu.bme.mit.massif.communication.datatype.StructMatlabData;
import hu.bme.mit.massif.simulink.Block;
import hu.bme.mit.massif.simulink.BusSelector;
import hu.bme.mit.massif.simulink.Property;
import hu.bme.mit.massif.simulink.SimulinkFactory;
import hu.bme.mit.massif.simulink.SimulinkReference;
import hu.bme.mit.massif.simulink.api.Importer;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.EList;

/**
 * Adapter class for the bus selector
 */
public class BusSelectorAdapter extends DefaultBlockAdapter {

    @Override
    public Block getBlock(Importer traverser) {
        return SimulinkFactory.eINSTANCE.createBusSelector();
    }

    @Override
    public void process(Importer traverser, SimulinkReference parentSimRef, Block blockToProcess) {
        super.process(traverser, parentSimRef, blockToProcess);

        // Cast block to the correct type
        BusSelector busSelector = (BusSelector) blockToProcess;

        // Cache the FQN for the block
        String busSelectorFQN = busSelector.getSimulinkRef().getFQN();
        // Cache the command evaluator instance
        MatlabCommandFactory commandFactory = traverser.getCommandFactory();
        // Cache bus selector mappings
        Map<BusSelector, List<Handle>> selectorToDestinationPorts = traverser.getBusSelectorToDestinationPorts();

        // Get relevant properties - don't have to be queried again from MATLAB, super.process() already obtained all
        // mask/dialog
        // parameters
        Property outputSignalsProperty = null;
        Property outputAsBusProperty = null;
        EList<Property> properties = busSelector.getProperties();
        for (Property property : properties) {
            if ("OutputAsBus".equalsIgnoreCase(property.getName())) {
                outputAsBusProperty = property;
            } else if ("OutputSignals".equalsIgnoreCase(property.getName())) {
                outputSignalsProperty = property;
            }
        }

        if ("on".equals(outputAsBusProperty.getValue())) {
            busSelector.setOutputAsBus(true);
        } else {
            busSelector.setOutputAsBus(false);
        }

        // Signal FQNs to trace back
        String[] outputSignals = outputSignalsProperty.getValue().split(",");

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