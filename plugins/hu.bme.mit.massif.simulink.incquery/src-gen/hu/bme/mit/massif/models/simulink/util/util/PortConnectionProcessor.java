package hu.bme.mit.massif.models.simulink.util.util;

import hu.bme.mit.massif.models.simulink.util.PortConnectionMatch;
import hu.bme.mit.massif.simulink.InPort;
import hu.bme.mit.massif.simulink.OutPort;
import hu.bme.mit.massif.simulink.SingleConnection;
import org.eclipse.incquery.runtime.api.IMatchProcessor;

/**
 * A match processor tailored for the hu.bme.mit.massif.models.simulink.util.portConnection pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
@SuppressWarnings("all")
public abstract class PortConnectionProcessor implements IMatchProcessor<PortConnectionMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pOutP the value of pattern parameter outP in the currently processed match
   * @param pInP the value of pattern parameter inP in the currently processed match
   * @param pPc the value of pattern parameter pc in the currently processed match
   * 
   */
  public abstract void process(final OutPort pOutP, final InPort pInP, final SingleConnection pPc);
  
  @Override
  public void process(final PortConnectionMatch match) {
    process(match.getOutP(), match.getInP(), match.getPc());
    
  }
}
