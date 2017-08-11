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
package hu.bme.mit.massif.simulink.api.provider.block;

import java.util.HashMap;
import java.util.Map;

import hu.bme.mit.massif.simulink.api.adapter.block.BusCreatorAdapter;
import hu.bme.mit.massif.simulink.api.adapter.block.BusSelectorAdapter;
import hu.bme.mit.massif.simulink.api.adapter.block.DefaultBlockAdapter;
import hu.bme.mit.massif.simulink.api.adapter.block.EnablePortAdapter;
import hu.bme.mit.massif.simulink.api.adapter.block.FromAdapter;
import hu.bme.mit.massif.simulink.api.adapter.block.GotoAdapter;
import hu.bme.mit.massif.simulink.api.adapter.block.GotoTagVisibilityAdapter;
import hu.bme.mit.massif.simulink.api.adapter.block.IBlockAdapter;
import hu.bme.mit.massif.simulink.api.adapter.block.InportBlockAdapter;
import hu.bme.mit.massif.simulink.api.adapter.block.InportShadowAdapter;
import hu.bme.mit.massif.simulink.api.adapter.block.ModelReferenceAdapter;
import hu.bme.mit.massif.simulink.api.adapter.block.OutPortAdapter;
import hu.bme.mit.massif.simulink.api.adapter.block.SubSystemAdapter;
import hu.bme.mit.massif.simulink.api.adapter.block.TriggerPortAdapter;

/**
 * Provider class to return the appropriate adapter for the specified block type
 */
public class BlockProvider {

    public static final String DEFAULT_BLOCK_ADAPTER = "DEFAULT_ADAPTER";

    private Map<String, IBlockAdapter> adapters;

    /**
     * Constructor for the provider object. Initializes the adapters for the block types
     */
    public BlockProvider() {
        // TODO later this can be initialized via extensions
        adapters = new HashMap<String, IBlockAdapter>();

        adapters.put("BusSelector", new BusSelectorAdapter());
        adapters.put("BusCreator", new BusCreatorAdapter());
        adapters.put("Goto", new GotoAdapter());
        adapters.put("GotoTagVisibility", new GotoTagVisibilityAdapter());
        adapters.put("From", new FromAdapter());
        adapters.put("ModelReference", new ModelReferenceAdapter());
        adapters.put("SubSystem", new SubSystemAdapter());
        adapters.put("Outport", new OutPortAdapter());
        adapters.put("Inport", new InportBlockAdapter());
        adapters.put("EnablePort", new EnablePortAdapter());
        adapters.put("TriggerPort", new TriggerPortAdapter());
        adapters.put("InportShadow", new InportShadowAdapter());
        adapters.put(DEFAULT_BLOCK_ADAPTER, new DefaultBlockAdapter());
    }

    /**
     * Gets the appropriate adapter for the given block type
     * 
     * @param blockType
     *            the specified block type
     * @return the corresponding adapter for the given type
     */
    public IBlockAdapter adapt(String blockType) {
        // If the given 'BlockType' parameter has no corresponding adapter, return a new
        return adapters.get(blockType) == null ? adapters.get(DEFAULT_BLOCK_ADAPTER) : adapters.get(blockType);
    }
}
