/*******************************************************************************
 * Copyright (c) 2010, 2014, Embraer S.A., Budapest University of Technology and Economics
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
 * TODO
 * 
 * (The successor class of BasicOperationsApi utility class)
 */
public class LocalScriptEvaluator extends AbstractCommandEvaluator<LocalScriptAccess> {
	
    public LocalScriptEvaluator() {
        super(new LocalScriptAccess(new MatlabController()));
    }

}