/*******************************************************************************
 * Copyright (c) 2010-2018, IncQuery Labs Ltd.
 * All rights reserved. This program and the accompanying materials 
 * are made available under the terms of the Eclipse Public License v1.0 
 * which accompanies this distribution, and is available at 
 * http://www.eclipse.org/legal/epl-v10.html 
 *
 * Contributors: 
 *     Barnabás Reischl - initial API and implementation 
 *******************************************************************************/
package hu.bme.mit.massif.simulink.cli.localscript;

import br.com.embraer.massif.commandevaluation.commands.MatlabController;
import hu.bme.mit.massif.communication.AbstractCommandEvaluator;
import hu.bme.mit.massif.communication.ICommandAccess;
import hu.bme.mit.massif.communication.ICommandEvaluator;
import hu.bme.mit.massif.communication.localscript.LocalScriptAccess;
import hu.bme.mit.massif.simulink.cli.CLIMatlabCreator;

/**
 * @author Barnabás Reischl
 *
 */
public class LocalScriptCLIMatlabCreator extends CLIMatlabCreator {
    
    @Override
    public ICommandEvaluator getEvaluator() {
        return new AbstractCommandEvaluator<ICommandAccess>(new LocalScriptAccess(new MatlabController()));
    }
}

