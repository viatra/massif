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
package hu.bme.mit.massif.simulink.layout.elk.tests;

import java.io.File;
import java.util.Comparator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.graphics.ImageLoader;
import org.eclipse.swt.widgets.Display;
import org.eclipse.viatra.query.runtime.api.ViatraQueryEngineOptions;
import org.eclipse.viatra.query.runtime.localsearch.matcher.integration.LocalSearchEMFBackendFactory;
import org.eclipse.viatra.query.runtime.rete.matcher.ReteBackendFactory;
import org.junit.BeforeClass;
import org.junit.Test;

import hu.bme.mit.massif.simulink.Block;
import hu.bme.mit.massif.simulink.InPort;
import hu.bme.mit.massif.simulink.OutPort;
import hu.bme.mit.massif.simulink.SimulinkFactory;
import hu.bme.mit.massif.simulink.SingleConnection;
import hu.bme.mit.massif.simulink.SubSystem;
import hu.bme.mit.massif.simulink.api.layout.BlockLayoutSpecification;
import hu.bme.mit.massif.simulink.layout.elk.ElkLayoutProvider;

public class ElkLayoutProviderTest {

    @BeforeClass
    public static void init() {
        // Workaround for running with tycho-surefire-plugin
        ViatraQueryEngineOptions.setSystemDefaultBackends(ReteBackendFactory.INSTANCE, ReteBackendFactory.INSTANCE, LocalSearchEMFBackendFactory.INSTANCE);
    }
    
    private static final SimulinkFactory FACTORY = SimulinkFactory.eINSTANCE;

    @Test
    public void oneBlock() {
        SubSystem subSystem = FACTORY.createSubSystem();
        createBlock(subSystem);
        test("one block", subSystem);
    }

    @Test
    public void twoBlocks() {
        SubSystem subSystem = FACTORY.createSubSystem();
        createBlock(subSystem);
        createBlock(subSystem);
        test("two blocks", subSystem);
    }
    
    @Test
    public void oneSourceOneTarget() {
        SubSystem subSystem = FACTORY.createSubSystem();
        Block source = createBlock(subSystem);
        Block target = createBlock(subSystem);
        connect(source, target);
        test("one source, one target", subSystem);
    }
    
    @Test
    public void oneSourceTwoTargets() {
        SubSystem subSystem = FACTORY.createSubSystem();
        Block source = createBlock(subSystem);
        Block target1 = createBlock(subSystem);
        connect(source, target1);
        Block target2 = createBlock(subSystem);
        connect(source, target2);
        test("one source, two targets", subSystem);
    }
    
    @Test
    public void twoSourcesOneTarget() {
        SubSystem subSystem = FACTORY.createSubSystem();
        Block source1 = createBlock(subSystem);
        Block source2 = createBlock(subSystem);
        Block target = createBlock(subSystem);
        connect(source1, target);
        connect(source2, target);
        test("two sources, one target", subSystem);
    }
    
    @Test
    public void threeLevels() {
        SubSystem subSystem = FACTORY.createSubSystem();
        Block a = createBlock(subSystem);
        Block aa = createBlock(subSystem);
        connect(a, aa);
        Block ab = createBlock(subSystem);
        connect(a, ab);
        Block aaa = createBlock(subSystem);
        connect(aa, aaa);
        Block aab = createBlock(subSystem);
        connect(aa, aab);
        Block aba = createBlock(subSystem);
        connect(ab, aba);
        Block abb = createBlock(subSystem);
        connect(ab, abb);
        test("three levels", subSystem);
    }
    
    private Block createBlock(SubSystem subSystem) {
        Block block = FACTORY.createBlock();
        subSystem.getSubBlocks().add(block);
        return block;
    }
    
    private void connect(Block source, Block target) {
        OutPort outPort = FACTORY.createOutPort();
        source.getPorts().add(outPort);
        
        InPort inPort = FACTORY.createInPort();
        target.getPorts().add(inPort);
        
        SingleConnection connection = FACTORY.createSingleConnection();
        connection.setFrom(outPort);
        connection.setTo(inPort);
        
        outPort.setConnection(connection);
    }

    private void test(String name, SubSystem subSystem) {
        Map<Block, BlockLayoutSpecification> layout = subSystem.getSubBlocks().stream().collect(Collectors.toMap(Function.identity(), it -> new BlockLayoutSpecification()));
        new ElkLayoutProvider(10, 20, 40).updateSpecifications(layout);
        render(name, subSystem, layout);
    }

    private void render(String name, SubSystem subSystem, Map<Block, BlockLayoutSpecification> layout) {
        Image image = new Image(Display.getDefault(), (int)getRight(layout) + 1, (int)getBottom(layout) + 1);
        GC gc = new GC(image);
        
        gc.setBackground(Display.getDefault().getSystemColor(SWT.COLOR_WHITE));
        gc.fillRectangle(image.getBounds());
        gc.setForeground(Display.getDefault().getSystemColor(SWT.COLOR_BLACK));
        
        // Nodes
        for (BlockLayoutSpecification specification : layout.values()) {
            gc.drawRectangle((int)specification.topLeft.x, (int)specification.topLeft.y, (int)specification.width, (int)specification.height);
        }
        
        // Edges
        for (Entry<Block, BlockLayoutSpecification> entry : layout.entrySet()) {
            Block source = entry.getKey();
            BlockLayoutSpecification sourceSpecification = entry.getValue();
            for (OutPort outPort : source.getOutports()) {
                for (SingleConnection singleConnection : ElkLayoutProvider.getSingleConnections(outPort.getConnection()).collect(Collectors.toSet())) {
                    Block target = ElkLayoutProvider.getTarget(singleConnection);
                    double sourceRight = sourceSpecification.topLeft.x + sourceSpecification.width;
                    double sourceMiddle = sourceSpecification.topLeft.y + sourceSpecification.height / 2;
                    BlockLayoutSpecification targetSpecification = layout.get(target);
                    double targetLeft = targetSpecification.topLeft.x;
                    double targetMiddle = targetSpecification.topLeft.y + targetSpecification.height / 2;
                    gc.drawLine((int)sourceRight, (int)sourceMiddle, (int)targetLeft, (int)targetMiddle);
                }
            }
        }
        
        ImageLoader loader = new ImageLoader();
        loader.data = new ImageData[] {image.getImageData()};
        File directory = new File("results");
        directory.mkdirs();
        loader.save(new File(directory, name + ".png").getAbsolutePath(), SWT.IMAGE_PNG);
        
        gc.dispose();
        image.dispose();
    }
    
    private double getRight(Map<Block, BlockLayoutSpecification> layout) {
        return layout.values().stream().map(specification -> specification.topLeft.x + specification.width).max(Comparator.naturalOrder()).orElse(0d);
    }
    
    private double getBottom(Map<Block, BlockLayoutSpecification> layout) {
        return layout.values().stream().map(specification -> specification.topLeft.y + specification.height).max(Comparator.naturalOrder()).orElse(0d);
    }

}
