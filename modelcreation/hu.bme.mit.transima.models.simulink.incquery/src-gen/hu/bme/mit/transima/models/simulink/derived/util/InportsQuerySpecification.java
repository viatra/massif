package hu.bme.mit.transima.models.simulink.derived.util;

import com.google.common.collect.Sets;
import hu.bme.mit.transima.models.simulink.derived.InportsMatch;
import hu.bme.mit.transima.models.simulink.derived.InportsMatcher;
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
import org.eclipse.incquery.runtime.matchers.psystem.basicenumerables.TypeBinary;
import org.eclipse.incquery.runtime.matchers.psystem.basicenumerables.TypeUnary;
import org.eclipse.incquery.runtime.matchers.psystem.queries.PParameter;

/**
 * A pattern-specific query specification that can instantiate InportsMatcher in a type-safe way.
 * 
 * @see InportsMatcher
 * @see InportsMatch
 * 
 */
@SuppressWarnings("all")
public final class InportsQuerySpecification extends BaseGeneratedQuerySpecification<InportsMatcher> {
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static InportsQuerySpecification instance() throws IncQueryException {
    return LazyHolder.INSTANCE;
    
  }
  
  protected InportsMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return InportsMatcher.on(engine);
  }
  
  public String getFullyQualifiedName() {
    return "hu.bme.mit.transima.models.simulink.derived.inports";
    
  }
  
  public List<String> getParameterNames() {
    return Arrays.asList("Block","InPort");
  }
  
  public List<PParameter> getParameters() {
    return Arrays.asList(new PParameter("Block", "hu.bme.mit.transima.Simulink.Block"),new PParameter("InPort", "hu.bme.mit.transima.Simulink.InPort"));
  }
  
  public InportsMatch newEmptyMatch() {
    return InportsMatch.newEmptyMatch();
  }
  
  public InportsMatch newMatch(final Object... parameters) {
    return InportsMatch.newMatch((hu.bme.mit.transima.Simulink.Block) parameters[0], (hu.bme.mit.transima.Simulink.InPort) parameters[1]);
  }
  
  public Set<PBody> doGetContainedBodies() throws IncQueryException {
    Set<PBody> bodies = Sets.newLinkedHashSet();
    {
      PBody body = new PBody(this);
      PVariable var_Block = body.getOrCreateVariableByName("Block");
      PVariable var_InPort = body.getOrCreateVariableByName("InPort");
      body.setExportedParameters(Arrays.<ExportedParameter>asList(
        new ExportedParameter(body, var_Block, "Block"), 
        new ExportedParameter(body, var_InPort, "InPort")
      ));
      
      
      new TypeUnary(body, var_InPort, getClassifierLiteral("http://hu.bme.mit.transima/simulink/1.0", "InPort"), "http://hu.bme.mit.transima/simulink/1.0/InPort");
      new TypeBinary(body, CONTEXT, var_Block, var_InPort, getFeatureLiteral("http://hu.bme.mit.transima/simulink/1.0", "Block", "ports"), "http://hu.bme.mit.transima/simulink/1.0/Block.ports");
      bodies.add(body);
    }
    {
      PAnnotation annotation = new PAnnotation("QueryBasedFeature");
      addAnnotation(annotation);
    }
    return bodies;
  }
  
  private static class LazyHolder {
    private final static InportsQuerySpecification INSTANCE = make();
    
    public static InportsQuerySpecification make() {
      return new InportsQuerySpecification();					
      
    }
  }
}
