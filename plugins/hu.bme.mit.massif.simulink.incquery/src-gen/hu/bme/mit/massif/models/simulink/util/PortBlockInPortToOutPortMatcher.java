package hu.bme.mit.massif.models.simulink.util;

import hu.bme.mit.massif.models.simulink.util.PortBlockInPortToOutPortMatch;
import hu.bme.mit.massif.models.simulink.util.util.PortBlockInPortToOutPortQuerySpecification;
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
 * Generated pattern matcher API of the hu.bme.mit.massif.models.simulink.util.portBlockInPortToOutPort pattern,
 * providing pattern-specific query methods.
 * 
 * <p>Use the pattern matcher on a given model via {@link #on(IncQueryEngine)},
 * e.g. in conjunction with {@link IncQueryEngine#on(Notifier)}.
 * 
 * <p>Matches of the pattern will be represented as {@link PortBlockInPortToOutPortMatch}.
 * 
 * <p>Original source:
 * <code><pre>
 * pattern portBlockInPortToOutPort(inPortOfPBl : InPort, outPort : OutPort) {
 * 	PortBlock.ports(pBl, inPortOfPBl);
 * 	find portToPortBlock(outPort, pBl);
 * }
 * </pre></code>
 * 
 * @see PortBlockInPortToOutPortMatch
 * @see PortBlockInPortToOutPortProcessor
 * @see PortBlockInPortToOutPortQuerySpecification
 * 
 */
@SuppressWarnings("all")
public class PortBlockInPortToOutPortMatcher extends BaseMatcher<PortBlockInPortToOutPortMatch> {
  /**
   * Initializes the pattern matcher within an existing EMF-IncQuery engine.
   * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
   * The match set will be incrementally refreshed upon updates.
   * @param engine the existing EMF-IncQuery engine in which this matcher will be created.
   * @throws IncQueryException if an error occurs during pattern matcher creation
   * 
   */
  public static PortBlockInPortToOutPortMatcher on(final IncQueryEngine engine) throws IncQueryException {
    // check if matcher already exists
    PortBlockInPortToOutPortMatcher matcher = engine.getExistingMatcher(querySpecification());
    if (matcher == null) {
    	matcher = new PortBlockInPortToOutPortMatcher(engine);
    	// do not have to "put" it into engine.matchers, reportMatcherInitialized() will take care of it
    }
    return matcher;
  }
  
  private final static int POSITION_INPORTOFPBL = 0;
  
  private final static int POSITION_OUTPORT = 1;
  
  private final static Logger LOGGER = IncQueryLoggingUtil.getLogger(PortBlockInPortToOutPortMatcher.class);
  
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
  public PortBlockInPortToOutPortMatcher(final Notifier emfRoot) throws IncQueryException {
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
  public PortBlockInPortToOutPortMatcher(final IncQueryEngine engine) throws IncQueryException {
    super(engine, querySpecification());
  }
  
  /**
   * Returns the set of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pInPortOfPBl the fixed value of pattern parameter inPortOfPBl, or null if not bound.
   * @param pOutPort the fixed value of pattern parameter outPort, or null if not bound.
   * @return matches represented as a PortBlockInPortToOutPortMatch object.
   * 
   */
  public Collection<PortBlockInPortToOutPortMatch> getAllMatches(final InPort pInPortOfPBl, final OutPort pOutPort) {
    return rawGetAllMatches(new Object[]{pInPortOfPBl, pOutPort});
  }
  
  /**
   * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pInPortOfPBl the fixed value of pattern parameter inPortOfPBl, or null if not bound.
   * @param pOutPort the fixed value of pattern parameter outPort, or null if not bound.
   * @return a match represented as a PortBlockInPortToOutPortMatch object, or null if no match is found.
   * 
   */
  public PortBlockInPortToOutPortMatch getOneArbitraryMatch(final InPort pInPortOfPBl, final OutPort pOutPort) {
    return rawGetOneArbitraryMatch(new Object[]{pInPortOfPBl, pOutPort});
  }
  
  /**
   * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
   * under any possible substitution of the unspecified parameters (if any).
   * @param pInPortOfPBl the fixed value of pattern parameter inPortOfPBl, or null if not bound.
   * @param pOutPort the fixed value of pattern parameter outPort, or null if not bound.
   * @return true if the input is a valid (partial) match of the pattern.
   * 
   */
  public boolean hasMatch(final InPort pInPortOfPBl, final OutPort pOutPort) {
    return rawHasMatch(new Object[]{pInPortOfPBl, pOutPort});
  }
  
  /**
   * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pInPortOfPBl the fixed value of pattern parameter inPortOfPBl, or null if not bound.
   * @param pOutPort the fixed value of pattern parameter outPort, or null if not bound.
   * @return the number of pattern matches found.
   * 
   */
  public int countMatches(final InPort pInPortOfPBl, final OutPort pOutPort) {
    return rawCountMatches(new Object[]{pInPortOfPBl, pOutPort});
  }
  
  /**
   * Executes the given processor on each match of the pattern that conforms to the given fixed values of some parameters.
   * @param pInPortOfPBl the fixed value of pattern parameter inPortOfPBl, or null if not bound.
   * @param pOutPort the fixed value of pattern parameter outPort, or null if not bound.
   * @param processor the action that will process each pattern match.
   * 
   */
  public void forEachMatch(final InPort pInPortOfPBl, final OutPort pOutPort, final IMatchProcessor<? super PortBlockInPortToOutPortMatch> processor) {
    rawForEachMatch(new Object[]{pInPortOfPBl, pOutPort}, processor);
  }
  
  /**
   * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pInPortOfPBl the fixed value of pattern parameter inPortOfPBl, or null if not bound.
   * @param pOutPort the fixed value of pattern parameter outPort, or null if not bound.
   * @param processor the action that will process the selected match.
   * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
   * 
   */
  public boolean forOneArbitraryMatch(final InPort pInPortOfPBl, final OutPort pOutPort, final IMatchProcessor<? super PortBlockInPortToOutPortMatch> processor) {
    return rawForOneArbitraryMatch(new Object[]{pInPortOfPBl, pOutPort}, processor);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pInPortOfPBl the fixed value of pattern parameter inPortOfPBl, or null if not bound.
   * @param pOutPort the fixed value of pattern parameter outPort, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public PortBlockInPortToOutPortMatch newMatch(final InPort pInPortOfPBl, final OutPort pOutPort) {
    return PortBlockInPortToOutPortMatch.newMatch(pInPortOfPBl, pOutPort);
  }
  
  /**
   * Retrieve the set of values that occur in matches for inPortOfPBl.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<InPort> rawAccumulateAllValuesOfinPortOfPBl(final Object[] parameters) {
    Set<InPort> results = new HashSet<InPort>();
    rawAccumulateAllValues(POSITION_INPORTOFPBL, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for inPortOfPBl.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<InPort> getAllValuesOfinPortOfPBl() {
    return rawAccumulateAllValuesOfinPortOfPBl(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for inPortOfPBl.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<InPort> getAllValuesOfinPortOfPBl(final PortBlockInPortToOutPortMatch partialMatch) {
    return rawAccumulateAllValuesOfinPortOfPBl(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for inPortOfPBl.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<InPort> getAllValuesOfinPortOfPBl(final OutPort pOutPort) {
    return rawAccumulateAllValuesOfinPortOfPBl(new Object[]{
    null, 
    pOutPort
    });
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
  public Set<OutPort> getAllValuesOfoutPort(final PortBlockInPortToOutPortMatch partialMatch) {
    return rawAccumulateAllValuesOfoutPort(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for outPort.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<OutPort> getAllValuesOfoutPort(final InPort pInPortOfPBl) {
    return rawAccumulateAllValuesOfoutPort(new Object[]{
    pInPortOfPBl, 
    null
    });
  }
  
  @Override
  protected PortBlockInPortToOutPortMatch tupleToMatch(final Tuple t) {
    try {
    	return PortBlockInPortToOutPortMatch.newMatch((hu.bme.mit.massif.simulink.InPort) t.get(POSITION_INPORTOFPBL), (hu.bme.mit.massif.simulink.OutPort) t.get(POSITION_OUTPORT));
    } catch(ClassCastException e) {
    	LOGGER.error("Element(s) in tuple not properly typed!",e);
    	return null;
    }
  }
  
  @Override
  protected PortBlockInPortToOutPortMatch arrayToMatch(final Object[] match) {
    try {
    	return PortBlockInPortToOutPortMatch.newMatch((hu.bme.mit.massif.simulink.InPort) match[POSITION_INPORTOFPBL], (hu.bme.mit.massif.simulink.OutPort) match[POSITION_OUTPORT]);
    } catch(ClassCastException e) {
    	LOGGER.error("Element(s) in array not properly typed!",e);
    	return null;
    }
  }
  
  @Override
  protected PortBlockInPortToOutPortMatch arrayToMatchMutable(final Object[] match) {
    try {
    	return PortBlockInPortToOutPortMatch.newMutableMatch((hu.bme.mit.massif.simulink.InPort) match[POSITION_INPORTOFPBL], (hu.bme.mit.massif.simulink.OutPort) match[POSITION_OUTPORT]);
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
  public static IQuerySpecification<PortBlockInPortToOutPortMatcher> querySpecification() throws IncQueryException {
    return PortBlockInPortToOutPortQuerySpecification.instance();
  }
}
