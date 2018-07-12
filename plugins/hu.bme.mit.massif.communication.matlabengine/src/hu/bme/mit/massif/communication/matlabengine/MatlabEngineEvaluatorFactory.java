package hu.bme.mit.massif.communication.matlabengine;

import java.util.Map;

import hu.bme.mit.massif.communication.ICommandEvaluator;
import hu.bme.mit.massif.communication.ICommandEvaluatorFactory;

public class MatlabEngineEvaluatorFactory implements ICommandEvaluatorFactory {

	@Override
	public ICommandEvaluator createCommandEvaluator(Map<String, Object> parameters) {
		ICommandEvaluator evaluator = new MatlabEngineEvaluator();
		return evaluator;
	}

	@Override
	public String getConnectorName() {
		return "MatlabEngine";
	}

}
