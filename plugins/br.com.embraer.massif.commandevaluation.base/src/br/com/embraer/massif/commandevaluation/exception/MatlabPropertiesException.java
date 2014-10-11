package br.com.embraer.massif.commandevaluation.exception;

/**
 * Exception class related to errors on handling matlab configuration
 * properties file
 * 
 * @author ldnascim
 */
public class MatlabPropertiesException extends MatlabException {

	/**
	 * generated UUID for this class 
	 */
	private static final long serialVersionUID = 7366292090813695647L;

	/**
	 * Constructor
	 * @param error Error code
	 * @param throwable Exception reference
	 */
	public MatlabPropertiesException(MatlabError error, Throwable throwable) {
		super(error, throwable);
	}
}
