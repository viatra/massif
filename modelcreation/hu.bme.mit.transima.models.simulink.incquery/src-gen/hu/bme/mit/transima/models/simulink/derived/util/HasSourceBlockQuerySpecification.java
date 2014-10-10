package hu.bme.mit.transima.models.simulink.derived.util;

import com.google.common.collect.Sets;
import hu.bme.mit.transima.models.simulink.derived.HasSourceBlockMatch;
import hu.bme.mit.transima.models.simulink.derived.HasSourceBlockMatcher;
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
 * A pattern-specific query specification that can instantiate HasSourceBlockMatcher in a type-safe way.
 * 
 * @see HasSourceBlockMatcher
 * @see HasSourceBlockMatch
 * 
 */
@SuppressWarnings("all")
public final class HasSourceBlockQuerySpecification extends BaseGeneratedQuerySpecification<HasSourceBlockMatcher> {
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static HasSourceBlockQuerySpecification instance() throws IncQueryException {
    return LazyHolder.INSTANCE;
    
  }
  
  protected HasSourceBlockMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return HasSourceBlockMatcher.on(engine);
  }
  
  public String getFullyQualifiedName() {
    return "hu.bme.mit.transima.models.simulink.derived.hasSourceBlock";
    
  }
  
  public List<String> getParameterNames() {
    return Arrays.asList("Bl");
  }
  
  public List<PParameter> getParameters() {
    return Arrays.asList(new PParameter("Bl", "hu.bme.mit.transima.Simulink.Block"));
  }
  
  public HasSourceBlockMatch newEmptyMatch() {
    return HasSourceBlockMatch.newEmptyMatch();
  }
  
  public HasSourceBlockMatch newMatch(final Object... parameters) {
    return HasSourceBlockMatch.newMatch((hu.bme.mit.transima.Simulink.Block) parameters[0]);
  }
  
  public Set<PBody> doGetContainedBodies() throws IncQueryException {
    Set<PBody> bodies = Sets.newLinkedHashSet();
    {
      PBody body = new PBody(this);
      PVariable var_Bl = body.getOrCreateVariableByName("Bl");
      PVariable var__Src = body.getOrCreateVariableByName("_Src");
      body.setExportedParameters(Arrays.<ExportedParameter>asList(
        new ExportedParameter(body, var_Bl, "Bl")
      ));
      
      new TypeBinary(body, CONTEXT, var_Bl, var__Src, getFeatureLiteral("http://hu.bme.mit.transima/simulink/1.0", "Block", "sourceBlock"), "http://hu.bme.mit.transima/simulink/1.0/Block.sourceBlock");
      bodies.add(body);
    }
    return bodies;
  }
  
  private static class LazyHolder {
    private final static HasSourceBlockQuerySpecification INSTANCE = make();
    
    public static HasSourceBlockQuerySpecification make() {
      return new HasSourceBlockQuerySpecification();					
      
    }
  }
}
