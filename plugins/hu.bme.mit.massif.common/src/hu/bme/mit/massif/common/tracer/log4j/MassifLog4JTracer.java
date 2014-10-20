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
package hu.bme.mit.massif.common.tracer.log4j;

import hu.bme.mit.massif.common.tracer.AbstractMassifTracer;
import hu.bme.mit.massif.common.tracer.MassifTracerOptions;

import java.util.List;

import org.apache.log4j.Logger;

public class MassifLog4JTracer extends AbstractMassifTracer {

    private final Logger logger;
    protected MassifLog4JTracer(MassifTracerOptions option, Logger logger) {
        super(option);
        this.logger = logger;
    }

    @Override
    public void trace(String formatMessage, Object... formatObjects) {
        if (tracingEnabled) {
            List<Object> namelist = transformNameList(formatObjects);
            logger.trace(String.format(option + " >> " + formatMessage, namelist.toArray()));
        }
    }
}
