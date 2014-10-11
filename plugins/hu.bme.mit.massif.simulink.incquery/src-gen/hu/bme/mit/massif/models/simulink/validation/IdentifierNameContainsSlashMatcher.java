package hu.bme.mit.massif.models.simulink.validation;

import hu.bme.mit.massif.models.simulink.validation.IdentifierNameContainsSlashMatch;
import hu.bme.mit.massif.models.simulink.validation.util.IdentifierNameContainsSlashQuerySpecification;
import hu.bme.mit.massif.simulink.IdentifierReference;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import org.apache.log4j.Logger;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.incquery.runtime.api.IMatchProcessor;
import org.eclipse.incquery.runtime.api.IQuerySpecification;
import org.eclipse.incquery.runtime.api.IncQueryEngine;
import org.eclipse.incquery.runtime.api.impl.BaseMatcher;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.incquery.runtime.matchers.tuple.Tuple;
import org.eclipse.incquery.runtime.rete.misc.DeltaMonitor;
import org.eclipse.incquery.runtime.util.IncQueryLoggingUtil;

/**
 * Generated pattern matcher API of the hu.bme.mit.massif.models.simulink.validation.identifierNameContainsSlash pattern,
 * providing pattern-specific query methods.
 * 
 * <p>Use the pattern matcher on a given model via {@link #on(IncQueryEngine)},
 * e.g. in conjunction with {@link IncQueryEngine#on(Notifier)}.
 * 
 * <p>Matches of the pattern will be represented as {@link IdentifierNameContainsSlashMatch}.
 * 
 * <p>Original source:
 * <code><pre>
 * {@literal @}Constraint(severity = "error", location = id,
 * 	message = "Identifier $id$ must not contain '/'!"
 * )
 * pattern identifierNameContainsSlash(id : IdentifierReference) {
 * 	IdentifierReference.name(id, name);
 * 	check(name.contains('/'));
 * }
 * </pre></code>
 * 
 * @see IdentifierNameContainsSlashMatch
 * @see IdentifierNameContainsSlashProcessor
 * @see IdentifierNameContainsSlashQuerySpecification
 * 
 */
@SuppressWarnings("all")
public class IdentifierNameContainsSlashMatcher extends BaseMatcher<IdentifierNameContainsSlashMatch> {
  /**
   * @return the singleton instance of the query specification of this pattern
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static IQuerySpecification<IdentifierNameContainsSlashMatcher> querySpecification() throws IncQueryException {
    return IdentifierNameContainsSlashQuerySpecification.instance();
  }
  
  /**
   * Initializes the pattern matcher within an existing EMF-IncQuery engine.
   * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
   * The match set will be incrementally refreshed upon updates.
   * @param engine the existing EMF-IncQuery engine in which this matcher will be created.
   * @throws IncQueryException if an error occurs during pattern matcher creation
   * 
   */
  public static IdentifierNameContainsSlashMatcher on(final IncQueryEngine engine) throws IncQueryException {
    // check if matcher already exists
    IdentifierNameContainsSlashMatcher matcher = engine.getExistingMatcher(querySpecification());
    if (matcher == null) {
    	matcher = new IdentifierNameContainsSlashMatcher(engine);
    	// do not have to "put" it into engine.matchers, reportMatcherInitialized() will take care of it
    }
    return matcher;
  }
  
  private final static int POSITION_ID = 0;
  
  private final static Logger LOGGER = IncQueryLoggingUtil.getLogger(IdentifierNameContainsSlashMatcher.class);
  
  /**
   * Initializes the pattern matcher over a given EMF model root (recommended: Resource or ResourceSet).
   * If a pattern matcher is already constructed with the same root, only a light-weight reference is returned.
   * The scope of pattern matching will be the given EMF model root and below (see FAQ for more precise definition).
   * The match set will be incrementally refreshed upon updates from this scope.
   * <p>The matcher will be created within the managed {@link IncQueryEngine} belonging to the EMF model root, so
   * multiple matchers will reuse the same engine and benefit from increased performance and reduced memory footprint.
   * @param emfRoot the root of the EMF containment hierarchy where the pattern matcher will operate. Recommended: Resource or ResourceSet.
   * @throws IncQueryException if an error occurs during pattern matcher creation
   * @deprecated use {@link #on(IncQueryEngine)} instead, e.g. in conjunction with {@link IncQueryEngine#on(Notifier)}
   * 
   */
  @Deprecated
  public IdentifierNameContainsSlashMatcher(final Notifier emfRoot) throws IncQueryException {
    this(IncQueryEngine.on(emfRoot));
  }
  
  /**
   * Initializes the pattern matcher within an existing EMF-IncQuery engine.
   * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
   * The match set will be incrementally refreshed upon updates.
   * @param engine the existing EMF-IncQuery engine in which this matcher will be created.
   * @throws IncQueryException if an error occurs during pattern matcher creation
   * @deprecated use {@link #on(IncQueryEngine)} instead
   * 
   */
  @Deprecated
  public IdentifierNameContainsSlashMatcher(final IncQueryEngine engine) throws IncQueryException {
    super(engine, querySpecification());
  }
  
