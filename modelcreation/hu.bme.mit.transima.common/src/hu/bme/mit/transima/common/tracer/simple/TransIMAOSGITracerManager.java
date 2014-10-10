package hu.bme.mit.transima.common.tracer.simple;

import hu.bme.mit.transima.common.TransIMACommonPlugin;
import hu.bme.mit.transima.common.tracer.ITransIMATracer;
import hu.bme.mit.transima.common.tracer.TransIMATracerManager;
import hu.bme.mit.transima.common.tracer.TransIMATracerOptions;

import org.eclipse.osgi.service.debug.DebugOptions;
import org.eclipse.osgi.service.debug.DebugTrace;
import org.osgi.framework.BundleContext;
import org.osgi.util.tracker.ServiceTracker;

public class TransIMAOSGITracerManager extends TransIMATracerManager {

    private DebugTrace trace;

    public TransIMAOSGITracerManager(BundleContext context) {
        super(context);
        ServiceTracker<Void, DebugOptions> debugTracker = new ServiceTracker<Void, DebugOptions>(context,
                DebugOptions.class.getName(), null);
        debugTracker.open();
        DebugOptions debugOptions = debugTracker.getService();
        trace = debugOptions.newDebugTrace(TransIMACommonPlugin.PLUGIN_ID);
    }

    @Override
    protected ITransIMATracer createTracer(TransIMATracerOptions option) {
        return new TransIMAOSGITracer(option, trace);
    }

}
