package hu.bme.mit.massif.models.simulink.derived.util;

import com.google.common.collect.Sets;
import hu.bme.mit.massif.models.simulink.derived.ReferencedModelMatch;
import hu.bme.mit.massif.models.simulink.derived.ReferencedModelMatcher;
import hu.bme.mit.massif.models.simulink.util.util.ReferenceEqualQuerySpecification;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import org.eclipse.incquery.runtime.api.IncQueryEngine;
import org.eclipse.incquery.runtime.api.impl.BaseGeneratedQuerySpecification;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.incquery.runtime.matchers.psystem.PBody;
import org.eclipse.incquery.runtime.matchers.psystem.PVariable;
import org.eclipse.incquery.runtime.matchers.psystem.annotations.PAnnotation;
import org.eclipse.incquery.runtime.matchers.psystem.basicdeferred.ExportedParameter;
import org.eclipse.incquery.runtime.matchers.psystem.basicenumerables.PositivePatternCall;
import org.eclipse.incquery.runtime.matchers.psystem.basicenumerables.TypeBinary;
import org.eclipse.incquery.runtime.matchers.psystem.basicenumerables.TypeUnary;
import org.eclipse.incquery.runtime.matchers.psystem.queries.PParameter;
import org.eclipse.incquery.runtime.matchers.tuple.FlatTuple;

/**
 * A pattern-specific query specification that can instantiate ReferencedModelMatcher in a type-safe way.
 * 
 * @see ReferencedModelMatcher
 * @see ReferencedModelMatch
 * 
 */
@SuppressWarnings("all")
public final class ReferencedModelQuerySpecification extends BaseGeneratedQuerySpecification<ReferencedModelMatcher> {
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static ReferencedModelQuerySpecification instance() throws IncQueryException {
    return LazyHolder.INSTANCE;
    
  }
  
  @Override
  protected ReferencedModelMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return ReferencedModelMatcher.on(engine);
  }
  
  @Override
  public String getFullyQualifiedName() {
    return "hu.bme.mit.massif.models.simulink.derived.referencedModel";
    
  }
  
  @Override
  public List<String> getParameterNames() {
    return Arrays.asList("This","Target");
  }
  
  @Override
  public List<PParameter> getParameters() {
    return Arrays.asList(new PParameter("This", "hu.bme.mit.massif.simulink.ModelReference"),new PParameter("Target", "hu.bme.mit.massif.simulink.SimulinkModel"));
  }
  
  @Override
  public ReferencedModelMatch newEmptyMatch() {
    return ReferencedModelMatch.newEmptyMatch();
  }
  
  @Override
  public ReferencedModelMatch newMatch(final Object... parameters) {
    return ReferencedModelMatch.newMatch((hu.bme.mit.massif.simulink.ModelReference) parameters[0], (hu.bme.mit.massif.simulink.SimulinkModel) parameters[1]);
  }
  
  @Override
  public Set<PBody> doGetContainedBodies() throws IncQueryException {
    Set<PBody> bodies = Sets.newLinkedHashSet();
    {
      PBody body = new PBody(this);
      PVariable var_This = body.getOrCreateVariableByName("This");
      PVariable var_Target = body.getOrCreateVariableByName("Target");
      PVariable var_ModelRef = body.getOrCreateVariableByName("ModelRef");
      PVariable var_SR = body.getOrCreateVariableByName("SR");
      body.setExportedParameters(Arrays.<ExportedParameter>asList(
        new ExportedParameter(body, var_This, "This"), 
        new ExportedParameter(body, var_Target, "Target")
      ));
      
      
      new TypeBinary(body, CONTEXT, var_This, var_ModelRef, getFeatureLiteral("http://hu.bme.mit.massif/simulink/1.0", "ModelReference", "modelRef"), "http://hu.bme.mit.massif/simulink/1.0/ModelReference.modelRef");
      new TypeUnary(body, var_Target, getClassifierLiteral("http://hu.bme.mit.massif/simulink/1.0", "SimulinkModel"), "http://hu.bme.mit.massif/simulink/1.0/SimulinkModel");
      new TypeBinary(body, CONTEXT, var_Target, var_SR, getFeatureLiteral("http://hu.bme.mit.massif/simulink/1.0", "SimulinkElement", "simulinkRef"), "http://hu.bme.mit.massif/simulink/1.0/SimulinkElement.simulinkRef");
      new PositivePatternCall(body, new FlatTuple(var_ModelRef, var_SR), ReferenceEqualQuerySpecification.instance());
      bodies.add(body);
    }
    {
      PAnnotation annotation = new PAnnotation("QueryBasedFeature");
      addAnnotation(annotation);
    }
    return bodies;
  }
  
  private static class LazyHolder {
    private final static ReferencedModelQuerySpecification INSTANCE = make();
    
    public static ReferencedModelQuerySpecification make() {
      return new ReferencedModelQuerySpecification();					
      
    }
  }
}
