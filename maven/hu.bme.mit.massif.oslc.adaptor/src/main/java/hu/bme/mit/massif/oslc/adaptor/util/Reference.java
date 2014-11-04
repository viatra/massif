/*******************************************************************************
 * Copyright (c) 2010-2013, Embraer S.A., Budapest University of Technology and Economics
 * All rights reserved. This program and the accompanying materials 
 * are made available under the terms of the Eclipse Public License v1.0 
 * which accompanies this distribution, and is available at 
 * http://www.eclipse.org/legal/epl-v10.html 
 *
 * Contributors: 
 *     Robert Doczi, Akos Horvath - initial API and implementation 
 *******************************************************************************/
package hu.bme.mit.massif.oslc.adaptor.util;

/**
 * This utility class is a basic container for any non primitive data. It is used to imitate
 * C++ like pass by reference and C# like ref parameter.
 * 
 * @author Dóczi Róbert
 *
 * @param <T> The type of the non primitive data contained.
 */
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
