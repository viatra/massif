package hu.bme.mit.massif.communication.datatype;

import hu.bme.mit.massif.communication.datavisitor.IMatlabDataVisitor;

/**
 * Interface to represent data that is sent to and received from MATLAB
 */
public interface IVisitableMatlabData {
    public void acceptDataVisitor(IMatlabDataVisitor visitor);
}
