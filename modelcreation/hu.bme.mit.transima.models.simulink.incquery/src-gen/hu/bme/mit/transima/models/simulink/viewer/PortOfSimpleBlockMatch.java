package hu.bme.mit.transima.models.simulink.viewer;

import hu.bme.mit.transima.Simulink.Block;
import hu.bme.mit.transima.Simulink.Port;
import hu.bme.mit.transima.models.simulink.viewer.util.PortOfSimpleBlockQuerySpecification;
import java.util.Arrays;
import java.util.List;
import org.eclipse.incquery.runtime.api.IPatternMatch;
import org.eclipse.incquery.runtime.api.impl.BasePatternMatch;
import org.eclipse.incquery.runtime.exception.IncQueryException;

/**
 * Pattern-specific match representation of the hu.bme.mit.transima.models.simulink.viewer.portOfSimpleBlock pattern,
 * to be used in conjunction with {@link PortOfSimpleBlockMatcher}.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters,
 * usable to represent a match of the pattern in the result of a query,
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see PortOfSimpleBlockMatcher
 * @see PortOfSimpleBlockProcessor
 * 
 */
@SuppressWarnings("all")
public abstract class PortOfSimpleBlockMatch extends BasePatternMatch {
  private Port fPort;
  
  private Block fBlock;
  
  private static List<String> parameterNames = makeImmutableList("port", "block");
  
  private PortOfSimpleBlockMatch(final Port pPort, final Block pBlock) {
    this.fPort = pPort;
    this.fBlock = pBlock;
    
  }
  
  @Override
  public Object get(final String parameterName) {
    if ("port".equals(parameterName)) return this.fPort;
    if ("block".equals(parameterName)) return this.fBlock;
    return null;
    
  }
  
  public Port getPort() {
    return this.fPort;
    
  }
  
  public Block getBlock() {
    return this.fBlock;
    
  }
  
  @Override
  public boolean set(final String parameterName, final Object newValue) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    if ("port".equals(parameterName) ) {
    	this.fPort = (hu.bme.mit.transima.Simulink.Port) newValue;
    	return true;
    }
    if ("block".equals(parameterName) ) {
    	this.fBlock = (hu.bme.mit.transima.Simulink.Block) newValue;
    	return true;
    }
    return false;
    
  }
  
  public void setPort(final Port pPort) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fPort = pPort;
    
  }
  
  public void setBlock(final Block pBlock) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fBlock = pBlock;
    
  }
  
  @Override
  public String patternName() {
    return "hu.bme.mit.transima.models.simulink.viewer.portOfSimpleBlock";
    
  }
  
  @Override
  public List<String> parameterNames() {
    return PortOfSimpleBlockMatch.parameterNames;
    
  }
  
  @Override
  public Object[] toArray() {
    return new Object[]{fPort, fBlock};
    
  }
  
  @Override
  public PortOfSimpleBlockMatch toImmutable() {
    return isMutable() ? newMatch(fPort, fBlock) : this;
    
  }
  
  @Override
  public String prettyPrint() {
    StringBuilder result = new StringBuilder();
    result.append("\"port\"=" + prettyPrintValue(fPort) + ", ");
    result.append("\"block\"=" + prettyPrintValue(fBlock));
    return result.toString();
    
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((fPort == null) ? 0 : fPort.hashCode());
    result = prime * result + ((fBlock == null) ? 0 : fBlock.hashCode());
    return result;
    
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
    	return true;
    if (!(obj instanceof PortOfSimpleBlockMatch)) { // this should be infrequent
    	if (obj == null)
    		return false;
    	if (!(obj instanceof IPatternMatch))
    		return false;
    	IPatternMatch otherSig  = (IPatternMatch) obj;
    	if (!specification().equals(otherSig.specification()))
    		return false;
    	return Arrays.deepEquals(toArray(), otherSig.toArray());
    }
    PortOfSimpleBlockMatch other = (PortOfSimpleBlockMatch) obj;
    if (fPort == null) {if (other.fPort != null) return false;}
    else if (!fPort.equals(other.fPort)) return false;
    if (fBlock == null) {if (other.fBlock != null) return false;}
    else if (!fBlock.equals(other.fBlock)) return false;
    return true;
  }
  
  @Override
  public PortOfSimpleBlockQuerySpecification specification() {
    try {
    	return PortOfSimpleBlockQuerySpecification.instance();
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
  public static PortOfSimpleBlockMatch newEmptyMatch() {
    return new Mutable(null, null);
    
  }
  
  /**
   * Returns a mutable (partial) match.
   * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
   * 
   * @param pPort the fixed value of pattern parameter port, or null if not bound.
   * @param pBlock the fixed value of pattern parameter block, or null if not bound.
   * @return the new, mutable (partial) match object.
   * 
   */
  public static PortOfSimpleBlockMatch newMutableMatch(final Port pPort, final Block pBlock) {
    return new Mutable(pPort, pBlock);
    
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pPort the fixed value of pattern parameter port, or null if not bound.
   * @param pBlock the fixed value of pattern parameter block, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public static PortOfSimpleBlockMatch newMatch(final Port pPort, final Block pBlock) {
    return new Immutable(pPort, pBlock);
    
  }
  
  private static final class Mutable extends PortOfSimpleBlockMatch {
    Mutable(final Port pPort, final Block pBlock) {
      super(pPort, pBlock);
      
    }
    
    @Override
    public boolean isMutable() {
      return true;
    }
  }
  
  private static final class Immutable extends PortOfSimpleBlockMatch {
    Immutable(final Port pPort, final Block pBlock) {
      super(pPort, pBlock);
      
    }
    
    @Override
    public boolean isMutable() {
      return false;
    }
  }
}
