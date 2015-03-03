package hu.bme.mit.massif.models.simulink.viewer;

import hu.bme.mit.massif.models.simulink.viewer.BlockMatcher;
import hu.bme.mit.massif.models.simulink.viewer.BlockPortsMatcher;
import hu.bme.mit.massif.models.simulink.viewer.BusSignalMappingSourceMatcher;
import hu.bme.mit.massif.models.simulink.viewer.EmptySubSystemMatcher;
import hu.bme.mit.massif.models.simulink.viewer.FromBlocksMatcher;
import hu.bme.mit.massif.models.simulink.viewer.GotoBlocksMatcher;
import hu.bme.mit.massif.models.simulink.viewer.GotoConnectionMatcher;
import hu.bme.mit.massif.models.simulink.viewer.HierarchyConnectionEndMatcher;
import hu.bme.mit.massif.models.simulink.viewer.HierarchyConnectionMatcher;
import hu.bme.mit.massif.models.simulink.viewer.IgnoredBlockMatcher;
import hu.bme.mit.massif.models.simulink.viewer.NonNullLineNameMatcher;
import hu.bme.mit.massif.models.simulink.viewer.PortBlockMatcher;
import hu.bme.mit.massif.models.simulink.viewer.PortOfPortBlockMatcher;
import hu.bme.mit.massif.models.simulink.viewer.PortOfSimpleBlockMatcher;
import hu.bme.mit.massif.models.simulink.viewer.PortToPortConnectionMatcher;
import hu.bme.mit.massif.models.simulink.viewer.SubBlocksMatcher;
import hu.bme.mit.massif.models.simulink.viewer.SubSystemMatcher;
import hu.bme.mit.massif.models.simulink.viewer.util.BlockPortsQuerySpecification;
import hu.bme.mit.massif.models.simulink.viewer.util.BlockQuerySpecification;
import hu.bme.mit.massif.models.simulink.viewer.util.BusSignalMappingSourceQuerySpecification;
import hu.bme.mit.massif.models.simulink.viewer.util.EmptySubSystemQuerySpecification;
import hu.bme.mit.massif.models.simulink.viewer.util.FromBlocksQuerySpecification;
import hu.bme.mit.massif.models.simulink.viewer.util.GotoBlocksQuerySpecification;
import hu.bme.mit.massif.models.simulink.viewer.util.GotoConnectionQuerySpecification;
import hu.bme.mit.massif.models.simulink.viewer.util.HierarchyConnectionEndQuerySpecification;
import hu.bme.mit.massif.models.simulink.viewer.util.HierarchyConnectionQuerySpecification;
import hu.bme.mit.massif.models.simulink.viewer.util.IgnoredBlockQuerySpecification;
import hu.bme.mit.massif.models.simulink.viewer.util.NonNullLineNameQuerySpecification;
import hu.bme.mit.massif.models.simulink.viewer.util.PortBlockQuerySpecification;
import hu.bme.mit.massif.models.simulink.viewer.util.PortOfPortBlockQuerySpecification;
import hu.bme.mit.massif.models.simulink.viewer.util.PortOfSimpleBlockQuerySpecification;
import hu.bme.mit.massif.models.simulink.viewer.util.PortToPortConnectionQuerySpecification;
import hu.bme.mit.massif.models.simulink.viewer.util.SubBlocksQuerySpecification;
import hu.bme.mit.massif.models.simulink.viewer.util.SubSystemQuerySpecification;
import org.eclipse.incquery.runtime.api.IncQueryEngine;
import org.eclipse.incquery.runtime.api.impl.BaseGeneratedPatternGroup;
import org.eclipse.incquery.runtime.exception.IncQueryException;

