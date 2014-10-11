package hu.bme.mit.massif.common.tracer;

import hu.bme.mit.massif.common.MassifCommonPlugin;

public enum MassifTracerOptions {
    GLOBAL, SIMULINKAPI, TRANSFORMATION, UI, ALLOCATION;

    public String getFullTraceOption() {
        return MassifCommonPlugin.PLUGIN_ID + getTraceOption();
    }

    public String getTraceOption() {
        if (this == MassifTracerOptions.GLOBAL) {
            return "/debug";
        } else {
            return "/trace/" + this.toString().toLowerCase();
        }
    }
}