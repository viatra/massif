package hu.bme.mit.massif.common;

import hu.bme.mit.massif.common.tracer.IMassifTracer;
import hu.bme.mit.massif.common.tracer.MassifTracerManager;
import hu.bme.mit.massif.common.tracer.MassifTracerOptions;
import hu.bme.mit.massif.common.tracer.log4j.MassifLog4JTracerManager;

import org.eclipse.core.runtime.Plugin;
import org.osgi.framework.BundleContext;

public class MassifCommonPlugin extends Plugin {

    // The plug-in ID
    public static final String PLUGIN_ID = "hu.bme.mit.massif.common"; //$NON-NLS-1$

    // The shared instance
    private static MassifCommonPlugin plugin;

    private MassifTracerManager tracerManager;

    /**
     * The constructor
     */
    public MassifCommonPlugin() {
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext)
     */
    @Override
    public void start(BundleContext context) throws Exception {
        super.start(context);
        plugin = this;
        tracerManager = new MassifLog4JTracerManager(context);
        // tracerManager = new massifOSGITracerManager(context);

    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext)
     */
    @Override
    public void stop(BundleContext context) throws Exception {
        plugin = null;
        tracerManager.dispose();
        tracerManager = null;
        super.stop(context);
    }

    /**
     * Returns the shared instance
     * 
     * @return the shared instance
     */
    public static MassifCommonPlugin getDefault() {
        return plugin;
    }

    public IMassifTracer getTracer(MassifTracerOptions option) {
        return tracerManager.getTracer(option);
    }
}
