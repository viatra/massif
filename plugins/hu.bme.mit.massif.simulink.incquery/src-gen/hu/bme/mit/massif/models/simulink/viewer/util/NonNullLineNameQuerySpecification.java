package hu.bme.mit.massif.models.simulink.viewer.util;

import com.google.common.collect.Sets;
import hu.bme.mit.massif.models.simulink.util.util.LineNameQuerySpecification;
import hu.bme.mit.massif.models.simulink.viewer.NonNullLineNameMatch;
import hu.bme.mit.massif.models.simulink.viewer.NonNullLineNameMatcher;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import org.eclipse.incquery.runtime.api.IncQueryEngine;
import org.eclipse.incquery.runtime.api.impl.BaseGeneratedQuerySpecification;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.incquery.runtime.matchers.psystem.PBody;
import org.eclipse.incquery.runtime.matchers.psystem.PVariable;
import org.eclipse.incquery.runtime.matchers.psystem.basicdeferred.ExportedParameter;
import org.eclipse.incquery.runtime.matchers.psystem.basicdeferred.NegativePatternCall;
import org.eclipse.incquery.runtime.matchers.psystem.basicenumerables.ConstantValue;
import org.eclipse.incquery.runtime.matchers.psystem.basicenumerables.PositivePatternCall;
import org.eclipse.incquery.runtime.matchers.psystem.basicenumerables.TypeUnary;
import org.eclipse.incquery.runtime.matchers.psystem.queries.PParameter;
import org.eclipse.incquery.runtime.matchers.tuple.FlatTuple;

/**
 * A pattern-specific query specification that can instantiate NonNullLineNameMatcher in a type-safe way.
 * 
 * @see NonNullLineNameMatcher
 * @see NonNullLineNameMatch
 * 
 */
@SuppressWarnings("all")
public final class NonNullLineNameQuerySpecification extends BaseGeneratedQuerySpecification<NonNullLineNameMatcher> {
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static NonNullLineNameQuerySpecification instance() throws IncQueryException {
    return LazyHolder.INSTANCE;
    
  }
  
  @Override
  protected NonNullLineNameMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return NonNullLineNameMatcher.on(engine);
  }
  
  @Override
  public String getFullyQualifiedName() {
    return "hu.bme.mit.massif.models.simulink.viewer.nonNullLineName";
    
  }
  
  @Override
  public List<String> getParameterNames() {
    return Arrays.asList("conn","name");
  }
  
  @Override
  public List<PParameter> getParameters() {
    return Arrays.asList(new PParameter("conn", "hu.bme.mit.massif.simulink.Connection"),new PParameter("name", "java.lang.String"));
  }
  
  @Override
  public NonNullLineNameMatch newEmptyMatch() {
    return NonNullLineNameMatch.newEmptyMatch();
  }
  
  @Override
  public NonNullLineNameMatch newMatch(final Object... parameters) {
    return NonNullLineNameMatch.newMatch((hu.bme.mit.massif.simulink.Connection) parameters[0], (java.lang.String) parameters[1]);
  }
  
  @Override
  public Set<PBody> doGetContainedBodies() throws IncQueryException {
    Set<PBody> bodies = Sets.newLinkedHashSet();
    {
      PBody body = new PBody(this);
      PVariable var_conn = body.getOrCreateVariableByName("conn");
      PVariable var_name = body.getOrCreateVariableByName("name");
      body.setExportedParameters(Arrays.<ExportedParameter>asList(
        new ExportedParameter(body, var_conn, "conn"), 
        new ExportedParameter(body, var_name, "name")
      ));
      
      
      new PositivePatternCall(body, new FlatTuple(var_conn, var_name), LineNameQuerySpecification.instance());
      bodies.add(body);
    }
    {
      PBody body = new PBody(this);
      PVariable var_conn = body.getOrCreateVariableByName("conn");
      PVariable var_name = body.getOrCreateVariableByName("name");
      PVariable var__noname = body.getOrCreateVariableByName("_noname");
      body.setExportedParameters(Arrays.<ExportedParameter>asList(
        new ExportedParameter(body, var_conn, "conn"), 
        new ExportedParameter(body, var_name, "name")
      ));
      
      
      new TypeUnary(body, var_conn, getClassifierLiteral("http://hu.bme.mit.massif/simulink/1.0", "Connection"), "http://hu.bme.mit.massif/simulink/1.0/Connection");
      new NegativePatternCall(body, new FlatTuple(var_conn, var__noname), LineNameQuerySpecification.instance().instance());
      new ConstantValue(body, var_name, "");
      bodies.add(body);
    }
    return bodies;
  }
  
  private static class LazyHolder {
    private final static NonNullLineNameQuerySpecification INSTANCE = make();
    
    public static NonNullLineNameQuerySpecification make() {
      return new NonNullLineNameQuerySpecification();					
      
    }
  }
}
