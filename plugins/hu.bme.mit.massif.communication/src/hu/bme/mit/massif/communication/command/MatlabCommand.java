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
package hu.bme.mit.massif.communication.command;

import hu.bme.mit.massif.communication.CommandEvaluationException;
import hu.bme.mit.massif.communication.ICommandEvaluator;
import hu.bme.mit.massif.communication.datatype.Handle;
import hu.bme.mit.massif.communication.datatype.IVisitableMatlabData;
import hu.bme.mit.massif.communication.datatype.MatlabString;
import hu.bme.mit.massif.communication.datavisitor.ParameterVisitor;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * This class holds the general MATLAB command execution logic.
 * 
 * When subclassing, please consider the following naming conventions:
 * 
 * (1) A class representing a MATLAB command should have a name that refers to the original command in MATLAB
 * 
 * (2) All class names in Java should begin with a capital letter
 * 
 * (3) In MATLAB some command names contain underscore (the character '_'). Instead of underscore, use a capital letter
 * in the word preceded by the underscore.
 * 
 * Examples: the command get_param is represented by the class GetParam, and fileparts is represented by Fileparts
 */
public abstract class MatlabCommand {

    protected List<IVisitableMatlabData> params;
    protected String[] commandStrings;
    private ICommandEvaluator commandEvaluator;

    // private MatlabClient matlabClient;

    public MatlabCommand(/* MatlabClient matlabClient */ICommandEvaluator commandEvaluator) {
        this.params = new LinkedList<IVisitableMatlabData>();
        // this.matlabClient = matlabClient;
        this.commandEvaluator = commandEvaluator;
    }

    public void removeParams() {
        params = new LinkedList<IVisitableMatlabData>();
    }

    public MatlabCommand addParam(String param) {
        this.params.add(new MatlabString(param));
        return this;
    }

    public MatlabCommand addParam(Double param) {
        this.params.add(new Handle(param));
        return this;
    }

    public MatlabCommand addParam(IVisitableMatlabData param) {
        this.params.add(param);
        return this;
    }

    public MatlabCommand addParam(List<IVisitableMatlabData> params) {
        this.params.addAll(params);
        return this;
    }

    public MatlabCommand setParam(int idx, IVisitableMatlabData param) {
        params.set(idx, param);
        return this;
    }

    public List<IVisitableMatlabData> getCurrentParams() {
        return this.params;
    }

    public String[] getCommandStrings() {
        compileCommandStrings();
        return Arrays.copyOf(commandStrings, commandStrings.length);
    }

    /**
     * Execute the represented command
     * 
     * @return the IVisistalbeMatlabData object containing the returned data
     * @throws CommandEvaluationException if an unexpected error occurred during execution of the command
     */
    public final IVisitableMatlabData execute() {
        compileCommandStrings();
        // Executing command
        return commandEvaluator.evaluateCommands(commandStrings, getOutputArgumentCount());
    }

    /**
     * Compile command strings based on the current command parameters
     */
    private void compileCommandStrings() {
        if (params.size() > 0) {

            commandStrings = new String[] { this.getCommandName() + "(" };
            ParameterVisitor parameterVisitor = new ParameterVisitor(commandStrings);
            for (IVisitableMatlabData data : params) {
                data.acceptDataVisitor(parameterVisitor);
            }
            commandStrings = parameterVisitor.getCommandStrings();
            for (int i = 0; i < commandStrings.length; i++) {
                commandStrings[i] = commandStrings[i].replaceAll(",$", ""); // remove the last unnecessary comma
                commandStrings[i] = commandStrings[i] + ")";
            }

        } else {
            commandStrings = new String[] { this.getCommandName() };
        }
    }

    /**
     * Gets the command (or function) name used in MATLAB
     * 
     * @return the command name used in MATLAB
     */
    public abstract String getCommandName();

    /**
     * Gets the number of output arguments of the command. In MATLAB the number of expected output arguments can change
     * the behavior of a command (or function).
     * 
     * @return the number of expected output arguments
     */
    public abstract int getOutputArgumentCount();

}
