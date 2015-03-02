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

import java.util.Iterator;

import hu.bme.mit.massif.simulink.Block;
import hu.bme.mit.massif.simulink.Connection;
import hu.bme.mit.massif.simulink.IdentifierReference;
import hu.bme.mit.massif.simulink.LibraryLinkReference;
import hu.bme.mit.massif.simulink.MultiConnection;
import hu.bme.mit.massif.simulink.OutPort;
import hu.bme.mit.massif.simulink.Port;
import hu.bme.mit.massif.simulink.SimulinkElement;
import hu.bme.mit.massif.simulink.SimulinkFactory;
import hu.bme.mit.massif.simulink.SimulinkModel;
import hu.bme.mit.massif.simulink.SimulinkReference;
import hu.bme.mit.massif.simulink.SingleConnection;
import hu.bme.mit.massif.simulink.SubSystem;
import hu.bme.mit.massif.simulink.util.SimulinkSwitch;

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

    /**
     * Changes the qualifier of the element to the supplied FQN and also propagates this change on the qualifier tree.
     * 
     */
    public static void changeRootQualifier(SimulinkElement elem, String parentFQN) {
        elem.getSimulinkRef().setQualifier(parentFQN);
        String fqnOfRoot = elem.getSimulinkRef().getFQN();
        
        if(elem instanceof Block){
            for (Port port : ((Block) elem).getPorts()) {
                changeRootQualifier(port, fqnOfRoot);
            }
            if (elem instanceof SubSystem) {
                for(Block subBl : ((SubSystem)elem).getSubBlocks()){
                    changeRootQualifier(subBl, fqnOfRoot);
                }
            }
        } else if(elem instanceof SimulinkModel) {
            for (Block child : ((SimulinkModel) elem).getContains()) {
                changeRootQualifier(child, fqnOfRoot);
            }
        } else if (elem instanceof Port) {
            if(elem instanceof OutPort){
                Connection conn = ((OutPort) elem).getConnection();
                changeRootQualifier(conn, fqnOfRoot);
            }
        } else if (elem instanceof Connection) {
           if(elem instanceof MultiConnection){
               for (SingleConnection conn : ((MultiConnection) elem).getConnections()) {
                   changeRootQualifier(conn, fqnOfRoot);
               }
           }
        } else {
            throw new IllegalArgumentException("Cannot change root qualifier for element " + elem.getSimulinkRef().getFQN());
        }
    }
}