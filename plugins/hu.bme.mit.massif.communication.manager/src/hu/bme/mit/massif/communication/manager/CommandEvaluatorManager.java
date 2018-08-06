/*******************************************************************************
 * Copyright (c) 2010, 2014, Embraer S.A., Budapest University of Technology and Economics
 * All rights reserved. This program and the accompanying materials 
 * are made available under the terms of the Eclipse Public License v1.0 
 * which accompanies this distribution, and is available at 
 * http://www.eclipse.org/legal/epl-v10.html 
 *
 * Contributors: 
 *     Marton Bur, Abel Hegedus - initial API and implementation 
 *******************************************************************************/
package hu.bme.mit.massif.communication.manager;

import hu.bme.mit.massif.communication.ConnectorCreationException;
import hu.bme.mit.massif.communication.ICommandEvaluator;
import hu.bme.mit.massif.communication.ICommandEvaluatorFactory;
import hu.bme.mit.massif.communication.MassifCommunicationManagerPlugin;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtension;
import org.eclipse.core.runtime.IExtensionPoint;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;

/**
 * This class is responsible for returning the appropriate object with the ICommandEvaluator interface for command
 * execution.
 */
public enum CommandEvaluatorManager {

	INSTANCE;
	
	private Map<String, ICommandEvaluatorFactory> factoryMap = null;

    public ICommandEvaluator getCommandEvaluator(String id, Map<String, Object> parameters) throws ConnectorCreationException {
    	ICommandEvaluator result = null;
    	if(id != null){
    		ICommandEvaluatorFactory factory = getFactoryMap().get(id);
    		if(factory != null){
    			result = factory.createOrGetCommandEvaluator(parameters);
    		}
    	}
    	return result;
    }
    
    public Map<String, String> getConnectorIdNameMap() {
    	Map<String, String> connectorIdMap = new HashMap<String, String>();
    	Map<String, ICommandEvaluatorFactory> factories = getFactoryMap();
    	for (Entry<String, ICommandEvaluatorFactory> entry : factories.entrySet()) {
			String id = entry.getKey();
			String connectorName = entry.getValue().getConnectorName();
			connectorIdMap.put(id, connectorName);
		}
    	return connectorIdMap;
    }
    
    private synchronized Map<String, ICommandEvaluatorFactory> getFactoryMap() {
		if(factoryMap == null){
			factoryMap = new HashMap<String, ICommandEvaluatorFactory>();
			processConnectorExtensions();
		}
    	return factoryMap;
	}
    
    private void processConnectorExtensions() {
    	// Initialization of connectors from extensions via the extension point
        IExtensionRegistry reg = Platform.getExtensionRegistry();
        IExtensionPoint poi;

        if (reg != null) {
            poi = reg.getExtensionPoint("hu.bme.mit.massif.matlab.connectors");
            if (poi != null) {
                IExtension[] exts = poi.getExtensions();

                for (IExtension ext : exts) {
                    IConfigurationElement[] els = ext.getConfigurationElements();
                    for (IConfigurationElement el : els) {
                        if (el.getName().equals("connector")) {
                            try {
                            	ICommandEvaluatorFactory factory = (ICommandEvaluatorFactory) el
                                        .createExecutableExtension("factory");
                            	String id = el.getAttribute("id");
                                if (id != null && !"".equals(id) && factory != null) {
                                    if(factoryMap.containsKey(id)){
                                    	MassifCommunicationManagerPlugin
										.getDefault()
										.getLog()
										.log(new Status(IStatus.ERROR,
												MassifCommunicationManagerPlugin.PLUGIN_ID,
												"Connector id " + id + " is not unique!"));
                                    } else {
                                    	factoryMap.put(id, factory);
                                    }
                                }
							} catch (Exception e) {
								MassifCommunicationManagerPlugin
										.getDefault()
										.getLog()
										.log(new Status(IStatus.ERROR,
												MassifCommunicationManagerPlugin.PLUGIN_ID,
												"Could not initialize connector!", e));
							}
                        }
                    }
                }
            }
        }
    }

}
