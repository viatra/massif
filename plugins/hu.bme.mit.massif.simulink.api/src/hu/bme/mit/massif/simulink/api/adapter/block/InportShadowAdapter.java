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
package hu.bme.mit.massif.simulink.api.adapter.block;

import hu.bme.mit.massif.communication.command.MatlabCommand;
import hu.bme.mit.massif.communication.command.MatlabCommandFactory;
import hu.bme.mit.massif.communication.datatype.CellMatlabData;
import hu.bme.mit.massif.communication.datatype.MatlabString;
import hu.bme.mit.massif.simulink.Block;
import hu.bme.mit.massif.simulink.InPortBlock;
import hu.bme.mit.massif.simulink.SimulinkReference;
import hu.bme.mit.massif.simulink.api.Importer;

/**
 * Adapter class for the bus creator
 */
public class InportShadowAdapter extends InportBlockAdapter {

    @Override
    public void process(Importer traverser, SimulinkReference parentSimRef, Block blockToProcess) {
        super.process(traverser, parentSimRef, blockToProcess);

        MatlabCommandFactory commandFactory = traverser.getCommandFactory();
        String commandNameString = "find_system('" + blockToProcess.getSimulinkRef().getQualifier()
                + "','SearchDepth','1','LookUnderMasks','all','BlockType','Inport','Port',get_param('"
                + blockToProcess.getSimulinkRef().getFQN() + "','Port'))".replace("\r\n", " ");
        commandNameString = commandNameString.replace('\n', ' ');
        MatlabCommand getInport = commandFactory.customCommand(commandNameString, 1);
        MatlabString inportName = MatlabString.asMatlabString(CellMatlabData.asCellMatlabData(getInport.execute())
                .getData(0));

        traverser.getLogger().debug("InportShadow port was found in the model: " + inportName);
        traverser.getShadowInports().put((InPortBlock) blockToProcess, inportName);
    }

}
