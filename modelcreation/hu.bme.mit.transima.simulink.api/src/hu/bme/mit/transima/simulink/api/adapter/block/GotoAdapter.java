package hu.bme.mit.transima.simulink.api.adapter.block;

import hu.bme.mit.transima.Simulink.Block;
import hu.bme.mit.transima.Simulink.Goto;
import hu.bme.mit.transima.Simulink.SimulinkFactory;
import hu.bme.mit.transima.Simulink.SimulinkReference;
import hu.bme.mit.transima.Simulink.TagVisibility;
import hu.bme.mit.transima.simulink.api.Importer;
import hu.bme.mit.transima.simulink.communication.command.MatlabCommand;
import hu.bme.mit.transima.simulink.communication.command.MatlabCommandFactory;
import hu.bme.mit.transima.simulink.communication.datatype.CellMatlabData;
import hu.bme.mit.transima.simulink.communication.datatype.IVisitableMatlabData;
import hu.bme.mit.transima.simulink.communication.datatype.MatlabString;
import hu.bme.mit.transima.simulink.communication.datatype.StructMatlabData;

import java.util.LinkedList;
import java.util.List;

/**
 * Adapter class for the goto block
 */
public class GotoAdapter extends DefaultAdapter {

    @Override
    public Block getBlock(Importer traverser) {
        return SimulinkFactory.eINSTANCE.createGoto();
    }

    @Override
    public void process(Importer traverser, SimulinkReference parentSimRef, Block blockToProcess) {
        super.process(traverser, parentSimRef, blockToProcess);
        // TODO revisit implementation
        Goto gotoBlock = (Goto) blockToProcess;
        MatlabCommandFactory commandFactory = traverser.getCommandFactory();
        String blockName = gotoBlock.getSimulinkRef().getFQN();

        MatlabCommand getGotoTag = commandFactory.getParam().addParam(blockName).addParam("GotoTag");
        String gotoTag = MatlabString.getMatlabStringData(getGotoTag.execute());

        gotoBlock.setGotoTag(gotoTag);

        TagVisibility tagVisibility = null;

        MatlabCommand getGotoTagVisibility = commandFactory.getParam().addParam(blockName).addParam("TagVisibility");
        String tagVisibilityStr = MatlabString.getMatlabStringData(getGotoTagVisibility.execute());

        if (tagVisibilityStr.contains("local")) {
            tagVisibility = TagVisibility.LOCAL;
        } else if (tagVisibilityStr.contains("global")) {
            tagVisibility = TagVisibility.GLOBAL;
        } else if (tagVisibilityStr.contains("scoped")) {
            tagVisibility = TagVisibility.SCOPED;
        }

        gotoBlock.setTagVisibility(tagVisibility);

        List<String> fromNames = null;
        // Get the corresponding from block FQNs
        MatlabCommand getGotoHandle = commandFactory.getParam().addParam(blockName).addParam("Handle");
        IVisitableMatlabData gotoHandle = getGotoHandle.execute();

        MatlabCommand getFromsForGoto = commandFactory.get().addParam(gotoHandle).addParam("FromBlock");
        CellMatlabData fromNamesAndHandles = CellMatlabData.asCellMatlabData(getFromsForGoto.execute());
        fromNames = new LinkedList<String>();

        for (IVisitableMatlabData fromData : fromNamesAndHandles.getDatas()) {
            StructMatlabData structFromData = (StructMatlabData) fromData;
            if (structFromData == null) {
                // This means that there are no corresponding from blocks
                continue;
            }

            String fromName = MatlabString.getMatlabStringData(structFromData.getData("name"));
            fromNames.add(fromName);
        }
        traverser.getGotos().put(gotoBlock, fromNames);

        // This block is processed further during the creation of connections between blocks
    }

}
