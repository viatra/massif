package hu.bme.mit.massif.common.tracer.simple;

import hu.bme.mit.massif.common.tracer.AbstractMassifTracer;
import hu.bme.mit.massif.common.tracer.MassifTracerOptions;

import java.util.List;

import org.eclipse.osgi.service.debug.DebugTrace;

public class MassifOSGITracer extends AbstractMassifTracer {

    private DebugTrace debugTrace;
    private String optionString;

    public MassifOSGITracer(MassifTracerOptions option, DebugTrace trace) {
        super(option);
        this.debugTrace = trace;
        this.optionString = option.getTraceOption();
    }

    @Override
    public void trace(String formatMessage, Object... formatObjects) {
        if (tracingEnabled) {
            List<Object> namelist = transformNameList(formatObjects);
            debugTrace.trace(optionString, String.format(formatMessage, namelist.toArray()));
        }
    }

}
