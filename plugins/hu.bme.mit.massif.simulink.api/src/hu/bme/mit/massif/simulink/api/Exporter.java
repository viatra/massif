/*******************************************************************************
 * Copyright (c) 2010-2017, IncQuery Labs Ltd., Embraer S.A., Budapest University of Technology and Economics
 * All rights reserved. This program and the accompanying materials 
 * are made available under the terms of the Eclipse Public License v1.0 
 * which accompanies this distribution, and is available at 
 * http://www.eclipse.org/legal/epl-v10.html 
 *
 * Contributors: 
 *     Peter Lunk - Modified API to allow custom Logger definition
 *     Marton Bur, Abel Hegedus, Akos Horvath - initial API and implementation 
 *******************************************************************************/
package hu.bme.mit.massif.simulink.api;

import java.io.File;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.BasicExtendedMetaData;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.ExtendedMetaData;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

import com.google.common.base.Strings;
import com.google.common.collect.Sets;

import hu.bme.mit.massif.communication.command.MatlabCommand;
import hu.bme.mit.massif.communication.command.MatlabCommandFactory;
import hu.bme.mit.massif.communication.datatype.CellMatlabData;
import hu.bme.mit.massif.communication.datatype.Handle;
import hu.bme.mit.massif.communication.datatype.IVisitableMatlabData;
import hu.bme.mit.massif.communication.datatype.MatlabString;
import hu.bme.mit.massif.communication.datatype.StructMatlabData;
import hu.bme.mit.massif.simulink.Block;
import hu.bme.mit.massif.simulink.BusCreator;
import hu.bme.mit.massif.simulink.BusSelector;
import hu.bme.mit.massif.simulink.BusSignalMapping;
import hu.bme.mit.massif.simulink.Connection;
import hu.bme.mit.massif.simulink.Enable;
import hu.bme.mit.massif.simulink.From;
import hu.bme.mit.massif.simulink.Goto;
import hu.bme.mit.massif.simulink.GotoTagVisibility;
import hu.bme.mit.massif.simulink.InPort;
import hu.bme.mit.massif.simulink.MultiConnection;
import hu.bme.mit.massif.simulink.OutPort;
import hu.bme.mit.massif.simulink.Parameter;
import hu.bme.mit.massif.simulink.Port;
import hu.bme.mit.massif.simulink.SimulinkElement;
import hu.bme.mit.massif.simulink.SimulinkModel;
import hu.bme.mit.massif.simulink.SimulinkReference;
import hu.bme.mit.massif.simulink.SingleConnection;
import hu.bme.mit.massif.simulink.SubSystem;
import hu.bme.mit.massif.simulink.Trigger;
import hu.bme.mit.massif.simulink.api.exception.SimulinkApiException;
import hu.bme.mit.massif.simulink.api.internal.PluginSimulinkAPILogger;
import hu.bme.mit.massif.simulink.api.layout.BlockLayoutSpecification;
import hu.bme.mit.massif.simulink.api.layout.DummyExporterLayoutProvider;
import hu.bme.mit.massif.simulink.api.layout.IExporterLayoutProvider;
import hu.bme.mit.massif.simulink.api.provider.block.SourceBlockProvider;
import hu.bme.mit.massif.simulink.api.util.ISimulinkAPILogger;
import hu.bme.mit.massif.simulink.api.util.Point;
import hu.bme.mit.massif.simulink.api.util.bus.BusSignalMapper;
import hu.bme.mit.massif.simulink.api.util.bus.BusSignalMappingPathFinder;

/**
 * This class provides functions to export and save Simulink models represented by EMF models
 */
public class Exporter {

    /**
     * The command evaluator instance used during the export process. It is used to send commands to Matlab and receive
     * the results.
     */
//    private ICommandEvaluator commandEvaluator;
    
    private MatlabCommandFactory commandFactory;
    /**
     * The logger instance used during the export process. It does the logging.
     */
    private ISimulinkAPILogger logger;
    /**
     * The layout provider used during the export process. It is responsible for determining the location and size of
     * each exported block.
     */
    private IExporterLayoutProvider layoutTool;

    /**
     * A temporal cache to store Goto objects in a set.
     */
    private Set<Goto> gotoCache;
    /**
     * A temporal cache to store GotoTagVisibility objects in a set.
     */
    private Set<GotoTagVisibility> gotoTagVisibilityCache;
    /**
     * A temporal cache to store the FQNs of the already added blocks.
     */
    private Set<String> addedBlockFQNs = new HashSet<String>();
    private BusSignalMappingPathFinder pathFinder;

    /**
     * The constructor for the exporter. Creates the logger, layout provider and initializes caches. It uses an instance of
     * {@link PluginSimulinkAPILogger} therefore the usage of this constructor in a non-OSGi environment is discouraged
     */
    public Exporter() {
        this(new PluginSimulinkAPILogger());
    }
    
