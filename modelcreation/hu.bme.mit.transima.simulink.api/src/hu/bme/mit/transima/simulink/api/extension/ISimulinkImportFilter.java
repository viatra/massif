package hu.bme.mit.transima.simulink.api.extension;

import hu.bme.mit.transima.simulink.communication.command.MatlabCommandFactory;

/**
 * Interface that defines the filter for importing Simulink models
 */
public interface ISimulinkImportFilter {

    /**
     * Determines if the internal content of a Simulink block should also be imported.
     * 
     * @param commandEvaluator
     *            the MATLAB command evaluator object
     * @param blockFQN
     *            the fully qualified name of the block
     * @return true if the sub-blocks of the block should not be imported (in other words: returns if the sub-blocks
     *         should be filtered)
     */
    boolean filter(MatlabCommandFactory commandFactory, String blockFQN);

}
