package hu.bme.mit.massif.models.simulink.viewer.util;

import hu.bme.mit.massif.models.simulink.viewer.BusSignalMappingSourceMatch;
import hu.bme.mit.massif.simulink.Block;
import hu.bme.mit.massif.simulink.BusSelector;
import org.eclipse.incquery.runtime.api.IMatchProcessor;

/**
 * A match processor tailored for the hu.bme.mit.massif.models.simulink.viewer.busSignalMappingSource pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
@SuppressWarnings("all")
public abstract class BusSignalMappingSourceProcessor implements IMatchProcessor<BusSignalMappingSourceMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pBusSelector the value of pattern parameter busSelector in the currently processed match
   * @param pFrom the value of pattern parameter from in the currently processed match
   * @param pName the value of pattern parameter name in the currently processed match
   * @param pToName the value of pattern parameter toName in the currently processed match
   * 
   */
  public abstract void process(final BusSelector pBusSelector, final Block pFrom, final String pName, final String pToName);
  
  @Override
  public void process(final BusSignalMappingSourceMatch match) {
    process(match.getBusSelector(), match.getFrom(), match.getName(), match.getToName());
    
  }
}
