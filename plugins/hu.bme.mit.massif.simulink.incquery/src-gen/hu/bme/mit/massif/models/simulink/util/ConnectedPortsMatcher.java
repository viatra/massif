package hu.bme.mit.massif.models.simulink.util;

import hu.bme.mit.massif.models.simulink.util.ConnectedPortsMatch;
import hu.bme.mit.massif.models.simulink.util.util.ConnectedPortsQuerySpecification;
import hu.bme.mit.massif.simulink.InPort;
import hu.bme.mit.massif.simulink.OutPort;
import hu.bme.mit.massif.simulink.SingleConnection;
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
 * Generated pattern matcher API of the hu.bme.mit.massif.models.simulink.util.connectedPorts pattern,
 * providing pattern-specific query methods.
 * 
 * <p>Use the pattern matcher on a given model via {@link #on(IncQueryEngine)},
 * e.g. in conjunction with {@link IncQueryEngine#on(Notifier)}.
 * 
 * <p>Matches of the pattern will be represented as {@link ConnectedPortsMatch}.
 * 
 * <p>Original source:
 * <code><pre>
 * pattern connectedPorts(outP : OutPort, inP : InPort, firstPC : SingleConnection) {
 * 	find portConnection(outP, inP, firstPC);
 * } or {
 * 	find portConnection(outP, innerIP, firstPC);
 * 	find connectedInPorts(innerIP, inP);
 * }
 * </pre></code>
 * 
 * @see ConnectedPortsMatch
 * @see ConnectedPortsProcessor
 * @see ConnectedPortsQuerySpecification
 * 
 */
@SuppressWarnings("all")
public class ConnectedPortsMatcher extends BaseMatcher<ConnectedPortsMatch> {
  /**
   * Initializes the pattern matcher within an existing EMF-IncQuery engine.
   * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
   * The match set will be incrementally refreshed upon updates.
   * @param engine the existing EMF-IncQuery engine in which this matcher will be created.
   * @throws IncQueryException if an error occurs during pattern matcher creation
   * 
   */
  public static ConnectedPortsMatcher on(final IncQueryEngine engine) throws IncQueryException {
    // check if matcher already exists
    ConnectedPortsMatcher matcher = engine.getExistingMatcher(querySpecification());
    if (matcher == null) {
    	matcher = new ConnectedPortsMatcher(engine);
    	// do not have to "put" it into engine.matchers, reportMatcherInitialized() will take care of it
    }
    return matcher;
  }
  
  private final static int POSITION_OUTP = 0;
  
  private final static int POSITION_INP = 1;
  
  private final static int POSITION_FIRSTPC = 2;
  
  private final static Logger LOGGER = IncQueryLoggingUtil.getLogger(ConnectedPortsMatcher.class);
  
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
  public ConnectedPortsMatcher(final Notifier emfRoot) throws IncQueryException {
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
  public ConnectedPortsMatcher(final IncQueryEngine engine) throws IncQueryException {
    super(engine, querySpecification());
  }
  
  /**
   * Returns the set of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pOutP the fixed value of pattern parameter outP, or null if not bound.
   * @param pInP the fixed value of pattern parameter inP, or null if not bound.
   * @param pFirstPC the fixed value of pattern parameter firstPC, or null if not bound.
   * @return matches represented as a ConnectedPortsMatch object.
   * 
   */
  public Collection<ConnectedPortsMatch> getAllMatches(final OutPort pOutP, final InPort pInP, final SingleConnection pFirstPC) {
    return rawGetAllMatches(new Object[]{pOutP, pInP, pFirstPC});
  }
  
  /**
   * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pOutP the fixed value of pattern parameter outP, or null if not bound.
   * @param pInP the fixed value of pattern parameter inP, or null if not bound.
   * @param pFirstPC the fixed value of pattern parameter firstPC, or null if not bound.
   * @return a match represented as a ConnectedPortsMatch object, or null if no match is found.
   * 
   */
  public ConnectedPortsMatch getOneArbitraryMatch(final OutPort pOutP, final InPort pInP, final SingleConnection pFirstPC) {
    return rawGetOneArbitraryMatch(new Object[]{pOutP, pInP, pFirstPC});
  }
  
  /**
   * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
   * under any possible substitution of the unspecified parameters (if any).
   * @param pOutP the fixed value of pattern parameter outP, or null if not bound.
   * @param pInP the fixed value of pattern parameter inP, or null if not bound.
   * @param pFirstPC the fixed value of pattern parameter firstPC, or null if not bound.
   * @return true if the input is a valid (partial) match of the pattern.
   * 
   */
  public boolean hasMatch(final OutPort pOutP, final InPort pInP, final SingleConnection pFirstPC) {
    return rawHasMatch(new Object[]{pOutP, pInP, pFirstPC});
  }
  
  /**
   * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pOutP the fixed value of pattern parameter outP, or null if not bound.
   * @param pInP the fixed value of pattern parameter inP, or null if not bound.
   * @param pFirstPC the fixed value of pattern parameter firstPC, or null if not bound.
   * @return the number of pattern matches found.
   * 
   */
  public int countMatches(final OutPort pOutP, final InPort pInP, final SingleConnection pFirstPC) {
    return rawCountMatches(new Object[]{pOutP, pInP, pFirstPC});
  }
  
  /**
   * Executes the given processor on each match of the pattern that conforms to the given fixed values of some parameters.
   * @param pOutP the fixed value of pattern parameter outP, or null if not bound.
   * @param pInP the fixed value of pattern parameter inP, or null if not bound.
   * @param pFirstPC the fixed value of pattern parameter firstPC, or null if not bound.
   * @param processor the action that will process each pattern match.
   * 
   */
  public void forEachMatch(final OutPort pOutP, final InPort pInP, final SingleConnection pFirstPC, final IMatchProcessor<? super ConnectedPortsMatch> processor) {
    rawForEachMatch(new Object[]{pOutP, pInP, pFirstPC}, processor);
  }
  
  /**
   * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pOutP the fixed value of pattern parameter outP, or null if not bound.
   * @param pInP the fixed value of pattern parameter inP, or null if not bound.
   * @param pFirstPC the fixed value of pattern parameter firstPC, or null if not bound.
   * @param processor the action that will process the selected match.
   * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
   * 
   */
  public boolean forOneArbitraryMatch(final OutPort pOutP, final InPort pInP, final SingleConnection pFirstPC, final IMatchProcessor<? super ConnectedPortsMatch> processor) {
    return rawForOneArbitraryMatch(new Object[]{pOutP, pInP, pFirstPC}, processor);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pOutP the fixed value of pattern parameter outP, or null if not bound.
   * @param pInP the fixed value of pattern parameter inP, or null if not bound.
   * @param pFirstPC the fixed value of pattern parameter firstPC, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public ConnectedPortsMatch newMatch(final OutPort pOutP, final InPort pInP, final SingleConnection pFirstPC) {
    return ConnectedPortsMatch.newMatch(pOutP, pInP, pFirstPC);
  }
  
  /**
   * Retrieve the set of values that occur in matches for outP.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<OutPort> rawAccumulateAllValuesOfoutP(final Object[] parameters) {
    Set<OutPort> results = new HashSet<OutPort>();
    rawAccumulateAllValues(POSITION_OUTP, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for outP.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<OutPort> getAllValuesOfoutP() {
    return rawAccumulateAllValuesOfoutP(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for outP.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<OutPort> getAllValuesOfoutP(final ConnectedPortsMatch partialMatch) {
    return rawAccumulateAllValuesOfoutP(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for outP.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<OutPort> getAllValuesOfoutP(final InPort pInP, final SingleConnection pFirstPC) {
    return rawAccumulateAllValuesOfoutP(new Object[]{
    null, 
    pInP, 
    pFirstPC
    });
  }
  
  /**
   * Retrieve the set of values that occur in matches for inP.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<InPort> rawAccumulateAllValuesOfinP(final Object[] parameters) {
    Set<InPort> results = new HashSet<InPort>();
    rawAccumulateAllValues(POSITION_INP, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for inP.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<InPort> getAllValuesOfinP() {
    return rawAccumulateAllValuesOfinP(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for inP.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<InPort> getAllValuesOfinP(final ConnectedPortsMatch partialMatch) {
    return rawAccumulateAllValuesOfinP(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for inP.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<InPort> getAllValuesOfinP(final OutPort pOutP, final SingleConnection pFirstPC) {
    return rawAccumulateAllValuesOfinP(new Object[]{
    pOutP, 
    null, 
    pFirstPC
    });
  }
  
  /**
   * Retrieve the set of values that occur in matches for firstPC.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<SingleConnection> rawAccumulateAllValuesOffirstPC(final Object[] parameters) {
    Set<SingleConnection> results = new HashSet<SingleConnection>();
    rawAccumulateAllValues(POSITION_FIRSTPC, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for firstPC.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<SingleConnection> getAllValuesOffirstPC() {
    return rawAccumulateAllValuesOffirstPC(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for firstPC.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<SingleConnection> getAllValuesOffirstPC(final ConnectedPortsMatch partialMatch) {
    return rawAccumulateAllValuesOffirstPC(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for firstPC.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<SingleConnection> getAllValuesOffirstPC(final OutPort pOutP, final InPort pInP) {
    return rawAccumulateAllValuesOffirstPC(new Object[]{
    pOutP, 
    pInP, 
    null
    });
  }
  
  @Override
  protected ConnectedPortsMatch tupleToMatch(final Tuple t) {
    try {
    	return ConnectedPortsMatch.newMatch((hu.bme.mit.massif.simulink.OutPort) t.get(POSITION_OUTP), (hu.bme.mit.massif.simulink.InPort) t.get(POSITION_INP), (hu.bme.mit.massif.simulink.SingleConnection) t.get(POSITION_FIRSTPC));
    } catch(ClassCastException e) {
    	LOGGER.error("Element(s) in tuple not properly typed!",e);
    	return null;
    }
  }
  
  @Override
  protected ConnectedPortsMatch arrayToMatch(final Object[] match) {
    try {
    	return ConnectedPortsMatch.newMatch((hu.bme.mit.massif.simulink.OutPort) match[POSITION_OUTP], (hu.bme.mit.massif.simulink.InPort) match[POSITION_INP], (hu.bme.mit.massif.simulink.SingleConnection) match[POSITION_FIRSTPC]);
    } catch(ClassCastException e) {
    	LOGGER.error("Element(s) in array not properly typed!",e);
    	return null;
    }
  }
  
  @Override
  protected ConnectedPortsMatch arrayToMatchMutable(final Object[] match) {
    try {
    	return ConnectedPortsMatch.newMutableMatch((hu.bme.mit.massif.simulink.OutPort) match[POSITION_OUTP], (hu.bme.mit.massif.simulink.InPort) match[POSITION_INP], (hu.bme.mit.massif.simulink.SingleConnection) match[POSITION_FIRSTPC]);
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
  public static IQuerySpecification<ConnectedPortsMatcher> querySpecification() throws IncQueryException {
    return ConnectedPortsQuerySpecification.instance();
  }
}