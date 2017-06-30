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
package hu.bme.mit.massif.simulink.api.provider.block;

import hu.bme.mit.massif.simulink.Block;
import hu.bme.mit.massif.simulink.LibraryLinkReference;
import hu.bme.mit.massif.simulink.SimulinkPackage;
import hu.bme.mit.massif.simulink.api.util.SimulinkUtil;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EClass;

public enum SourceBlockProvider {

    INSTANCE;

    private static final String PORTS_AND_SUBSYSTEMS = "simulink/Ports & Subsystems";
    private static final String SIGNAL_ROUTING = "simulink/Signal Routing";

    private static final String OUTPORT = "Out1";
    private static final String INPORT = "In1";
    private static final String ENABLE = "Enable";
    private static final String TRIGGER = "Trigger";
    private static final String MODEL_REFERENCE = "Model";
    private static final String SUBSYSTEM = "Subsystem";

    private static final String GOTO = "Goto";
    private static final String FROM = "From";
    private static final String GOTO_TAG = "Goto Tag Visibility";
    private static final String BUS_CREATOR = "Bus Creator";
    private static final String BUS_SELECTOR = "Bus Selector";

    private Map<EClass, String> sourceBlockQualifiers;
    private Map<EClass, String> sourceBlockNames;
    
    private SourceBlockProvider() {
        sourceBlockQualifiers = new HashMap<EClass, String>();
        sourceBlockQualifiers.put(SimulinkPackage.Literals.OUT_PORT_BLOCK, PORTS_AND_SUBSYSTEMS);
        sourceBlockQualifiers.put(SimulinkPackage.Literals.IN_PORT_BLOCK, PORTS_AND_SUBSYSTEMS);
        sourceBlockQualifiers.put(SimulinkPackage.Literals.ENABLE_BLOCK, PORTS_AND_SUBSYSTEMS);
        sourceBlockQualifiers.put(SimulinkPackage.Literals.TRIGGER_BLOCK, PORTS_AND_SUBSYSTEMS);
        sourceBlockQualifiers.put(SimulinkPackage.Literals.MODEL_REFERENCE, PORTS_AND_SUBSYSTEMS);
        sourceBlockQualifiers.put(SimulinkPackage.Literals.SUB_SYSTEM, PORTS_AND_SUBSYSTEMS);
        sourceBlockQualifiers.put(SimulinkPackage.Literals.GOTO, SIGNAL_ROUTING);
        sourceBlockQualifiers.put(SimulinkPackage.Literals.FROM, SIGNAL_ROUTING);
        sourceBlockQualifiers.put(SimulinkPackage.Literals.GOTO_TAG_VISIBILITY, SIGNAL_ROUTING);
        sourceBlockQualifiers.put(SimulinkPackage.Literals.BUS_CREATOR, SIGNAL_ROUTING);
        sourceBlockQualifiers.put(SimulinkPackage.Literals.BUS_SELECTOR, SIGNAL_ROUTING);

        sourceBlockNames = new HashMap<EClass, String>();
        sourceBlockNames.put(SimulinkPackage.Literals.OUT_PORT_BLOCK, OUTPORT);
        sourceBlockNames.put(SimulinkPackage.Literals.IN_PORT_BLOCK, INPORT);
        sourceBlockNames.put(SimulinkPackage.Literals.ENABLE_BLOCK, ENABLE);
        sourceBlockNames.put(SimulinkPackage.Literals.TRIGGER_BLOCK, TRIGGER);
        sourceBlockNames.put(SimulinkPackage.Literals.GOTO, GOTO);
        sourceBlockNames.put(SimulinkPackage.Literals.FROM, FROM);
        sourceBlockNames.put(SimulinkPackage.Literals.GOTO_TAG_VISIBILITY, GOTO_TAG);
        sourceBlockNames.put(SimulinkPackage.Literals.BUS_CREATOR, BUS_CREATOR);
        sourceBlockNames.put(SimulinkPackage.Literals.BUS_SELECTOR, BUS_SELECTOR);
        sourceBlockNames.put(SimulinkPackage.Literals.MODEL_REFERENCE, MODEL_REFERENCE);
        sourceBlockNames.put(SimulinkPackage.Literals.SUB_SYSTEM, SUBSYSTEM);
    }
    
    public String adapt(Block block){
        String qualifier = sourceBlockQualifiers.get(block.eClass());
        String name = sourceBlockNames.get(block.eClass());
        LibraryLinkReference linkReference = SimulinkUtil.createLinkReference(name, qualifier);
        linkReference.setDisabled(true);
        block.setSourceBlockRef(linkReference);
        return linkReference.getFQN();
    }

}
