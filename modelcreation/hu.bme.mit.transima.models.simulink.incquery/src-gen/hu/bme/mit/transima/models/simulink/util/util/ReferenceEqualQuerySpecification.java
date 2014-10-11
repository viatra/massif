package hu.bme.mit.transima.models.simulink.util.util;

import com.google.common.collect.Sets;
import hu.bme.mit.transima.models.simulink.util.ReferenceEqualMatch;
import hu.bme.mit.transima.models.simulink.util.ReferenceEqualMatcher;
import hu.bme.mit.transima.models.simulink.util.util.ReferenceQualifierQuerySpecification;
import hu.bme.mit.transima.models.simulink.util.util.SimulinkReferenceQuerySpecification;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import org.eclipse.incquery.runtime.api.IncQueryEngine;
import org.eclipse.incquery.runtime.api.impl.BaseGeneratedQuerySpecification;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.incquery.runtime.matchers.psystem.PBody;
import org.eclipse.incquery.runtime.matchers.psystem.PVariable;
import org.eclipse.incquery.runtime.matchers.psystem.basicdeferred.ExportedParameter;
import org.eclipse.incquery.runtime.matchers.psystem.basicdeferred.NegativePatternCall;
import org.eclipse.incquery.runtime.matchers.psystem.basicenumerables.PositivePatternCall;
import org.eclipse.incquery.runtime.matchers.psystem.basicenumerables.TypeBinary;
import org.eclipse.incquery.runtime.matchers.psystem.basicenumerables.TypeUnary;
import org.eclipse.incquery.runtime.matchers.psystem.queries.PParameter;
import org.eclipse.incquery.runtime.matchers.tuple.FlatTuple;

/**
 * A pattern-specific query specification that can instantiate ReferenceEqualMatcher in a type-safe way.
 * 
 * @see ReferenceEqualMatcher
 * @see ReferenceEqualMatch
 * 
 */
@SuppressWarnings("all")
public final class ReferenceEqualQuerySpecification extends BaseGeneratedQuerySpecification<ReferenceEqualMatcher> {
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static ReferenceEqualQuerySpecification instance() throws IncQueryException {
    return LazyHolder.INSTANCE;
    
  }
  
  @Override
  protected ReferenceEqualMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return ReferenceEqualMatcher.on(engine);
  }
  
  @Override
  public String getFullyQualifiedName() {
    return "hu.bme.mit.transima.models.simulink.util.referenceEqual";
    
  }
  
  @Override
  public List<String> getParameterNames() {
    return Arrays.asList("sourceRef","targetRef");
  }
  
  @Override
  public List<PParameter> getParameters() {
    return Arrays.asList(new PParameter("sourceRef", "hu.bme.mit.transima.Simulink.SimulinkReference"),new PParameter("targetRef", "hu.bme.mit.transima.Simulink.SimulinkReference"));
  }
  
  @Override
  public ReferenceEqualMatch newEmptyMatch() {
    return ReferenceEqualMatch.newEmptyMatch();
  }
  
  @Override
  public ReferenceEqualMatch newMatch(final Object... parameters) {
    return ReferenceEqualMatch.newMatch((hu.bme.mit.transima.Simulink.SimulinkReference) parameters[0], (hu.bme.mit.transima.Simulink.SimulinkReference) parameters[1]);
  }
  
  @Override
  public Set<PBody> doGetContainedBodies() throws IncQueryException {
    Set<PBody> bodies = Sets.newLinkedHashSet();
    {
      PBody body = new PBody(this);
      PVariable var_sourceRef = body.getOrCreateVariableByName("sourceRef");
      PVariable var_targetRef = body.getOrCreateVariableByName("targetRef");
      PVariable var_Name = body.getOrCreateVariableByName("Name");
      PVariable var_Qual = body.getOrCreateVariableByName("Qual");
      body.setExportedParameters(Arrays.<ExportedParameter>asList(
        new ExportedParameter(body, var_sourceRef, "sourceRef"), 
        new ExportedParameter(body, var_targetRef, "targetRef")
      ));
      
      new TypeUnary(body, var_sourceRef, getClassifierLiteral("http://hu.bme.mit.transima/simulink/1.0", "SimulinkReference"), "http://hu.bme.mit.transima/simulink/1.0/SimulinkReference");
      
      new TypeUnary(body, var_targetRef, getClassifierLiteral("http://hu.bme.mit.transima/simulink/1.0", "SimulinkReference"), "http://hu.bme.mit.transima/simulink/1.0/SimulinkReference");
      new PositivePatternCall(body, new FlatTuple(var_sourceRef, var_Name, var_Qual), SimulinkReferenceQuerySpecification.instance());
      new PositivePatternCall(body, new FlatTuple(var_targetRef, var_Name, var_Qual), SimulinkReferenceQuerySpecification.instance());
      bodies.add(body);
    }
    {
      PBody body = new PBody(this);
      PVariable var_sourceRef = body.getOrCreateVariableByName("sourceRef");
      PVariable var_targetRef = body.getOrCreateVariableByName("targetRef");
      PVariable var_Name = body.getOrCreateVariableByName("Name");
      PVariable var__squal = body.getOrCreateVariableByName("_squal");
      PVariable var__tqual = body.getOrCreateVariableByName("_tqual");
      body.setExportedParameters(Arrays.<ExportedParameter>asList(
        new ExportedParameter(body, var_sourceRef, "sourceRef"), 
        new ExportedParameter(body, var_targetRef, "targetRef")
      ));
      
      
      new TypeBinary(body, CONTEXT, var_sourceRef, var_Name, getFeatureLiteral("http://hu.bme.mit.transima/simulink/1.0", "SimulinkReference", "name"), "http://hu.bme.mit.transima/simulink/1.0/SimulinkReference.name");
      new TypeBinary(body, CONTEXT, var_targetRef, var_Name, getFeatureLiteral("http://hu.bme.mit.transima/simulink/1.0", "SimulinkReference", "name"), "http://hu.bme.mit.transima/simulink/1.0/SimulinkReference.name");
      new NegativePatternCall(body, new FlatTuple(var_sourceRef, var__squal), ReferenceQualifierQuerySpecification.instance().instance());
      new NegativePatternCall(body, new FlatTuple(var_targetRef, var__tqual), ReferenceQualifierQuerySpecification.instance().instance());
      bodies.add(body);
    }
    return bodies;
  }
  
  private static class LazyHolder {
    private final static ReferenceEqualQuerySpecification INSTANCE = make();
    
    public static ReferenceEqualQuerySpecification make() {
      return new ReferenceEqualQuerySpecification();					
      
    }
  }
}
