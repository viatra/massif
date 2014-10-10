package hu.bme.mit.transima.models.simulink.viewer.util;

import com.google.common.collect.Sets;
import hu.bme.mit.transima.models.simulink.viewer.PortOfPortBlockMatch;
import hu.bme.mit.transima.models.simulink.viewer.PortOfPortBlockMatcher;
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
 * A pattern-specific query specification that can instantiate PortOfPortBlockMatcher in a type-safe way.
 * 
 * @see PortOfPortBlockMatcher
 * @see PortOfPortBlockMatch
 * 
 */
@SuppressWarnings("all")
public final class PortOfPortBlockQuerySpecification extends BaseGeneratedQuerySpecification<PortOfPortBlockMatcher> {
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static PortOfPortBlockQuerySpecification instance() throws IncQueryException {
    return LazyHolder.INSTANCE;
    
  }
  
  protected PortOfPortBlockMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return PortOfPortBlockMatcher.on(engine);
  }
  
  public String getFullyQualifiedName() {
    return "hu.bme.mit.transima.models.simulink.viewer.portOfPortBlock";
    
  }
  
  public List<String> getParameterNames() {
    return Arrays.asList("port","portBlock");
  }
  
  public List<PParameter> getParameters() {
    return Arrays.asList(new PParameter("port", "hu.bme.mit.transima.Simulink.Port"),new PParameter("portBlock", "hu.bme.mit.transima.Simulink.PortBlock"));
  }
  
  public PortOfPortBlockMatch newEmptyMatch() {
    return PortOfPortBlockMatch.newEmptyMatch();
  }
  
  public PortOfPortBlockMatch newMatch(final Object... parameters) {
    return PortOfPortBlockMatch.newMatch((hu.bme.mit.transima.Simulink.Port) parameters[0], (hu.bme.mit.transima.Simulink.PortBlock) parameters[1]);
  }
  
  public Set<PBody> doGetContainedBodies() throws IncQueryException {
    Set<PBody> bodies = Sets.newLinkedHashSet();
    {
      PBody body = new PBody(this);
      PVariable var_port = body.getOrCreateVariableByName("port");
      PVariable var_portBlock = body.getOrCreateVariableByName("portBlock");
      body.setExportedParameters(Arrays.<ExportedParameter>asList(
        new ExportedParameter(body, var_port, "port"), 
        new ExportedParameter(body, var_portBlock, "portBlock")
      ));
      
      
      new TypeBinary(body, CONTEXT, var_port, var_portBlock, getFeatureLiteral("http://hu.bme.mit.transima/simulink/1.0", "Port", "portBlock"), "http://hu.bme.mit.transima/simulink/1.0/Port.portBlock");
      bodies.add(body);
    }
    return bodies;
  }
  
  private static class LazyHolder {
    private final static PortOfPortBlockQuerySpecification INSTANCE = make();
    
    public static PortOfPortBlockQuerySpecification make() {
      return new PortOfPortBlockQuerySpecification();					
      
    }
  }
}
