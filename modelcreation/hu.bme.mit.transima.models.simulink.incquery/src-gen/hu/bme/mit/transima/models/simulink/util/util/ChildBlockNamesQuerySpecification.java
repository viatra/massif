package hu.bme.mit.transima.models.simulink.util.util;

import com.google.common.collect.Sets;
import hu.bme.mit.transima.models.simulink.util.ChildBlockNamesMatch;
import hu.bme.mit.transima.models.simulink.util.ChildBlockNamesMatcher;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import org.eclipse.incquery.runtime.api.IncQueryEngine;
import org.eclipse.incquery.runtime.api.impl.BaseGeneratedQuerySpecification;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.incquery.runtime.matchers.psystem.PBody;
import org.eclipse.incquery.runtime.matchers.psystem.PVariable;
import org.eclipse.incquery.runtime.matchers.psystem.basicdeferred.ExportedParameter;
import org.eclipse.incquery.runtime.matchers.psystem.basicenumerables.TypeBinary;
import org.eclipse.incquery.runtime.matchers.psystem.queries.PParameter;

/**
 * A pattern-specific query specification that can instantiate ChildBlockNamesMatcher in a type-safe way.
 * 
 * @see ChildBlockNamesMatcher
 * @see ChildBlockNamesMatch
 * 
 */
@SuppressWarnings("all")
public final class ChildBlockNamesQuerySpecification extends BaseGeneratedQuerySpecification<ChildBlockNamesMatcher> {
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static ChildBlockNamesQuerySpecification instance() throws IncQueryException {
    return LazyHolder.INSTANCE;
    
  }
  
  protected ChildBlockNamesMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return ChildBlockNamesMatcher.on(engine);
  }
  
  public String getFullyQualifiedName() {
    return "hu.bme.mit.transima.models.simulink.util.childBlockNames";
    
  }
  
  public List<String> getParameterNames() {
    return Arrays.asList("elem","child","name");
  }
  
  public List<PParameter> getParameters() {
    return Arrays.asList(new PParameter("elem", "hu.bme.mit.transima.Simulink.SimulinkElement"),new PParameter("child", "hu.bme.mit.transima.Simulink.SimulinkElement"),new PParameter("name", "java.lang.String"));
  }
  
  public ChildBlockNamesMatch newEmptyMatch() {
    return ChildBlockNamesMatch.newEmptyMatch();
  }
  
  public ChildBlockNamesMatch newMatch(final Object... parameters) {
    return ChildBlockNamesMatch.newMatch((hu.bme.mit.transima.Simulink.SimulinkElement) parameters[0], (hu.bme.mit.transima.Simulink.SimulinkElement) parameters[1], (java.lang.String) parameters[2]);
  }
  
  public Set<PBody> doGetContainedBodies() throws IncQueryException {
    Set<PBody> bodies = Sets.newLinkedHashSet();
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
      
      
      
      new TypeBinary(body, CONTEXT, var_elem, var_child, getFeatureLiteral("http://hu.bme.mit.transima/simulink/1.0", "SimulinkModel", "contains"), "http://hu.bme.mit.transima/simulink/1.0/SimulinkModel.contains");
      new TypeBinary(body, CONTEXT, var_child, var_name, getFeatureLiteral("http://hu.bme.mit.transima/simulink/1.0", "SimulinkElement", "name"), "http://hu.bme.mit.transima/simulink/1.0/SimulinkElement.name");
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
      
      
      
      new TypeBinary(body, CONTEXT, var_elem, var_child, getFeatureLiteral("http://hu.bme.mit.transima/simulink/1.0", "SubSystem", "subBlocks"), "http://hu.bme.mit.transima/simulink/1.0/SubSystem.subBlocks");
      new TypeBinary(body, CONTEXT, var_child, var_name, getFeatureLiteral("http://hu.bme.mit.transima/simulink/1.0", "SimulinkElement", "name"), "http://hu.bme.mit.transima/simulink/1.0/SimulinkElement.name");
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
      
      
      
      new TypeBinary(body, CONTEXT, var_elem, var_child, getFeatureLiteral("http://hu.bme.mit.transima/simulink/1.0", "Block", "ports"), "http://hu.bme.mit.transima/simulink/1.0/Block.ports");
      new TypeBinary(body, CONTEXT, var_child, var_name, getFeatureLiteral("http://hu.bme.mit.transima/simulink/1.0", "SimulinkElement", "name"), "http://hu.bme.mit.transima/simulink/1.0/SimulinkElement.name");
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
      
      
      
      new TypeBinary(body, CONTEXT, var_child, var_elem, getFeatureLiteral("http://hu.bme.mit.transima/simulink/1.0", "MultiConnection", "connections"), "http://hu.bme.mit.transima/simulink/1.0/MultiConnection.connections");
      new TypeBinary(body, CONTEXT, var_child, var_name, getFeatureLiteral("http://hu.bme.mit.transima/simulink/1.0", "SimulinkElement", "name"), "http://hu.bme.mit.transima/simulink/1.0/SimulinkElement.name");
      bodies.add(body);
    }
    return bodies;
  }
  
  private static class LazyHolder {
    private final static ChildBlockNamesQuerySpecification INSTANCE = make();
    
    public static ChildBlockNamesQuerySpecification make() {
      return new ChildBlockNamesQuerySpecification();					
      
    }
  }
}
