package hu.bme.mit.transima.simulink.communication.datatype;

import hu.bme.mit.transima.simulink.communication.datavisitor.IMatlabDataVisitor;

/**
 * Interface to represent data that is sent to and received from MATLAB
 */
public interface IVisitableMatlabData {
    public void acceptDataVisitor(IMatlabDataVisitor visitor);
}
