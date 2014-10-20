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
