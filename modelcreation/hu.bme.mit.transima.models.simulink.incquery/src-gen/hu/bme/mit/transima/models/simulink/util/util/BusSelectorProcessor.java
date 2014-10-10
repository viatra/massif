package hu.bme.mit.transima.models.simulink.util.util;

import hu.bme.mit.transima.Simulink.BusSelector;
import hu.bme.mit.transima.models.simulink.util.BusSelectorMatch;
import org.eclipse.incquery.runtime.api.IMatchProcessor;

/**
 * A match processor tailored for the hu.bme.mit.transima.models.simulink.util.busSelector pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
@SuppressWarnings("all")
public abstract class BusSelectorProcessor implements IMatchProcessor<BusSelectorMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pSelector the value of pattern parameter selector in the currently processed match
   * 
   */
  public abstract void process(final BusSelector pSelector);
  
  public void process(final BusSelectorMatch match) {
    process(match.getSelector());
    
  }
}
