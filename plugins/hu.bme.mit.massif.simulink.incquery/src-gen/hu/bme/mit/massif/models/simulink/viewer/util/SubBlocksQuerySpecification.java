package hu.bme.mit.massif.models.simulink.viewer.util;

import com.google.common.collect.Sets;
import hu.bme.mit.massif.models.simulink.viewer.SubBlocksMatch;
import hu.bme.mit.massif.models.simulink.viewer.SubBlocksMatcher;
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
import org.eclipse.incquery.runtime.matchers.psystem.annotations.ParameterReference;
import org.eclipse.incquery.runtime.matchers.psystem.basicdeferred.ExportedParameter;
import org.eclipse.incquery.runtime.matchers.psystem.basicenumerables.TypeBinary;
import org.eclipse.incquery.runtime.matchers.psystem.queries.PParameter;
import org.eclipse.incquery.runtime.matchers.psystem.queries.QueryInitializationException;

/**
 * A pattern-specific query specification that can instantiate SubBlocksMatcher in a type-safe way.
 * 
 * @see SubBlocksMatcher
 * @see SubBlocksMatch
 * 
 */
@SuppressWarnings("all")
public final class SubBlocksQuerySpecification extends BaseGeneratedEMFQuerySpecification<SubBlocksMatcher> {
  private SubBlocksQuerySpecification() {
    super(GeneratedPQuery.INSTANCE);
  }
  
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static SubBlocksQuerySpecification instance() throws IncQueryException {
    try{
    	return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
    	throw processInitializerError(err);
    }
  }
  
  @Override
  protected SubBlocksMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return SubBlocksMatcher.on(engine);
  }
  
  @Override
  public SubBlocksMatch newEmptyMatch() {
    return SubBlocksMatch.newEmptyMatch();
  }
  
  @Override
  public SubBlocksMatch newMatch(final Object... parameters) {
    return SubBlocksMatch.newMatch((hu.bme.mit.massif.simulink.SubSystem) parameters[0], (hu.bme.mit.massif.simulink.Block) parameters[1]);
  }
  
  private static class LazyHolder {
    private final static SubBlocksQuerySpecification INSTANCE = make();
    
    public static SubBlocksQuerySpecification make() {
      return new SubBlocksQuerySpecification();					
    }
  }
  
  private static class GeneratedPQuery extends BaseGeneratedEMFPQuery {
    private final static SubBlocksQuerySpecification.GeneratedPQuery INSTANCE = new GeneratedPQuery();
    
    @Override
    public String getFullyQualifiedName() {
      return "hu.bme.mit.massif.models.simulink.viewer.subBlocks";
    }
    
    @Override
    public List<String> getParameterNames() {
      return Arrays.asList("subSys","bl");
    }
    
    @Override
    public List<PParameter> getParameters() {
      return Arrays.asList(new PParameter("subSys", "hu.bme.mit.massif.simulink.SubSystem"),new PParameter("bl", "hu.bme.mit.massif.simulink.Block"));
    }
    
    @Override
    public Set<PBody> doGetContainedBodies() throws QueryInitializationException {
      Set<PBody> bodies = Sets.newLinkedHashSet();
      try {
      {
      	PBody body = new PBody(this);
      	PVariable var_subSys = body.getOrCreateVariableByName("subSys");
      	PVariable var_bl = body.getOrCreateVariableByName("bl");
      	body.setExportedParameters(Arrays.<ExportedParameter>asList(
      		new ExportedParameter(body, var_subSys, "subSys"),
      				
      		new ExportedParameter(body, var_bl, "bl")
      	));
      	new TypeBinary(body, CONTEXT, var_subSys, var_bl, getFeatureLiteral("http://hu.bme.mit.massif/simulink/1.0", "SubSystem", "subBlocks"), "http://hu.bme.mit.massif/simulink/1.0/SubSystem.subBlocks");
      	bodies.add(body);
      }
      	{
      	PAnnotation annotation = new PAnnotation("ContainsItem");
      	annotation.addAttribute("container", new ParameterReference("subSys"));
      	annotation.addAttribute("item", new ParameterReference("bl"));
      	addAnnotation(annotation);
      }
      {
      	PAnnotation annotation = new PAnnotation("QueryExplorer");
      	annotation.addAttribute("display", true);
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
