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
package hu.bme.mit.massif.simulink.api.extension.impl;

import hu.bme.mit.massif.communication.command.MatlabCommandFactory;
import hu.bme.mit.massif.simulink.api.extension.IParameterImportFilter;

/**
 * 
 * Simple filter that filters no parameters.
 * 
 * @author Marton Bur
 *
 */
public class KeepAllParametersFilter implements IParameterImportFilter {

	@Override
	public String getName() {
		return "Keep all block parameters filter";
	}
	
	@Override
	public String getDescription() {
		return "Simple filter that filters no parameters.";
	}
	
	@Override
    public boolean filter(MatlabCommandFactory commandFactory, String parameterName) {
		return false;
	}

}
