package hu.bme.mit.transima.simulink.communication.datavisitor;

import hu.bme.mit.transima.simulink.communication.datatype.CellMatlabData;
import hu.bme.mit.transima.simulink.communication.datatype.Handle;
import hu.bme.mit.transima.simulink.communication.datatype.MatlabString;
import hu.bme.mit.transima.simulink.communication.datatype.StructMatlabData;

/**
 * Visitor interface for the MATLAB data types
 */
public interface IMatlabDataVisitor {
    public void visit(CellMatlabData compositeData);

    public void visit(Handle handle);

    public void visit(MatlabString matlabString);

    public void visit(StructMatlabData structMatlabData);
}
