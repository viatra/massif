package hu.bme.mit.transima.common.tracer;

import hu.bme.mit.transima.common.TransIMACommonPlugin;

public enum TransIMATracerOptions {
    GLOBAL, SIMULINKAPI, TRANSFORMATION, UI, ALLOCATION;

    public String getFullTraceOption() {
        return TransIMACommonPlugin.PLUGIN_ID + getTraceOption();
    }

    public String getTraceOption() {
        if (this == TransIMATracerOptions.GLOBAL) {
            return "/debug";
        } else {
            return "/trace/" + this.toString().toLowerCase();
        }
    }
}