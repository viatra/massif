package hu.bme.mit.transima.models.simulink.util;

import hu.bme.mit.transima.Simulink.InPort;
import hu.bme.mit.transima.Simulink.OutPort;
import hu.bme.mit.transima.models.simulink.util.util.InPortToBlockPortOutPortQuerySpecification;
import java.util.Arrays;
import java.util.List;
import org.eclipse.incquery.runtime.api.IPatternMatch;
import org.eclipse.incquery.runtime.api.impl.BasePatternMatch;
import org.eclipse.incquery.runtime.exception.IncQueryException;

/**
 * Pattern-specific match representation of the hu.bme.mit.transima.models.simulink.util.inPortToBlockPortOutPort pattern,
 * to be used in conjunction with {@link InPortToBlockPortOutPortMatcher}.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters,
 * usable to represent a match of the pattern in the result of a query,
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see InPortToBlockPortOutPortMatcher
 * @see InPortToBlockPortOutPortProcessor
 * 
 */
@SuppressWarnings("all")
public abstract class InPortToBlockPortOutPortMatch extends BasePatternMatch {
  private InPort fInPort;
  
  private OutPort fOutPortOfPBl;
  
  private static List<String> parameterNames = makeImmutableList("inPort", "outPortOfPBl");
  
  private InPortToBlockPortOutPortMatch(final InPort pInPort, final OutPort pOutPortOfPBl) {
    this.fInPort = pInPort;
    this.fOutPortOfPBl = pOutPortOfPBl;
    
  }
  
  @Override
  public Object get(final String parameterName) {
    if ("inPort".equals(parameterName)) return this.fInPort;
    if ("outPortOfPBl".equals(parameterName)) return this.fOutPortOfPBl;
    return null;
    
  }
  
  public InPort getInPort() {
    return this.fInPort;
    
  }
  
  public OutPort getOutPortOfPBl() {
    return this.fOutPortOfPBl;
    
  }
  
  @Override
  public boolean set(final String parameterName, final Object newValue) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    if ("inPort".equals(parameterName) ) {
    	this.fInPort = (hu.bme.mit.transima.Simulink.InPort) newValue;
    	return true;
    }
    if ("outPortOfPBl".equals(parameterName) ) {
    	this.fOutPortOfPBl = (hu.bme.mit.transima.Simulink.OutPort) newValue;
    	return true;
    }
    return false;
    
  }
  
  public void setInPort(final InPort pInPort) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fInPort = pInPort;
    
  }
  
  public void setOutPortOfPBl(final OutPort pOutPortOfPBl) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fOutPortOfPBl = pOutPortOfPBl;
    
  }
  
  @Override
  public String patternName() {
    return "hu.bme.mit.transima.models.simulink.util.inPortToBlockPortOutPort";
    
  }
  
  @Override
  public List<String> parameterNames() {
    return InPortToBlockPortOutPortMatch.parameterNames;
    
  }
  
  @Override
  public Object[] toArray() {
    return new Object[]{fInPort, fOutPortOfPBl};
    
  }
  
  @Override
  public InPortToBlockPortOutPortMatch toImmutable() {
    return isMutable() ? newMatch(fInPort, fOutPortOfPBl) : this;
    
  }
  
  @Override
  public String prettyPrint() {
    StringBuilder result = new StringBuilder();
    result.append("\"inPort\"=" + prettyPrintValue(fInPort) + ", ");
    result.append("\"outPortOfPBl\"=" + prettyPrintValue(fOutPortOfPBl));
    return result.toString();
    
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((fInPort == null) ? 0 : fInPort.hashCode());
    result = prime * result + ((fOutPortOfPBl == null) ? 0 : fOutPortOfPBl.hashCode());
    return result;
    
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
    	return true;
    if (!(obj instanceof InPortToBlockPortOutPortMatch)) { // this should be infrequent
    	if (obj == null)
    		return false;
    	if (!(obj instanceof IPatternMatch))
    		return false;
    	IPatternMatch otherSig  = (IPatternMatch) obj;
    	if (!specification().equals(otherSig.specification()))
    		return false;
    	return Arrays.deepEquals(toArray(), otherSig.toArray());
    }
    InPortToBlockPortOutPortMatch other = (InPortToBlockPortOutPortMatch) obj;
    if (fInPort == null) {if (other.fInPort != null) return false;}
    else if (!fInPort.equals(other.fInPort)) return false;
    if (fOutPortOfPBl == null) {if (other.fOutPortOfPBl != null) return false;}
    else if (!fOutPortOfPBl.equals(other.fOutPortOfPBl)) return false;
    return true;
  }
  
  @Override
  public InPortToBlockPortOutPortQuerySpecification specification() {
    try {
    	return InPortToBlockPortOutPortQuerySpecification.instance();
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
  public static InPortToBlockPortOutPortMatch newEmptyMatch() {
    return new Mutable(null, null);
    
  }
  
  /**
   * Returns a mutable (partial) match.
   * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
   * 
   * @param pInPort the fixed value of pattern parameter inPort, or null if not bound.
   * @param pOutPortOfPBl the fixed value of pattern parameter outPortOfPBl, or null if not bound.
   * @return the new, mutable (partial) match object.
   * 
   */
  public static InPortToBlockPortOutPortMatch newMutableMatch(final InPort pInPort, final OutPort pOutPortOfPBl) {
    return new Mutable(pInPort, pOutPortOfPBl);
    
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
  public static InPortToBlockPortOutPortMatch newMatch(final InPort pInPort, final OutPort pOutPortOfPBl) {
    return new Immutable(pInPort, pOutPortOfPBl);
    
  }
  
  private static final class Mutable extends InPortToBlockPortOutPortMatch {
    Mutable(final InPort pInPort, final OutPort pOutPortOfPBl) {
      super(pInPort, pOutPortOfPBl);
      
    }
    
    @Override
    public boolean isMutable() {
      return true;
    }
  }
  
  private static final class Immutable extends InPortToBlockPortOutPortMatch {
    Immutable(final InPort pInPort, final OutPort pOutPortOfPBl) {
      super(pInPort, pOutPortOfPBl);
      
    }
    
    @Override
    public boolean isMutable() {
      return false;
    }
  }
}
