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

import hu.bme.mit.massif.communication.command.MatlabCommand;
import hu.bme.mit.massif.communication.command.MatlabCommandFactory;
import hu.bme.mit.massif.communication.datatype.CellMatlabData;
import hu.bme.mit.massif.communication.datatype.IVisitableMatlabData;
import hu.bme.mit.massif.communication.datatype.MatlabString;
import hu.bme.mit.massif.communication.datatype.StructMatlabData;
import hu.bme.mit.massif.simulink.Block;
import hu.bme.mit.massif.simulink.Goto;
import hu.bme.mit.massif.simulink.SimulinkFactory;
import hu.bme.mit.massif.simulink.TagVisibility;
import hu.bme.mit.massif.simulink.api.dto.BlockDTO;
import hu.bme.mit.massif.simulink.api.util.ImportMode;

/**
 * Adapter class for the goto block
 */
public class GotoAdapter extends DefaultBlockAdapter {

    @Override
    public Block getBlock(ImportMode importMode) {
        return SimulinkFactory.eINSTANCE.createGoto();
    }

    @Override
    public void process(BlockDTO dto) {
        super.process(dto);
        // TODO revisit implementation
        Goto gotoBlock = (Goto) dto.getBlockToProcess();
        MatlabCommandFactory commandFactory = dto.getCommandFactory();
        String blockName = gotoBlock.getSimulinkRef().getFQN();

        MatlabCommand getGotoTag = commandFactory.getParam().addParam(blockName).addParam("GotoTag");
        String gotoTag = MatlabString.getMatlabStringData(getGotoTag.execute());

        gotoBlock.setGotoTag(gotoTag);

        TagVisibility tagVisibility = null;

        MatlabCommand getGotoTagVisibility = commandFactory.getParam().addParam(blockName).addParam("TagVisibility");
        String tagVisibilityStr = MatlabString.getMatlabStringData(getGotoTagVisibility.execute());

        if (tagVisibilityStr.contains("local")) {
            tagVisibility = TagVisibility.LOCAL;
        } else if (tagVisibilityStr.contains("global")) {
            tagVisibility = TagVisibility.GLOBAL;
        } else if (tagVisibilityStr.contains("scoped")) {
            tagVisibility = TagVisibility.SCOPED;
        }

        gotoBlock.setTagVisibility(tagVisibility);

        List<String> fromNames = null;
        // Get the corresponding from block FQNs
        MatlabCommand getGotoHandle = commandFactory.getParam().addParam(blockName).addParam("Handle");
        IVisitableMatlabData gotoHandle = getGotoHandle.execute();

        MatlabCommand getFromsForGoto = commandFactory.get().addParam(gotoHandle).addParam("FromBlock");
        CellMatlabData fromNamesAndHandles = CellMatlabData.asCellMatlabData(getFromsForGoto.execute());
        fromNames = new LinkedList<String>();

        for (IVisitableMatlabData fromData : fromNamesAndHandles.getDatas()) {
            StructMatlabData structFromData = (StructMatlabData) fromData;
            if (structFromData == null) {
                // This means that there are no corresponding from blocks
                continue;
            }

            String fromName = MatlabString.getMatlabStringData(structFromData.getData("name"));
            fromNames.add(fromName.replaceAll("\n", " "));
        }
        dto.getGotos().put(gotoBlock, fromNames);
        // This block is processed further during the creation of connections between blocks
    }

}
