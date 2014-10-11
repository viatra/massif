package hu.bme.mit.massif.models.simulink.derived.util;

import com.google.common.collect.Sets;
import hu.bme.mit.massif.models.simulink.derived.OutportsMatch;
import hu.bme.mit.massif.models.simulink.derived.OutportsMatcher;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import org.eclipse.incquery.runtime.api.IncQueryEngine;
import org.eclipse.incquery.runtime.api.impl.BaseGeneratedQuerySpecification;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.incquery.runtime.matchers.psystem.PBody;
import org.eclipse.incquery.runtime.matchers.psystem.PVariable;
import org.eclipse.incquery.runtime.matchers.psystem.annotations.PAnnotation;
import org.eclipse.incquery.runtime.matchers.psystem.basicdeferred.ExportedParameter;
import org.eclipse.incquery.runtime.matchers.psystem.basicenumerables.TypeBinary;
import org.eclipse.incquery.runtime.matchers.psystem.basicenumerables.TypeUnary;
import org.eclipse.incquery.runtime.matchers.psystem.queries.PParameter;

/**
 * A pattern-specific query specification that can instantiate OutportsMatcher in a type-safe way.
 * 
 * @see OutportsMatcher
 * @see OutportsMatch
 * 
 */
@SuppressWarnings("all")
public final class OutportsQuerySpecification extends BaseGeneratedQuerySpecification<OutportsMatcher> {
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static OutportsQuerySpecification instance() throws IncQueryException {
    return LazyHolder.INSTANCE;
    
  }
  
  @Override
  protected OutportsMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return OutportsMatcher.on(engine);
  }
  
  @Override
  public String getFullyQualifiedName() {
    return "hu.bme.mit.massif.models.simulink.derived.outports";
    
  }
  
  @Override
  public List<String> getParameterNames() {
    return Arrays.asList("Block","OutPort");
  }
  
  @Override
  public List<PParameter> getParameters() {
    return Arrays.asList(new PParameter("Block", "hu.bme.mit.massif.simulink.Block"),new PParameter("OutPort", "hu.bme.mit.massif.simulink.OutPort"));
  }
  
  @Override
  public OutportsMatch newEmptyMatch() {
    return OutportsMatch.newEmptyMatch();
  }
  
  @Override
  public OutportsMatch newMatch(final Object... parameters) {
    return OutportsMatch.newMatch((hu.bme.mit.massif.simulink.Block) parameters[0], (hu.bme.mit.massif.simulink.OutPort) parameters[1]);
  }
  
  @Override
  public Set<PBody> doGetContainedBodies() throws IncQueryException {
    Set<PBody> bodies = Sets.newLinkedHashSet();
    {
      PBody body = new PBody(this);
      PVariable var_Block = body.getOrCreateVariableByName("Block");
      PVariable var_OutPort = body.getOrCreateVariableByName("OutPort");
      body.setExportedParameters(Arrays.<ExportedParameter>asList(
        new ExportedParameter(body, var_Block, "Block"), 
        new ExportedParameter(body, var_OutPort, "OutPort")
      ));
      
      
      new TypeUnary(body, var_OutPort, getClassifierLiteral("http://hu.bme.mit.massif/simulink/1.0", "OutPort"), "http://hu.bme.mit.massif/simulink/1.0/OutPort");
      new TypeBinary(body, CONTEXT, var_Block, var_OutPort, getFeatureLiteral("http://hu.bme.mit.massif/simulink/1.0", "Block", "ports"), "http://hu.bme.mit.massif/simulink/1.0/Block.ports");
      bodies.add(body);
    }
    {
      PAnnotation annotation = new PAnnotation("QueryBasedFeature");
      addAnnotation(annotation);
    }
    return bodies;
  }
  
  private static class LazyHolder {
    private final static OutportsQuerySpecification INSTANCE = make();
    
    public static OutportsQuerySpecification make() {
      return new OutportsQuerySpecification();					
      
    }
  }
}
