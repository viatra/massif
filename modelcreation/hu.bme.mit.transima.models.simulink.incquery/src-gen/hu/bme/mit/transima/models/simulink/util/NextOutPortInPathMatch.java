package hu.bme.mit.transima.models.simulink.util;

import hu.bme.mit.transima.Simulink.OutPort;
import hu.bme.mit.transima.models.simulink.util.util.NextOutPortInPathQuerySpecification;
import java.util.Arrays;
import java.util.List;
import org.eclipse.incquery.runtime.api.IPatternMatch;
import org.eclipse.incquery.runtime.api.impl.BasePatternMatch;
import org.eclipse.incquery.runtime.exception.IncQueryException;

/**
 * Pattern-specific match representation of the hu.bme.mit.transima.models.simulink.util.nextOutPortInPath pattern,
 * to be used in conjunction with {@link NextOutPortInPathMatcher}.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters,
 * usable to represent a match of the pattern in the result of a query,
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see NextOutPortInPathMatcher
 * @see NextOutPortInPathProcessor
 * 
 */
@SuppressWarnings("all")
public abstract class NextOutPortInPathMatch extends BasePatternMatch {
  private OutPort fSourceOutPort;
  
  private OutPort fNextOutPort;
  
  private OutPort fTargetOutPort;
  
  private static List<String> parameterNames = makeImmutableList("sourceOutPort", "nextOutPort", "targetOutPort");
  
  private NextOutPortInPathMatch(final OutPort pSourceOutPort, final OutPort pNextOutPort, final OutPort pTargetOutPort) {
    this.fSourceOutPort = pSourceOutPort;
    this.fNextOutPort = pNextOutPort;
    this.fTargetOutPort = pTargetOutPort;
    
  }
  
  @Override
  public Object get(final String parameterName) {
    if ("sourceOutPort".equals(parameterName)) return this.fSourceOutPort;
    if ("nextOutPort".equals(parameterName)) return this.fNextOutPort;
    if ("targetOutPort".equals(parameterName)) return this.fTargetOutPort;
    return null;
    
  }
  
  public OutPort getSourceOutPort() {
    return this.fSourceOutPort;
    
  }
  
  public OutPort getNextOutPort() {
    return this.fNextOutPort;
    
  }
  
  public OutPort getTargetOutPort() {
    return this.fTargetOutPort;
    
  }
  
