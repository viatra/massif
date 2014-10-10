package hu.bme.mit.transima.models.simulink.viewer.util;

import com.google.common.collect.Sets;
import hu.bme.mit.transima.models.simulink.viewer.EmptySubSystemMatch;
import hu.bme.mit.transima.models.simulink.viewer.EmptySubSystemMatcher;
import hu.bme.mit.transima.models.simulink.viewer.util.SubBlocksQuerySpecification;
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
 * A pattern-specific query specification that can instantiate EmptySubSystemMatcher in a type-safe way.
 * 
 * @see EmptySubSystemMatcher
 * @see EmptySubSystemMatch
 * 
 */
@SuppressWarnings("all")
public final class EmptySubSystemQuerySpecification extends BaseGeneratedQuerySpecification<EmptySubSystemMatcher> {
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static EmptySubSystemQuerySpecification instance() throws IncQueryException {
    return LazyHolder.INSTANCE;
    
  }
  
  protected EmptySubSystemMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return EmptySubSystemMatcher.on(engine);
  }
  
  public String getFullyQualifiedName() {
    return "hu.bme.mit.transima.models.simulink.viewer.emptySubSystem";
    
  }
  
  public List<String> getParameterNames() {
    return Arrays.asList("subS");
  }
  
  public List<PParameter> getParameters() {
    return Arrays.asList(new PParameter("subS", "hu.bme.mit.transima.Simulink.SubSystem"));
  }
  
  public EmptySubSystemMatch newEmptyMatch() {
    return EmptySubSystemMatch.newEmptyMatch();
  }
  
  public EmptySubSystemMatch newMatch(final Object... parameters) {
    return EmptySubSystemMatch.newMatch((hu.bme.mit.transima.Simulink.SubSystem) parameters[0]);
  }
  
  public Set<PBody> doGetContainedBodies() throws IncQueryException {
    Set<PBody> bodies = Sets.newLinkedHashSet();
    {
      PBody body = new PBody(this);
      PVariable var_subS = body.getOrCreateVariableByName("subS");
      PVariable var__bl = body.getOrCreateVariableByName("_bl");
      body.setExportedParameters(Arrays.<ExportedParameter>asList(
        new ExportedParameter(body, var_subS, "subS")
      ));
      
      new TypeUnary(body, var_subS, getClassifierLiteral("http://hu.bme.mit.transima/simulink/1.0", "SubSystem"), "http://hu.bme.mit.transima/simulink/1.0/SubSystem");
      new NegativePatternCall(body, new FlatTuple(var_subS, var__bl), SubBlocksQuerySpecification.instance().instance());
      bodies.add(body);
    }
    {
      PAnnotation annotation = new PAnnotation("Item");
      annotation.addAttribute("item",new ParameterReference("subS"));
      annotation.addAttribute("label","$subS.tag$ $subS$");
      addAnnotation(annotation);
    }
    {
      PAnnotation annotation = new PAnnotation("Format");
      annotation.addAttribute("textColor","#000000");
      annotation.addAttribute("color","#F0FFFF");
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
    private final static EmptySubSystemQuerySpecification INSTANCE = make();
    
    public static EmptySubSystemQuerySpecification make() {
      return new EmptySubSystemQuerySpecification();					
      
    }
  }
}
