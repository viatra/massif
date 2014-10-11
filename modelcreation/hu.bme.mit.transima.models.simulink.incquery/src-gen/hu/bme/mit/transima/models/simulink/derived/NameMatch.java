package hu.bme.mit.transima.models.simulink.derived;

import hu.bme.mit.transima.Simulink.SimulinkElement;
import hu.bme.mit.transima.models.simulink.derived.util.NameQuerySpecification;
import java.util.Arrays;
import java.util.List;
import org.eclipse.incquery.runtime.api.IPatternMatch;
import org.eclipse.incquery.runtime.api.impl.BasePatternMatch;
import org.eclipse.incquery.runtime.exception.IncQueryException;

/**
 * Pattern-specific match representation of the hu.bme.mit.transima.models.simulink.derived.name pattern,
 * to be used in conjunction with {@link NameMatcher}.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters,
 * usable to represent a match of the pattern in the result of a query,
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see NameMatcher
 * @see NameProcessor
 * 
 */
@SuppressWarnings("all")
public abstract class NameMatch extends BasePatternMatch {
  private SimulinkElement fSE;
  
  private String fName;
  
  private static List<String> parameterNames = makeImmutableList("SE", "Name");
  
  private NameMatch(final SimulinkElement pSE, final String pName) {
    this.fSE = pSE;
    this.fName = pName;
    
  }
  
  @Override
  public Object get(final String parameterName) {
    if ("SE".equals(parameterName)) return this.fSE;
    if ("Name".equals(parameterName)) return this.fName;
    return null;
    
  }
  
  public SimulinkElement getSE() {
    return this.fSE;
    
  }
  
  public String getName() {
    return this.fName;
    
  }
  
  @Override
  public boolean set(final String parameterName, final Object newValue) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    if ("SE".equals(parameterName) ) {
    	this.fSE = (hu.bme.mit.transima.Simulink.SimulinkElement) newValue;
    	return true;
    }
    if ("Name".equals(parameterName) ) {
    	this.fName = (java.lang.String) newValue;
    	return true;
    }
    return false;
    
  }
  
  public void setSE(final SimulinkElement pSE) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fSE = pSE;
    
  }
  
  public void setName(final String pName) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fName = pName;
    
  }
  
  @Override
  public String patternName() {
    return "hu.bme.mit.transima.models.simulink.derived.name";
    
  }
  
  @Override
  public List<String> parameterNames() {
    return NameMatch.parameterNames;
    
  }
  
  @Override
  public Object[] toArray() {
    return new Object[]{fSE, fName};
    
  }
  
  @Override
  public NameMatch toImmutable() {
    return isMutable() ? newMatch(fSE, fName) : this;
    
  }
  
  @Override
  public String prettyPrint() {
    StringBuilder result = new StringBuilder();
    result.append("\"SE\"=" + prettyPrintValue(fSE) + ", ");
    result.append("\"Name\"=" + prettyPrintValue(fName));
    return result.toString();
    
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((fSE == null) ? 0 : fSE.hashCode());
    result = prime * result + ((fName == null) ? 0 : fName.hashCode());
    return result;
    
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
    	return true;
    if (!(obj instanceof NameMatch)) { // this should be infrequent
    	if (obj == null)
    		return false;
    	if (!(obj instanceof IPatternMatch))
    		return false;
    	IPatternMatch otherSig  = (IPatternMatch) obj;
    	if (!specification().equals(otherSig.specification()))
    		return false;
    	return Arrays.deepEquals(toArray(), otherSig.toArray());
    }
    NameMatch other = (NameMatch) obj;
    if (fSE == null) {if (other.fSE != null) return false;}
    else if (!fSE.equals(other.fSE)) return false;
    if (fName == null) {if (other.fName != null) return false;}
    else if (!fName.equals(other.fName)) return false;
    return true;
  }
  
  @Override
  public NameQuerySpecification specification() {
    try {
    	return NameQuerySpecification.instance();
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
  public static NameMatch newEmptyMatch() {
    return new Mutable(null, null);
    
  }
  
  /**
   * Returns a mutable (partial) match.
   * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
   * 
   * @param pSE the fixed value of pattern parameter SE, or null if not bound.
   * @param pName the fixed value of pattern parameter Name, or null if not bound.
   * @return the new, mutable (partial) match object.
   * 
   */
  public static NameMatch newMutableMatch(final SimulinkElement pSE, final String pName) {
    return new Mutable(pSE, pName);
    
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pSE the fixed value of pattern parameter SE, or null if not bound.
   * @param pName the fixed value of pattern parameter Name, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public static NameMatch newMatch(final SimulinkElement pSE, final String pName) {
    return new Immutable(pSE, pName);
    
  }
  
  private static final class Mutable extends NameMatch {
    Mutable(final SimulinkElement pSE, final String pName) {
      super(pSE, pName);
      
    }
    
    @Override
    public boolean isMutable() {
      return true;
    }
  }
  
  private static final class Immutable extends NameMatch {
    Immutable(final SimulinkElement pSE, final String pName) {
      super(pSE, pName);
      
    }
    
    @Override
    public boolean isMutable() {
      return false;
    }
  }
}