  @Override
  public boolean set(final String parameterName, final Object newValue) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    if ("sourceOutPort".equals(parameterName) ) {
    	this.fSourceOutPort = (hu.bme.mit.transima.Simulink.OutPort) newValue;
    	return true;
    }
    if ("nextOutPort".equals(parameterName) ) {
    	this.fNextOutPort = (hu.bme.mit.transima.Simulink.OutPort) newValue;
    	return true;
    }
    if ("targetOutPort".equals(parameterName) ) {
    	this.fTargetOutPort = (hu.bme.mit.transima.Simulink.OutPort) newValue;
    	return true;
    }
    return false;
    
  }
  
  public void setSourceOutPort(final OutPort pSourceOutPort) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fSourceOutPort = pSourceOutPort;
    
  }
  
  public void setNextOutPort(final OutPort pNextOutPort) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fNextOutPort = pNextOutPort;
    
  }
  
  public void setTargetOutPort(final OutPort pTargetOutPort) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fTargetOutPort = pTargetOutPort;
    
  }
  
  @Override
  public String patternName() {
    return "hu.bme.mit.transima.models.simulink.util.nextOutPortInPath";
    
  }
  
  @Override
  public List<String> parameterNames() {
    return NextOutPortInPathMatch.parameterNames;
    
  }
  
  @Override
  public Object[] toArray() {
    return new Object[]{fSourceOutPort, fNextOutPort, fTargetOutPort};
    
  }
  
  @Override
  public NextOutPortInPathMatch toImmutable() {
    return isMutable() ? newMatch(fSourceOutPort, fNextOutPort, fTargetOutPort) : this;
    
  }
  
  @Override
  public String prettyPrint() {
    StringBuilder result = new StringBuilder();
    result.append("\"sourceOutPort\"=" + prettyPrintValue(fSourceOutPort) + ", ");
    result.append("\"nextOutPort\"=" + prettyPrintValue(fNextOutPort) + ", ");
    result.append("\"targetOutPort\"=" + prettyPrintValue(fTargetOutPort));
    return result.toString();
    
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((fSourceOutPort == null) ? 0 : fSourceOutPort.hashCode());
    result = prime * result + ((fNextOutPort == null) ? 0 : fNextOutPort.hashCode());
    result = prime * result + ((fTargetOutPort == null) ? 0 : fTargetOutPort.hashCode());
    return result;
    
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
    	return true;
    if (!(obj instanceof NextOutPortInPathMatch)) { // this should be infrequent
    	if (obj == null)
    		return false;
    	if (!(obj instanceof IPatternMatch))
    		return false;
    	IPatternMatch otherSig  = (IPatternMatch) obj;
    	if (!specification().equals(otherSig.specification()))
    		return false;
    	return Arrays.deepEquals(toArray(), otherSig.toArray());
    }
    NextOutPortInPathMatch other = (NextOutPortInPathMatch) obj;
    if (fSourceOutPort == null) {if (other.fSourceOutPort != null) return false;}
    else if (!fSourceOutPort.equals(other.fSourceOutPort)) return false;
    if (fNextOutPort == null) {if (other.fNextOutPort != null) return false;}
    else if (!fNextOutPort.equals(other.fNextOutPort)) return false;
    if (fTargetOutPort == null) {if (other.fTargetOutPort != null) return false;}
    else if (!fTargetOutPort.equals(other.fTargetOutPort)) return false;
    return true;
  }
  
  @Override
  public NextOutPortInPathQuerySpecification specification() {
    try {
    	return NextOutPortInPathQuerySpecification.instance();
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
  public static NextOutPortInPathMatch newEmptyMatch() {
    return new Mutable(null, null, null);
    
  }
  
  /**
   * Returns a mutable (partial) match.
   * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
   * 
   * @param pSourceOutPort the fixed value of pattern parameter sourceOutPort, or null if not bound.
   * @param pNextOutPort the fixed value of pattern parameter nextOutPort, or null if not bound.
   * @param pTargetOutPort the fixed value of pattern parameter targetOutPort, or null if not bound.
   * @return the new, mutable (partial) match object.
   * 
   */
  public static NextOutPortInPathMatch newMutableMatch(final OutPort pSourceOutPort, final OutPort pNextOutPort, final OutPort pTargetOutPort) {
    return new Mutable(pSourceOutPort, pNextOutPort, pTargetOutPort);
    
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pSourceOutPort the fixed value of pattern parameter sourceOutPort, or null if not bound.
   * @param pNextOutPort the fixed value of pattern parameter nextOutPort, or null if not bound.
   * @param pTargetOutPort the fixed value of pattern parameter targetOutPort, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public static NextOutPortInPathMatch newMatch(final OutPort pSourceOutPort, final OutPort pNextOutPort, final OutPort pTargetOutPort) {
    return new Immutable(pSourceOutPort, pNextOutPort, pTargetOutPort);
    
  }
  
  private static final class Mutable extends NextOutPortInPathMatch {
    Mutable(final OutPort pSourceOutPort, final OutPort pNextOutPort, final OutPort pTargetOutPort) {
      super(pSourceOutPort, pNextOutPort, pTargetOutPort);
      
    }
    
    @Override
    public boolean isMutable() {
      return true;
    }
  }
  
  private static final class Immutable extends NextOutPortInPathMatch {
    Immutable(final OutPort pSourceOutPort, final OutPort pNextOutPort, final OutPort pTargetOutPort) {
      super(pSourceOutPort, pNextOutPort, pTargetOutPort);
      
    }
    
    @Override
    public boolean isMutable() {
      return false;
    }
  }
}
