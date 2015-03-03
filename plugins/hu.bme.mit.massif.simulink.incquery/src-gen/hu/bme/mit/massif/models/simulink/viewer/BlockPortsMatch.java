package hu.bme.mit.massif.models.simulink.viewer;

import hu.bme.mit.massif.models.simulink.viewer.util.BlockPortsQuerySpecification;
import hu.bme.mit.massif.simulink.Block;
import hu.bme.mit.massif.simulink.Port;
import java.util.Arrays;
import java.util.List;
import org.eclipse.incquery.runtime.api.IPatternMatch;
import org.eclipse.incquery.runtime.api.impl.BasePatternMatch;
import org.eclipse.incquery.runtime.exception.IncQueryException;

/**
 * Pattern-specific match representation of the hu.bme.mit.massif.models.simulink.viewer.blockPorts pattern,
 * to be used in conjunction with {@link BlockPortsMatcher}.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters,
 * usable to represent a match of the pattern in the result of a query,
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see BlockPortsMatcher
 * @see BlockPortsProcessor
 * 
 */
@SuppressWarnings("all")
public abstract class BlockPortsMatch extends BasePatternMatch {
  private Block fBlock;
  
  private Port fPort;
  
  private static List<String> parameterNames = makeImmutableList("block", "port");
  
  private BlockPortsMatch(final Block pBlock, final Port pPort) {
    this.fBlock = pBlock;
    this.fPort = pPort;
  }
  
  @Override
  public Object get(final String parameterName) {
    if ("block".equals(parameterName)) return this.fBlock;
    if ("port".equals(parameterName)) return this.fPort;
    return null;
  }
  
  public Block getBlock() {
    return this.fBlock;
  }
  
  public Port getPort() {
    return this.fPort;
  }
  
  @Override
  public boolean set(final String parameterName, final Object newValue) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    if ("block".equals(parameterName) ) {
    	this.fBlock = (hu.bme.mit.massif.simulink.Block) newValue;
    	return true;
    }
    if ("port".equals(parameterName) ) {
    	this.fPort = (hu.bme.mit.massif.simulink.Port) newValue;
    	return true;
    }
    return false;
  }
  
  public void setBlock(final Block pBlock) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fBlock = pBlock;
  }
  
  public void setPort(final Port pPort) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fPort = pPort;
  }
  
  @Override
  public String patternName() {
    return "hu.bme.mit.massif.models.simulink.viewer.blockPorts";
  }
  
  @Override
  public List<String> parameterNames() {
    return BlockPortsMatch.parameterNames;
  }
  
  @Override
  public Object[] toArray() {
    return new Object[]{fBlock, fPort};
  }
  
  @Override
  public BlockPortsMatch toImmutable() {
    return isMutable() ? newMatch(fBlock, fPort) : this;
  }
  
  @Override
  public String prettyPrint() {
    StringBuilder result = new StringBuilder();
    result.append("\"block\"=" + prettyPrintValue(fBlock) + ", ");
    
    result.append("\"port\"=" + prettyPrintValue(fPort)
    );
    return result.toString();
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((fBlock == null) ? 0 : fBlock.hashCode());
    result = prime * result + ((fPort == null) ? 0 : fPort.hashCode());
    return result;
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
    	return true;
    if (!(obj instanceof BlockPortsMatch)) { // this should be infrequent
    	if (obj == null) {
    		return false;
    	}
    	if (!(obj instanceof IPatternMatch)) {
    		return false;
    	}
    	IPatternMatch otherSig  = (IPatternMatch) obj;
    	if (!specification().equals(otherSig.specification()))
    		return false;
    	return Arrays.deepEquals(toArray(), otherSig.toArray());
    }
    BlockPortsMatch other = (BlockPortsMatch) obj;
    if (fBlock == null) {if (other.fBlock != null) return false;}
    else if (!fBlock.equals(other.fBlock)) return false;
    if (fPort == null) {if (other.fPort != null) return false;}
    else if (!fPort.equals(other.fPort)) return false;
    return true;
  }
  
  @Override
  public BlockPortsQuerySpecification specification() {
    try {
    	return BlockPortsQuerySpecification.instance();
    } catch (IncQueryException ex) {
     	// This cannot happen, as the match object can only be instantiated if the query specification exists
     	throw new IllegalStateException (ex);
    }
  }
  
  /**
   * Returns an empty, mutable match.
   * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
   * 
   * @return the empty match.
   * 
   */
  public static BlockPortsMatch newEmptyMatch() {
    return new Mutable(null, null);
  }
  
  /**
   * Returns a mutable (partial) match.
   * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
   * 
   * @param pBlock the fixed value of pattern parameter block, or null if not bound.
   * @param pPort the fixed value of pattern parameter port, or null if not bound.
   * @return the new, mutable (partial) match object.
   * 
   */
  public static BlockPortsMatch newMutableMatch(final Block pBlock, final Port pPort) {
    return new Mutable(pBlock, pPort);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pBlock the fixed value of pattern parameter block, or null if not bound.
   * @param pPort the fixed value of pattern parameter port, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public static BlockPortsMatch newMatch(final Block pBlock, final Port pPort) {
    return new Immutable(pBlock, pPort);
  }
  
  private static final class Mutable extends BlockPortsMatch {
    Mutable(final Block pBlock, final Port pPort) {
      super(pBlock, pPort);
    }
    
    @Override
    public boolean isMutable() {
      return true;
    }
  }
  
  private static final class Immutable extends BlockPortsMatch {
    Immutable(final Block pBlock, final Port pPort) {
      super(pBlock, pPort);
    }
    
    @Override
    public boolean isMutable() {
      return false;
    }
  }
}
