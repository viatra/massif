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
package hu.bme.mit.massif.simulink.api.tests.bus;

import hu.bme.mit.massif.simulink.api.util.bus.BusSignalMapper;

import org.junit.Test;

public class BusSignalMappingSpecificCasesTest extends BusSignalMappingBaseTest {

    @Test
    public void testMappingCreatorFAM18() throws Exception{
    	// TODO fox test cases
        modelUri = "platform:plugin/Local_trunk/fam.18.bus_creator_selector/fam_18_bus_creator_selector";
        BusSignalMapper mapper = prepareBusSignalMapper();
        executeMappingCreator(mapper, true);
    }
    
    @Test(expected = IllegalStateException.class)
    public void testMappingCreatorFlattenedSignals() throws Exception{
        modelUri = "platform:plugin/hu.bme.mit.massif.simulink.api.tests/cases/14 - BusMapping/tst_bus_flattened_signals";
        BusSignalMapper mapper = prepareBusSignalMapper();
        executeMappingCreator(mapper, true);
    }
}
