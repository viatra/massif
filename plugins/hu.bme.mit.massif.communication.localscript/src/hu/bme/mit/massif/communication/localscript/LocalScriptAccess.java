/*******************************************************************************
 * Copyright (c) 2010-2017, LunkP, Peter Lunk
 * All rights reserved. This program and the accompanying materials 
 * are made available under the terms of the Eclipse Public License v1.0 
 * which accompanies this distribution, and is available at 
 * http://www.eclipse.org/legal/epl-v10.html 
 *
 * Contributors: 
 *     lunkpeter - initial API and implementation 
 *******************************************************************************/
package hu.bme.mit.massif.communication.localscript;

import java.util.UUID;

import br.com.embraer.massif.commandevaluation.commands.EvalCommand;
import br.com.embraer.massif.commandevaluation.commands.FevalCommand;
import br.com.embraer.massif.commandevaluation.commands.InteractionCommand;
import br.com.embraer.massif.commandevaluation.commands.MatlabController;
import br.com.embraer.massif.commandevaluation.exception.MatlabOutputException;
import hu.bme.mit.massif.communication.ICommandAccess;

public class LocalScriptAccess implements ICommandAccess{
    private final MatlabController controller;
    
    public LocalScriptAccess(MatlabController controller) {
        this.controller = controller;
    }
    
    @Override
    public Object[] executeFeval(String name, Object[] inputArgs, int numberOfOutputs) throws MatlabOutputException {
        InteractionCommand fevalCommand = new FevalCommand(numberOfOutputs, name, inputArgs);
        controller.addCommand(fevalCommand);
        
        Object[] returnOutput = null;
        if (numberOfOutputs > 0) {
            UUID idCommand = fevalCommand.getIdNumber();
            returnOutput = controller.getCommandOutput(idCommand);
        }
        
        return returnOutput;
    }

    @Override
    public Object[] executeEval(String command, int numberOfOutputs) throws MatlabOutputException {
        InteractionCommand evalCommand = new EvalCommand(numberOfOutputs, command);
        controller.addCommand(evalCommand);
        
        Object[] returnOutput = null;
        if (numberOfOutputs > 0) {
            UUID idCommand = evalCommand.getIdNumber();
            returnOutput = controller.getCommandOutput(idCommand);
        }
        
        return returnOutput;
    }
    
}