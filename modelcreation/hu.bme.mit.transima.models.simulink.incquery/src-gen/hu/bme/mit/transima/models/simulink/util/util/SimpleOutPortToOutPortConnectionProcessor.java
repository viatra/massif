package hu.bme.mit.transima.models.simulink.util.util;

import hu.bme.mit.transima.Simulink.OutPort;
import hu.bme.mit.transima.Simulink.SingleConnection;
import hu.bme.mit.transima.models.simulink.util.SimpleOutPortToOutPortConnectionMatch;
import org.eclipse.incquery.runtime.api.IMatchProcessor;

/**
 * A match processor tailored for the hu.bme.mit.transima.models.simulink.util.simpleOutPortToOutPortConnection pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
@SuppressWarnings("all")
public abstract class SimpleOutPortToOutPortConnectionProcessor implements IMatchProcessor<SimpleOutPortToOutPortConnectionMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pSourceOutPort the value of pattern parameter sourceOutPort in the currently processed match
   * @param pTargetOutPort the value of pattern parameter targetOutPort in the currently processed match
   * @param pConnection the value of pattern parameter connection in the currently processed match
   * 
   */
  public abstract void process(final OutPort pSourceOutPort, final OutPort pTargetOutPort, final SingleConnection pConnection);
  
  public void process(final SimpleOutPortToOutPortConnectionMatch match) {
    process(match.getSourceOutPort(), match.getTargetOutPort(), match.getConnection());
    
  }
}
