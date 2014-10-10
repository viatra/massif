package hu.bme.mit.transima.simulink.api.adapter.block;

import hu.bme.mit.transima.Simulink.Block;
import hu.bme.mit.transima.Simulink.InPortBlock;
import hu.bme.mit.transima.Simulink.SimulinkFactory;
import hu.bme.mit.transima.Simulink.SimulinkReference;
import hu.bme.mit.transima.simulink.api.Importer;

import java.util.LinkedHashSet;
import java.util.Map;

/**
 * Adapter class for the in port block
 */
public class InportAdapter extends PortAdapter {

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
