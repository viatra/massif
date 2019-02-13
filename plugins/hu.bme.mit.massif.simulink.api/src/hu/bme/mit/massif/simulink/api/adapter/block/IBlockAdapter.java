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

import java.io.IOException;

import hu.bme.mit.massif.simulink.Block;
import hu.bme.mit.massif.simulink.api.data.BlockData;
import hu.bme.mit.massif.simulink.api.exception.SimulinkApiException;
import hu.bme.mit.massif.simulink.api.util.ImportMode;

/**
 * The block adapter interface
 * 
 * Classes that are implementing this interface are used to create specific EMF representations of Simulink blocks.
 */
public interface IBlockAdapter {

    /**
     * Returns an instance of the block EClass associated with the adapter
     * 
     * @return the EMF block object
     */
    Block getBlock(ImportMode importMode);

    /**
     * Executes the required actions to import the block to EMF properly
     * 
     * @param traverser
     *            the currently traversing object
     * @param parentSimRef
     *            the </code>SimulinkReference</code> of the block being processed
     * @param blockToProcess
     *            the block to process by the corresponding implementation
     * @throws SimulinkApiException
     * @throws IOException
     */
    void process(BlockData dto);

}
