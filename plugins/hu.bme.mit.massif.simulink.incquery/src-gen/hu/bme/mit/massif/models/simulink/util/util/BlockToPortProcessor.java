package hu.bme.mit.massif.models.simulink.util.util;

import hu.bme.mit.massif.models.simulink.util.BlockToPortMatch;
import hu.bme.mit.massif.simulink.Block;
import hu.bme.mit.massif.simulink.Port;
import org.eclipse.incquery.runtime.api.IMatchProcessor;

/**
 * A match processor tailored for the hu.bme.mit.massif.models.simulink.util.blockToPort pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
@SuppressWarnings("all")
public abstract class BlockToPortProcessor implements IMatchProcessor<BlockToPortMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pBlock the value of pattern parameter block in the currently processed match
   * @param pPort the value of pattern parameter port in the currently processed match
   * 
   */
  public abstract void process(final Block pBlock, final Port pPort);
  
  @Override
  public void process(final BlockToPortMatch match) {
    process(match.getBlock(), match.getPort());
    
  }
}
