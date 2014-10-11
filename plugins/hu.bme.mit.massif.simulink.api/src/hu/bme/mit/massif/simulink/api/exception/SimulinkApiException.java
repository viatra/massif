package hu.bme.mit.massif.simulink.api.exception;

/**
 * The exception class for the API
 * 
 * TODO change supertype
 */
public class SimulinkApiException extends Exception {

    /**
     * Default serial version ID
     */
    private static final long serialVersionUID = 1L;

    /**
     * Constructor for throwing exception with a single message
     * 
     * @param msg
     *            the message to be sent
     */
    public SimulinkApiException(String msg) {
        super(msg);
    }

    /**
     * Constructor to wrap up exceptions durint import/export
     * 
     * @param msg
     *            a string message
     * @param e
     *            the cause of this exception
     */
    public SimulinkApiException(String msg, Throwable e) {
        super(msg, e);
    }

}