/**
 * A pattern group formed of all patterns defined in simulinkViewer.eiq.
 * 
 * <p>Use the static instance as any {@link org.eclipse.incquery.runtime.api.IPatternGroup}, to conveniently prepare
 * an EMF-IncQuery engine for matching all patterns originally defined in file simulinkViewer.eiq,
 * in order to achieve better performance than one-by-one on-demand matcher initialization.
 * 
 * <p> From package hu.bme.mit.massif.models.simulink.viewer, the group contains the definition of the following patterns: <ul>
 * <li>portOfPortBlock</li>
 * <li>portBlock</li>
 * <li>blockPorts</li>
 * <li>portOfSimpleBlock</li>
 * <li>ignoredBlock</li>
 * <li>block</li>
 * <li>fromBlocks</li>
 * <li>gotoBlocks</li>
 * <li>subSystem</li>
 * <li>emptySubSystem</li>
 * <li>subBlocks</li>
 * <li>nonNullLineName</li>
 * <li>portToPortConnection</li>
 * <li>gotoConnection</li>
 * <li>hierarchyConnection</li>
 * <li>hierarchyConnectionEnd</li>
 * <li>busSignalMappingSource</li>
 * </ul>
 * 
 * @see IPatternGroup
 * 
 */
@SuppressWarnings("all")
public final class SimulinkViewer extends BaseGeneratedPatternGroup {
  /**
   * Access the pattern group.
   * 
   * @return the singleton instance of the group
   * @throws IncQueryException if there was an error loading the generated code of pattern specifications
   * 
   */
  public static SimulinkViewer instance() throws IncQueryException {
    if (INSTANCE == null) {
    	INSTANCE = new SimulinkViewer();
    }
    return INSTANCE;
  }
  
  private static SimulinkViewer INSTANCE;
  
  private SimulinkViewer() throws IncQueryException {
    querySpecifications.add(PortOfPortBlockQuerySpecification.instance());
    querySpecifications.add(PortBlockQuerySpecification.instance());
    querySpecifications.add(BlockPortsQuerySpecification.instance());
    querySpecifications.add(PortOfSimpleBlockQuerySpecification.instance());
    querySpecifications.add(IgnoredBlockQuerySpecification.instance());
    querySpecifications.add(BlockQuerySpecification.instance());
    querySpecifications.add(FromBlocksQuerySpecification.instance());
    querySpecifications.add(GotoBlocksQuerySpecification.instance());
    querySpecifications.add(SubSystemQuerySpecification.instance());
    querySpecifications.add(EmptySubSystemQuerySpecification.instance());
    querySpecifications.add(SubBlocksQuerySpecification.instance());
    querySpecifications.add(NonNullLineNameQuerySpecification.instance());
    querySpecifications.add(PortToPortConnectionQuerySpecification.instance());
    querySpecifications.add(GotoConnectionQuerySpecification.instance());
    querySpecifications.add(HierarchyConnectionQuerySpecification.instance());
    querySpecifications.add(HierarchyConnectionEndQuerySpecification.instance());
    querySpecifications.add(BusSignalMappingSourceQuerySpecification.instance());
  }
  
  public PortOfPortBlockQuerySpecification getPortOfPortBlock() throws IncQueryException {
    return PortOfPortBlockQuerySpecification.instance();
  }
  
  public PortOfPortBlockMatcher getPortOfPortBlock(final IncQueryEngine engine) throws IncQueryException {
    return PortOfPortBlockMatcher.on(engine);
  }
  
  public PortBlockQuerySpecification getPortBlock() throws IncQueryException {
    return PortBlockQuerySpecification.instance();
  }
  
  public PortBlockMatcher getPortBlock(final IncQueryEngine engine) throws IncQueryException {
    return PortBlockMatcher.on(engine);
  }
  
  public BlockPortsQuerySpecification getBlockPorts() throws IncQueryException {
    return BlockPortsQuerySpecification.instance();
  }
  
  public BlockPortsMatcher getBlockPorts(final IncQueryEngine engine) throws IncQueryException {
    return BlockPortsMatcher.on(engine);
  }
  
  public PortOfSimpleBlockQuerySpecification getPortOfSimpleBlock() throws IncQueryException {
    return PortOfSimpleBlockQuerySpecification.instance();
  }
  
  public PortOfSimpleBlockMatcher getPortOfSimpleBlock(final IncQueryEngine engine) throws IncQueryException {
    return PortOfSimpleBlockMatcher.on(engine);
  }
  
  public IgnoredBlockQuerySpecification getIgnoredBlock() throws IncQueryException {
    return IgnoredBlockQuerySpecification.instance();
  }
  
