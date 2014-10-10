package br.com.embraer.transima.matlab.commandevaluation.util;

import java.io.IOException;
import java.io.Serializable;
import java.net.Socket;
import java.rmi.server.RMIClientSocketFactory;

/**
 * 
 * Custom client socket factory that creates time limited sockets. If the given time limit is reached, an exception is
 * thrown indicating the timeout.
 * 
 * @author transima
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
