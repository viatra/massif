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
