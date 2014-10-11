package hu.bme.mit.massif.models.simulink.util.util;

import com.google.common.collect.Sets;
import hu.bme.mit.massif.models.simulink.util.PortBlockInPortToOutPortMatch;
import hu.bme.mit.massif.models.simulink.util.PortBlockInPortToOutPortMatcher;
import hu.bme.mit.massif.models.simulink.util.util.PortToPortBlockQuerySpecification;
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
 * A pattern-specific query specification that can instantiate PortBlockInPortToOutPortMatcher in a type-safe way.
 * 
 * @see PortBlockInPortToOutPortMatcher
 * @see PortBlockInPortToOutPortMatch
 * 
 */
@SuppressWarnings("all")
public final class PortBlockInPortToOutPortQuerySpecification extends BaseGeneratedQuerySpecification<PortBlockInPortToOutPortMatcher> {
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static PortBlockInPortToOutPortQuerySpecification instance() throws IncQueryException {
    return LazyHolder.INSTANCE;
    
  }
  
  @Override
  protected PortBlockInPortToOutPortMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return PortBlockInPortToOutPortMatcher.on(engine);
  }
  
  @Override
  public String getFullyQualifiedName() {
    return "hu.bme.mit.massif.models.simulink.util.portBlockInPortToOutPort";
    
  }
  
  @Override
  public List<String> getParameterNames() {
    return Arrays.asList("inPortOfPBl","outPort");
  }
  
  @Override
  public List<PParameter> getParameters() {
    return Arrays.asList(new PParameter("inPortOfPBl", "hu.bme.mit.massif.simulink.InPort"),new PParameter("outPort", "hu.bme.mit.massif.simulink.OutPort"));
  }
  
  @Override
  public PortBlockInPortToOutPortMatch newEmptyMatch() {
    return PortBlockInPortToOutPortMatch.newEmptyMatch();
  }
  
  @Override
  public PortBlockInPortToOutPortMatch newMatch(final Object... parameters) {
    return PortBlockInPortToOutPortMatch.newMatch((hu.bme.mit.massif.simulink.InPort) parameters[0], (hu.bme.mit.massif.simulink.OutPort) parameters[1]);
  }
  
  @Override
  public Set<PBody> doGetContainedBodies() throws IncQueryException {
    Set<PBody> bodies = Sets.newLinkedHashSet();
    {
      PBody body = new PBody(this);
      PVariable var_inPortOfPBl = body.getOrCreateVariableByName("inPortOfPBl");
      PVariable var_outPort = body.getOrCreateVariableByName("outPort");
      PVariable var_pBl = body.getOrCreateVariableByName("pBl");
      body.setExportedParameters(Arrays.<ExportedParameter>asList(
        new ExportedParameter(body, var_inPortOfPBl, "inPortOfPBl"), 
        new ExportedParameter(body, var_outPort, "outPort")
      ));
      
      new TypeUnary(body, var_inPortOfPBl, getClassifierLiteral("http://hu.bme.mit.massif/simulink/1.0", "InPort"), "http://hu.bme.mit.massif/simulink/1.0/InPort");
      
      new TypeUnary(body, var_outPort, getClassifierLiteral("http://hu.bme.mit.massif/simulink/1.0", "OutPort"), "http://hu.bme.mit.massif/simulink/1.0/OutPort");
      new TypeUnary(body, var_pBl, getClassifierLiteral("http://hu.bme.mit.massif/simulink/1.0", "PortBlock"), "http://hu.bme.mit.massif/simulink/1.0/PortBlock");
      new TypeBinary(body, CONTEXT, var_pBl, var_inPortOfPBl, getFeatureLiteral("http://hu.bme.mit.massif/simulink/1.0", "Block", "ports"), "http://hu.bme.mit.massif/simulink/1.0/Block.ports");
      new PositivePatternCall(body, new FlatTuple(var_outPort, var_pBl), PortToPortBlockQuerySpecification.instance());
      bodies.add(body);
    }
    return bodies;
  }
  
  private static class LazyHolder {
    private final static PortBlockInPortToOutPortQuerySpecification INSTANCE = make();
    
    public static PortBlockInPortToOutPortQuerySpecification make() {
      return new PortBlockInPortToOutPortQuerySpecification();					
      
    }
  }
}
