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
import hu.bme.mit.massif.simulink.SimulinkFactory;
import hu.bme.mit.massif.simulink.api.dto.BlockDTO;
import hu.bme.mit.massif.simulink.api.util.ImportMode;

/**
 * Adapter class for the trigger port block
 */
public class TriggerPortAdapter extends InportBlockAdapter {

    @Override
    public Block getBlock(ImportMode importMode) {
        return SimulinkFactory.eINSTANCE.createTriggerBlock();
    }

    @Override
    public void process(BlockDTO dto) {
        super.process(dto);
    }

}