    /**
     * The constructor for the exporter. Creates the layout provider, caches and sets. Receives an external logger implementation. 
     */
    public Exporter(ISimulinkAPILogger logger) {
        this.logger = logger;
        layoutTool = new DummyExporterLayoutProvider();
        gotoCache = new HashSet<Goto>();
        gotoTagVisibilityCache = new HashSet<GotoTagVisibility>();
    }

    /**
     * Sets the layout provider.
     * 
     * @param layoutTool
     *            the new layout provider to be used by the exporter object
     */
    public void setLayoutProvider(IExporterLayoutProvider layoutTool) {
        this.layoutTool = layoutTool;
    }

    /**
     * Loads the EMF representation of a Simulink model.
     * 
     * @param fileNameWithoutExtension
     *            the file to load specified by its name
     * @return the loaded SimulinkModel root EMF model object
     * @throws SimulinkApiException
     */
    public SimulinkModel loadSimulinkModel(String fileNameWithoutExtension) throws SimulinkApiException {

        // Register a resource factory for the extension "simulink"
        Resource.Factory.Registry reg = Resource.Factory.Registry.INSTANCE;
        Map<String, Object> m = reg.getExtensionToFactoryMap();
        m.put("simulink", new XMIResourceFactoryImpl());

        // Obtain a new resource set
        ResourceSet rs = new ResourceSetImpl();
        final ExtendedMetaData extendedMetaData = new BasicExtendedMetaData(rs.getPackageRegistry());
        rs.getLoadOptions().put(XMLResource.OPTION_EXTENDED_META_DATA, extendedMetaData);

        // The model will be saved to the root of the project for now under the
        // given name.
        // TODO save path may come from an extension or properties file
        String path = fileNameWithoutExtension + ".simulink";

        // Load the resource
        Resource loadResource = rs.getResource(URI.createURI(path), true);
        Object resourceContent = loadResource.getContents().get(0);

        // Make a log entry if the root object isn't a SimulinkModel
        if (!(resourceContent instanceof SimulinkModel))
            logger.error("The given resource contained no SimulinkModel as a root element!");

        // Return the root EMF model object
        // Also throws an exception when invalid cast occurs
        return (SimulinkModel) resourceContent;
    }

    /**
     * Saves the exported Simuink model in Matlab.
     * 
     * @param modelNameWithPath
     *            the exported model's save path
     * @throws SimulinkApiException
     */
    public void saveSimulinkModel(String modelNameWithPath, String fileExtension) throws SimulinkApiException {

        // If no command evaluator object is assigned yet, indicate it
        if (commandFactory == null) {
            logger.error("No Matlab command factory is set for the exporter. Was the model to be saved already exported?");
            return;
        }

        /*
         * The exporter needs to navigate to the save directory first, because it is quite common, that the length of
         * the model absolute path exceeds the maximum number of characters accepted by the save_system command (exceeds
         * 63 characters)
         */

        // Save the current directory
        String currentWorkdirectory = MatlabString.getMatlabStringData(commandFactory.cd().execute());

        String[] savePathSegments = modelNameWithPath.split("\\\\");
        String modelName = savePathSegments[savePathSegments.length - 1];

        // Navigate to the save location
        for (int i = 0; i < savePathSegments.length - 1; i++) {
            String segment = savePathSegments[i];
            MatlabCommand changeToSaveDir = commandFactory.cd().addParam(segment + File.separator);
            changeToSaveDir.execute();
        }

        // Save the model
        MatlabCommand saveSystem = commandFactory.saveSystem().addParam(modelName).addParam(modelName + "." + fileExtension);
        saveSystem.execute();

        // Navigate back to the original working directory
        String[] workDirSegments = currentWorkdirectory.split("\\\\");
        for (int i = 0; i < workDirSegments.length; i++) {
            String segment = workDirSegments[i];
            MatlabCommand changeToWorkDir = commandFactory.cd().addParam(segment + "\\");
            changeToWorkDir.execute();
        }

    }

