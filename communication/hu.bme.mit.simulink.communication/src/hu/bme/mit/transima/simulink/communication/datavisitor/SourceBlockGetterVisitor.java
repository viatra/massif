package hu.bme.mit.transima.simulink.communication.datavisitor;

import hu.bme.mit.transima.simulink.communication.datatype.CellMatlabData;
import hu.bme.mit.transima.simulink.communication.datatype.Handle;
import hu.bme.mit.transima.simulink.communication.datatype.IVisitableMatlabData;
import hu.bme.mit.transima.simulink.communication.datatype.MatlabString;
import hu.bme.mit.transima.simulink.communication.datatype.StructMatlabData;

public class SourceBlockGetterVisitor implements IMatlabDataVisitor {

    private String sourceBlockFQN;

    public String getSourceBlockFQN() {
        return sourceBlockFQN;
    }

    @Override
    public void visit(CellMatlabData compositeData) {
        // Multiple blocks were found with the specified type
        // TODO not sure, if the first match is the best
        for (IVisitableMatlabData fqn : compositeData.getDatas()) {
            if (!fqn.toString().contains("Commonly Used Blocks")) {
                sourceBlockFQN = MatlabString.getMatlabStringData(fqn);
                break;
            }
        }
    }

    @Override
    public void visit(Handle handle) {
        // TODO Get name for handle
        throw new UnsupportedOperationException("Not yet implemented!");
    }

    @Override
    public void visit(MatlabString matlabString) {
        // It is a single block
        // If it is not from the commonly used blocks lib, set it as source
        if (!matlabString.getData().contains("Commonly Used Blocks")) {
            sourceBlockFQN = matlabString.getData();
        }
    }

    @Override
    public void visit(StructMatlabData structMatlabData) {
        // TODO Unsupported operation?
        throw new UnsupportedOperationException("Not yet implemented!");
    }
}
