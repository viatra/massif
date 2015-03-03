package hu.bme.mit.massif.models.simulink.util;

import hu.bme.mit.massif.models.simulink.util.InPortToBlockPortOutPortMatch;
import hu.bme.mit.massif.models.simulink.util.util.InPortToBlockPortOutPortQuerySpecification;
import hu.bme.mit.massif.simulink.InPort;
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
 * Generated pattern matcher API of the hu.bme.mit.massif.models.simulink.util.inPortToBlockPortOutPort pattern,
 * providing pattern-specific query methods.
 * 
 * <p>Use the pattern matcher on a given model via {@link #on(IncQueryEngine)},
 * e.g. in conjunction with {@link IncQueryEngine#on(Notifier)}.
 * 
 * <p>Matches of the pattern will be represented as {@link InPortToBlockPortOutPortMatch}.
 * 
 * <p>Original source:
 * <code><pre>
 * pattern inPortToBlockPortOutPort(inPort : InPort, outPortOfPBl : OutPort) {
 * 	find portToPortBlock(inPort, pBl);
 * 	PortBlock.ports(pBl, outPortOfPBl);
 * }
 * </pre></code>
 * 
 * @see InPortToBlockPortOutPortMatch
 * @see InPortToBlockPortOutPortProcessor
 * @see InPortToBlockPortOutPortQuerySpecification
 * 
 */
@SuppressWarnings("all")
public class InPortToBlockPortOutPortMatcher extends BaseMatcher<InPortToBlockPortOutPortMatch> {
  /**
   * Initializes the pattern matcher within an existing EMF-IncQuery engine.
   * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
   * The match set will be incrementally refreshed upon updates.
   * @param engine the existing EMF-IncQuery engine in which this matcher will be created.
   * @throws IncQueryException if an error occurs during pattern matcher creation
   * 
   */
  public static InPortToBlockPortOutPortMatcher on(final IncQueryEngine engine) throws IncQueryException {
    // check if matcher already exists
    InPortToBlockPortOutPortMatcher matcher = engine.getExistingMatcher(querySpecification());
    if (matcher == null) {
    	matcher = new InPortToBlockPortOutPortMatcher(engine);
    	// do not have to "put" it into engine.matchers, reportMatcherInitialized() will take care of it
    }
    return matcher;
  }
  
  private final static int POSITION_INPORT = 0;
  
  private final static int POSITION_OUTPORTOFPBL = 1;
  
  private final static Logger LOGGER = IncQueryLoggingUtil.getLogger(InPortToBlockPortOutPortMatcher.class);
  
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
  public InPortToBlockPortOutPortMatcher(final Notifier emfRoot) throws IncQueryException {
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
  public InPortToBlockPortOutPortMatcher(final IncQueryEngine engine) throws IncQueryException {
    super(engine, querySpecification());
  }
  
  /**
   * Returns the set of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pInPort the fixed value of pattern parameter inPort, or null if not bound.
   * @param pOutPortOfPBl the fixed value of pattern parameter outPortOfPBl, or null if not bound.
   * @return matches represented as a InPortToBlockPortOutPortMatch object.
   * 
   */
  public Collection<InPortToBlockPortOutPortMatch> getAllMatches(final InPort pInPort, final OutPort pOutPortOfPBl) {
    return rawGetAllMatches(new Object[]{pInPort, pOutPortOfPBl});
  }
  
  /**
   * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pInPort the fixed value of pattern parameter inPort, or null if not bound.
   * @param pOutPortOfPBl the fixed value of pattern parameter outPortOfPBl, or null if not bound.
   * @return a match represented as a InPortToBlockPortOutPortMatch object, or null if no match is found.
   * 
   */
  public InPortToBlockPortOutPortMatch getOneArbitraryMatch(final InPort pInPort, final OutPort pOutPortOfPBl) {
    return rawGetOneArbitraryMatch(new Object[]{pInPort, pOutPortOfPBl});
  }
  
  /**
   * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
   * under any possible substitution of the unspecified parameters (if any).
   * @param pInPort the fixed value of pattern parameter inPort, or null if not bound.
   * @param pOutPortOfPBl the fixed value of pattern parameter outPortOfPBl, or null if not bound.
   * @return true if the input is a valid (partial) match of the pattern.
   * 
   */
  public boolean hasMatch(final InPort pInPort, final OutPort pOutPortOfPBl) {
    return rawHasMatch(new Object[]{pInPort, pOutPortOfPBl});
  }
  
  /**
   * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pInPort the fixed value of pattern parameter inPort, or null if not bound.
   * @param pOutPortOfPBl the fixed value of pattern parameter outPortOfPBl, or null if not bound.
   * @return the number of pattern matches found.
   * 
   */
  public int countMatches(final InPort pInPort, final OutPort pOutPortOfPBl) {
    return rawCountMatches(new Object[]{pInPort, pOutPortOfPBl});
  }
  
  /**
   * Executes the given processor on each match of the pattern that conforms to the given fixed values of some parameters.
   * @param pInPort the fixed value of pattern parameter inPort, or null if not bound.
   * @param pOutPortOfPBl the fixed value of pattern parameter outPortOfPBl, or null if not bound.
   * @param processor the action that will process each pattern match.
   * 
   */
  public void forEachMatch(final InPort pInPort, final OutPort pOutPortOfPBl, final IMatchProcessor<? super InPortToBlockPortOutPortMatch> processor) {
    rawForEachMatch(new Object[]{pInPort, pOutPortOfPBl}, processor);
  }
  
  /**
   * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pInPort the fixed value of pattern parameter inPort, or null if not bound.
   * @param pOutPortOfPBl the fixed value of pattern parameter outPortOfPBl, or null if not bound.
   * @param processor the action that will process the selected match.
   * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
   * 
   */
  public boolean forOneArbitraryMatch(final InPort pInPort, final OutPort pOutPortOfPBl, final IMatchProcessor<? super InPortToBlockPortOutPortMatch> processor) {
    return rawForOneArbitraryMatch(new Object[]{pInPort, pOutPortOfPBl}, processor);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pInPort the fixed value of pattern parameter inPort, or null if not bound.
   * @param pOutPortOfPBl the fixed value of pattern parameter outPortOfPBl, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public InPortToBlockPortOutPortMatch newMatch(final InPort pInPort, final OutPort pOutPortOfPBl) {
    return InPortToBlockPortOutPortMatch.newMatch(pInPort, pOutPortOfPBl);
  }
  
  /**
   * Retrieve the set of values that occur in matches for inPort.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<InPort> rawAccumulateAllValuesOfinPort(final Object[] parameters) {
    Set<InPort> results = new HashSet<InPort>();
    rawAccumulateAllValues(POSITION_INPORT, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for inPort.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<InPort> getAllValuesOfinPort() {
    return rawAccumulateAllValuesOfinPort(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for inPort.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<InPort> getAllValuesOfinPort(final InPortToBlockPortOutPortMatch partialMatch) {
    return rawAccumulateAllValuesOfinPort(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for inPort.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<InPort> getAllValuesOfinPort(final OutPort pOutPortOfPBl) {
    return rawAccumulateAllValuesOfinPort(new Object[]{
    null, 
    pOutPortOfPBl
    });
  }
  
  /**
   * Retrieve the set of values that occur in matches for outPortOfPBl.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<OutPort> rawAccumulateAllValuesOfoutPortOfPBl(final Object[] parameters) {
    Set<OutPort> results = new HashSet<OutPort>();
    rawAccumulateAllValues(POSITION_OUTPORTOFPBL, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for outPortOfPBl.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<OutPort> getAllValuesOfoutPortOfPBl() {
    return rawAccumulateAllValuesOfoutPortOfPBl(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for outPortOfPBl.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<OutPort> getAllValuesOfoutPortOfPBl(final InPortToBlockPortOutPortMatch partialMatch) {
    return rawAccumulateAllValuesOfoutPortOfPBl(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for outPortOfPBl.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<OutPort> getAllValuesOfoutPortOfPBl(final InPort pInPort) {
    return rawAccumulateAllValuesOfoutPortOfPBl(new Object[]{
    pInPort, 
    null
    });
  }
  
  @Override
  protected InPortToBlockPortOutPortMatch tupleToMatch(final Tuple t) {
    try {
    	return InPortToBlockPortOutPortMatch.newMatch((hu.bme.mit.massif.simulink.InPort) t.get(POSITION_INPORT), (hu.bme.mit.massif.simulink.OutPort) t.get(POSITION_OUTPORTOFPBL));
    } catch(ClassCastException e) {
    	LOGGER.error("Element(s) in tuple not properly typed!",e);
    	return null;
    }
  }
  
  @Override
  protected InPortToBlockPortOutPortMatch arrayToMatch(final Object[] match) {
    try {
    	return InPortToBlockPortOutPortMatch.newMatch((hu.bme.mit.massif.simulink.InPort) match[POSITION_INPORT], (hu.bme.mit.massif.simulink.OutPort) match[POSITION_OUTPORTOFPBL]);
    } catch(ClassCastException e) {
    	LOGGER.error("Element(s) in array not properly typed!",e);
    	return null;
    }
  }
  
  @Override
  protected InPortToBlockPortOutPortMatch arrayToMatchMutable(final Object[] match) {
    try {
    	return InPortToBlockPortOutPortMatch.newMutableMatch((hu.bme.mit.massif.simulink.InPort) match[POSITION_INPORT], (hu.bme.mit.massif.simulink.OutPort) match[POSITION_OUTPORTOFPBL]);
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
  public static IQuerySpecification<InPortToBlockPortOutPortMatcher> querySpecification() throws IncQueryException {
    return InPortToBlockPortOutPortQuerySpecification.instance();
  }
}
