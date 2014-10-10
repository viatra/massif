package br.com.embraer.transima.matlab.commandevaluation.exception;

/**
 * Exception class related to retrieving output from commands
 * 
 * @author ldnascim
 */
public class MatlabOutputException extends MatlabException {

	/**
	 * generated UUID for this class
	 */
	private static final long serialVersionUID = 1093976139223564223L;

	/**
	 * Constructor
	 * @param error Error code
	 * @param throwable Exception reference
	 */
	public MatlabOutputException(MatlabError error, Throwable throwable) {
		super(error, throwable);
	}
	
}
