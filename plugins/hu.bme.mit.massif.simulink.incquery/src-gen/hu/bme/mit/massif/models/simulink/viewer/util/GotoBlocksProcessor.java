package hu.bme.mit.massif.models.simulink.viewer.util;

import hu.bme.mit.massif.models.simulink.viewer.GotoBlocksMatch;
import hu.bme.mit.massif.simulink.Goto;
import org.eclipse.incquery.runtime.api.IMatchProcessor;

/**
 * A match processor tailored for the hu.bme.mit.massif.models.simulink.viewer.gotoBlocks pattern.
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
  
  @Override
  public void process(final GotoBlocksMatch match) {
    process(match.getBl());
  }
}
