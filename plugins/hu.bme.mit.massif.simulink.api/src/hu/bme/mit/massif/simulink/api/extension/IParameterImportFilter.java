/*******************************************************************************
 * Copyright (c) 2010-2018, IncQuery Labs Ltd., logi.cals GmbH, McGill University
 * All rights reserved. This program and the accompanying materials 
 * are made available under the terms of the Eclipse Public License v1.0 
 * which accompanies this distribution, and is available at 
 * http://www.eclipse.org/legal/epl-v10.html 
 *
 * Contributors: 
 *     Marton Bur - initial API and implementation 
 *******************************************************************************/
package hu.bme.mit.massif.simulink.api.extension;

import hu.bme.mit.massif.communication.command.MatlabCommandFactory;

/**
 * Interface that defines the filter for importing Simulink block parameters
 */
public interface IParameterImportFilter {

	
	/**
	 * @return the name of the filter
	 */
	String getName();
	
	/** 
	 * @return a short description for the filter implementation, and it is used as the tooltip text on the preference page
	 */
	String getDescription();
	
    /**
     * Determines if the parameter should be filtered from importing.
     * 
     * @param commandFactory
     *            the MATLAB command factory
     * @param parameterName
     *            the name of the parameter in question
     * @return true if the parameter should be ignored during import
     */
    boolean filter(MatlabCommandFactory commandFactory, String parameterName);

}
