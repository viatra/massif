package hu.bme.mit.transima.models.simulink.util;

import hu.bme.mit.transima.Simulink.OutPort;
import hu.bme.mit.transima.Simulink.SingleConnection;
import hu.bme.mit.transima.models.simulink.util.SimpleOutPortToOutPortConnectionMatch;
import hu.bme.mit.transima.models.simulink.util.util.SimpleOutPortToOutPortConnectionQuerySpecification;
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
 * Generated pattern matcher API of the hu.bme.mit.transima.models.simulink.util.simpleOutPortToOutPortConnection pattern,
 * providing pattern-specific query methods.
 * 
 * <p>Use the pattern matcher on a given model via {@link #on(IncQueryEngine)},
 * e.g. in conjunction with {@link IncQueryEngine#on(Notifier)}.
 * 
 * <p>Matches of the pattern will be represented as {@link SimpleOutPortToOutPortConnectionMatch}.
 * 
 * <p>Original source:
 * <code><pre>
 * pattern simpleOutPortToOutPortConnection(sourceOutPort, targetOutPort, connection) {
 * 	find portConnection(sourceOutPort, gotoInPort, connection);
 * 	find gotoConnectedPorts(gotoInPort, targetOutPort);
 * } or {
 * 	find portConnection(sourceOutPort, pBlIn, connection);
 * 	find portBlockInPortToOutPort(pBlIn, targetOutPort);
 * } or {
 * 	find portConnection(sourceOutPort, inPort, connection);
 * 	find inPortToBlockPortOutPort(inPort, targetOutPort);
 * }
 * </pre></code>
 * 
 * @see SimpleOutPortToOutPortConnectionMatch
 * @see SimpleOutPortToOutPortConnectionProcessor
 * @see SimpleOutPortToOutPortConnectionQuerySpecification
 * 
 */
@SuppressWarnings("all")
public class SimpleOutPortToOutPortConnectionMatcher extends BaseMatcher<SimpleOutPortToOutPortConnectionMatch> {
  /**
   * @return the singleton instance of the query specification of this pattern
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static IQuerySpecification<SimpleOutPortToOutPortConnectionMatcher> querySpecification() throws IncQueryException {
    return SimpleOutPortToOutPortConnectionQuerySpecification.instance();
  }
  
  /**
   * Initializes the pattern matcher within an existing EMF-IncQuery engine.
   * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
   * The match set will be incrementally refreshed upon updates.
   * @param engine the existing EMF-IncQuery engine in which this matcher will be created.
   * @throws IncQueryException if an error occurs during pattern matcher creation
   * 
   */
  public static SimpleOutPortToOutPortConnectionMatcher on(final IncQueryEngine engine) throws IncQueryException {
    // check if matcher already exists
    SimpleOutPortToOutPortConnectionMatcher matcher = engine.getExistingMatcher(querySpecification());
    if (matcher == null) {
    	matcher = new SimpleOutPortToOutPortConnectionMatcher(engine);
    	// do not have to "put" it into engine.matchers, reportMatcherInitialized() will take care of it
    }
    return matcher;
  }
  
  private final static int POSITION_SOURCEOUTPORT = 0;
  
  private final static int POSITION_TARGETOUTPORT = 1;
  
  private final static int POSITION_CONNECTION = 2;
  
  private final static Logger LOGGER = IncQueryLoggingUtil.getLogger(SimpleOutPortToOutPortConnectionMatcher.class);
  
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
  public SimpleOutPortToOutPortConnectionMatcher(final Notifier emfRoot) throws IncQueryException {
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
  public SimpleOutPortToOutPortConnectionMatcher(final IncQueryEngine engine) throws IncQueryException {
    super(engine, querySpecification());
  }
  
  /**
   * Returns the set of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pSourceOutPort the fixed value of pattern parameter sourceOutPort, or null if not bound.
   * @param pTargetOutPort the fixed value of pattern parameter targetOutPort, or null if not bound.
   * @param pConnection the fixed value of pattern parameter connection, or null if not bound.
   * @return matches represented as a SimpleOutPortToOutPortConnectionMatch object.
   * 
   */
  public Collection<SimpleOutPortToOutPortConnectionMatch> getAllMatches(final OutPort pSourceOutPort, final OutPort pTargetOutPort, final SingleConnection pConnection) {
    return rawGetAllMatches(new Object[]{pSourceOutPort, pTargetOutPort, pConnection});
  }
  
  /**
   * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pSourceOutPort the fixed value of pattern parameter sourceOutPort, or null if not bound.
   * @param pTargetOutPort the fixed value of pattern parameter targetOutPort, or null if not bound.
   * @param pConnection the fixed value of pattern parameter connection, or null if not bound.
   * @return a match represented as a SimpleOutPortToOutPortConnectionMatch object, or null if no match is found.
   * 
   */
  public SimpleOutPortToOutPortConnectionMatch getOneArbitraryMatch(final OutPort pSourceOutPort, final OutPort pTargetOutPort, final SingleConnection pConnection) {
    return rawGetOneArbitraryMatch(new Object[]{pSourceOutPort, pTargetOutPort, pConnection});
  }
  
  /**
   * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
   * under any possible substitution of the unspecified parameters (if any).
   * @param pSourceOutPort the fixed value of pattern parameter sourceOutPort, or null if not bound.
   * @param pTargetOutPort the fixed value of pattern parameter targetOutPort, or null if not bound.
   * @param pConnection the fixed value of pattern parameter connection, or null if not bound.
   * @return true if the input is a valid (partial) match of the pattern.
   * 
   */
  public boolean hasMatch(final OutPort pSourceOutPort, final OutPort pTargetOutPort, final SingleConnection pConnection) {
    return rawHasMatch(new Object[]{pSourceOutPort, pTargetOutPort, pConnection});
  }
  
  /**
   * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pSourceOutPort the fixed value of pattern parameter sourceOutPort, or null if not bound.
   * @param pTargetOutPort the fixed value of pattern parameter targetOutPort, or null if not bound.
   * @param pConnection the fixed value of pattern parameter connection, or null if not bound.
   * @return the number of pattern matches found.
   * 
   */
  public int countMatches(final OutPort pSourceOutPort, final OutPort pTargetOutPort, final SingleConnection pConnection) {
    return rawCountMatches(new Object[]{pSourceOutPort, pTargetOutPort, pConnection});
  }
  
  /**
   * Executes the given processor on each match of the pattern that conforms to the given fixed values of some parameters.
   * @param pSourceOutPort the fixed value of pattern parameter sourceOutPort, or null if not bound.
   * @param pTargetOutPort the fixed value of pattern parameter targetOutPort, or null if not bound.
   * @param pConnection the fixed value of pattern parameter connection, or null if not bound.
   * @param processor the action that will process each pattern match.
   * 
   */
  public void forEachMatch(final OutPort pSourceOutPort, final OutPort pTargetOutPort, final SingleConnection pConnection, final IMatchProcessor<? super SimpleOutPortToOutPortConnectionMatch> processor) {
    rawForEachMatch(new Object[]{pSourceOutPort, pTargetOutPort, pConnection}, processor);
  }
  
  /**
   * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pSourceOutPort the fixed value of pattern parameter sourceOutPort, or null if not bound.
   * @param pTargetOutPort the fixed value of pattern parameter targetOutPort, or null if not bound.
   * @param pConnection the fixed value of pattern parameter connection, or null if not bound.
   * @param processor the action that will process the selected match.
   * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
   * 
   */
  public boolean forOneArbitraryMatch(final OutPort pSourceOutPort, final OutPort pTargetOutPort, final SingleConnection pConnection, final IMatchProcessor<? super SimpleOutPortToOutPortConnectionMatch> processor) {
    return rawForOneArbitraryMatch(new Object[]{pSourceOutPort, pTargetOutPort, pConnection}, processor);
  }
  
  /**
   * Registers a new filtered delta monitor on this pattern matcher.
   * The DeltaMonitor can be used to track changes (delta) in the set of filtered pattern matches from now on, considering those matches only that conform to the given fixed values of some parameters.
   * It can also be reset to track changes from a later point in time,
   * and changes can even be acknowledged on an individual basis.
   * See {@link DeltaMonitor} for details.
   * @param fillAtStart if true, all current matches are reported as new match events; if false, the delta monitor starts empty.
   * @param pSourceOutPort the fixed value of pattern parameter sourceOutPort, or null if not bound.
   * @param pTargetOutPort the fixed value of pattern parameter targetOutPort, or null if not bound.
   * @param pConnection the fixed value of pattern parameter connection, or null if not bound.
   * @return the delta monitor.
   * @deprecated use the IncQuery Databinding API (IncQueryObservables) instead.
   * 
   */
  public DeltaMonitor<SimpleOutPortToOutPortConnectionMatch> newFilteredDeltaMonitor(final boolean fillAtStart, final OutPort pSourceOutPort, final OutPort pTargetOutPort, final SingleConnection pConnection) {
    return rawNewFilteredDeltaMonitor(fillAtStart, new Object[]{pSourceOutPort, pTargetOutPort, pConnection});
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pSourceOutPort the fixed value of pattern parameter sourceOutPort, or null if not bound.
   * @param pTargetOutPort the fixed value of pattern parameter targetOutPort, or null if not bound.
   * @param pConnection the fixed value of pattern parameter connection, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public SimpleOutPortToOutPortConnectionMatch newMatch(final OutPort pSourceOutPort, final OutPort pTargetOutPort, final SingleConnection pConnection) {
    return SimpleOutPortToOutPortConnectionMatch.newMatch(pSourceOutPort, pTargetOutPort, pConnection);
    
  }
  
  /**
   * Retrieve the set of values that occur in matches for sourceOutPort.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<OutPort> rawAccumulateAllValuesOfsourceOutPort(final Object[] parameters) {
    Set<OutPort> results = new HashSet<OutPort>();
    rawAccumulateAllValues(POSITION_SOURCEOUTPORT, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for sourceOutPort.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<OutPort> getAllValuesOfsourceOutPort() {
    return rawAccumulateAllValuesOfsourceOutPort(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for sourceOutPort.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<OutPort> getAllValuesOfsourceOutPort(final SimpleOutPortToOutPortConnectionMatch partialMatch) {
    return rawAccumulateAllValuesOfsourceOutPort(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for sourceOutPort.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<OutPort> getAllValuesOfsourceOutPort(final OutPort pTargetOutPort, final SingleConnection pConnection) {
    return rawAccumulateAllValuesOfsourceOutPort(new Object[]{null, pTargetOutPort, pConnection});
  }
  
  /**
   * Retrieve the set of values that occur in matches for targetOutPort.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<OutPort> rawAccumulateAllValuesOftargetOutPort(final Object[] parameters) {
    Set<OutPort> results = new HashSet<OutPort>();
    rawAccumulateAllValues(POSITION_TARGETOUTPORT, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for targetOutPort.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<OutPort> getAllValuesOftargetOutPort() {
    return rawAccumulateAllValuesOftargetOutPort(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for targetOutPort.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<OutPort> getAllValuesOftargetOutPort(final SimpleOutPortToOutPortConnectionMatch partialMatch) {
    return rawAccumulateAllValuesOftargetOutPort(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for targetOutPort.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<OutPort> getAllValuesOftargetOutPort(final OutPort pSourceOutPort, final SingleConnection pConnection) {
    return rawAccumulateAllValuesOftargetOutPort(new Object[]{pSourceOutPort, null, pConnection});
  }
  
  /**
   * Retrieve the set of values that occur in matches for connection.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<SingleConnection> rawAccumulateAllValuesOfconnection(final Object[] parameters) {
    Set<SingleConnection> results = new HashSet<SingleConnection>();
    rawAccumulateAllValues(POSITION_CONNECTION, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for connection.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<SingleConnection> getAllValuesOfconnection() {
    return rawAccumulateAllValuesOfconnection(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for connection.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<SingleConnection> getAllValuesOfconnection(final SimpleOutPortToOutPortConnectionMatch partialMatch) {
    return rawAccumulateAllValuesOfconnection(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for connection.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<SingleConnection> getAllValuesOfconnection(final OutPort pSourceOutPort, final OutPort pTargetOutPort) {
    return rawAccumulateAllValuesOfconnection(new Object[]{pSourceOutPort, pTargetOutPort, null});
  }
  
  protected SimpleOutPortToOutPortConnectionMatch tupleToMatch(final Tuple t) {
    try {
      return SimpleOutPortToOutPortConnectionMatch.newMatch((hu.bme.mit.transima.Simulink.OutPort) t.get(POSITION_SOURCEOUTPORT), (hu.bme.mit.transima.Simulink.OutPort) t.get(POSITION_TARGETOUTPORT), (hu.bme.mit.transima.Simulink.SingleConnection) t.get(POSITION_CONNECTION));
    } catch(ClassCastException e) {
      LOGGER.error("Element(s) in tuple not properly typed!",e);
      return null;
    }
    
  }
  
  protected SimpleOutPortToOutPortConnectionMatch arrayToMatch(final Object[] match) {
    try {
      return SimpleOutPortToOutPortConnectionMatch.newMatch((hu.bme.mit.transima.Simulink.OutPort) match[POSITION_SOURCEOUTPORT], (hu.bme.mit.transima.Simulink.OutPort) match[POSITION_TARGETOUTPORT], (hu.bme.mit.transima.Simulink.SingleConnection) match[POSITION_CONNECTION]);
    } catch(ClassCastException e) {
      LOGGER.error("Element(s) in array not properly typed!",e);
      return null;
    }
    
  }
  
  protected SimpleOutPortToOutPortConnectionMatch arrayToMatchMutable(final Object[] match) {
    try {
      return SimpleOutPortToOutPortConnectionMatch.newMutableMatch((hu.bme.mit.transima.Simulink.OutPort) match[POSITION_SOURCEOUTPORT], (hu.bme.mit.transima.Simulink.OutPort) match[POSITION_TARGETOUTPORT], (hu.bme.mit.transima.Simulink.SingleConnection) match[POSITION_CONNECTION]);
    } catch(ClassCastException e) {
      LOGGER.error("Element(s) in array not properly typed!",e);
      return null;
    }
    
  }
}
