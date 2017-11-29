/*******************************************************************************
 * Copyright (c) 2010-2017, LunkP, Peter Lunk
 * All rights reserved. This program and the accompanying materials 
 * are made available under the terms of the Eclipse Public License v1.0 
 * which accompanies this distribution, and is available at 
 * http://www.eclipse.org/legal/epl-v10.html 
 *
 * Contributors: 
 *     lunkpeter - initial API and implementation 
 *******************************************************************************/
package hu.bme.mit.massif.simulink.cli.util;

import hu.bme.mit.massif.simulink.api.util.ISimulinkAPILogger;

/**
 * @author lunkpeter
 *
 */
public class CLISimulinkAPILogger implements ISimulinkAPILogger {

    /* (non-Javadoc)
     * @see hu.bme.mit.massif.simulink.api.util.ISimulinkAPILogger#error(java.lang.String)
     */
    @Override
    public void error(String message) {
        System.out.println(message);
    }

    /* (non-Javadoc)
     * @see hu.bme.mit.massif.simulink.api.util.ISimulinkAPILogger#error(java.lang.String, java.lang.Throwable)
     */
    @Override
    public void error(String message, Throwable cause) {
        System.out.println(message);
        System.out.println(cause.getMessage());
    }

    /* (non-Javadoc)
     * @see hu.bme.mit.massif.simulink.api.util.ISimulinkAPILogger#warning(java.lang.String)
     */
    @Override
    public void warning(String message) {
        System.out.println(message);
    }

    /* (non-Javadoc)
     * @see hu.bme.mit.massif.simulink.api.util.ISimulinkAPILogger#debug(java.lang.String)
     */
    @Override
    public void debug(String message) {
        System.out.println(message);
    }

    /* (non-Javadoc)
     * @see hu.bme.mit.massif.simulink.api.util.ISimulinkAPILogger#isDebugging()
     */
    @Override
    public boolean isDebugging() {
        return false;
    }

}
