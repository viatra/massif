package hu.bme.mit.transima.common.tracer;

import hu.bme.mit.transima.common.NamingUtil;

import java.util.List;

import org.eclipse.emf.ecore.EObject;

import com.google.common.base.Function;
import com.google.common.collect.Lists;


public abstract class AbstractTransIMATracer implements ITransIMATracer {

    protected final TransIMATracerOptions option;
    protected boolean tracingEnabled = false;

    public AbstractTransIMATracer(TransIMATracerOptions option) {
        this.option = option;
    }

    @Override
    public TransIMATracerOptions getOption() {
        return option;
    }

    @Override
    public boolean isTracingEnabled() {
        return tracingEnabled;
    }

    @Override
    public void setTracingEnabled(boolean tracingEnabled) {
        this.tracingEnabled = tracingEnabled;
    }

    protected List<Object> transformNameList(Object... formatObjects) {
        List<Object> namelist = Lists.transform(Lists.newArrayList(formatObjects), new Function<Object, Object>() {
    
            @Override
            public Object apply(Object input) {
                if (input instanceof EObject) {
                    return NamingUtil.getGlobalNameOfNamedElement((EObject) input);
                }
                return input;
            }
        });
        return namelist;
    }

}