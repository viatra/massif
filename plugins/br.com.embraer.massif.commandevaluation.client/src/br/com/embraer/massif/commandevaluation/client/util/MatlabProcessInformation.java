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
package br.com.embraer.massif.commandevaluation.client.util;

/**
 * DTO(data transfer object) class used to hold information about the
 * current running matlab processes
 * 
 * @author ldnascim
 */
public class MatlabProcessInformation {
	public String path = "";
	public int pid = 0;
	public String release = "";
	public boolean is32bits;
	
	/**
	 * If path, pid or release are empty, then the instance has no proper
	 * information about a Matlab process
	 * 
	 * @return True if neither path, pid nor release are empty
	 */
	public boolean isEmpty() {
		return (pid == 0) || (path.isEmpty())|| (release.isEmpty());
	}
}