package hu.bme.mit.massif.common.tracer.simple;

import hu.bme.mit.massif.common.MassifCommonPlugin;
import hu.bme.mit.massif.common.tracer.IMassifTracer;
import hu.bme.mit.massif.common.tracer.MassifTracerManager;
import hu.bme.mit.massif.common.tracer.MassifTracerOptions;

import org.eclipse.osgi.service.debug.DebugOptions;
import org.eclipse.osgi.service.debug.DebugTrace;
import org.osgi.framework.BundleContext;
import org.osgi.util.tracker.ServiceTracker;

public class MassifOSGITracerManager extends MassifTracerManager {

    private DebugTrace trace;

    public MassifOSGITracerManager(BundleContext context) {
        super(context);
        ServiceTracker<Void, DebugOptions> debugTracker = new ServiceTracker<Void, DebugOptions>(context,
                DebugOptions.class.getName(), null);
        debugTracker.open();
        DebugOptions debugOptions = debugTracker.getService();
        trace = debugOptions.newDebugTrace(MassifCommonPlugin.PLUGIN_ID);
    }

    @Override
    protected IMassifTracer createTracer(MassifTracerOptions option) {
        return new MassifOSGITracer(option, trace);
    }

}
