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
package br.com.embraer.massif.commandevaluation.exception;

import java.util.HashMap;
import java.util.Map;

/**
 * Class for handling errors thrown in the code
 * 
 * @author ldnascim
 */
public abstract class MatlabException extends Exception {

	/**
	 * generated UUID for this class
	 */
	private static final long serialVersionUID = -6078896145108250561L;

	/** Error code and description **/
	private MatlabError error;
	
	/** Throwable object referencing the original exception, if any **/
	private Throwable throwable;
	
	/** Additional information for the exception **/
	private Map<String, Object> additionalInfoMap;
	
	/**
	 * Constructor
	 * @param error MatlabError referencing error type
	 * @param throwable Throwable object to the original exception, if any
	 */
	public MatlabException(MatlabError error, Throwable throwable) {
		super();
		this.error = error;
		this.throwable = throwable;
		this.additionalInfoMap = new HashMap<String, Object>();
	}
	
	/**
	 * Returns the MatlabError object
	 * @return
	 */
	public MatlabError getError() {
		return this.error;
	}
	
	/**
	 * Sets additional information that could be useful for
	 * debugging the exception cause
	 * @param key Information identifier
	 * @param value Information content
	 */
	public void set(String key, Object value) {
		this.additionalInfoMap.put(key, value);
	}
	
	/**
	 * Makes possible to the user can read an expected additional
	 * information from the exception  
	 * @param key Information identifier
	 * @return Information content
	 */
	public Object get(String key) {
		return this.additionalInfoMap.get(key);
	}
	
	/**
	 * Returns the original exception, if any
	 * @return original exception
	 */
	public Throwable getOriginalException() {
		return throwable;
	}
	
	@Override
	public String toString() {
		StringBuilder exceptionTrace = new StringBuilder();
		exceptionTrace.append("\n" + this.error.getCode() + ": " + this.error.getDescription() + 
				" \nAdditional information:\n" + this.additionalInfoMap);
		
		// appends original exception, if any
		if (throwable != null) {
			exceptionTrace.append("\n---------------------\n");
			exceptionTrace.append("Original exception: \n" + throwable.toString());
		}
		
		return exceptionTrace.toString();
	}
}
