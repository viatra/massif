package hu.bme.mit.massif.models.simulink.viewer.util;

import com.google.common.collect.Sets;
import hu.bme.mit.massif.models.simulink.viewer.BlockPortsMatch;
import hu.bme.mit.massif.models.simulink.viewer.BlockPortsMatcher;
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
 * A pattern-specific query specification that can instantiate BlockPortsMatcher in a type-safe way.
 * 
 * @see BlockPortsMatcher
 * @see BlockPortsMatch
 * 
 */
@SuppressWarnings("all")
public final class BlockPortsQuerySpecification extends BaseGeneratedQuerySpecification<BlockPortsMatcher> {
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static BlockPortsQuerySpecification instance() throws IncQueryException {
    return LazyHolder.INSTANCE;
    
  }
  
  @Override
  protected BlockPortsMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return BlockPortsMatcher.on(engine);
  }
  
  @Override
  public String getFullyQualifiedName() {
    return "hu.bme.mit.massif.models.simulink.viewer.blockPorts";
    
  }
  
  @Override
  public List<String> getParameterNames() {
    return Arrays.asList("block","port");
  }
  
  @Override
  public List<PParameter> getParameters() {
    return Arrays.asList(new PParameter("block", "hu.bme.mit.massif.simulink.Block"),new PParameter("port", "hu.bme.mit.massif.simulink.Port"));
  }
  
  @Override
  public BlockPortsMatch newEmptyMatch() {
    return BlockPortsMatch.newEmptyMatch();
  }
  
  @Override
  public BlockPortsMatch newMatch(final Object... parameters) {
    return BlockPortsMatch.newMatch((hu.bme.mit.massif.simulink.Block) parameters[0], (hu.bme.mit.massif.simulink.Port) parameters[1]);
  }
  
  @Override
  public Set<PBody> doGetContainedBodies() throws IncQueryException {
    Set<PBody> bodies = Sets.newLinkedHashSet();
    {
      PBody body = new PBody(this);
      PVariable var_block = body.getOrCreateVariableByName("block");
      PVariable var_port = body.getOrCreateVariableByName("port");
      body.setExportedParameters(Arrays.<ExportedParameter>asList(
        new ExportedParameter(body, var_block, "block"), 
        new ExportedParameter(body, var_port, "port")
      ));
      
      
      new TypeBinary(body, CONTEXT, var_block, var_port, getFeatureLiteral("http://hu.bme.mit.massif/simulink/1.0", "Block", "ports"), "http://hu.bme.mit.massif/simulink/1.0/Block.ports");
      bodies.add(body);
    }
    return bodies;
  }
  
  private static class LazyHolder {
    private final static BlockPortsQuerySpecification INSTANCE = make();
    
    public static BlockPortsQuerySpecification make() {
      return new BlockPortsQuerySpecification();					
      
    }
  }
}
