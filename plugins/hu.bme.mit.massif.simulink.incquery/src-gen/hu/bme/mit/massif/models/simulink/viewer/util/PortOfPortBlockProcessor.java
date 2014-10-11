package hu.bme.mit.massif.models.simulink.viewer.util;

import hu.bme.mit.massif.models.simulink.viewer.PortOfPortBlockMatch;
import hu.bme.mit.massif.simulink.Port;
import hu.bme.mit.massif.simulink.PortBlock;
import org.eclipse.incquery.runtime.api.IMatchProcessor;

/**
 * A match processor tailored for the hu.bme.mit.massif.models.simulink.viewer.portOfPortBlock pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
@SuppressWarnings("all")
public abstract class PortOfPortBlockProcessor implements IMatchProcessor<PortOfPortBlockMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pPort the value of pattern parameter port in the currently processed match
   * @param pPortBlock the value of pattern parameter portBlock in the currently processed match
   * 
   */
  public abstract void process(final Port pPort, final PortBlock pPortBlock);
  
  @Override
  public void process(final PortOfPortBlockMatch match) {
    process(match.getPort(), match.getPortBlock());
    
  }
}
