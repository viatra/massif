package hu.bme.mit.transima.simulink.api.adapter.block;

import hu.bme.mit.transima.Simulink.Block;
import hu.bme.mit.transima.Simulink.From;
import hu.bme.mit.transima.Simulink.SimulinkFactory;
import hu.bme.mit.transima.Simulink.SimulinkReference;
import hu.bme.mit.transima.simulink.api.Importer;

/**
 * Adapter class for the from block
 */
public class FromAdapter extends DefaultAdapter {

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
