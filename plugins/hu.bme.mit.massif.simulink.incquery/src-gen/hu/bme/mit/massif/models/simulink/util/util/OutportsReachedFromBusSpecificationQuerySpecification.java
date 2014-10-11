package hu.bme.mit.massif.models.simulink.util.util;

import com.google.common.collect.Sets;
import hu.bme.mit.massif.models.simulink.util.OutportsReachedFromBusSpecificationMatch;
import hu.bme.mit.massif.models.simulink.util.OutportsReachedFromBusSpecificationMatcher;
import hu.bme.mit.massif.models.simulink.util.util.PortConnectionQuerySpecification;
import hu.bme.mit.massif.models.simulink.util.util.SimpleConnectedOutPortQuerySpecification;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import org.eclipse.incquery.runtime.api.IncQueryEngine;
import org.eclipse.incquery.runtime.api.impl.BaseGeneratedQuerySpecification;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.incquery.runtime.matchers.psystem.PBody;
import org.eclipse.incquery.runtime.matchers.psystem.PVariable;
import org.eclipse.incquery.runtime.matchers.psystem.basicdeferred.ExportedParameter;
import org.eclipse.incquery.runtime.matchers.psystem.basicenumerables.BinaryTransitiveClosure;
import org.eclipse.incquery.runtime.matchers.psystem.basicenumerables.PositivePatternCall;
import org.eclipse.incquery.runtime.matchers.psystem.basicenumerables.TypeBinary;
import org.eclipse.incquery.runtime.matchers.psystem.basicenumerables.TypeUnary;
import org.eclipse.incquery.runtime.matchers.psystem.queries.PParameter;
import org.eclipse.incquery.runtime.matchers.tuple.FlatTuple;

/**
 * A pattern-specific query specification that can instantiate OutportsReachedFromBusSpecificationMatcher in a type-safe way.
 * 
 * @see OutportsReachedFromBusSpecificationMatcher
 * @see OutportsReachedFromBusSpecificationMatch
 * 
 */
@SuppressWarnings("all")
public final class OutportsReachedFromBusSpecificationQuerySpecification extends BaseGeneratedQuerySpecification<OutportsReachedFromBusSpecificationMatcher> {
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static OutportsReachedFromBusSpecificationQuerySpecification instance() throws IncQueryException {
    return LazyHolder.INSTANCE;
    
  }
  
