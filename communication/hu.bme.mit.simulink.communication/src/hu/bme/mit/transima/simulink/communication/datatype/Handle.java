package hu.bme.mit.transima.simulink.communication.datatype;

import hu.bme.mit.transima.simulink.communication.datavisitor.IMatlabDataVisitor;

/**
 * This class represents the handle of objects in MATLAB. For now this class also represents double values.
 */
public class Handle extends PrimitiveMatlabData<Double> {

    public Handle() {
    }

    public Handle(double data) {
        this.data = data;
    }

    public static Handle asHandle(IVisitableMatlabData data) {
        return (Handle) data;
    }

    public static Double getHandleData(IVisitableMatlabData data) {
        return ((Handle) data).data;
    }

    @Override
    public void acceptDataVisitor(IMatlabDataVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public String toString() {
        return data.toString();
    }

}
