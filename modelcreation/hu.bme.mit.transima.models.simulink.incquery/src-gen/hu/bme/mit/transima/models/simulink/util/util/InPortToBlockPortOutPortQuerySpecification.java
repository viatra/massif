package hu.bme.mit.transima.models.simulink.util.util;

import com.google.common.collect.Sets;
import hu.bme.mit.transima.models.simulink.util.InPortToBlockPortOutPortMatch;
import hu.bme.mit.transima.models.simulink.util.InPortToBlockPortOutPortMatcher;
import hu.bme.mit.transima.models.simulink.util.util.PortToPortBlockQuerySpecification;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import org.eclipse.incquery.runtime.api.IncQueryEngine;
import org.eclipse.incquery.runtime.api.impl.BaseGeneratedQuerySpecification;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.incquery.runtime.matchers.psystem.PBody;
import org.eclipse.incquery.runtime.matchers.psystem.PVariable;
import org.eclipse.incquery.runtime.matchers.psystem.basicdeferred.ExportedParameter;
import org.eclipse.incquery.runtime.matchers.psystem.basicenumerables.PositivePatternCall;
import org.eclipse.incquery.runtime.matchers.psystem.basicenumerables.TypeBinary;
import org.eclipse.incquery.runtime.matchers.psystem.basicenumerables.TypeUnary;
import org.eclipse.incquery.runtime.matchers.psystem.queries.PParameter;
import org.eclipse.incquery.runtime.matchers.tuple.FlatTuple;

/**
 * A pattern-specific query specification that can instantiate InPortToBlockPortOutPortMatcher in a type-safe way.
 * 
 * @see InPortToBlockPortOutPortMatcher
 * @see InPortToBlockPortOutPortMatch
 * 
 */
@SuppressWarnings("all")
public final class InPortToBlockPortOutPortQuerySpecification extends BaseGeneratedQuerySpecification<InPortToBlockPortOutPortMatcher> {
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static InPortToBlockPortOutPortQuerySpecification instance() throws IncQueryException {
    return LazyHolder.INSTANCE;
    
  }
  
  @Override
  protected InPortToBlockPortOutPortMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return InPortToBlockPortOutPortMatcher.on(engine);
  }
  
  @Override
  public String getFullyQualifiedName() {
    return "hu.bme.mit.transima.models.simulink.util.inPortToBlockPortOutPort";
    
  }
  
  @Override
  public List<String> getParameterNames() {
    return Arrays.asList("inPort","outPortOfPBl");
  }
  
  @Override
  public List<PParameter> getParameters() {
    return Arrays.asList(new PParameter("inPort", "hu.bme.mit.transima.Simulink.InPort"),new PParameter("outPortOfPBl", "hu.bme.mit.transima.Simulink.OutPort"));
  }
  
  @Override
  public InPortToBlockPortOutPortMatch newEmptyMatch() {
    return InPortToBlockPortOutPortMatch.newEmptyMatch();
  }
  
  @Override
  public InPortToBlockPortOutPortMatch newMatch(final Object... parameters) {
    return InPortToBlockPortOutPortMatch.newMatch((hu.bme.mit.transima.Simulink.InPort) parameters[0], (hu.bme.mit.transima.Simulink.OutPort) parameters[1]);
  }
  
  @Override
  public Set<PBody> doGetContainedBodies() throws IncQueryException {
    Set<PBody> bodies = Sets.newLinkedHashSet();
    {
      PBody body = new PBody(this);
      PVariable var_inPort = body.getOrCreateVariableByName("inPort");
      PVariable var_outPortOfPBl = body.getOrCreateVariableByName("outPortOfPBl");
      PVariable var_pBl = body.getOrCreateVariableByName("pBl");
      body.setExportedParameters(Arrays.<ExportedParameter>asList(
        new ExportedParameter(body, var_inPort, "inPort"), 
        new ExportedParameter(body, var_outPortOfPBl, "outPortOfPBl")
      ));
      
      new TypeUnary(body, var_inPort, getClassifierLiteral("http://hu.bme.mit.transima/simulink/1.0", "InPort"), "http://hu.bme.mit.transima/simulink/1.0/InPort");
      
      new TypeUnary(body, var_outPortOfPBl, getClassifierLiteral("http://hu.bme.mit.transima/simulink/1.0", "OutPort"), "http://hu.bme.mit.transima/simulink/1.0/OutPort");
      new PositivePatternCall(body, new FlatTuple(var_inPort, var_pBl), PortToPortBlockQuerySpecification.instance());
      new TypeUnary(body, var_pBl, getClassifierLiteral("http://hu.bme.mit.transima/simulink/1.0", "PortBlock"), "http://hu.bme.mit.transima/simulink/1.0/PortBlock");
      new TypeBinary(body, CONTEXT, var_pBl, var_outPortOfPBl, getFeatureLiteral("http://hu.bme.mit.transima/simulink/1.0", "Block", "ports"), "http://hu.bme.mit.transima/simulink/1.0/Block.ports");
      bodies.add(body);
    }
    return bodies;
  }
  
  private static class LazyHolder {
    private final static InPortToBlockPortOutPortQuerySpecification INSTANCE = make();
    
    public static InPortToBlockPortOutPortQuerySpecification make() {
      return new InPortToBlockPortOutPortQuerySpecification();					
      
    }
  }
}
