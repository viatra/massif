package hu.bme.mit.massif.models.simulink.util;

import hu.bme.mit.massif.models.simulink.util.ReferenceEqualMatch;
import hu.bme.mit.massif.models.simulink.util.util.ReferenceEqualQuerySpecification;
import hu.bme.mit.massif.simulink.SimulinkReference;
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
 * Generated pattern matcher API of the hu.bme.mit.massif.models.simulink.util.referenceEqual pattern,
 * providing pattern-specific query methods.
 * 
 * <p>Use the pattern matcher on a given model via {@link #on(IncQueryEngine)},
 * e.g. in conjunction with {@link IncQueryEngine#on(Notifier)}.
 * 
 * <p>Matches of the pattern will be represented as {@link ReferenceEqualMatch}.
 * 
 * <p>Original source:
 * <code><pre>
 * pattern referenceEqual(sourceRef : SimulinkReference, targetRef : SimulinkReference) {
 * 	find simulinkReference(sourceRef, Name, Qual);
 * 	find simulinkReference(targetRef, Name, Qual);
 * } or {
 * 	SimulinkReference.name(sourceRef,Name);
 * 	SimulinkReference.name(targetRef,Name);
 * 	neg find referenceQualifier(sourceRef, _squal);
 * 	neg find referenceQualifier(targetRef, _tqual);
 * }
 * </pre></code>
 * 
 * @see ReferenceEqualMatch
 * @see ReferenceEqualProcessor
 * @see ReferenceEqualQuerySpecification
 * 
 */
@SuppressWarnings("all")
public class ReferenceEqualMatcher extends BaseMatcher<ReferenceEqualMatch> {
  /**
   * Initializes the pattern matcher within an existing EMF-IncQuery engine.
   * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
   * The match set will be incrementally refreshed upon updates.
   * @param engine the existing EMF-IncQuery engine in which this matcher will be created.
   * @throws IncQueryException if an error occurs during pattern matcher creation
   * 
   */
  public static ReferenceEqualMatcher on(final IncQueryEngine engine) throws IncQueryException {
    // check if matcher already exists
    ReferenceEqualMatcher matcher = engine.getExistingMatcher(querySpecification());
    if (matcher == null) {
    	matcher = new ReferenceEqualMatcher(engine);
    	// do not have to "put" it into engine.matchers, reportMatcherInitialized() will take care of it
    }
    return matcher;
  }
  
  private final static int POSITION_SOURCEREF = 0;
  
  private final static int POSITION_TARGETREF = 1;
  
  private final static Logger LOGGER = IncQueryLoggingUtil.getLogger(ReferenceEqualMatcher.class);
  
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
  public ReferenceEqualMatcher(final Notifier emfRoot) throws IncQueryException {
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
  public ReferenceEqualMatcher(final IncQueryEngine engine) throws IncQueryException {
    super(engine, querySpecification());
  }
  
  /**
   * Returns the set of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pSourceRef the fixed value of pattern parameter sourceRef, or null if not bound.
   * @param pTargetRef the fixed value of pattern parameter targetRef, or null if not bound.
   * @return matches represented as a ReferenceEqualMatch object.
   * 
   */
  public Collection<ReferenceEqualMatch> getAllMatches(final SimulinkReference pSourceRef, final SimulinkReference pTargetRef) {
    return rawGetAllMatches(new Object[]{pSourceRef, pTargetRef});
  }
  
  /**
   * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pSourceRef the fixed value of pattern parameter sourceRef, or null if not bound.
   * @param pTargetRef the fixed value of pattern parameter targetRef, or null if not bound.
   * @return a match represented as a ReferenceEqualMatch object, or null if no match is found.
   * 
   */
  public ReferenceEqualMatch getOneArbitraryMatch(final SimulinkReference pSourceRef, final SimulinkReference pTargetRef) {
    return rawGetOneArbitraryMatch(new Object[]{pSourceRef, pTargetRef});
  }
  
  /**
   * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
   * under any possible substitution of the unspecified parameters (if any).
   * @param pSourceRef the fixed value of pattern parameter sourceRef, or null if not bound.
   * @param pTargetRef the fixed value of pattern parameter targetRef, or null if not bound.
   * @return true if the input is a valid (partial) match of the pattern.
   * 
   */
  public boolean hasMatch(final SimulinkReference pSourceRef, final SimulinkReference pTargetRef) {
    return rawHasMatch(new Object[]{pSourceRef, pTargetRef});
  }
  
  /**
   * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pSourceRef the fixed value of pattern parameter sourceRef, or null if not bound.
   * @param pTargetRef the fixed value of pattern parameter targetRef, or null if not bound.
   * @return the number of pattern matches found.
   * 
   */
  public int countMatches(final SimulinkReference pSourceRef, final SimulinkReference pTargetRef) {
    return rawCountMatches(new Object[]{pSourceRef, pTargetRef});
  }
  
  /**
   * Executes the given processor on each match of the pattern that conforms to the given fixed values of some parameters.
   * @param pSourceRef the fixed value of pattern parameter sourceRef, or null if not bound.
   * @param pTargetRef the fixed value of pattern parameter targetRef, or null if not bound.
   * @param processor the action that will process each pattern match.
   * 
   */
  public void forEachMatch(final SimulinkReference pSourceRef, final SimulinkReference pTargetRef, final IMatchProcessor<? super ReferenceEqualMatch> processor) {
    rawForEachMatch(new Object[]{pSourceRef, pTargetRef}, processor);
  }
  
  /**
   * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pSourceRef the fixed value of pattern parameter sourceRef, or null if not bound.
   * @param pTargetRef the fixed value of pattern parameter targetRef, or null if not bound.
   * @param processor the action that will process the selected match.
   * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
   * 
   */
  public boolean forOneArbitraryMatch(final SimulinkReference pSourceRef, final SimulinkReference pTargetRef, final IMatchProcessor<? super ReferenceEqualMatch> processor) {
    return rawForOneArbitraryMatch(new Object[]{pSourceRef, pTargetRef}, processor);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pSourceRef the fixed value of pattern parameter sourceRef, or null if not bound.
   * @param pTargetRef the fixed value of pattern parameter targetRef, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public ReferenceEqualMatch newMatch(final SimulinkReference pSourceRef, final SimulinkReference pTargetRef) {
    return ReferenceEqualMatch.newMatch(pSourceRef, pTargetRef);
  }
  
  /**
   * Retrieve the set of values that occur in matches for sourceRef.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<SimulinkReference> rawAccumulateAllValuesOfsourceRef(final Object[] parameters) {
    Set<SimulinkReference> results = new HashSet<SimulinkReference>();
    rawAccumulateAllValues(POSITION_SOURCEREF, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for sourceRef.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<SimulinkReference> getAllValuesOfsourceRef() {
    return rawAccumulateAllValuesOfsourceRef(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for sourceRef.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<SimulinkReference> getAllValuesOfsourceRef(final ReferenceEqualMatch partialMatch) {
    return rawAccumulateAllValuesOfsourceRef(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for sourceRef.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<SimulinkReference> getAllValuesOfsourceRef(final SimulinkReference pTargetRef) {
    return rawAccumulateAllValuesOfsourceRef(new Object[]{
    null, 
    pTargetRef
    });
  }
  
  /**
   * Retrieve the set of values that occur in matches for targetRef.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<SimulinkReference> rawAccumulateAllValuesOftargetRef(final Object[] parameters) {
    Set<SimulinkReference> results = new HashSet<SimulinkReference>();
    rawAccumulateAllValues(POSITION_TARGETREF, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for targetRef.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<SimulinkReference> getAllValuesOftargetRef() {
    return rawAccumulateAllValuesOftargetRef(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for targetRef.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<SimulinkReference> getAllValuesOftargetRef(final ReferenceEqualMatch partialMatch) {
    return rawAccumulateAllValuesOftargetRef(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for targetRef.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<SimulinkReference> getAllValuesOftargetRef(final SimulinkReference pSourceRef) {
    return rawAccumulateAllValuesOftargetRef(new Object[]{
    pSourceRef, 
    null
    });
  }
  
  @Override
  protected ReferenceEqualMatch tupleToMatch(final Tuple t) {
    try {
    	return ReferenceEqualMatch.newMatch((hu.bme.mit.massif.simulink.SimulinkReference) t.get(POSITION_SOURCEREF), (hu.bme.mit.massif.simulink.SimulinkReference) t.get(POSITION_TARGETREF));
    } catch(ClassCastException e) {
    	LOGGER.error("Element(s) in tuple not properly typed!",e);
    	return null;
    }
  }
  
  @Override
  protected ReferenceEqualMatch arrayToMatch(final Object[] match) {
    try {
    	return ReferenceEqualMatch.newMatch((hu.bme.mit.massif.simulink.SimulinkReference) match[POSITION_SOURCEREF], (hu.bme.mit.massif.simulink.SimulinkReference) match[POSITION_TARGETREF]);
    } catch(ClassCastException e) {
    	LOGGER.error("Element(s) in array not properly typed!",e);
    	return null;
    }
  }
  
  @Override
  protected ReferenceEqualMatch arrayToMatchMutable(final Object[] match) {
    try {
    	return ReferenceEqualMatch.newMutableMatch((hu.bme.mit.massif.simulink.SimulinkReference) match[POSITION_SOURCEREF], (hu.bme.mit.massif.simulink.SimulinkReference) match[POSITION_TARGETREF]);
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
  public static IQuerySpecification<ReferenceEqualMatcher> querySpecification() throws IncQueryException {
    return ReferenceEqualQuerySpecification.instance();
  }
}
