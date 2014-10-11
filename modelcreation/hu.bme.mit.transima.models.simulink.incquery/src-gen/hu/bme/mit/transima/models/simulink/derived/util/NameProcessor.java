package hu.bme.mit.transima.models.simulink.derived.util;

import hu.bme.mit.transima.Simulink.SimulinkElement;
import hu.bme.mit.transima.models.simulink.derived.NameMatch;
import org.eclipse.incquery.runtime.api.IMatchProcessor;

/**
 * A match processor tailored for the hu.bme.mit.transima.models.simulink.derived.name pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
@SuppressWarnings("all")
public abstract class NameProcessor implements IMatchProcessor<NameMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pSE the value of pattern parameter SE in the currently processed match
   * @param pName the value of pattern parameter Name in the currently processed match
   * 
   */
  public abstract void process(final SimulinkElement pSE, final String pName);
  
  @Override
  public void process(final NameMatch match) {
    process(match.getSE(), match.getName());
    
  }
}
