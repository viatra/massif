package hu.bme.mit.transima.models.simulink.derived.util;

import hu.bme.mit.transima.Simulink.Block;
import hu.bme.mit.transima.Simulink.LibraryLinkReference;
import hu.bme.mit.transima.models.simulink.derived.SourceBlockNotFoundMatch;
import org.eclipse.incquery.runtime.api.IMatchProcessor;

/**
 * A match processor tailored for the hu.bme.mit.transima.models.simulink.derived.sourceBlockNotFound pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
@SuppressWarnings("all")
public abstract class SourceBlockNotFoundProcessor implements IMatchProcessor<SourceBlockNotFoundMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pBlock the value of pattern parameter Block in the currently processed match
   * @param pBlRef the value of pattern parameter BlRef in the currently processed match
   * 
   */
  public abstract void process(final Block pBlock, final LibraryLinkReference pBlRef);
  
  @Override
  public void process(final SourceBlockNotFoundMatch match) {
    process(match.getBlock(), match.getBlRef());
    
  }
}
