package hu.bme.mit.transima.models.simulink.util;

import hu.bme.mit.transima.Simulink.SimulinkReference;
import hu.bme.mit.transima.models.simulink.util.util.ReferenceEqualQuerySpecification;
import java.util.Arrays;
import java.util.List;
import org.eclipse.incquery.runtime.api.IPatternMatch;
import org.eclipse.incquery.runtime.api.impl.BasePatternMatch;
import org.eclipse.incquery.runtime.exception.IncQueryException;

/**
 * Pattern-specific match representation of the hu.bme.mit.transima.models.simulink.util.referenceEqual pattern,
 * to be used in conjunction with {@link ReferenceEqualMatcher}.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters,
 * usable to represent a match of the pattern in the result of a query,
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see ReferenceEqualMatcher
 * @see ReferenceEqualProcessor
 * 
 */
@SuppressWarnings("all")
public abstract class ReferenceEqualMatch extends BasePatternMatch {
  private SimulinkReference fSourceRef;
  
  private SimulinkReference fTargetRef;
  
  private static List<String> parameterNames = makeImmutableList("sourceRef", "targetRef");
  
  private ReferenceEqualMatch(final SimulinkReference pSourceRef, final SimulinkReference pTargetRef) {
    this.fSourceRef = pSourceRef;
    this.fTargetRef = pTargetRef;
    
  }
  
  public Object get(final String parameterName) {
    if ("sourceRef".equals(parameterName)) return this.fSourceRef;
    if ("targetRef".equals(parameterName)) return this.fTargetRef;
    return null;
    
  }
  
  public SimulinkReference getSourceRef() {
    return this.fSourceRef;
    
  }
  
  public SimulinkReference getTargetRef() {
    return this.fTargetRef;
    
  }
  
  public boolean set(final String parameterName, final Object newValue) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    if ("sourceRef".equals(parameterName) ) {
    	this.fSourceRef = (hu.bme.mit.transima.Simulink.SimulinkReference) newValue;
    	return true;
    }
    if ("targetRef".equals(parameterName) ) {
    	this.fTargetRef = (hu.bme.mit.transima.Simulink.SimulinkReference) newValue;
    	return true;
    }
    return false;
    
  }
  
  public void setSourceRef(final SimulinkReference pSourceRef) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fSourceRef = pSourceRef;
    
  }
  
  public void setTargetRef(final SimulinkReference pTargetRef) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fTargetRef = pTargetRef;
    
  }
  
  public String patternName() {
    return "hu.bme.mit.transima.models.simulink.util.referenceEqual";
    
  }
  
  public List<String> parameterNames() {
    return ReferenceEqualMatch.parameterNames;
    
  }
  
  public Object[] toArray() {
    return new Object[]{fSourceRef, fTargetRef};
    
  }
  
  public ReferenceEqualMatch toImmutable() {
    return isMutable() ? newMatch(fSourceRef, fTargetRef) : this;
    
  }
  
  public String prettyPrint() {
    StringBuilder result = new StringBuilder();
    result.append("\"sourceRef\"=" + prettyPrintValue(fSourceRef) + ", ");
    result.append("\"targetRef\"=" + prettyPrintValue(fTargetRef));
    return result.toString();
    
  }
  
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((fSourceRef == null) ? 0 : fSourceRef.hashCode());
    result = prime * result + ((fTargetRef == null) ? 0 : fTargetRef.hashCode());
    return result;
    
  }
  
  public boolean equals(final Object obj) {
    if (this == obj)
    	return true;
    if (!(obj instanceof ReferenceEqualMatch)) { // this should be infrequent
    	if (obj == null)
    		return false;
    	if (!(obj instanceof IPatternMatch))
    		return false;
    	IPatternMatch otherSig  = (IPatternMatch) obj;
    	if (!specification().equals(otherSig.specification()))
    		return false;
    	return Arrays.deepEquals(toArray(), otherSig.toArray());
    }
    ReferenceEqualMatch other = (ReferenceEqualMatch) obj;
    if (fSourceRef == null) {if (other.fSourceRef != null) return false;}
    else if (!fSourceRef.equals(other.fSourceRef)) return false;
    if (fTargetRef == null) {if (other.fTargetRef != null) return false;}
    else if (!fTargetRef.equals(other.fTargetRef)) return false;
    return true;
  }
  
  public ReferenceEqualQuerySpecification specification() {
    try {
    	return ReferenceEqualQuerySpecification.instance();
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
  public static ReferenceEqualMatch newEmptyMatch() {
    return new Mutable(null, null);
    
  }
  
  /**
   * Returns a mutable (partial) match.
   * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
   * 
   * @param pSourceRef the fixed value of pattern parameter sourceRef, or null if not bound.
   * @param pTargetRef the fixed value of pattern parameter targetRef, or null if not bound.
   * @return the new, mutable (partial) match object.
   * 
   */
  public static ReferenceEqualMatch newMutableMatch(final SimulinkReference pSourceRef, final SimulinkReference pTargetRef) {
    return new Mutable(pSourceRef, pTargetRef);
    
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pSourceRef the fixed value of pattern parameter sourceRef, or null if not bound.
   * @param pTargetRef the fixed value of pattern parameter targetRef, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public static ReferenceEqualMatch newMatch(final SimulinkReference pSourceRef, final SimulinkReference pTargetRef) {
    return new Immutable(pSourceRef, pTargetRef);
    
  }
  
  private static final class Mutable extends ReferenceEqualMatch {
    Mutable(final SimulinkReference pSourceRef, final SimulinkReference pTargetRef) {
      super(pSourceRef, pTargetRef);
      
    }
    
    public boolean isMutable() {
      return true;
    }
  }
  
  private static final class Immutable extends ReferenceEqualMatch {
    Immutable(final SimulinkReference pSourceRef, final SimulinkReference pTargetRef) {
      super(pSourceRef, pTargetRef);
      
    }
    
    public boolean isMutable() {
      return false;
    }
  }
}
