package hu.bme.mit.transima.models.simulink.util;

import hu.bme.mit.transima.Simulink.InPort;
import hu.bme.mit.transima.Simulink.OutPort;
import hu.bme.mit.transima.models.simulink.util.GotoConnectedPortsMatch;
import hu.bme.mit.transima.models.simulink.util.util.GotoConnectedPortsQuerySpecification;
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
 * Generated pattern matcher API of the hu.bme.mit.transima.models.simulink.util.gotoConnectedPorts pattern,
 * providing pattern-specific query methods.
 * 
 * <p>Use the pattern matcher on a given model via {@link #on(IncQueryEngine)},
 * e.g. in conjunction with {@link IncQueryEngine#on(Notifier)}.
 * 
 * <p>Matches of the pattern will be represented as {@link GotoConnectedPortsMatch}.
 * 
 * <p>Original source:
 * <code><pre>
 * pattern gotoConnectedPorts(gotoInPort : InPort, fromOutPort : OutPort) {
 * 	Goto(GT);
 * 	find blockToPort(GT, gotoInPort);
 * 	Goto.fromBlocks(GT, From);
 * 	find blockToPort(From, fromOutPort);
 * }
 * </pre></code>
 * 
 * @see GotoConnectedPortsMatch
 * @see GotoConnectedPortsProcessor
 * @see GotoConnectedPortsQuerySpecification
 * 
 */
@SuppressWarnings("all")
public class GotoConnectedPortsMatcher extends BaseMatcher<GotoConnectedPortsMatch> {
  /**
   * @return the singleton instance of the query specification of this pattern
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static IQuerySpecification<GotoConnectedPortsMatcher> querySpecification() throws IncQueryException {
    return GotoConnectedPortsQuerySpecification.instance();
  }
  
  /**
   * Initializes the pattern matcher within an existing EMF-IncQuery engine.
   * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
   * The match set will be incrementally refreshed upon updates.
   * @param engine the existing EMF-IncQuery engine in which this matcher will be created.
   * @throws IncQueryException if an error occurs during pattern matcher creation
   * 
   */
  public static GotoConnectedPortsMatcher on(final IncQueryEngine engine) throws IncQueryException {
    // check if matcher already exists
    GotoConnectedPortsMatcher matcher = engine.getExistingMatcher(querySpecification());
    if (matcher == null) {
    	matcher = new GotoConnectedPortsMatcher(engine);
    	// do not have to "put" it into engine.matchers, reportMatcherInitialized() will take care of it
    }
    return matcher;
  }
  
  private final static int POSITION_GOTOINPORT = 0;
  
  private final static int POSITION_FROMOUTPORT = 1;
  
  private final static Logger LOGGER = IncQueryLoggingUtil.getLogger(GotoConnectedPortsMatcher.class);
  
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
  public GotoConnectedPortsMatcher(final Notifier emfRoot) throws IncQueryException {
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
  public GotoConnectedPortsMatcher(final IncQueryEngine engine) throws IncQueryException {
    super(engine, querySpecification());
  }
  
  /**
   * Returns the set of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pGotoInPort the fixed value of pattern parameter gotoInPort, or null if not bound.
   * @param pFromOutPort the fixed value of pattern parameter fromOutPort, or null if not bound.
   * @return matches represented as a GotoConnectedPortsMatch object.
   * 
   */
  public Collection<GotoConnectedPortsMatch> getAllMatches(final InPort pGotoInPort, final OutPort pFromOutPort) {
    return rawGetAllMatches(new Object[]{pGotoInPort, pFromOutPort});
  }
  
  /**
   * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pGotoInPort the fixed value of pattern parameter gotoInPort, or null if not bound.
   * @param pFromOutPort the fixed value of pattern parameter fromOutPort, or null if not bound.
   * @return a match represented as a GotoConnectedPortsMatch object, or null if no match is found.
   * 
   */
  public GotoConnectedPortsMatch getOneArbitraryMatch(final InPort pGotoInPort, final OutPort pFromOutPort) {
    return rawGetOneArbitraryMatch(new Object[]{pGotoInPort, pFromOutPort});
  }
  
  /**
   * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
   * under any possible substitution of the unspecified parameters (if any).
   * @param pGotoInPort the fixed value of pattern parameter gotoInPort, or null if not bound.
   * @param pFromOutPort the fixed value of pattern parameter fromOutPort, or null if not bound.
   * @return true if the input is a valid (partial) match of the pattern.
   * 
   */
  public boolean hasMatch(final InPort pGotoInPort, final OutPort pFromOutPort) {
    return rawHasMatch(new Object[]{pGotoInPort, pFromOutPort});
  }
  
  /**
   * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pGotoInPort the fixed value of pattern parameter gotoInPort, or null if not bound.
   * @param pFromOutPort the fixed value of pattern parameter fromOutPort, or null if not bound.
   * @return the number of pattern matches found.
   * 
   */
  public int countMatches(final InPort pGotoInPort, final OutPort pFromOutPort) {
    return rawCountMatches(new Object[]{pGotoInPort, pFromOutPort});
  }
  
  /**
   * Executes the given processor on each match of the pattern that conforms to the given fixed values of some parameters.
   * @param pGotoInPort the fixed value of pattern parameter gotoInPort, or null if not bound.
   * @param pFromOutPort the fixed value of pattern parameter fromOutPort, or null if not bound.
   * @param processor the action that will process each pattern match.
   * 
   */
  public void forEachMatch(final InPort pGotoInPort, final OutPort pFromOutPort, final IMatchProcessor<? super GotoConnectedPortsMatch> processor) {
    rawForEachMatch(new Object[]{pGotoInPort, pFromOutPort}, processor);
  }
  
  /**
   * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pGotoInPort the fixed value of pattern parameter gotoInPort, or null if not bound.
   * @param pFromOutPort the fixed value of pattern parameter fromOutPort, or null if not bound.
   * @param processor the action that will process the selected match.
   * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
   * 
   */
  public boolean forOneArbitraryMatch(final InPort pGotoInPort, final OutPort pFromOutPort, final IMatchProcessor<? super GotoConnectedPortsMatch> processor) {
    return rawForOneArbitraryMatch(new Object[]{pGotoInPort, pFromOutPort}, processor);
  }
  
  /**
   * Registers a new filtered delta monitor on this pattern matcher.
   * The DeltaMonitor can be used to track changes (delta) in the set of filtered pattern matches from now on, considering those matches only that conform to the given fixed values of some parameters.
   * It can also be reset to track changes from a later point in time,
   * and changes can even be acknowledged on an individual basis.
   * See {@link DeltaMonitor} for details.
   * @param fillAtStart if true, all current matches are reported as new match events; if false, the delta monitor starts empty.
   * @param pGotoInPort the fixed value of pattern parameter gotoInPort, or null if not bound.
   * @param pFromOutPort the fixed value of pattern parameter fromOutPort, or null if not bound.
   * @return the delta monitor.
   * @deprecated use the IncQuery Databinding API (IncQueryObservables) instead.
   * 
   */
  @Deprecated
  public DeltaMonitor<GotoConnectedPortsMatch> newFilteredDeltaMonitor(final boolean fillAtStart, final InPort pGotoInPort, final OutPort pFromOutPort) {
    return rawNewFilteredDeltaMonitor(fillAtStart, new Object[]{pGotoInPort, pFromOutPort});
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pGotoInPort the fixed value of pattern parameter gotoInPort, or null if not bound.
   * @param pFromOutPort the fixed value of pattern parameter fromOutPort, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public GotoConnectedPortsMatch newMatch(final InPort pGotoInPort, final OutPort pFromOutPort) {
    return GotoConnectedPortsMatch.newMatch(pGotoInPort, pFromOutPort);
    
  }
  
  /**
   * Retrieve the set of values that occur in matches for gotoInPort.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<InPort> rawAccumulateAllValuesOfgotoInPort(final Object[] parameters) {
    Set<InPort> results = new HashSet<InPort>();
    rawAccumulateAllValues(POSITION_GOTOINPORT, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for gotoInPort.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<InPort> getAllValuesOfgotoInPort() {
    return rawAccumulateAllValuesOfgotoInPort(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for gotoInPort.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<InPort> getAllValuesOfgotoInPort(final GotoConnectedPortsMatch partialMatch) {
    return rawAccumulateAllValuesOfgotoInPort(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for gotoInPort.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<InPort> getAllValuesOfgotoInPort(final OutPort pFromOutPort) {
    return rawAccumulateAllValuesOfgotoInPort(new Object[]{null, pFromOutPort});
  }
  
  /**
   * Retrieve the set of values that occur in matches for fromOutPort.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<OutPort> rawAccumulateAllValuesOffromOutPort(final Object[] parameters) {
    Set<OutPort> results = new HashSet<OutPort>();
    rawAccumulateAllValues(POSITION_FROMOUTPORT, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for fromOutPort.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<OutPort> getAllValuesOffromOutPort() {
    return rawAccumulateAllValuesOffromOutPort(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for fromOutPort.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<OutPort> getAllValuesOffromOutPort(final GotoConnectedPortsMatch partialMatch) {
    return rawAccumulateAllValuesOffromOutPort(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for fromOutPort.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<OutPort> getAllValuesOffromOutPort(final InPort pGotoInPort) {
    return rawAccumulateAllValuesOffromOutPort(new Object[]{pGotoInPort, null});
  }
  
  @Override
  protected GotoConnectedPortsMatch tupleToMatch(final Tuple t) {
    try {
      return GotoConnectedPortsMatch.newMatch((hu.bme.mit.transima.Simulink.InPort) t.get(POSITION_GOTOINPORT), (hu.bme.mit.transima.Simulink.OutPort) t.get(POSITION_FROMOUTPORT));
    } catch(ClassCastException e) {
      LOGGER.error("Element(s) in tuple not properly typed!",e);
      return null;
    }
    
  }
  
  @Override
  protected GotoConnectedPortsMatch arrayToMatch(final Object[] match) {
    try {
      return GotoConnectedPortsMatch.newMatch((hu.bme.mit.transima.Simulink.InPort) match[POSITION_GOTOINPORT], (hu.bme.mit.transima.Simulink.OutPort) match[POSITION_FROMOUTPORT]);
    } catch(ClassCastException e) {
      LOGGER.error("Element(s) in array not properly typed!",e);
      return null;
    }
    
  }
  
  @Override
  protected GotoConnectedPortsMatch arrayToMatchMutable(final Object[] match) {
    try {
      return GotoConnectedPortsMatch.newMutableMatch((hu.bme.mit.transima.Simulink.InPort) match[POSITION_GOTOINPORT], (hu.bme.mit.transima.Simulink.OutPort) match[POSITION_FROMOUTPORT]);
    } catch(ClassCastException e) {
      LOGGER.error("Element(s) in array not properly typed!",e);
      return null;
    }
    
  }
}
