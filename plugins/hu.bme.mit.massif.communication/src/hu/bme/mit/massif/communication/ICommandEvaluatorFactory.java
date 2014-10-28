/*******************************************************************************
 * Copyright (c) 2010, 2014, Embraer S.A., Budapest University of Technology and Economics
 * All rights reserved. This program and the accompanying materials 
 * are made available under the terms of the Eclipse Public License v1.0 
 * which accompanies this distribution, and is available at 
 * http://www.eclipse.org/legal/epl-v10.html 
 *
 * Contributors: 
 *     Abel Hegedus - initial API and implementation 
 *******************************************************************************/
package hu.bme.mit.massif.communication;

import java.util.Map;

public interface ICommandEvaluatorFactory {

	/**
     * Create the command evaluator object.
     * 
     * @param parameters a map containing the required parameters for the connection to the MATLAB session
     * @return the object with the ICommandEvaluator interface
     */
	public ICommandEvaluator createCommandEvaluator(Map<String, Object> parameters) throws ConnectorCreationException;
	
	public String getConnectorName();
	
}