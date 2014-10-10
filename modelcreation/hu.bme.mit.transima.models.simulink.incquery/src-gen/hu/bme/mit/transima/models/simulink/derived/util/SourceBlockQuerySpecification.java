package hu.bme.mit.transima.models.simulink.derived.util;

import com.google.common.collect.Sets;
import hu.bme.mit.transima.models.simulink.derived.SourceBlockMatch;
import hu.bme.mit.transima.models.simulink.derived.SourceBlockMatcher;
import hu.bme.mit.transima.models.simulink.util.util.ReferenceEqualQuerySpecification;
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
 * A pattern-specific query specification that can instantiate SourceBlockMatcher in a type-safe way.
 * 
 * @see SourceBlockMatcher
 * @see SourceBlockMatch
 * 
 */
@SuppressWarnings("all")
public final class SourceBlockQuerySpecification extends BaseGeneratedQuerySpecification<SourceBlockMatcher> {
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static SourceBlockQuerySpecification instance() throws IncQueryException {
    return LazyHolder.INSTANCE;
    
  }
  
  protected SourceBlockMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return SourceBlockMatcher.on(engine);
  }
  
  public String getFullyQualifiedName() {
    return "hu.bme.mit.transima.models.simulink.derived.sourceBlock";
    
  }
  
  public List<String> getParameterNames() {
    return Arrays.asList("This","Source");
  }
  
  public List<PParameter> getParameters() {
    return Arrays.asList(new PParameter("This", "hu.bme.mit.transima.Simulink.Block"),new PParameter("Source", "hu.bme.mit.transima.Simulink.Block"));
  }
  
  public SourceBlockMatch newEmptyMatch() {
    return SourceBlockMatch.newEmptyMatch();
  }
  
  public SourceBlockMatch newMatch(final Object... parameters) {
    return SourceBlockMatch.newMatch((hu.bme.mit.transima.Simulink.Block) parameters[0], (hu.bme.mit.transima.Simulink.Block) parameters[1]);
  }
  
  public Set<PBody> doGetContainedBodies() throws IncQueryException {
    Set<PBody> bodies = Sets.newLinkedHashSet();
    {
      PBody body = new PBody(this);
      PVariable var_This = body.getOrCreateVariableByName("This");
      PVariable var_Source = body.getOrCreateVariableByName("Source");
      PVariable var_SrcRef = body.getOrCreateVariableByName("SrcRef");
      PVariable var_SR = body.getOrCreateVariableByName("SR");
      body.setExportedParameters(Arrays.<ExportedParameter>asList(
        new ExportedParameter(body, var_This, "This"), 
        new ExportedParameter(body, var_Source, "Source")
      ));
      
      
      new TypeBinary(body, CONTEXT, var_This, var_SrcRef, getFeatureLiteral("http://hu.bme.mit.transima/simulink/1.0", "Block", "sourceBlockRef"), "http://hu.bme.mit.transima/simulink/1.0/Block.sourceBlockRef");
      new TypeUnary(body, var_Source, getClassifierLiteral("http://hu.bme.mit.transima/simulink/1.0", "Block"), "http://hu.bme.mit.transima/simulink/1.0/Block");
      new TypeBinary(body, CONTEXT, var_Source, var_SR, getFeatureLiteral("http://hu.bme.mit.transima/simulink/1.0", "SimulinkElement", "simulinkRef"), "http://hu.bme.mit.transima/simulink/1.0/SimulinkElement.simulinkRef");
      new PositivePatternCall(body, new FlatTuple(var_SrcRef, var_SR), ReferenceEqualQuerySpecification.instance());
      bodies.add(body);
    }
    {
      PAnnotation annotation = new PAnnotation("QueryBasedFeature");
      addAnnotation(annotation);
    }
    return bodies;
  }
  
  private static class LazyHolder {
    private final static SourceBlockQuerySpecification INSTANCE = make();
    
    public static SourceBlockQuerySpecification make() {
      return new SourceBlockQuerySpecification();					
      
    }
  }
}
