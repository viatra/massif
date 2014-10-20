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

import hu.bme.mit.massif.common.MassifCommonPlugin;
import hu.bme.mit.massif.common.tracer.IMassifTracer;
import hu.bme.mit.massif.common.tracer.MassifTracerManager;
import hu.bme.mit.massif.common.tracer.MassifTracerOptions;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.osgi.framework.BundleContext;

public class MassifLog4JTracerManager extends MassifTracerManager {
    public MassifLog4JTracerManager(BundleContext context) {
        super(context);
    }

    @Override
    protected IMassifTracer createTracer(MassifTracerOptions option) {
        IMassifTracer tracer;
        Logger logger = Logger.getLogger(MassifCommonPlugin.class);
        logger.setLevel(Level.TRACE);
        tracer = new MassifLog4JTracer(option, logger);
        return tracer;
    }
}