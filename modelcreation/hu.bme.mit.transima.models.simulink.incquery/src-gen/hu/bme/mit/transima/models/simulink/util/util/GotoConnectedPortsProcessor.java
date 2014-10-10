package hu.bme.mit.transima.models.simulink.util.util;

import hu.bme.mit.transima.Simulink.InPort;
import hu.bme.mit.transima.Simulink.OutPort;
import hu.bme.mit.transima.models.simulink.util.GotoConnectedPortsMatch;
import org.eclipse.incquery.runtime.api.IMatchProcessor;

/**
 * A match processor tailored for the hu.bme.mit.transima.models.simulink.util.gotoConnectedPorts pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
@SuppressWarnings("all")
public abstract class GotoConnectedPortsProcessor implements IMatchProcessor<GotoConnectedPortsMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pGotoInPort the value of pattern parameter gotoInPort in the currently processed match
   * @param pFromOutPort the value of pattern parameter fromOutPort in the currently processed match
   * 
   */
  public abstract void process(final InPort pGotoInPort, final OutPort pFromOutPort);
  
  public void process(final GotoConnectedPortsMatch match) {
    process(match.getGotoInPort(), match.getFromOutPort());
    
  }
}
