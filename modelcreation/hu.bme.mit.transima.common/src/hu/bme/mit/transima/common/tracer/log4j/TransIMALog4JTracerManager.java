package hu.bme.mit.transima.common.tracer.log4j;

import hu.bme.mit.transima.common.TransIMACommonPlugin;
import hu.bme.mit.transima.common.tracer.ITransIMATracer;
import hu.bme.mit.transima.common.tracer.TransIMATracerManager;
import hu.bme.mit.transima.common.tracer.TransIMATracerOptions;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.osgi.framework.BundleContext;

public class TransIMALog4JTracerManager extends TransIMATracerManager {
    public TransIMALog4JTracerManager(BundleContext context) {
        super(context);
    }

    @Override
    protected ITransIMATracer createTracer(TransIMATracerOptions option) {
        ITransIMATracer tracer;
        Logger logger = Logger.getLogger(TransIMACommonPlugin.class);
        logger.setLevel(Level.TRACE);
        tracer = new TransIMALog4JTracer(option, logger);
        return tracer;
    }
}