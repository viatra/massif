package hu.bme.mit.massif.communication.datatype;

import hu.bme.mit.massif.communication.datavisitor.IMatlabDataVisitor;

/**
 * This class represents a string in MATLAB
 */
public class MatlabString extends PrimitiveMatlabData<String> {

    public MatlabString() {
    }

    @Override
    public String getData() {
        return data.replaceAll("\\n", " ");
    }
    
    public MatlabString(String data) {
        this.data = data.replaceAll("\\n", " ");
    }

    public static MatlabString asMatlabString(IVisitableMatlabData data) {
        return (MatlabString) data;
    }

    public static String getMatlabStringData(IVisitableMatlabData data) {
        return ((MatlabString) data).data.replaceAll("\\n", " ");
    }

    @Override
    public void acceptDataVisitor(IMatlabDataVisitor visitor) {
        visitor.visit(this);
    }

    // TODO revisit escaping of characters
    @Override
    public String toString() {
        // the string "/" is not always has to be escaped, this case has to be handled differently
        return "'" + data.replaceAll("'", "''").replace('\n', ' ') + "'";
    }

}
