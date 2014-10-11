package hu.bme.mit.transima.models.simulink.derived;

import hu.bme.mit.transima.Simulink.ModelReference;
import hu.bme.mit.transima.Simulink.SimulinkModel;
import hu.bme.mit.transima.models.simulink.derived.ReferencedModelMatch;
import hu.bme.mit.transima.models.simulink.derived.util.ReferencedModelQuerySpecification;
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
 * Generated pattern matcher API of the hu.bme.mit.transima.models.simulink.derived.referencedModel pattern,
 * providing pattern-specific query methods.
 * 
 * <p>Use the pattern matcher on a given model via {@link #on(IncQueryEngine)},
 * e.g. in conjunction with {@link IncQueryEngine#on(Notifier)}.
 * 
 * <p>Matches of the pattern will be represented as {@link ReferencedModelMatch}.
 * 
 * <p>Original source:
 * <code><pre>
 * {@literal @}QueryBasedFeature
 * pattern referencedModel(This : ModelReference, Target : SimulinkModel) = {
 * 	ModelReference.modelRef(This,ModelRef);
 * 	SimulinkModel.simulinkRef(Target,SR);
 * 	find referenceEqual(ModelRef,SR);
 * }
 * </pre></code>
 * 
 * @see ReferencedModelMatch
 * @see ReferencedModelProcessor
 * @see ReferencedModelQuerySpecification
 * 
 */
@SuppressWarnings("all")
public class ReferencedModelMatcher extends BaseMatcher<ReferencedModelMatch> {
  /**
   * @return the singleton instance of the query specification of this pattern
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static IQuerySpecification<ReferencedModelMatcher> querySpecification() throws IncQueryException {
    return ReferencedModelQuerySpecification.instance();
  }
  
  /**
   * Initializes the pattern matcher within an existing EMF-IncQuery engine.
   * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
   * The match set will be incrementally refreshed upon updates.
   * @param engine the existing EMF-IncQuery engine in which this matcher will be created.
   * @throws IncQueryException if an error occurs during pattern matcher creation
   * 
   */
  public static ReferencedModelMatcher on(final IncQueryEngine engine) throws IncQueryException {
    // check if matcher already exists
    ReferencedModelMatcher matcher = engine.getExistingMatcher(querySpecification());
    if (matcher == null) {
    	matcher = new ReferencedModelMatcher(engine);
    	// do not have to "put" it into engine.matchers, reportMatcherInitialized() will take care of it
    }
    return matcher;
  }
  
  private final static int POSITION_THIS = 0;
  
  private final static int POSITION_TARGET = 1;
  
  private final static Logger LOGGER = IncQueryLoggingUtil.getLogger(ReferencedModelMatcher.class);
  
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
  public ReferencedModelMatcher(final Notifier emfRoot) throws IncQueryException {
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
  public ReferencedModelMatcher(final IncQueryEngine engine) throws IncQueryException {
    super(engine, querySpecification());
  }
  
  /**
   * Returns the set of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pThis the fixed value of pattern parameter This, or null if not bound.
   * @param pTarget the fixed value of pattern parameter Target, or null if not bound.
   * @return matches represented as a ReferencedModelMatch object.
   * 
   */
  public Collection<ReferencedModelMatch> getAllMatches(final ModelReference pThis, final SimulinkModel pTarget) {
    return rawGetAllMatches(new Object[]{pThis, pTarget});
  }
  
  /**
   * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pThis the fixed value of pattern parameter This, or null if not bound.
   * @param pTarget the fixed value of pattern parameter Target, or null if not bound.
   * @return a match represented as a ReferencedModelMatch object, or null if no match is found.
   * 
   */
  public ReferencedModelMatch getOneArbitraryMatch(final ModelReference pThis, final SimulinkModel pTarget) {
    return rawGetOneArbitraryMatch(new Object[]{pThis, pTarget});
  }
  
  /**
   * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
   * under any possible substitution of the unspecified parameters (if any).
   * @param pThis the fixed value of pattern parameter This, or null if not bound.
   * @param pTarget the fixed value of pattern parameter Target, or null if not bound.
   * @return true if the input is a valid (partial) match of the pattern.
   * 
   */
  public boolean hasMatch(final ModelReference pThis, final SimulinkModel pTarget) {
    return rawHasMatch(new Object[]{pThis, pTarget});
  }
  
  /**
   * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pThis the fixed value of pattern parameter This, or null if not bound.
   * @param pTarget the fixed value of pattern parameter Target, or null if not bound.
   * @return the number of pattern matches found.
   * 
   */
  public int countMatches(final ModelReference pThis, final SimulinkModel pTarget) {
    return rawCountMatches(new Object[]{pThis, pTarget});
  }
  
  /**
   * Executes the given processor on each match of the pattern that conforms to the given fixed values of some parameters.
   * @param pThis the fixed value of pattern parameter This, or null if not bound.
   * @param pTarget the fixed value of pattern parameter Target, or null if not bound.
   * @param processor the action that will process each pattern match.
   * 
   */
  public void forEachMatch(final ModelReference pThis, final SimulinkModel pTarget, final IMatchProcessor<? super ReferencedModelMatch> processor) {
    rawForEachMatch(new Object[]{pThis, pTarget}, processor);
  }
  
  /**
   * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pThis the fixed value of pattern parameter This, or null if not bound.
   * @param pTarget the fixed value of pattern parameter Target, or null if not bound.
   * @param processor the action that will process the selected match.
   * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
   * 
   */
  public boolean forOneArbitraryMatch(final ModelReference pThis, final SimulinkModel pTarget, final IMatchProcessor<? super ReferencedModelMatch> processor) {
    return rawForOneArbitraryMatch(new Object[]{pThis, pTarget}, processor);
  }
  
  /**
   * Registers a new filtered delta monitor on this pattern matcher.
   * The DeltaMonitor can be used to track changes (delta) in the set of filtered pattern matches from now on, considering those matches only that conform to the given fixed values of some parameters.
   * It can also be reset to track changes from a later point in time,
   * and changes can even be acknowledged on an individual basis.
   * See {@link DeltaMonitor} for details.
   * @param fillAtStart if true, all current matches are reported as new match events; if false, the delta monitor starts empty.
   * @param pThis the fixed value of pattern parameter This, or null if not bound.
   * @param pTarget the fixed value of pattern parameter Target, or null if not bound.
   * @return the delta monitor.
   * @deprecated use the IncQuery Databinding API (IncQueryObservables) instead.
   * 
   */
  @Deprecated
  public DeltaMonitor<ReferencedModelMatch> newFilteredDeltaMonitor(final boolean fillAtStart, final ModelReference pThis, final SimulinkModel pTarget) {
    return rawNewFilteredDeltaMonitor(fillAtStart, new Object[]{pThis, pTarget});
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pThis the fixed value of pattern parameter This, or null if not bound.
   * @param pTarget the fixed value of pattern parameter Target, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public ReferencedModelMatch newMatch(final ModelReference pThis, final SimulinkModel pTarget) {
    return ReferencedModelMatch.newMatch(pThis, pTarget);
    
  }
  
  /**
   * Retrieve the set of values that occur in matches for This.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<ModelReference> rawAccumulateAllValuesOfThis(final Object[] parameters) {
    Set<ModelReference> results = new HashSet<ModelReference>();
    rawAccumulateAllValues(POSITION_THIS, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for This.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<ModelReference> getAllValuesOfThis() {
    return rawAccumulateAllValuesOfThis(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for This.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<ModelReference> getAllValuesOfThis(final ReferencedModelMatch partialMatch) {
    return rawAccumulateAllValuesOfThis(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for This.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<ModelReference> getAllValuesOfThis(final SimulinkModel pTarget) {
    return rawAccumulateAllValuesOfThis(new Object[]{null, pTarget});
  }
  
  /**
   * Retrieve the set of values that occur in matches for Target.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<SimulinkModel> rawAccumulateAllValuesOfTarget(final Object[] parameters) {
    Set<SimulinkModel> results = new HashSet<SimulinkModel>();
    rawAccumulateAllValues(POSITION_TARGET, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for Target.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<SimulinkModel> getAllValuesOfTarget() {
    return rawAccumulateAllValuesOfTarget(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for Target.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<SimulinkModel> getAllValuesOfTarget(final ReferencedModelMatch partialMatch) {
    return rawAccumulateAllValuesOfTarget(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for Target.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<SimulinkModel> getAllValuesOfTarget(final ModelReference pThis) {
    return rawAccumulateAllValuesOfTarget(new Object[]{pThis, null});
  }
  
  @Override
  protected ReferencedModelMatch tupleToMatch(final Tuple t) {
    try {
      return ReferencedModelMatch.newMatch((hu.bme.mit.transima.Simulink.ModelReference) t.get(POSITION_THIS), (hu.bme.mit.transima.Simulink.SimulinkModel) t.get(POSITION_TARGET));
    } catch(ClassCastException e) {
      LOGGER.error("Element(s) in tuple not properly typed!",e);
      return null;
    }
    
  }
  
  @Override
  protected ReferencedModelMatch arrayToMatch(final Object[] match) {
    try {
      return ReferencedModelMatch.newMatch((hu.bme.mit.transima.Simulink.ModelReference) match[POSITION_THIS], (hu.bme.mit.transima.Simulink.SimulinkModel) match[POSITION_TARGET]);
    } catch(ClassCastException e) {
      LOGGER.error("Element(s) in array not properly typed!",e);
      return null;
    }
    
  }
  
  @Override
  protected ReferencedModelMatch arrayToMatchMutable(final Object[] match) {
    try {
      return ReferencedModelMatch.newMutableMatch((hu.bme.mit.transima.Simulink.ModelReference) match[POSITION_THIS], (hu.bme.mit.transima.Simulink.SimulinkModel) match[POSITION_TARGET]);
    } catch(ClassCastException e) {
      LOGGER.error("Element(s) in array not properly typed!",e);
      return null;
    }
    
  }
}
