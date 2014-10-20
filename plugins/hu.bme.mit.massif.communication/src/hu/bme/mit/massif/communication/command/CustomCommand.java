/*******************************************************************************
 * Copyright (c) 2010-2013, Embraer S.A., Budapest University of Technology and Economics
 * All rights reserved. This program and the accompanying materials 
 * are made available under the terms of the Eclipse Public License v1.0 
 * which accompanies this distribution, and is available at 
 * http://www.eclipse.org/legal/epl-v10.html 
 *
 * Contributors: 
 *     Marton Bur, Abel Hegedus, Akos Horvath - initial API and implementation 
 *******************************************************************************/
package hu.bme.mit.massif.communication.command;

import hu.bme.mit.massif.communication.ICommandEvaluator;

/**
 * Command class representing any generic MATLAB command
 */
public class CustomCommand extends MatlabCommand {

    public String commandName;
    public int outputArgumentCount;

    public CustomCommand(ICommandEvaluator commandEvaluator) {
        super(commandEvaluator);
    }

    @Override
    public String getCommandName() {
        return commandName;
    }

    public void setCommandName(String commandName) {
        this.commandName = commandName;
    }

    @Override
    public int getOutputArgumentCount() {
        return outputArgumentCount;
    }

    public void setOutputArgumentCount(int oargcount) {
        this.outputArgumentCount = oargcount;
    }

}
