package hu.bme.mit.massif.models.simulink.util.util;

import com.google.common.collect.Sets;
import hu.bme.mit.massif.models.simulink.util.ChildBlockNamesMatch;
import hu.bme.mit.massif.models.simulink.util.ChildBlockNamesMatcher;
import hu.bme.mit.massif.models.simulink.util.util.ElementNameQuerySpecification;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import org.eclipse.incquery.runtime.api.IncQueryEngine;
import org.eclipse.incquery.runtime.api.impl.BaseGeneratedEMFPQuery;
import org.eclipse.incquery.runtime.api.impl.BaseGeneratedEMFQuerySpecification;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.incquery.runtime.matchers.psystem.PBody;
import org.eclipse.incquery.runtime.matchers.psystem.PVariable;
import org.eclipse.incquery.runtime.matchers.psystem.basicdeferred.ExportedParameter;
import org.eclipse.incquery.runtime.matchers.psystem.basicenumerables.PositivePatternCall;
import org.eclipse.incquery.runtime.matchers.psystem.basicenumerables.TypeBinary;
import org.eclipse.incquery.runtime.matchers.psystem.queries.PParameter;
import org.eclipse.incquery.runtime.matchers.psystem.queries.QueryInitializationException;
import org.eclipse.incquery.runtime.matchers.tuple.FlatTuple;

/**
 * A pattern-specific query specification that can instantiate ChildBlockNamesMatcher in a type-safe way.
 * 
 * @see ChildBlockNamesMatcher
 * @see ChildBlockNamesMatch
 * 
 */
@SuppressWarnings("all")
public final class ChildBlockNamesQuerySpecification extends BaseGeneratedEMFQuerySpecification<ChildBlockNamesMatcher> {
  private ChildBlockNamesQuerySpecification() {
    super(GeneratedPQuery.INSTANCE);
  }
  
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static ChildBlockNamesQuerySpecification instance() throws IncQueryException {
    try{
    	return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
    	throw processInitializerError(err);
    }
  }
  
  @Override
  protected ChildBlockNamesMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return ChildBlockNamesMatcher.on(engine);
  }
  
  @Override
  public ChildBlockNamesMatch newEmptyMatch() {
    return ChildBlockNamesMatch.newEmptyMatch();
  }
  
  @Override
  public ChildBlockNamesMatch newMatch(final Object... parameters) {
    return ChildBlockNamesMatch.newMatch((hu.bme.mit.massif.simulink.SimulinkElement) parameters[0], (hu.bme.mit.massif.simulink.SimulinkElement) parameters[1], (java.lang.String) parameters[2]);
  }
  
  private static class LazyHolder {
    private final static ChildBlockNamesQuerySpecification INSTANCE = make();
    
    public static ChildBlockNamesQuerySpecification make() {
      return new ChildBlockNamesQuerySpecification();					
    }
  }
  
  private static class GeneratedPQuery extends BaseGeneratedEMFPQuery {
    private final static ChildBlockNamesQuerySpecification.GeneratedPQuery INSTANCE = new GeneratedPQuery();
    
    @Override
    public String getFullyQualifiedName() {
      return "hu.bme.mit.massif.models.simulink.util.childBlockNames";
    }
    
    @Override
    public List<String> getParameterNames() {
      return Arrays.asList("elem","child","name");
    }
    
    @Override
    public List<PParameter> getParameters() {
      return Arrays.asList(new PParameter("elem", "hu.bme.mit.massif.simulink.SimulinkElement"),new PParameter("child", "hu.bme.mit.massif.simulink.SimulinkElement"),new PParameter("name", "java.lang.String"));
    }
    
    @Override
    public Set<PBody> doGetContainedBodies() throws QueryInitializationException {
      Set<PBody> bodies = Sets.newLinkedHashSet();
      try {
      {
      	PBody body = new PBody(this);
      	PVariable var_elem = body.getOrCreateVariableByName("elem");
      	PVariable var_child = body.getOrCreateVariableByName("child");
      	PVariable var_name = body.getOrCreateVariableByName("name");
      	body.setExportedParameters(Arrays.<ExportedParameter>asList(
      		new ExportedParameter(body, var_elem, "elem"),
      				
      		new ExportedParameter(body, var_child, "child"),
      				
      		new ExportedParameter(body, var_name, "name")
      	));
      	new TypeBinary(body, CONTEXT, var_elem, var_child, getFeatureLiteral("http://hu.bme.mit.massif/simulink/1.0", "SimulinkModel", "contains"), "http://hu.bme.mit.massif/simulink/1.0/SimulinkModel.contains");
      	new PositivePatternCall(body, new FlatTuple(var_child, var_name), ElementNameQuerySpecification.instance().getInternalQueryRepresentation());
      	bodies.add(body);
      }
      {
      	PBody body = new PBody(this);
      	PVariable var_elem = body.getOrCreateVariableByName("elem");
      	PVariable var_child = body.getOrCreateVariableByName("child");
      	PVariable var_name = body.getOrCreateVariableByName("name");
      	body.setExportedParameters(Arrays.<ExportedParameter>asList(
      		new ExportedParameter(body, var_elem, "elem"),
      				
      		new ExportedParameter(body, var_child, "child"),
      				
      		new ExportedParameter(body, var_name, "name")
      	));
      	new TypeBinary(body, CONTEXT, var_elem, var_child, getFeatureLiteral("http://hu.bme.mit.massif/simulink/1.0", "SubSystem", "subBlocks"), "http://hu.bme.mit.massif/simulink/1.0/SubSystem.subBlocks");
      	new PositivePatternCall(body, new FlatTuple(var_child, var_name), ElementNameQuerySpecification.instance().getInternalQueryRepresentation());
      	bodies.add(body);
      }
      {
      	PBody body = new PBody(this);
      	PVariable var_elem = body.getOrCreateVariableByName("elem");
      	PVariable var_child = body.getOrCreateVariableByName("child");
      	PVariable var_name = body.getOrCreateVariableByName("name");
      	body.setExportedParameters(Arrays.<ExportedParameter>asList(
      		new ExportedParameter(body, var_elem, "elem"),
      				
      		new ExportedParameter(body, var_child, "child"),
      				
      		new ExportedParameter(body, var_name, "name")
      	));
      	new TypeBinary(body, CONTEXT, var_elem, var_child, getFeatureLiteral("http://hu.bme.mit.massif/simulink/1.0", "Block", "ports"), "http://hu.bme.mit.massif/simulink/1.0/Block.ports");
      	new PositivePatternCall(body, new FlatTuple(var_child, var_name), ElementNameQuerySpecification.instance().getInternalQueryRepresentation());
      	bodies.add(body);
      }
      {
      	PBody body = new PBody(this);
      	PVariable var_elem = body.getOrCreateVariableByName("elem");
      	PVariable var_child = body.getOrCreateVariableByName("child");
      	PVariable var_name = body.getOrCreateVariableByName("name");
      	body.setExportedParameters(Arrays.<ExportedParameter>asList(
      		new ExportedParameter(body, var_elem, "elem"),
      				
      		new ExportedParameter(body, var_child, "child"),
      				
      		new ExportedParameter(body, var_name, "name")
      	));
      	new TypeBinary(body, CONTEXT, var_child, var_elem, getFeatureLiteral("http://hu.bme.mit.massif/simulink/1.0", "MultiConnection", "connections"), "http://hu.bme.mit.massif/simulink/1.0/MultiConnection.connections");
      	new PositivePatternCall(body, new FlatTuple(var_child, var_name), ElementNameQuerySpecification.instance().getInternalQueryRepresentation());
      	bodies.add(body);
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
