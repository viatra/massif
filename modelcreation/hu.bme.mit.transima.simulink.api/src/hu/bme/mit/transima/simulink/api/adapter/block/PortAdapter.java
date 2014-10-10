package hu.bme.mit.transima.simulink.api.adapter.block;

import hu.bme.mit.transima.Simulink.Block;
import hu.bme.mit.transima.Simulink.PortBlock;
import hu.bme.mit.transima.Simulink.Property;
import hu.bme.mit.transima.Simulink.PropertySource;
import hu.bme.mit.transima.Simulink.SimulinkFactory;
import hu.bme.mit.transima.Simulink.SimulinkReference;
import hu.bme.mit.transima.simulink.api.Importer;
import hu.bme.mit.transima.simulink.communication.command.MatlabCommand;
import hu.bme.mit.transima.simulink.communication.command.MatlabCommandFactory;
import hu.bme.mit.transima.simulink.communication.datatype.BusSignal;
import hu.bme.mit.transima.simulink.communication.datatype.CellMatlabData;
import hu.bme.mit.transima.simulink.communication.datatype.Handle;
import hu.bme.mit.transima.simulink.communication.datatype.IVisitableMatlabData;
import hu.bme.mit.transima.simulink.communication.datatype.MatlabString;

import java.util.List;

/**
 * Generic adapter class for the port block
 */
public abstract class PortAdapter extends DefaultAdapter {

    @Override
    public abstract Block getBlock(Importer traverser);

    @Override
    public void process(Importer traverser, SimulinkReference parentSimRef, Block blockToProcess) {
        super.process(traverser, parentSimRef, blockToProcess);

        PortBlock portBlock = (PortBlock) blockToProcess;
        String portBlockName = portBlock.getSimulinkRef().getFQN();
        MatlabCommandFactory commandFactory = traverser.getCommandFactory();
        
        // Get DataType and SampleTime properties
        MatlabCommand getDataTypeString = commandFactory.getParam().addParam(portBlockName).addParam("OutDataTypeStr");
        String dataTypeString = MatlabString.getMatlabStringData(getDataTypeString.execute());

        if (dataTypeString.indexOf("Bus") == 0) {

        	MatlabCommand getBusObjectName = commandFactory.getParam().addParam(blockToProcess.getSimulinkRef().getFQN()).addParam("BusObject");
            String busObjectName = MatlabString.getMatlabStringData(getBusObjectName.execute());

            BusSignal busSignal = processBusObject(busObjectName,commandFactory);

            // The busObjectStructCell stores the raw and busSignal the processed BusObject
            // TODO write model modification code here
            Property busObject = SimulinkFactory.eINSTANCE.createProperty();
            busObject.setName("BusObject");
            busObject.setSource(PropertySource.DIALOG);
            busObject.setValue(busSignal.toString());
            portBlock.getProperties().add(busObject);
            // for now, only log it
            traverser.getLogger().debug(String.format("BusObject in %s was processed to %s", portBlockName, busSignal));
        }

        MatlabCommand getSampleTimeString = commandFactory.getParam().addParam(portBlockName).addParam("SampleTime");
        String sampleTimeString = MatlabString.getMatlabStringData(getSampleTimeString.execute());

        // Create the corresponding properties
        Property dataType = SimulinkFactory.eINSTANCE.createProperty();
        dataType.setName("DataType");
        dataType.setValue(dataTypeString);

        Property sampleTime = SimulinkFactory.eINSTANCE.createProperty();
        sampleTime.setName("SampleTime");
        sampleTime.setValue(sampleTimeString);

        portBlock.getProperties().add(dataType);
        portBlock.getProperties().add(sampleTime);

    }

    private BusSignal processBusObject(String workspaceVariableName, MatlabCommandFactory commandFactory) {
        
        // Create a signal
        BusSignal busSignal = new BusSignal();
        // Find out if it is a Bus
        
        // Check if a variable with the same name in the workspace exists
        MatlabCommand variableExists = commandFactory.exist().addParam(workspaceVariableName);
        Double variableExistsRetVal = Handle.getHandleData(variableExists.execute());
        // The limits and the conjunction are here due to the double value
        boolean isVariableFound = variableExistsRetVal > 0.9 && variableExistsRetVal < 1.1;
        
        // isBus will be set to true if it is a bus; by defaults it's false
        boolean isBus = false;
        if(isVariableFound){

            // If a variable with that name exists, check its type. If it is a Simulink.Bus, regard it as the next BusObject to process
        	MatlabCommand getVariableType = commandFactory.customCommand("class(" + workspaceVariableName + ")", 1);
            String variableTypeString = MatlabString.getMatlabStringData(getVariableType.execute());

            isBus = "Simulink.Bus".equals(variableTypeString);
        }

        CellMatlabData signalCell = null;
        String signalName = null;
        
        if(isBus){
        	MatlabCommand getBusObjectStruct = commandFactory.customCommand("Simulink.Bus.objectToCell({'" + workspaceVariableName + "'})", 1);
            signalCell = CellMatlabData.asCellMatlabData(getBusObjectStruct.execute());
            
            signalName = MatlabString.getMatlabStringData(CellMatlabData.getCellMatlabDataData(signalCell.getData(0)).get(0));
        } else {
            signalName = workspaceVariableName;
        }

        // Set the name
        busSignal.setSignalName(signalName);
        
        if (isBus) {
            List<IVisitableMatlabData> busSignals = CellMatlabData.getCellMatlabDataData(CellMatlabData.getCellMatlabDataData(signalCell.getData(0)).get(5));
            for (IVisitableMatlabData signal : busSignals) {
                String childSignalName = MatlabString.getMatlabStringData(CellMatlabData.asCellMatlabData(signal).getData(0));
                busSignal.getSignalsInBus().add(processBusObject(childSignalName,commandFactory));
            }
        }

        return busSignal;
    }

}
