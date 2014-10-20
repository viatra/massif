/*******************************************************************************
 * Copyright (c) 2010-2013, Embraer S.A., Budapest University of Technology and Economics
 * All rights reserved. This program and the accompanying materials 
 * are made available under the terms of the Eclipse Public License v1.0 
 * which accompanies this distribution, and is available at 
 * http://www.eclipse.org/legal/epl-v10.html 
 *
 * Contributors: 
 *     Rodrigo Rizzi Starr, Lincoln Nascimento - initial API and implementation 
 *******************************************************************************/
package br.com.embraer.massif.commandevaluation.util;

import java.io.IOException;
import java.io.Serializable;
import java.net.Socket;
import java.rmi.server.RMIClientSocketFactory;

/**
 * 
 * Custom client socket factory that creates time limited sockets. If the given time limit is reached, an exception is
 * thrown indicating the timeout.
 * 
 * @author Marton Bur
 * 
 */
public class TimeLimitedClientSocketFactory implements RMIClientSocketFactory, Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * The default timeout time
     */
    public static final int DEFAULT_TIMEOUT_TIME = 30000;

    private int timeoutTime = DEFAULT_TIMEOUT_TIME;

    /**
     * Gets the currently set timeout time for the client sockets
     */
    public int getTimeoutTime() {
        return timeoutTime;
    }

    /**
     * Sets the timeout time for the client sockets
     * 
     * @param timeoutTime
     *            the desired timeout time in milliseconds. Call has no effect if the new value is less then or equals 0
     */
    public void setTimoutTime(int timeoutTime) {
        if (timeoutTime <= 0)
            return;
        this.timeoutTime = timeoutTime;
    }

    @Override
    public Socket createSocket(String host, int port) throws IOException {
        Socket socket = new Socket(host, port);
        // Set the timeout time
        socket.setSoTimeout(timeoutTime);
        socket.setSoLinger(false, 0);
        return socket;
    }

}
