package hu.bme.mit.massif.models.simulink.derived.util;

import hu.bme.mit.massif.models.simulink.derived.TriggerMatch;
import hu.bme.mit.massif.simulink.Block;
import hu.bme.mit.massif.simulink.Trigger;
import org.eclipse.incquery.runtime.api.IMatchProcessor;

/**
 * A match processor tailored for the hu.bme.mit.massif.models.simulink.derived.trigger pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
@SuppressWarnings("all")
public abstract class TriggerProcessor implements IMatchProcessor<TriggerMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pBlock the value of pattern parameter Block in the currently processed match
   * @param pTrigger the value of pattern parameter Trigger in the currently processed match
   * 
   */
  public abstract void process(final Block pBlock, final Trigger pTrigger);
  
  @Override
  public void process(final TriggerMatch match) {
    process(match.getBlock(), match.getTrigger());
  }
}