    /**
     * Exports a given .simulink model to Simulink, but doesn't save it
     * 
     * @param model
     *            the EMF representation of the Simulink model to export
     * @param commandEvaluator
     *            the command evaluator object to use for evaluating command in Matlab during export TODO this object
     *            could be set in a setter, previously
     * @throws SimulinkApiException
     */
    public void export(SimulinkModel model, MatlabCommandFactory commandFactory) throws SimulinkApiException {

        // Import time measurement begin
        long beginTime = System.currentTimeMillis();

        // The given command factory is set for the exporter
        this.commandFactory = commandFactory;
        
        // The list of blocks on the top level
        EList<Block> topLevelBlocks = model.getContains();

        
        // Create the model in Simulink
        
        String modelFQN = getFQN(model);

        int existValue = Handle.getHandleData(commandFactory.exist().addParam(modelFQN).execute()).intValue();
        boolean modelAlreadyExists = existValue == 4;
        if(modelAlreadyExists){
        	MatlabCommand loadSystem = commandFactory.loadSytem();
        	loadSystem.addParam(modelFQN).execute();
		} else {
			if (existValue == 0) {
				MatlabCommand newSystem = commandFactory.newSytem();
				newSystem.addParam(modelFQN);
				if (model.isLibrary()) {
					newSystem.addParam("Library");
				}
				newSystem.execute();
			} else {
				logger.error("Model name collides with a MATLAB object name. 'exist' return status: " + existValue
						+ System.getProperty("line.separator") + "See > help exist in MATLAB for details");
				return;

			}
        }

        BusSignalMapper mapper = new BusSignalMapper(model.eResource().getResourceSet());
        mapper.setLogger(logger);
        pathFinder = new BusSignalMappingPathFinder(mapper);

        // Start the export from the top level blocks
        // Also exports connections for each hierarchy level
        logger.debug("Exporting blocks...");
        exportBlocks(topLevelBlocks);
        logger.debug("Block export finished");

        // Some tasks can only be done after placing all model object to the exported model, so do these post processing
        // steps here
        postProcessModel(modelFQN);

        // End of import
        logger.debug("EXPORT TIME TOTAL: " + (System.currentTimeMillis() - beginTime) + "ms");
    }

    /**
     * Gets the FQN for a given SimulinkElement
     * 
     * @param element
     *            the SimulinkElement object
     * @return
     */
    private String getFQN(SimulinkElement element) {
        return element.getSimulinkRef().getFQN();
    }

    /**
     * All the post processing tasks are done in this function. Post processing tasks can only be done after placing all
     * model elements to the model.
     * 
     * @param modelFQN
     *            the model's fully qualified name, to which the post process steps are need to be done
     */
    private void postProcessModel(String modelFQN) {
        logger.debug("Post processing begins...");
        setMissingGotoTags();
        logger.debug("Post processing finished");
    }

    /**
     * As a post process step, sets all missing goto tags for the exported elements in order to create the same
     * goto-from assignments as the EMF model contains.
     */
    private void setMissingGotoTags() {
        for (GotoTagVisibility gotoTagVisibilityBlock : gotoTagVisibilityCache) {
            String gotoTagVisibilityFQN = getFQN(gotoTagVisibilityBlock);
            Goto gotoBlock = gotoTagVisibilityBlock.getGotoBlock();

            String selectedGotoTag = gotoBlock.getGotoTag();
            // When a gotoTagVisibility points to a processed goto block use the gotoTag of the goto block
            boolean gotoBlockIsAlreadyProcessedOnce = !gotoCache.contains(gotoBlock);
            if (gotoBlockIsAlreadyProcessedOnce) {
            	MatlabCommand setGotoGotoTag = commandFactory.setParam().addParam(gotoTagVisibilityFQN).addParam("GotoTag").addParam(selectedGotoTag);
                setGotoGotoTag.execute();
                break;
            }
            // When the gotoTag is empty/not set generate a new gotoTag
            if (Strings.isNullOrEmpty(selectedGotoTag)) {
                selectedGotoTag = generateGotoTag();
                gotoBlock.setGotoTag(selectedGotoTag);
            }
            MatlabCommand setGotoTagVisibilityGotoTag = commandFactory.setParam().addParam(gotoTagVisibilityFQN).addParam("GotoTag").addParam(selectedGotoTag);
            setGotoTagVisibilityGotoTag.execute();
            // Set it in the model, but do not save it
            gotoTagSet(gotoBlock, selectedGotoTag, true);
            gotoCache.remove(gotoBlock);
        }
        for (Goto gotoBlock : gotoCache) {
            // Test if the gotoTag is valid
            String selectedGotoTag = gotoBlock.getGotoTag();
            if (Strings.isNullOrEmpty(selectedGotoTag)) {
                // When invalid generate one
                selectedGotoTag = generateGotoTag();
            }
            // Set it in the model
            gotoTagSet(gotoBlock, selectedGotoTag, false);
        }
    }

    /**
     * Generates a unique and valid goto tag.
     * 
     * @return the generated goto tag string
     */
    private String generateGotoTag() {
        String generatedUUID = EcoreUtil.generateUUID();
        return generatedUUID.replaceAll("[^a-zA-Z]", "");
    }

