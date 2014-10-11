package hu.bme.mit.transima.models.simulink.viewer.util;

import com.google.common.collect.Sets;
import hu.bme.mit.transima.models.simulink.viewer.BlockMatch;
import hu.bme.mit.transima.models.simulink.viewer.BlockMatcher;
import hu.bme.mit.transima.models.simulink.viewer.util.IgnoredBlockQuerySpecification;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import org.eclipse.incquery.runtime.api.IncQueryEngine;
import org.eclipse.incquery.runtime.api.impl.BaseGeneratedQuerySpecification;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.incquery.runtime.matchers.psystem.PBody;
import org.eclipse.incquery.runtime.matchers.psystem.PVariable;
import org.eclipse.incquery.runtime.matchers.psystem.annotations.PAnnotation;
import org.eclipse.incquery.runtime.matchers.psystem.annotations.ParameterReference;
import org.eclipse.incquery.runtime.matchers.psystem.basicdeferred.ExportedParameter;
import org.eclipse.incquery.runtime.matchers.psystem.basicdeferred.NegativePatternCall;
import org.eclipse.incquery.runtime.matchers.psystem.basicenumerables.TypeUnary;
import org.eclipse.incquery.runtime.matchers.psystem.queries.PParameter;
import org.eclipse.incquery.runtime.matchers.tuple.FlatTuple;

/**
 * A pattern-specific query specification that can instantiate BlockMatcher in a type-safe way.
 * 
 * @see BlockMatcher
 * @see BlockMatch
 * 
 */
@SuppressWarnings("all")
public final class BlockQuerySpecification extends BaseGeneratedQuerySpecification<BlockMatcher> {
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static BlockQuerySpecification instance() throws IncQueryException {
    return LazyHolder.INSTANCE;
    
  }
  
  @Override
  protected BlockMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return BlockMatcher.on(engine);
  }
  
  @Override
  public String getFullyQualifiedName() {
    return "hu.bme.mit.transima.models.simulink.viewer.block";
    
  }
  
  @Override
  public List<String> getParameterNames() {
    return Arrays.asList("bl");
  }
  
  @Override
  public List<PParameter> getParameters() {
    return Arrays.asList(new PParameter("bl", "hu.bme.mit.transima.Simulink.Block"));
  }
  
  @Override
  public BlockMatch newEmptyMatch() {
    return BlockMatch.newEmptyMatch();
  }
  
  @Override
  public BlockMatch newMatch(final Object... parameters) {
    return BlockMatch.newMatch((hu.bme.mit.transima.Simulink.Block) parameters[0]);
  }
  
  @Override
  public Set<PBody> doGetContainedBodies() throws IncQueryException {
    Set<PBody> bodies = Sets.newLinkedHashSet();
    {
      PBody body = new PBody(this);
      PVariable var_bl = body.getOrCreateVariableByName("bl");
      body.setExportedParameters(Arrays.<ExportedParameter>asList(
        new ExportedParameter(body, var_bl, "bl")
      ));
      
      new TypeUnary(body, var_bl, getClassifierLiteral("http://hu.bme.mit.transima/simulink/1.0", "Block"), "http://hu.bme.mit.transima/simulink/1.0/Block");
      new NegativePatternCall(body, new FlatTuple(var_bl), IgnoredBlockQuerySpecification.instance().instance());
      bodies.add(body);
    }
    {
      PAnnotation annotation = new PAnnotation("Item");
      annotation.addAttribute("item",new ParameterReference("bl"));
      annotation.addAttribute("label","$bl$");
      addAnnotation(annotation);
    }
    {
      PAnnotation annotation = new PAnnotation("Format");
      annotation.addAttribute("textColor","#191970");
      annotation.addAttribute("color","#F5F5F5");
      addAnnotation(annotation);
    }
    {
      PAnnotation annotation = new PAnnotation("QueryExplorer");
      annotation.addAttribute("display",true);
      addAnnotation(annotation);
    }
    return bodies;
  }
  
  private static class LazyHolder {
    private final static BlockQuerySpecification INSTANCE = make();
    
    public static BlockQuerySpecification make() {
      return new BlockQuerySpecification();					
      
    }
  }
}
