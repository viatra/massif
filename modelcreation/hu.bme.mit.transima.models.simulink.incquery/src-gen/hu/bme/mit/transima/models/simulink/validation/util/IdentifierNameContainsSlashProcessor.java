package hu.bme.mit.transima.models.simulink.validation.util;

import hu.bme.mit.transima.Simulink.IdentifierReference;
import hu.bme.mit.transima.models.simulink.validation.IdentifierNameContainsSlashMatch;
import org.eclipse.incquery.runtime.api.IMatchProcessor;

/**
 * A match processor tailored for the hu.bme.mit.transima.models.simulink.validation.identifierNameContainsSlash pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
@SuppressWarnings("all")
public abstract class IdentifierNameContainsSlashProcessor implements IMatchProcessor<IdentifierNameContainsSlashMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pId the value of pattern parameter id in the currently processed match
   * 
   */
  public abstract void process(final IdentifierReference pId);
  
  public void process(final IdentifierNameContainsSlashMatch match) {
    process(match.getId());
    
  }
}
