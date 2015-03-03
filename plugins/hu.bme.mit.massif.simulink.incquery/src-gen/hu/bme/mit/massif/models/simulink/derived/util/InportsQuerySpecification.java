package hu.bme.mit.massif.models.simulink.derived.util;

import com.google.common.collect.Sets;
import hu.bme.mit.massif.models.simulink.derived.InportsMatch;
import hu.bme.mit.massif.models.simulink.derived.InportsMatcher;
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
 * A pattern-specific query specification that can instantiate InportsMatcher in a type-safe way.
 * 
 * @see InportsMatcher
 * @see InportsMatch
 * 
 */
@SuppressWarnings("all")
public final class InportsQuerySpecification extends BaseGeneratedEMFQuerySpecification<InportsMatcher> {
  private InportsQuerySpecification() {
    super(GeneratedPQuery.INSTANCE);
  }
  
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static InportsQuerySpecification instance() throws IncQueryException {
    try{
    	return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
    	throw processInitializerError(err);
    }
  }
  
  @Override
  protected InportsMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return InportsMatcher.on(engine);
  }
  
  @Override
  public InportsMatch newEmptyMatch() {
    return InportsMatch.newEmptyMatch();
  }
  
  @Override
  public InportsMatch newMatch(final Object... parameters) {
    return InportsMatch.newMatch((hu.bme.mit.massif.simulink.Block) parameters[0], (hu.bme.mit.massif.simulink.InPort) parameters[1]);
  }
  
  private static class LazyHolder {
    private final static InportsQuerySpecification INSTANCE = make();
    
    public static InportsQuerySpecification make() {
      return new InportsQuerySpecification();					
    }
  }
  
  private static class GeneratedPQuery extends BaseGeneratedEMFPQuery {
    private final static InportsQuerySpecification.GeneratedPQuery INSTANCE = new GeneratedPQuery();
    
    @Override
    public String getFullyQualifiedName() {
      return "hu.bme.mit.massif.models.simulink.derived.inports";
    }
    
    @Override
    public List<String> getParameterNames() {
      return Arrays.asList("Block","InPort");
    }
    
    @Override
    public List<PParameter> getParameters() {
      return Arrays.asList(new PParameter("Block", "hu.bme.mit.massif.simulink.Block"),new PParameter("InPort", "hu.bme.mit.massif.simulink.InPort"));
    }
    
    @Override
    public Set<PBody> doGetContainedBodies() throws QueryInitializationException {
      Set<PBody> bodies = Sets.newLinkedHashSet();
      try {
      {
      	PBody body = new PBody(this);
      	PVariable var_Block = body.getOrCreateVariableByName("Block");
      	PVariable var_InPort = body.getOrCreateVariableByName("InPort");
      	body.setExportedParameters(Arrays.<ExportedParameter>asList(
      		new ExportedParameter(body, var_Block, "Block"),
      				
      		new ExportedParameter(body, var_InPort, "InPort")
      	));
      	new TypeUnary(body, var_InPort, getClassifierLiteral("http://hu.bme.mit.massif/simulink/1.0", "InPort"), "http://hu.bme.mit.massif/simulink/1.0/InPort");
      	new TypeBinary(body, CONTEXT, var_Block, var_InPort, getFeatureLiteral("http://hu.bme.mit.massif/simulink/1.0", "Block", "ports"), "http://hu.bme.mit.massif/simulink/1.0/Block.ports");
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
