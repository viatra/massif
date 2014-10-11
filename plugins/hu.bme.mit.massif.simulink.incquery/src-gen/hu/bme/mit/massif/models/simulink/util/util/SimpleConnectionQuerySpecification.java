package hu.bme.mit.massif.models.simulink.util.util;

import com.google.common.collect.Sets;
import hu.bme.mit.massif.models.simulink.util.SimpleConnectionMatch;
import hu.bme.mit.massif.models.simulink.util.SimpleConnectionMatcher;
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
 * A pattern-specific query specification that can instantiate SimpleConnectionMatcher in a type-safe way.
 * 
 * @see SimpleConnectionMatcher
 * @see SimpleConnectionMatch
 * 
 */
@SuppressWarnings("all")
public final class SimpleConnectionQuerySpecification extends BaseGeneratedQuerySpecification<SimpleConnectionMatcher> {
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static SimpleConnectionQuerySpecification instance() throws IncQueryException {
    return LazyHolder.INSTANCE;
    
  }
  
  @Override
  protected SimpleConnectionMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return SimpleConnectionMatcher.on(engine);
  }
  
  @Override
  public String getFullyQualifiedName() {
    return "hu.bme.mit.massif.models.simulink.util.simpleConnection";
    
  }
  
  @Override
  public List<String> getParameterNames() {
    return Arrays.asList("outP","inP","pc");
  }
  
  @Override
  public List<PParameter> getParameters() {
    return Arrays.asList(new PParameter("outP", "hu.bme.mit.massif.simulink.OutPort"),new PParameter("inP", "hu.bme.mit.massif.simulink.InPort"),new PParameter("pc", "hu.bme.mit.massif.simulink.SingleConnection"));
  }
  
  @Override
  public SimpleConnectionMatch newEmptyMatch() {
    return SimpleConnectionMatch.newEmptyMatch();
  }
  
  @Override
  public SimpleConnectionMatch newMatch(final Object... parameters) {
    return SimpleConnectionMatch.newMatch((hu.bme.mit.massif.simulink.OutPort) parameters[0], (hu.bme.mit.massif.simulink.InPort) parameters[1], (hu.bme.mit.massif.simulink.SingleConnection) parameters[2]);
  }
  
  @Override
  public Set<PBody> doGetContainedBodies() throws IncQueryException {
    Set<PBody> bodies = Sets.newLinkedHashSet();
    {
      PBody body = new PBody(this);
      PVariable var_outP = body.getOrCreateVariableByName("outP");
      PVariable var_inP = body.getOrCreateVariableByName("inP");
      PVariable var_pc = body.getOrCreateVariableByName("pc");
      body.setExportedParameters(Arrays.<ExportedParameter>asList(
        new ExportedParameter(body, var_outP, "outP"), 
        new ExportedParameter(body, var_inP, "inP"), 
        new ExportedParameter(body, var_pc, "pc")
      ));
      
      
      
      new TypeBinary(body, CONTEXT, var_inP, var_pc, getFeatureLiteral("http://hu.bme.mit.massif/simulink/1.0", "InPort", "connection"), "http://hu.bme.mit.massif/simulink/1.0/InPort.connection");
      new TypeBinary(body, CONTEXT, var_pc, var_outP, getFeatureLiteral("http://hu.bme.mit.massif/simulink/1.0", "Connection", "from"), "http://hu.bme.mit.massif/simulink/1.0/Connection.from");
      bodies.add(body);
    }
    return bodies;
  }
  
  private static class LazyHolder {
    private final static SimpleConnectionQuerySpecification INSTANCE = make();
    
    public static SimpleConnectionQuerySpecification make() {
      return new SimpleConnectionQuerySpecification();					
      
    }
  }
}
