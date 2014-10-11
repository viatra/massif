package hu.bme.mit.massif.models.simulink.util;

import hu.bme.mit.massif.models.simulink.util.util.ChildBlockNamesQuerySpecification;
import hu.bme.mit.massif.simulink.SimulinkElement;
import java.util.Arrays;
import java.util.List;
import org.eclipse.incquery.runtime.api.IPatternMatch;
import org.eclipse.incquery.runtime.api.impl.BasePatternMatch;
import org.eclipse.incquery.runtime.exception.IncQueryException;

/**
 * Pattern-specific match representation of the hu.bme.mit.massif.models.simulink.util.childBlockNames pattern,
 * to be used in conjunction with {@link ChildBlockNamesMatcher}.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters,
 * usable to represent a match of the pattern in the result of a query,
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see ChildBlockNamesMatcher
 * @see ChildBlockNamesProcessor
 * 
 */
@SuppressWarnings("all")
public abstract class ChildBlockNamesMatch extends BasePatternMatch {
  private SimulinkElement fElem;
  
  private SimulinkElement fChild;
  
  private String fName;
  
  private static List<String> parameterNames = makeImmutableList("elem", "child", "name");
  
  private ChildBlockNamesMatch(final SimulinkElement pElem, final SimulinkElement pChild, final String pName) {
    this.fElem = pElem;
    this.fChild = pChild;
    this.fName = pName;
    
  }
  
  @Override
  public Object get(final String parameterName) {
    if ("elem".equals(parameterName)) return this.fElem;
    if ("child".equals(parameterName)) return this.fChild;
    if ("name".equals(parameterName)) return this.fName;
    return null;
    
  }
  
  public SimulinkElement getElem() {
    return this.fElem;
    
  }
  
  public SimulinkElement getChild() {
    return this.fChild;
    
  }
  
  public String getName() {
    return this.fName;
    
  }
  
  @Override
  public boolean set(final String parameterName, final Object newValue) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    if ("elem".equals(parameterName) ) {
    	this.fElem = (hu.bme.mit.massif.simulink.SimulinkElement) newValue;
    	return true;
    }
    if ("child".equals(parameterName) ) {
    	this.fChild = (hu.bme.mit.massif.simulink.SimulinkElement) newValue;
    	return true;
    }
    if ("name".equals(parameterName) ) {
    	this.fName = (java.lang.String) newValue;
    	return true;
    }
    return false;
    
  }
  
  public void setElem(final SimulinkElement pElem) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fElem = pElem;
    
  }
  
  public void setChild(final SimulinkElement pChild) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fChild = pChild;
    
  }
  
  public void setName(final String pName) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fName = pName;
    
  }
  
  @Override
  public String patternName() {
    return "hu.bme.mit.massif.models.simulink.util.childBlockNames";
    
  }
  
  @Override
  public List<String> parameterNames() {
    return ChildBlockNamesMatch.parameterNames;
    
  }
  
  @Override
  public Object[] toArray() {
    return new Object[]{fElem, fChild, fName};
    
  }
  
  @Override
  public ChildBlockNamesMatch toImmutable() {
    return isMutable() ? newMatch(fElem, fChild, fName) : this;
    
  }
  
  @Override
  public String prettyPrint() {
    StringBuilder result = new StringBuilder();
    result.append("\"elem\"=" + prettyPrintValue(fElem) + ", ");
    result.append("\"child\"=" + prettyPrintValue(fChild) + ", ");
    result.append("\"name\"=" + prettyPrintValue(fName));
    return result.toString();
    
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((fElem == null) ? 0 : fElem.hashCode());
    result = prime * result + ((fChild == null) ? 0 : fChild.hashCode());
    result = prime * result + ((fName == null) ? 0 : fName.hashCode());
    return result;
    
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
    	return true;
    if (!(obj instanceof ChildBlockNamesMatch)) { // this should be infrequent
    	if (obj == null)
    		return false;
    	if (!(obj instanceof IPatternMatch))
    		return false;
    	IPatternMatch otherSig  = (IPatternMatch) obj;
    	if (!specification().equals(otherSig.specification()))
    		return false;
    	return Arrays.deepEquals(toArray(), otherSig.toArray());
    }
    ChildBlockNamesMatch other = (ChildBlockNamesMatch) obj;
    if (fElem == null) {if (other.fElem != null) return false;}
    else if (!fElem.equals(other.fElem)) return false;
    if (fChild == null) {if (other.fChild != null) return false;}
    else if (!fChild.equals(other.fChild)) return false;
    if (fName == null) {if (other.fName != null) return false;}
    else if (!fName.equals(other.fName)) return false;
    return true;
  }
  
  @Override
  public ChildBlockNamesQuerySpecification specification() {
    try {
    	return ChildBlockNamesQuerySpecification.instance();
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
  public static ChildBlockNamesMatch newEmptyMatch() {
    return new Mutable(null, null, null);
    
  }
  
  /**
   * Returns a mutable (partial) match.
   * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
   * 
   * @param pElem the fixed value of pattern parameter elem, or null if not bound.
   * @param pChild the fixed value of pattern parameter child, or null if not bound.
   * @param pName the fixed value of pattern parameter name, or null if not bound.
   * @return the new, mutable (partial) match object.
   * 
   */
  public static ChildBlockNamesMatch newMutableMatch(final SimulinkElement pElem, final SimulinkElement pChild, final String pName) {
    return new Mutable(pElem, pChild, pName);
    
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pElem the fixed value of pattern parameter elem, or null if not bound.
   * @param pChild the fixed value of pattern parameter child, or null if not bound.
   * @param pName the fixed value of pattern parameter name, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public static ChildBlockNamesMatch newMatch(final SimulinkElement pElem, final SimulinkElement pChild, final String pName) {
    return new Immutable(pElem, pChild, pName);
    
  }
  
  private static final class Mutable extends ChildBlockNamesMatch {
    Mutable(final SimulinkElement pElem, final SimulinkElement pChild, final String pName) {
      super(pElem, pChild, pName);
      
    }
    
    @Override
    public boolean isMutable() {
      return true;
    }
  }
  
  private static final class Immutable extends ChildBlockNamesMatch {
    Immutable(final SimulinkElement pElem, final SimulinkElement pChild, final String pName) {
      super(pElem, pChild, pName);
      
    }
    
    @Override
    public boolean isMutable() {
      return false;
    }
  }
}