  /**
   * Returns the set of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pId the fixed value of pattern parameter id, or null if not bound.
   * @return matches represented as a IdentifierNameContainsSlashMatch object.
   * 
   */
  public Collection<IdentifierNameContainsSlashMatch> getAllMatches(final IdentifierReference pId) {
    return rawGetAllMatches(new Object[]{pId});
  }
  
  /**
   * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pId the fixed value of pattern parameter id, or null if not bound.
   * @return a match represented as a IdentifierNameContainsSlashMatch object, or null if no match is found.
   * 
   */
  public IdentifierNameContainsSlashMatch getOneArbitraryMatch(final IdentifierReference pId) {
    return rawGetOneArbitraryMatch(new Object[]{pId});
  }
  
  /**
   * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
   * under any possible substitution of the unspecified parameters (if any).
   * @param pId the fixed value of pattern parameter id, or null if not bound.
   * @return true if the input is a valid (partial) match of the pattern.
   * 
   */
  public boolean hasMatch(final IdentifierReference pId) {
    return rawHasMatch(new Object[]{pId});
  }
  
  /**
   * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pId the fixed value of pattern parameter id, or null if not bound.
   * @return the number of pattern matches found.
   * 
   */
  public int countMatches(final IdentifierReference pId) {
    return rawCountMatches(new Object[]{pId});
  }
  
  /**
   * Executes the given processor on each match of the pattern that conforms to the given fixed values of some parameters.
   * @param pId the fixed value of pattern parameter id, or null if not bound.
   * @param processor the action that will process each pattern match.
   * 
   */
  public void forEachMatch(final IdentifierReference pId, final IMatchProcessor<? super IdentifierNameContainsSlashMatch> processor) {
    rawForEachMatch(new Object[]{pId}, processor);
  }
  
  /**
   * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pId the fixed value of pattern parameter id, or null if not bound.
   * @param processor the action that will process the selected match.
   * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
   * 
   */
  public boolean forOneArbitraryMatch(final IdentifierReference pId, final IMatchProcessor<? super IdentifierNameContainsSlashMatch> processor) {
    return rawForOneArbitraryMatch(new Object[]{pId}, processor);
  }
  
  /**
   * Registers a new filtered delta monitor on this pattern matcher.
   * The DeltaMonitor can be used to track changes (delta) in the set of filtered pattern matches from now on, considering those matches only that conform to the given fixed values of some parameters.
   * It can also be reset to track changes from a later point in time,
   * and changes can even be acknowledged on an individual basis.
   * See {@link DeltaMonitor} for details.
   * @param fillAtStart if true, all current matches are reported as new match events; if false, the delta monitor starts empty.
   * @param pId the fixed value of pattern parameter id, or null if not bound.
   * @return the delta monitor.
   * @deprecated use the IncQuery Databinding API (IncQueryObservables) instead.
   * 
   */
  @Deprecated
  public DeltaMonitor<IdentifierNameContainsSlashMatch> newFilteredDeltaMonitor(final boolean fillAtStart, final IdentifierReference pId) {
    return rawNewFilteredDeltaMonitor(fillAtStart, new Object[]{pId});
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pId the fixed value of pattern parameter id, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public IdentifierNameContainsSlashMatch newMatch(final IdentifierReference pId) {
    return IdentifierNameContainsSlashMatch.newMatch(pId);
    
  }
  
  /**
   * Retrieve the set of values that occur in matches for id.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<IdentifierReference> rawAccumulateAllValuesOfid(final Object[] parameters) {
    Set<IdentifierReference> results = new HashSet<IdentifierReference>();
    rawAccumulateAllValues(POSITION_ID, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for id.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<IdentifierReference> getAllValuesOfid() {
    return rawAccumulateAllValuesOfid(emptyArray());
  }
  
  @Override
  protected IdentifierNameContainsSlashMatch tupleToMatch(final Tuple t) {
    try {
      return IdentifierNameContainsSlashMatch.newMatch((hu.bme.mit.massif.simulink.IdentifierReference) t.get(POSITION_ID));
    } catch(ClassCastException e) {
      LOGGER.error("Element(s) in tuple not properly typed!",e);
      return null;
    }
    
  }
  
  @Override
  protected IdentifierNameContainsSlashMatch arrayToMatch(final Object[] match) {
    try {
      return IdentifierNameContainsSlashMatch.newMatch((hu.bme.mit.massif.simulink.IdentifierReference) match[POSITION_ID]);
    } catch(ClassCastException e) {
      LOGGER.error("Element(s) in array not properly typed!",e);
      return null;
    }
    
  }
  
  @Override
  protected IdentifierNameContainsSlashMatch arrayToMatchMutable(final Object[] match) {
    try {
      return IdentifierNameContainsSlashMatch.newMutableMatch((hu.bme.mit.massif.simulink.IdentifierReference) match[POSITION_ID]);
    } catch(ClassCastException e) {
      LOGGER.error("Element(s) in array not properly typed!",e);
      return null;
    }
    
  }
}
