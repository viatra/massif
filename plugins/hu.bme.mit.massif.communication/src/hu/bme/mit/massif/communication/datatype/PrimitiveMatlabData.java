package hu.bme.mit.massif.communication.datatype;

/**
 * This class represents a single valued data from MATLAB
 * 
 * @param <T>
 *            the java type of the represented MATLAB data
 */
public abstract class PrimitiveMatlabData<T> implements IVisitableMatlabData {

    protected T data;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    // TODO revisit escaping of characters
    public abstract String toString();

}
