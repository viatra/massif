package hu.bme.mit.transima.models.simulink.util;

import hu.bme.mit.transima.Simulink.Port;
import hu.bme.mit.transima.Simulink.PortBlock;
import hu.bme.mit.transima.models.simulink.util.util.PortToPortBlockQuerySpecification;
import java.util.Arrays;
import java.util.List;
import org.eclipse.incquery.runtime.api.IPatternMatch;
import org.eclipse.incquery.runtime.api.impl.BasePatternMatch;
import org.eclipse.incquery.runtime.exception.IncQueryException;

/**
 * Pattern-specific match representation of the hu.bme.mit.transima.models.simulink.util.portToPortBlock pattern,
 * to be used in conjunction with {@link PortToPortBlockMatcher}.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters,
 * usable to represent a match of the pattern in the result of a query,
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see PortToPortBlockMatcher
 * @see PortToPortBlockProcessor
 * 
 */
@SuppressWarnings("all")
public abstract class PortToPortBlockMatch extends BasePatternMatch {
  private Port fPort;
  
  private PortBlock fPortBlock;
  
  private static List<String> parameterNames = makeImmutableList("port", "portBlock");
  
  private PortToPortBlockMatch(final Port pPort, final PortBlock pPortBlock) {
    this.fPort = pPort;
    this.fPortBlock = pPortBlock;
    
  }
  
  @Override
  public Object get(final String parameterName) {
    if ("port".equals(parameterName)) return this.fPort;
    if ("portBlock".equals(parameterName)) return this.fPortBlock;
    return null;
    
  }
  
  public Port getPort() {
    return this.fPort;
    
  }
  
  public PortBlock getPortBlock() {
    return this.fPortBlock;
    
  }
  
  @Override
  public boolean set(final String parameterName, final Object newValue) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    if ("port".equals(parameterName) ) {
    	this.fPort = (hu.bme.mit.transima.Simulink.Port) newValue;
    	return true;
    }
    if ("portBlock".equals(parameterName) ) {
    	this.fPortBlock = (hu.bme.mit.transima.Simulink.PortBlock) newValue;
    	return true;
    }
    return false;
    
  }
  
  public void setPort(final Port pPort) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fPort = pPort;
    
  }
  
  public void setPortBlock(final PortBlock pPortBlock) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fPortBlock = pPortBlock;
    
  }
  
  @Override
  public String patternName() {
    return "hu.bme.mit.transima.models.simulink.util.portToPortBlock";
    
  }
  
  @Override
  public List<String> parameterNames() {
    return PortToPortBlockMatch.parameterNames;
    
  }
  
  @Override
  public Object[] toArray() {
    return new Object[]{fPort, fPortBlock};
    
  }
  
  @Override
  public PortToPortBlockMatch toImmutable() {
    return isMutable() ? newMatch(fPort, fPortBlock) : this;
    
  }
  
  @Override
  public String prettyPrint() {
    StringBuilder result = new StringBuilder();
    result.append("\"port\"=" + prettyPrintValue(fPort) + ", ");
    result.append("\"portBlock\"=" + prettyPrintValue(fPortBlock));
    return result.toString();
    
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((fPort == null) ? 0 : fPort.hashCode());
    result = prime * result + ((fPortBlock == null) ? 0 : fPortBlock.hashCode());
    return result;
    
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
    	return true;
    if (!(obj instanceof PortToPortBlockMatch)) { // this should be infrequent
    	if (obj == null)
    		return false;
    	if (!(obj instanceof IPatternMatch))
    		return false;
    	IPatternMatch otherSig  = (IPatternMatch) obj;
    	if (!specification().equals(otherSig.specification()))
    		return false;
    	return Arrays.deepEquals(toArray(), otherSig.toArray());
    }
    PortToPortBlockMatch other = (PortToPortBlockMatch) obj;
    if (fPort == null) {if (other.fPort != null) return false;}
    else if (!fPort.equals(other.fPort)) return false;
    if (fPortBlock == null) {if (other.fPortBlock != null) return false;}
    else if (!fPortBlock.equals(other.fPortBlock)) return false;
    return true;
  }
  
  @Override
  public PortToPortBlockQuerySpecification specification() {
    try {
    	return PortToPortBlockQuerySpecification.instance();
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
  public static PortToPortBlockMatch newEmptyMatch() {
    return new Mutable(null, null);
    
  }
  
  /**
   * Returns a mutable (partial) match.
   * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
   * 
   * @param pPort the fixed value of pattern parameter port, or null if not bound.
   * @param pPortBlock the fixed value of pattern parameter portBlock, or null if not bound.
   * @return the new, mutable (partial) match object.
   * 
   */
  public static PortToPortBlockMatch newMutableMatch(final Port pPort, final PortBlock pPortBlock) {
    return new Mutable(pPort, pPortBlock);
    
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pPort the fixed value of pattern parameter port, or null if not bound.
   * @param pPortBlock the fixed value of pattern parameter portBlock, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public static PortToPortBlockMatch newMatch(final Port pPort, final PortBlock pPortBlock) {
    return new Immutable(pPort, pPortBlock);
    
  }
  
  private static final class Mutable extends PortToPortBlockMatch {
    Mutable(final Port pPort, final PortBlock pPortBlock) {
      super(pPort, pPortBlock);
      
    }
    
    @Override
    public boolean isMutable() {
      return true;
    }
  }
  
  private static final class Immutable extends PortToPortBlockMatch {
    Immutable(final Port pPort, final PortBlock pPortBlock) {
      super(pPort, pPortBlock);
      
    }
    
    @Override
    public boolean isMutable() {
      return false;
    }
  }
}
