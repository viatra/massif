package hu.bme.mit.transima.models.simulink.util.util;

import com.google.common.collect.Sets;
import hu.bme.mit.transima.models.simulink.util.ReferenceQualifierMatch;
import hu.bme.mit.transima.models.simulink.util.ReferenceQualifierMatcher;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import org.eclipse.incquery.runtime.api.IncQueryEngine;
import org.eclipse.incquery.runtime.api.impl.BaseGeneratedQuerySpecification;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.incquery.runtime.matchers.psystem.PBody;
import org.eclipse.incquery.runtime.matchers.psystem.PVariable;
import org.eclipse.incquery.runtime.matchers.psystem.basicdeferred.ExportedParameter;
import org.eclipse.incquery.runtime.matchers.psystem.basicenumerables.TypeBinary;
import org.eclipse.incquery.runtime.matchers.psystem.queries.PParameter;

/**
 * A pattern-specific query specification that can instantiate ReferenceQualifierMatcher in a type-safe way.
 * 
 * @see ReferenceQualifierMatcher
 * @see ReferenceQualifierMatch
 * 
 */
@SuppressWarnings("all")
public final class ReferenceQualifierQuerySpecification extends BaseGeneratedQuerySpecification<ReferenceQualifierMatcher> {
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static ReferenceQualifierQuerySpecification instance() throws IncQueryException {
    return LazyHolder.INSTANCE;
    
  }
  
  protected ReferenceQualifierMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return ReferenceQualifierMatcher.on(engine);
  }
  
  public String getFullyQualifiedName() {
    return "hu.bme.mit.transima.models.simulink.util.referenceQualifier";
    
  }
  
  public List<String> getParameterNames() {
    return Arrays.asList("SR","Qual");
  }
  
  public List<PParameter> getParameters() {
    return Arrays.asList(new PParameter("SR", "hu.bme.mit.transima.Simulink.SimulinkReference"),new PParameter("Qual", "java.lang.String"));
  }
  
  public ReferenceQualifierMatch newEmptyMatch() {
    return ReferenceQualifierMatch.newEmptyMatch();
  }
  
  public ReferenceQualifierMatch newMatch(final Object... parameters) {
    return ReferenceQualifierMatch.newMatch((hu.bme.mit.transima.Simulink.SimulinkReference) parameters[0], (java.lang.String) parameters[1]);
  }
  
  public Set<PBody> doGetContainedBodies() throws IncQueryException {
    Set<PBody> bodies = Sets.newLinkedHashSet();
    {
      PBody body = new PBody(this);
      PVariable var_SR = body.getOrCreateVariableByName("SR");
      PVariable var_Qual = body.getOrCreateVariableByName("Qual");
      body.setExportedParameters(Arrays.<ExportedParameter>asList(
        new ExportedParameter(body, var_SR, "SR"), 
        new ExportedParameter(body, var_Qual, "Qual")
      ));
      
      
      new TypeBinary(body, CONTEXT, var_SR, var_Qual, getFeatureLiteral("http://hu.bme.mit.transima/simulink/1.0", "SimulinkReference", "qualifier"), "http://hu.bme.mit.transima/simulink/1.0/SimulinkReference.qualifier");
      bodies.add(body);
    }
    return bodies;
  }
  
  private static class LazyHolder {
    private final static ReferenceQualifierQuerySpecification INSTANCE = make();
    
    public static ReferenceQualifierQuerySpecification make() {
      return new ReferenceQualifierQuerySpecification();					
      
    }
  }
}
