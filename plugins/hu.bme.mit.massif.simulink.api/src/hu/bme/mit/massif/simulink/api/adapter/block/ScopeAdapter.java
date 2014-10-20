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
package hu.bme.mit.massif.simulink.api.adapter.block;

import hu.bme.mit.massif.communication.command.MatlabCommand;
import hu.bme.mit.massif.communication.command.MatlabCommandFactory;
import hu.bme.mit.massif.communication.datatype.MatlabString;
import hu.bme.mit.massif.simulink.Block;
import hu.bme.mit.massif.simulink.Property;
import hu.bme.mit.massif.simulink.PropertySource;
import hu.bme.mit.massif.simulink.SimulinkFactory;
import hu.bme.mit.massif.simulink.SimulinkReference;
import hu.bme.mit.massif.simulink.api.Importer;

/**
 * Adapter class for the scope block
 */
public class ScopeAdapter extends DefaultBlockAdapter {

    private static final String FLOATING_PROPERTY_NAME = "floating";

    @Override
    public void process(Importer traverser, SimulinkReference parentSimRef, Block blockToProcess) {
        super.process(traverser, parentSimRef, blockToProcess);

        MatlabCommandFactory commandFactory = traverser.getCommandFactory();
        String blockFQN = blockToProcess.getSimulinkRef().getFQN();

        MatlabCommand getFloatingValue = commandFactory.getParam().addParam(blockFQN).addParam("floating");
        String isFloatingString = MatlabString.getMatlabStringData(getFloatingValue.execute());
        
        Property prop = SimulinkFactory.eINSTANCE.createProperty();
        prop.setName(FLOATING_PROPERTY_NAME);
        prop.setValue(isFloatingString);
        prop.setSource(PropertySource.MASK);

        blockToProcess.getProperties().add(prop);
    }

}
