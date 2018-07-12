package hu.bme.mit.massif.communication.matlabengine;

import com.mathworks.engine.EngineException;
import com.mathworks.engine.MatlabEngine;

import hu.bme.mit.massif.communication.ICommandAccess;

public class MatlabEngineAccess implements ICommandAccess {

	private MatlabEngine engine;
	
	public MatlabEngineAccess() {
		try {
			engine = MatlabEngine.connectMatlab();
		} catch (EngineException | InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	
	@Override
	public Object[] executeFeval(String name, Object[] inputArgs, int numberOfOutputs) throws Exception {
		return engine.<Object[]>feval(name, inputArgs);
	}

	@Override
	public Object[] executeEval(String command, int numberOfOutputs) throws Exception {
		engine.eval(command);
		return null;
	}

}
