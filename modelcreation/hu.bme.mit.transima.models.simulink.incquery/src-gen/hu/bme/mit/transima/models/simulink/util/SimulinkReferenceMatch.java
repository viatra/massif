package hu.bme.mit.transima.models.simulink.util;

import hu.bme.mit.transima.Simulink.SimulinkReference;
import hu.bme.mit.transima.models.simulink.util.util.SimulinkReferenceQuerySpecification;
import java.util.Arrays;
import java.util.List;
import org.eclipse.incquery.runtime.api.IPatternMatch;
import org.eclipse.incquery.runtime.api.impl.BasePatternMatch;
import org.eclipse.incquery.runtime.exception.IncQueryException;

/**
 * Pattern-specific match representation of the hu.bme.mit.transima.models.simulink.util.simulinkReference pattern,
 * to be used in conjunction with {@link SimulinkReferenceMatcher}.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters,
 * usable to represent a match of the pattern in the result of a query,
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see SimulinkReferenceMatcher
 * @see SimulinkReferenceProcessor
 * 
 */
@SuppressWarnings("all")
public abstract class SimulinkReferenceMatch extends BasePatternMatch {
  private SimulinkReference fSR;
  
  private String fName;
  
  private String fQual;
  
  private static List<String> parameterNames = makeImmutableList("SR", "Name", "Qual");
  
  private SimulinkReferenceMatch(final SimulinkReference pSR, final String pName, final String pQual) {
    this.fSR = pSR;
    this.fName = pName;
    this.fQual = pQual;
    
  }
  
  @Override
  public Object get(final String parameterName) {
    if ("SR".equals(parameterName)) return this.fSR;
    if ("Name".equals(parameterName)) return this.fName;
    if ("Qual".equals(parameterName)) return this.fQual;
    return null;
    
  }
  
  public SimulinkReference getSR() {
    return this.fSR;
    
  }
  
  public String getName() {
    return this.fName;
    
  }
  
  public String getQual() {
    return this.fQual;
    
  }
  
  @Override
  public boolean set(final String parameterName, final Object newValue) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    if ("SR".equals(parameterName) ) {
    	this.fSR = (hu.bme.mit.transima.Simulink.SimulinkReference) newValue;
    	return true;
    }
    if ("Name".equals(parameterName) ) {
    	this.fName = (java.lang.String) newValue;
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
  
  public void setName(final String pName) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fName = pName;
    
  }
  
  public void setQual(final String pQual) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fQual = pQual;
    
  }
  
  @Override
  public String patternName() {
    return "hu.bme.mit.transima.models.simulink.util.simulinkReference";
    
  }
  
  @Override
  public List<String> parameterNames() {
    return SimulinkReferenceMatch.parameterNames;
    
  }
  
  @Override
  public Object[] toArray() {
    return new Object[]{fSR, fName, fQual};
    
  }
  
  @Override
  public SimulinkReferenceMatch toImmutable() {
    return isMutable() ? newMatch(fSR, fName, fQual) : this;
    
  }
  
  @Override
  public String prettyPrint() {
    StringBuilder result = new StringBuilder();
    result.append("\"SR\"=" + prettyPrintValue(fSR) + ", ");
    result.append("\"Name\"=" + prettyPrintValue(fName) + ", ");
    result.append("\"Qual\"=" + prettyPrintValue(fQual));
    return result.toString();
    
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((fSR == null) ? 0 : fSR.hashCode());
    result = prime * result + ((fName == null) ? 0 : fName.hashCode());
    result = prime * result + ((fQual == null) ? 0 : fQual.hashCode());
    return result;
    
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
    	return true;
    if (!(obj instanceof SimulinkReferenceMatch)) { // this should be infrequent
    	if (obj == null)
    		return false;
    	if (!(obj instanceof IPatternMatch))
    		return false;
    	IPatternMatch otherSig  = (IPatternMatch) obj;
    	if (!specification().equals(otherSig.specification()))
    		return false;
    	return Arrays.deepEquals(toArray(), otherSig.toArray());
    }
    SimulinkReferenceMatch other = (SimulinkReferenceMatch) obj;
    if (fSR == null) {if (other.fSR != null) return false;}
    else if (!fSR.equals(other.fSR)) return false;
    if (fName == null) {if (other.fName != null) return false;}
    else if (!fName.equals(other.fName)) return false;
    if (fQual == null) {if (other.fQual != null) return false;}
    else if (!fQual.equals(other.fQual)) return false;
    return true;
  }
  
  @Override
  public SimulinkReferenceQuerySpecification specification() {
    try {
    	return SimulinkReferenceQuerySpecification.instance();
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
  public static SimulinkReferenceMatch newEmptyMatch() {
    return new Mutable(null, null, null);
    
  }
  
  /**
   * Returns a mutable (partial) match.
   * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
   * 
   * @param pSR the fixed value of pattern parameter SR, or null if not bound.
   * @param pName the fixed value of pattern parameter Name, or null if not bound.
   * @param pQual the fixed value of pattern parameter Qual, or null if not bound.
   * @return the new, mutable (partial) match object.
   * 
   */
  public static SimulinkReferenceMatch newMutableMatch(final SimulinkReference pSR, final String pName, final String pQual) {
    return new Mutable(pSR, pName, pQual);
    
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pSR the fixed value of pattern parameter SR, or null if not bound.
   * @param pName the fixed value of pattern parameter Name, or null if not bound.
   * @param pQual the fixed value of pattern parameter Qual, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public static SimulinkReferenceMatch newMatch(final SimulinkReference pSR, final String pName, final String pQual) {
    return new Immutable(pSR, pName, pQual);
    
  }
  
  private static final class Mutable extends SimulinkReferenceMatch {
    Mutable(final SimulinkReference pSR, final String pName, final String pQual) {
      super(pSR, pName, pQual);
      
    }
    
    @Override
    public boolean isMutable() {
      return true;
    }
  }
  
  private static final class Immutable extends SimulinkReferenceMatch {
    Immutable(final SimulinkReference pSR, final String pName, final String pQual) {
      super(pSR, pName, pQual);
      
    }
    
    @Override
    public boolean isMutable() {
      return false;
    }
  }
}
