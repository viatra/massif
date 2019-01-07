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
import hu.bme.mit.massif.simulink.InPortBlock;
import hu.bme.mit.massif.simulink.SimulinkFactory;
import hu.bme.mit.massif.simulink.SimulinkReference;
import hu.bme.mit.massif.simulink.api.data.BlockData;
import hu.bme.mit.massif.simulink.api.util.ImportMode;

/**
 * Adapter class for the in port block
 */
public class InportBlockAdapter extends PortAdapter {

    @Override
    public Block getBlock(ImportMode importMode) {
        return SimulinkFactory.eINSTANCE.createInPortBlock();
    }

    @Override
    public void process(BlockData dto) {
        super.process(dto);

        Map<String, LinkedHashSet<InPortBlock>> inPortBlocks = dto.getInPortBlocks();
        SimulinkReference parentSimRef = dto.getParentSimRef();
        Block blockToProcess = dto.getBlockToProcess();
        if (parentSimRef != null) {
            if (inPortBlocks.get(parentSimRef.getFQN()) == null) {
                inPortBlocks.put(parentSimRef.getFQN(), new LinkedHashSet<InPortBlock>());
            }
            // Cache the inport block
            inPortBlocks.get(parentSimRef.getFQN()).add((InPortBlock) dto.getBlockToProcess());
        }
        
        dto.getInportBlocksByName().put(dto.getBlockToProcess().getSimulinkRef().getFQN(), (InPortBlock) blockToProcess);

    }


}
