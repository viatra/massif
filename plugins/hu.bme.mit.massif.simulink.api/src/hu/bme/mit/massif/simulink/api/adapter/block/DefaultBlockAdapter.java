/*******************************************************************************
 * Copyright (c) 2010-2013, Embraer S.A., Budapest University of Technology and Economics
 * All rights reserved. This program and the accompanying materials 
 * are made available under the terms of the Eclipse Public License v1.0 
 * which accompanies this distribution, and is available at 
 * http://www.eclipse.org/legal/epl-v10.html 
 *
 * Contributors: 
 *     Marton Bur, Abel Hegedus, Akos Horvath - initial API and implementation 
 *     Marton Bur - script-based parameter querying
 *     Marton Bur - support for parameter filtering
 *     Krisztian Gabor Mayer - additional features      
 *******************************************************************************/
package hu.bme.mit.massif.simulink.api.adapter.block;

import java.util.List;

import hu.bme.mit.massif.communication.datatype.Handle;
import hu.bme.mit.massif.simulink.Block;
import hu.bme.mit.massif.simulink.Parameter;
import hu.bme.mit.massif.simulink.SimulinkFactory;
import hu.bme.mit.massif.simulink.SimulinkReference;
import hu.bme.mit.massif.simulink.api.adapter.ParameterHelper;
import hu.bme.mit.massif.simulink.api.data.BlockData;
import hu.bme.mit.massif.simulink.api.util.ImportMode;

/**
 * Generic adapter for non-specific blocks. This adapter is used when no adapter is registered for a block type. The
 * process method should be called from every class subclassing it.
 */
public class DefaultBlockAdapter implements IBlockAdapter {

    @Override
    public Block getBlock(ImportMode importMode) {
        return SimulinkFactory.eINSTANCE.createBlock();
    }

    @Override
    public void process(BlockData dto) {
        // The default block processing implementation goes here
        List<Parameter> blockProperties = ParameterHelper.collectParameters(dto);
        dto.getBlockToProcess().getParameters().addAll(blockProperties);
    }

}
