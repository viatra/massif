package hu.bme.mit.transima.models.simulink.util;

import hu.bme.mit.transima.Simulink.Connection;
import hu.bme.mit.transima.models.simulink.util.util.LineNameQuerySpecification;
import java.util.Arrays;
import java.util.List;
import org.eclipse.incquery.runtime.api.IPatternMatch;
import org.eclipse.incquery.runtime.api.impl.BasePatternMatch;
import org.eclipse.incquery.runtime.exception.IncQueryException;

/**
 * Pattern-specific match representation of the hu.bme.mit.transima.models.simulink.util.lineName pattern,
 * to be used in conjunction with {@link LineNameMatcher}.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters,
 * usable to represent a match of the pattern in the result of a query,
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see LineNameMatcher
 * @see LineNameProcessor
 * 
 */
@SuppressWarnings("all")
public abstract class LineNameMatch extends BasePatternMatch {
  private Connection fConn;
  
  private String fName;
  
  private static List<String> parameterNames = makeImmutableList("conn", "name");
  
  private LineNameMatch(final Connection pConn, final String pName) {
    this.fConn = pConn;
    this.fName = pName;
    
  }
  
  public Object get(final String parameterName) {
    if ("conn".equals(parameterName)) return this.fConn;
    if ("name".equals(parameterName)) return this.fName;
    return null;
    
  }
  
  public Connection getConn() {
    return this.fConn;
    
  }
  
  public String getName() {
    return this.fName;
    
  }
  
  public boolean set(final String parameterName, final Object newValue) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    if ("conn".equals(parameterName) ) {
    	this.fConn = (hu.bme.mit.transima.Simulink.Connection) newValue;
    	return true;
    }
    if ("name".equals(parameterName) ) {
    	this.fName = (java.lang.String) newValue;
    	return true;
    }
    return false;
    
  }
  
  public void setConn(final Connection pConn) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fConn = pConn;
    
  }
  
  public void setName(final String pName) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fName = pName;
    
  }
  
  public String patternName() {
    return "hu.bme.mit.transima.models.simulink.util.lineName";
    
  }
  
  public List<String> parameterNames() {
    return LineNameMatch.parameterNames;
    
  }
  
  public Object[] toArray() {
    return new Object[]{fConn, fName};
    
  }
  
  public LineNameMatch toImmutable() {
    return isMutable() ? newMatch(fConn, fName) : this;
    
  }
  
  public String prettyPrint() {
    StringBuilder result = new StringBuilder();
    result.append("\"conn\"=" + prettyPrintValue(fConn) + ", ");
    result.append("\"name\"=" + prettyPrintValue(fName));
    return result.toString();
    
  }
  
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((fConn == null) ? 0 : fConn.hashCode());
    result = prime * result + ((fName == null) ? 0 : fName.hashCode());
    return result;
    
  }
  
  public boolean equals(final Object obj) {
    if (this == obj)
    	return true;
    if (!(obj instanceof LineNameMatch)) { // this should be infrequent
    	if (obj == null)
    		return false;
    	if (!(obj instanceof IPatternMatch))
    		return false;
    	IPatternMatch otherSig  = (IPatternMatch) obj;
    	if (!specification().equals(otherSig.specification()))
    		return false;
    	return Arrays.deepEquals(toArray(), otherSig.toArray());
    }
    LineNameMatch other = (LineNameMatch) obj;
    if (fConn == null) {if (other.fConn != null) return false;}
    else if (!fConn.equals(other.fConn)) return false;
    if (fName == null) {if (other.fName != null) return false;}
    else if (!fName.equals(other.fName)) return false;
    return true;
  }
  
  public LineNameQuerySpecification specification() {
    try {
    	return LineNameQuerySpecification.instance();
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
  public static LineNameMatch newEmptyMatch() {
    return new Mutable(null, null);
    
  }
  
  /**
   * Returns a mutable (partial) match.
   * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
   * 
   * @param pConn the fixed value of pattern parameter conn, or null if not bound.
   * @param pName the fixed value of pattern parameter name, or null if not bound.
   * @return the new, mutable (partial) match object.
   * 
   */
  public static LineNameMatch newMutableMatch(final Connection pConn, final String pName) {
    return new Mutable(pConn, pName);
    
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pConn the fixed value of pattern parameter conn, or null if not bound.
   * @param pName the fixed value of pattern parameter name, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public static LineNameMatch newMatch(final Connection pConn, final String pName) {
    return new Immutable(pConn, pName);
    
  }
  
  private static final class Mutable extends LineNameMatch {
    Mutable(final Connection pConn, final String pName) {
      super(pConn, pName);
      
    }
    
    public boolean isMutable() {
      return true;
    }
  }
  
  private static final class Immutable extends LineNameMatch {
    Immutable(final Connection pConn, final String pName) {
      super(pConn, pName);
      
    }
    
    public boolean isMutable() {
      return false;
    }
  }
}
