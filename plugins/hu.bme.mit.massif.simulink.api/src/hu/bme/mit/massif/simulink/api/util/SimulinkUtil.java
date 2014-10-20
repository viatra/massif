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
package hu.bme.mit.massif.simulink.api.util;

import hu.bme.mit.massif.simulink.IdentifierReference;
import hu.bme.mit.massif.simulink.LibraryLinkReference;
import hu.bme.mit.massif.simulink.SimulinkElement;
import hu.bme.mit.massif.simulink.SimulinkFactory;
import hu.bme.mit.massif.simulink.SimulinkReference;

public class SimulinkUtil {

    /**
     * Returns a copy of the SimulinkReference of the given SimulinkElement
     */
    public static IdentifierReference createIdentifierReference(SimulinkElement slELem) {
        return createIdentifierReference(slELem.getSimulinkRef());
    }

    public static IdentifierReference createIdentifierReference(IdentifierReference slRef) {
        IdentifierReference ref = createIdentifierReference(slRef.getName(), slRef.getQualifier());
        return ref;
    }

    public static IdentifierReference createIdentifierReference(String name, String qualifier) {
        IdentifierReference ref = SimulinkFactory.eINSTANCE.createIdentifierReference();
        setNameAndQualifierForReference(name, qualifier, ref);
        return ref;
    }

    public static LibraryLinkReference createLinkReference(SimulinkElement slElem) {
        return createLinkReference(slElem.getSimulinkRef());
    }

    public static LibraryLinkReference createLinkReference(SimulinkReference ref) {
        return createLinkReference(ref.getName(), ref.getQualifier());
    }

    public static LibraryLinkReference createLinkReference(String name, String qualifier) {
        LibraryLinkReference ref = SimulinkFactory.eINSTANCE.createLibraryLinkReference();
        setNameAndQualifierForReference(name, qualifier, ref);
        return ref;
    }

    public static IdentifierReference createChildIdentifierReference(SimulinkElement slElem, String childName) {
        IdentifierReference parentRef = slElem.getSimulinkRef();
        IdentifierReference ref = createChildIdentifierReference(parentRef, childName);
        return ref;
    }

    public static IdentifierReference createChildIdentifierReference(IdentifierReference parentRef, String childName) {
        IdentifierReference ref = createIdentifierReference(childName, parentRef.getFQN());
        return ref;
    }

    public static void setNameAndQualifierOfElementForReference(SimulinkElement fromElem, SimulinkReference toRef) {
        setNameAndQualifierForReference(fromElem.getSimulinkRef(), toRef);
    }

    public static void setNameAndQualifierForReference(SimulinkReference fromRef, SimulinkReference toRef) {
        String name = fromRef.getName();
        String qualifier = fromRef.getQualifier();
        setNameAndQualifierForReference(name, qualifier, toRef);
    }

    public static void setNameAndQualifierForReference(String name, String qualifier, SimulinkReference toRef) {
        toRef.setName(name);
        toRef.setQualifier(qualifier);
    }

}