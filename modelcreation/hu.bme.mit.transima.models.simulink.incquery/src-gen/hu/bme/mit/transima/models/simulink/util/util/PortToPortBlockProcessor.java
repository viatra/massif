package hu.bme.mit.transima.models.simulink.util.util;

import hu.bme.mit.transima.Simulink.Port;
import hu.bme.mit.transima.Simulink.PortBlock;
import hu.bme.mit.transima.models.simulink.util.PortToPortBlockMatch;
import org.eclipse.incquery.runtime.api.IMatchProcessor;

/**
 * A match processor tailored for the hu.bme.mit.transima.models.simulink.util.portToPortBlock pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
@SuppressWarnings("all")
public abstract class PortToPortBlockProcessor implements IMatchProcessor<PortToPortBlockMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pPort the value of pattern parameter port in the currently processed match
   * @param pPortBlock the value of pattern parameter portBlock in the currently processed match
   * 
   */
  public abstract void process(final Port pPort, final PortBlock pPortBlock);
  
  public void process(final PortToPortBlockMatch match) {
    process(match.getPort(), match.getPortBlock());
    
  }
}
