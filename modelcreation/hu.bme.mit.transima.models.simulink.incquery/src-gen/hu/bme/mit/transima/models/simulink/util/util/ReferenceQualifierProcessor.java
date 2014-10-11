package hu.bme.mit.transima.models.simulink.util.util;

import hu.bme.mit.transima.Simulink.SimulinkReference;
import hu.bme.mit.transima.models.simulink.util.ReferenceQualifierMatch;
import org.eclipse.incquery.runtime.api.IMatchProcessor;

/**
 * A match processor tailored for the hu.bme.mit.transima.models.simulink.util.referenceQualifier pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
@SuppressWarnings("all")
public abstract class ReferenceQualifierProcessor implements IMatchProcessor<ReferenceQualifierMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pSR the value of pattern parameter SR in the currently processed match
   * @param pQual the value of pattern parameter Qual in the currently processed match
   * 
   */
  public abstract void process(final SimulinkReference pSR, final String pQual);
  
  @Override
  public void process(final ReferenceQualifierMatch match) {
    process(match.getSR(), match.getQual());
    
  }
}
