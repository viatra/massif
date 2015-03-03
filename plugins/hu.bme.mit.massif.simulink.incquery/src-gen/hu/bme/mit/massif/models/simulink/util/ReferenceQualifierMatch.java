package hu.bme.mit.massif.models.simulink.util;

import hu.bme.mit.massif.models.simulink.util.util.ReferenceQualifierQuerySpecification;
import hu.bme.mit.massif.simulink.SimulinkReference;
import java.util.Arrays;
import java.util.List;
import org.eclipse.incquery.runtime.api.IPatternMatch;
import org.eclipse.incquery.runtime.api.impl.BasePatternMatch;
import org.eclipse.incquery.runtime.exception.IncQueryException;

/**
 * Pattern-specific match representation of the hu.bme.mit.massif.models.simulink.util.referenceQualifier pattern,
 * to be used in conjunction with {@link ReferenceQualifierMatcher}.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters,
 * usable to represent a match of the pattern in the result of a query,
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see ReferenceQualifierMatcher
 * @see ReferenceQualifierProcessor
 * 
 */
@SuppressWarnings("all")
public abstract class ReferenceQualifierMatch extends BasePatternMatch {
  private SimulinkReference fSR;
  
  private String fQual;
  
  private static List<String> parameterNames = makeImmutableList("SR", "Qual");
  
  private ReferenceQualifierMatch(final SimulinkReference pSR, final String pQual) {
    this.fSR = pSR;
    this.fQual = pQual;
  }
  
  @Override
  public Object get(final String parameterName) {
    if ("SR".equals(parameterName)) return this.fSR;
    if ("Qual".equals(parameterName)) return this.fQual;
    return null;
  }
  
  public SimulinkReference getSR() {
    return this.fSR;
  }
  
  public String getQual() {
    return this.fQual;
  }
  
  @Override
  public boolean set(final String parameterName, final Object newValue) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    if ("SR".equals(parameterName) ) {
    	this.fSR = (hu.bme.mit.massif.simulink.SimulinkReference) newValue;
    	return true;
    }
    if ("Qual".equals(parameterName) ) {
    	this.fQual = (java.lang.String) newValue;
    	return true;
    }
    return false;
  }
  
  public void setSR(final SimulinkReference pSR) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fSR = pSR;
  }
  
  public void setQual(final String pQual) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fQual = pQual;
  }
  
  @Override
  public String patternName() {
    return "hu.bme.mit.massif.models.simulink.util.referenceQualifier";
  }
  
  @Override
  public List<String> parameterNames() {
    return ReferenceQualifierMatch.parameterNames;
  }
  
  @Override
  public Object[] toArray() {
    return new Object[]{fSR, fQual};
  }
  
  @Override
  public ReferenceQualifierMatch toImmutable() {
    return isMutable() ? newMatch(fSR, fQual) : this;
  }
  
  @Override
  public String prettyPrint() {
    StringBuilder result = new StringBuilder();
    result.append("\"SR\"=" + prettyPrintValue(fSR) + ", ");
    
    result.append("\"Qual\"=" + prettyPrintValue(fQual)
    );
    return result.toString();
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((fSR == null) ? 0 : fSR.hashCode());
    result = prime * result + ((fQual == null) ? 0 : fQual.hashCode());
    return result;
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
    	return true;
    if (!(obj instanceof ReferenceQualifierMatch)) { // this should be infrequent
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
    ReferenceQualifierMatch other = (ReferenceQualifierMatch) obj;
    if (fSR == null) {if (other.fSR != null) return false;}
    else if (!fSR.equals(other.fSR)) return false;
    if (fQual == null) {if (other.fQual != null) return false;}
    else if (!fQual.equals(other.fQual)) return false;
    return true;
  }
  
  @Override
  public ReferenceQualifierQuerySpecification specification() {
    try {
    	return ReferenceQualifierQuerySpecification.instance();
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
  public static ReferenceQualifierMatch newEmptyMatch() {
    return new Mutable(null, null);
  }
  
  /**
   * Returns a mutable (partial) match.
   * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
   * 
   * @param pSR the fixed value of pattern parameter SR, or null if not bound.
   * @param pQual the fixed value of pattern parameter Qual, or null if not bound.
   * @return the new, mutable (partial) match object.
   * 
   */
  public static ReferenceQualifierMatch newMutableMatch(final SimulinkReference pSR, final String pQual) {
    return new Mutable(pSR, pQual);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pSR the fixed value of pattern parameter SR, or null if not bound.
   * @param pQual the fixed value of pattern parameter Qual, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public static ReferenceQualifierMatch newMatch(final SimulinkReference pSR, final String pQual) {
    return new Immutable(pSR, pQual);
  }
  
  private static final class Mutable extends ReferenceQualifierMatch {
    Mutable(final SimulinkReference pSR, final String pQual) {
      super(pSR, pQual);
    }
    
    @Override
    public boolean isMutable() {
      return true;
    }
  }
  
  private static final class Immutable extends ReferenceQualifierMatch {
    Immutable(final SimulinkReference pSR, final String pQual) {
      super(pSR, pQual);
    }
    
    @Override
    public boolean isMutable() {
      return false;
    }
  }
}
