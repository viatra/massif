package hu.bme.mit.transima.models.simulink.viewer.util;

import com.google.common.collect.Sets;
import hu.bme.mit.transima.models.simulink.viewer.PortBlockMatch;
import hu.bme.mit.transima.models.simulink.viewer.PortBlockMatcher;
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
 * A pattern-specific query specification that can instantiate PortBlockMatcher in a type-safe way.
 * 
 * @see PortBlockMatcher
 * @see PortBlockMatch
 * 
 */
@SuppressWarnings("all")
public final class PortBlockQuerySpecification extends BaseGeneratedQuerySpecification<PortBlockMatcher> {
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static PortBlockQuerySpecification instance() throws IncQueryException {
    return LazyHolder.INSTANCE;
    
  }
  
  protected PortBlockMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return PortBlockMatcher.on(engine);
  }
  
  public String getFullyQualifiedName() {
    return "hu.bme.mit.transima.models.simulink.viewer.portBlock";
    
  }
  
  public List<String> getParameterNames() {
    return Arrays.asList("bl");
  }
  
  public List<PParameter> getParameters() {
    return Arrays.asList(new PParameter("bl", "hu.bme.mit.transima.Simulink.PortBlock"));
  }
  
  public PortBlockMatch newEmptyMatch() {
    return PortBlockMatch.newEmptyMatch();
  }
  
  public PortBlockMatch newMatch(final Object... parameters) {
    return PortBlockMatch.newMatch((hu.bme.mit.transima.Simulink.PortBlock) parameters[0]);
  }
  
  public Set<PBody> doGetContainedBodies() throws IncQueryException {
    Set<PBody> bodies = Sets.newLinkedHashSet();
    {
      PBody body = new PBody(this);
      PVariable var_bl = body.getOrCreateVariableByName("bl");
      body.setExportedParameters(Arrays.<ExportedParameter>asList(
        new ExportedParameter(body, var_bl, "bl")
      ));
      
      new TypeUnary(body, var_bl, getClassifierLiteral("http://hu.bme.mit.transima/simulink/1.0", "PortBlock"), "http://hu.bme.mit.transima/simulink/1.0/PortBlock");
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
      annotation.addAttribute("textColor","#FFFFFF");
      annotation.addAttribute("color","#191970");
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
    private final static PortBlockQuerySpecification INSTANCE = make();
    
    public static PortBlockQuerySpecification make() {
      return new PortBlockQuerySpecification();					
      
    }
  }
}
