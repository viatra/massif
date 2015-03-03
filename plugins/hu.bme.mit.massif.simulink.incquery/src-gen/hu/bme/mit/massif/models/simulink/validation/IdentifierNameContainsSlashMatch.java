package hu.bme.mit.massif.models.simulink.validation;

import hu.bme.mit.massif.models.simulink.validation.util.IdentifierNameContainsSlashQuerySpecification;
import hu.bme.mit.massif.simulink.IdentifierReference;
import java.util.Arrays;
import java.util.List;
import org.eclipse.incquery.runtime.api.IPatternMatch;
import org.eclipse.incquery.runtime.api.impl.BasePatternMatch;
import org.eclipse.incquery.runtime.exception.IncQueryException;

/**
 * Pattern-specific match representation of the hu.bme.mit.massif.models.simulink.validation.identifierNameContainsSlash pattern,
 * to be used in conjunction with {@link IdentifierNameContainsSlashMatcher}.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters,
 * usable to represent a match of the pattern in the result of a query,
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see IdentifierNameContainsSlashMatcher
 * @see IdentifierNameContainsSlashProcessor
 * 
 */
@SuppressWarnings("all")
public abstract class IdentifierNameContainsSlashMatch extends BasePatternMatch {
  private IdentifierReference fId;
  
  private static List<String> parameterNames = makeImmutableList("id");
  
  private IdentifierNameContainsSlashMatch(final IdentifierReference pId) {
    this.fId = pId;
  }
  
  @Override
  public Object get(final String parameterName) {
    if ("id".equals(parameterName)) return this.fId;
    return null;
  }
  
  public IdentifierReference getId() {
    return this.fId;
  }
  
  @Override
  public boolean set(final String parameterName, final Object newValue) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    if ("id".equals(parameterName) ) {
    	this.fId = (hu.bme.mit.massif.simulink.IdentifierReference) newValue;
    	return true;
    }
    return false;
  }
  
  public void setId(final IdentifierReference pId) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fId = pId;
  }
  
  @Override
  public String patternName() {
    return "hu.bme.mit.massif.models.simulink.validation.identifierNameContainsSlash";
  }
  
  @Override
  public List<String> parameterNames() {
    return IdentifierNameContainsSlashMatch.parameterNames;
  }
  
  @Override
  public Object[] toArray() {
    return new Object[]{fId};
  }
  
  @Override
  public IdentifierNameContainsSlashMatch toImmutable() {
    return isMutable() ? newMatch(fId) : this;
  }
  
  @Override
  public String prettyPrint() {
    StringBuilder result = new StringBuilder();
    result.append("\"id\"=" + prettyPrintValue(fId)
    );
    return result.toString();
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((fId == null) ? 0 : fId.hashCode());
    return result;
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
    	return true;
    if (!(obj instanceof IdentifierNameContainsSlashMatch)) { // this should be infrequent
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
    IdentifierNameContainsSlashMatch other = (IdentifierNameContainsSlashMatch) obj;
    if (fId == null) {if (other.fId != null) return false;}
    else if (!fId.equals(other.fId)) return false;
    return true;
  }
  
  @Override
  public IdentifierNameContainsSlashQuerySpecification specification() {
    try {
    	return IdentifierNameContainsSlashQuerySpecification.instance();
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
  public static IdentifierNameContainsSlashMatch newEmptyMatch() {
    return new Mutable(null);
  }
  
  /**
   * Returns a mutable (partial) match.
   * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
   * 
   * @param pId the fixed value of pattern parameter id, or null if not bound.
   * @return the new, mutable (partial) match object.
   * 
   */
  public static IdentifierNameContainsSlashMatch newMutableMatch(final IdentifierReference pId) {
    return new Mutable(pId);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pId the fixed value of pattern parameter id, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public static IdentifierNameContainsSlashMatch newMatch(final IdentifierReference pId) {
    return new Immutable(pId);
  }
  
  private static final class Mutable extends IdentifierNameContainsSlashMatch {
    Mutable(final IdentifierReference pId) {
      super(pId);
    }
    
    @Override
    public boolean isMutable() {
      return true;
    }
  }
  
  private static final class Immutable extends IdentifierNameContainsSlashMatch {
    Immutable(final IdentifierReference pId) {
      super(pId);
    }
    
    @Override
    public boolean isMutable() {
      return false;
    }
  }
}
