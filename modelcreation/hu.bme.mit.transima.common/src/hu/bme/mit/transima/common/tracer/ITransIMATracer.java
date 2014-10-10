package hu.bme.mit.transima.common.tracer;

public interface ITransIMATracer {

    /**
     * Send a message to the trace logger. The format message will only be assembled when actual logging is required,
     * therefore any performance overhead from toString() and string concatenation occurs when tracing is required.
     * 
     * @param formatMessage
     * @param formatObjects
     */
    public void trace(String formatMessage, Object... formatObjects);

    /**
     * The option of the tracer represents what kind of functionality is traced through it.
     * 
     * @return
     */
    public TransIMATracerOptions getOption();

    /**
     * NOTE: {@link #trace(String, Object...)} can be called without checking the value returned by this method!
     * 
     * @return
     */
    public boolean isTracingEnabled();

    void setTracingEnabled(boolean tracingEnabled);

}
