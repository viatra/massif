/*******************************************************************************
 * Copyright (c) 2010-2019, IncQuery Labs Ltd.
 * All rights reserved. This program and the accompanying materials 
 * are made available under the terms of the Eclipse Public License v1.0 
 * which accompanies this distribution, and is available at 
 * http://www.eclipse.org/legal/epl-v10.html 
 *
 * Contributors: 
 *     Dénes Harmath - initial API and implementation 
 *******************************************************************************/
package hu.bme.mit.massif.simulink.layout.elk;

import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.eclipse.elk.alg.layered.options.LayeredMetaDataProvider;
import org.eclipse.elk.alg.layered.options.LayeredOptions;
import org.eclipse.elk.core.RecursiveGraphLayoutEngine;
import org.eclipse.elk.core.data.LayoutMetaDataService;
import org.eclipse.elk.core.options.CoreOptions;
import org.eclipse.elk.core.options.Direction;
import org.eclipse.elk.core.util.BasicProgressMonitor;
import org.eclipse.elk.graph.ElkConnectableShape;
import org.eclipse.elk.graph.ElkEdge;
import org.eclipse.elk.graph.ElkNode;
import org.eclipse.elk.graph.properties.IProperty;
import org.eclipse.elk.graph.properties.Property;
import org.eclipse.elk.graph.util.ElkGraphUtil;

import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Iterables;

import hu.bme.mit.massif.simulink.Block;
import hu.bme.mit.massif.simulink.Connection;
import hu.bme.mit.massif.simulink.MultiConnection;
import hu.bme.mit.massif.simulink.OutPort;
import hu.bme.mit.massif.simulink.SingleConnection;
import hu.bme.mit.massif.simulink.api.layout.BlockLayoutSpecification;
import hu.bme.mit.massif.simulink.api.layout.IExporterLayoutProvider;
import hu.bme.mit.massif.simulink.api.util.Point;

/**
 * Automatic layout provider using ELK.
 */
public class ElkLayoutProvider implements IExporterLayoutProvider {

    public ElkLayoutProvider() {
        LayoutMetaDataService.getInstance().registerLayoutMetaDataProviders(new LayeredMetaDataProvider());
    }
    
    @Override
    public void updateSpecifications(Map<Block, BlockLayoutSpecification> layout) {
        ElkNode graph = createGraph(layout.keySet());
        layout(graph);
        layout.putAll(getSpecifications(graph));
    }

    private static ElkNode createGraph(Set<Block> blocks) {
        ElkNode graph = ElkGraphUtil.createGraph();
        
        graph.setProperty(CoreOptions.ALGORITHM, LayeredOptions.ALGORITHM_ID);
        
        graph.setProperty(CoreOptions.DIRECTION, Direction.RIGHT);
        
        Collection<ElkNode> nodes = blocks.stream().map(block -> createNode(block, graph)).collect(Collectors.toSet());

        for (Block block : blocks) {
            for (OutPort outPort : block.getOutports()) {
                createEdge(outPort.getConnection(), nodes);
            }
        }
        
        return graph;
    }

    private final static IProperty<Block> BLOCK = new Property<Block>("hu.bme.mit.massif.simulink.layout.elk.block");

    private static ElkNode createNode(Block block, ElkNode graph) {
        ElkNode node = ElkGraphUtil.createNode(graph);
        node.setProperty(BLOCK, block);
        node.setWidth(10);
        node.setHeight(10);
        return node;
    }
    
    private static ElkEdge createEdge(Connection connection, Iterable<ElkNode> nodes) {
        Iterable<ElkNode> sources = findNodes(connection.getFrom().getContainer(), nodes);
        Collection<ElkConnectableShape> sourcePorts = createPorts(sources);
        
        Iterable<Block> targetBlocks = Iterables.transform(getSingleConnections(connection), ElkLayoutProvider::getTarget);
        Iterable<ElkNode> targets = Iterables.concat(Iterables.transform(targetBlocks, target -> findNodes(target, nodes)));
        Collection<ElkConnectableShape> targetPorts = createPorts(targets);
        
        return ElkGraphUtil.createHyperedge(sourcePorts, targetPorts);
    }

    private static Collection<ElkConnectableShape> createPorts(Iterable<ElkNode> targets) {
        return ImmutableSet.copyOf(Iterables.transform(targets, ElkGraphUtil::createPort));
    }
    
    public static Iterable<SingleConnection> getSingleConnections(Connection connection) {
        if (connection instanceof SingleConnection) {
            SingleConnection singleConnection = (SingleConnection) connection;
            return ImmutableSet.of(singleConnection);
        } else if (connection instanceof MultiConnection) {
            MultiConnection multiConnection = (MultiConnection) connection;
            return multiConnection.getConnections();
        } else {
            return ImmutableSet.of();
        }
    }
    
    public static Block getTarget(SingleConnection singleConnection) {
        return singleConnection.getTo().getContainer();
    }

    private static Iterable<ElkNode> findNodes(Block block, Iterable<ElkNode> nodes) {
        return Iterables.filter(nodes, node -> getBlock(node) == block);
    }

    private static Block getBlock(ElkNode node) {
        return node.getProperty(BLOCK);
    }

    private static void layout(ElkNode graph) {
        new RecursiveGraphLayoutEngine().layout(graph, new BasicProgressMonitor());
    }

    private static Map<Block, BlockLayoutSpecification> getSpecifications(ElkNode graph) {
        return graph.getChildren().stream().collect(Collectors.toMap(ElkLayoutProvider::getBlock, ElkLayoutProvider::getSpecification));
    }
    
    private static BlockLayoutSpecification getSpecification(ElkNode node) {
        BlockLayoutSpecification specification = new BlockLayoutSpecification();
        specification.topLeft = new Point(node.getX(), node.getY());
        specification.width = node.getWidth();
        specification.height = node.getHeight();
        return specification;
    }
    
}
