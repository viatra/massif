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
package hu.bme.mit.massif.common;

import hu.bme.mit.massif.common.tracer.IMassifTracer;
import hu.bme.mit.massif.common.tracer.MassifTracerManager;
import hu.bme.mit.massif.common.tracer.MassifTracerOptions;
import hu.bme.mit.massif.common.tracer.log4j.MassifLog4JTracerManager;

import org.eclipse.core.runtime.Plugin;
import org.osgi.framework.BundleContext;

public class MassifCommonPlugin extends Plugin {

    // The plug-in ID
    public static final String PLUGIN_ID = "hu.bme.mit.massif.common"; //$NON-NLS-1$

    // The shared instance
    private static MassifCommonPlugin plugin;

    private MassifTracerManager tracerManager;

    /**
     * The constructor
     */
    public MassifCommonPlugin() {
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext)
     */
    @Override
    public void start(BundleContext context) throws Exception {
        super.start(context);
        plugin = this;
        tracerManager = new MassifLog4JTracerManager(context);
        // tracerManager = new massifOSGITracerManager(context);

    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext)
     */
    @Override
    public void stop(BundleContext context) throws Exception {
        plugin = null;
        tracerManager.dispose();
        tracerManager = null;
        super.stop(context);
    }

    /**
     * Returns the shared instance
     * 
     * @return the shared instance
     */
    public static MassifCommonPlugin getDefault() {
        return plugin;
    }

    public IMassifTracer getTracer(MassifTracerOptions option) {
        return tracerManager.getTracer(option);
    }
}