  @Override
  protected OutportsReachedFromBusSpecificationMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return OutportsReachedFromBusSpecificationMatcher.on(engine);
  }
  
  @Override
  public String getFullyQualifiedName() {
    return "hu.bme.mit.massif.models.simulink.util.outportsReachedFromBusSpecification";
    
  }
  
  @Override
  public List<String> getParameterNames() {
    return Arrays.asList("outPort","nextSpec","endPortBeforeNextSpec");
  }
  
  @Override
  public List<PParameter> getParameters() {
    return Arrays.asList(new PParameter("outPort", "hu.bme.mit.massif.simulink.OutPort"),new PParameter("nextSpec", "hu.bme.mit.massif.simulink.BusSpecification"),new PParameter("endPortBeforeNextSpec", "hu.bme.mit.massif.simulink.OutPort"));
  }
  
  @Override
  public OutportsReachedFromBusSpecificationMatch newEmptyMatch() {
    return OutportsReachedFromBusSpecificationMatch.newEmptyMatch();
  }
  
  @Override
  public OutportsReachedFromBusSpecificationMatch newMatch(final Object... parameters) {
    return OutportsReachedFromBusSpecificationMatch.newMatch((hu.bme.mit.massif.simulink.OutPort) parameters[0], (hu.bme.mit.massif.simulink.BusSpecification) parameters[1], (hu.bme.mit.massif.simulink.OutPort) parameters[2]);
  }
  
  @Override
  public Set<PBody> doGetContainedBodies() throws IncQueryException {
    Set<PBody> bodies = Sets.newLinkedHashSet();
    {
      PBody body = new PBody(this);
      PVariable var_outPort = body.getOrCreateVariableByName("outPort");
      PVariable var_nextSpec = body.getOrCreateVariableByName("nextSpec");
      PVariable var_endPortBeforeNextSpec = body.getOrCreateVariableByName("endPortBeforeNextSpec");
      PVariable var_inPort = body.getOrCreateVariableByName("inPort");
      PVariable var__pc = body.getOrCreateVariableByName("_pc");
      body.setExportedParameters(Arrays.<ExportedParameter>asList(
        new ExportedParameter(body, var_outPort, "outPort"), 
        new ExportedParameter(body, var_nextSpec, "nextSpec"), 
        new ExportedParameter(body, var_endPortBeforeNextSpec, "endPortBeforeNextSpec")
      ));
      
      new TypeUnary(body, var_outPort, getClassifierLiteral("http://hu.bme.mit.massif/simulink/1.0", "OutPort"), "http://hu.bme.mit.massif/simulink/1.0/OutPort");
      
      new TypeUnary(body, var_nextSpec, getClassifierLiteral("http://hu.bme.mit.massif/simulink/1.0", "BusSpecification"), "http://hu.bme.mit.massif/simulink/1.0/BusSpecification");
      
      new TypeUnary(body, var_endPortBeforeNextSpec, getClassifierLiteral("http://hu.bme.mit.massif/simulink/1.0", "OutPort"), "http://hu.bme.mit.massif/simulink/1.0/OutPort");
      new BinaryTransitiveClosure(body, new FlatTuple(var_outPort, var_endPortBeforeNextSpec), SimpleConnectedOutPortQuerySpecification.instance().instance());
      new PositivePatternCall(body, new FlatTuple(var_endPortBeforeNextSpec, var_inPort, var__pc), PortConnectionQuerySpecification.instance());
      new TypeBinary(body, CONTEXT, var_nextSpec, var_inPort, getFeatureLiteral("http://hu.bme.mit.massif/simulink/1.0", "Block", "ports"), "http://hu.bme.mit.massif/simulink/1.0/Block.ports");
      bodies.add(body);
    }
    {
      PBody body = new PBody(this);
      PVariable var_outPort = body.getOrCreateVariableByName("outPort");
      PVariable var_nextSpec = body.getOrCreateVariableByName("nextSpec");
      PVariable var_inPort = body.getOrCreateVariableByName("inPort");
      PVariable var__pc = body.getOrCreateVariableByName("_pc");
      body.setExportedParameters(Arrays.<ExportedParameter>asList(
        new ExportedParameter(body, var_outPort, "outPort"), 
        new ExportedParameter(body, var_nextSpec, "nextSpec"), 
        new ExportedParameter(body, var_outPort, "endPortBeforeNextSpec")
      ));
      
      new TypeUnary(body, var_outPort, getClassifierLiteral("http://hu.bme.mit.massif/simulink/1.0", "OutPort"), "http://hu.bme.mit.massif/simulink/1.0/OutPort");
      
      new TypeUnary(body, var_nextSpec, getClassifierLiteral("http://hu.bme.mit.massif/simulink/1.0", "BusSpecification"), "http://hu.bme.mit.massif/simulink/1.0/BusSpecification");
      
      new PositivePatternCall(body, new FlatTuple(var_outPort, var_inPort, var__pc), PortConnectionQuerySpecification.instance());
      new TypeBinary(body, CONTEXT, var_nextSpec, var_inPort, getFeatureLiteral("http://hu.bme.mit.massif/simulink/1.0", "Block", "ports"), "http://hu.bme.mit.massif/simulink/1.0/Block.ports");
      bodies.add(body);
    }
    return bodies;
  }
  
  private static class LazyHolder {
    private final static OutportsReachedFromBusSpecificationQuerySpecification INSTANCE = make();
    
    public static OutportsReachedFromBusSpecificationQuerySpecification make() {
      return new OutportsReachedFromBusSpecificationQuerySpecification();					
      
    }
  }
}
