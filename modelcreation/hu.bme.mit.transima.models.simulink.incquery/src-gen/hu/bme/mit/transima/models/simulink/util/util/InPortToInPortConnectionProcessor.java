package hu.bme.mit.transima.models.simulink.util.util;

import hu.bme.mit.transima.Simulink.InPort;
import hu.bme.mit.transima.models.simulink.util.InPortToInPortConnectionMatch;
import org.eclipse.incquery.runtime.api.IMatchProcessor;

/**
 * A match processor tailored for the hu.bme.mit.transima.models.simulink.util.inPortToInPortConnection pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
@SuppressWarnings("all")
public abstract class InPortToInPortConnectionProcessor implements IMatchProcessor<InPortToInPortConnectionMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pSourceInPort the value of pattern parameter sourceInPort in the currently processed match
   * @param pTargetInPort the value of pattern parameter targetInPort in the currently processed match
   * 
   */
  public abstract void process(final InPort pSourceInPort, final InPort pTargetInPort);
  
  @Override
  public void process(final InPortToInPortConnectionMatch match) {
    process(match.getSourceInPort(), match.getTargetInPort());
    
  }
}