    /**
     * Sets the given goto tag for the given goto block.
     * 
     * @param gotoBlock
     *            the goto block for which the tag should be set
     * @param gotoTag
     *            the value of the tag
     * @param isScoped
     *            indicates if the goto block is scoped
     */
    private void gotoTagSet(Goto gotoBlock, String gotoTag, boolean isScoped) {
        String gotoFQN = getFQN(gotoBlock);
        String scopedOrLocal = null;
        if (gotoBlock.getTagVisibility() != null && !Strings.isNullOrEmpty(gotoBlock.getTagVisibility().name())) {
            // Whether there is a GotoTagVisibility block or not, the scoping can be set to any possible value
            scopedOrLocal = gotoBlock.getTagVisibility().name();
        } else {
            // If the GotoTagVisibility scope is not set, it should be inferred from the existence of the tag visibility
            // block
            // knowing that global doesn't fulfill the criteria of well-formedness of the model
            scopedOrLocal = isScoped ? "scoped" : "local";
        }

        // Set the parameter values in Matlab
        MatlabCommand setScope = commandFactory.setParam().addParam(gotoFQN).addParam("TagVisibility").addParam(scopedOrLocal);
        setScope.execute();

        MatlabCommand setGotoTag = commandFactory.setParam().addParam(gotoFQN).addParam("GotoTag").addParam(gotoTag);
        setGotoTag.execute();

        // Set the same tag for each assigned from block
        for (From from : gotoBlock.getFromBlocks()) {
            String fromFQN = getFQN(from);
            setGotoTag.setParam(0, new MatlabString(fromFQN));
            setGotoTag.execute();
        }

    }

    /**
     * Exports the blocks to the model contained in the given list.
     * 
     * @param sameLevelBlocks
     *            the list of EMF objects for which a Simulink block should be added to the model in Simulink
     * @throws SimulinkApiException
     */
    private void exportBlocks(EList<Block> sameLevelBlocks) throws SimulinkApiException {

		// Check if there is at least one block present at the given level
		if (sameLevelBlocks.size() <= 0) {
			return;
		}

        // BlockFQN and block size map
        Map<Block, BlockLayoutSpecification> blocksOriginalSize = new HashMap<Block, BlockLayoutSpecification>();

        // Create blocks
        for (Block block : sameLevelBlocks) {
            // Caching for post processing
            if (block instanceof GotoTagVisibility) {
                gotoTagVisibilityCache.add((GotoTagVisibility) block);
            } else if (block instanceof Goto) {
                gotoCache.add((Goto) block);
            }

            // process the block
            IVisitableMatlabData newBlockHandle;

            String sourceBlockFQN = getRealSourceBlockFQN(block);
            String blockFQN = getFQN(block);

            // Making sure not to re-add blocks with the same name to the model by storing the already added blockFQNs
            if (addedBlockFQNs.contains(blockFQN)) {
                logger.error("The block '" + blockFQN + "' with sourceBlock '" + sourceBlockFQN
                        + "' could not be added, because a block with the same name already exists in the model!");
                continue;
            }
            addedBlockFQNs.add(blockFQN);

            // Adds a block to the model if able
            commandFactory.clearLastErrorMessage().execute();
            MatlabCommand addBlock = commandFactory.addBlock().addParam(sourceBlockFQN).addParam(blockFQN);
            newBlockHandle = addBlock.execute();
            MatlabCommand lastErrorMessage = commandFactory.getLastErrorMessage();
            String lastErrorMessageString = MatlabString.getMatlabStringData(lastErrorMessage.execute());
            if (!"".equals(lastErrorMessageString)) {
                logger.error("The block '" + blockFQN + "' with sourceBlock '" + sourceBlockFQN
                        + "' could not be added");
                continue;
            }

            // Get original size of the block
            MatlabCommand getDefaultPosition = commandFactory.getParam().addParam(newBlockHandle).addParam("Position");
            IVisitableMatlabData defaultPosition = getDefaultPosition.execute();
            CellMatlabData defaultPositionData = (CellMatlabData) defaultPosition;

            BlockLayoutSpecification bls = new BlockLayoutSpecification();
            bls.width = (Handle.getHandleData(defaultPositionData.getData(2)) - Handle
                    .getHandleData(defaultPositionData.getData(0)));
            bls.height = (Handle.getHandleData(defaultPositionData.getData(3)) - Handle
                    .getHandleData(defaultPositionData.getData(1)));
            // set temporary x,y coordinate
            bls.topLeft = new Point(0.0f, 0.0f);

            blocksOriginalSize.put(block, bls);

            // Try to load the source block library
            // DO NOT DELETE - TODO this might be necessary and useful
            // if (newBlockHandle == null) {
            // LoadSystem loadSystem = new LoadSystem(commandEvaluator);
            // loadSystem.addParam(block.getSourceBlockRef().getQualifier());
            // loadSystem.execute();
            // newBlockHandle = addBlock.execute();
            // // If the add_block operation fails for the second time as well, throw an exception
            // if (newBlockHandle == null) {
            // logger.error("Failed to add block " + block.getSimulinkRef().getFQN() + "\nEscaped name: " + blockFQN);
            // }
            // }

            // //////////////////////////////////////////////////////////
            // Block type specific processing part BEGIN
            // TODO find a more sophisticated solution (like the provider-adapter pattern applied in the Importer)
            if (block instanceof BusCreator) {
                busCreatorExtraActions(block);
            } else if (block instanceof BusSelector) {
                busSelectorExtraActions(block);
            } else if (block instanceof SubSystem) {
                subSystemExtraActions(block, newBlockHandle, blockFQN);
            }
            // Block type specific processing part END
            // //////////////////////////////////////////////////////////

            // Set block dialog/mask parameters
            EList<Parameter> parameters = block.getParameters();
            for (Parameter parameter : parameters) {
                String propertyName = parameter.getName();
                commandFactory.setParam().addParam(getFQN(block)).addParam(propertyName).addParam(parameter.getValue()).execute();
            }

        }

        // When there is at least one block on the same level, check that only blocks are there on the same level will be present in the exported model
        String containerFQN = getContainerFQN(sameLevelBlocks);

        MatlabCommand findExistingBlocks = commandFactory.findSystem().addParam(containerFQN).addParam("SearchDepth").addParam(1.0).addParam("type").addParam("block");
        List<IVisitableMatlabData> fqnsInTheModel = CellMatlabData.getCellMatlabDataData(findExistingBlocks.execute());
        
        for (IVisitableMatlabData iVisitableMatlabData : fqnsInTheModel) {
			String fqn = MatlabString.getMatlabStringData(iVisitableMatlabData);
			boolean found = false;
			inner:
			for (Block block : sameLevelBlocks) {
				if(block.getSimulinkRef().getFQN().equals(fqn)){
					found = true;
					break inner;
				}
			}
			if(!found && !fqn.equals(containerFQN)){
				commandFactory.deleteBlock().addParam(fqn).execute();
			}
		}
        
        
        // layout the complete level
        layoutBlocks(blocksOriginalSize);
        
        // create connections between the exported blocks
        exportLines(sameLevelBlocks);
    }

