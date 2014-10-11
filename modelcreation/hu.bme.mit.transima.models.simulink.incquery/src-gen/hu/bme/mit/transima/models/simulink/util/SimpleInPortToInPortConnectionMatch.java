package hu.bme.mit.transima.models.simulink.util;

import hu.bme.mit.transima.Simulink.InPort;
import hu.bme.mit.transima.Simulink.SingleConnection;
import hu.bme.mit.transima.models.simulink.util.util.SimpleInPortToInPortConnectionQuerySpecification;
import java.util.Arrays;
import java.util.List;
import org.eclipse.incquery.runtime.api.IPatternMatch;
import org.eclipse.incquery.runtime.api.impl.BasePatternMatch;
import org.eclipse.incquery.runtime.exception.IncQueryException;

/**
 * Pattern-specific match representation of the hu.bme.mit.transima.models.simulink.util.simpleInPortToInPortConnection pattern,
 * to be used in conjunction with {@link SimpleInPortToInPortConnectionMatcher}.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters,
 * usable to represent a match of the pattern in the result of a query,
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see SimpleInPortToInPortConnectionMatcher
 * @see SimpleInPortToInPortConnectionProcessor
 * 
 */
@SuppressWarnings("all")
public abstract class SimpleInPortToInPortConnectionMatch extends BasePatternMatch {
  private InPort fSourceInPort;
  
  private InPort fTargetInPort;
  
  private SingleConnection fConnection;
  
  private static List<String> parameterNames = makeImmutableList("sourceInPort", "targetInPort", "connection");
  
  private SimpleInPortToInPortConnectionMatch(final InPort pSourceInPort, final InPort pTargetInPort, final SingleConnection pConnection) {
    this.fSourceInPort = pSourceInPort;
    this.fTargetInPort = pTargetInPort;
    this.fConnection = pConnection;
    
  }
  
  @Override
  public Object get(final String parameterName) {
    if ("sourceInPort".equals(parameterName)) return this.fSourceInPort;
    if ("targetInPort".equals(parameterName)) return this.fTargetInPort;
    if ("connection".equals(parameterName)) return this.fConnection;
    return null;
    
  }
  
  public InPort getSourceInPort() {
    return this.fSourceInPort;
    
  }
  
  public InPort getTargetInPort() {
    return this.fTargetInPort;
    
  }
  
  public SingleConnection getConnection() {
    return this.fConnection;
    
  }
  
