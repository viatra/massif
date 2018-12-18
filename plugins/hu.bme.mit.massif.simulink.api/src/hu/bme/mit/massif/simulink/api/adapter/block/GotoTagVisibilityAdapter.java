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
import hu.bme.mit.massif.communication.datatype.MatlabString;
import hu.bme.mit.massif.simulink.Block;
import hu.bme.mit.massif.simulink.GotoTagVisibility;
import hu.bme.mit.massif.simulink.SimulinkFactory;
import hu.bme.mit.massif.simulink.api.dto.BlockDTO;
import hu.bme.mit.massif.simulink.api.util.ImportMode;

/**
 * Adapter class for the goto tag visibility blocks
 */
public class GotoTagVisibilityAdapter extends DefaultBlockAdapter {

    @Override
    public Block getBlock(ImportMode importMode) {
        return SimulinkFactory.eINSTANCE.createGotoTagVisibility();
    }

    @Override
    public void process(BlockDTO dto) {
        super.process(dto);

        GotoTagVisibility gotoTagVisibilityBlock = (GotoTagVisibility) dto.getBlockToProcess();
        String blockFQN = gotoTagVisibilityBlock.getSimulinkRef().getFQN();

        MatlabCommandFactory commandFactory = dto.getCommandFactory();        

        MatlabCommand getGotoTag = commandFactory.getParam().addParam(blockFQN).addParam("GotoTag");
        String gotoTag = MatlabString.getMatlabStringData(getGotoTag.execute());

        List<GotoTagVisibility> gotoTagVisibilitiesList = dto.getGotoTagVisibilities().get(gotoTag);
        if(gotoTagVisibilitiesList == null){
            gotoTagVisibilitiesList = new LinkedList<GotoTagVisibility>();
            dto.getGotoTagVisibilities().put(gotoTag,gotoTagVisibilitiesList);
        }
         
        gotoTagVisibilitiesList.add(gotoTagVisibilityBlock);
        
        // This block is processed further during the creation of connections between blocks
    }

}
