package hu.bme.mit.transima.models.simulink.derived;

import hu.bme.mit.transima.Simulink.Block;
import hu.bme.mit.transima.Simulink.LibraryLinkReference;
import hu.bme.mit.transima.models.simulink.derived.util.SourceBlockNotFoundQuerySpecification;
import java.util.Arrays;
import java.util.List;
import org.eclipse.incquery.runtime.api.IPatternMatch;
import org.eclipse.incquery.runtime.api.impl.BasePatternMatch;
import org.eclipse.incquery.runtime.exception.IncQueryException;

/**
 * Pattern-specific match representation of the hu.bme.mit.transima.models.simulink.derived.sourceBlockNotFound pattern,
 * to be used in conjunction with {@link SourceBlockNotFoundMatcher}.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters,
 * usable to represent a match of the pattern in the result of a query,
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see SourceBlockNotFoundMatcher
 * @see SourceBlockNotFoundProcessor
 * 
 */
@SuppressWarnings("all")
public abstract class SourceBlockNotFoundMatch extends BasePatternMatch {
  private Block fBlock;
  
  private LibraryLinkReference fBlRef;
  
  private static List<String> parameterNames = makeImmutableList("Block", "BlRef");
  
  private SourceBlockNotFoundMatch(final Block pBlock, final LibraryLinkReference pBlRef) {
    this.fBlock = pBlock;
    this.fBlRef = pBlRef;
    
  }
  
  @Override
  public Object get(final String parameterName) {
    if ("Block".equals(parameterName)) return this.fBlock;
    if ("BlRef".equals(parameterName)) return this.fBlRef;
    return null;
    
  }
  
  public Block getBlock() {
    return this.fBlock;
    
  }
  
  public LibraryLinkReference getBlRef() {
    return this.fBlRef;
    
  }
  
  @Override
  public boolean set(final String parameterName, final Object newValue) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    if ("Block".equals(parameterName) ) {
    	this.fBlock = (hu.bme.mit.transima.Simulink.Block) newValue;
    	return true;
    }
    if ("BlRef".equals(parameterName) ) {
    	this.fBlRef = (hu.bme.mit.transima.Simulink.LibraryLinkReference) newValue;
    	return true;
    }
    return false;
    
  }
  
  public void setBlock(final Block pBlock) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fBlock = pBlock;
    
  }
  
  public void setBlRef(final LibraryLinkReference pBlRef) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fBlRef = pBlRef;
    
  }
  
  @Override
  public String patternName() {
    return "hu.bme.mit.transima.models.simulink.derived.sourceBlockNotFound";
    
  }
  
  @Override
  public List<String> parameterNames() {
    return SourceBlockNotFoundMatch.parameterNames;
    
  }
  
  @Override
  public Object[] toArray() {
    return new Object[]{fBlock, fBlRef};
    
  }
  
  @Override
  public SourceBlockNotFoundMatch toImmutable() {
    return isMutable() ? newMatch(fBlock, fBlRef) : this;
    
  }
  
  @Override
  public String prettyPrint() {
    StringBuilder result = new StringBuilder();
    result.append("\"Block\"=" + prettyPrintValue(fBlock) + ", ");
    result.append("\"BlRef\"=" + prettyPrintValue(fBlRef));
    return result.toString();
    
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((fBlock == null) ? 0 : fBlock.hashCode());
    result = prime * result + ((fBlRef == null) ? 0 : fBlRef.hashCode());
    return result;
    
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
    	return true;
    if (!(obj instanceof SourceBlockNotFoundMatch)) { // this should be infrequent
    	if (obj == null)
    		return false;
    	if (!(obj instanceof IPatternMatch))
    		return false;
    	IPatternMatch otherSig  = (IPatternMatch) obj;
    	if (!specification().equals(otherSig.specification()))
    		return false;
    	return Arrays.deepEquals(toArray(), otherSig.toArray());
    }
    SourceBlockNotFoundMatch other = (SourceBlockNotFoundMatch) obj;
    if (fBlock == null) {if (other.fBlock != null) return false;}
    else if (!fBlock.equals(other.fBlock)) return false;
    if (fBlRef == null) {if (other.fBlRef != null) return false;}
    else if (!fBlRef.equals(other.fBlRef)) return false;
    return true;
  }
  
  @Override
  public SourceBlockNotFoundQuerySpecification specification() {
    try {
    	return SourceBlockNotFoundQuerySpecification.instance();
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
  public static SourceBlockNotFoundMatch newEmptyMatch() {
    return new Mutable(null, null);
    
  }
  
  /**
   * Returns a mutable (partial) match.
   * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
   * 
   * @param pBlock the fixed value of pattern parameter Block, or null if not bound.
   * @param pBlRef the fixed value of pattern parameter BlRef, or null if not bound.
   * @return the new, mutable (partial) match object.
   * 
   */
  public static SourceBlockNotFoundMatch newMutableMatch(final Block pBlock, final LibraryLinkReference pBlRef) {
    return new Mutable(pBlock, pBlRef);
    
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pBlock the fixed value of pattern parameter Block, or null if not bound.
   * @param pBlRef the fixed value of pattern parameter BlRef, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public static SourceBlockNotFoundMatch newMatch(final Block pBlock, final LibraryLinkReference pBlRef) {
    return new Immutable(pBlock, pBlRef);
    
  }
  
  private static final class Mutable extends SourceBlockNotFoundMatch {
    Mutable(final Block pBlock, final LibraryLinkReference pBlRef) {
      super(pBlock, pBlRef);
      
    }
    
    @Override
    public boolean isMutable() {
      return true;
    }
  }
  
  private static final class Immutable extends SourceBlockNotFoundMatch {
    Immutable(final Block pBlock, final LibraryLinkReference pBlRef) {
      super(pBlock, pBlRef);
      
    }
    
    @Override
    public boolean isMutable() {
      return false;
    }
  }
}
