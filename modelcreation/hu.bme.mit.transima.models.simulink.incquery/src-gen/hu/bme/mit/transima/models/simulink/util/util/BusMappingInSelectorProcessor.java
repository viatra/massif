package hu.bme.mit.transima.models.simulink.util.util;

import hu.bme.mit.transima.Simulink.BusSelector;
import hu.bme.mit.transima.Simulink.BusSignalMapping;
import hu.bme.mit.transima.Simulink.OutPort;
import hu.bme.mit.transima.models.simulink.util.BusMappingInSelectorMatch;
import org.eclipse.incquery.runtime.api.IMatchProcessor;

/**
 * A match processor tailored for the hu.bme.mit.transima.models.simulink.util.busMappingInSelector pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
@SuppressWarnings("all")
public abstract class BusMappingInSelectorProcessor implements IMatchProcessor<BusMappingInSelectorMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pSelector the value of pattern parameter selector in the currently processed match
   * @param pMapping the value of pattern parameter mapping in the currently processed match
   * @param pMappingFrom the value of pattern parameter mappingFrom in the currently processed match
   * @param pMappingTo the value of pattern parameter mappingTo in the currently processed match
   * 
   */
  public abstract void process(final BusSelector pSelector, final BusSignalMapping pMapping, final OutPort pMappingFrom, final OutPort pMappingTo);
  
  @Override
  public void process(final BusMappingInSelectorMatch match) {
    process(match.getSelector(), match.getMapping(), match.getMappingFrom(), match.getMappingTo());
    
  }
}
