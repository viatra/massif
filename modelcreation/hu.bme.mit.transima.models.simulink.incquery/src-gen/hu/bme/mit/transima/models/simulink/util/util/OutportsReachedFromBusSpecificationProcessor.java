package hu.bme.mit.transima.models.simulink.util.util;

import hu.bme.mit.transima.Simulink.BusSpecification;
import hu.bme.mit.transima.Simulink.OutPort;
import hu.bme.mit.transima.models.simulink.util.OutportsReachedFromBusSpecificationMatch;
import org.eclipse.incquery.runtime.api.IMatchProcessor;

/**
 * A match processor tailored for the hu.bme.mit.transima.models.simulink.util.outportsReachedFromBusSpecification pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
@SuppressWarnings("all")
public abstract class OutportsReachedFromBusSpecificationProcessor implements IMatchProcessor<OutportsReachedFromBusSpecificationMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pOutPort the value of pattern parameter outPort in the currently processed match
   * @param pNextSpec the value of pattern parameter nextSpec in the currently processed match
   * @param pEndPortBeforeNextSpec the value of pattern parameter endPortBeforeNextSpec in the currently processed match
   * 
   */
  public abstract void process(final OutPort pOutPort, final BusSpecification pNextSpec, final OutPort pEndPortBeforeNextSpec);
  
  @Override
  public void process(final OutportsReachedFromBusSpecificationMatch match) {
    process(match.getOutPort(), match.getNextSpec(), match.getEndPortBeforeNextSpec());
    
  }
}
