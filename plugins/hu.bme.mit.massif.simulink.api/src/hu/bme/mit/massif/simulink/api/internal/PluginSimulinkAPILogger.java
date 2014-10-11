package hu.bme.mit.massif.simulink.api.internal;

import hu.bme.mit.massif.common.MassifCommonPlugin;
import hu.bme.mit.massif.common.tracer.IMassifTracer;
import hu.bme.mit.massif.common.tracer.MassifTracerOptions;
import hu.bme.mit.massif.simulink.api.util.ISimulinkAPILogger;

import org.eclipse.core.runtime.Status;

public class PluginSimulinkAPILogger implements ISimulinkAPILogger {

    IMassifTracer tracer = MassifCommonPlugin.getDefault().getTracer(MassifTracerOptions.SIMULINKAPI);

    @Override
    public void error(String message) {
        error(message, null);
    }

    @Override
    public void error(String message, Throwable cause) {
        Status status = new Status(Status.ERROR, SimulinkApiPlugin.PLUGIN_ID, message, cause);
        logStatusToPluginLogger(status);
    }

    public void logStatusToPluginLogger(Status status) {
        SimulinkApiPlugin.getDefault().getLog().log(status);
    }

    @Override
    public void warning(String message) {
        Status status = new Status(Status.WARNING, SimulinkApiPlugin.PLUGIN_ID, message);
        logStatusToPluginLogger(status);
    }

    @Override
    public void debug(String message) {
        tracer.trace(message);
    }

    @Override
    public boolean isDebugging() {
        return tracer.isTracingEnabled();
    }

}
