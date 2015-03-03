package hu.bme.mit.massif.models.simulink.util.util;

import hu.bme.mit.massif.models.simulink.util.ReferenceEqualMatch;
import hu.bme.mit.massif.simulink.SimulinkReference;
import org.eclipse.incquery.runtime.api.IMatchProcessor;

/**
 * A match processor tailored for the hu.bme.mit.massif.models.simulink.util.referenceEqual pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
@SuppressWarnings("all")
public abstract class ReferenceEqualProcessor implements IMatchProcessor<ReferenceEqualMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pSourceRef the value of pattern parameter sourceRef in the currently processed match
   * @param pTargetRef the value of pattern parameter targetRef in the currently processed match
   * 
   */
  public abstract void process(final SimulinkReference pSourceRef, final SimulinkReference pTargetRef);
  
  @Override
  public void process(final ReferenceEqualMatch match) {
    process(match.getSourceRef(), match.getTargetRef());
  }
}
