package hu.bme.mit.transima.simulink.api.adapter.block;

import hu.bme.mit.transima.Simulink.Block;
import hu.bme.mit.transima.Simulink.OutPortBlock;
import hu.bme.mit.transima.Simulink.SimulinkFactory;
import hu.bme.mit.transima.Simulink.SimulinkReference;
import hu.bme.mit.transima.simulink.api.Importer;

import java.util.LinkedHashSet;
import java.util.Map;

/**
 * Adapter class for the out port block
 */
public class OutPortAdapter extends PortAdapter {

    @Override
    public Block getBlock(Importer traverser) {
        return SimulinkFactory.eINSTANCE.createOutPortBlock();
    }

    @Override
    public void process(Importer traverser, SimulinkReference parentSimRef, Block blockToProcess) {
        super.process(traverser, parentSimRef, blockToProcess);

        Map<String, LinkedHashSet<OutPortBlock>> outPortBlocks = traverser.getOutPortBlocks();
        if (parentSimRef != null) {
            // Cache the outport block
            if (outPortBlocks.get(parentSimRef.getFQN()) == null) {
                outPortBlocks.put(parentSimRef.getFQN(), new LinkedHashSet<OutPortBlock>());
            }
            outPortBlocks.get(parentSimRef.getFQN()).add((OutPortBlock) blockToProcess);
        }
    }

}
