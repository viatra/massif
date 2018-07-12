package hu.bme.mit.massif.communication.matlabengine;

import hu.bme.mit.massif.communication.AbstractCommandEvaluator;

public class MatlabEngineEvaluator extends AbstractCommandEvaluator<MatlabEngineAccess> {

	public MatlabEngineEvaluator() {
		super(new MatlabEngineAccess());
	}

}
