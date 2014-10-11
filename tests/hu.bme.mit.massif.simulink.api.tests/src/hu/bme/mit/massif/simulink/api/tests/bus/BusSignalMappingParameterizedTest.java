package hu.bme.mit.massif.simulink.api.tests.bus;

import hu.bme.mit.massif.simulink.api.util.bus.BusSignalMapper;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(value = Parameterized.class)
public class BusSignalMappingParameterizedTest extends BusSignalMappingBaseTest {

    private static final String BASEPATH = "platform:plugin/hu.bme.mit.transima.simulink.api.tests/cases/14 - BusMapping/";
    public BusSignalMappingParameterizedTest(String modelUri) {
        this.modelUri = modelUri;
    }
    
    @Test
    public void testMappingCreator() throws Exception{
        BusSignalMapper mapper = prepareBusSignalMapper();
        executeMappingCreator(mapper, modelUri.endsWith("incomplete"));
    }
    
    @Test
    public void testPathFinder() throws Exception{
        BusSignalMapper mapper = prepareBusSignalMapper();
        checkPathFinder(mapper);
    }
    
    @Parameters(name= "{index}: modelUri = {0}")
    public static Collection<Object[]> getInputModelUris() {
      Object[][] data = new Object[][] {
              { BASEPATH + "bus_simple" },
              { BASEPATH + "bus_goto" },
              { BASEPATH + "bus_combined" },
              { BASEPATH + "bus_outputAsBus" },
              { BASEPATH + "bus_outputAsBusAndSelect" },
              { BASEPATH + "bus_collision" },
              { BASEPATH + "bus_unnamed" },
              { BASEPATH + "bus_goto" },
              { BASEPATH + "bus_outputAsBusComplex" },
              { BASEPATH + "tst_bus_simple" },
              { BASEPATH + "tst_bus_simple_goto" },
              { BASEPATH + "tst_bus_simple_hierarchy" },
              { BASEPATH + "tst_bus_simple_combined" },
              { BASEPATH + "tst_bus_complex" },
              { BASEPATH + "tst_bus_complex_combined" },
              //{ BASEPATH + "tst_bus_flattened_signals" }, // ignore: duplicate names in model
              { BASEPATH + "tst_bus_no_signal_names" },
              { BASEPATH + "tst_bus_outputasbus" },
              { BASEPATH + "tst_bus_outputasbus_combined" },
              { BASEPATH + "tst_bus_outputasbus_goto" },
              { BASEPATH + "tst_bus_outputasbus_hierarchy" },
              { BASEPATH + "tst_bus_name_with_dot" },
              { BASEPATH + "tst_bus_name_with_comma" },
              { BASEPATH + "bus_simple_incomplete" },
              { BASEPATH + "tst_bus_complex_incomplete" },
              { BASEPATH + "tst_bus_complex_combined_incomplete" }
              };
      return Arrays.asList(data);
    }

}