package hu.bme.mit.transima.models.simulink.util;

import hu.bme.mit.transima.Simulink.OutPort;
import hu.bme.mit.transima.models.simulink.util.util.SimpleConnectedOutPortQuerySpecification;
import java.util.Arrays;
import java.util.List;
import org.eclipse.incquery.runtime.api.IPatternMatch;
import org.eclipse.incquery.runtime.api.impl.BasePatternMatch;
import org.eclipse.incquery.runtime.exception.IncQueryException;

/**
 * Pattern-specific match representation of the hu.bme.mit.transima.models.simulink.util.simpleConnectedOutPort pattern,
 * to be used in conjunction with {@link SimpleConnectedOutPortMatcher}.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters,
 * usable to represent a match of the pattern in the result of a query,
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see SimpleConnectedOutPortMatcher
 * @see SimpleConnectedOutPortProcessor
 * 
 */
@SuppressWarnings("all")
public abstract class SimpleConnectedOutPortMatch extends BasePatternMatch {
  private OutPort fSourceOutPort;
  
  private OutPort fTargetOutPort;
  
  private static List<String> parameterNames = makeImmutableList("sourceOutPort", "targetOutPort");
  
  private SimpleConnectedOutPortMatch(final OutPort pSourceOutPort, final OutPort pTargetOutPort) {
    this.fSourceOutPort = pSourceOutPort;
    this.fTargetOutPort = pTargetOutPort;
    
  }
  
  public Object get(final String parameterName) {
    if ("sourceOutPort".equals(parameterName)) return this.fSourceOutPort;
    if ("targetOutPort".equals(parameterName)) return this.fTargetOutPort;
    return null;
    
  }
  
  public OutPort getSourceOutPort() {
    return this.fSourceOutPort;
    
  }
  
  public OutPort getTargetOutPort() {
    return this.fTargetOutPort;
    
  }
  
  public boolean set(final String parameterName, final Object newValue) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    if ("sourceOutPort".equals(parameterName) ) {
    	this.fSourceOutPort = (hu.bme.mit.transima.Simulink.OutPort) newValue;
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
  
  public void setTargetOutPort(final OutPort pTargetOutPort) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fTargetOutPort = pTargetOutPort;
    
  }
  
  public String patternName() {
    return "hu.bme.mit.transima.models.simulink.util.simpleConnectedOutPort";
    
  }
  
  public List<String> parameterNames() {
    return SimpleConnectedOutPortMatch.parameterNames;
    
  }
  
  public Object[] toArray() {
    return new Object[]{fSourceOutPort, fTargetOutPort};
    
  }
  
  public SimpleConnectedOutPortMatch toImmutable() {
    return isMutable() ? newMatch(fSourceOutPort, fTargetOutPort) : this;
    
  }
  
  public String prettyPrint() {
    StringBuilder result = new StringBuilder();
    result.append("\"sourceOutPort\"=" + prettyPrintValue(fSourceOutPort) + ", ");
    result.append("\"targetOutPort\"=" + prettyPrintValue(fTargetOutPort));
    return result.toString();
    
  }
  
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((fSourceOutPort == null) ? 0 : fSourceOutPort.hashCode());
    result = prime * result + ((fTargetOutPort == null) ? 0 : fTargetOutPort.hashCode());
    return result;
    
  }
  
  public boolean equals(final Object obj) {
    if (this == obj)
    	return true;
    if (!(obj instanceof SimpleConnectedOutPortMatch)) { // this should be infrequent
    	if (obj == null)
    		return false;
    	if (!(obj instanceof IPatternMatch))
    		return false;
    	IPatternMatch otherSig  = (IPatternMatch) obj;
    	if (!specification().equals(otherSig.specification()))
    		return false;
    	return Arrays.deepEquals(toArray(), otherSig.toArray());
    }
    SimpleConnectedOutPortMatch other = (SimpleConnectedOutPortMatch) obj;
    if (fSourceOutPort == null) {if (other.fSourceOutPort != null) return false;}
    else if (!fSourceOutPort.equals(other.fSourceOutPort)) return false;
    if (fTargetOutPort == null) {if (other.fTargetOutPort != null) return false;}
    else if (!fTargetOutPort.equals(other.fTargetOutPort)) return false;
    return true;
  }
  
  public SimpleConnectedOutPortQuerySpecification specification() {
    try {
    	return SimpleConnectedOutPortQuerySpecification.instance();
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
  public static SimpleConnectedOutPortMatch newEmptyMatch() {
    return new Mutable(null, null);
    
  }
  
  /**
   * Returns a mutable (partial) match.
   * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
   * 
   * @param pSourceOutPort the fixed value of pattern parameter sourceOutPort, or null if not bound.
   * @param pTargetOutPort the fixed value of pattern parameter targetOutPort, or null if not bound.
   * @return the new, mutable (partial) match object.
   * 
   */
  public static SimpleConnectedOutPortMatch newMutableMatch(final OutPort pSourceOutPort, final OutPort pTargetOutPort) {
    return new Mutable(pSourceOutPort, pTargetOutPort);
    
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pSourceOutPort the fixed value of pattern parameter sourceOutPort, or null if not bound.
   * @param pTargetOutPort the fixed value of pattern parameter targetOutPort, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public static SimpleConnectedOutPortMatch newMatch(final OutPort pSourceOutPort, final OutPort pTargetOutPort) {
    return new Immutable(pSourceOutPort, pTargetOutPort);
    
  }
  
  private static final class Mutable extends SimpleConnectedOutPortMatch {
    Mutable(final OutPort pSourceOutPort, final OutPort pTargetOutPort) {
      super(pSourceOutPort, pTargetOutPort);
      
    }
    
    public boolean isMutable() {
      return true;
    }
  }
  
  private static final class Immutable extends SimpleConnectedOutPortMatch {
    Immutable(final OutPort pSourceOutPort, final OutPort pTargetOutPort) {
      super(pSourceOutPort, pTargetOutPort);
      
    }
    
    public boolean isMutable() {
      return false;
    }
  }
}
