package hu.bme.mit.transima.models.simulink.util;

import hu.bme.mit.transima.Simulink.BusSpecification;
import hu.bme.mit.transima.Simulink.OutPort;
import hu.bme.mit.transima.models.simulink.util.OutportsReachedFromBusSpecificationMatch;
import hu.bme.mit.transima.models.simulink.util.util.OutportsReachedFromBusSpecificationQuerySpecification;
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
 * Generated pattern matcher API of the hu.bme.mit.transima.models.simulink.util.outportsReachedFromBusSpecification pattern,
 * providing pattern-specific query methods.
 * 
 * <p>Use the pattern matcher on a given model via {@link #on(IncQueryEngine)},
 * e.g. in conjunction with {@link IncQueryEngine#on(Notifier)}.
 * 
 * <p>Matches of the pattern will be represented as {@link OutportsReachedFromBusSpecificationMatch}.
 * 
 * <p>Original source:
 * <code><pre>
 * pattern outportsReachedFromBusSpecification(
 * 	outPort: OutPort,
 * 	nextSpec: BusSpecification,
 * 	endPortBeforeNextSpec: OutPort
 * ) {
 * 	find simpleConnectedOutPort+(outPort, endPortBeforeNextSpec);
 * 	find portConnection(endPortBeforeNextSpec, inPort, _pc);
 * 	Block.ports(nextSpec, inPort);
 * } or {
 * 	find portConnection(outPort, inPort, _pc);
 * 	Block.ports(nextSpec, inPort);
 * 	endPortBeforeNextSpec == outPort;
 * }
 * </pre></code>
 * 
 * @see OutportsReachedFromBusSpecificationMatch
 * @see OutportsReachedFromBusSpecificationProcessor
 * @see OutportsReachedFromBusSpecificationQuerySpecification
 * 
 */
@SuppressWarnings("all")
public class OutportsReachedFromBusSpecificationMatcher extends BaseMatcher<OutportsReachedFromBusSpecificationMatch> {
  /**
   * @return the singleton instance of the query specification of this pattern
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static IQuerySpecification<OutportsReachedFromBusSpecificationMatcher> querySpecification() throws IncQueryException {
    return OutportsReachedFromBusSpecificationQuerySpecification.instance();
  }
  
  /**
   * Initializes the pattern matcher within an existing EMF-IncQuery engine.
   * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
   * The match set will be incrementally refreshed upon updates.
   * @param engine the existing EMF-IncQuery engine in which this matcher will be created.
   * @throws IncQueryException if an error occurs during pattern matcher creation
   * 
   */
  public static OutportsReachedFromBusSpecificationMatcher on(final IncQueryEngine engine) throws IncQueryException {
    // check if matcher already exists
    OutportsReachedFromBusSpecificationMatcher matcher = engine.getExistingMatcher(querySpecification());
    if (matcher == null) {
    	matcher = new OutportsReachedFromBusSpecificationMatcher(engine);
    	// do not have to "put" it into engine.matchers, reportMatcherInitialized() will take care of it
    }
    return matcher;
  }
  
  private final static int POSITION_OUTPORT = 0;
  
  private final static int POSITION_NEXTSPEC = 1;
  
  private final static int POSITION_ENDPORTBEFORENEXTSPEC = 2;
  
  private final static Logger LOGGER = IncQueryLoggingUtil.getLogger(OutportsReachedFromBusSpecificationMatcher.class);
  
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
  public OutportsReachedFromBusSpecificationMatcher(final Notifier emfRoot) throws IncQueryException {
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
  public OutportsReachedFromBusSpecificationMatcher(final IncQueryEngine engine) throws IncQueryException {
    super(engine, querySpecification());
  }
  
  /**
   * Returns the set of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pOutPort the fixed value of pattern parameter outPort, or null if not bound.
   * @param pNextSpec the fixed value of pattern parameter nextSpec, or null if not bound.
   * @param pEndPortBeforeNextSpec the fixed value of pattern parameter endPortBeforeNextSpec, or null if not bound.
   * @return matches represented as a OutportsReachedFromBusSpecificationMatch object.
   * 
   */
  public Collection<OutportsReachedFromBusSpecificationMatch> getAllMatches(final OutPort pOutPort, final BusSpecification pNextSpec, final OutPort pEndPortBeforeNextSpec) {
    return rawGetAllMatches(new Object[]{pOutPort, pNextSpec, pEndPortBeforeNextSpec});
  }
  
  /**
   * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pOutPort the fixed value of pattern parameter outPort, or null if not bound.
   * @param pNextSpec the fixed value of pattern parameter nextSpec, or null if not bound.
   * @param pEndPortBeforeNextSpec the fixed value of pattern parameter endPortBeforeNextSpec, or null if not bound.
   * @return a match represented as a OutportsReachedFromBusSpecificationMatch object, or null if no match is found.
   * 
   */
  public OutportsReachedFromBusSpecificationMatch getOneArbitraryMatch(final OutPort pOutPort, final BusSpecification pNextSpec, final OutPort pEndPortBeforeNextSpec) {
    return rawGetOneArbitraryMatch(new Object[]{pOutPort, pNextSpec, pEndPortBeforeNextSpec});
  }
  
  /**
   * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
   * under any possible substitution of the unspecified parameters (if any).
   * @param pOutPort the fixed value of pattern parameter outPort, or null if not bound.
   * @param pNextSpec the fixed value of pattern parameter nextSpec, or null if not bound.
   * @param pEndPortBeforeNextSpec the fixed value of pattern parameter endPortBeforeNextSpec, or null if not bound.
   * @return true if the input is a valid (partial) match of the pattern.
   * 
   */
  public boolean hasMatch(final OutPort pOutPort, final BusSpecification pNextSpec, final OutPort pEndPortBeforeNextSpec) {
    return rawHasMatch(new Object[]{pOutPort, pNextSpec, pEndPortBeforeNextSpec});
  }
  
  /**
   * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pOutPort the fixed value of pattern parameter outPort, or null if not bound.
   * @param pNextSpec the fixed value of pattern parameter nextSpec, or null if not bound.
   * @param pEndPortBeforeNextSpec the fixed value of pattern parameter endPortBeforeNextSpec, or null if not bound.
   * @return the number of pattern matches found.
   * 
   */
  public int countMatches(final OutPort pOutPort, final BusSpecification pNextSpec, final OutPort pEndPortBeforeNextSpec) {
    return rawCountMatches(new Object[]{pOutPort, pNextSpec, pEndPortBeforeNextSpec});
  }
  
  /**
   * Executes the given processor on each match of the pattern that conforms to the given fixed values of some parameters.
   * @param pOutPort the fixed value of pattern parameter outPort, or null if not bound.
   * @param pNextSpec the fixed value of pattern parameter nextSpec, or null if not bound.
   * @param pEndPortBeforeNextSpec the fixed value of pattern parameter endPortBeforeNextSpec, or null if not bound.
   * @param processor the action that will process each pattern match.
   * 
   */
  public void forEachMatch(final OutPort pOutPort, final BusSpecification pNextSpec, final OutPort pEndPortBeforeNextSpec, final IMatchProcessor<? super OutportsReachedFromBusSpecificationMatch> processor) {
    rawForEachMatch(new Object[]{pOutPort, pNextSpec, pEndPortBeforeNextSpec}, processor);
  }
  
  /**
   * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pOutPort the fixed value of pattern parameter outPort, or null if not bound.
   * @param pNextSpec the fixed value of pattern parameter nextSpec, or null if not bound.
   * @param pEndPortBeforeNextSpec the fixed value of pattern parameter endPortBeforeNextSpec, or null if not bound.
   * @param processor the action that will process the selected match.
   * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
   * 
   */
  public boolean forOneArbitraryMatch(final OutPort pOutPort, final BusSpecification pNextSpec, final OutPort pEndPortBeforeNextSpec, final IMatchProcessor<? super OutportsReachedFromBusSpecificationMatch> processor) {
    return rawForOneArbitraryMatch(new Object[]{pOutPort, pNextSpec, pEndPortBeforeNextSpec}, processor);
  }
  
  /**
   * Registers a new filtered delta monitor on this pattern matcher.
   * The DeltaMonitor can be used to track changes (delta) in the set of filtered pattern matches from now on, considering those matches only that conform to the given fixed values of some parameters.
   * It can also be reset to track changes from a later point in time,
   * and changes can even be acknowledged on an individual basis.
   * See {@link DeltaMonitor} for details.
   * @param fillAtStart if true, all current matches are reported as new match events; if false, the delta monitor starts empty.
   * @param pOutPort the fixed value of pattern parameter outPort, or null if not bound.
   * @param pNextSpec the fixed value of pattern parameter nextSpec, or null if not bound.
   * @param pEndPortBeforeNextSpec the fixed value of pattern parameter endPortBeforeNextSpec, or null if not bound.
   * @return the delta monitor.
   * @deprecated use the IncQuery Databinding API (IncQueryObservables) instead.
   * 
   */
  public DeltaMonitor<OutportsReachedFromBusSpecificationMatch> newFilteredDeltaMonitor(final boolean fillAtStart, final OutPort pOutPort, final BusSpecification pNextSpec, final OutPort pEndPortBeforeNextSpec) {
    return rawNewFilteredDeltaMonitor(fillAtStart, new Object[]{pOutPort, pNextSpec, pEndPortBeforeNextSpec});
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pOutPort the fixed value of pattern parameter outPort, or null if not bound.
   * @param pNextSpec the fixed value of pattern parameter nextSpec, or null if not bound.
   * @param pEndPortBeforeNextSpec the fixed value of pattern parameter endPortBeforeNextSpec, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public OutportsReachedFromBusSpecificationMatch newMatch(final OutPort pOutPort, final BusSpecification pNextSpec, final OutPort pEndPortBeforeNextSpec) {
    return OutportsReachedFromBusSpecificationMatch.newMatch(pOutPort, pNextSpec, pEndPortBeforeNextSpec);
    
  }
  
  /**
   * Retrieve the set of values that occur in matches for outPort.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<OutPort> rawAccumulateAllValuesOfoutPort(final Object[] parameters) {
    Set<OutPort> results = new HashSet<OutPort>();
    rawAccumulateAllValues(POSITION_OUTPORT, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for outPort.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<OutPort> getAllValuesOfoutPort() {
    return rawAccumulateAllValuesOfoutPort(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for outPort.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<OutPort> getAllValuesOfoutPort(final OutportsReachedFromBusSpecificationMatch partialMatch) {
    return rawAccumulateAllValuesOfoutPort(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for outPort.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<OutPort> getAllValuesOfoutPort(final BusSpecification pNextSpec, final OutPort pEndPortBeforeNextSpec) {
    return rawAccumulateAllValuesOfoutPort(new Object[]{null, pNextSpec, pEndPortBeforeNextSpec});
  }
  
  /**
   * Retrieve the set of values that occur in matches for nextSpec.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<BusSpecification> rawAccumulateAllValuesOfnextSpec(final Object[] parameters) {
    Set<BusSpecification> results = new HashSet<BusSpecification>();
    rawAccumulateAllValues(POSITION_NEXTSPEC, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for nextSpec.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<BusSpecification> getAllValuesOfnextSpec() {
    return rawAccumulateAllValuesOfnextSpec(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for nextSpec.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<BusSpecification> getAllValuesOfnextSpec(final OutportsReachedFromBusSpecificationMatch partialMatch) {
    return rawAccumulateAllValuesOfnextSpec(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for nextSpec.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<BusSpecification> getAllValuesOfnextSpec(final OutPort pOutPort, final OutPort pEndPortBeforeNextSpec) {
    return rawAccumulateAllValuesOfnextSpec(new Object[]{pOutPort, null, pEndPortBeforeNextSpec});
  }
  
  /**
   * Retrieve the set of values that occur in matches for endPortBeforeNextSpec.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<OutPort> rawAccumulateAllValuesOfendPortBeforeNextSpec(final Object[] parameters) {
    Set<OutPort> results = new HashSet<OutPort>();
    rawAccumulateAllValues(POSITION_ENDPORTBEFORENEXTSPEC, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for endPortBeforeNextSpec.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<OutPort> getAllValuesOfendPortBeforeNextSpec() {
    return rawAccumulateAllValuesOfendPortBeforeNextSpec(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for endPortBeforeNextSpec.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<OutPort> getAllValuesOfendPortBeforeNextSpec(final OutportsReachedFromBusSpecificationMatch partialMatch) {
    return rawAccumulateAllValuesOfendPortBeforeNextSpec(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for endPortBeforeNextSpec.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<OutPort> getAllValuesOfendPortBeforeNextSpec(final OutPort pOutPort, final BusSpecification pNextSpec) {
    return rawAccumulateAllValuesOfendPortBeforeNextSpec(new Object[]{pOutPort, pNextSpec, null});
  }
  
  protected OutportsReachedFromBusSpecificationMatch tupleToMatch(final Tuple t) {
    try {
      return OutportsReachedFromBusSpecificationMatch.newMatch((hu.bme.mit.transima.Simulink.OutPort) t.get(POSITION_OUTPORT), (hu.bme.mit.transima.Simulink.BusSpecification) t.get(POSITION_NEXTSPEC), (hu.bme.mit.transima.Simulink.OutPort) t.get(POSITION_ENDPORTBEFORENEXTSPEC));
    } catch(ClassCastException e) {
      LOGGER.error("Element(s) in tuple not properly typed!",e);
      return null;
    }
    
  }
  
  protected OutportsReachedFromBusSpecificationMatch arrayToMatch(final Object[] match) {
    try {
      return OutportsReachedFromBusSpecificationMatch.newMatch((hu.bme.mit.transima.Simulink.OutPort) match[POSITION_OUTPORT], (hu.bme.mit.transima.Simulink.BusSpecification) match[POSITION_NEXTSPEC], (hu.bme.mit.transima.Simulink.OutPort) match[POSITION_ENDPORTBEFORENEXTSPEC]);
    } catch(ClassCastException e) {
      LOGGER.error("Element(s) in array not properly typed!",e);
      return null;
    }
    
  }
  
  protected OutportsReachedFromBusSpecificationMatch arrayToMatchMutable(final Object[] match) {
    try {
      return OutportsReachedFromBusSpecificationMatch.newMutableMatch((hu.bme.mit.transima.Simulink.OutPort) match[POSITION_OUTPORT], (hu.bme.mit.transima.Simulink.BusSpecification) match[POSITION_NEXTSPEC], (hu.bme.mit.transima.Simulink.OutPort) match[POSITION_ENDPORTBEFORENEXTSPEC]);
    } catch(ClassCastException e) {
      LOGGER.error("Element(s) in array not properly typed!",e);
      return null;
    }
    
  }
}
