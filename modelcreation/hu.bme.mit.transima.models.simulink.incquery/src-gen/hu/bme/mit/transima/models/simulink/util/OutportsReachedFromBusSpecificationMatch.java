package hu.bme.mit.transima.models.simulink.util;

import hu.bme.mit.transima.Simulink.BusSpecification;
import hu.bme.mit.transima.Simulink.OutPort;
import hu.bme.mit.transima.models.simulink.util.util.OutportsReachedFromBusSpecificationQuerySpecification;
import java.util.Arrays;
import java.util.List;
import org.eclipse.incquery.runtime.api.IPatternMatch;
import org.eclipse.incquery.runtime.api.impl.BasePatternMatch;
import org.eclipse.incquery.runtime.exception.IncQueryException;

/**
 * Pattern-specific match representation of the hu.bme.mit.transima.models.simulink.util.outportsReachedFromBusSpecification pattern,
 * to be used in conjunction with {@link OutportsReachedFromBusSpecificationMatcher}.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters,
 * usable to represent a match of the pattern in the result of a query,
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see OutportsReachedFromBusSpecificationMatcher
 * @see OutportsReachedFromBusSpecificationProcessor
 * 
 */
@SuppressWarnings("all")
public abstract class OutportsReachedFromBusSpecificationMatch extends BasePatternMatch {
  private OutPort fOutPort;
  
  private BusSpecification fNextSpec;
  
  private OutPort fEndPortBeforeNextSpec;
  
  private static List<String> parameterNames = makeImmutableList("outPort", "nextSpec", "endPortBeforeNextSpec");
  
  private OutportsReachedFromBusSpecificationMatch(final OutPort pOutPort, final BusSpecification pNextSpec, final OutPort pEndPortBeforeNextSpec) {
    this.fOutPort = pOutPort;
    this.fNextSpec = pNextSpec;
    this.fEndPortBeforeNextSpec = pEndPortBeforeNextSpec;
    
  }
  
  @Override
  public Object get(final String parameterName) {
    if ("outPort".equals(parameterName)) return this.fOutPort;
    if ("nextSpec".equals(parameterName)) return this.fNextSpec;
    if ("endPortBeforeNextSpec".equals(parameterName)) return this.fEndPortBeforeNextSpec;
    return null;
    
  }
  
  public OutPort getOutPort() {
    return this.fOutPort;
    
  }
  
  public BusSpecification getNextSpec() {
    return this.fNextSpec;
    
  }
  
  public OutPort getEndPortBeforeNextSpec() {
    return this.fEndPortBeforeNextSpec;
    
  }
  
