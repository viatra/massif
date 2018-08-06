/*******************************************************************************
 * Copyright (c) 2010-2017, IncQueryLabs Ltd.
 * All rights reserved. This program and the accompanying materials 
 * are made available under the terms of the Eclipse Public License v1.0 
 * which accompanies this distribution, and is available at 
 * http://www.eclipse.org/legal/epl-v10.html 
 *
 * Contributors: 
 *     Peter Lunk - initial API and implementation 
 *******************************************************************************/
package hu.bme.mit.massif.communication.localscript;

import java.util.Map;

import br.com.embraer.massif.commandevaluation.commands.MatlabController;
import hu.bme.mit.massif.communication.ICommandEvaluator;
import hu.bme.mit.massif.communication.ICommandEvaluatorFactory;

/**
 * 
 * @author Peter Lunk
 *
 */
public class LocalScriptEvaluatorFactory implements ICommandEvaluatorFactory {

	private LocalScriptEvaluator evaluator;

    @Override
	public ICommandEvaluator createCommandEvaluator(
			Map<String, Object> parameters) {
	    if(evaluator == null) {
	        evaluator = new LocalScriptEvaluator(new MatlabController());	        
	    }
        return evaluator;
	}

	@Override
	public String getConnectorName() {
		return "LocalScript";
	}

}
