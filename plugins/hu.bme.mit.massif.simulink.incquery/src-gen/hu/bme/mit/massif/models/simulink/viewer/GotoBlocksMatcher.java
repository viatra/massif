package hu.bme.mit.massif.models.simulink.viewer;

import hu.bme.mit.massif.models.simulink.viewer.GotoBlocksMatch;
import hu.bme.mit.massif.models.simulink.viewer.util.GotoBlocksQuerySpecification;
import hu.bme.mit.massif.simulink.Goto;
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
import org.eclipse.incquery.runtime.util.IncQueryLoggingUtil;

/**
 * Generated pattern matcher API of the hu.bme.mit.massif.models.simulink.viewer.gotoBlocks pattern,
 * providing pattern-specific query methods.
 * 
 * <p>Use the pattern matcher on a given model via {@link #on(IncQueryEngine)},
 * e.g. in conjunction with {@link IncQueryEngine#on(Notifier)}.
 * 
 * <p>Matches of the pattern will be represented as {@link GotoBlocksMatch}.
 * 
 * <p>Original source:
 * <code><pre>
 * {@literal @}Item(item = bl, label = "Goto")
 * {@literal @}Format(color = "#F5F5F5", textColor = "#191970")
 * {@literal @}QueryExplorer(display=true)
 * pattern gotoBlocks(bl) {
 * 	Goto(bl);
 * }
 * </pre></code>
 * 
 * @see GotoBlocksMatch
 * @see GotoBlocksProcessor
 * @see GotoBlocksQuerySpecification
 * 
 */
@SuppressWarnings("all")
public class GotoBlocksMatcher extends BaseMatcher<GotoBlocksMatch> {
  /**
   * Initializes the pattern matcher within an existing EMF-IncQuery engine.
   * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
   * The match set will be incrementally refreshed upon updates.
   * @param engine the existing EMF-IncQuery engine in which this matcher will be created.
   * @throws IncQueryException if an error occurs during pattern matcher creation
   * 
   */
  public static GotoBlocksMatcher on(final IncQueryEngine engine) throws IncQueryException {
    // check if matcher already exists
    GotoBlocksMatcher matcher = engine.getExistingMatcher(querySpecification());
    if (matcher == null) {
    	matcher = new GotoBlocksMatcher(engine);
    	// do not have to "put" it into engine.matchers, reportMatcherInitialized() will take care of it
    }
    return matcher;
  }
  
  private final static int POSITION_BL = 0;
  
  private final static Logger LOGGER = IncQueryLoggingUtil.getLogger(GotoBlocksMatcher.class);
  
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
  public GotoBlocksMatcher(final Notifier emfRoot) throws IncQueryException {
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
  public GotoBlocksMatcher(final IncQueryEngine engine) throws IncQueryException {
    super(engine, querySpecification());
  }
  
  /**
   * Returns the set of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pBl the fixed value of pattern parameter bl, or null if not bound.
   * @return matches represented as a GotoBlocksMatch object.
   * 
   */
  public Collection<GotoBlocksMatch> getAllMatches(final Goto pBl) {
    return rawGetAllMatches(new Object[]{pBl});
  }
  
  /**
   * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pBl the fixed value of pattern parameter bl, or null if not bound.
   * @return a match represented as a GotoBlocksMatch object, or null if no match is found.
   * 
   */
  public GotoBlocksMatch getOneArbitraryMatch(final Goto pBl) {
    return rawGetOneArbitraryMatch(new Object[]{pBl});
  }
  
  /**
   * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
   * under any possible substitution of the unspecified parameters (if any).
   * @param pBl the fixed value of pattern parameter bl, or null if not bound.
   * @return true if the input is a valid (partial) match of the pattern.
   * 
   */
  public boolean hasMatch(final Goto pBl) {
    return rawHasMatch(new Object[]{pBl});
  }
  
  /**
   * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pBl the fixed value of pattern parameter bl, or null if not bound.
   * @return the number of pattern matches found.
   * 
   */
  public int countMatches(final Goto pBl) {
    return rawCountMatches(new Object[]{pBl});
  }
  
  /**
   * Executes the given processor on each match of the pattern that conforms to the given fixed values of some parameters.
   * @param pBl the fixed value of pattern parameter bl, or null if not bound.
   * @param processor the action that will process each pattern match.
   * 
   */
  public void forEachMatch(final Goto pBl, final IMatchProcessor<? super GotoBlocksMatch> processor) {
    rawForEachMatch(new Object[]{pBl}, processor);
  }
  
  /**
   * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pBl the fixed value of pattern parameter bl, or null if not bound.
   * @param processor the action that will process the selected match.
   * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
   * 
   */
  public boolean forOneArbitraryMatch(final Goto pBl, final IMatchProcessor<? super GotoBlocksMatch> processor) {
    return rawForOneArbitraryMatch(new Object[]{pBl}, processor);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pBl the fixed value of pattern parameter bl, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public GotoBlocksMatch newMatch(final Goto pBl) {
    return GotoBlocksMatch.newMatch(pBl);
  }
  
  /**
   * Retrieve the set of values that occur in matches for bl.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<Goto> rawAccumulateAllValuesOfbl(final Object[] parameters) {
    Set<Goto> results = new HashSet<Goto>();
    rawAccumulateAllValues(POSITION_BL, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for bl.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Goto> getAllValuesOfbl() {
    return rawAccumulateAllValuesOfbl(emptyArray());
  }
  
  @Override
  protected GotoBlocksMatch tupleToMatch(final Tuple t) {
    try {
    	return GotoBlocksMatch.newMatch((hu.bme.mit.massif.simulink.Goto) t.get(POSITION_BL));
    } catch(ClassCastException e) {
    	LOGGER.error("Element(s) in tuple not properly typed!",e);
    	return null;
    }
  }
  
  @Override
  protected GotoBlocksMatch arrayToMatch(final Object[] match) {
    try {
    	return GotoBlocksMatch.newMatch((hu.bme.mit.massif.simulink.Goto) match[POSITION_BL]);
    } catch(ClassCastException e) {
    	LOGGER.error("Element(s) in array not properly typed!",e);
    	return null;
    }
  }
  
  @Override
  protected GotoBlocksMatch arrayToMatchMutable(final Object[] match) {
    try {
    	return GotoBlocksMatch.newMutableMatch((hu.bme.mit.massif.simulink.Goto) match[POSITION_BL]);
    } catch(ClassCastException e) {
    	LOGGER.error("Element(s) in array not properly typed!",e);
    	return null;
    }
  }
  
  /**
   * @return the singleton instance of the query specification of this pattern
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static IQuerySpecification<GotoBlocksMatcher> querySpecification() throws IncQueryException {
    return GotoBlocksQuerySpecification.instance();
  }
}