  @Override
  public boolean set(final String parameterName, final Object newValue) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    if ("outPort".equals(parameterName) ) {
    	this.fOutPort = (hu.bme.mit.transima.Simulink.OutPort) newValue;
    	return true;
    }
    if ("nextSpec".equals(parameterName) ) {
    	this.fNextSpec = (hu.bme.mit.transima.Simulink.BusSpecification) newValue;
    	return true;
    }
    if ("endPortBeforeNextSpec".equals(parameterName) ) {
    	this.fEndPortBeforeNextSpec = (hu.bme.mit.transima.Simulink.OutPort) newValue;
    	return true;
    }
    return false;
    
  }
  
  public void setOutPort(final OutPort pOutPort) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fOutPort = pOutPort;
    
  }
  
  public void setNextSpec(final BusSpecification pNextSpec) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fNextSpec = pNextSpec;
    
  }
  
  public void setEndPortBeforeNextSpec(final OutPort pEndPortBeforeNextSpec) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fEndPortBeforeNextSpec = pEndPortBeforeNextSpec;
    
  }
  
  @Override
  public String patternName() {
    return "hu.bme.mit.transima.models.simulink.util.outportsReachedFromBusSpecification";
    
  }
  
  @Override
  public List<String> parameterNames() {
    return OutportsReachedFromBusSpecificationMatch.parameterNames;
    
  }
  
  @Override
  public Object[] toArray() {
    return new Object[]{fOutPort, fNextSpec, fEndPortBeforeNextSpec};
    
  }
  
  @Override
  public OutportsReachedFromBusSpecificationMatch toImmutable() {
    return isMutable() ? newMatch(fOutPort, fNextSpec, fEndPortBeforeNextSpec) : this;
    
  }
  
  @Override
  public String prettyPrint() {
    StringBuilder result = new StringBuilder();
    result.append("\"outPort\"=" + prettyPrintValue(fOutPort) + ", ");
    result.append("\"nextSpec\"=" + prettyPrintValue(fNextSpec) + ", ");
    result.append("\"endPortBeforeNextSpec\"=" + prettyPrintValue(fEndPortBeforeNextSpec));
    return result.toString();
    
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((fOutPort == null) ? 0 : fOutPort.hashCode());
    result = prime * result + ((fNextSpec == null) ? 0 : fNextSpec.hashCode());
    result = prime * result + ((fEndPortBeforeNextSpec == null) ? 0 : fEndPortBeforeNextSpec.hashCode());
    return result;
    
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
    	return true;
    if (!(obj instanceof OutportsReachedFromBusSpecificationMatch)) { // this should be infrequent
    	if (obj == null)
    		return false;
    	if (!(obj instanceof IPatternMatch))
    		return false;
    	IPatternMatch otherSig  = (IPatternMatch) obj;
    	if (!specification().equals(otherSig.specification()))
    		return false;
    	return Arrays.deepEquals(toArray(), otherSig.toArray());
    }
    OutportsReachedFromBusSpecificationMatch other = (OutportsReachedFromBusSpecificationMatch) obj;
    if (fOutPort == null) {if (other.fOutPort != null) return false;}
    else if (!fOutPort.equals(other.fOutPort)) return false;
    if (fNextSpec == null) {if (other.fNextSpec != null) return false;}
    else if (!fNextSpec.equals(other.fNextSpec)) return false;
    if (fEndPortBeforeNextSpec == null) {if (other.fEndPortBeforeNextSpec != null) return false;}
    else if (!fEndPortBeforeNextSpec.equals(other.fEndPortBeforeNextSpec)) return false;
    return true;
  }
  
  @Override
  public OutportsReachedFromBusSpecificationQuerySpecification specification() {
    try {
    	return OutportsReachedFromBusSpecificationQuerySpecification.instance();
    } catch (IncQueryException ex) {
     	// This cannot happen, as the match object can only be instantiated if the query specification exists
     	throw new IllegalStateException	(ex);
    }
    
  }
  
  /**
   * Returns an empty, mutable match.
   * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
   * 
   * @return the empty match.
   * 
   */
  public static OutportsReachedFromBusSpecificationMatch newEmptyMatch() {
    return new Mutable(null, null, null);
    
  }
  
  /**
   * Returns a mutable (partial) match.
   * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
   * 
   * @param pOutPort the fixed value of pattern parameter outPort, or null if not bound.
   * @param pNextSpec the fixed value of pattern parameter nextSpec, or null if not bound.
   * @param pEndPortBeforeNextSpec the fixed value of pattern parameter endPortBeforeNextSpec, or null if not bound.
   * @return the new, mutable (partial) match object.
   * 
   */
  public static OutportsReachedFromBusSpecificationMatch newMutableMatch(final OutPort pOutPort, final BusSpecification pNextSpec, final OutPort pEndPortBeforeNextSpec) {
    return new Mutable(pOutPort, pNextSpec, pEndPortBeforeNextSpec);
    
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
  public static OutportsReachedFromBusSpecificationMatch newMatch(final OutPort pOutPort, final BusSpecification pNextSpec, final OutPort pEndPortBeforeNextSpec) {
    return new Immutable(pOutPort, pNextSpec, pEndPortBeforeNextSpec);
    
  }
  
  private static final class Mutable extends OutportsReachedFromBusSpecificationMatch {
    Mutable(final OutPort pOutPort, final BusSpecification pNextSpec, final OutPort pEndPortBeforeNextSpec) {
      super(pOutPort, pNextSpec, pEndPortBeforeNextSpec);
      
    }
    
    @Override
    public boolean isMutable() {
      return true;
    }
  }
  
  private static final class Immutable extends OutportsReachedFromBusSpecificationMatch {
    Immutable(final OutPort pOutPort, final BusSpecification pNextSpec, final OutPort pEndPortBeforeNextSpec) {
      super(pOutPort, pNextSpec, pEndPortBeforeNextSpec);
      
    }
    
    @Override
    public boolean isMutable() {
      return false;
    }
  }
}
