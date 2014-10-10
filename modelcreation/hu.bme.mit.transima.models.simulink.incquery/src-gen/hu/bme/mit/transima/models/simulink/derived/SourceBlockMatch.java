package hu.bme.mit.transima.models.simulink.derived;

import hu.bme.mit.transima.Simulink.Block;
import hu.bme.mit.transima.models.simulink.derived.util.SourceBlockQuerySpecification;
import java.util.Arrays;
import java.util.List;
import org.eclipse.incquery.runtime.api.IPatternMatch;
import org.eclipse.incquery.runtime.api.impl.BasePatternMatch;
import org.eclipse.incquery.runtime.exception.IncQueryException;

/**
 * Pattern-specific match representation of the hu.bme.mit.transima.models.simulink.derived.sourceBlock pattern,
 * to be used in conjunction with {@link SourceBlockMatcher}.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters,
 * usable to represent a match of the pattern in the result of a query,
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see SourceBlockMatcher
 * @see SourceBlockProcessor
 * 
 */
@SuppressWarnings("all")
public abstract class SourceBlockMatch extends BasePatternMatch {
  private Block fThis;
  
  private Block fSource;
  
  private static List<String> parameterNames = makeImmutableList("This", "Source");
  
  private SourceBlockMatch(final Block pThis, final Block pSource) {
    this.fThis = pThis;
    this.fSource = pSource;
    
  }
  
  public Object get(final String parameterName) {
    if ("This".equals(parameterName)) return this.fThis;
    if ("Source".equals(parameterName)) return this.fSource;
    return null;
    
  }
  
  public Block getThis() {
    return this.fThis;
    
  }
  
  public Block getSource() {
    return this.fSource;
    
  }
  
  public boolean set(final String parameterName, final Object newValue) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    if ("This".equals(parameterName) ) {
    	this.fThis = (hu.bme.mit.transima.Simulink.Block) newValue;
    	return true;
    }
    if ("Source".equals(parameterName) ) {
    	this.fSource = (hu.bme.mit.transima.Simulink.Block) newValue;
    	return true;
    }
    return false;
    
  }
  
  public void setThis(final Block pThis) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fThis = pThis;
    
  }
  
  public void setSource(final Block pSource) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fSource = pSource;
    
  }
  
  public String patternName() {
    return "hu.bme.mit.transima.models.simulink.derived.sourceBlock";
    
  }
  
  public List<String> parameterNames() {
    return SourceBlockMatch.parameterNames;
    
  }
  
  public Object[] toArray() {
    return new Object[]{fThis, fSource};
    
  }
  
  public SourceBlockMatch toImmutable() {
    return isMutable() ? newMatch(fThis, fSource) : this;
    
  }
  
  public String prettyPrint() {
    StringBuilder result = new StringBuilder();
    result.append("\"This\"=" + prettyPrintValue(fThis) + ", ");
    result.append("\"Source\"=" + prettyPrintValue(fSource));
    return result.toString();
    
  }
  
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((fThis == null) ? 0 : fThis.hashCode());
    result = prime * result + ((fSource == null) ? 0 : fSource.hashCode());
    return result;
    
  }
  
  public boolean equals(final Object obj) {
    if (this == obj)
    	return true;
    if (!(obj instanceof SourceBlockMatch)) { // this should be infrequent
    	if (obj == null)
    		return false;
    	if (!(obj instanceof IPatternMatch))
    		return false;
    	IPatternMatch otherSig  = (IPatternMatch) obj;
    	if (!specification().equals(otherSig.specification()))
    		return false;
    	return Arrays.deepEquals(toArray(), otherSig.toArray());
    }
    SourceBlockMatch other = (SourceBlockMatch) obj;
    if (fThis == null) {if (other.fThis != null) return false;}
    else if (!fThis.equals(other.fThis)) return false;
    if (fSource == null) {if (other.fSource != null) return false;}
    else if (!fSource.equals(other.fSource)) return false;
    return true;
  }
  
  public SourceBlockQuerySpecification specification() {
    try {
    	return SourceBlockQuerySpecification.instance();
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
  public static SourceBlockMatch newEmptyMatch() {
    return new Mutable(null, null);
    
  }
  
  /**
   * Returns a mutable (partial) match.
   * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
   * 
   * @param pThis the fixed value of pattern parameter This, or null if not bound.
   * @param pSource the fixed value of pattern parameter Source, or null if not bound.
   * @return the new, mutable (partial) match object.
   * 
   */
  public static SourceBlockMatch newMutableMatch(final Block pThis, final Block pSource) {
    return new Mutable(pThis, pSource);
    
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pThis the fixed value of pattern parameter This, or null if not bound.
   * @param pSource the fixed value of pattern parameter Source, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public static SourceBlockMatch newMatch(final Block pThis, final Block pSource) {
    return new Immutable(pThis, pSource);
    
  }
  
  private static final class Mutable extends SourceBlockMatch {
    Mutable(final Block pThis, final Block pSource) {
      super(pThis, pSource);
      
    }
    
    public boolean isMutable() {
      return true;
    }
  }
  
  private static final class Immutable extends SourceBlockMatch {
    Immutable(final Block pThis, final Block pSource) {
      super(pThis, pSource);
      
    }
    
    public boolean isMutable() {
      return false;
    }
  }
}
