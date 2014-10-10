package br.com.embraer.transima.matlab.commandevaluation.command;

import java.util.Arrays;

import br.com.embraer.transima.matlab.commandevaluation.exception.MatlabError;
import br.com.embraer.transima.matlab.commandevaluation.exception.MatlabRMIException;
import br.com.embraer.transima.matlab.commandevaluation.util.ModelProviderUtil;

/**
 * Wrapper class for the "feval" command
 * 
 * @author ldnascim
 */
public class FevalCommand extends InteractionCommand {
	
	private String name;
	private Object[] inputArguments;

	/**
	 * Constructor
	 * @param numberOfOutputsArguments Number of outputs
	 * @param name
	 * @param inputArguments
	 */
	public FevalCommand(int numberOfOutputsArguments,
			String name, Object[] inputArguments) {
		super(numberOfOutputsArguments);
		this.name = name;
        this.inputArguments = Arrays.copyOf(inputArguments, inputArguments.length);
	}
	
	/**
	 * Gets the function name
	 * @return Function name
	 */
	public String getFunctionName() {
		return name;
	}
	
	/**
	 * Returns the function inputs
	 * @return Array of objects containing the inputs
	 */
	public Object[] getInputArguments() {
        return Arrays.copyOf(inputArguments, inputArguments.length);
	}

	@Override
	protected Object execute() throws MatlabRMIException {
		Object output = null;
		String functionName = getFunctionName();
        Object[] inputArgs = inputArguments;
		int numberOfOutputsArguments = getNumberOfOutputsArguments();
		try {
			output = com.mathworks.jmi.Matlab.mtFevalConsoleOutput(functionName,
					inputArgs, numberOfOutputsArguments);
		} catch (Exception e) {
			MatlabRMIException exception =
					new MatlabRMIException(MatlabError.EXECUTING_COMMAND_ON_MATLAB_ERROR, e);
			exception.set("Type", "mtFevalConsoleOutput");
			exception.set("Function name", functionName);
			exception.set("Input arguments", ModelProviderUtil.convertArrayToString(inputArgs, ","));
			exception.set("Number of outputs arguments", numberOfOutputsArguments);
			throw exception;
		}
		
		return output;
	}
	
	@Override
	public String toString() {
        String str = "Type: mtFevalConsoleOutput, Function name: " + getFunctionName() +
 ", Input arguments: "
                + ModelProviderUtil.convertArrayToString(inputArguments, ",") +
				" ,Number of outputs arguments: " + getNumberOfOutputsArguments();
		return str;
	}
}
