package hu.bme.mit.massif.models.simulink.viewer.util;

import hu.bme.mit.massif.models.simulink.viewer.SubBlocksMatch;
import hu.bme.mit.massif.simulink.Block;
import hu.bme.mit.massif.simulink.SubSystem;
import org.eclipse.incquery.runtime.api.IMatchProcessor;

/**
 * A match processor tailored for the hu.bme.mit.massif.models.simulink.viewer.subBlocks pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
@SuppressWarnings("all")
public abstract class SubBlocksProcessor implements IMatchProcessor<SubBlocksMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pSubSys the value of pattern parameter subSys in the currently processed match
   * @param pBl the value of pattern parameter bl in the currently processed match
   * 
   */
  public abstract void process(final SubSystem pSubSys, final Block pBl);
  
  @Override
  public void process(final SubBlocksMatch match) {
    process(match.getSubSys(), match.getBl());
  }
}
