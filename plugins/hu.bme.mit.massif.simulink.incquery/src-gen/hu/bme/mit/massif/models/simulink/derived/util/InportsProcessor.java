package hu.bme.mit.massif.models.simulink.derived.util;

import hu.bme.mit.massif.models.simulink.derived.InportsMatch;
import hu.bme.mit.massif.simulink.Block;
import hu.bme.mit.massif.simulink.InPort;
import org.eclipse.incquery.runtime.api.IMatchProcessor;

/**
 * A match processor tailored for the hu.bme.mit.massif.models.simulink.derived.inports pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
@SuppressWarnings("all")
public abstract class InportsProcessor implements IMatchProcessor<InportsMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pBlock the value of pattern parameter Block in the currently processed match
   * @param pInPort the value of pattern parameter InPort in the currently processed match
   * 
   */
  public abstract void process(final Block pBlock, final InPort pInPort);
  
  @Override
  public void process(final InportsMatch match) {
    process(match.getBlock(), match.getInPort());
  }
}
