package hu.bme.mit.massif.models.simulink.util.util;

import hu.bme.mit.massif.models.simulink.util.PortBlockInPortToOutPortMatch;
import hu.bme.mit.massif.simulink.InPort;
import hu.bme.mit.massif.simulink.OutPort;
import org.eclipse.incquery.runtime.api.IMatchProcessor;

/**
 * A match processor tailored for the hu.bme.mit.massif.models.simulink.util.portBlockInPortToOutPort pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
@SuppressWarnings("all")
public abstract class PortBlockInPortToOutPortProcessor implements IMatchProcessor<PortBlockInPortToOutPortMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pInPortOfPBl the value of pattern parameter inPortOfPBl in the currently processed match
   * @param pOutPort the value of pattern parameter outPort in the currently processed match
   * 
   */
  public abstract void process(final InPort pInPortOfPBl, final OutPort pOutPort);
  
  @Override
  public void process(final PortBlockInPortToOutPortMatch match) {
    process(match.getInPortOfPBl(), match.getOutPort());
    
  }
}
