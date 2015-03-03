package hu.bme.mit.massif.models.simulink.util.util;

import hu.bme.mit.massif.models.simulink.util.InPortToBlockPortOutPortMatch;
import hu.bme.mit.massif.simulink.InPort;
import hu.bme.mit.massif.simulink.OutPort;
import org.eclipse.incquery.runtime.api.IMatchProcessor;

/**
 * A match processor tailored for the hu.bme.mit.massif.models.simulink.util.inPortToBlockPortOutPort pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
@SuppressWarnings("all")
public abstract class InPortToBlockPortOutPortProcessor implements IMatchProcessor<InPortToBlockPortOutPortMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pInPort the value of pattern parameter inPort in the currently processed match
   * @param pOutPortOfPBl the value of pattern parameter outPortOfPBl in the currently processed match
   * 
   */
  public abstract void process(final InPort pInPort, final OutPort pOutPortOfPBl);
  
  @Override
  public void process(final InPortToBlockPortOutPortMatch match) {
    process(match.getInPort(), match.getOutPortOfPBl());
  }
}
