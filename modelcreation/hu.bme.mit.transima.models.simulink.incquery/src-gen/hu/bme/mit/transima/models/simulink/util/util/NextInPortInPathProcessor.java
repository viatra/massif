package hu.bme.mit.transima.models.simulink.util.util;

import hu.bme.mit.transima.Simulink.InPort;
import hu.bme.mit.transima.models.simulink.util.NextInPortInPathMatch;
import org.eclipse.incquery.runtime.api.IMatchProcessor;

/**
 * A match processor tailored for the hu.bme.mit.transima.models.simulink.util.nextInPortInPath pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
@SuppressWarnings("all")
public abstract class NextInPortInPathProcessor implements IMatchProcessor<NextInPortInPathMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pSourceInPort the value of pattern parameter sourceInPort in the currently processed match
   * @param pNextInPort the value of pattern parameter nextInPort in the currently processed match
   * @param pTargetInPort the value of pattern parameter targetInPort in the currently processed match
   * 
   */
  public abstract void process(final InPort pSourceInPort, final InPort pNextInPort, final InPort pTargetInPort);
  
  public void process(final NextInPortInPathMatch match) {
    process(match.getSourceInPort(), match.getNextInPort(), match.getTargetInPort());
    
  }
}
