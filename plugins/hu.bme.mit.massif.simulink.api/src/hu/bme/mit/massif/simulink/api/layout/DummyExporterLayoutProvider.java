/*******************************************************************************
 * Copyright (c) 2010-2013, Embraer S.A., Budapest University of Technology and Economics
 * All rights reserved. This program and the accompanying materials 
 * are made available under the terms of the Eclipse Public License v1.0 
 * which accompanies this distribution, and is available at 
 * http://www.eclipse.org/legal/epl-v10.html 
 *
 * Contributors: 
 *     Marton Bur, Abel Hegedus, Akos Horvath - initial API and implementation 
 *******************************************************************************/
package hu.bme.mit.massif.simulink.api.layout;

import hu.bme.mit.massif.simulink.Block;
import hu.bme.mit.massif.simulink.BusSpecification;
import hu.bme.mit.massif.simulink.From;
import hu.bme.mit.massif.simulink.Goto;
import hu.bme.mit.massif.simulink.InPortBlock;
import hu.bme.mit.massif.simulink.OutPortBlock;
import hu.bme.mit.massif.simulink.api.util.Point;

import java.util.Map;

public class DummyExporterLayoutProvider implements IExporterLayoutProvider {
    
    @Override
    public void updateSpecifications(Map<Block, BlockLayoutSpecification> bls) {
        double[] columnHeight = { 10, 10, 10, 10, 10 };
        double[] maxWidth = { 0, 0, 0, 0, 0 };
        double[] blockWidth = { 0, 0, 0, 0, 0 };
        double space = 40;

        for (Map.Entry<Block, BlockLayoutSpecification> entry : bls.entrySet()) {
            Block block = entry.getKey();
            BlockType blockType = getBlockType(block);

            int columnIndex = getColumnForType(blockType);
            if (maxWidth[columnIndex] < entry.getValue().width) {
                maxWidth[columnIndex] = entry.getValue().width;
            }
        }
        
        blockWidth[0] = space;
        blockWidth[1] = blockWidth[0] + maxWidth[0] + space;
        blockWidth[2] = blockWidth[1] + maxWidth[1] + space;
        blockWidth[3] = blockWidth[2] + maxWidth[2] + space;
        blockWidth[4] = blockWidth[3] + maxWidth[3] + space;
        
        for (Map.Entry<Block, BlockLayoutSpecification> entry : bls.entrySet()) {
            Block block = entry.getKey();
            BlockType blockType = getBlockType(block);

            int columnIndex = getColumnForType(blockType);
            double height = entry.getValue().height;
            double bottom = columnHeight[columnIndex];
            columnHeight[columnIndex] += height + 30.0;
            // double left = columnIndex * 200;
            double left = blockWidth[columnIndex];
            entry.getValue().topLeft = new Point(left, bottom);
        }
        
    }

    private int getColumnForType(BlockType blockType) {
        return blockType.column;
    }

    private BlockType getBlockType(Block block) {
        BlockType blockType = BlockType.OTHER;
        if(block instanceof InPortBlock){
            blockType = BlockType.INPORTBLOCK;
        } else if(block instanceof OutPortBlock){
            blockType = BlockType.OUTPORTBLOCK;
        } else if (block instanceof From) {
            blockType = BlockType.FROM;
        } else if (block instanceof Goto) {
            blockType = BlockType.GOTO;
        } else if (block instanceof BusSpecification) {
            blockType = BlockType.BUS_SPEC;
        }
        return blockType;
    }

    enum BlockType{

        INPORTBLOCK(0, 30, 15), OUTPORTBLOCK(4, 30, 15), FROM(1, 100, 30), GOTO(3, 100, 30), BUS_SPEC(2, 10, 30), OTHER(
                2, 100, 200);

        int column;
        int width;
        int height;

        BlockType(int col, int w, int h) {
            column = col;
            width = w;
            height = h;
        }

    }
}
