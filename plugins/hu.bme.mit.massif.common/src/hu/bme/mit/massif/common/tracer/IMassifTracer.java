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

public interface IMassifTracer {

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
    public MassifTracerOptions getOption();

    /**
     * NOTE: {@link #trace(String, Object...)} can be called without checking the value returned by this method!
     * 
     * @return
     */
    public boolean isTracingEnabled();

    void setTracingEnabled(boolean tracingEnabled);

}
