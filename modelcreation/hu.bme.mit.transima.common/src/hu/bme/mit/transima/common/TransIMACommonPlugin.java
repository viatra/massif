package hu.bme.mit.transima.common;

import hu.bme.mit.transima.common.tracer.ITransIMATracer;
import hu.bme.mit.transima.common.tracer.TransIMATracerManager;
import hu.bme.mit.transima.common.tracer.TransIMATracerOptions;
import hu.bme.mit.transima.common.tracer.log4j.TransIMALog4JTracerManager;

import org.eclipse.core.runtime.Plugin;
import org.osgi.framework.BundleContext;

public class TransIMACommonPlugin extends Plugin {

    // The plug-in ID
    public static final String PLUGIN_ID = "hu.bme.mit.transima.common"; //$NON-NLS-1$

    // The shared instance
    private static TransIMACommonPlugin plugin;

    private TransIMATracerManager tracerManager;

    /**
     * The constructor
     */
    public TransIMACommonPlugin() {
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
        tracerManager = new TransIMALog4JTracerManager(context);
        // tracerManager = new TransIMAOSGITracerManager(context);

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
    public static TransIMACommonPlugin getDefault() {
        return plugin;
    }

    public ITransIMATracer getTracer(TransIMATracerOptions option) {
        return tracerManager.getTracer(option);
    }
}
