package hu.bme.mit.massif.models.simulink.util.util;

import hu.bme.mit.massif.models.simulink.util.SimulinkReferenceMatch;
import hu.bme.mit.massif.simulink.SimulinkReference;
import org.eclipse.incquery.runtime.api.IMatchProcessor;

/**
 * A match processor tailored for the hu.bme.mit.massif.models.simulink.util.simulinkReference pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
@SuppressWarnings("all")
public abstract class SimulinkReferenceProcessor implements IMatchProcessor<SimulinkReferenceMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pSR the value of pattern parameter SR in the currently processed match
   * @param pName the value of pattern parameter Name in the currently processed match
   * @param pQual the value of pattern parameter Qual in the currently processed match
   * 
   */
  public abstract void process(final SimulinkReference pSR, final String pName, final String pQual);
  
  @Override
  public void process(final SimulinkReferenceMatch match) {
    process(match.getSR(), match.getName(), match.getQual());
    
  }
}
