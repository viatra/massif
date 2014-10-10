package hu.bme.mit.transima.simulink.communication.command;

import hu.bme.mit.transima.simulink.communication.ICommandEvaluator;

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
