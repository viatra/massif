package hu.bme.mit.transima.models.simulink.util;

import hu.bme.mit.transima.Simulink.InPort;
import hu.bme.mit.transima.Simulink.OutPort;
import hu.bme.mit.transima.Simulink.SingleConnection;
import hu.bme.mit.transima.models.simulink.util.MultiConnectionMatch;
import hu.bme.mit.transima.models.simulink.util.util.MultiConnectionQuerySpecification;
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
 * Generated pattern matcher API of the hu.bme.mit.transima.models.simulink.util.multiConnection pattern,
 * providing pattern-specific query methods.
 * 
 * <p>Use the pattern matcher on a given model via {@link #on(IncQueryEngine)},
 * e.g. in conjunction with {@link IncQueryEngine#on(Notifier)}.
 * 
 * <p>Matches of the pattern will be represented as {@link MultiConnectionMatch}.
 * 
 * <p>Original source:
 * <code><pre>
 * pattern multiConnection(outP, inP, pc) {
 * 	InPort.connection(inP, pc);
 * 	SingleConnection.parent.from(pc, outP);
 * }
 * </pre></code>
 * 
 * @see MultiConnectionMatch
 * @see MultiConnectionProcessor
 * @see MultiConnectionQuerySpecification
 * 
 */
@SuppressWarnings("all")
public class MultiConnectionMatcher extends BaseMatcher<MultiConnectionMatch> {
  /**
   * @return the singleton instance of the query specification of this pattern
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static IQuerySpecification<MultiConnectionMatcher> querySpecification() throws IncQueryException {
    return MultiConnectionQuerySpecification.instance();
  }
  
  /**
   * Initializes the pattern matcher within an existing EMF-IncQuery engine.
   * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
   * The match set will be incrementally refreshed upon updates.
   * @param engine the existing EMF-IncQuery engine in which this matcher will be created.
   * @throws IncQueryException if an error occurs during pattern matcher creation
   * 
   */
  public static MultiConnectionMatcher on(final IncQueryEngine engine) throws IncQueryException {
    // check if matcher already exists
    MultiConnectionMatcher matcher = engine.getExistingMatcher(querySpecification());
    if (matcher == null) {
    	matcher = new MultiConnectionMatcher(engine);
    	// do not have to "put" it into engine.matchers, reportMatcherInitialized() will take care of it
    }
    return matcher;
  }
  
  private final static int POSITION_OUTP = 0;
  
  private final static int POSITION_INP = 1;
  
  private final static int POSITION_PC = 2;
  
  private final static Logger LOGGER = IncQueryLoggingUtil.getLogger(MultiConnectionMatcher.class);
  
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
  public MultiConnectionMatcher(final Notifier emfRoot) throws IncQueryException {
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
  public MultiConnectionMatcher(final IncQueryEngine engine) throws IncQueryException {
    super(engine, querySpecification());
  }
  
  /**
   * Returns the set of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pOutP the fixed value of pattern parameter outP, or null if not bound.
   * @param pInP the fixed value of pattern parameter inP, or null if not bound.
   * @param pPc the fixed value of pattern parameter pc, or null if not bound.
   * @return matches represented as a MultiConnectionMatch object.
   * 
   */
  public Collection<MultiConnectionMatch> getAllMatches(final OutPort pOutP, final InPort pInP, final SingleConnection pPc) {
    return rawGetAllMatches(new Object[]{pOutP, pInP, pPc});
  }
  
  /**
   * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pOutP the fixed value of pattern parameter outP, or null if not bound.
   * @param pInP the fixed value of pattern parameter inP, or null if not bound.
   * @param pPc the fixed value of pattern parameter pc, or null if not bound.
   * @return a match represented as a MultiConnectionMatch object, or null if no match is found.
   * 
   */
  public MultiConnectionMatch getOneArbitraryMatch(final OutPort pOutP, final InPort pInP, final SingleConnection pPc) {
    return rawGetOneArbitraryMatch(new Object[]{pOutP, pInP, pPc});
  }
  
  /**
   * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
   * under any possible substitution of the unspecified parameters (if any).
   * @param pOutP the fixed value of pattern parameter outP, or null if not bound.
   * @param pInP the fixed value of pattern parameter inP, or null if not bound.
   * @param pPc the fixed value of pattern parameter pc, or null if not bound.
   * @return true if the input is a valid (partial) match of the pattern.
   * 
   */
  public boolean hasMatch(final OutPort pOutP, final InPort pInP, final SingleConnection pPc) {
    return rawHasMatch(new Object[]{pOutP, pInP, pPc});
  }
  
  /**
   * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pOutP the fixed value of pattern parameter outP, or null if not bound.
   * @param pInP the fixed value of pattern parameter inP, or null if not bound.
   * @param pPc the fixed value of pattern parameter pc, or null if not bound.
   * @return the number of pattern matches found.
   * 
   */
  public int countMatches(final OutPort pOutP, final InPort pInP, final SingleConnection pPc) {
    return rawCountMatches(new Object[]{pOutP, pInP, pPc});
  }
  
  /**
   * Executes the given processor on each match of the pattern that conforms to the given fixed values of some parameters.
   * @param pOutP the fixed value of pattern parameter outP, or null if not bound.
   * @param pInP the fixed value of pattern parameter inP, or null if not bound.
   * @param pPc the fixed value of pattern parameter pc, or null if not bound.
   * @param processor the action that will process each pattern match.
   * 
   */
  public void forEachMatch(final OutPort pOutP, final InPort pInP, final SingleConnection pPc, final IMatchProcessor<? super MultiConnectionMatch> processor) {
    rawForEachMatch(new Object[]{pOutP, pInP, pPc}, processor);
  }
  
  /**
   * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pOutP the fixed value of pattern parameter outP, or null if not bound.
   * @param pInP the fixed value of pattern parameter inP, or null if not bound.
   * @param pPc the fixed value of pattern parameter pc, or null if not bound.
   * @param processor the action that will process the selected match.
   * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
   * 
   */
  public boolean forOneArbitraryMatch(final OutPort pOutP, final InPort pInP, final SingleConnection pPc, final IMatchProcessor<? super MultiConnectionMatch> processor) {
    return rawForOneArbitraryMatch(new Object[]{pOutP, pInP, pPc}, processor);
  }
  
  /**
   * Registers a new filtered delta monitor on this pattern matcher.
   * The DeltaMonitor can be used to track changes (delta) in the set of filtered pattern matches from now on, considering those matches only that conform to the given fixed values of some parameters.
   * It can also be reset to track changes from a later point in time,
   * and changes can even be acknowledged on an individual basis.
   * See {@link DeltaMonitor} for details.
   * @param fillAtStart if true, all current matches are reported as new match events; if false, the delta monitor starts empty.
   * @param pOutP the fixed value of pattern parameter outP, or null if not bound.
   * @param pInP the fixed value of pattern parameter inP, or null if not bound.
   * @param pPc the fixed value of pattern parameter pc, or null if not bound.
   * @return the delta monitor.
   * @deprecated use the IncQuery Databinding API (IncQueryObservables) instead.
   * 
   */
  @Deprecated
  public DeltaMonitor<MultiConnectionMatch> newFilteredDeltaMonitor(final boolean fillAtStart, final OutPort pOutP, final InPort pInP, final SingleConnection pPc) {
    return rawNewFilteredDeltaMonitor(fillAtStart, new Object[]{pOutP, pInP, pPc});
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pOutP the fixed value of pattern parameter outP, or null if not bound.
   * @param pInP the fixed value of pattern parameter inP, or null if not bound.
   * @param pPc the fixed value of pattern parameter pc, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public MultiConnectionMatch newMatch(final OutPort pOutP, final InPort pInP, final SingleConnection pPc) {
    return MultiConnectionMatch.newMatch(pOutP, pInP, pPc);
    
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
  public Set<OutPort> getAllValuesOfoutP(final MultiConnectionMatch partialMatch) {
    return rawAccumulateAllValuesOfoutP(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for outP.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<OutPort> getAllValuesOfoutP(final InPort pInP, final SingleConnection pPc) {
    return rawAccumulateAllValuesOfoutP(new Object[]{null, pInP, pPc});
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
  public Set<InPort> getAllValuesOfinP(final MultiConnectionMatch partialMatch) {
    return rawAccumulateAllValuesOfinP(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for inP.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<InPort> getAllValuesOfinP(final OutPort pOutP, final SingleConnection pPc) {
    return rawAccumulateAllValuesOfinP(new Object[]{pOutP, null, pPc});
  }
  
  /**
   * Retrieve the set of values that occur in matches for pc.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<SingleConnection> rawAccumulateAllValuesOfpc(final Object[] parameters) {
    Set<SingleConnection> results = new HashSet<SingleConnection>();
    rawAccumulateAllValues(POSITION_PC, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for pc.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<SingleConnection> getAllValuesOfpc() {
    return rawAccumulateAllValuesOfpc(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for pc.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<SingleConnection> getAllValuesOfpc(final MultiConnectionMatch partialMatch) {
    return rawAccumulateAllValuesOfpc(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for pc.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<SingleConnection> getAllValuesOfpc(final OutPort pOutP, final InPort pInP) {
    return rawAccumulateAllValuesOfpc(new Object[]{pOutP, pInP, null});
  }
  
  @Override
  protected MultiConnectionMatch tupleToMatch(final Tuple t) {
    try {
      return MultiConnectionMatch.newMatch((hu.bme.mit.transima.Simulink.OutPort) t.get(POSITION_OUTP), (hu.bme.mit.transima.Simulink.InPort) t.get(POSITION_INP), (hu.bme.mit.transima.Simulink.SingleConnection) t.get(POSITION_PC));
    } catch(ClassCastException e) {
      LOGGER.error("Element(s) in tuple not properly typed!",e);
      return null;
    }
    
  }
  
  @Override
  protected MultiConnectionMatch arrayToMatch(final Object[] match) {
    try {
      return MultiConnectionMatch.newMatch((hu.bme.mit.transima.Simulink.OutPort) match[POSITION_OUTP], (hu.bme.mit.transima.Simulink.InPort) match[POSITION_INP], (hu.bme.mit.transima.Simulink.SingleConnection) match[POSITION_PC]);
    } catch(ClassCastException e) {
      LOGGER.error("Element(s) in array not properly typed!",e);
      return null;
    }
    
  }
  
  @Override
  protected MultiConnectionMatch arrayToMatchMutable(final Object[] match) {
    try {
      return MultiConnectionMatch.newMutableMatch((hu.bme.mit.transima.Simulink.OutPort) match[POSITION_OUTP], (hu.bme.mit.transima.Simulink.InPort) match[POSITION_INP], (hu.bme.mit.transima.Simulink.SingleConnection) match[POSITION_PC]);
    } catch(ClassCastException e) {
      LOGGER.error("Element(s) in array not properly typed!",e);
      return null;
    }
    
  }
}
