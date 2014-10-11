package hu.bme.mit.massif.simulink.api.adapter.block;

import hu.bme.mit.massif.simulink.Block;
import hu.bme.mit.massif.simulink.SimulinkReference;
import hu.bme.mit.massif.simulink.api.Importer;
import hu.bme.mit.massif.simulink.api.exception.SimulinkApiException;

import java.io.IOException;

/**
 * The block adapter interface
 * 
 * Classes that are implementing this interface are used to create specific EMF representations of Simulink blocks.
 */
public interface IBlockAdapter {

    /**
     * Returns an instance of the block EClass associated with the adapter
     * 
     * @param traverser
     *            the importer instance that needs to obtain the block EMF object
     * 
     * @return the EMF block object
     */
    Block getBlock(Importer traverser);

    /**
     * Executes the required actions to import the block to EMF properly
     * 
     * @param traverser
     *            the currently traversing object
     * @param parentSimRef
     *            the </code>SimulinkReference</code> of the block being processed
     * @param blockToProcess
     *            the block to process by the corresponding implementation
     * @throws SimulinkApiException
     * @throws IOException
     */
    void process(Importer traverser, SimulinkReference parentSimRef, Block blockToProcess);

}