  @Override
  public boolean set(final String parameterName, final Object newValue) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    if ("sourceInPort".equals(parameterName) ) {
    	this.fSourceInPort = (hu.bme.mit.transima.Simulink.InPort) newValue;
    	return true;
    }
    if ("targetInPort".equals(parameterName) ) {
    	this.fTargetInPort = (hu.bme.mit.transima.Simulink.InPort) newValue;
    	return true;
    }
    if ("connection".equals(parameterName) ) {
    	this.fConnection = (hu.bme.mit.transima.Simulink.SingleConnection) newValue;
    	return true;
    }
    return false;
    
  }
  
  public void setSourceInPort(final InPort pSourceInPort) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fSourceInPort = pSourceInPort;
    
  }
  
  public void setTargetInPort(final InPort pTargetInPort) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fTargetInPort = pTargetInPort;
    
  }
  
  public void setConnection(final SingleConnection pConnection) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fConnection = pConnection;
    
  }
  
  @Override
  public String patternName() {
    return "hu.bme.mit.transima.models.simulink.util.simpleInPortToInPortConnection";
    
  }
  
  @Override
  public List<String> parameterNames() {
    return SimpleInPortToInPortConnectionMatch.parameterNames;
    
  }
  
  @Override
  public Object[] toArray() {
    return new Object[]{fSourceInPort, fTargetInPort, fConnection};
    
  }
  
  @Override
  public SimpleInPortToInPortConnectionMatch toImmutable() {
    return isMutable() ? newMatch(fSourceInPort, fTargetInPort, fConnection) : this;
    
  }
  
  @Override
  public String prettyPrint() {
    StringBuilder result = new StringBuilder();
    result.append("\"sourceInPort\"=" + prettyPrintValue(fSourceInPort) + ", ");
    result.append("\"targetInPort\"=" + prettyPrintValue(fTargetInPort) + ", ");
    result.append("\"connection\"=" + prettyPrintValue(fConnection));
    return result.toString();
    
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((fSourceInPort == null) ? 0 : fSourceInPort.hashCode());
    result = prime * result + ((fTargetInPort == null) ? 0 : fTargetInPort.hashCode());
    result = prime * result + ((fConnection == null) ? 0 : fConnection.hashCode());
    return result;
    
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
    	return true;
    if (!(obj instanceof SimpleInPortToInPortConnectionMatch)) { // this should be infrequent
    	if (obj == null)
    		return false;
    	if (!(obj instanceof IPatternMatch))
    		return false;
    	IPatternMatch otherSig  = (IPatternMatch) obj;
    	if (!specification().equals(otherSig.specification()))
    		return false;
    	return Arrays.deepEquals(toArray(), otherSig.toArray());
    }
    SimpleInPortToInPortConnectionMatch other = (SimpleInPortToInPortConnectionMatch) obj;
    if (fSourceInPort == null) {if (other.fSourceInPort != null) return false;}
    else if (!fSourceInPort.equals(other.fSourceInPort)) return false;
    if (fTargetInPort == null) {if (other.fTargetInPort != null) return false;}
    else if (!fTargetInPort.equals(other.fTargetInPort)) return false;
    if (fConnection == null) {if (other.fConnection != null) return false;}
    else if (!fConnection.equals(other.fConnection)) return false;
    return true;
  }
  
  @Override
  public SimpleInPortToInPortConnectionQuerySpecification specification() {
    try {
    	return SimpleInPortToInPortConnectionQuerySpecification.instance();
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
  public static SimpleInPortToInPortConnectionMatch newEmptyMatch() {
    return new Mutable(null, null, null);
    
  }
  
  /**
   * Returns a mutable (partial) match.
   * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
   * 
   * @param pSourceInPort the fixed value of pattern parameter sourceInPort, or null if not bound.
   * @param pTargetInPort the fixed value of pattern parameter targetInPort, or null if not bound.
   * @param pConnection the fixed value of pattern parameter connection, or null if not bound.
   * @return the new, mutable (partial) match object.
   * 
   */
  public static SimpleInPortToInPortConnectionMatch newMutableMatch(final InPort pSourceInPort, final InPort pTargetInPort, final SingleConnection pConnection) {
    return new Mutable(pSourceInPort, pTargetInPort, pConnection);
    
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pSourceInPort the fixed value of pattern parameter sourceInPort, or null if not bound.
   * @param pTargetInPort the fixed value of pattern parameter targetInPort, or null if not bound.
   * @param pConnection the fixed value of pattern parameter connection, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public static SimpleInPortToInPortConnectionMatch newMatch(final InPort pSourceInPort, final InPort pTargetInPort, final SingleConnection pConnection) {
    return new Immutable(pSourceInPort, pTargetInPort, pConnection);
    
  }
  
  private static final class Mutable extends SimpleInPortToInPortConnectionMatch {
    Mutable(final InPort pSourceInPort, final InPort pTargetInPort, final SingleConnection pConnection) {
      super(pSourceInPort, pTargetInPort, pConnection);
      
    }
    
    @Override
    public boolean isMutable() {
      return true;
    }
  }
  
  private static final class Immutable extends SimpleInPortToInPortConnectionMatch {
    Immutable(final InPort pSourceInPort, final InPort pTargetInPort, final SingleConnection pConnection) {
      super(pSourceInPort, pTargetInPort, pConnection);
      
    }
    
    @Override
    public boolean isMutable() {
      return false;
    }
  }
}
