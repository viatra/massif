package hu.bme.mit.transima.common.tracer;

import hu.bme.mit.transima.common.TransIMACommonPlugin;

import java.util.Hashtable;
import java.util.Map;

import org.eclipse.core.runtime.Platform;
import org.eclipse.osgi.service.debug.DebugOptions;
import org.eclipse.osgi.service.debug.DebugOptionsListener;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

import com.google.common.collect.Maps;

public abstract class TransIMATracerManager {

    private Map<TransIMATracerOptions, ITransIMATracer> tracers;

    private ServiceRegistration<?> listenerService;

    public TransIMATracerManager(BundleContext context) {
        tracers = Maps.newHashMap();
        final Hashtable<String, String> properties = new Hashtable<String, String>(4);
        properties.put(DebugOptions.LISTENER_SYMBOLICNAME, TransIMACommonPlugin.PLUGIN_ID);
        DebugOptionsListener debugOptionsListener = new DebugOptionsListener() {

            @Override
            public void optionsChanged(DebugOptions options) {
                boolean globalOption = options.getBooleanOption(TransIMATracerOptions.GLOBAL.getFullTraceOption(),
                    false);
                for (TransIMATracerOptions existingTracerOption : tracers.keySet()) {
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

    public ITransIMATracer getTracer(TransIMATracerOptions option) {
        ITransIMATracer tracer = null;
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
    protected abstract ITransIMATracer createTracer(TransIMATracerOptions option);

    private boolean isTracingOptionEnabled(TransIMATracerOptions option) {
        boolean globalOptionEnabled = TransIMACommonPlugin.getDefault().isDebugging();
        if (option != null && option != TransIMATracerOptions.GLOBAL) {
            String optionValue = Platform.getDebugOption(option.getFullTraceOption());
            return globalOptionEnabled && Boolean.parseBoolean(optionValue);
        }
        return false;
    }
}