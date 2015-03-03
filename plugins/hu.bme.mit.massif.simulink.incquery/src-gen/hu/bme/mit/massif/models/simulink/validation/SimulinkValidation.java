package hu.bme.mit.massif.models.simulink.validation;

import hu.bme.mit.massif.models.simulink.validation.ClashingChildNamesMatcher;
import hu.bme.mit.massif.models.simulink.validation.IdentifierNameContainsSlashMatcher;
import hu.bme.mit.massif.models.simulink.validation.util.ClashingChildNamesQuerySpecification;
import hu.bme.mit.massif.models.simulink.validation.util.IdentifierNameContainsSlashQuerySpecification;
import org.eclipse.incquery.runtime.api.IncQueryEngine;
import org.eclipse.incquery.runtime.api.impl.BaseGeneratedPatternGroup;
import org.eclipse.incquery.runtime.exception.IncQueryException;

/**
 * A pattern group formed of all patterns defined in simulinkValidation.eiq.
 * 
 * <p>Use the static instance as any {@link org.eclipse.incquery.runtime.api.IPatternGroup}, to conveniently prepare
 * an EMF-IncQuery engine for matching all patterns originally defined in file simulinkValidation.eiq,
 * in order to achieve better performance than one-by-one on-demand matcher initialization.
 * 
 * <p> From package hu.bme.mit.massif.models.simulink.validation, the group contains the definition of the following patterns: <ul>
 * <li>identifierNameContainsSlash</li>
 * <li>clashingChildNames</li>
 * </ul>
 * 
 * @see IPatternGroup
 * 
 */
@SuppressWarnings("all")
public final class SimulinkValidation extends BaseGeneratedPatternGroup {
  /**
   * Access the pattern group.
   * 
   * @return the singleton instance of the group
   * @throws IncQueryException if there was an error loading the generated code of pattern specifications
   * 
   */
  public static SimulinkValidation instance() throws IncQueryException {
    if (INSTANCE == null) {
    	INSTANCE = new SimulinkValidation();
    }
    return INSTANCE;
  }
  
  private static SimulinkValidation INSTANCE;
  
  private SimulinkValidation() throws IncQueryException {
    querySpecifications.add(IdentifierNameContainsSlashQuerySpecification.instance());
    querySpecifications.add(ClashingChildNamesQuerySpecification.instance());
  }
  
  public IdentifierNameContainsSlashQuerySpecification getIdentifierNameContainsSlash() throws IncQueryException {
    return IdentifierNameContainsSlashQuerySpecification.instance();
  }
  
  public IdentifierNameContainsSlashMatcher getIdentifierNameContainsSlash(final IncQueryEngine engine) throws IncQueryException {
    return IdentifierNameContainsSlashMatcher.on(engine);
  }
  
  public ClashingChildNamesQuerySpecification getClashingChildNames() throws IncQueryException {
    return ClashingChildNamesQuerySpecification.instance();
  }
  
  public ClashingChildNamesMatcher getClashingChildNames(final IncQueryEngine engine) throws IncQueryException {
    return ClashingChildNamesMatcher.on(engine);
  }
}
