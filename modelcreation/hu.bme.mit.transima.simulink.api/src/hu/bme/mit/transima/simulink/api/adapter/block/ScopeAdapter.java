package hu.bme.mit.transima.simulink.api.adapter.block;

import hu.bme.mit.transima.Simulink.Block;
import hu.bme.mit.transima.Simulink.Property;
import hu.bme.mit.transima.Simulink.PropertySource;
import hu.bme.mit.transima.Simulink.SimulinkFactory;
import hu.bme.mit.transima.Simulink.SimulinkReference;
import hu.bme.mit.transima.simulink.api.Importer;
import hu.bme.mit.transima.simulink.communication.command.MatlabCommand;
import hu.bme.mit.transima.simulink.communication.command.MatlabCommandFactory;
import hu.bme.mit.transima.simulink.communication.datatype.MatlabString;

/**
 * Adapter class for the scope block
 */
public class ScopeAdapter extends DefaultAdapter {

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
