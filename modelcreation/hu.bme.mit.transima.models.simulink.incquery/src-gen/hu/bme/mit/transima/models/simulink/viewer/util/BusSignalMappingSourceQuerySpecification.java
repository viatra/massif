package hu.bme.mit.transima.models.simulink.viewer.util;

import com.google.common.collect.Sets;
import hu.bme.mit.transima.models.simulink.util.util.BusMappingInSelectorQuerySpecification;
import hu.bme.mit.transima.models.simulink.util.util.PortConnectionQuerySpecification;
import hu.bme.mit.transima.models.simulink.viewer.BusSignalMappingSourceMatch;
import hu.bme.mit.transima.models.simulink.viewer.BusSignalMappingSourceMatcher;
import hu.bme.mit.transima.models.simulink.viewer.util.HierarchyConnectionEndQuerySpecification;
import hu.bme.mit.transima.models.simulink.viewer.util.NonNullLineNameQuerySpecification;
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
 * A pattern-specific query specification that can instantiate BusSignalMappingSourceMatcher in a type-safe way.
 * 
 * @see BusSignalMappingSourceMatcher
 * @see BusSignalMappingSourceMatch
 * 
 */
@SuppressWarnings("all")
public final class BusSignalMappingSourceQuerySpecification extends BaseGeneratedQuerySpecification<BusSignalMappingSourceMatcher> {
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static BusSignalMappingSourceQuerySpecification instance() throws IncQueryException {
    return LazyHolder.INSTANCE;
    
  }
  
  protected BusSignalMappingSourceMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return BusSignalMappingSourceMatcher.on(engine);
  }
  
  public String getFullyQualifiedName() {
    return "hu.bme.mit.transima.models.simulink.viewer.busSignalMappingSource";
    
  }
  
  public List<String> getParameterNames() {
    return Arrays.asList("busSelector","from","name","toName");
  }
  
  public List<PParameter> getParameters() {
    return Arrays.asList(new PParameter("busSelector", "hu.bme.mit.transima.Simulink.BusSelector"),new PParameter("from", "hu.bme.mit.transima.Simulink.Block"),new PParameter("name", "java.lang.String"),new PParameter("toName", "java.lang.String"));
  }
  
  public BusSignalMappingSourceMatch newEmptyMatch() {
    return BusSignalMappingSourceMatch.newEmptyMatch();
  }
  
  public BusSignalMappingSourceMatch newMatch(final Object... parameters) {
    return BusSignalMappingSourceMatch.newMatch((hu.bme.mit.transima.Simulink.BusSelector) parameters[0], (hu.bme.mit.transima.Simulink.Block) parameters[1], (java.lang.String) parameters[2], (java.lang.String) parameters[3]);
  }
  
  public Set<PBody> doGetContainedBodies() throws IncQueryException {
    Set<PBody> bodies = Sets.newLinkedHashSet();
    {
      PBody body = new PBody(this);
      PVariable var_busSelector = body.getOrCreateVariableByName("busSelector");
      PVariable var_from = body.getOrCreateVariableByName("from");
      PVariable var_name = body.getOrCreateVariableByName("name");
      PVariable var_toName = body.getOrCreateVariableByName("toName");
      PVariable var__mapping = body.getOrCreateVariableByName("_mapping");
      PVariable var_fromOP = body.getOrCreateVariableByName("fromOP");
      PVariable var_to = body.getOrCreateVariableByName("to");
      PVariable var__inP = body.getOrCreateVariableByName("_inP");
      PVariable var_fromPC = body.getOrCreateVariableByName("fromPC");
      PVariable var__toP = body.getOrCreateVariableByName("_toP");
      PVariable var_toPC = body.getOrCreateVariableByName("toPC");
      body.setExportedParameters(Arrays.<ExportedParameter>asList(
        new ExportedParameter(body, var_busSelector, "busSelector"), 
        new ExportedParameter(body, var_from, "from"), 
        new ExportedParameter(body, var_name, "name"), 
        new ExportedParameter(body, var_toName, "toName")
      ));
      
      
      
      
      new PositivePatternCall(body, new FlatTuple(var_busSelector, var__mapping, var_fromOP, var_to), BusMappingInSelectorQuerySpecification.instance());
      new PositivePatternCall(body, new FlatTuple(var_fromOP, var_from), HierarchyConnectionEndQuerySpecification.instance());
      new PositivePatternCall(body, new FlatTuple(var_fromOP, var__inP, var_fromPC), PortConnectionQuerySpecification.instance());
      new PositivePatternCall(body, new FlatTuple(var_to, var__toP, var_toPC), PortConnectionQuerySpecification.instance());
      new PositivePatternCall(body, new FlatTuple(var_fromPC, var_name), NonNullLineNameQuerySpecification.instance());
      new PositivePatternCall(body, new FlatTuple(var_toPC, var_toName), NonNullLineNameQuerySpecification.instance());
      bodies.add(body);
    }
    {
      PAnnotation annotation = new PAnnotation("Edge");
      annotation.addAttribute("source",new ParameterReference("busSelector"));
      annotation.addAttribute("target",new ParameterReference("from"));
      annotation.addAttribute("label","[$name$ -> $toName$]");
      addAnnotation(annotation);
    }
    {
      PAnnotation annotation = new PAnnotation("Format");
      annotation.addAttribute("lineColor","#228B22");
      annotation.addAttribute("lineStyle","dotted");
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
    private final static BusSignalMappingSourceQuerySpecification INSTANCE = make();
    
    public static BusSignalMappingSourceQuerySpecification make() {
      return new BusSignalMappingSourceQuerySpecification();					
      
    }
  }
}
