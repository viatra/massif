package hu.bme.mit.massif.models.simulink.viewer.util;

import hu.bme.mit.massif.models.simulink.viewer.BlockMatch;
import hu.bme.mit.massif.simulink.Block;
import org.eclipse.incquery.runtime.api.IMatchProcessor;

/**
 * A match processor tailored for the hu.bme.mit.massif.models.simulink.viewer.block pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
@SuppressWarnings("all")
public abstract class BlockProcessor implements IMatchProcessor<BlockMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pBl the value of pattern parameter bl in the currently processed match
   * 
   */
  public abstract void process(final Block pBl);
  
  @Override
  public void process(final BlockMatch match) {
    process(match.getBl());
  }
}
