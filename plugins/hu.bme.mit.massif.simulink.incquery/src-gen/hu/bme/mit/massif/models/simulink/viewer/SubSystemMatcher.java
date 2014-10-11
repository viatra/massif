package hu.bme.mit.massif.models.simulink.viewer;

import hu.bme.mit.massif.models.simulink.viewer.SubSystemMatch;
import hu.bme.mit.massif.models.simulink.viewer.util.SubSystemQuerySpecification;
import hu.bme.mit.massif.simulink.SubSystem;
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
 * Generated pattern matcher API of the hu.bme.mit.massif.models.simulink.viewer.subSystem pattern,
 * providing pattern-specific query methods.
 * 
 * <p>Use the pattern matcher on a given model via {@link #on(IncQueryEngine)},
 * e.g. in conjunction with {@link IncQueryEngine#on(Notifier)}.
 * 
 * <p>Matches of the pattern will be represented as {@link SubSystemMatch}.
 * 
 * <p>Original source:
 * <code><pre>
 * {@literal @}Item(item = subS, label = "$subS.tag$ $subS$")
 * {@literal @}Format(color = "#F0FFFF", textColor = "#FFFFFF")
 * {@literal @}QueryExplorer(display=true)
 * pattern subSystem(subS) {
 * 	SubSystem(subS);
 * 	find subBlocks(subS, _bl);
 * }
 * </pre></code>
 * 
 * @see SubSystemMatch
 * @see SubSystemProcessor
 * @see SubSystemQuerySpecification
 * 
 */
@SuppressWarnings("all")
public class SubSystemMatcher extends BaseMatcher<SubSystemMatch> {
  /**
   * @return the singleton instance of the query specification of this pattern
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static IQuerySpecification<SubSystemMatcher> querySpecification() throws IncQueryException {
    return SubSystemQuerySpecification.instance();
  }
  
  /**
   * Initializes the pattern matcher within an existing EMF-IncQuery engine.
   * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
   * The match set will be incrementally refreshed upon updates.
   * @param engine the existing EMF-IncQuery engine in which this matcher will be created.
   * @throws IncQueryException if an error occurs during pattern matcher creation
   * 
   */
  public static SubSystemMatcher on(final IncQueryEngine engine) throws IncQueryException {
    // check if matcher already exists
    SubSystemMatcher matcher = engine.getExistingMatcher(querySpecification());
    if (matcher == null) {
    	matcher = new SubSystemMatcher(engine);
    	// do not have to "put" it into engine.matchers, reportMatcherInitialized() will take care of it
    }
    return matcher;
  }
  
  private final static int POSITION_SUBS = 0;
  
  private final static Logger LOGGER = IncQueryLoggingUtil.getLogger(SubSystemMatcher.class);
  
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
  public SubSystemMatcher(final Notifier emfRoot) throws IncQueryException {
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
  public SubSystemMatcher(final IncQueryEngine engine) throws IncQueryException {
    super(engine, querySpecification());
  }
  
  /**
   * Returns the set of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pSubS the fixed value of pattern parameter subS, or null if not bound.
   * @return matches represented as a SubSystemMatch object.
   * 
   */
  public Collection<SubSystemMatch> getAllMatches(final SubSystem pSubS) {
    return rawGetAllMatches(new Object[]{pSubS});
  }
  
  /**
   * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pSubS the fixed value of pattern parameter subS, or null if not bound.
   * @return a match represented as a SubSystemMatch object, or null if no match is found.
   * 
   */
  public SubSystemMatch getOneArbitraryMatch(final SubSystem pSubS) {
    return rawGetOneArbitraryMatch(new Object[]{pSubS});
  }
  
  /**
   * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
   * under any possible substitution of the unspecified parameters (if any).
   * @param pSubS the fixed value of pattern parameter subS, or null if not bound.
   * @return true if the input is a valid (partial) match of the pattern.
   * 
   */
  public boolean hasMatch(final SubSystem pSubS) {
    return rawHasMatch(new Object[]{pSubS});
  }
  
  /**
   * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pSubS the fixed value of pattern parameter subS, or null if not bound.
   * @return the number of pattern matches found.
   * 
   */
  public int countMatches(final SubSystem pSubS) {
    return rawCountMatches(new Object[]{pSubS});
  }
  
  /**
   * Executes the given processor on each match of the pattern that conforms to the given fixed values of some parameters.
   * @param pSubS the fixed value of pattern parameter subS, or null if not bound.
   * @param processor the action that will process each pattern match.
   * 
   */
  public void forEachMatch(final SubSystem pSubS, final IMatchProcessor<? super SubSystemMatch> processor) {
    rawForEachMatch(new Object[]{pSubS}, processor);
  }
  
  /**
   * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pSubS the fixed value of pattern parameter subS, or null if not bound.
   * @param processor the action that will process the selected match.
   * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
   * 
   */
  public boolean forOneArbitraryMatch(final SubSystem pSubS, final IMatchProcessor<? super SubSystemMatch> processor) {
    return rawForOneArbitraryMatch(new Object[]{pSubS}, processor);
  }
  
  /**
   * Registers a new filtered delta monitor on this pattern matcher.
   * The DeltaMonitor can be used to track changes (delta) in the set of filtered pattern matches from now on, considering those matches only that conform to the given fixed values of some parameters.
   * It can also be reset to track changes from a later point in time,
   * and changes can even be acknowledged on an individual basis.
   * See {@link DeltaMonitor} for details.
   * @param fillAtStart if true, all current matches are reported as new match events; if false, the delta monitor starts empty.
   * @param pSubS the fixed value of pattern parameter subS, or null if not bound.
   * @return the delta monitor.
   * @deprecated use the IncQuery Databinding API (IncQueryObservables) instead.
   * 
   */
  @Deprecated
  public DeltaMonitor<SubSystemMatch> newFilteredDeltaMonitor(final boolean fillAtStart, final SubSystem pSubS) {
    return rawNewFilteredDeltaMonitor(fillAtStart, new Object[]{pSubS});
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pSubS the fixed value of pattern parameter subS, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public SubSystemMatch newMatch(final SubSystem pSubS) {
    return SubSystemMatch.newMatch(pSubS);
    
  }
  
  /**
   * Retrieve the set of values that occur in matches for subS.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<SubSystem> rawAccumulateAllValuesOfsubS(final Object[] parameters) {
    Set<SubSystem> results = new HashSet<SubSystem>();
    rawAccumulateAllValues(POSITION_SUBS, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for subS.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<SubSystem> getAllValuesOfsubS() {
    return rawAccumulateAllValuesOfsubS(emptyArray());
  }
  
  @Override
  protected SubSystemMatch tupleToMatch(final Tuple t) {
    try {
      return SubSystemMatch.newMatch((hu.bme.mit.massif.simulink.SubSystem) t.get(POSITION_SUBS));
    } catch(ClassCastException e) {
      LOGGER.error("Element(s) in tuple not properly typed!",e);
      return null;
    }
    
  }
  
  @Override
  protected SubSystemMatch arrayToMatch(final Object[] match) {
    try {
      return SubSystemMatch.newMatch((hu.bme.mit.massif.simulink.SubSystem) match[POSITION_SUBS]);
    } catch(ClassCastException e) {
      LOGGER.error("Element(s) in array not properly typed!",e);
      return null;
    }
    
  }
  
  @Override
  protected SubSystemMatch arrayToMatchMutable(final Object[] match) {
    try {
      return SubSystemMatch.newMutableMatch((hu.bme.mit.massif.simulink.SubSystem) match[POSITION_SUBS]);
    } catch(ClassCastException e) {
      LOGGER.error("Element(s) in array not properly typed!",e);
      return null;
    }
    
  }
}
