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
