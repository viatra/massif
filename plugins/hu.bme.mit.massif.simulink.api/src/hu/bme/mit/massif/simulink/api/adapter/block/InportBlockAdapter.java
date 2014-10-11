package hu.bme.mit.massif.simulink.api.adapter.block;

import hu.bme.mit.massif.simulink.Block;
import hu.bme.mit.massif.simulink.InPortBlock;
import hu.bme.mit.massif.simulink.SimulinkFactory;
import hu.bme.mit.massif.simulink.SimulinkReference;
import hu.bme.mit.massif.simulink.api.Importer;

import java.util.LinkedHashSet;
import java.util.Map;

/**
 * Adapter class for the in port block
 */
public class InportBlockAdapter extends PortAdapter {

    @Override
    public Block getBlock(Importer traverser) {
        return SimulinkFactory.eINSTANCE.createInPortBlock();
    }

    @Override
    public void process(Importer traverser, SimulinkReference parentSimRef, Block blockToProcess) {
        super.process(traverser, parentSimRef, blockToProcess);

        Map<String, LinkedHashSet<InPortBlock>> inPortBlocks = traverser.getInPortBlocks();
        if (parentSimRef != null) {
            if (inPortBlocks.get(parentSimRef.getFQN()) == null) {
                inPortBlocks.put(parentSimRef.getFQN(), new LinkedHashSet<InPortBlock>());
            }
            // Cache the inport block
            inPortBlocks.get(parentSimRef.getFQN()).add((InPortBlock) blockToProcess);
        }
        
        traverser.getInportBlocksByName().put(blockToProcess.getSimulinkRef().getFQN(), (InPortBlock) blockToProcess);

    }


}
