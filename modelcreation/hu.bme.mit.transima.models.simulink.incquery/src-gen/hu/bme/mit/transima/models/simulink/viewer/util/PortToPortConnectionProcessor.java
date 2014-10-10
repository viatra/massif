package hu.bme.mit.transima.models.simulink.viewer.util;

import hu.bme.mit.transima.Simulink.Block;
import hu.bme.mit.transima.models.simulink.viewer.PortToPortConnectionMatch;
import org.eclipse.incquery.runtime.api.IMatchProcessor;

/**
 * A match processor tailored for the hu.bme.mit.transima.models.simulink.viewer.portToPortConnection pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
@SuppressWarnings("all")
public abstract class PortToPortConnectionProcessor implements IMatchProcessor<PortToPortConnectionMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pFrom the value of pattern parameter from in the currently processed match
   * @param pTo the value of pattern parameter to in the currently processed match
   * @param pName the value of pattern parameter name in the currently processed match
   * 
   */
  public abstract void process(final Block pFrom, final Block pTo, final String pName);
  
  public void process(final PortToPortConnectionMatch match) {
    process(match.getFrom(), match.getTo(), match.getName());
    
  }
}
