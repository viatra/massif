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
package hu.bme.mit.massif.simulink.api.provider.port;

import hu.bme.mit.massif.simulink.api.adapter.port.DefaultPortAdapter;
import hu.bme.mit.massif.simulink.api.adapter.port.EnableAdapter;
import hu.bme.mit.massif.simulink.api.adapter.port.IPortAdapter;
import hu.bme.mit.massif.simulink.api.adapter.port.InportAdapter;
import hu.bme.mit.massif.simulink.api.adapter.port.OutportAdapter;
import hu.bme.mit.massif.simulink.api.adapter.port.StateAdapter;
import hu.bme.mit.massif.simulink.api.adapter.port.TriggerAdapter;

import java.util.HashMap;
import java.util.Map;

public class PortProvider {
    public static final String DEFAULT_PORT_ADAPTER = "DEFAULT_ADAPTER";

    private Map<String, IPortAdapter> adapters;

    /**
     * Constructor for the provider object. Initializes the adapters for the port types
     */
    public PortProvider() {
        // TODO later this can be initialized via extensions
        adapters = new HashMap<String, IPortAdapter>();

        adapters.put("inport", new InportAdapter());
        adapters.put("trigger", new TriggerAdapter());
        adapters.put("enable", new EnableAdapter());
        adapters.put("outport", new OutportAdapter());
        adapters.put("state", new StateAdapter());

        adapters.put(DEFAULT_PORT_ADAPTER, new DefaultPortAdapter());
    }

    /**
     * Gets the appropriate adapter for the given port type
     * 
     * @param portType
     *            the specified port type
     * @return the corresponding adapter for the given type
     */
    public IPortAdapter adapt(String portType) {
        // If the given 'PortType' parameter has no corresponding adapter, return a default adapter
        return adapters.get(portType) == null ? adapters.get(DEFAULT_PORT_ADAPTER) : adapters.get(portType);
    }
}