	private String getContainerFQN(EList<Block> sameLevelBlocks) {
		String containerFQN = null;
        if(sameLevelBlocks.size() > 0 ){
        	Block aBlock = sameLevelBlocks.get(0);
        	EObject container = aBlock.eContainer();
        	if(container instanceof SimulinkModel){
				containerFQN = ((SimulinkModel) container).getSimulinkRef().getFQN();
        	} else if (container instanceof SubSystem){
        		containerFQN = ((SubSystem) container).getSimulinkRef().getFQN();
        	} else {
        		logger.error("Unknown parent encountered for: " + aBlock.getName());
        	}
        }
		return containerFQN;
	}

    private void layoutBlocks(Map<Block, BlockLayoutSpecification> blocksOriginalSize) {

        // set x,y coordinate of blocks
        layoutTool.updateSpecifications(blocksOriginalSize);

        for (Map.Entry<Block, BlockLayoutSpecification> entry : blocksOriginalSize.entrySet()) {
            Block block = entry.getKey();
            BlockLayoutSpecification layoutSpecification = entry.getValue();

            int topLeftX = (int) layoutSpecification.topLeft.x;
            int topLeftY = (int) layoutSpecification.topLeft.y;
            int width = (int) entry.getValue().width;
            int height = (int) entry.getValue().height;
            int bottomRightX = topLeftX + width;
            int bottomRightY = topLeftY + height;

            
            String corners = "[" + topLeftX + "," + topLeftY + "," + bottomRightX + "," + bottomRightY + "]";
            commandFactory.setParam().addParam(getFQN(block)).addParam("Position").addParam(corners).execute();
            logger.debug("Block position: " + getFQN(block) + "  TopLeftX: " + topLeftX + "  TopLeftY: " + topLeftY
                    + "  Width: " + width + "  Height: " + height);
        }
    }

    /**
     * Gets the source block FQN.
     * 
     * @param block
     *            for which the source block FQN should be retreived
     * @return
     */
    private String getRealSourceBlockFQN(Block block) {
        SimulinkReference sourceBlockRef = block.getSourceBlockRef();
        String sourceBlockFQN = null;

        if (sourceBlockRef != null)
            sourceBlockFQN = block.getSourceBlockRef().getFQN();

        if (Strings.isNullOrEmpty(sourceBlockFQN)) {
            sourceBlockFQN = SourceBlockProvider.INSTANCE.adapt(block);
        }
        return sourceBlockFQN;
    }

