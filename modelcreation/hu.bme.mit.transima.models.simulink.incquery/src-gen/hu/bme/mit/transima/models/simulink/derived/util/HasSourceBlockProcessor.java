package hu.bme.mit.transima.models.simulink.derived.util;

import hu.bme.mit.transima.Simulink.Block;
import hu.bme.mit.transima.models.simulink.derived.HasSourceBlockMatch;
import org.eclipse.incquery.runtime.api.IMatchProcessor;

/**
 * A match processor tailored for the hu.bme.mit.transima.models.simulink.derived.hasSourceBlock pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
@SuppressWarnings("all")
public abstract class HasSourceBlockProcessor implements IMatchProcessor<HasSourceBlockMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pBl the value of pattern parameter Bl in the currently processed match
   * 
   */
  public abstract void process(final Block pBl);
  
  @Override
  public void process(final HasSourceBlockMatch match) {
    process(match.getBl());
    
  }
}
