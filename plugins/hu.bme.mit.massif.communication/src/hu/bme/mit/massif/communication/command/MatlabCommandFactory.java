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
/**
 * 
 */
package hu.bme.mit.massif.communication.command;

import hu.bme.mit.massif.communication.ICommandEvaluator;

/**
 * @author Abel Hegedus
 *
 */
public class MatlabCommandFactory {

    private static final String GET_COMMAND_NAME = "get";
    private static final String GETFULLNAME_COMMAND_NAME = "getfullname";
    private static final String FILEPARTS_COMMAND_NAME = "fileparts";
    private static final String EXIST_COMMAND_NAME = "exist";
    private static final String RUN_COMMAND_NAME = "run";
    private static final String CD_COMMAND_NAME = "cd";
    private static final String CLOSE_SYSTEM_COMMAND_NAME = "close_system";
    private static final String SAVE_SYSTEM_COMMAND_NAME = "save_system";
    private static final String LOAD_SYSTEM_COMMAND_NAME = "load_system";
    private static final String FIND_SYSTEM_COMMAND_NAME = "find_system";
    private static final String NEW_SYSTEM_COMMAND_NAME = "new_system";
    private static final String ADD_PATH_COMMAND_NAME = "add_path";
    private static final String DELETE_LINE_COMMAND_NAME = "delete_line";
    private static final String ADD_LINE_COMMAND_NAME = "add_line";
    private static final String DELETE_BLOCK_COMMAND_NAME = "delete_block";
    private static final String ADD_BLOCK_COMMAND_NAME = "add_block";
    private static final String SET_PARAM_COMMAND_NAME = "set_param";
    private static final String GET_PARAM_COMMAND_NAME = "get_param";
	private static final String CLEAR_LAST_ERROR_MESSAGE_COMMAND_NAME = "MException.last('reset')";
	private static final String GET_LAST_ERROR_MESSAGE_COMMAND_NAME = "MException.last.message";
	

    private ICommandEvaluator commandEvaluator;

    public MatlabCommandFactory(ICommandEvaluator evaluator) {
        this.commandEvaluator = evaluator;
    }
    
    public ICommandEvaluator getCommandEvaluator(){
    	return commandEvaluator;
    }

    public MatlabCommand getParam() {
        return customCommand(GET_PARAM_COMMAND_NAME, 1);
    }

    public MatlabCommand setParam() {
        return customCommand(SET_PARAM_COMMAND_NAME, 0);
    }

    public MatlabCommand addBlock() {
        return customCommand(ADD_BLOCK_COMMAND_NAME, 1);
    }

    public MatlabCommand deleteBlock() {
        return customCommand(DELETE_BLOCK_COMMAND_NAME, 0);
    }

    public MatlabCommand addLine() {
        return customCommand(ADD_LINE_COMMAND_NAME, 1);
    }

    public MatlabCommand deleteLine() {
        return customCommand(DELETE_LINE_COMMAND_NAME, 0);
    }

    public MatlabCommand addPath() {
        return customCommand(ADD_PATH_COMMAND_NAME, 1);
    }

    public MatlabCommand newSytem() {
        return customCommand(NEW_SYSTEM_COMMAND_NAME, 1);
    }

    public MatlabCommand findSystem() {
        return customCommand(FIND_SYSTEM_COMMAND_NAME, 1);
    }

    public MatlabCommand loadSytem() {
        return customCommand(LOAD_SYSTEM_COMMAND_NAME, 0);
    }

    public MatlabCommand saveSystem() {
        return customCommand(SAVE_SYSTEM_COMMAND_NAME, 1);
    }

    public MatlabCommand closeSystem() {
        return customCommand(CLOSE_SYSTEM_COMMAND_NAME, 0);
    }

    public MatlabCommand cd() {
        return customCommand(CD_COMMAND_NAME, 1);
    }

    public MatlabCommand run() {
        return customCommand(RUN_COMMAND_NAME, 0);
    }

    public MatlabCommand exist() {
        return customCommand(EXIST_COMMAND_NAME, 1);
    }

    public MatlabCommand fileParts() {
        return customCommand(FILEPARTS_COMMAND_NAME, 3);
    }

    public MatlabCommand getFullName() {
        return customCommand(GETFULLNAME_COMMAND_NAME, 1);
    }

    public MatlabCommand get() {
        return customCommand(GET_COMMAND_NAME, 1);
    }

    public MatlabCommand clearLastErrorMessage() {
    	return customCommand(CLEAR_LAST_ERROR_MESSAGE_COMMAND_NAME, 0);
    }

    public MatlabCommand getLastErrorMessage() {
    	return customCommand(GET_LAST_ERROR_MESSAGE_COMMAND_NAME, 1);
    }

    public MatlabCommand customCommand(final String commandName, final int outputArgumentCount) {

        return new MatlabCommand(commandEvaluator) {

            @Override
            public int getOutputArgumentCount() {
                return outputArgumentCount;
            }

            @Override
            public String getCommandName() {
                return commandName;
            }
        };

    }
}
