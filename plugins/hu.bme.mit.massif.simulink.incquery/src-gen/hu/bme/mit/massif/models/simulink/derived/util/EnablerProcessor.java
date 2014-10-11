package hu.bme.mit.massif.models.simulink.derived.util;

import hu.bme.mit.massif.models.simulink.derived.EnablerMatch;
import hu.bme.mit.massif.simulink.Block;
import hu.bme.mit.massif.simulink.Enable;
import org.eclipse.incquery.runtime.api.IMatchProcessor;

/**
 * A match processor tailored for the hu.bme.mit.massif.models.simulink.derived.enabler pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
@SuppressWarnings("all")
public abstract class EnablerProcessor implements IMatchProcessor<EnablerMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pBlock the value of pattern parameter Block in the currently processed match
   * @param pEnabler the value of pattern parameter Enabler in the currently processed match
   * 
   */
  public abstract void process(final Block pBlock, final Enable pEnabler);
  
  @Override
  public void process(final EnablerMatch match) {
    process(match.getBlock(), match.getEnabler());
    
  }
}
