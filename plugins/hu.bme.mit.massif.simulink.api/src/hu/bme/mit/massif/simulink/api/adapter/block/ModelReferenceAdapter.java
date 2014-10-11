package hu.bme.mit.massif.simulink.api.adapter.block;

import hu.bme.mit.massif.communication.command.MatlabCommand;
import hu.bme.mit.massif.communication.command.MatlabCommandFactory;
import hu.bme.mit.massif.communication.datatype.MatlabString;
import hu.bme.mit.massif.simulink.Block;
import hu.bme.mit.massif.simulink.IdentifierReference;
import hu.bme.mit.massif.simulink.ModelReference;
import hu.bme.mit.massif.simulink.SimulinkFactory;
import hu.bme.mit.massif.simulink.SimulinkModel;
import hu.bme.mit.massif.simulink.SimulinkReference;
import hu.bme.mit.massif.simulink.SubSystem;
import hu.bme.mit.massif.simulink.api.Importer;
import hu.bme.mit.massif.simulink.api.ModelObject;
import hu.bme.mit.massif.simulink.api.exception.SimulinkApiException;
import hu.bme.mit.massif.simulink.api.util.ImportMode;
import hu.bme.mit.massif.simulink.api.util.SimulinkUtil;

import java.util.Map;

import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * Adapter class for the model reference
 */
public class ModelReferenceAdapter extends DefaultBlockAdapter {

    @Override
    public Block getBlock(Importer traverser) {
        switch (traverser.getImportMode()) {
        case FLATTENING:
            return SimulinkFactory.eINSTANCE.createSubSystem();
        default:
            return SimulinkFactory.eINSTANCE.createModelReference();
        }
    }

    @Override
    public void process(Importer traverser, SimulinkReference parentSimRef, Block blockToProcess) {
        super.process(traverser, parentSimRef, blockToProcess);

        ImportMode importMode = traverser.getImportMode();
        String modelReferenceFQN = blockToProcess.getSimulinkRef().getFQN();
        MatlabCommandFactory commandFactory = traverser.getCommandFactory();
        String referencedModelName = null;
        SimulinkModel actualReferredModel = null;
        ModelReference modelReference = (ModelReference) blockToProcess;
        
        switch (importMode) {
        case SHALLOW:
            // Set the referenced model name
        	MatlabCommand getReferencedModelName = commandFactory.getParam().addParam(modelReferenceFQN).addParam("ModelName");
            referencedModelName = MatlabString.getMatlabStringData(getReferencedModelName.execute());
            referencedModelName = handleSpecialCharacters(referencedModelName);

            String qualifier = null;
            String name = null;
            if (referencedModelName.contains("/")) {
                qualifier = referencedModelName.substring(referencedModelName.lastIndexOf('/'));
                name = referencedModelName
                        .substring(referencedModelName.lastIndexOf('/'), referencedModelName.length());
            } else {
                qualifier = "";
                name = referencedModelName;
            }
            IdentifierReference modelSimRef = SimulinkUtil.createIdentifierReference(name, qualifier);

            modelReference.setModelRef(modelSimRef);
            break;
        case REFERENCING: // fall-through
        case DEEP:
            // Create individual EMF models for the referenced models.
            try {
                actualReferredModel = traverseReferencedModel(traverser, modelReferenceFQN, commandFactory,
                        ImportMode.DEEP);
                IdentifierReference actualReferredModelSimRef = EcoreUtil.copy(actualReferredModel.getSimulinkRef());
                modelReference.setModelRef(actualReferredModelSimRef);
            } catch (SimulinkApiException e) {
                traverser.getLogger().error("Exception occurred while traversing referenced model in deep copy!", e);
            }
            break;
        case FLATTENING:
            // Import the blocks located in the referenced model to EMF
            // as though they were in the currently traversed model
            SubSystem modelReferenceSubSystem = (SubSystem) blockToProcess;
            try {
                actualReferredModel = traverseReferencedModel(traverser, modelReferenceFQN, commandFactory,
                        ImportMode.FLATTENING);
                // Set the level 0 elements of the model as the children of the SubSystem block
                // so that flattening completes
                for (Block b : actualReferredModel.getContains()) {
                    modelReferenceSubSystem.getSubBlocks().add(EcoreUtil.copy(b));
                }
            } catch (SimulinkApiException e) {
                traverser.getLogger().error("Exception occurred while traversing referenced model in flattening copy!",
                        e);
            }
            break;
        default:
            break;
        }

    }

    private SimulinkModel traverseReferencedModel(Importer traverser, String modelReferenceFQN,
            MatlabCommandFactory commandFactory, ImportMode importMode) throws SimulinkApiException {
        String referencedModelName;
        ModelObject referencedModel;
        Importer referencedModelTraverser;
        SimulinkModel actualReferredModel;
        // Fetch the referenced model's name
        MatlabCommand getReferencedModelName = commandFactory.getParam().addParam(modelReferenceFQN).addParam("ModelName");
        referencedModelName = MatlabString.getMatlabStringData(getReferencedModelName.execute());
        referencedModelName = handleSpecialCharacters(referencedModelName);

        Map<String, SimulinkModel> modelRegistry = traverser.getReferencedModels();

        if (modelRegistry.get(referencedModelName) != null) {
            return modelRegistry.get(referencedModelName);
        }

        referencedModel = new ModelObject(referencedModelName, commandFactory.getCommandEvaluator());
        referencedModelTraverser = new Importer(referencedModel);

        // Add all already referenced and imported models to the new traverser registry
        referencedModelTraverser.getReferencedModels().putAll(modelRegistry);

        // Creates an individual model
        referencedModelTraverser.traverseAndCreateEMFModel(importMode);
        actualReferredModel = referencedModelTraverser.getSimulinkModel();

        // Add back all recently traversed models to the 'referenced models' set
        modelRegistry.putAll(referencedModelTraverser.getReferencedModels());

        modelRegistry.put(actualReferredModel.getSimulinkRef().getFQN(), actualReferredModel);

        return actualReferredModel;
    }

    /**
     * Escaping characters in the return value from Matlab
     * 
     * @param referencedModelName
     * @return
     */
    private String handleSpecialCharacters(String referencedModelName) {
        String result = referencedModelName;
        if (referencedModelName.contains("/"))
            result = referencedModelName.replace("/", "//");
        if (referencedModelName.contains("\n"))
            result = referencedModelName.replace("\n", " ");
        return result;
    }

}
