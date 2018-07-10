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

import br.com.embraer.massif.commandevaluation.commands.MatlabController;
import hu.bme.mit.massif.communication.AbstractCommandEvaluator;

/**
 * 
 * @author Peter Lunk
 *
 */
public class LocalScriptEvaluator extends AbstractCommandEvaluator<LocalScriptAccess> {
	
    public LocalScriptEvaluator(MatlabController controller) {
        super(new LocalScriptAccess(controller));
    }

}