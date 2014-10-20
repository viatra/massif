/*******************************************************************************
 * Copyright (c) 2010-2013, Embraer S.A., Budapest University of Technology and Economics
 * All rights reserved. This program and the accompanying materials 
 * are made available under the terms of the Eclipse Public License v1.0 
 * which accompanies this distribution, and is available at 
 * http://www.eclipse.org/legal/epl-v10.html 
 *
 * Contributors: 
 *     Abel Hegedus - initial API and implementation 
 *******************************************************************************/
package hu.bme.mit.massif.common.tracer;

import hu.bme.mit.massif.common.MassifCommonPlugin;

import java.util.Hashtable;
import java.util.Map;

import org.eclipse.core.runtime.Platform;
import org.eclipse.osgi.service.debug.DebugOptions;
import org.eclipse.osgi.service.debug.DebugOptionsListener;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

import com.google.common.collect.Maps;

public abstract class MassifTracerManager {

    private Map<MassifTracerOptions, IMassifTracer> tracers;

    private ServiceRegistration<?> listenerService;

    public MassifTracerManager(BundleContext context) {
        tracers = Maps.newHashMap();
        final Hashtable<String, String> properties = new Hashtable<String, String>(4);
        properties.put(DebugOptions.LISTENER_SYMBOLICNAME, MassifCommonPlugin.PLUGIN_ID);
        DebugOptionsListener debugOptionsListener = new DebugOptionsListener() {

            @Override
            public void optionsChanged(DebugOptions options) {
                boolean globalOption = options.getBooleanOption(MassifTracerOptions.GLOBAL.getFullTraceOption(),
                    false);
                for (MassifTracerOptions existingTracerOption : tracers.keySet()) {
                    boolean debugOption = globalOption
                            && options.getBooleanOption(existingTracerOption.getFullTraceOption(), false);
                    tracers.get(existingTracerOption).setTracingEnabled(debugOption);
                }
            }

        };
        listenerService = context.registerService(DebugOptionsListener.class.getName(), debugOptionsListener,
            properties);
    }

    public void dispose() {
        listenerService.unregister();
        tracers = null;
    }

    public IMassifTracer getTracer(MassifTracerOptions option) {
        IMassifTracer tracer = null;
        if (tracers.containsKey(option)) {
            tracer = tracers.get(option);
        } else {
            tracer = createTracer(option);
            boolean tracingEnabled = isTracingOptionEnabled(option);
            tracer.setTracingEnabled(tracingEnabled);
            tracers.put(option, tracer);
        }
        return tracer;
    }

    // this can be implemented to use debugTrace instead of log4j
    protected abstract IMassifTracer createTracer(MassifTracerOptions option);

    private boolean isTracingOptionEnabled(MassifTracerOptions option) {
        boolean globalOptionEnabled = MassifCommonPlugin.getDefault().isDebugging();
        if (option != null && option != MassifTracerOptions.GLOBAL) {
            String optionValue = Platform.getDebugOption(option.getFullTraceOption());
            return globalOptionEnabled && Boolean.parseBoolean(optionValue);
        }
        return false;
    }
}