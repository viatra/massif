package hu.bme.mit.massif.models.simulink.viewer.util;

import hu.bme.mit.massif.models.simulink.viewer.GotoConnectionMatch;
import hu.bme.mit.massif.simulink.From;
import hu.bme.mit.massif.simulink.Goto;
import org.eclipse.incquery.runtime.api.IMatchProcessor;

/**
 * A match processor tailored for the hu.bme.mit.massif.models.simulink.viewer.gotoConnection pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
@SuppressWarnings("all")
public abstract class GotoConnectionProcessor implements IMatchProcessor<GotoConnectionMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pFrom the value of pattern parameter from in the currently processed match
   * @param pTo the value of pattern parameter to in the currently processed match
   * 
   */
  public abstract void process(final Goto pFrom, final From pTo);
  
  @Override
  public void process(final GotoConnectionMatch match) {
    process(match.getFrom(), match.getTo());
    
  }
}
