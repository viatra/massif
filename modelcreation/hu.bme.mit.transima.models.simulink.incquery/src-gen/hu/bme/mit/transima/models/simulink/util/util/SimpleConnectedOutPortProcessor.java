package hu.bme.mit.transima.models.simulink.util.util;

import hu.bme.mit.transima.Simulink.OutPort;
import hu.bme.mit.transima.models.simulink.util.SimpleConnectedOutPortMatch;
import org.eclipse.incquery.runtime.api.IMatchProcessor;

/**
 * A match processor tailored for the hu.bme.mit.transima.models.simulink.util.simpleConnectedOutPort pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
@SuppressWarnings("all")
public abstract class SimpleConnectedOutPortProcessor implements IMatchProcessor<SimpleConnectedOutPortMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pSourceOutPort the value of pattern parameter sourceOutPort in the currently processed match
   * @param pTargetOutPort the value of pattern parameter targetOutPort in the currently processed match
   * 
   */
  public abstract void process(final OutPort pSourceOutPort, final OutPort pTargetOutPort);
  
  public void process(final SimpleConnectedOutPortMatch match) {
    process(match.getSourceOutPort(), match.getTargetOutPort());
    
  }
}
