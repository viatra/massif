package br.com.embraer.transima.matlab.commandevaluation.exception;

/**
 * Exception class related to errors when connecting and interacting with
 * the matlab RMI server
 * 
 * @author ldnascim
 */
public class MatlabRMIException extends MatlabException {

	/**
	 * generated UUID for this class
	 */
	private static final long serialVersionUID = 9141780809540321070L;
	
	/**
	 * Constructor
	 * @param error Error code
	 * @param throwable Exception reference
	 */
	public MatlabRMIException(MatlabError error, Throwable throwable) {
		super(error, throwable);
	}
}
