package hu.bme.mit.massif.models.simulink.viewer.util;

import com.google.common.collect.Sets;
import hu.bme.mit.massif.models.simulink.viewer.GotoBlocksMatch;
import hu.bme.mit.massif.models.simulink.viewer.GotoBlocksMatcher;
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
import org.eclipse.incquery.runtime.matchers.psystem.basicenumerables.TypeUnary;
import org.eclipse.incquery.runtime.matchers.psystem.queries.PParameter;

/**
 * A pattern-specific query specification that can instantiate GotoBlocksMatcher in a type-safe way.
 * 
 * @see GotoBlocksMatcher
 * @see GotoBlocksMatch
 * 
 */
@SuppressWarnings("all")
public final class GotoBlocksQuerySpecification extends BaseGeneratedQuerySpecification<GotoBlocksMatcher> {
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static GotoBlocksQuerySpecification instance() throws IncQueryException {
    return LazyHolder.INSTANCE;
    
  }
  
  @Override
  protected GotoBlocksMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return GotoBlocksMatcher.on(engine);
  }
  
  @Override
  public String getFullyQualifiedName() {
    return "hu.bme.mit.massif.models.simulink.viewer.gotoBlocks";
    
  }
  
  @Override
  public List<String> getParameterNames() {
    return Arrays.asList("bl");
  }
  
  @Override
  public List<PParameter> getParameters() {
    return Arrays.asList(new PParameter("bl", "hu.bme.mit.massif.simulink.Goto"));
  }
  
  @Override
  public GotoBlocksMatch newEmptyMatch() {
    return GotoBlocksMatch.newEmptyMatch();
  }
  
  @Override
  public GotoBlocksMatch newMatch(final Object... parameters) {
    return GotoBlocksMatch.newMatch((hu.bme.mit.massif.simulink.Goto) parameters[0]);
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
      
      new TypeUnary(body, var_bl, getClassifierLiteral("http://hu.bme.mit.massif/simulink/1.0", "Goto"), "http://hu.bme.mit.massif/simulink/1.0/Goto");
      bodies.add(body);
    }
    {
      PAnnotation annotation = new PAnnotation("Item");
      annotation.addAttribute("item",new ParameterReference("bl"));
      annotation.addAttribute("label","Goto");
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
    private final static GotoBlocksQuerySpecification INSTANCE = make();
    
    public static GotoBlocksQuerySpecification make() {
      return new GotoBlocksQuerySpecification();					
      
    }
  }
}
