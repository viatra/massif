package hu.bme.mit.massif.common.tracer.log4j;

import hu.bme.mit.massif.common.MassifCommonPlugin;
import hu.bme.mit.massif.common.tracer.IMassifTracer;
import hu.bme.mit.massif.common.tracer.MassifTracerManager;
import hu.bme.mit.massif.common.tracer.MassifTracerOptions;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.osgi.framework.BundleContext;

public class MassifLog4JTracerManager extends MassifTracerManager {
    public MassifLog4JTracerManager(BundleContext context) {
        super(context);
    }

    @Override
    protected IMassifTracer createTracer(MassifTracerOptions option) {
        IMassifTracer tracer;
        Logger logger = Logger.getLogger(MassifCommonPlugin.class);
        logger.setLevel(Level.TRACE);
        tracer = new MassifLog4JTracer(option, logger);
        return tracer;
    }
}