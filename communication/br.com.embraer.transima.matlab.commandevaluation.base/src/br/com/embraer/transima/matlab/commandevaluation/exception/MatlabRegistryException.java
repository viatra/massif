package br.com.embraer.transima.matlab.commandevaluation.exception;

/**
 * Exception related to errors on reading values from windows registry
 * 
 * @author ldnascim
 */
public class MatlabRegistryException extends MatlabException {

	/**
	 * generated UUID for this class 
	 */
	private static final long serialVersionUID = -6342226598091290417L;

	/**
	 * Constructor
	 * @param error Error code
	 * @param throwable Exception reference
	 */
	public MatlabRegistryException(MatlabError error, Throwable throwable) {
		super(error, throwable);
	}
}
