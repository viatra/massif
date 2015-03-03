package hu.bme.mit.massif.models.simulink.viewer.util;

import com.google.common.collect.Sets;
import hu.bme.mit.massif.models.simulink.util.util.PortConnectionQuerySpecification;
import hu.bme.mit.massif.models.simulink.viewer.HierarchyConnectionMatch;
import hu.bme.mit.massif.models.simulink.viewer.HierarchyConnectionMatcher;
import hu.bme.mit.massif.models.simulink.viewer.util.HierarchyConnectionEndQuerySpecification;
import hu.bme.mit.massif.models.simulink.viewer.util.NonNullLineNameQuerySpecification;
import hu.bme.mit.massif.models.simulink.viewer.util.PortToPortConnectionQuerySpecification;
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
import org.eclipse.incquery.runtime.matchers.psystem.basicenumerables.PositivePatternCall;
import org.eclipse.incquery.runtime.matchers.psystem.queries.PParameter;
import org.eclipse.incquery.runtime.matchers.psystem.queries.QueryInitializationException;
import org.eclipse.incquery.runtime.matchers.tuple.FlatTuple;

/**
 * A pattern-specific query specification that can instantiate HierarchyConnectionMatcher in a type-safe way.
 * 
 * @see HierarchyConnectionMatcher
 * @see HierarchyConnectionMatch
 * 
 */
@SuppressWarnings("all")
public final class HierarchyConnectionQuerySpecification extends BaseGeneratedEMFQuerySpecification<HierarchyConnectionMatcher> {
  private HierarchyConnectionQuerySpecification() {
    super(GeneratedPQuery.INSTANCE);
  }
  
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static HierarchyConnectionQuerySpecification instance() throws IncQueryException {
    try{
    	return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
    	throw processInitializerError(err);
    }
  }
  
  @Override
  protected HierarchyConnectionMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return HierarchyConnectionMatcher.on(engine);
  }
  
  @Override
  public HierarchyConnectionMatch newEmptyMatch() {
    return HierarchyConnectionMatch.newEmptyMatch();
  }
  
  @Override
  public HierarchyConnectionMatch newMatch(final Object... parameters) {
    return HierarchyConnectionMatch.newMatch((hu.bme.mit.massif.simulink.Block) parameters[0], (hu.bme.mit.massif.simulink.Block) parameters[1], (java.lang.String) parameters[2]);
  }
  
  private static class LazyHolder {
    private final static HierarchyConnectionQuerySpecification INSTANCE = make();
    
    public static HierarchyConnectionQuerySpecification make() {
      return new HierarchyConnectionQuerySpecification();					
    }
  }
  
  private static class GeneratedPQuery extends BaseGeneratedEMFPQuery {
    private final static HierarchyConnectionQuerySpecification.GeneratedPQuery INSTANCE = new GeneratedPQuery();
    
    @Override
    public String getFullyQualifiedName() {
      return "hu.bme.mit.massif.models.simulink.viewer.hierarchyConnection";
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
    public Set<PBody> doGetContainedBodies() throws QueryInitializationException {
      Set<PBody> bodies = Sets.newLinkedHashSet();
      try {
      {
      	PBody body = new PBody(this);
      	PVariable var_from = body.getOrCreateVariableByName("from");
      	PVariable var_to = body.getOrCreateVariableByName("to");
      	PVariable var_name = body.getOrCreateVariableByName("name");
      	PVariable var_outP = body.getOrCreateVariableByName("outP");
      	PVariable var_inP = body.getOrCreateVariableByName("inP");
      	PVariable var_firstPC = body.getOrCreateVariableByName("firstPC");
      	PVariable var__pc = body.getOrCreateVariableByName("_pc");
      	body.setExportedParameters(Arrays.<ExportedParameter>asList(
      		new ExportedParameter(body, var_from, "from"),
      				
      		new ExportedParameter(body, var_to, "to"),
      				
      		new ExportedParameter(body, var_name, "name")
      	));
      	new PositivePatternCall(body, new FlatTuple(var_outP, var_from), HierarchyConnectionEndQuerySpecification.instance().getInternalQueryRepresentation());
      	new PositivePatternCall(body, new FlatTuple(var_outP, var_inP, var_firstPC), PortConnectionQuerySpecification.instance().getInternalQueryRepresentation());
      	new PositivePatternCall(body, new FlatTuple(var_firstPC, var_name), NonNullLineNameQuerySpecification.instance().getInternalQueryRepresentation());
      	new NegativePatternCall(body, new FlatTuple(var_from, var_to, var__pc), PortToPortConnectionQuerySpecification.instance().getInternalQueryRepresentation());
      	new PositivePatternCall(body, new FlatTuple(var_inP, var_to), HierarchyConnectionEndQuerySpecification.instance().getInternalQueryRepresentation());
      	bodies.add(body);
      }
      	{
      	PAnnotation annotation = new PAnnotation("Edge");
      	annotation.addAttribute("source", new ParameterReference("from"));
      	annotation.addAttribute("target", new ParameterReference("to"));
      	annotation.addAttribute("label", "$name$");
      	addAnnotation(annotation);
      }
      {
      	PAnnotation annotation = new PAnnotation("Format");
      	annotation.addAttribute("lineColor", "#D93F3F");
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