    /**
     * Specific actions to be taken in case of a bus creator
     * 
     * @param block
     *            the BusCreator block
     */
    private void busCreatorExtraActions(Block block) {
        BusCreator busCreator = (BusCreator) block;
        int inportCount = busCreator.getInports().size();
        commandFactory.setParam().addParam(getFQN(block)).addParam("Inputs").addParam(Integer.toString(inportCount)).execute();
    }

    /**
     * Specific actions to be taken for a Subsystem
     * 
     * @param block
     *            the subsystem object
     * @param handle
     *            the handle of the created block in Simulink
     * @param blockFQN
     *            the FQN of the subsystem
     * @throws SimulinkApiException
     */
    private void subSystemExtraActions(Block block, IVisitableMatlabData handle, String blockFQN)
            throws SimulinkApiException {
        if (isDefaultSubsystem(block)) {
            deleteDefaultContentsOfSubsystem(block, handle);
        }

        boolean notLinkedSubsystem = block.getSourceBlockRef().isDisabled();

        if (notLinkedSubsystem) {
            // Naive implementation: build up the internal contents of a non linked subsystem from scratch
        	MatlabCommand deleteContents = commandFactory.customCommand("Simulink.SubSystem.deleteContents", 0);
            deleteContents.addParam(blockFQN).execute();
            
            commandFactory.setParam().addParam(blockFQN).addParam("LinkStatus").addParam("inactive").execute();
            // Recursive call for the lower layer blocks, if there's any
            exportBlocks(((SubSystem) block).getSubBlocks());
        }
    }

    /**
     * Specific actions to be taken in case of a bus selector
     * 
     * @param block
     *            the BusSelector block
     */
    private void busSelectorExtraActions(Block block) throws SimulinkApiException {
        BusSelector busSelector = (BusSelector) block;

        EList<BusSignalMapping> portMappings = busSelector.getMappings();

        String[] outputSignalNames = new String[portMappings.size()];

        int portNumber = 0;
        for (BusSignalMapping busSignalMapping : portMappings) {
            OutPort mappedTo = busSignalMapping.getMappingTo();
            String portNumberString = mappedTo.getName().substring(mappedTo.getName().lastIndexOf('.') + 1);
            if (busSelector.isOutputAsBus()) {
                portNumber++;
            } else {
                portNumber = Integer.parseInt(portNumberString);
            }

            try {
                String originalPath = busSignalMapping.getMappingPath();
                String computedPath = originalPath;
                boolean incompleteButSetMapping = !Strings.isNullOrEmpty(originalPath)
                        && busSignalMapping.isIncomplete();
                if (incompleteButSetMapping) {
                    logger.debug(String.format("Using stored mapping path for incomplete mapping [%s]", originalPath));
                } else {
                    computedPath = pathFinder.findMappingPath(busSignalMapping);
                    busSignalMapping.setMappingPath(computedPath);
                    logger.debug(String.format("Updating mapping path from [%s] to [%s]", originalPath, computedPath));
                }
                outputSignalNames[portNumber - 1] = computedPath;
            } catch (IllegalArgumentException e) {
                throw new SimulinkApiException("Could not compute path mapping for " + busSignalMapping
                        + "! Mapping is not set correctly.", e);
            } catch (IllegalStateException e) {
                throw new SimulinkApiException("Could not compute path mapping for " + busSignalMapping
                        + "! Mapping is inconsistent with model.", e);
            }
            // If output as bus, increment port counter manually
        }

        String outputSignals = "";
        for (int i = 0; i < outputSignalNames.length - 1; i++) {
            outputSignals = outputSignals.concat(outputSignalNames[i]) + ",";
        }
        outputSignals = outputSignals.concat(outputSignalNames[outputSignalNames.length - 1]);

        commandFactory.setParam().addParam(getFQN(block)).addParam("OutputSignals").addParam(outputSignals).execute();
    }

    /**
     * Determines if a block is a basic built-in subsystem block
     * 
     * @param block
     *            is the model object to inspect
     * @return <li>true, if it is a default/inbuilt subsystem</li> <li>false, otherwise</li>
     */
    private boolean isDefaultSubsystem(Block block) {
        String realSourceBlockFQN = getRealSourceBlockFQN(block);
        return "simulink/Ports & Subsystems/Subsystem".equalsIgnoreCase(realSourceBlockFQN)
                || "simulink/Ports & Subsystems/Atomic Subsystem".equalsIgnoreCase(realSourceBlockFQN);
    }

