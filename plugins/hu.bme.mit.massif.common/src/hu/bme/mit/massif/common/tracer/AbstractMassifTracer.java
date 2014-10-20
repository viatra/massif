/*******************************************************************************
 * Copyright (c) 2010-2013, Embraer S.A., Budapest University of Technology and Economics
 * All rights reserved. This program and the accompanying materials 
 * are made available under the terms of the Eclipse Public License v1.0 
 * which accompanies this distribution, and is available at 
 * http://www.eclipse.org/legal/epl-v10.html 
 *
 * Contributors: 
 *     Abel Hegedus - initial API and implementation 
 *******************************************************************************/
package hu.bme.mit.massif.common.tracer;

import hu.bme.mit.massif.common.NamingUtil;

import java.util.List;

import org.eclipse.emf.ecore.EObject;

import com.google.common.base.Function;
import com.google.common.collect.Lists;


public abstract class AbstractMassifTracer implements IMassifTracer {

    protected final MassifTracerOptions option;
    protected boolean tracingEnabled = false;

    public AbstractMassifTracer(MassifTracerOptions option) {
        this.option = option;
    }

    @Override
    public MassifTracerOptions getOption() {
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