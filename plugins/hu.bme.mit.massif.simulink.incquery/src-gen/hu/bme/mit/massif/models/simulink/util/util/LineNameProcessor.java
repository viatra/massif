package hu.bme.mit.massif.models.simulink.util.util;

import hu.bme.mit.massif.models.simulink.util.LineNameMatch;
import hu.bme.mit.massif.simulink.Connection;
import org.eclipse.incquery.runtime.api.IMatchProcessor;

/**
 * A match processor tailored for the hu.bme.mit.massif.models.simulink.util.lineName pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
@SuppressWarnings("all")
public abstract class LineNameProcessor implements IMatchProcessor<LineNameMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pConn the value of pattern parameter conn in the currently processed match
   * @param pName the value of pattern parameter name in the currently processed match
   * 
   */
  public abstract void process(final Connection pConn, final String pName);
  
  @Override
  public void process(final LineNameMatch match) {
    process(match.getConn(), match.getName());
  }
}
