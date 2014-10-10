package hu.bme.mit.transima.common.tracer.log4j;

import hu.bme.mit.transima.common.tracer.AbstractTransIMATracer;
import hu.bme.mit.transima.common.tracer.TransIMATracerOptions;

import java.util.List;

import org.apache.log4j.Logger;

public class TransIMALog4JTracer extends AbstractTransIMATracer {

    private final Logger logger;
    protected TransIMALog4JTracer(TransIMATracerOptions option, Logger logger) {
        super(option);
        this.logger = logger;
    }

    @Override
    public void trace(String formatMessage, Object... formatObjects) {
        if (tracingEnabled) {
            List<Object> namelist = transformNameList(formatObjects);
            logger.trace(String.format(option + " >> " + formatMessage, namelist.toArray()));
        }
    }
}
