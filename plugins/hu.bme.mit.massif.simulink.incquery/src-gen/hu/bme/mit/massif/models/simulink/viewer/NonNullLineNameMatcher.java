package hu.bme.mit.massif.models.simulink.viewer;

import hu.bme.mit.massif.models.simulink.viewer.NonNullLineNameMatch;
import hu.bme.mit.massif.models.simulink.viewer.util.NonNullLineNameQuerySpecification;
import hu.bme.mit.massif.simulink.Connection;
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
 * Generated pattern matcher API of the hu.bme.mit.massif.models.simulink.viewer.nonNullLineName pattern,
 * providing pattern-specific query methods.
 * 
 * <p>Use the pattern matcher on a given model via {@link #on(IncQueryEngine)},
 * e.g. in conjunction with {@link IncQueryEngine#on(Notifier)}.
 * 
 * <p>Matches of the pattern will be represented as {@link NonNullLineNameMatch}.
 * 
 * <p>Original source:
 * <code><pre>
 * connection is either:
 *   - block-to-block when neither has subBlocks
 *   - portBlock-to-block when the source is contained by the parent of the target
 *   - block-to-portBlock when the target is contained by the parent of the source
 *   - portBlock-to-portBlock when the target and the source are in different subsystems 
 *  
 * pattern nonNullLineName(conn, name) {
 * 	find lineName(conn, name);
 * } or {
 * 	Connection(conn);
 * 	neg find lineName(conn, _noname);
 * 	name == "";
 * }
 * </pre></code>
 * 
 * @see NonNullLineNameMatch
 * @see NonNullLineNameProcessor
 * @see NonNullLineNameQuerySpecification
 * 
 */
@SuppressWarnings("all")
public class NonNullLineNameMatcher extends BaseMatcher<NonNullLineNameMatch> {
  /**
   * @return the singleton instance of the query specification of this pattern
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static IQuerySpecification<NonNullLineNameMatcher> querySpecification() throws IncQueryException {
    return NonNullLineNameQuerySpecification.instance();
  }
  
  /**
   * Initializes the pattern matcher within an existing EMF-IncQuery engine.
   * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
   * The match set will be incrementally refreshed upon updates.
   * @param engine the existing EMF-IncQuery engine in which this matcher will be created.
   * @throws IncQueryException if an error occurs during pattern matcher creation
   * 
   */
  public static NonNullLineNameMatcher on(final IncQueryEngine engine) throws IncQueryException {
    // check if matcher already exists
    NonNullLineNameMatcher matcher = engine.getExistingMatcher(querySpecification());
    if (matcher == null) {
    	matcher = new NonNullLineNameMatcher(engine);
    	// do not have to "put" it into engine.matchers, reportMatcherInitialized() will take care of it
    }
    return matcher;
  }
  
  private final static int POSITION_CONN = 0;
  
  private final static int POSITION_NAME = 1;
  
  private final static Logger LOGGER = IncQueryLoggingUtil.getLogger(NonNullLineNameMatcher.class);
  
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
  public NonNullLineNameMatcher(final Notifier emfRoot) throws IncQueryException {
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
  public NonNullLineNameMatcher(final IncQueryEngine engine) throws IncQueryException {
    super(engine, querySpecification());
  }
  
  /**
   * Returns the set of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pConn the fixed value of pattern parameter conn, or null if not bound.
   * @param pName the fixed value of pattern parameter name, or null if not bound.
   * @return matches represented as a NonNullLineNameMatch object.
   * 
   */
  public Collection<NonNullLineNameMatch> getAllMatches(final Connection pConn, final String pName) {
    return rawGetAllMatches(new Object[]{pConn, pName});
  }
  
  /**
   * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pConn the fixed value of pattern parameter conn, or null if not bound.
   * @param pName the fixed value of pattern parameter name, or null if not bound.
   * @return a match represented as a NonNullLineNameMatch object, or null if no match is found.
   * 
   */
  public NonNullLineNameMatch getOneArbitraryMatch(final Connection pConn, final String pName) {
    return rawGetOneArbitraryMatch(new Object[]{pConn, pName});
  }
  
  /**
   * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
   * under any possible substitution of the unspecified parameters (if any).
   * @param pConn the fixed value of pattern parameter conn, or null if not bound.
   * @param pName the fixed value of pattern parameter name, or null if not bound.
   * @return true if the input is a valid (partial) match of the pattern.
   * 
   */
  public boolean hasMatch(final Connection pConn, final String pName) {
    return rawHasMatch(new Object[]{pConn, pName});
  }
  
  /**
   * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pConn the fixed value of pattern parameter conn, or null if not bound.
   * @param pName the fixed value of pattern parameter name, or null if not bound.
   * @return the number of pattern matches found.
   * 
   */
  public int countMatches(final Connection pConn, final String pName) {
    return rawCountMatches(new Object[]{pConn, pName});
  }
  
  /**
   * Executes the given processor on each match of the pattern that conforms to the given fixed values of some parameters.
   * @param pConn the fixed value of pattern parameter conn, or null if not bound.
   * @param pName the fixed value of pattern parameter name, or null if not bound.
   * @param processor the action that will process each pattern match.
   * 
   */
  public void forEachMatch(final Connection pConn, final String pName, final IMatchProcessor<? super NonNullLineNameMatch> processor) {
    rawForEachMatch(new Object[]{pConn, pName}, processor);
  }
  
  /**
   * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pConn the fixed value of pattern parameter conn, or null if not bound.
   * @param pName the fixed value of pattern parameter name, or null if not bound.
   * @param processor the action that will process the selected match.
   * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
   * 
   */
  public boolean forOneArbitraryMatch(final Connection pConn, final String pName, final IMatchProcessor<? super NonNullLineNameMatch> processor) {
    return rawForOneArbitraryMatch(new Object[]{pConn, pName}, processor);
  }
  
  /**
   * Registers a new filtered delta monitor on this pattern matcher.
   * The DeltaMonitor can be used to track changes (delta) in the set of filtered pattern matches from now on, considering those matches only that conform to the given fixed values of some parameters.
   * It can also be reset to track changes from a later point in time,
   * and changes can even be acknowledged on an individual basis.
   * See {@link DeltaMonitor} for details.
   * @param fillAtStart if true, all current matches are reported as new match events; if false, the delta monitor starts empty.
   * @param pConn the fixed value of pattern parameter conn, or null if not bound.
   * @param pName the fixed value of pattern parameter name, or null if not bound.
   * @return the delta monitor.
   * @deprecated use the IncQuery Databinding API (IncQueryObservables) instead.
   * 
   */
  @Deprecated
  public DeltaMonitor<NonNullLineNameMatch> newFilteredDeltaMonitor(final boolean fillAtStart, final Connection pConn, final String pName) {
    return rawNewFilteredDeltaMonitor(fillAtStart, new Object[]{pConn, pName});
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pConn the fixed value of pattern parameter conn, or null if not bound.
   * @param pName the fixed value of pattern parameter name, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public NonNullLineNameMatch newMatch(final Connection pConn, final String pName) {
    return NonNullLineNameMatch.newMatch(pConn, pName);
    
  }
  
  /**
   * Retrieve the set of values that occur in matches for conn.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<Connection> rawAccumulateAllValuesOfconn(final Object[] parameters) {
    Set<Connection> results = new HashSet<Connection>();
    rawAccumulateAllValues(POSITION_CONN, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for conn.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Connection> getAllValuesOfconn() {
    return rawAccumulateAllValuesOfconn(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for conn.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Connection> getAllValuesOfconn(final NonNullLineNameMatch partialMatch) {
    return rawAccumulateAllValuesOfconn(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for conn.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Connection> getAllValuesOfconn(final String pName) {
    return rawAccumulateAllValuesOfconn(new Object[]{null, pName});
  }
  
  /**
   * Retrieve the set of values that occur in matches for name.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<String> rawAccumulateAllValuesOfname(final Object[] parameters) {
    Set<String> results = new HashSet<String>();
    rawAccumulateAllValues(POSITION_NAME, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for name.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<String> getAllValuesOfname() {
    return rawAccumulateAllValuesOfname(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for name.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<String> getAllValuesOfname(final NonNullLineNameMatch partialMatch) {
    return rawAccumulateAllValuesOfname(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for name.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<String> getAllValuesOfname(final Connection pConn) {
    return rawAccumulateAllValuesOfname(new Object[]{pConn, null});
  }
  
  @Override
  protected NonNullLineNameMatch tupleToMatch(final Tuple t) {
    try {
      return NonNullLineNameMatch.newMatch((hu.bme.mit.massif.simulink.Connection) t.get(POSITION_CONN), (java.lang.String) t.get(POSITION_NAME));
    } catch(ClassCastException e) {
      LOGGER.error("Element(s) in tuple not properly typed!",e);
      return null;
    }
    
  }
  
  @Override
  protected NonNullLineNameMatch arrayToMatch(final Object[] match) {
    try {
      return NonNullLineNameMatch.newMatch((hu.bme.mit.massif.simulink.Connection) match[POSITION_CONN], (java.lang.String) match[POSITION_NAME]);
    } catch(ClassCastException e) {
      LOGGER.error("Element(s) in array not properly typed!",e);
      return null;
    }
    
  }
  
  @Override
  protected NonNullLineNameMatch arrayToMatchMutable(final Object[] match) {
    try {
      return NonNullLineNameMatch.newMutableMatch((hu.bme.mit.massif.simulink.Connection) match[POSITION_CONN], (java.lang.String) match[POSITION_NAME]);
    } catch(ClassCastException e) {
      LOGGER.error("Element(s) in array not properly typed!",e);
      return null;
    }
    
  }
}
