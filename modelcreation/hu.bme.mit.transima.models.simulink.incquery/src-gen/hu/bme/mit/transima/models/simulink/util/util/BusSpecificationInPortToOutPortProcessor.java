package hu.bme.mit.transima.models.simulink.util.util;

import hu.bme.mit.transima.Simulink.InPort;
import hu.bme.mit.transima.Simulink.OutPort;
import hu.bme.mit.transima.models.simulink.util.BusSpecificationInPortToOutPortMatch;
import org.eclipse.incquery.runtime.api.IMatchProcessor;

/**
 * A match processor tailored for the hu.bme.mit.transima.models.simulink.util.busSpecificationInPortToOutPort pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
@SuppressWarnings("all")
public abstract class BusSpecificationInPortToOutPortProcessor implements IMatchProcessor<BusSpecificationInPortToOutPortMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pInportOfBS the value of pattern parameter inportOfBS in the currently processed match
   * @param pOutPortOfBS the value of pattern parameter outPortOfBS in the currently processed match
   * 
   */
  public abstract void process(final InPort pInportOfBS, final OutPort pOutPortOfBS);
  
  public void process(final BusSpecificationInPortToOutPortMatch match) {
    process(match.getInportOfBS(), match.getOutPortOfBS());
    
  }
}
