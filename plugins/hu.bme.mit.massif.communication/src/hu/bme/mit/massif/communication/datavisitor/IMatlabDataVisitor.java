package hu.bme.mit.massif.communication.datavisitor;

import hu.bme.mit.massif.communication.datatype.CellMatlabData;
import hu.bme.mit.massif.communication.datatype.Handle;
import hu.bme.mit.massif.communication.datatype.MatlabString;
import hu.bme.mit.massif.communication.datatype.StructMatlabData;

/**
 * Visitor interface for the MATLAB data types
 */
public interface IMatlabDataVisitor {
    public void visit(CellMatlabData compositeData);

    public void visit(Handle handle);

    public void visit(MatlabString matlabString);

    public void visit(StructMatlabData structMatlabData);
}
