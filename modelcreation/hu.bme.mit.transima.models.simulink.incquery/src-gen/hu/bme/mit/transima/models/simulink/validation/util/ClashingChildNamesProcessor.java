package hu.bme.mit.transima.models.simulink.validation.util;

import hu.bme.mit.transima.Simulink.SimulinkElement;
import hu.bme.mit.transima.models.simulink.validation.ClashingChildNamesMatch;
import org.eclipse.incquery.runtime.api.IMatchProcessor;

/**
 * A match processor tailored for the hu.bme.mit.transima.models.simulink.validation.clashingChildNames pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
@SuppressWarnings("all")
public abstract class ClashingChildNamesProcessor implements IMatchProcessor<ClashingChildNamesMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pParent the value of pattern parameter parent in the currently processed match
   * @param pChild the value of pattern parameter child in the currently processed match
   * 
   */
  public abstract void process(final SimulinkElement pParent, final SimulinkElement pChild);
  
  public void process(final ClashingChildNamesMatch match) {
    process(match.getParent(), match.getChild());
    
  }
}
