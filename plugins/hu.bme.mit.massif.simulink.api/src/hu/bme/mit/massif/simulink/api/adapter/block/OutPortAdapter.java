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

import java.util.LinkedHashSet;
import java.util.Map;

import hu.bme.mit.massif.simulink.Block;
import hu.bme.mit.massif.simulink.OutPortBlock;
import hu.bme.mit.massif.simulink.SimulinkFactory;
import hu.bme.mit.massif.simulink.SimulinkReference;
import hu.bme.mit.massif.simulink.api.data.BlockData;
import hu.bme.mit.massif.simulink.api.util.ImportMode;

/**
 * Adapter class for the out port block
 */
public class OutPortAdapter extends PortAdapter {

    @Override
    public Block getBlock(ImportMode importMode) {
        return SimulinkFactory.eINSTANCE.createOutPortBlock();
    }

    @Override
    public void process(BlockData dto) {
        super.process(dto);
        SimulinkReference parentSimRef = dto.getParentSimRef();
        Map<String, LinkedHashSet<OutPortBlock>> outPortBlocks = dto.getOutPortBlocks();
        if (parentSimRef != null) {
            // Cache the outport block
            if (outPortBlocks.get(parentSimRef.getFQN()) == null) {
                outPortBlocks.put(parentSimRef.getFQN(), new LinkedHashSet<OutPortBlock>());
            }
            outPortBlocks.get(parentSimRef.getFQN()).add((OutPortBlock) dto.getBlockToProcess());
        }
    }

}
