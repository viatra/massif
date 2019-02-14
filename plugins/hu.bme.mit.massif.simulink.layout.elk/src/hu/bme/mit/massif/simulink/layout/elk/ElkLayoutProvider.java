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
import java.util.stream.Stream;

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
import org.eclipse.elk.graph.util.ElkGraphUtil;

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
        ElkNode graph = createEmptyGraph();
        Set<Block> blocks = layout.keySet();
        Map<Block, ElkNode> nodes = createNodes(blocks, graph);
        createEdges(blocks, nodes);
        layout(graph);
        layout.putAll(getSpecifications(nodes));
    }

    private static ElkNode createEmptyGraph() {
        ElkNode graph = ElkGraphUtil.createGraph();
        graph.setProperty(CoreOptions.ALGORITHM, LayeredOptions.ALGORITHM_ID);
        graph.setProperty(CoreOptions.DIRECTION, Direction.RIGHT);
        return graph;
    }

    private static Map<Block, ElkNode> createNodes(Set<Block> blocks, ElkNode graph) {
        return blocks.stream().collect(Collectors.toMap(block -> block, block -> createNode(graph)));
    }

    private static void createEdges(Set<Block> blocks, Map<Block, ElkNode> nodes) {
        for (Block block : blocks) {
            for (OutPort outPort : block.getOutports()) {
                if (outPort.getConnection() != null) {
                    createEdge(outPort.getConnection(), nodes);
                }
            }
        }
    }
    
    private static ElkNode createNode(ElkNode graph) {
        ElkNode node = ElkGraphUtil.createNode(graph);
        node.setWidth(10);
        node.setHeight(10);
        return node;
    }
    
    private static ElkEdge createEdge(Connection connection, Map<Block, ElkNode> nodes) {
        ElkNode source = nodes.get(getSource(connection));
        Stream<ElkNode> sources = Stream.of(source).filter(it -> it != null);
        Collection<ElkConnectableShape> sourcePorts = createPorts(sources);
        
        Stream<Block> targetBlocks = getSingleConnections(connection).map(ElkLayoutProvider::getTarget);
        Stream<ElkNode> targets = targetBlocks.map(target -> nodes.get(target)).filter(it -> it != null);
        Collection<ElkConnectableShape> targetPorts = createPorts(targets);
        
        return ElkGraphUtil.createHyperedge(sourcePorts, targetPorts);
    }

    private static Block getSource(Connection connection) {
        return connection.getFrom().getContainer();
    }

    private static Collection<ElkConnectableShape> createPorts(Stream<ElkNode> nodes) {
        return nodes.map(ElkGraphUtil::createPort).collect(Collectors.toSet());
    }
    
    public static Stream<SingleConnection> getSingleConnections(Connection connection) {
        if (connection instanceof SingleConnection) {
            SingleConnection singleConnection = (SingleConnection) connection;
            return Stream.of(singleConnection);
        } else if (connection instanceof MultiConnection) {
            MultiConnection multiConnection = (MultiConnection) connection;
            return multiConnection.getConnections().stream();
        } else {
            return Stream.of();
        }
    }
    
    public static Block getTarget(SingleConnection singleConnection) {
        return singleConnection.getTo().getContainer();
    }

    private static void layout(ElkNode graph) {
        new RecursiveGraphLayoutEngine().layout(graph, new BasicProgressMonitor());
    }

    private static Map<Block, BlockLayoutSpecification> getSpecifications(Map<Block, ElkNode> nodes) {
        return nodes.entrySet().stream().collect(Collectors.toMap(it -> it.getKey(), it -> ElkLayoutProvider.getSpecification(it.getValue())));
    }
    
    private static BlockLayoutSpecification getSpecification(ElkNode node) {
        BlockLayoutSpecification specification = new BlockLayoutSpecification();
        specification.topLeft = new Point(node.getX(), node.getY());
        specification.width = node.getWidth();
        specification.height = node.getHeight();
        return specification;
    }
    
}
