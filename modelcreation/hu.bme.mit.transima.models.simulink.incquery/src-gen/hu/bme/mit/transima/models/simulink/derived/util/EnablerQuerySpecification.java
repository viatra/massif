package hu.bme.mit.transima.models.simulink.derived.util;

import com.google.common.collect.Sets;
import hu.bme.mit.transima.models.simulink.derived.EnablerMatch;
import hu.bme.mit.transima.models.simulink.derived.EnablerMatcher;
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
 * A pattern-specific query specification that can instantiate EnablerMatcher in a type-safe way.
 * 
 * @see EnablerMatcher
 * @see EnablerMatch
 * 
 */
@SuppressWarnings("all")
public final class EnablerQuerySpecification extends BaseGeneratedQuerySpecification<EnablerMatcher> {
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static EnablerQuerySpecification instance() throws IncQueryException {
    return LazyHolder.INSTANCE;
    
  }
  
  protected EnablerMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return EnablerMatcher.on(engine);
  }
  
  public String getFullyQualifiedName() {
    return "hu.bme.mit.transima.models.simulink.derived.enabler";
    
  }
  
  public List<String> getParameterNames() {
    return Arrays.asList("Block","Enabler");
  }
  
  public List<PParameter> getParameters() {
    return Arrays.asList(new PParameter("Block", "hu.bme.mit.transima.Simulink.Block"),new PParameter("Enabler", "hu.bme.mit.transima.Simulink.Enable"));
  }
  
  public EnablerMatch newEmptyMatch() {
    return EnablerMatch.newEmptyMatch();
  }
  
  public EnablerMatch newMatch(final Object... parameters) {
    return EnablerMatch.newMatch((hu.bme.mit.transima.Simulink.Block) parameters[0], (hu.bme.mit.transima.Simulink.Enable) parameters[1]);
  }
  
  public Set<PBody> doGetContainedBodies() throws IncQueryException {
    Set<PBody> bodies = Sets.newLinkedHashSet();
    {
      PBody body = new PBody(this);
      PVariable var_Block = body.getOrCreateVariableByName("Block");
      PVariable var_Enabler = body.getOrCreateVariableByName("Enabler");
      body.setExportedParameters(Arrays.<ExportedParameter>asList(
        new ExportedParameter(body, var_Block, "Block"), 
        new ExportedParameter(body, var_Enabler, "Enabler")
      ));
      
      
      new TypeUnary(body, var_Enabler, getClassifierLiteral("http://hu.bme.mit.transima/simulink/1.0", "Enable"), "http://hu.bme.mit.transima/simulink/1.0/Enable");
      new TypeBinary(body, CONTEXT, var_Block, var_Enabler, getFeatureLiteral("http://hu.bme.mit.transima/simulink/1.0", "Block", "ports"), "http://hu.bme.mit.transima/simulink/1.0/Block.ports");
      bodies.add(body);
    }
    {
      PAnnotation annotation = new PAnnotation("QueryBasedFeature");
      addAnnotation(annotation);
    }
    return bodies;
  }
  
  private static class LazyHolder {
    private final static EnablerQuerySpecification INSTANCE = make();
    
    public static EnablerQuerySpecification make() {
      return new EnablerQuerySpecification();					
      
    }
  }
}
