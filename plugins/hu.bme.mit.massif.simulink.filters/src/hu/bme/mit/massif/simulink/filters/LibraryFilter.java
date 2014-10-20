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
package hu.bme.mit.massif.simulink.filters;

import hu.bme.mit.massif.communication.command.MatlabCommand;
import hu.bme.mit.massif.communication.command.MatlabCommandFactory;
import hu.bme.mit.massif.communication.datatype.CellMatlabData;
import hu.bme.mit.massif.communication.datatype.MatlabString;
import hu.bme.mit.massif.simulink.api.extension.ISimulinkImportFilter;

/**
 * This filter identifies atomic library blocks inside a library model. Such blocks are not represented graphically by
 * the tree view of the Simulink Library Browser in Matlab. <br>
 * <br>
 * 
 * Def.: atomic library element = block in a library that is used in models (does not contain library elements)<br>
 * <br>
 * 
 * I think the following heuristic will cover all cases:<br>
 * 
 * (a) If a block is not a subsystem, it is an atomic library element (return true)<br>
 * 
 * (b) If a block is a subsystem, then:<br>
 * 
 * (b/i) If it has any input or any output (including trigger, if ports or symPower ports), then it is atomic. (return
 * true)<br>
 * 
 * (b/ii) If any field in the block Properties dialog is not empty, then it is atomic (all these fields can be accessed
 * from get_param) (return true)<br>
 * 
 * (b/iii) If any field in the Parameters, Initialization or Documentation tabs in the "Mask editor" dialog are not
 * empty, then it is atomic (return true) (again, these field can be accessed with get_param). Note that it is common to
 * change the information in the Icon tab, so this is not a good indication.<br>
 * 
 * (b/iv) Otherwise, it is not atomic, that is, it is simply part of the hierarchical organization (return false)<br>
 */
public class LibraryFilter implements ISimulinkImportFilter {

    @Override
    public boolean filter(MatlabCommandFactory commandFactory, String blockFQN) {
        // Check case (a)
    	MatlabCommand getBlockType = commandFactory.getParam().addParam(blockFQN).addParam("BlockType");
        String type = MatlabString.getMatlabStringData(getBlockType.execute());

        if (!type.equals("SubSystem"))
            return true;

        // Check case (b/i)
        // LinkedList<Double> ports = new LinkedList<Double>();
        MatlabCommand getPortHandles = commandFactory.getParam().addParam(blockFQN).addParam("PortHandles");
        int portCounter = CellMatlabData.getCellMatlabDataData(getPortHandles.execute()).size();

        // If the list containing the port handles is not empty, it
        // indicates that there was at least one port
        if (portCounter != 0) {
            return true;
        }

        // Check case (b/ii)
        MatlabCommand getDescription = commandFactory.getParam().addParam(blockFQN).addParam("Description");
        MatlabCommand getPriority = commandFactory.getParam().addParam(blockFQN).addParam("Priority");
        MatlabCommand getTag = commandFactory.getParam().addParam(blockFQN).addParam("Tag");

        String description = MatlabString.getMatlabStringData(getDescription.execute());
        String priority = MatlabString.getMatlabStringData(getPriority.execute());
        String tag = MatlabString.getMatlabStringData(getTag.execute());
        if (description.length() != 0 || priority.length() != 0 || tag.length() != 0)
            return true;

        // Check case (b/iii)
        // If there is at least one mask variable, it is atomic
        MatlabCommand getMaskVariables = commandFactory.getParam().addParam(blockFQN).addParam("MaskVariables");
        String maskParams = MatlabString.getMatlabStringData(getMaskVariables.execute());
        if (maskParams.length() > 0)
            return true;
        // If the mask initialization is not empty, it is atomic
        MatlabCommand getMaskInitialization = commandFactory.getParam().addParam(blockFQN).addParam("MaskInitialization");
        String maskInit = MatlabString.getMatlabStringData(getMaskInitialization.execute());
        if (maskInit.length() > 0)
            return true;
        // If the documentation tab not empty, it is atomic
        MatlabCommand getMaskType = commandFactory.getParam().addParam(blockFQN).addParam("MaskType");
        MatlabCommand getMaskDescription = commandFactory.getParam().addParam(blockFQN).addParam("MaskDescription");
        MatlabCommand getMaskHelp = commandFactory.getParam().addParam(blockFQN).addParam("MaskHelp");

        String maskType = MatlabString.getMatlabStringData(getMaskType.execute());
        String maskDescription = MatlabString.getMatlabStringData(getMaskDescription.execute());
        String maskHelp = MatlabString.getMatlabStringData(getMaskHelp.execute());
        if (maskType.length() > 0 || maskDescription.length() > 0 || maskHelp.length() > 0)
            return true;

        // Case (b/iv)
        return false;
    }
}
