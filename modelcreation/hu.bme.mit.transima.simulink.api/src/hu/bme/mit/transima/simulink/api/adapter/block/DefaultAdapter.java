package hu.bme.mit.transima.simulink.api.adapter.block;

import hu.bme.mit.transima.Simulink.Block;
import hu.bme.mit.transima.Simulink.Property;
import hu.bme.mit.transima.Simulink.SimulinkFactory;
import hu.bme.mit.transima.Simulink.SimulinkReference;
import hu.bme.mit.transima.simulink.api.Importer;
import hu.bme.mit.transima.simulink.api.util.BasicSimulinkEMFOperationsAPI;
import hu.bme.mit.transima.simulink.communication.command.MatlabCommand;
import hu.bme.mit.transima.simulink.communication.command.MatlabCommandFactory;
import hu.bme.mit.transima.simulink.communication.datatype.Handle;

import java.util.List;

/**
 * Generic adapter for non-specific blocks. This adapter is used when no adapter is registered for a block type. The
 * process method should be called from every class subclassing it.
 */
public class DefaultAdapter implements IBlockAdapter {

    @Override
    public Block getBlock(Importer traverser) {
        return SimulinkFactory.eINSTANCE.createBlock();
    }

    @Override
    public void process(Importer traverser, SimulinkReference parentSimRef, Block blockToProcess) {
        // The default block processing implementation goes here

        MatlabCommandFactory commandFactory = traverser.getCommandFactory();
        String blockFQN = blockToProcess.getSimulinkRef().getFQN();

        MatlabCommand getBlockHandle = commandFactory.getParam().addParam(blockFQN).addParam("Handle");
        Handle blockHandle = Handle.asHandle(getBlockHandle.execute());

        // Get Mask parameters list
        List<Property> maskProperties = BasicSimulinkEMFOperationsAPI.getMaskParameters(commandFactory, blockHandle);
        // Add all
        blockToProcess.getProperties().addAll(maskProperties);

        // Get Dialog parameters list
        List<Property> dialogProperties = BasicSimulinkEMFOperationsAPI.getDialogParameters(commandFactory,
                blockToProcess);
        // Add all
        blockToProcess.getProperties().addAll(dialogProperties);

    }

}
