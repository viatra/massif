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

import hu.bme.mit.massif.simulink.Block;
import hu.bme.mit.massif.simulink.From;
import hu.bme.mit.massif.simulink.SimulinkFactory;
import hu.bme.mit.massif.simulink.api.data.BlockData;
import hu.bme.mit.massif.simulink.api.util.ImportMode;

/**
 * Adapter class for the from block
 */
public class FromAdapter extends DefaultBlockAdapter {

    @Override
    public Block getBlock(ImportMode importMode) {
        return SimulinkFactory.eINSTANCE.createFrom();
    }

    @Override
    public void process(BlockData dto) {
        super.process(dto);
        From fromBlock = (From) dto.getBlockToProcess();
        dto.getFroms().put(fromBlock.getSimulinkRef().getFQN().replaceAll("\n", " "), fromBlock);
        // This block is processed further during the creation of connections between blocks
    }

}
