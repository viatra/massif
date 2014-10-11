package hu.bme.mit.massif.simulink.api.adapter.block;

import hu.bme.mit.massif.communication.command.MatlabCommand;
import hu.bme.mit.massif.communication.command.MatlabCommandFactory;
import hu.bme.mit.massif.communication.datatype.MatlabString;
import hu.bme.mit.massif.simulink.Block;
import hu.bme.mit.massif.simulink.GotoTagVisibility;
import hu.bme.mit.massif.simulink.SimulinkFactory;
import hu.bme.mit.massif.simulink.SimulinkReference;
import hu.bme.mit.massif.simulink.api.Importer;

import java.util.LinkedList;
import java.util.List;

/**
 * Adapter class for the goto tag visibility blocks
 */
public class GotoTagVisibilityAdapter extends DefaultBlockAdapter {

    @Override
    public Block getBlock(Importer traverser) {
        return SimulinkFactory.eINSTANCE.createGotoTagVisibility();
    }

    @Override
    public void process(Importer traverser, SimulinkReference parentSimRef, Block blockToProcess) {
        super.process(traverser, parentSimRef, blockToProcess);

        GotoTagVisibility gotoTagVisibilityBlock = (GotoTagVisibility) blockToProcess;
        String blockFQN = gotoTagVisibilityBlock.getSimulinkRef().getFQN();

        MatlabCommandFactory commandFactory = traverser.getCommandFactory();        

        MatlabCommand getGotoTag = commandFactory.getParam().addParam(blockFQN).addParam("GotoTag");
        String gotoTag = MatlabString.getMatlabStringData(getGotoTag.execute());

        List<GotoTagVisibility> gotoTagVisibilitiesList = traverser.getGotoTagVisibilities().get(gotoTag);
        if(gotoTagVisibilitiesList == null){
            gotoTagVisibilitiesList = new LinkedList<GotoTagVisibility>();
            traverser.getGotoTagVisibilities().put(gotoTag,gotoTagVisibilitiesList);
        }
         
        gotoTagVisibilitiesList.add(gotoTagVisibilityBlock);
        
        // This block is processed further during the creation of connections between blocks
    }

}
