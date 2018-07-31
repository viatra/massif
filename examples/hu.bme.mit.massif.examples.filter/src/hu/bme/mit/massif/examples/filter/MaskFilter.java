package hu.bme.mit.massif.examples.filter;

import hu.bme.mit.massif.communication.command.MatlabCommand;
import hu.bme.mit.massif.communication.command.MatlabCommandFactory;
import hu.bme.mit.massif.communication.datatype.MatlabString;
import hu.bme.mit.massif.simulink.api.extension.IBlockImportFilter;

public class MaskFilter implements IBlockImportFilter {

	public MaskFilter() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getName() {
		return "MaskFilter";
	}

	@Override
	public String getDescription() {
		return "This is a user defined custom filter that ignores all masked subsystems.";
	}

	@Override
	public boolean filter(MatlabCommandFactory commandFactory, String blockFQN) {
		
		String blockType = MatlabString.getMatlabStringData(commandFactory.getParam().addParam(blockFQN).addParam("blockType").execute());
		if("SubSystem".equals(blockType)){		
			// In case of a subsystem check mask
			MatlabCommand getMask = commandFactory.getParam().addParam(blockFQN).addParam("Mask");
			String isMaskOn = MatlabString.getMatlabStringData(getMask.execute());
			
			if("on".equals(isMaskOn)){
				return true;
			}
		}
		
		return false;
	}

}
