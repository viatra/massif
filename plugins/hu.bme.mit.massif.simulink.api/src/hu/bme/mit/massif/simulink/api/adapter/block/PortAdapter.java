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

import java.util.List;

import hu.bme.mit.massif.communication.command.MatlabCommand;
import hu.bme.mit.massif.communication.command.MatlabCommandFactory;
import hu.bme.mit.massif.communication.datatype.BusSignal;
import hu.bme.mit.massif.communication.datatype.CellMatlabData;
import hu.bme.mit.massif.communication.datatype.Handle;
import hu.bme.mit.massif.communication.datatype.IVisitableMatlabData;
import hu.bme.mit.massif.communication.datatype.MatlabString;
import hu.bme.mit.massif.simulink.Block;
import hu.bme.mit.massif.simulink.Parameter;
import hu.bme.mit.massif.simulink.PortBlock;
import hu.bme.mit.massif.simulink.SimulinkFactory;
import hu.bme.mit.massif.simulink.SimulinkReference;
import hu.bme.mit.massif.simulink.api.dto.BlockDTO;
import hu.bme.mit.massif.simulink.api.util.ImportMode;

/**
 * Generic adapter class for the port block
 */
public abstract class PortAdapter extends DefaultBlockAdapter {

    @Override
    public abstract Block getBlock(ImportMode importMode);

    @Override
    public void process(BlockDTO dto) {
        super.process(dto);

        PortBlock portBlock = (PortBlock) dto.getBlockToProcess();
        String portBlockName = portBlock.getSimulinkRef().getFQN();
        MatlabCommandFactory commandFactory = dto.getCommandFactory();
        
        // Get DataType and SampleTime properties
        MatlabCommand getDataTypeString = commandFactory.getParam().addParam(portBlockName).addParam("OutDataTypeStr");
        String dataTypeString = MatlabString.getMatlabStringData(getDataTypeString.execute());

        if (dataTypeString.indexOf("Bus") == 0) {

        	MatlabCommand getBusObjectName = commandFactory.getParam().addParam(portBlock.getSimulinkRef().getFQN()).addParam("BusObject");
            String busObjectName = MatlabString.getMatlabStringData(getBusObjectName.execute());

            BusSignal busSignal = processBusObject(busObjectName,commandFactory);

            // The busObjectStructCell stores the raw and busSignal the processed BusObject
            // write model modification code here
            Parameter busObject = SimulinkFactory.eINSTANCE.createParameter();
            busObject.setName("BusObject");
            busObject.setValue(busSignal.toString());
            portBlock.getParameters().add(busObject);
            // for now, only log it
            dto.getLogger().debug(String.format("BusObject in %s was processed to %s", portBlockName, busSignal));
        }

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
        String signalName;
        
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
