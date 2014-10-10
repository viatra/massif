package hu.bme.mit.transima.simulink.communication;

import hu.bme.mit.transima.simulink.communication.datatype.IVisitableMatlabData;

/**
 * Class responsible for the low level operations with MATLAB
 * 
 * (The successor class of the removed <code>BasicOperationsApi</code> utility class)
 */
public interface ICommandEvaluator {

    /**
     * Evaluate a given sting as a MATLAB command
     * 
     * @param command
     *            the MATLAB command
     * @param nargout
     *            the number of expected return values in MATLAB
     * @return the result data
     */
    public IVisitableMatlabData evaluateCommand(String command, int nargout);

    /**
     * Evaluate given string array as an array of commands. The return values are put into a newly created
     * CellMatlabData.
     * 
     * @param commandStrings
     *            the array containig the command strings
     * @param outputArgumentCount
     *            the output argument count for each command (must be the same for every command in the given array)
     * @return
     */
    public IVisitableMatlabData evaluateCommands(String[] commandStrings, int outputArgumentCount);

}
