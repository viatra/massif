package hu.bme.mit.transima.models.simulink.util.util;

import com.google.common.collect.Sets;
import hu.bme.mit.transima.models.simulink.util.SimulinkReferenceMatch;
import hu.bme.mit.transima.models.simulink.util.SimulinkReferenceMatcher;
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
 * A pattern-specific query specification that can instantiate SimulinkReferenceMatcher in a type-safe way.
 * 
 * @see SimulinkReferenceMatcher
 * @see SimulinkReferenceMatch
 * 
 */
@SuppressWarnings("all")
public final class SimulinkReferenceQuerySpecification extends BaseGeneratedQuerySpecification<SimulinkReferenceMatcher> {
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static SimulinkReferenceQuerySpecification instance() throws IncQueryException {
    return LazyHolder.INSTANCE;
    
  }
  
  @Override
  protected SimulinkReferenceMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return SimulinkReferenceMatcher.on(engine);
  }
  
  @Override
  public String getFullyQualifiedName() {
    return "hu.bme.mit.transima.models.simulink.util.simulinkReference";
    
  }
  
  @Override
  public List<String> getParameterNames() {
    return Arrays.asList("SR","Name","Qual");
  }
  
  @Override
  public List<PParameter> getParameters() {
    return Arrays.asList(new PParameter("SR", "hu.bme.mit.transima.Simulink.SimulinkReference"),new PParameter("Name", "java.lang.String"),new PParameter("Qual", "java.lang.String"));
  }
  
  @Override
  public SimulinkReferenceMatch newEmptyMatch() {
    return SimulinkReferenceMatch.newEmptyMatch();
  }
  
  @Override
  public SimulinkReferenceMatch newMatch(final Object... parameters) {
    return SimulinkReferenceMatch.newMatch((hu.bme.mit.transima.Simulink.SimulinkReference) parameters[0], (java.lang.String) parameters[1], (java.lang.String) parameters[2]);
  }
  
  @Override
  public Set<PBody> doGetContainedBodies() throws IncQueryException {
    Set<PBody> bodies = Sets.newLinkedHashSet();
    {
      PBody body = new PBody(this);
      PVariable var_SR = body.getOrCreateVariableByName("SR");
      PVariable var_Name = body.getOrCreateVariableByName("Name");
      PVariable var_Qual = body.getOrCreateVariableByName("Qual");
      body.setExportedParameters(Arrays.<ExportedParameter>asList(
        new ExportedParameter(body, var_SR, "SR"), 
        new ExportedParameter(body, var_Name, "Name"), 
        new ExportedParameter(body, var_Qual, "Qual")
      ));
      
      
      
      new TypeBinary(body, CONTEXT, var_SR, var_Name, getFeatureLiteral("http://hu.bme.mit.transima/simulink/1.0", "SimulinkReference", "name"), "http://hu.bme.mit.transima/simulink/1.0/SimulinkReference.name");
      new TypeBinary(body, CONTEXT, var_SR, var_Qual, getFeatureLiteral("http://hu.bme.mit.transima/simulink/1.0", "SimulinkReference", "qualifier"), "http://hu.bme.mit.transima/simulink/1.0/SimulinkReference.qualifier");
      bodies.add(body);
    }
    return bodies;
  }
  
  private static class LazyHolder {
    private final static SimulinkReferenceQuerySpecification INSTANCE = make();
    
    public static SimulinkReferenceQuerySpecification make() {
      return new SimulinkReferenceQuerySpecification();					
      
    }
  }
}
