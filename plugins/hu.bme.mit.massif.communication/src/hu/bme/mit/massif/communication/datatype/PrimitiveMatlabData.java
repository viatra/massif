/*******************************************************************************
 * Copyright (c) 2010-2013, Embraer S.A., Budapest University of Technology and Economics
 * All rights reserved. This program and the accompanying materials 
 * are made available under the terms of the Eclipse Public License v1.0 
 * which accompanies this distribution, and is available at 
 * http://www.eclipse.org/legal/epl-v10.html 
 *
 * Contributors: 
 *     Marton Bur, Abel Hegedus, Akos Horvath - initial API and implementation 
 *******************************************************************************/
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
