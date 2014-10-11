package hu.bme.mit.transima.models.simulink.util.util;

import com.google.common.collect.Sets;
import hu.bme.mit.transima.models.simulink.util.LineNameMatch;
import hu.bme.mit.transima.models.simulink.util.LineNameMatcher;
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
 * A pattern-specific query specification that can instantiate LineNameMatcher in a type-safe way.
 * 
 * @see LineNameMatcher
 * @see LineNameMatch
 * 
 */
@SuppressWarnings("all")
public final class LineNameQuerySpecification extends BaseGeneratedQuerySpecification<LineNameMatcher> {
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static LineNameQuerySpecification instance() throws IncQueryException {
    return LazyHolder.INSTANCE;
    
  }
  
  @Override
  protected LineNameMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return LineNameMatcher.on(engine);
  }
  
  @Override
  public String getFullyQualifiedName() {
    return "hu.bme.mit.transima.models.simulink.util.lineName";
    
  }
  
  @Override
  public List<String> getParameterNames() {
    return Arrays.asList("conn","name");
  }
  
  @Override
  public List<PParameter> getParameters() {
    return Arrays.asList(new PParameter("conn", "hu.bme.mit.transima.Simulink.Connection"),new PParameter("name", "java.lang.String"));
  }
  
  @Override
  public LineNameMatch newEmptyMatch() {
    return LineNameMatch.newEmptyMatch();
  }
  
  @Override
  public LineNameMatch newMatch(final Object... parameters) {
    return LineNameMatch.newMatch((hu.bme.mit.transima.Simulink.Connection) parameters[0], (java.lang.String) parameters[1]);
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
      
      
      new TypeBinary(body, CONTEXT, var_conn, var_name, getFeatureLiteral("http://hu.bme.mit.transima/simulink/1.0", "Connection", "lineName"), "http://hu.bme.mit.transima/simulink/1.0/Connection.lineName");
      bodies.add(body);
    }
    return bodies;
  }
  
  private static class LazyHolder {
    private final static LineNameQuerySpecification INSTANCE = make();
    
    public static LineNameQuerySpecification make() {
      return new LineNameQuerySpecification();					
      
    }
  }
}