  public IgnoredBlockMatcher getIgnoredBlock(final IncQueryEngine engine) throws IncQueryException {
    return IgnoredBlockMatcher.on(engine);
  }
  
  public BlockQuerySpecification getBlock() throws IncQueryException {
    return BlockQuerySpecification.instance();
  }
  
  public BlockMatcher getBlock(final IncQueryEngine engine) throws IncQueryException {
    return BlockMatcher.on(engine);
  }
  
  public FromBlocksQuerySpecification getFromBlocks() throws IncQueryException {
    return FromBlocksQuerySpecification.instance();
  }
  
  public FromBlocksMatcher getFromBlocks(final IncQueryEngine engine) throws IncQueryException {
    return FromBlocksMatcher.on(engine);
  }
  
  public GotoBlocksQuerySpecification getGotoBlocks() throws IncQueryException {
    return GotoBlocksQuerySpecification.instance();
  }
  
  public GotoBlocksMatcher getGotoBlocks(final IncQueryEngine engine) throws IncQueryException {
    return GotoBlocksMatcher.on(engine);
  }
  
  public SubSystemQuerySpecification getSubSystem() throws IncQueryException {
    return SubSystemQuerySpecification.instance();
  }
  
  public SubSystemMatcher getSubSystem(final IncQueryEngine engine) throws IncQueryException {
    return SubSystemMatcher.on(engine);
  }
  
  public EmptySubSystemQuerySpecification getEmptySubSystem() throws IncQueryException {
    return EmptySubSystemQuerySpecification.instance();
  }
  
  public EmptySubSystemMatcher getEmptySubSystem(final IncQueryEngine engine) throws IncQueryException {
    return EmptySubSystemMatcher.on(engine);
  }
  
  public SubBlocksQuerySpecification getSubBlocks() throws IncQueryException {
    return SubBlocksQuerySpecification.instance();
  }
  
  public SubBlocksMatcher getSubBlocks(final IncQueryEngine engine) throws IncQueryException {
    return SubBlocksMatcher.on(engine);
  }
  
  public NonNullLineNameQuerySpecification getNonNullLineName() throws IncQueryException {
    return NonNullLineNameQuerySpecification.instance();
  }
  
  public NonNullLineNameMatcher getNonNullLineName(final IncQueryEngine engine) throws IncQueryException {
    return NonNullLineNameMatcher.on(engine);
  }
  
  public PortToPortConnectionQuerySpecification getPortToPortConnection() throws IncQueryException {
    return PortToPortConnectionQuerySpecification.instance();
  }
  
  public PortToPortConnectionMatcher getPortToPortConnection(final IncQueryEngine engine) throws IncQueryException {
    return PortToPortConnectionMatcher.on(engine);
  }
  
  public GotoConnectionQuerySpecification getGotoConnection() throws IncQueryException {
    return GotoConnectionQuerySpecification.instance();
  }
  
  public GotoConnectionMatcher getGotoConnection(final IncQueryEngine engine) throws IncQueryException {
    return GotoConnectionMatcher.on(engine);
  }
  
  public HierarchyConnectionQuerySpecification getHierarchyConnection() throws IncQueryException {
    return HierarchyConnectionQuerySpecification.instance();
  }
  
  public HierarchyConnectionMatcher getHierarchyConnection(final IncQueryEngine engine) throws IncQueryException {
    return HierarchyConnectionMatcher.on(engine);
  }
  
  public HierarchyConnectionEndQuerySpecification getHierarchyConnectionEnd() throws IncQueryException {
    return HierarchyConnectionEndQuerySpecification.instance();
  }
  
  public HierarchyConnectionEndMatcher getHierarchyConnectionEnd(final IncQueryEngine engine) throws IncQueryException {
    return HierarchyConnectionEndMatcher.on(engine);
  }
  
  public BusSignalMappingSourceQuerySpecification getBusSignalMappingSource() throws IncQueryException {
    return BusSignalMappingSourceQuerySpecification.instance();
  }
  
  public BusSignalMappingSourceMatcher getBusSignalMappingSource(final IncQueryEngine engine) throws IncQueryException {
    return BusSignalMappingSourceMatcher.on(engine);
  }
}
