package hu.bme.mit.transima.simulink.api.adapter.block;

import hu.bme.mit.transima.Simulink.Block;
import hu.bme.mit.transima.Simulink.GotoTagVisibility;
import hu.bme.mit.transima.Simulink.SimulinkFactory;
import hu.bme.mit.transima.Simulink.SimulinkReference;
import hu.bme.mit.transima.simulink.api.Importer;
import hu.bme.mit.transima.simulink.communication.command.MatlabCommand;
import hu.bme.mit.transima.simulink.communication.command.MatlabCommandFactory;
import hu.bme.mit.transima.simulink.communication.datatype.MatlabString;

import java.util.LinkedList;
import java.util.List;

/**
 * Adapter class for the goto tag visibility blocks
 */
public class GotoTagVisibilityAdapter extends DefaultAdapter {

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
