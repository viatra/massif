package hu.bme.mit.massif.models.simulink.util;

import hu.bme.mit.massif.models.simulink.util.SimpleConnectedOutPortMatch;
import hu.bme.mit.massif.models.simulink.util.util.SimpleConnectedOutPortQuerySpecification;
import hu.bme.mit.massif.simulink.OutPort;
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
 * Generated pattern matcher API of the hu.bme.mit.massif.models.simulink.util.simpleConnectedOutPort pattern,
 * providing pattern-specific query methods.
 * 
 * <p>Use the pattern matcher on a given model via {@link #on(IncQueryEngine)},
 * e.g. in conjunction with {@link IncQueryEngine#on(Notifier)}.
 * 
 * <p>Matches of the pattern will be represented as {@link SimpleConnectedOutPortMatch}.
 * 
 * <p>Original source:
 * <code><pre>
 * pattern simpleConnectedOutPort(sourceOutPort : OutPort, targetOutPort : OutPort) {
 * 	find simpleOutPortToOutPortConnection(sourceOutPort, targetOutPort, _pc);
 * }
 * </pre></code>
 * 
 * @see SimpleConnectedOutPortMatch
 * @see SimpleConnectedOutPortProcessor
 * @see SimpleConnectedOutPortQuerySpecification
 * 
 */
@SuppressWarnings("all")
public class SimpleConnectedOutPortMatcher extends BaseMatcher<SimpleConnectedOutPortMatch> {
  /**
   * Initializes the pattern matcher within an existing EMF-IncQuery engine.
   * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
   * The match set will be incrementally refreshed upon updates.
   * @param engine the existing EMF-IncQuery engine in which this matcher will be created.
   * @throws IncQueryException if an error occurs during pattern matcher creation
   * 
   */
  public static SimpleConnectedOutPortMatcher on(final IncQueryEngine engine) throws IncQueryException {
    // check if matcher already exists
    SimpleConnectedOutPortMatcher matcher = engine.getExistingMatcher(querySpecification());
    if (matcher == null) {
    	matcher = new SimpleConnectedOutPortMatcher(engine);
    	// do not have to "put" it into engine.matchers, reportMatcherInitialized() will take care of it
    }
    return matcher;
  }
  
  private final static int POSITION_SOURCEOUTPORT = 0;
  
  private final static int POSITION_TARGETOUTPORT = 1;
  
  private final static Logger LOGGER = IncQueryLoggingUtil.getLogger(SimpleConnectedOutPortMatcher.class);
  
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
  public SimpleConnectedOutPortMatcher(final Notifier emfRoot) throws IncQueryException {
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
  public SimpleConnectedOutPortMatcher(final IncQueryEngine engine) throws IncQueryException {
    super(engine, querySpecification());
  }
  
  /**
   * Returns the set of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pSourceOutPort the fixed value of pattern parameter sourceOutPort, or null if not bound.
   * @param pTargetOutPort the fixed value of pattern parameter targetOutPort, or null if not bound.
   * @return matches represented as a SimpleConnectedOutPortMatch object.
   * 
   */
  public Collection<SimpleConnectedOutPortMatch> getAllMatches(final OutPort pSourceOutPort, final OutPort pTargetOutPort) {
    return rawGetAllMatches(new Object[]{pSourceOutPort, pTargetOutPort});
  }
  
  /**
   * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pSourceOutPort the fixed value of pattern parameter sourceOutPort, or null if not bound.
   * @param pTargetOutPort the fixed value of pattern parameter targetOutPort, or null if not bound.
   * @return a match represented as a SimpleConnectedOutPortMatch object, or null if no match is found.
   * 
   */
  public SimpleConnectedOutPortMatch getOneArbitraryMatch(final OutPort pSourceOutPort, final OutPort pTargetOutPort) {
    return rawGetOneArbitraryMatch(new Object[]{pSourceOutPort, pTargetOutPort});
  }
  
  /**
   * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
   * under any possible substitution of the unspecified parameters (if any).
   * @param pSourceOutPort the fixed value of pattern parameter sourceOutPort, or null if not bound.
   * @param pTargetOutPort the fixed value of pattern parameter targetOutPort, or null if not bound.
   * @return true if the input is a valid (partial) match of the pattern.
   * 
   */
  public boolean hasMatch(final OutPort pSourceOutPort, final OutPort pTargetOutPort) {
    return rawHasMatch(new Object[]{pSourceOutPort, pTargetOutPort});
  }
  
  /**
   * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pSourceOutPort the fixed value of pattern parameter sourceOutPort, or null if not bound.
   * @param pTargetOutPort the fixed value of pattern parameter targetOutPort, or null if not bound.
   * @return the number of pattern matches found.
   * 
   */
  public int countMatches(final OutPort pSourceOutPort, final OutPort pTargetOutPort) {
    return rawCountMatches(new Object[]{pSourceOutPort, pTargetOutPort});
  }
  
  /**
   * Executes the given processor on each match of the pattern that conforms to the given fixed values of some parameters.
   * @param pSourceOutPort the fixed value of pattern parameter sourceOutPort, or null if not bound.
   * @param pTargetOutPort the fixed value of pattern parameter targetOutPort, or null if not bound.
   * @param processor the action that will process each pattern match.
   * 
   */
  public void forEachMatch(final OutPort pSourceOutPort, final OutPort pTargetOutPort, final IMatchProcessor<? super SimpleConnectedOutPortMatch> processor) {
    rawForEachMatch(new Object[]{pSourceOutPort, pTargetOutPort}, processor);
  }
  
  /**
   * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pSourceOutPort the fixed value of pattern parameter sourceOutPort, or null if not bound.
   * @param pTargetOutPort the fixed value of pattern parameter targetOutPort, or null if not bound.
   * @param processor the action that will process the selected match.
   * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
   * 
   */
  public boolean forOneArbitraryMatch(final OutPort pSourceOutPort, final OutPort pTargetOutPort, final IMatchProcessor<? super SimpleConnectedOutPortMatch> processor) {
    return rawForOneArbitraryMatch(new Object[]{pSourceOutPort, pTargetOutPort}, processor);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pSourceOutPort the fixed value of pattern parameter sourceOutPort, or null if not bound.
   * @param pTargetOutPort the fixed value of pattern parameter targetOutPort, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public SimpleConnectedOutPortMatch newMatch(final OutPort pSourceOutPort, final OutPort pTargetOutPort) {
    return SimpleConnectedOutPortMatch.newMatch(pSourceOutPort, pTargetOutPort);
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
  public Set<OutPort> getAllValuesOfsourceOutPort(final SimpleConnectedOutPortMatch partialMatch) {
    return rawAccumulateAllValuesOfsourceOutPort(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for sourceOutPort.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<OutPort> getAllValuesOfsourceOutPort(final OutPort pTargetOutPort) {
    return rawAccumulateAllValuesOfsourceOutPort(new Object[]{
    null, 
    pTargetOutPort
    });
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
  public Set<OutPort> getAllValuesOftargetOutPort(final SimpleConnectedOutPortMatch partialMatch) {
    return rawAccumulateAllValuesOftargetOutPort(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for targetOutPort.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<OutPort> getAllValuesOftargetOutPort(final OutPort pSourceOutPort) {
    return rawAccumulateAllValuesOftargetOutPort(new Object[]{
    pSourceOutPort, 
    null
    });
  }
  
  @Override
  protected SimpleConnectedOutPortMatch tupleToMatch(final Tuple t) {
    try {
    	return SimpleConnectedOutPortMatch.newMatch((hu.bme.mit.massif.simulink.OutPort) t.get(POSITION_SOURCEOUTPORT), (hu.bme.mit.massif.simulink.OutPort) t.get(POSITION_TARGETOUTPORT));
    } catch(ClassCastException e) {
    	LOGGER.error("Element(s) in tuple not properly typed!",e);
    	return null;
    }
  }
  
  @Override
  protected SimpleConnectedOutPortMatch arrayToMatch(final Object[] match) {
    try {
    	return SimpleConnectedOutPortMatch.newMatch((hu.bme.mit.massif.simulink.OutPort) match[POSITION_SOURCEOUTPORT], (hu.bme.mit.massif.simulink.OutPort) match[POSITION_TARGETOUTPORT]);
    } catch(ClassCastException e) {
    	LOGGER.error("Element(s) in array not properly typed!",e);
    	return null;
    }
  }
  
  @Override
  protected SimpleConnectedOutPortMatch arrayToMatchMutable(final Object[] match) {
    try {
    	return SimpleConnectedOutPortMatch.newMutableMatch((hu.bme.mit.massif.simulink.OutPort) match[POSITION_SOURCEOUTPORT], (hu.bme.mit.massif.simulink.OutPort) match[POSITION_TARGETOUTPORT]);
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
  public static IQuerySpecification<SimpleConnectedOutPortMatcher> querySpecification() throws IncQueryException {
    return SimpleConnectedOutPortQuerySpecification.instance();
  }
}
