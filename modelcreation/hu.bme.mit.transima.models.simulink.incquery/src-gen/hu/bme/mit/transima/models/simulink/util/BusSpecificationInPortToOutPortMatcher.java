package hu.bme.mit.transima.models.simulink.util;

import hu.bme.mit.transima.Simulink.InPort;
import hu.bme.mit.transima.Simulink.OutPort;
import hu.bme.mit.transima.models.simulink.util.BusSpecificationInPortToOutPortMatch;
import hu.bme.mit.transima.models.simulink.util.util.BusSpecificationInPortToOutPortQuerySpecification;
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
 * Generated pattern matcher API of the hu.bme.mit.transima.models.simulink.util.busSpecificationInPortToOutPort pattern,
 * providing pattern-specific query methods.
 * 
 * <p>Use the pattern matcher on a given model via {@link #on(IncQueryEngine)},
 * e.g. in conjunction with {@link IncQueryEngine#on(Notifier)}.
 * 
 * <p>Matches of the pattern will be represented as {@link BusSpecificationInPortToOutPortMatch}.
 * 
 * <p>Original source:
 * <code><pre>
 * pattern busSpecificationInPortToOutPort(inportOfBS : InPort, outPortOfBS : OutPort){
 * 	BusSpecification.ports(BS, inportOfBS);
 * 	BusSpecification.ports(BS, outPortOfBS);
 * }
 * </pre></code>
 * 
 * @see BusSpecificationInPortToOutPortMatch
 * @see BusSpecificationInPortToOutPortProcessor
 * @see BusSpecificationInPortToOutPortQuerySpecification
 * 
 */
@SuppressWarnings("all")
public class BusSpecificationInPortToOutPortMatcher extends BaseMatcher<BusSpecificationInPortToOutPortMatch> {
  /**
   * @return the singleton instance of the query specification of this pattern
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static IQuerySpecification<BusSpecificationInPortToOutPortMatcher> querySpecification() throws IncQueryException {
    return BusSpecificationInPortToOutPortQuerySpecification.instance();
  }
  
  /**
   * Initializes the pattern matcher within an existing EMF-IncQuery engine.
   * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
   * The match set will be incrementally refreshed upon updates.
   * @param engine the existing EMF-IncQuery engine in which this matcher will be created.
   * @throws IncQueryException if an error occurs during pattern matcher creation
   * 
   */
  public static BusSpecificationInPortToOutPortMatcher on(final IncQueryEngine engine) throws IncQueryException {
    // check if matcher already exists
    BusSpecificationInPortToOutPortMatcher matcher = engine.getExistingMatcher(querySpecification());
    if (matcher == null) {
    	matcher = new BusSpecificationInPortToOutPortMatcher(engine);
    	// do not have to "put" it into engine.matchers, reportMatcherInitialized() will take care of it
    }
    return matcher;
  }
  
  private final static int POSITION_INPORTOFBS = 0;
  
  private final static int POSITION_OUTPORTOFBS = 1;
  
  private final static Logger LOGGER = IncQueryLoggingUtil.getLogger(BusSpecificationInPortToOutPortMatcher.class);
  
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
  public BusSpecificationInPortToOutPortMatcher(final Notifier emfRoot) throws IncQueryException {
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
  public BusSpecificationInPortToOutPortMatcher(final IncQueryEngine engine) throws IncQueryException {
    super(engine, querySpecification());
  }
  
  /**
   * Returns the set of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pInportOfBS the fixed value of pattern parameter inportOfBS, or null if not bound.
   * @param pOutPortOfBS the fixed value of pattern parameter outPortOfBS, or null if not bound.
   * @return matches represented as a BusSpecificationInPortToOutPortMatch object.
   * 
   */
  public Collection<BusSpecificationInPortToOutPortMatch> getAllMatches(final InPort pInportOfBS, final OutPort pOutPortOfBS) {
    return rawGetAllMatches(new Object[]{pInportOfBS, pOutPortOfBS});
  }
  
  /**
   * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pInportOfBS the fixed value of pattern parameter inportOfBS, or null if not bound.
   * @param pOutPortOfBS the fixed value of pattern parameter outPortOfBS, or null if not bound.
   * @return a match represented as a BusSpecificationInPortToOutPortMatch object, or null if no match is found.
   * 
   */
  public BusSpecificationInPortToOutPortMatch getOneArbitraryMatch(final InPort pInportOfBS, final OutPort pOutPortOfBS) {
    return rawGetOneArbitraryMatch(new Object[]{pInportOfBS, pOutPortOfBS});
  }
  
  /**
   * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
   * under any possible substitution of the unspecified parameters (if any).
   * @param pInportOfBS the fixed value of pattern parameter inportOfBS, or null if not bound.
   * @param pOutPortOfBS the fixed value of pattern parameter outPortOfBS, or null if not bound.
   * @return true if the input is a valid (partial) match of the pattern.
   * 
   */
  public boolean hasMatch(final InPort pInportOfBS, final OutPort pOutPortOfBS) {
    return rawHasMatch(new Object[]{pInportOfBS, pOutPortOfBS});
  }
  
  /**
   * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pInportOfBS the fixed value of pattern parameter inportOfBS, or null if not bound.
   * @param pOutPortOfBS the fixed value of pattern parameter outPortOfBS, or null if not bound.
   * @return the number of pattern matches found.
   * 
   */
  public int countMatches(final InPort pInportOfBS, final OutPort pOutPortOfBS) {
    return rawCountMatches(new Object[]{pInportOfBS, pOutPortOfBS});
  }
  
  /**
   * Executes the given processor on each match of the pattern that conforms to the given fixed values of some parameters.
   * @param pInportOfBS the fixed value of pattern parameter inportOfBS, or null if not bound.
   * @param pOutPortOfBS the fixed value of pattern parameter outPortOfBS, or null if not bound.
   * @param processor the action that will process each pattern match.
   * 
   */
  public void forEachMatch(final InPort pInportOfBS, final OutPort pOutPortOfBS, final IMatchProcessor<? super BusSpecificationInPortToOutPortMatch> processor) {
    rawForEachMatch(new Object[]{pInportOfBS, pOutPortOfBS}, processor);
  }
  
  /**
   * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pInportOfBS the fixed value of pattern parameter inportOfBS, or null if not bound.
   * @param pOutPortOfBS the fixed value of pattern parameter outPortOfBS, or null if not bound.
   * @param processor the action that will process the selected match.
   * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
   * 
   */
  public boolean forOneArbitraryMatch(final InPort pInportOfBS, final OutPort pOutPortOfBS, final IMatchProcessor<? super BusSpecificationInPortToOutPortMatch> processor) {
    return rawForOneArbitraryMatch(new Object[]{pInportOfBS, pOutPortOfBS}, processor);
  }
  
  /**
   * Registers a new filtered delta monitor on this pattern matcher.
   * The DeltaMonitor can be used to track changes (delta) in the set of filtered pattern matches from now on, considering those matches only that conform to the given fixed values of some parameters.
   * It can also be reset to track changes from a later point in time,
   * and changes can even be acknowledged on an individual basis.
   * See {@link DeltaMonitor} for details.
   * @param fillAtStart if true, all current matches are reported as new match events; if false, the delta monitor starts empty.
   * @param pInportOfBS the fixed value of pattern parameter inportOfBS, or null if not bound.
   * @param pOutPortOfBS the fixed value of pattern parameter outPortOfBS, or null if not bound.
   * @return the delta monitor.
   * @deprecated use the IncQuery Databinding API (IncQueryObservables) instead.
   * 
   */
  public DeltaMonitor<BusSpecificationInPortToOutPortMatch> newFilteredDeltaMonitor(final boolean fillAtStart, final InPort pInportOfBS, final OutPort pOutPortOfBS) {
    return rawNewFilteredDeltaMonitor(fillAtStart, new Object[]{pInportOfBS, pOutPortOfBS});
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pInportOfBS the fixed value of pattern parameter inportOfBS, or null if not bound.
   * @param pOutPortOfBS the fixed value of pattern parameter outPortOfBS, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public BusSpecificationInPortToOutPortMatch newMatch(final InPort pInportOfBS, final OutPort pOutPortOfBS) {
    return BusSpecificationInPortToOutPortMatch.newMatch(pInportOfBS, pOutPortOfBS);
    
  }
  
  /**
   * Retrieve the set of values that occur in matches for inportOfBS.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<InPort> rawAccumulateAllValuesOfinportOfBS(final Object[] parameters) {
    Set<InPort> results = new HashSet<InPort>();
    rawAccumulateAllValues(POSITION_INPORTOFBS, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for inportOfBS.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<InPort> getAllValuesOfinportOfBS() {
    return rawAccumulateAllValuesOfinportOfBS(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for inportOfBS.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<InPort> getAllValuesOfinportOfBS(final BusSpecificationInPortToOutPortMatch partialMatch) {
    return rawAccumulateAllValuesOfinportOfBS(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for inportOfBS.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<InPort> getAllValuesOfinportOfBS(final OutPort pOutPortOfBS) {
    return rawAccumulateAllValuesOfinportOfBS(new Object[]{null, pOutPortOfBS});
  }
  
  /**
   * Retrieve the set of values that occur in matches for outPortOfBS.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<OutPort> rawAccumulateAllValuesOfoutPortOfBS(final Object[] parameters) {
    Set<OutPort> results = new HashSet<OutPort>();
    rawAccumulateAllValues(POSITION_OUTPORTOFBS, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for outPortOfBS.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<OutPort> getAllValuesOfoutPortOfBS() {
    return rawAccumulateAllValuesOfoutPortOfBS(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for outPortOfBS.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<OutPort> getAllValuesOfoutPortOfBS(final BusSpecificationInPortToOutPortMatch partialMatch) {
    return rawAccumulateAllValuesOfoutPortOfBS(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for outPortOfBS.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<OutPort> getAllValuesOfoutPortOfBS(final InPort pInportOfBS) {
    return rawAccumulateAllValuesOfoutPortOfBS(new Object[]{pInportOfBS, null});
  }
  
  protected BusSpecificationInPortToOutPortMatch tupleToMatch(final Tuple t) {
    try {
      return BusSpecificationInPortToOutPortMatch.newMatch((hu.bme.mit.transima.Simulink.InPort) t.get(POSITION_INPORTOFBS), (hu.bme.mit.transima.Simulink.OutPort) t.get(POSITION_OUTPORTOFBS));
    } catch(ClassCastException e) {
      LOGGER.error("Element(s) in tuple not properly typed!",e);
      return null;
    }
    
  }
  
  protected BusSpecificationInPortToOutPortMatch arrayToMatch(final Object[] match) {
    try {
      return BusSpecificationInPortToOutPortMatch.newMatch((hu.bme.mit.transima.Simulink.InPort) match[POSITION_INPORTOFBS], (hu.bme.mit.transima.Simulink.OutPort) match[POSITION_OUTPORTOFBS]);
    } catch(ClassCastException e) {
      LOGGER.error("Element(s) in array not properly typed!",e);
      return null;
    }
    
  }
  
  protected BusSpecificationInPortToOutPortMatch arrayToMatchMutable(final Object[] match) {
    try {
      return BusSpecificationInPortToOutPortMatch.newMutableMatch((hu.bme.mit.transima.Simulink.InPort) match[POSITION_INPORTOFBS], (hu.bme.mit.transima.Simulink.OutPort) match[POSITION_OUTPORTOFBS]);
    } catch(ClassCastException e) {
      LOGGER.error("Element(s) in array not properly typed!",e);
      return null;
    }
    
  }
}
