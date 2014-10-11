package hu.bme.mit.massif.common.tracer.log4j;

import hu.bme.mit.massif.common.tracer.AbstractMassifTracer;
import hu.bme.mit.massif.common.tracer.MassifTracerOptions;

import java.util.List;

import org.apache.log4j.Logger;

public class MassifLog4JTracer extends AbstractMassifTracer {

    private final Logger logger;
    protected MassifLog4JTracer(MassifTracerOptions option, Logger logger) {
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
