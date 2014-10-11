package hu.bme.mit.massif.simulink.api.adapter.block;

import hu.bme.mit.massif.communication.command.MatlabCommand;
import hu.bme.mit.massif.communication.command.MatlabCommandFactory;
import hu.bme.mit.massif.communication.datatype.Handle;
import hu.bme.mit.massif.simulink.Block;
import hu.bme.mit.massif.simulink.Property;
import hu.bme.mit.massif.simulink.SimulinkFactory;
import hu.bme.mit.massif.simulink.SimulinkReference;
import hu.bme.mit.massif.simulink.api.Importer;
import hu.bme.mit.massif.simulink.api.util.BasicSimulinkEMFOperationsAPI;

import java.util.List;

/**
 * Generic adapter for non-specific blocks. This adapter is used when no adapter is registered for a block type. The
 * process method should be called from every class subclassing it.
 */
public class DefaultBlockAdapter implements IBlockAdapter {

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
