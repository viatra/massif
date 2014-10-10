package hu.bme.mit.transima.models.simulink.util;

import hu.bme.mit.transima.Simulink.InPort;
import hu.bme.mit.transima.models.simulink.util.util.NextInPortInPathQuerySpecification;
import java.util.Arrays;
import java.util.List;
import org.eclipse.incquery.runtime.api.IPatternMatch;
import org.eclipse.incquery.runtime.api.impl.BasePatternMatch;
import org.eclipse.incquery.runtime.exception.IncQueryException;

/**
 * Pattern-specific match representation of the hu.bme.mit.transima.models.simulink.util.nextInPortInPath pattern,
 * to be used in conjunction with {@link NextInPortInPathMatcher}.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters,
 * usable to represent a match of the pattern in the result of a query,
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see NextInPortInPathMatcher
 * @see NextInPortInPathProcessor
 * 
 */
@SuppressWarnings("all")
public abstract class NextInPortInPathMatch extends BasePatternMatch {
  private InPort fSourceInPort;
  
  private InPort fNextInPort;
  
  private InPort fTargetInPort;
  
  private static List<String> parameterNames = makeImmutableList("sourceInPort", "nextInPort", "targetInPort");
  
  private NextInPortInPathMatch(final InPort pSourceInPort, final InPort pNextInPort, final InPort pTargetInPort) {
    this.fSourceInPort = pSourceInPort;
    this.fNextInPort = pNextInPort;
    this.fTargetInPort = pTargetInPort;
    
  }
  
  public Object get(final String parameterName) {
    if ("sourceInPort".equals(parameterName)) return this.fSourceInPort;
    if ("nextInPort".equals(parameterName)) return this.fNextInPort;
    if ("targetInPort".equals(parameterName)) return this.fTargetInPort;
    return null;
    
  }
  
  public InPort getSourceInPort() {
    return this.fSourceInPort;
    
  }
  
  public InPort getNextInPort() {
    return this.fNextInPort;
    
  }
  
  public InPort getTargetInPort() {
    return this.fTargetInPort;
    
  }
  
  public boolean set(final String parameterName, final Object newValue) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    if ("sourceInPort".equals(parameterName) ) {
    	this.fSourceInPort = (hu.bme.mit.transima.Simulink.InPort) newValue;
    	return true;
    }
    if ("nextInPort".equals(parameterName) ) {
    	this.fNextInPort = (hu.bme.mit.transima.Simulink.InPort) newValue;
    	return true;
    }
    if ("targetInPort".equals(parameterName) ) {
    	this.fTargetInPort = (hu.bme.mit.transima.Simulink.InPort) newValue;
    	return true;
    }
    return false;
    
  }
  
  public void setSourceInPort(final InPort pSourceInPort) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fSourceInPort = pSourceInPort;
    
  }
  
  public void setNextInPort(final InPort pNextInPort) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fNextInPort = pNextInPort;
    
  }
  
  public void setTargetInPort(final InPort pTargetInPort) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fTargetInPort = pTargetInPort;
    
  }
  
  public String patternName() {
    return "hu.bme.mit.transima.models.simulink.util.nextInPortInPath";
    
  }
  
  public List<String> parameterNames() {
    return NextInPortInPathMatch.parameterNames;
    
  }
  
  public Object[] toArray() {
    return new Object[]{fSourceInPort, fNextInPort, fTargetInPort};
    
  }
  
  public NextInPortInPathMatch toImmutable() {
    return isMutable() ? newMatch(fSourceInPort, fNextInPort, fTargetInPort) : this;
    
  }
  
  public String prettyPrint() {
    StringBuilder result = new StringBuilder();
    result.append("\"sourceInPort\"=" + prettyPrintValue(fSourceInPort) + ", ");
    result.append("\"nextInPort\"=" + prettyPrintValue(fNextInPort) + ", ");
    result.append("\"targetInPort\"=" + prettyPrintValue(fTargetInPort));
    return result.toString();
    
  }
  
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((fSourceInPort == null) ? 0 : fSourceInPort.hashCode());
    result = prime * result + ((fNextInPort == null) ? 0 : fNextInPort.hashCode());
    result = prime * result + ((fTargetInPort == null) ? 0 : fTargetInPort.hashCode());
    return result;
    
  }
  
  public boolean equals(final Object obj) {
    if (this == obj)
    	return true;
    if (!(obj instanceof NextInPortInPathMatch)) { // this should be infrequent
    	if (obj == null)
    		return false;
    	if (!(obj instanceof IPatternMatch))
    		return false;
    	IPatternMatch otherSig  = (IPatternMatch) obj;
    	if (!specification().equals(otherSig.specification()))
    		return false;
    	return Arrays.deepEquals(toArray(), otherSig.toArray());
    }
    NextInPortInPathMatch other = (NextInPortInPathMatch) obj;
    if (fSourceInPort == null) {if (other.fSourceInPort != null) return false;}
    else if (!fSourceInPort.equals(other.fSourceInPort)) return false;
    if (fNextInPort == null) {if (other.fNextInPort != null) return false;}
    else if (!fNextInPort.equals(other.fNextInPort)) return false;
    if (fTargetInPort == null) {if (other.fTargetInPort != null) return false;}
    else if (!fTargetInPort.equals(other.fTargetInPort)) return false;
    return true;
  }
  
  public NextInPortInPathQuerySpecification specification() {
    try {
    	return NextInPortInPathQuerySpecification.instance();
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
  public static NextInPortInPathMatch newEmptyMatch() {
    return new Mutable(null, null, null);
    
  }
  
  /**
   * Returns a mutable (partial) match.
   * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
   * 
   * @param pSourceInPort the fixed value of pattern parameter sourceInPort, or null if not bound.
   * @param pNextInPort the fixed value of pattern parameter nextInPort, or null if not bound.
   * @param pTargetInPort the fixed value of pattern parameter targetInPort, or null if not bound.
   * @return the new, mutable (partial) match object.
   * 
   */
  public static NextInPortInPathMatch newMutableMatch(final InPort pSourceInPort, final InPort pNextInPort, final InPort pTargetInPort) {
    return new Mutable(pSourceInPort, pNextInPort, pTargetInPort);
    
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pSourceInPort the fixed value of pattern parameter sourceInPort, or null if not bound.
   * @param pNextInPort the fixed value of pattern parameter nextInPort, or null if not bound.
   * @param pTargetInPort the fixed value of pattern parameter targetInPort, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public static NextInPortInPathMatch newMatch(final InPort pSourceInPort, final InPort pNextInPort, final InPort pTargetInPort) {
    return new Immutable(pSourceInPort, pNextInPort, pTargetInPort);
    
  }
  
  private static final class Mutable extends NextInPortInPathMatch {
    Mutable(final InPort pSourceInPort, final InPort pNextInPort, final InPort pTargetInPort) {
      super(pSourceInPort, pNextInPort, pTargetInPort);
      
    }
    
    public boolean isMutable() {
      return true;
    }
  }
  
  private static final class Immutable extends NextInPortInPathMatch {
    Immutable(final InPort pSourceInPort, final InPort pNextInPort, final InPort pTargetInPort) {
      super(pSourceInPort, pNextInPort, pTargetInPort);
      
    }
    
    public boolean isMutable() {
      return false;
    }
  }
}
