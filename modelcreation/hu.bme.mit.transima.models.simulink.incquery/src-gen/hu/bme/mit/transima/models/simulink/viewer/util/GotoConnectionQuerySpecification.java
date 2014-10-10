package hu.bme.mit.transima.models.simulink.viewer.util;

import com.google.common.collect.Sets;
import hu.bme.mit.transima.models.simulink.viewer.GotoConnectionMatch;
import hu.bme.mit.transima.models.simulink.viewer.GotoConnectionMatcher;
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
import org.eclipse.incquery.runtime.matchers.psystem.basicenumerables.TypeBinary;
import org.eclipse.incquery.runtime.matchers.psystem.queries.PParameter;

/**
 * A pattern-specific query specification that can instantiate GotoConnectionMatcher in a type-safe way.
 * 
 * @see GotoConnectionMatcher
 * @see GotoConnectionMatch
 * 
 */
@SuppressWarnings("all")
public final class GotoConnectionQuerySpecification extends BaseGeneratedQuerySpecification<GotoConnectionMatcher> {
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static GotoConnectionQuerySpecification instance() throws IncQueryException {
    return LazyHolder.INSTANCE;
    
  }
  
  protected GotoConnectionMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return GotoConnectionMatcher.on(engine);
  }
  
  public String getFullyQualifiedName() {
    return "hu.bme.mit.transima.models.simulink.viewer.gotoConnection";
    
  }
  
  public List<String> getParameterNames() {
    return Arrays.asList("from","to");
  }
  
  public List<PParameter> getParameters() {
    return Arrays.asList(new PParameter("from", "hu.bme.mit.transima.Simulink.Goto"),new PParameter("to", "hu.bme.mit.transima.Simulink.From"));
  }
  
  public GotoConnectionMatch newEmptyMatch() {
    return GotoConnectionMatch.newEmptyMatch();
  }
  
  public GotoConnectionMatch newMatch(final Object... parameters) {
    return GotoConnectionMatch.newMatch((hu.bme.mit.transima.Simulink.Goto) parameters[0], (hu.bme.mit.transima.Simulink.From) parameters[1]);
  }
  
  public Set<PBody> doGetContainedBodies() throws IncQueryException {
    Set<PBody> bodies = Sets.newLinkedHashSet();
    {
      PBody body = new PBody(this);
      PVariable var_from = body.getOrCreateVariableByName("from");
      PVariable var_to = body.getOrCreateVariableByName("to");
      body.setExportedParameters(Arrays.<ExportedParameter>asList(
        new ExportedParameter(body, var_from, "from"), 
        new ExportedParameter(body, var_to, "to")
      ));
      
      
      new TypeBinary(body, CONTEXT, var_from, var_to, getFeatureLiteral("http://hu.bme.mit.transima/simulink/1.0", "Goto", "fromBlocks"), "http://hu.bme.mit.transima/simulink/1.0/Goto.fromBlocks");
      bodies.add(body);
    }
    {
      PAnnotation annotation = new PAnnotation("Edge");
      annotation.addAttribute("source",new ParameterReference("from"));
      annotation.addAttribute("target",new ParameterReference("to"));
      annotation.addAttribute("label","goto");
      addAnnotation(annotation);
    }
    {
      PAnnotation annotation = new PAnnotation("Format");
      annotation.addAttribute("lineColor","#228B22");
      annotation.addAttribute("lineStyle","dashed");
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
    private final static GotoConnectionQuerySpecification INSTANCE = make();
    
    public static GotoConnectionQuerySpecification make() {
      return new GotoConnectionQuerySpecification();					
      
    }
  }
}
