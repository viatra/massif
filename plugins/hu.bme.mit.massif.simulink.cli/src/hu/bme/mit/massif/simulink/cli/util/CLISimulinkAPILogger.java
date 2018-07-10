/*******************************************************************************
 * Copyright (c) 2010-2017, IncQueryLabs Ltd.
 * All rights reserved. This program and the accompanying materials 
 * are made available under the terms of the Eclipse Public License v1.0 
 * which accompanies this distribution, and is available at 
 * http://www.eclipse.org/legal/epl-v10.html 
 *
 * Contributors: 
 *     Peter Lunk - initial API and implementation 
 *******************************************************************************/
package hu.bme.mit.massif.simulink.cli.util;

import hu.bme.mit.massif.simulink.api.util.ISimulinkAPILogger;

/**
 * @author Peter Lunk
 *
 */
public class CLISimulinkAPILogger implements ISimulinkAPILogger {

    @Override
    public void error(String message) {
        System.out.println(message);
    }

    @Override
    public void error(String message, Throwable cause) {
        System.out.println(message);
        System.out.println(cause.getMessage());
    }

    @Override
    public void warning(String message) {
        System.out.println(message);
    }

    @Override
    public void debug(String message) {
        System.out.println(message);
    }

    @Override
    public boolean isDebugging() {
        return false;
    }

}
