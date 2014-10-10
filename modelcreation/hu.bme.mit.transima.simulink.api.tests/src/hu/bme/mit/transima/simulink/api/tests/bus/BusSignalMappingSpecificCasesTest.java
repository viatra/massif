package hu.bme.mit.transima.simulink.api.tests.bus;

import hu.bme.mit.transima.simulink.api.util.bus.BusSignalMapper;

import org.junit.Test;

public class BusSignalMappingSpecificCasesTest extends BusSignalMappingBaseTest {

    @Test
    public void testMappingCreatorFAM18() throws Exception{
        modelUri = "platform:plugin/Local_trunk/fam.18.bus_creator_selector/fam_18_bus_creator_selector";
        BusSignalMapper mapper = prepareBusSignalMapper();
        executeMappingCreator(mapper, true);
    }
    
    @Test(expected = IllegalStateException.class)
    public void testMappingCreatorFlattenedSignals() throws Exception{
        modelUri = "platform:plugin/hu.bme.mit.transima.simulink.api.tests/cases/14 - BusMapping/tst_bus_flattened_signals";
        BusSignalMapper mapper = prepareBusSignalMapper();
        executeMappingCreator(mapper, true);
    }
}
