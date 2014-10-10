package hu.bme.mit.transima.common.tracer.simple;

import hu.bme.mit.transima.common.tracer.AbstractTransIMATracer;
import hu.bme.mit.transima.common.tracer.TransIMATracerOptions;

import java.util.List;

import org.eclipse.osgi.service.debug.DebugTrace;

public class TransIMAOSGITracer extends AbstractTransIMATracer {

    private DebugTrace debugTrace;
    private String optionString;

    public TransIMAOSGITracer(TransIMATracerOptions option, DebugTrace trace) {
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
