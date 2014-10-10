package hu.bme.mit.transima.models.simulink.viewer.util;

import hu.bme.mit.transima.Simulink.Goto;
import hu.bme.mit.transima.models.simulink.viewer.GotoBlocksMatch;
import org.eclipse.incquery.runtime.api.IMatchProcessor;

/**
 * A match processor tailored for the hu.bme.mit.transima.models.simulink.viewer.gotoBlocks pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
@SuppressWarnings("all")
public abstract class GotoBlocksProcessor implements IMatchProcessor<GotoBlocksMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pBl the value of pattern parameter bl in the currently processed match
   * 
   */
  public abstract void process(final Goto pBl);
  
  public void process(final GotoBlocksMatch match) {
    process(match.getBl());
    
  }
}
