package hu.bme.mit.massif.models.simulink.derived.util;

import com.google.common.collect.Sets;
import hu.bme.mit.massif.models.simulink.derived.EnablerMatch;
import hu.bme.mit.massif.models.simulink.derived.EnablerMatcher;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import org.eclipse.incquery.runtime.api.IncQueryEngine;
import org.eclipse.incquery.runtime.api.impl.BaseGeneratedEMFPQuery;
import org.eclipse.incquery.runtime.api.impl.BaseGeneratedEMFQuerySpecification;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.incquery.runtime.matchers.psystem.PBody;
import org.eclipse.incquery.runtime.matchers.psystem.PVariable;
import org.eclipse.incquery.runtime.matchers.psystem.annotations.PAnnotation;
import org.eclipse.incquery.runtime.matchers.psystem.basicdeferred.ExportedParameter;
import org.eclipse.incquery.runtime.matchers.psystem.basicenumerables.TypeBinary;
import org.eclipse.incquery.runtime.matchers.psystem.basicenumerables.TypeUnary;
import org.eclipse.incquery.runtime.matchers.psystem.queries.PParameter;
import org.eclipse.incquery.runtime.matchers.psystem.queries.QueryInitializationException;

/**
 * A pattern-specific query specification that can instantiate EnablerMatcher in a type-safe way.
 * 
 * @see EnablerMatcher
 * @see EnablerMatch
 * 
 */
@SuppressWarnings("all")
public final class EnablerQuerySpecification extends BaseGeneratedEMFQuerySpecification<EnablerMatcher> {
  private EnablerQuerySpecification() {
    super(GeneratedPQuery.INSTANCE);
  }
  
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static EnablerQuerySpecification instance() throws IncQueryException {
    try{
    	return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
    	throw processInitializerError(err);
    }
  }
  
  @Override
  protected EnablerMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return EnablerMatcher.on(engine);
  }
  
  @Override
  public EnablerMatch newEmptyMatch() {
    return EnablerMatch.newEmptyMatch();
  }
  
  @Override
  public EnablerMatch newMatch(final Object... parameters) {
    return EnablerMatch.newMatch((hu.bme.mit.massif.simulink.Block) parameters[0], (hu.bme.mit.massif.simulink.Enable) parameters[1]);
  }
  
  private static class LazyHolder {
    private final static EnablerQuerySpecification INSTANCE = make();
    
    public static EnablerQuerySpecification make() {
      return new EnablerQuerySpecification();					
    }
  }
  
  private static class GeneratedPQuery extends BaseGeneratedEMFPQuery {
    private final static EnablerQuerySpecification.GeneratedPQuery INSTANCE = new GeneratedPQuery();
    
    @Override
    public String getFullyQualifiedName() {
      return "hu.bme.mit.massif.models.simulink.derived.enabler";
    }
    
    @Override
    public List<String> getParameterNames() {
      return Arrays.asList("Block","Enabler");
    }
    
    @Override
    public List<PParameter> getParameters() {
      return Arrays.asList(new PParameter("Block", "hu.bme.mit.massif.simulink.Block"),new PParameter("Enabler", "hu.bme.mit.massif.simulink.Enable"));
    }
    
    @Override
    public Set<PBody> doGetContainedBodies() throws QueryInitializationException {
      Set<PBody> bodies = Sets.newLinkedHashSet();
      try {
      {
      	PBody body = new PBody(this);
      	PVariable var_Block = body.getOrCreateVariableByName("Block");
      	PVariable var_Enabler = body.getOrCreateVariableByName("Enabler");
      	body.setExportedParameters(Arrays.<ExportedParameter>asList(
      		new ExportedParameter(body, var_Block, "Block"),
      				
      		new ExportedParameter(body, var_Enabler, "Enabler")
      	));
      	new TypeUnary(body, var_Enabler, getClassifierLiteral("http://hu.bme.mit.massif/simulink/1.0", "Enable"), "http://hu.bme.mit.massif/simulink/1.0/Enable");
      	new TypeBinary(body, CONTEXT, var_Block, var_Enabler, getFeatureLiteral("http://hu.bme.mit.massif/simulink/1.0", "Block", "ports"), "http://hu.bme.mit.massif/simulink/1.0/Block.ports");
      	bodies.add(body);
      }
      	{
      	PAnnotation annotation = new PAnnotation("QueryBasedFeature");
      	addAnnotation(annotation);
      }
      	// to silence compiler error
      	if (false) throw new IncQueryException("Never", "happens");
      } catch (IncQueryException ex) {
      	throw processDependencyException(ex);
      }
      return bodies;
    }
  }
}
