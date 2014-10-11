package hu.bme.mit.massif.simulink.api.adapter.block;

import hu.bme.mit.massif.simulink.Block;
import hu.bme.mit.massif.simulink.From;
import hu.bme.mit.massif.simulink.SimulinkFactory;
import hu.bme.mit.massif.simulink.SimulinkReference;
import hu.bme.mit.massif.simulink.api.Importer;

/**
 * Adapter class for the from block
 */
public class FromAdapter extends DefaultBlockAdapter {

    @Override
    public Block getBlock(Importer traverser) {
        return SimulinkFactory.eINSTANCE.createFrom();
    }

    @Override
    public void process(Importer traverser, SimulinkReference parentSimRef, Block blockToProcess) {
        super.process(traverser, parentSimRef, blockToProcess);
        From fromBlock = (From) blockToProcess;
        traverser.getFroms().put(fromBlock.getSimulinkRef().getFQN().replace('\n', ' '), fromBlock);
        // This block is processed further during the creation of connections between blocks
    }

}
