package hu.bme.mit.massif.models.simulink.viewer;

import hu.bme.mit.massif.models.simulink.viewer.util.SubBlocksQuerySpecification;
import hu.bme.mit.massif.simulink.Block;
import hu.bme.mit.massif.simulink.SubSystem;
import java.util.Arrays;
import java.util.List;
import org.eclipse.incquery.runtime.api.IPatternMatch;
import org.eclipse.incquery.runtime.api.impl.BasePatternMatch;
import org.eclipse.incquery.runtime.exception.IncQueryException;

/**
 * Pattern-specific match representation of the hu.bme.mit.massif.models.simulink.viewer.subBlocks pattern,
 * to be used in conjunction with {@link SubBlocksMatcher}.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters,
 * usable to represent a match of the pattern in the result of a query,
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see SubBlocksMatcher
 * @see SubBlocksProcessor
 * 
 */
@SuppressWarnings("all")
public abstract class SubBlocksMatch extends BasePatternMatch {
  private SubSystem fSubSys;
  
  private Block fBl;
  
  private static List<String> parameterNames = makeImmutableList("subSys", "bl");
  
  private SubBlocksMatch(final SubSystem pSubSys, final Block pBl) {
    this.fSubSys = pSubSys;
    this.fBl = pBl;
  }
  
  @Override
  public Object get(final String parameterName) {
    if ("subSys".equals(parameterName)) return this.fSubSys;
    if ("bl".equals(parameterName)) return this.fBl;
    return null;
  }
  
  public SubSystem getSubSys() {
    return this.fSubSys;
  }
  
  public Block getBl() {
    return this.fBl;
  }
  
  @Override
  public boolean set(final String parameterName, final Object newValue) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    if ("subSys".equals(parameterName) ) {
    	this.fSubSys = (hu.bme.mit.massif.simulink.SubSystem) newValue;
    	return true;
    }
    if ("bl".equals(parameterName) ) {
    	this.fBl = (hu.bme.mit.massif.simulink.Block) newValue;
    	return true;
    }
    return false;
  }
  
  public void setSubSys(final SubSystem pSubSys) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fSubSys = pSubSys;
  }
  
  public void setBl(final Block pBl) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fBl = pBl;
  }
  
  @Override
  public String patternName() {
    return "hu.bme.mit.massif.models.simulink.viewer.subBlocks";
  }
  
  @Override
  public List<String> parameterNames() {
    return SubBlocksMatch.parameterNames;
  }
  
  @Override
  public Object[] toArray() {
    return new Object[]{fSubSys, fBl};
  }
  
  @Override
  public SubBlocksMatch toImmutable() {
    return isMutable() ? newMatch(fSubSys, fBl) : this;
  }
  
  @Override
  public String prettyPrint() {
    StringBuilder result = new StringBuilder();
    result.append("\"subSys\"=" + prettyPrintValue(fSubSys) + ", ");
    
    result.append("\"bl\"=" + prettyPrintValue(fBl)
    );
    return result.toString();
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((fSubSys == null) ? 0 : fSubSys.hashCode());
    result = prime * result + ((fBl == null) ? 0 : fBl.hashCode());
    return result;
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
    	return true;
    if (!(obj instanceof SubBlocksMatch)) { // this should be infrequent
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
    SubBlocksMatch other = (SubBlocksMatch) obj;
    if (fSubSys == null) {if (other.fSubSys != null) return false;}
    else if (!fSubSys.equals(other.fSubSys)) return false;
    if (fBl == null) {if (other.fBl != null) return false;}
    else if (!fBl.equals(other.fBl)) return false;
    return true;
  }
  
  @Override
  public SubBlocksQuerySpecification specification() {
    try {
    	return SubBlocksQuerySpecification.instance();
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
  public static SubBlocksMatch newEmptyMatch() {
    return new Mutable(null, null);
  }
  
  /**
   * Returns a mutable (partial) match.
   * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
   * 
   * @param pSubSys the fixed value of pattern parameter subSys, or null if not bound.
   * @param pBl the fixed value of pattern parameter bl, or null if not bound.
   * @return the new, mutable (partial) match object.
   * 
   */
  public static SubBlocksMatch newMutableMatch(final SubSystem pSubSys, final Block pBl) {
    return new Mutable(pSubSys, pBl);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pSubSys the fixed value of pattern parameter subSys, or null if not bound.
   * @param pBl the fixed value of pattern parameter bl, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public static SubBlocksMatch newMatch(final SubSystem pSubSys, final Block pBl) {
    return new Immutable(pSubSys, pBl);
  }
  
  private static final class Mutable extends SubBlocksMatch {
    Mutable(final SubSystem pSubSys, final Block pBl) {
      super(pSubSys, pBl);
    }
    
    @Override
    public boolean isMutable() {
      return true;
    }
  }
  
  private static final class Immutable extends SubBlocksMatch {
    Immutable(final SubSystem pSubSys, final Block pBl) {
      super(pSubSys, pBl);
    }
    
    @Override
    public boolean isMutable() {
      return false;
    }
  }
}