    /**
     * Deletes the default blocks from a newly added default subsystem
     * 
     * @param block
     *            the EMF object representing the subsystem
     * @param handle
     *            the handle of the exported block
     */
    private void deleteDefaultContentsOfSubsystem(Block block, IVisitableMatlabData handle) {
        // Clear the default elements from the SubSystem block
    	MatlabCommand findDefaultLines = commandFactory.findSystem().addParam(handle).addParam("FindAll").addParam("On").addParam("Type").addParam("Line");
        IVisitableMatlabData lineToDelete = findDefaultLines.execute();
        commandFactory.deleteLine().addParam(lineToDelete).execute();
        commandFactory.deleteBlock().addParam(getFQN(block) + "/Out1").execute();
        commandFactory.deleteBlock().addParam(getFQN(block) + "/In1").execute();
    }

    /**
     * Exports the lines (connections) between blocks
     * 
     * @param sameLevelBlocks
     *            list of blocks for which lines should be created
     * @throws SimulinkApiException
     */
    private void exportLines(EList<Block> sameLevelBlocks) {
        // Create lines on the same level
        for (Block block : sameLevelBlocks) {
            // For each block, organize the list of inports
            // Move the enable port to the end of the list, if exists (it might be followed by a trigger port later)
            EList<Port> ports = block.getPorts();
            Enable enable = null;
            for (int i = 0; i < ports.size(); i++) {
                if (ports.get(i) instanceof Enable) {
                    enable = (Enable) ports.get(i);
                    ports.remove(i);
                    break;
                }
            }
            if (enable != null) {
                ports.add(enable);
            }
            // Move the trigger port to the end of the list, if exists (this should be the very last)
            Trigger trigger = null;
            for (int i = 0; i < ports.size(); i++) {
                if (ports.get(i) instanceof Trigger) {
                    trigger = (Trigger) ports.get(i);
                    ports.remove(i);
                    break;
                }
            }
            if (trigger != null) {
                ports.add(trigger);
            }

        }
   
        // Store the created line handles in order to be able to delete the rest in Simulink
        Set<Double> addedLineHandles = Sets.newHashSet();
        
        for (Block block : sameLevelBlocks) {

            for (OutPort outPort : block.getOutports()) {

            	Double addedLineHandle;
                Connection conn = outPort.getConnection();
                if (conn == null)
                    continue;
                if (conn instanceof SingleConnection) {

                    SingleConnection sc = (SingleConnection) conn;

					addedLineHandle = createConnectionFromSingleConnection(sc, outPort);
					if(addedLineHandle != null){
						addedLineHandles.add(addedLineHandle);
					}

                } else { // It is a multi connection (or null pointer)
                    MultiConnection mc = (MultiConnection) conn;
                    for (SingleConnection sc : mc.getConnections()) {
                    	addedLineHandle = createConnectionFromSingleConnection(sc, outPort);
                    	if(addedLineHandle != null){
                    		addedLineHandles.add(addedLineHandle);
                    	}
                    }
                }
                
                
            }

        }
        
        // Synchronize existing lines in the EMF model and in the exported Simulink model
        String containerFQN = getContainerFQN(sameLevelBlocks);
        MatlabCommand findLineHandles = commandFactory.findSystem().addParam(containerFQN).addParam("findall").addParam("on").addParam("SearchDepth").addParam(1.0).addParam("type").addParam("line");
		IVisitableMatlabData allQueriedLineHandles = findLineHandles.execute();
        
        Set<Handle> linesToDelete = Sets.newHashSet();
        
        if(allQueriedLineHandles instanceof CellMatlabData){
        	List<IVisitableMatlabData> lineHandles = ((CellMatlabData) allQueriedLineHandles).getDatas();
        	for (IVisitableMatlabData iVisitableMatlabData : lineHandles) {
        		// If the ImporterTmpResult doesn't contain the result of the previous command
        		if(!(iVisitableMatlabData instanceof Handle)){
        			break;
        		}
				Double currentLineHandle = Handle.getHandleData(iVisitableMatlabData);
				boolean isContained = false;
				for (Double lh : addedLineHandles) {
					if(lh.equals(currentLineHandle)){
						isContained = true;
						break;
					}
				}
				if(!isContained){
					// Add to delete list only when the children of the line is empty.
					// This extra constraint is needed, because we are exporting only 'single connections', so ignore the automatically created multi connections
					
					Handle lineToCheck = (Handle) iVisitableMatlabData;
					MatlabCommand getLineChildren = commandFactory.getParam().addParam(lineToCheck).addParam("LineChildren");
					IVisitableMatlabData children = getLineChildren.execute();
					// It exists in the model, has no children, but we did not exported it
					if (children instanceof CellMatlabData && ((CellMatlabData)children).getDatas().size() == 0){
						linesToDelete.add(lineToCheck);
					}
					
				}
			}
        } else if (allQueriedLineHandles instanceof Handle){
        	Handle handle = (Handle) allQueriedLineHandles;
            if(!addedLineHandles.contains(handle.getData())){
        		linesToDelete.add(handle);
        	}
        }
        for (Handle handle : linesToDelete) {
			MatlabCommand deleteLine = commandFactory.deleteLine().addParam(handle);
			deleteLine.execute();
		}
        
    }

