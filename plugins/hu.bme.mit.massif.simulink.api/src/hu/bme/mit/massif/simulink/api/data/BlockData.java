/*******************************************************************************
 * Copyright (c) 2010-2013, Embraer S.A., Budapest University of Technology and Economics
 * All rights reserved. This program and the accompanying materials 
 * are made available under the terms of the Eclipse Public License v1.0 
 * which accompanies this distribution, and is available at 
 * http://www.eclipse.org/legal/epl-v10.html 
 *
 * Contributors: 
 *     Krisztián Gábor Mayer - initial API and implementation 
 *******************************************************************************/
package hu.bme.mit.massif.simulink.api.data;

import hu.bme.mit.massif.communication.datatype.Handle;
import hu.bme.mit.massif.simulink.Block;
import hu.bme.mit.massif.simulink.SimulinkReference;
import hu.bme.mit.massif.simulink.api.Importer;


public class BlockData extends AbstractImporterData{

    private SimulinkReference parentSimRef;
    private Block block;

    public BlockData(Importer importer, Handle blockHandle, SimulinkReference parentSimRef, Block block) {
        super(importer, blockHandle);
        this.parentSimRef = parentSimRef;        
        this.block = block;
    }
    
    public Block getBlockToProcess() {
        return block;
    }
    public SimulinkReference getParentSimRef() {
        return parentSimRef;
    }
}
