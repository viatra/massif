package hu.bme.mit.transima.models.simulink.util.util;

import hu.bme.mit.transima.Simulink.Block;
import hu.bme.mit.transima.Simulink.Port;
import hu.bme.mit.transima.models.simulink.util.BlockToPortMatch;
import org.eclipse.incquery.runtime.api.IMatchProcessor;

/**
 * A match processor tailored for the hu.bme.mit.transima.models.simulink.util.blockToPort pattern.
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
  
  public void process(final BlockToPortMatch match) {
    process(match.getBlock(), match.getPort());
    
  }
}
