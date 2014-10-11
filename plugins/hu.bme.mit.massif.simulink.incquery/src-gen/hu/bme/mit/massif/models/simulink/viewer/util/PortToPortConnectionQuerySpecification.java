package hu.bme.mit.massif.models.simulink.viewer.util;

import com.google.common.collect.Sets;
import hu.bme.mit.massif.models.simulink.util.util.PortConnectionQuerySpecification;
import hu.bme.mit.massif.models.simulink.viewer.PortToPortConnectionMatch;
import hu.bme.mit.massif.models.simulink.viewer.PortToPortConnectionMatcher;
import hu.bme.mit.massif.models.simulink.viewer.util.NonNullLineNameQuerySpecification;
import hu.bme.mit.massif.models.simulink.viewer.util.PortOfSimpleBlockQuerySpecification;
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
import org.eclipse.incquery.runtime.matchers.psystem.basicenumerables.PositivePatternCall;
import org.eclipse.incquery.runtime.matchers.psystem.queries.PParameter;
import org.eclipse.incquery.runtime.matchers.tuple.FlatTuple;

/**
 * A pattern-specific query specification that can instantiate PortToPortConnectionMatcher in a type-safe way.
 * 
 * @see PortToPortConnectionMatcher
 * @see PortToPortConnectionMatch
 * 
 */
@SuppressWarnings("all")
public final class PortToPortConnectionQuerySpecification extends BaseGeneratedQuerySpecification<PortToPortConnectionMatcher> {
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static PortToPortConnectionQuerySpecification instance() throws IncQueryException {
    return LazyHolder.INSTANCE;
    
  }
  
  @Override
  protected PortToPortConnectionMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return PortToPortConnectionMatcher.on(engine);
  }
  
  @Override
  public String getFullyQualifiedName() {
    return "hu.bme.mit.massif.models.simulink.viewer.portToPortConnection";
    
  }
  
  @Override
  public List<String> getParameterNames() {
    return Arrays.asList("from","to","name");
  }
  
  @Override
  public List<PParameter> getParameters() {
    return Arrays.asList(new PParameter("from", "hu.bme.mit.massif.simulink.Block"),new PParameter("to", "hu.bme.mit.massif.simulink.Block"),new PParameter("name", "java.lang.String"));
  }
  
  @Override
  public PortToPortConnectionMatch newEmptyMatch() {
    return PortToPortConnectionMatch.newEmptyMatch();
  }
  
  @Override
  public PortToPortConnectionMatch newMatch(final Object... parameters) {
    return PortToPortConnectionMatch.newMatch((hu.bme.mit.massif.simulink.Block) parameters[0], (hu.bme.mit.massif.simulink.Block) parameters[1], (java.lang.String) parameters[2]);
  }
  
  @Override
  public Set<PBody> doGetContainedBodies() throws IncQueryException {
    Set<PBody> bodies = Sets.newLinkedHashSet();
    {
      PBody body = new PBody(this);
      PVariable var_from = body.getOrCreateVariableByName("from");
      PVariable var_to = body.getOrCreateVariableByName("to");
      PVariable var_name = body.getOrCreateVariableByName("name");
      PVariable var_outP = body.getOrCreateVariableByName("outP");
      PVariable var_inP = body.getOrCreateVariableByName("inP");
      PVariable var_firstPC = body.getOrCreateVariableByName("firstPC");
      body.setExportedParameters(Arrays.<ExportedParameter>asList(
        new ExportedParameter(body, var_from, "from"), 
        new ExportedParameter(body, var_to, "to"), 
        new ExportedParameter(body, var_name, "name")
      ));
      
      
      
      new PositivePatternCall(body, new FlatTuple(var_outP, var_from), PortOfSimpleBlockQuerySpecification.instance());
      new PositivePatternCall(body, new FlatTuple(var_outP, var_inP, var_firstPC), PortConnectionQuerySpecification.instance());
      new PositivePatternCall(body, new FlatTuple(var_firstPC, var_name), NonNullLineNameQuerySpecification.instance());
      new PositivePatternCall(body, new FlatTuple(var_inP, var_to), PortOfSimpleBlockQuerySpecification.instance());
      bodies.add(body);
    }
    {
      PAnnotation annotation = new PAnnotation("Edge");
      annotation.addAttribute("source",new ParameterReference("from"));
      annotation.addAttribute("target",new ParameterReference("to"));
      annotation.addAttribute("label","$name$");
      addAnnotation(annotation);
    }
    {
      PAnnotation annotation = new PAnnotation("Format");
      annotation.addAttribute("lineColor","#000080");
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
    private final static PortToPortConnectionQuerySpecification INSTANCE = make();
    
    public static PortToPortConnectionQuerySpecification make() {
      return new PortToPortConnectionQuerySpecification();					
      
    }
  }
}
