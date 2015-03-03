package hu.bme.mit.massif.models.simulink.derived.util;

import hu.bme.mit.massif.models.simulink.derived.SourceBlockMatch;
import hu.bme.mit.massif.simulink.Block;
import org.eclipse.incquery.runtime.api.IMatchProcessor;

/**
 * A match processor tailored for the hu.bme.mit.massif.models.simulink.derived.sourceBlock pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
@SuppressWarnings("all")
public abstract class SourceBlockProcessor implements IMatchProcessor<SourceBlockMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pThis the value of pattern parameter This in the currently processed match
   * @param pSource the value of pattern parameter Source in the currently processed match
   * 
   */
  public abstract void process(final Block pThis, final Block pSource);
  
  @Override
  public void process(final SourceBlockMatch match) {
    process(match.getThis(), match.getSource());
  }
}
