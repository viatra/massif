package hu.bme.mit.massif.models.simulink.derived.util;

import hu.bme.mit.massif.models.simulink.derived.OutportsMatch;
import hu.bme.mit.massif.simulink.Block;
import hu.bme.mit.massif.simulink.OutPort;
import org.eclipse.incquery.runtime.api.IMatchProcessor;

/**
 * A match processor tailored for the hu.bme.mit.massif.models.simulink.derived.outports pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
@SuppressWarnings("all")
public abstract class OutportsProcessor implements IMatchProcessor<OutportsMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pBlock the value of pattern parameter Block in the currently processed match
   * @param pOutPort the value of pattern parameter OutPort in the currently processed match
   * 
   */
  public abstract void process(final Block pBlock, final OutPort pOutPort);
  
  @Override
  public void process(final OutportsMatch match) {
    process(match.getBlock(), match.getOutPort());
    
  }
}
