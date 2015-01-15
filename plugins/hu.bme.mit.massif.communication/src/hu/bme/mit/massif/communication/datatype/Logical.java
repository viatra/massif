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

import hu.bme.mit.massif.communication.datavisitor.IMatlabDataVisitor;

/**
 * This class represents the handle of objects in MATLAB. For now this class also represents double values.
 */
public class Logical extends PrimitiveMatlabData<Boolean> {

    public Logical() {
    }

    public Logical(Boolean data) {
        this.data = data;
    }

    public static Logical asHandle(IVisitableMatlabData data) {
        return (Logical) data;
    }

    public static Boolean getLogicalData(IVisitableMatlabData data) {
        return ((Logical) data).data;
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
