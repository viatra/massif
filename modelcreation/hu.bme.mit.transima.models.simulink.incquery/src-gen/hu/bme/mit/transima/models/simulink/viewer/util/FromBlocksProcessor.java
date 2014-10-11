package hu.bme.mit.transima.models.simulink.viewer.util;

import hu.bme.mit.transima.Simulink.From;
import hu.bme.mit.transima.models.simulink.viewer.FromBlocksMatch;
import org.eclipse.incquery.runtime.api.IMatchProcessor;

/**
 * A match processor tailored for the hu.bme.mit.transima.models.simulink.viewer.fromBlocks pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
@SuppressWarnings("all")
public abstract class FromBlocksProcessor implements IMatchProcessor<FromBlocksMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pBl the value of pattern parameter bl in the currently processed match
   * 
   */
  public abstract void process(final From pBl);
  
  @Override
  public void process(final FromBlocksMatch match) {
    process(match.getBl());
    
  }
}
