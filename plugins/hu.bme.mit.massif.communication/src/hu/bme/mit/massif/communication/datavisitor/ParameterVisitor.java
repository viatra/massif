package hu.bme.mit.massif.communication.datavisitor;

import hu.bme.mit.massif.communication.datatype.CellMatlabData;
import hu.bme.mit.massif.communication.datatype.Handle;
import hu.bme.mit.massif.communication.datatype.MatlabString;
import hu.bme.mit.massif.communication.datatype.StructMatlabData;

import java.util.Arrays;

/**
 * Visitor implementation for command string creation
 */
public class ParameterVisitor implements IMatlabDataVisitor {

    // private MatlabCommand command;
    private String[] commandStrings;

    public String[] getCommandStrings() {
        return Arrays.copyOf(commandStrings, commandStrings.length);
    }

    public ParameterVisitor(String[] commandStrings) {
        this.commandStrings = Arrays.copyOf(commandStrings, commandStrings.length);
    }

    @Override
    public void visit(CellMatlabData compositeData) {
        if (compositeData.size() == 0) {
            return;
        }
        String[] newCommandStrings = new String[commandStrings.length * compositeData.getDatas().size()];
        for (int i = 0; i < commandStrings.length; i++) {
            for (int j = 0; j < compositeData.getDatas().size(); j++) {
                newCommandStrings[i * compositeData.getDatas().size() + j] = commandStrings[i]
                        + compositeData.getDatas().get(j) + ",";
            }
        }
        commandStrings = newCommandStrings;
    }

    @Override
    public void visit(Handle handle) {
        for (int i = 0; i < commandStrings.length; i++) {
            commandStrings[i] = commandStrings[i] + handle + ",";
        }
    }

    @Override
    public void visit(MatlabString matlabString) {
        for (int i = 0; i < commandStrings.length; i++) {
            commandStrings[i] = commandStrings[i] + matlabString + ",";
        }
    }

    @Override
    public void visit(StructMatlabData structMatlabData) {
        // TODO Unsupported operation? A struct should be created again using the given datas?
    }

}
