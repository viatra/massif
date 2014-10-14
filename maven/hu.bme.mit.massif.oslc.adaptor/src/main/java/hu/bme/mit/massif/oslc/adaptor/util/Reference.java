package hu.bme.mit.massif.oslc.adaptor.util;

public class Reference<T> {
    T value;

    public Reference() {
        this(null);
    }

    public Reference(final T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public void setValue(final T value) {
        this.value = value;
    }
}
