package hu.bme.mit.massif.models.simulink.viewer.util;

import com.google.common.collect.Sets;
import hu.bme.mit.massif.models.simulink.viewer.BlockMatch;
import hu.bme.mit.massif.models.simulink.viewer.BlockMatcher;
import hu.bme.mit.massif.models.simulink.viewer.util.IgnoredBlockQuerySpecification;
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
import org.eclipse.incquery.runtime.matchers.psystem.basicdeferred.NegativePatternCall;
import org.eclipse.incquery.runtime.matchers.psystem.basicenumerables.TypeUnary;
import org.eclipse.incquery.runtime.matchers.psystem.queries.PParameter;
import org.eclipse.incquery.runtime.matchers.psystem.queries.QueryInitializationException;
import org.eclipse.incquery.runtime.matchers.tuple.FlatTuple;

/**
 * A pattern-specific query specification that can instantiate BlockMatcher in a type-safe way.
 * 
 * @see BlockMatcher
 * @see BlockMatch
 * 
 */
@SuppressWarnings("all")
public final class BlockQuerySpecification extends BaseGeneratedEMFQuerySpecification<BlockMatcher> {
  private BlockQuerySpecification() {
    super(GeneratedPQuery.INSTANCE);
  }
  
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static BlockQuerySpecification instance() throws IncQueryException {
    try{
    	return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
    	throw processInitializerError(err);
    }
  }
  
  @Override
  protected BlockMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return BlockMatcher.on(engine);
  }
  
  @Override
  public BlockMatch newEmptyMatch() {
    return BlockMatch.newEmptyMatch();
  }
  
  @Override
  public BlockMatch newMatch(final Object... parameters) {
    return BlockMatch.newMatch((hu.bme.mit.massif.simulink.Block) parameters[0]);
  }
  
  private static class LazyHolder {
    private final static BlockQuerySpecification INSTANCE = make();
    
    public static BlockQuerySpecification make() {
      return new BlockQuerySpecification();					
    }
  }
  
  private static class GeneratedPQuery extends BaseGeneratedEMFPQuery {
    private final static BlockQuerySpecification.GeneratedPQuery INSTANCE = new GeneratedPQuery();
    
    @Override
    public String getFullyQualifiedName() {
      return "hu.bme.mit.massif.models.simulink.viewer.block";
    }
    
    @Override
    public List<String> getParameterNames() {
      return Arrays.asList("bl");
    }
    
    @Override
    public List<PParameter> getParameters() {
      return Arrays.asList(new PParameter("bl", "hu.bme.mit.massif.simulink.Block"));
    }
    
    @Override
    public Set<PBody> doGetContainedBodies() throws QueryInitializationException {
      Set<PBody> bodies = Sets.newLinkedHashSet();
      try {
      {
      	PBody body = new PBody(this);
      	PVariable var_bl = body.getOrCreateVariableByName("bl");
      	body.setExportedParameters(Arrays.<ExportedParameter>asList(
      		new ExportedParameter(body, var_bl, "bl")
      	));
      	new TypeUnary(body, var_bl, getClassifierLiteral("http://hu.bme.mit.massif/simulink/1.0", "Block"), "http://hu.bme.mit.massif/simulink/1.0/Block");
      	new NegativePatternCall(body, new FlatTuple(var_bl), IgnoredBlockQuerySpecification.instance().getInternalQueryRepresentation());
      	bodies.add(body);
      }
      	{
      	PAnnotation annotation = new PAnnotation("Item");
      	annotation.addAttribute("item", new ParameterReference("bl"));
      	annotation.addAttribute("label", "$bl$");
      	addAnnotation(annotation);
      }
      {
      	PAnnotation annotation = new PAnnotation("Format");
      	annotation.addAttribute("textColor", "#191970");
      	annotation.addAttribute("color", "#F5F5F5");
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
