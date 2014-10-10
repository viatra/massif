package hu.bme.mit.transima.models.simulink.util.util;

import hu.bme.mit.transima.Simulink.OutPort;
import hu.bme.mit.transima.models.simulink.util.NextOutPortInPathMatch;
import org.eclipse.incquery.runtime.api.IMatchProcessor;

/**
 * A match processor tailored for the hu.bme.mit.transima.models.simulink.util.nextOutPortInPath pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
@SuppressWarnings("all")
public abstract class NextOutPortInPathProcessor implements IMatchProcessor<NextOutPortInPathMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pSourceOutPort the value of pattern parameter sourceOutPort in the currently processed match
   * @param pNextOutPort the value of pattern parameter nextOutPort in the currently processed match
   * @param pTargetOutPort the value of pattern parameter targetOutPort in the currently processed match
   * 
   */
  public abstract void process(final OutPort pSourceOutPort, final OutPort pNextOutPort, final OutPort pTargetOutPort);
  
  public void process(final NextOutPortInPathMatch match) {
    process(match.getSourceOutPort(), match.getNextOutPort(), match.getTargetOutPort());
    
  }
}
