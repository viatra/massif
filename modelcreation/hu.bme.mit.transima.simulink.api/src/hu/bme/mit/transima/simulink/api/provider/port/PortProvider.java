package hu.bme.mit.transima.simulink.api.provider.port;

import hu.bme.mit.transima.simulink.api.adapter.port.DefaultAdapter;
import hu.bme.mit.transima.simulink.api.adapter.port.EnableAdapter;
import hu.bme.mit.transima.simulink.api.adapter.port.IPortAdapter;
import hu.bme.mit.transima.simulink.api.adapter.port.InportAdapter;
import hu.bme.mit.transima.simulink.api.adapter.port.OutportAdapter;
import hu.bme.mit.transima.simulink.api.adapter.port.TriggerAdapter;

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

        adapters.put("Inport", new InportAdapter());
        adapters.put("Trigger", new TriggerAdapter());
        adapters.put("Enable", new EnableAdapter());
        adapters.put("Outport", new OutportAdapter());

        adapters.put(DEFAULT_PORT_ADAPTER, new DefaultAdapter());
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
