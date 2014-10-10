package hu.bme.mit.transima.simulink.api.layout;

import hu.bme.mit.transima.Simulink.Block;
import hu.bme.mit.transima.Simulink.BusSpecification;
import hu.bme.mit.transima.Simulink.From;
import hu.bme.mit.transima.Simulink.Goto;
import hu.bme.mit.transima.Simulink.InPortBlock;
import hu.bme.mit.transima.Simulink.OutPortBlock;
import hu.bme.mit.transima.simulink.api.util.Point;

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