    /**
     * Creates a line from a single connection
     * 
     * @param singleConnection
     *            the single connection from which the line should be created
     * @param outPort
     *            the outport from which the line goes out
     * @throws SimulinkApiException
     */
    
    private double prevdata;
    
    private Double createConnectionFromSingleConnection(SingleConnection singleConnection, OutPort outPort) {
        // FIXME sc.getFrom() didn't work!!!
        String fromBlockName = outPort.getContainer().getName();

        // Get index of the port in the list of ports
        // Matlab indices start from 1
        int indexOfOutportInMatlab = 1;
        EList<Port> outPortContainerPortList = outPort.getContainer().getPorts();

        for (Port port : outPortContainerPortList) {
            if (port instanceof OutPort) {
                // Look for the outport involved in the connection
                if (port.equals(outPort)) {
                    break;
                } else {
                    // Only increment the counter, when outports are encountered in the list
                    indexOfOutportInMatlab++;
                }
            }
        }

        int fromPortNumber = indexOfOutportInMatlab;
        
        
        
        String srcPort = fromBlockName + "/" + fromPortNumber;
        
        if(singleConnection.getTo() == null){
        	// If the connection is unconnected to a port, it won't be added to the Simulink model
        	return null;
        }
        String toBlockName = singleConnection.getTo().getContainer().getName();

        // Get index of the port in the list of inPorts, and increment it by 1, because Matlab indices start with 1
        EList<Port> inPortContainerPortList = singleConnection.getTo().getContainer().getPorts();
        InPort targetInPort = singleConnection.getTo();

        int indexOfInportInMatlab = 1;
        for (Port port : inPortContainerPortList) {
            if (port instanceof InPort) {
                if (port.equals(targetInPort)) {
                    break;
                } else {
                    indexOfInportInMatlab++;
                }
            }
        }

        String toPortNumber = String.valueOf(indexOfInportInMatlab);
        // TODO optimize solution
        if(targetInPort instanceof Enable)
            toPortNumber = "Enable";
        if(targetInPort instanceof Trigger)
            toPortNumber = "Trigger";
        String dstPort = toBlockName + "/" + toPortNumber;

        
        // get the FQN of the current level / subsystem
        String system = outPort.getContainer().getSimulinkRef().getQualifier();

        
        commandFactory.clearLastErrorMessage().execute();
        MatlabCommand addLine = commandFactory.addLine().addParam(system).addParam(srcPort).addParam(dstPort).addParam("AutoRouting").addParam("on");
        IVisitableMatlabData addedLineHandle = addLine.execute();
        String lastErrorMsg = MatlabString.getMatlabStringData(commandFactory.getLastErrorMessage().execute());
        
        if(!"".equals(lastErrorMsg)) {
        	// There was an error message in the returned variable instead of the desired handle

        	// This also happens when there is already a connection between the selected elements, so try to get the line
        	MatlabCommand getPortHandles = commandFactory.getParam().addParam(system + "/" + toBlockName).addParam("PortHandles");
        	IVisitableMatlabData execute = getPortHandles.execute();
			IVisitableMatlabData inportData = StructMatlabData.getStructMatlabDataData(execute).get("Inport");
        	if(inportData instanceof Handle){
        		IVisitableMatlabData portHandle = inportData;
        		addedLineHandle = commandFactory.getParam().addParam(portHandle).addParam("line").execute();
        	}
        	else if(inportData instanceof CellMatlabData){
        		IVisitableMatlabData portHandle = ((CellMatlabData) inportData).getData(indexOfInportInMatlab-1);
        		addedLineHandle = commandFactory.getParam().addParam(portHandle).addParam("line").execute();
        	}
        	// TODO might be needed to check for null
        	//return null;
		}
		if(Handle.asHandle(addedLineHandle).getData().equals(prevdata)){
			// FIXME this is only a hotfix for State (out)ports
			addLine = commandFactory.addLine().addParam(system).addParam(fromBlockName+"/State").addParam(dstPort).addParam("AutoRouting").addParam("on");
			addedLineHandle = addLine.execute();
        }
        prevdata = Handle.asHandle(addedLineHandle).getData(); 
        
        // IF the line name is not artificially created while importing, the exporter sets the name
        if (addedLineHandle != null && singleConnection.getLineName() != null) {
            MatlabCommand setLineName = commandFactory.setParam().addParam(addedLineHandle).addParam("Name").addParam(singleConnection.getLineName());
            setLineName.execute();
        }
        
        return addedLineHandle == null ? null : Handle.getHandleData(addedLineHandle);
    }
}
