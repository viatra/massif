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
package hu.bme.mit.massif.simulink.api;

import hu.bme.mit.massif.communication.command.MatlabCommand;
import hu.bme.mit.massif.communication.command.MatlabCommandFactory;
import hu.bme.mit.massif.communication.datatype.CellMatlabData;
import hu.bme.mit.massif.communication.datatype.Handle;
import hu.bme.mit.massif.communication.datatype.IVisitableMatlabData;
import hu.bme.mit.massif.communication.datatype.MatlabString;
import hu.bme.mit.massif.communication.datatype.StructMatlabData;
import hu.bme.mit.massif.communication.datavisitor.SourceBlockGetterVisitor;
import hu.bme.mit.massif.simulink.Block;
import hu.bme.mit.massif.simulink.BusSelector;
import hu.bme.mit.massif.simulink.BusSignalMapping;
import hu.bme.mit.massif.simulink.Connection;
import hu.bme.mit.massif.simulink.From;
import hu.bme.mit.massif.simulink.Goto;
import hu.bme.mit.massif.simulink.GotoTagVisibility;
import hu.bme.mit.massif.simulink.IdentifierReference;
import hu.bme.mit.massif.simulink.InPort;
import hu.bme.mit.massif.simulink.InPortBlock;
import hu.bme.mit.massif.simulink.MultiConnection;
import hu.bme.mit.massif.simulink.OutPort;
import hu.bme.mit.massif.simulink.OutPortBlock;
import hu.bme.mit.massif.simulink.Port;
import hu.bme.mit.massif.simulink.PortBlock;
import hu.bme.mit.massif.simulink.Property;
import hu.bme.mit.massif.simulink.SimulinkElement;
import hu.bme.mit.massif.simulink.SimulinkFactory;
import hu.bme.mit.massif.simulink.SimulinkModel;
import hu.bme.mit.massif.simulink.SimulinkReference;
import hu.bme.mit.massif.simulink.SingleConnection;
import hu.bme.mit.massif.simulink.SubSystem;
import hu.bme.mit.massif.simulink.api.adapter.block.IBlockAdapter;
import hu.bme.mit.massif.simulink.api.adapter.port.IPortAdapter;
import hu.bme.mit.massif.simulink.api.exception.SimulinkApiException;
import hu.bme.mit.massif.simulink.api.extension.ISimulinkImportFilter;
import hu.bme.mit.massif.simulink.api.extension.impl.ReferencingImportFilter;
import hu.bme.mit.massif.simulink.api.internal.PluginSimulinkAPILogger;
import hu.bme.mit.massif.simulink.api.internal.SimulinkApiPlugin;
import hu.bme.mit.massif.simulink.api.provider.block.BlockProvider;
import hu.bme.mit.massif.simulink.api.provider.port.PortProvider;
import hu.bme.mit.massif.simulink.api.util.ISimulinkAPILogger;
import hu.bme.mit.massif.simulink.api.util.ImportMode;
import hu.bme.mit.massif.simulink.api.util.SimulinkUtil;
import hu.bme.mit.massif.simulink.api.util.bus.BusSignalMapper;
import hu.bme.mit.massif.simulink.api.util.bus.BusSignalMappingCreator;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.MultiStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

import com.google.common.base.Strings;

/**
 * This class provides functions to import and save Simulink models to EMF models
 */
public class Importer {

    private static final int BUS_SIGNAL_MAPPING_ERROR_CODE = 0;
    
    /* Caches for model import */
    // TODO maps for caching EMF objects now could also be stored in a map for <IVisistableData,Block>
    // TODO maps using Doubles should be replaced

    /**
     * Block cache for easier EMF model creation
     */
    private Map<String, Block> blocks;
    /**
     * InPort block cache
     */
    private Map<String, LinkedHashSet<InPortBlock>> inPortBlocks;

    /**
     * OutPort block cache
     */
    private Map<String, LinkedHashSet<OutPortBlock>> outPortBlocks;

    /**
     * Cache for blocks that are also play a parent role in a context
     */
    private Set<Block> parents;

    /**
     * Cache for Goto blocks
     */
    private Map<Goto, List<String>> gotos;

    /**
     * Cache for from blocks
     */
    private Map<String, From> froms;

    /**
     * Cache for GotoTagVisibilities
     */
    private Map<String, List<GotoTagVisibility>> gotoTagVisibilities;

    /**
     * Stores the so far imported models
     */
    private Map<String, SimulinkModel> referencedModels;

    /**
     * Stores the libraries that are available in EMF
     */
    private Map<String, SimulinkModel> referencedLibraries;

    
    private Set<String> librariesBeingImported;

    /**
     * For each bus selector store its outports
     */
    private Map<BusSelector, List<Handle>> busSelectorToDestinationPorts;
    /**
     * InPort objects cached and accessed by their handles
     */
    private Map<Double, InPort> inPorts;
    /**
     * OutPort objects cached and accessed by their handles
     */
    private Map<Double, OutPort> outPorts;
    /**
     * OutPort object handles cached and accessed by the OutPort objects
     */
    private Map<OutPort, Double> cachedOutPortHandles;
    /**
     * Stores the name of the 'real' port block to each InportShadow block
     */
    private Map<InPortBlock, MatlabString> shadowInports;
    /**
     * All created inport blocks can be accessed by using their parent's names
     */
    private Map<String, InPortBlock> inportBlocksByName;

    /* Cache getters */

    public Map<String, SimulinkModel> getReferencedLibraries() {
        return referencedLibraries;
    }
    
    public Map<String, Block> getBlocks() {
        return blocks;
    }

    public Map<String, LinkedHashSet<InPortBlock>> getInPortBlocks() {
        return inPortBlocks;
    }

    public Map<String, LinkedHashSet<OutPortBlock>> getOutPortBlocks() {
        return outPortBlocks;
    }

    public Set<Block> getParents() {
        return parents;
    }

    public Map<Goto, List<String>> getGotos() {
        return gotos;
    }

    public Map<String, From> getFroms() {
        return froms;
    }

    public Map<String, List<GotoTagVisibility>> getGotoTagVisibilities() {
        return gotoTagVisibilities;
    }

    public Map<String, SimulinkModel> getReferencedModels() {
        return referencedModels;
    }

    public Map<BusSelector, List<Handle>> getBusSelectorToDestinationPorts() {
        return busSelectorToDestinationPorts;
    }

    public Map<Double, InPort> getInPorts() {
        return inPorts;
    }

    public Map<Double, OutPort> getOutPorts() {
        return outPorts;
    }

    public Map<OutPort, Double> getCachedOutPortHandles() {
        return cachedOutPortHandles;
    }

    public Map<InPortBlock, MatlabString> getShadowInports() {
        return shadowInports;
    }

    /* Caches end */

    /* Constants */

    /**
     * If this string is contained in the name it shows that the line in simulink originally was not named
     */
    public static final String DERIVED_LINE_NAME_INDICATOR = "DERIVED_LINE_NAME";

    public static final String REFERENCES_FOLDER_SUFFIX = "_refs";
  
    /* Constants end */

    /* Fields */
    /**
     * The currently processed model's name
     */
    private String modelFQN;

    public String getModelFQN() {
        return modelFQN;
    }

    public ModelObject getModel() {
        return model;
    }

    public SimulinkModel getSimulinkModel() {
        return simulinkModel;
    }

    public Set<String> getLibrariesBeingImported() {
        return librariesBeingImported;
    }


    public ISimulinkAPILogger getLogger() {
        return logger;
    }

    public ImportMode getImportMode() {
        return importMode;
    }

    public Set<ISimulinkImportFilter> getFilters() {
        return filters;
    }

    public MatlabCommandFactory getCommandFactory(){
    	return commandFactory;
    }
    
    /**
     * The assigned model for this traverser
     */
    private ModelObject model;
    /**
     * The associated logger object
     */
    private ISimulinkAPILogger logger;
    /**
     * The chosen way to import the model
     */
    private ImportMode importMode;
    /**
     * Collection of filters that decide whether the Simulink block should be imported
     */
    private Set<ISimulinkImportFilter> filters = new HashSet<ISimulinkImportFilter>();
    /**
     * The current command evaluator connected to the currentMatlabClient
     */
//    private ICommandEvaluator commandEvaluator;
    // TODO maybe better to use a factory
    private MatlabCommandFactory commandFactory;

    private SimulinkModel simulinkModel;

    private String defaultSavePath;

    private String referencesFolderName;

    /* Field getters */
    
    /* Fields end */


    public String getReferencesFolderName() {
        return referencesFolderName;
    }

    public void setReferencesFolderName(String referencesFolderName) {
        this.referencesFolderName = referencesFolderName;
    }

    /**
     * Sets the ICommandEvaluator object to be used by the importer
     * 
     * @param currentCommandEvaluator
     *            the command evaluator
     */
    public void setCurrentCommandFactory(MatlabCommandFactory commandFactory) {
        this.commandFactory = commandFactory;
    }

    /**
     * Sets the model to traverse
     * 
     * @param model
     *            the model to assign
     */
    public void setModel(ModelObject model) {
        if (!this.model.equals(model)) {
            this.model = model;
            blocks = new HashMap<String, Block>();
        }
    }
    
    public Map<String, InPortBlock> getInportBlocksByName() {
        return inportBlocksByName;
    }

    /**
     * Constructor for the traverser.
     * 
     * @param model
     *            the model assigned to the traverser
     */
    public Importer(ModelObject model) {

        // Initialization of fields
        blocks = new HashMap<String, Block>();
        inportBlocksByName = new HashMap<String, InPortBlock>();
        shadowInports = new HashMap<InPortBlock, MatlabString>();
        inPortBlocks = new HashMap<String, LinkedHashSet<InPortBlock>>();
        outPortBlocks = new HashMap<String, LinkedHashSet<OutPortBlock>>();
        parents = new LinkedHashSet<Block>();
        gotos = new HashMap<Goto, List<String>>();
        froms = new HashMap<String, From>();
        gotoTagVisibilities = new HashMap<String, List<GotoTagVisibility>>();
        referencedModels = new HashMap<String, SimulinkModel>();
        busSelectorToDestinationPorts = new HashMap<BusSelector, List<Handle>>();
        inPorts = new HashMap<Double, InPort>();
        outPorts = new HashMap<Double, OutPort>();
        cachedOutPortHandles = new HashMap<OutPort, Double>();
        logger = new PluginSimulinkAPILogger();
        referencedLibraries = new HashMap<String, SimulinkModel>();
        librariesBeingImported = new HashSet<String>();
        
        referencesFolderName = model.getFullyQualifiedName();

        // Assign the model to the traverser
        this.model = model;
        commandFactory = model.getCommandFactory();
    }

    public void addFilters(Collection<ISimulinkImportFilter> filters){
    	this.filters.addAll(filters);
    }

    /**
     * Registers an import filter for the traverser
     * 
     * @param filter
     */
    public void registerFilter(ISimulinkImportFilter filter) {
        filters.add(filter);
    }

    public void saveEMFModel() throws SimulinkApiException {
        saveEMFModel(getDefaultSavePath() + File.separator + modelFQN);
    }
    /**
     * The saver function for the result model
     * 
     * @param model
     * @param importedModelName
     * @throws IOException
     */
    public void saveEMFModel(String importedModelName) throws SimulinkApiException {
        logger.debug("Saving model "+importedModelName);
        // Get save directory        
        // TODO on UNIX here should be checked for only one File.separator
        String[] segments = importedModelName.split(File.separator+File.separator);
        String savePath = segments[0] + File.separator;
        for (int i = 1; i < segments.length - 1; i++)
            savePath = savePath.concat(segments[i] + File.separator);

        // Registering a resource factory for the extension "simulink"
        Resource.Factory.Registry reg = Resource.Factory.Registry.INSTANCE;
        Map<String, Object> m = reg.getExtensionToFactoryMap();
        m.put("simulink", new XMIResourceFactoryImpl());

        // Obtain a new resource set
        ResourceSet rs = new ResourceSetImpl();

        // Set the save name
        String path = importedModelName + ".simulink";

        // Create a resource then add the model to it
        Resource saveResource = rs.createResource(URI.createFileURI(path));
        saveResource.getContents().add(simulinkModel);

        try {
            if (ImportMode.DEEP.equals(importMode) || ImportMode.REFERENCING.equals(importMode)) {
                // Save all referenced models in a separate folder
                String referencesFolder = referencesFolderName + REFERENCES_FOLDER_SUFFIX + File.separator;
                saveReferences(referencedModels.values(),savePath, rs, referencesFolder);
                saveReferences(referencedLibraries.values(),savePath, rs, referencesFolder);
            }
            // Now save the model with the added content.
            saveResource.save(Collections.EMPTY_MAP);
        } catch (IOException e) {
            throw new SimulinkApiException("Exception occurred while saving imported models!", e);
        }
        logger.debug("Model" + importedModelName + " saved");
    }

    private void saveReferences(Collection<SimulinkModel> simulinkModels,String savePath, ResourceSet rs, String referencesFolder) throws IOException {
        for (SimulinkModel sm : simulinkModels) {
            String fileName = sm.getSimulinkRef().getName() + ".simulink";
            Resource sr = rs.createResource(URI.createFileURI(savePath + referencesFolder + fileName));
            sr.getContents().add(sm);
            sr.save(Collections.EMPTY_MAP);
        }
    }

    /**
     * Traverse the <code>model</code> and generate the EMF representation. This function uses DFS (recursive).
     * 
     * @param importMode
     *            the way the model should be imported.
     * @param im
     *            portedLibraryName the name of the Simulink model that is to be created
     * @throws IOException
     * @throws SimulinkApiException
     */
    public void traverseAndCreateEMFModel(ImportMode importMode) throws SimulinkApiException {
        logger.debug("Starting model import...");
        // Import time measurement begin
        long beginTime = System.currentTimeMillis();

        // Set traverse mode
        this.importMode = importMode;

        if(importMode==ImportMode.REFERENCING){
            filters.add(new ReferencingImportFilter());
        }
        
        simulinkModel = SimulinkFactory.eINSTANCE.createSimulinkModel();
        simulinkModel.setFile(model.getLoadPath());

        modelFQN = model.getFullyQualifiedName();

        // Load the model in Simulink
        MatlabCommand loadSystem = commandFactory.loadSytem().addParam(model.getFullyQualifiedName());
        loadSystem.execute();

        // Registering a resource factory for the extension "simulink"
        Resource.Factory.Registry reg = Resource.Factory.Registry.INSTANCE;
        Map<String, Object> m = reg.getExtensionToFactoryMap();
        m.put("simulink", new XMIResourceFactoryImpl());

        // Obtain a new resource set
        ResourceSet rs = new ResourceSetImpl();

        // The base resource name, will not be persisted. The function saveEMFModel(...) writes the model to a file.
        // It is necessary to place it into a resource to have IncQuery operate properly
        String path = "notSerializedResource.simulink";
        Resource saveResource = rs.createResource(URI.createFileURI(path));
        saveResource.getContents().add(simulinkModel);

        // Create a SimulinkReference for the name of the model
        createAndSetSimulinkRef(modelFQN, null, simulinkModel);


        // Set the parameters of the model itself

        // Set file name first
        MatlabCommand getFilePath = commandFactory.getParam().addParam(modelFQN).addParam("FileName");
        String filePath = MatlabString.getMatlabStringData(getFilePath.execute());

        // Set if it is a library
        MatlabCommand getIsLibrary = commandFactory.getParam().addParam(modelFQN).addParam("BlockDiagramType");
        String blockDiagramType = MatlabString.getMatlabStringData(getIsLibrary.execute());
        if ("library".equals(blockDiagramType)) {
            simulinkModel.setLibrary(true);
        } else {
            simulinkModel.setLibrary(false);
        }

        // Get rid of the newline characters. Replace them with the Simulink equivalent space
        if (filePath.contains("\n"))
            filePath = filePath.replace("\n", " ");

        // Get model name
        MatlabCommand getFileparts = commandFactory.fileParts().addParam(filePath);
        List<IVisitableMatlabData> fileparts = CellMatlabData.getCellMatlabDataData(getFileparts.execute());

        String fileName = MatlabString.getMatlabStringData(fileparts.get(1))
                + MatlabString.getMatlabStringData(fileparts.get(2));

        // Set the file field for the EMF model
        simulinkModel.setFile(fileName);


        // Create blocks
        createBlocksFromTopLevel(simulinkModel);

        // Create ports
        createPorts();

        // Create connections
        createConnections();

        // Create port mappings
        createMappings();

        // Connect goto, from and goto tag visibility blocks
        connectFromsToGotos(simulinkModel);

        // Postprocess step: get rid of the shadow inports
        removeShadowInports();

        // Postprocess step: create mappings
        createBusSignalMappings(rs);

        // Get the modification date and set it as the version of the model
        // If a version is not set for a model or library, that means that the import was interrupted.
        MatlabCommand getModificationDate = commandFactory.getParam().addParam(simulinkModel.getSimulinkRef().getFQN()).addParam("LastModifiedDate");
        String lastModificationDate = MatlabString.getMatlabStringData(getModificationDate.execute());
        simulinkModel.setVersion(lastModificationDate);
        
        // End of import
        logger.debug("IMPORT TIME TOTAL: " + (System.currentTimeMillis() - beginTime) + "ms");
    }

    private void createBusSignalMappings(ResourceSet rs) {

        MultiStatus errors = new MultiStatus(SimulinkApiPlugin.PLUGIN_ID, BUS_SIGNAL_MAPPING_ERROR_CODE,
                "Errors occurred while creating bus mapping", null);

        BusSignalMapper mapper = new BusSignalMapper(rs);
        ISimulinkAPILogger simulinkAPILogger = getLogger();
        mapper.setLogger(simulinkAPILogger);
        BusSignalMappingCreator mappingCreator = new BusSignalMappingCreator(mapper);
        for (BusSelector selector : busSelectorToDestinationPorts.keySet()) {
            try {
                mappingCreator.createBusMapping(selector);
            } catch (IllegalStateException ise) {
                errors.add(new Status(Status.ERROR, SimulinkApiPlugin.PLUGIN_ID,
                        "Illegal state during bus signal mapping: " + ise.getMessage(), ise));
            } catch (IllegalArgumentException iae) {
                errors.add(new Status(Status.ERROR, SimulinkApiPlugin.PLUGIN_ID,
                        "Illegal argument when calling bus signal mapping: " + iae.getMessage(), iae));
            }
        }
        if (errors.getChildren().length > 0) {
            if (simulinkAPILogger instanceof PluginSimulinkAPILogger) {
                ((PluginSimulinkAPILogger) simulinkAPILogger).logStatusToPluginLogger(errors);
            } else {
                simulinkAPILogger.error(errors.getMessage());
                for (IStatus error : errors.getChildren()) {
                    simulinkAPILogger.error(error.getMessage(), error.getException());
                }
            }
        }
    }

    /**
     * As a postprocess step remove all InportShadow blocks from the EMF model and redirect all references to the
     * corresponding Inport block
     */
    private void removeShadowInports() {

        // For each shadow inport do the cleanup
        for (InPortBlock shadowInportBlock : shadowInports.keySet()) {
            // Get the corresponding inport block and the outports
            MatlabString inportBlockName = shadowInports.get(shadowInportBlock);
            InPortBlock inportBlock = inportBlocksByName.get(inportBlockName.getData());
            OutPort shadowOutPort = shadowInportBlock.getOutports().get(0);
            OutPort outPort = inportBlock.getOutports().get(0);

            // Reroute connections to the inport block

            // Get all connections from the shadow inport block
            Connection shadowConnection = shadowOutPort.getConnection();

            // Get the connections of the original inport block
            Connection originalConnection = outPort.getConnection();
            MultiConnection multiConn = null;

            // Redirect the connections of the shadow inport block
            // Need to branch according to the existing line connections to cover all possible cases
            if (originalConnection == null) {
                if (shadowConnection != null)
                    outPort.setConnection(shadowConnection);
            } else {
                if (originalConnection instanceof SingleConnection) {
                    MultiConnection newMultiConnection = SimulinkFactory.eINSTANCE.createMultiConnection();
                    IdentifierReference multiconnSimulinkReference = EcoreUtil
                            .copy(originalConnection.getSimulinkRef());
                    multiconnSimulinkReference.setName("ARTIFICIAL MULTICONNECTION DUE TO SHADOW INPORT TO PORT: "
                            + outPort.getSimulinkRef().getFQN());
                    newMultiConnection.getConnections().add((SingleConnection) originalConnection);
                    newMultiConnection.setSimulinkRef(multiconnSimulinkReference);
                    multiConn = newMultiConnection;
                    outPort.setConnection(multiConn);
                } else {
                    multiConn = (MultiConnection) originalConnection;
                }

                if (shadowConnection instanceof SingleConnection) {
                    multiConn.getConnections().add((SingleConnection) shadowConnection);
                } else {
                    multiConn.getConnections().addAll(((MultiConnection) shadowConnection).getConnections());
                }
            }

            // Delete the shadow inport from the model
            EcoreUtil.delete(shadowInportBlock, true);

        }
    }

    /**
     * For each goto block find the corresponding from block
     * 
     * @param simulinkModel
     *            the EMF model to create from the Simulink model
     */
    private void connectFromsToGotos(SimulinkModel simulinkModel) {

        // TODO visibility: local - no tags searched

        // scoped - a goto tag visibility block should be added
        for (Goto gotoBlock : gotos.keySet()) {
            // Get the FQNs of the connected from blocks
            List<String> fromNames = gotos.get(gotoBlock);

            // For each name get the from block and set the goto block
            for (String fromName : fromNames) {
                From from = froms.get(fromName);
                if(from!=null){
                    from.setGotoBlock(gotoBlock);
                }
                else {
                    logger.error("The from block '" + fromName + "' for goto "+ gotoBlock.getSimulinkRef().getFQN() + " could not be found!");
                }
            }

            // Set goto tag
            String gotoTag = gotoBlock.getGotoTag();

            // If there is a goto tag visibility block associated, set the reference
            List<GotoTagVisibility> gotoTagVisibilityBlocks = gotoTagVisibilities.get(gotoTag);
            if (gotoTagVisibilityBlocks != null){
                for (GotoTagVisibility gotoTagVisibility : gotoTagVisibilityBlocks) {
                    gotoTagVisibility.setGotoBlock(gotoBlock);
                }
            }
        }

    }

    /**
     * Creates the blocks according to the top level of the Simulink model, then traverses the further layers if
     * necessary.
     * 
     * @param simulinkModel
     *            the EMF model to create from the Simulink model
     * @throws SimulinkApiException
     * @throws IOException
     */
    private void createBlocksFromTopLevel(SimulinkModel simulinkModel) throws SimulinkApiException {
        // Get the top level block handles
        logger.debug("Traversing top level blocks");
        MatlabCommand findTopLevelBlockHandles = commandFactory.findSystem().addParam(modelFQN).addParam("SearchDepth").addParam(1.0).addParam("LookUnderMasks")
                .addParam("all").addParam("FindAll").addParam("on").addParam("FollowLinks").addParam("on")
                .addParam("type").addParam("block");
        IVisitableMatlabData toplevelBlockHandles = findTopLevelBlockHandles.execute();

        // Get the handle of the model itself
        MatlabCommand getModelHandle = commandFactory.getParam().addParam(modelFQN).addParam("Handle");
        Double modelHandle = Handle.getHandleData(getModelHandle.execute());

        // Traversing from each block
        for (IVisitableMatlabData currentBlockHandle : CellMatlabData.getCellMatlabDataData(toplevelBlockHandles)) {
            // If the handle refers to the subsystem block we are traversing, continue
            if (Handle.getHandleData(currentBlockHandle) == modelHandle)
                continue;
            createBlock(simulinkModel, (Handle) currentBlockHandle);
        }
        logger.debug("Top level blocks traversed");
    }

    /**
     * Recursive function to traverse the sub blocks and hierarchically create the block structure of the EMF model
     * 
     * @param parentBlockHandle
     *            the MATLAB handle of the current block
     * @throws SimulinkApiException
     * @throws IOException
     */
    private void createBlocksFromSubBlocks(Handle parentBlockHandle, Block parentBlock)
            throws SimulinkApiException {

        // Get the name of the root model element
    	MatlabCommand getRootName = commandFactory.getFullName().addParam(parentBlockHandle);
        IVisitableMatlabData name = getRootName.execute();

        // Retrieve potential sub block handles
        MatlabCommand findSubBlocks = commandFactory.findSystem().addParam(name).addParam("SearchDepth").addParam(1.0).addParam("LookUnderMasks").addParam("all")
                .addParam("FollowLinks").addParam("on").addParam("FindAll").addParam("on").addParam("type")
                .addParam("block");
        CellMatlabData subBlockHandles = CellMatlabData.asCellMatlabData(findSubBlocks.execute());

        // Iterate over all handles except for the root
        // If not only one handle is returned then it has sub blocks
        if (subBlockHandles.size() > 1) {
            parents.add(parentBlock);
        }

        // For each sub block do the traversing
        for (IVisitableMatlabData subBlockHandle : subBlockHandles.getDatas()) {
            if (Handle.getHandleData(subBlockHandle).compareTo(parentBlockHandle.getData()) != 0) {
                createBlock(parentBlock, (Handle) subBlockHandle);
            }
        }
    }

    /**
     * Create the block under the given parent for the given port handle
     * 
     * @param currentBlockHandle
     *            the handle of the current block in Matlab
     * @param parentBlock
     *            the parent EMF object of the to be created block
     * @throws SimulinkApiException
     * @throws IOException
     */
    private void createBlock(SimulinkElement parentSimulinkElement, Handle currentBlockHandle)
            throws SimulinkApiException {
        logger.debug("Traversing block " + parentSimulinkElement.getSimulinkRef().getFQN() + " ...");
        // Get the type of the block
        MatlabCommand getBlockType = commandFactory.get().addParam(currentBlockHandle).addParam("BlockType");
        String blockType = MatlabString.getMatlabStringData(getBlockType.execute());

        // Get the name of the block
        MatlabCommand getBlockName = commandFactory.get().addParam(currentBlockHandle).addParam("Name");
        String blockName = MatlabString.getMatlabStringData(getBlockName.execute());
        // Escape the character '/' in the name. It is needed in order to differentiate hierarchy level changes and
        // slashes in names
        blockName = blockName.replace("/", "//");

        // Create the block instance
        Block block = createBlockInstance(blockType, blockName, parentSimulinkElement.getSimulinkRef());
        // TODO a null check + return was removed from here for block - NEEDS TESTING, then delete this message
        // Add it as a sub block
        if (parentSimulinkElement instanceof SimulinkModel) {
            ((SimulinkModel) parentSimulinkElement).getContains().add(block);
        } else if (parentSimulinkElement instanceof SubSystem) {
            ((SubSystem) parentSimulinkElement).getSubBlocks().add(block);
        }

        // All blocks that were created are cached here. They are referenced using their unique FQNs
        blocks.put(block.getSimulinkRef().getFQN(), block);

        // Apply filter on the currently created block
        if (!isFiltered(block)) {
            // Create sub blocks if not filtered
            // Recursively call this traversing function
            createBlocksFromSubBlocks(currentBlockHandle, block);
        }
        logger.debug("Block " + parentSimulinkElement.getSimulinkRef().getFQN() + " is traversed");
    }

    /**
     * Checks if a subsystem block should be filtered or not.
     * 
     * @param block
     *            Block that should be checked for filtering
     * @return <code>true</code>, if the sub blocks of block are not supposed to be created in EMF
     */
    private boolean isFiltered(Block block) {
        boolean filtered = false;
        for (ISimulinkImportFilter filter : filters) {
            if (filter.filter(commandFactory, block.getSimulinkRef().getFQN())) {
                filtered = true;
                break;
            }
        }
        return filtered;
    }

    /**
     * Creates a block from the appropriate type.
     * 
     * @param blockType
     *            the type returned by MATLAB
     * @param blockName
     *            the name of the block to be created
     * @param parentSimRef
     *            the parent object's SimulinkReference. This will determine the new block's qualifier
     * @return the instance of the class Block or a subclass of Block
     * @throws SimulinkApiException
     * @throws IOException
     */
    private Block createBlockInstance(String blockType, String blockName, SimulinkReference parentSimRef)
            throws SimulinkApiException {

        // Obtain the block provider corresponding to the block type
        BlockProvider provider = new BlockProvider();
        IBlockAdapter adapter = provider.adapt(blockType);

        // Create the block, set the SimulinkReference
        Block createdBlock = adapter.getBlock(this);
        createAndSetSimulinkRef(blockName, parentSimRef, createdBlock);

        // Process the created blockk
        adapter.process(this, parentSimRef, createdBlock);
        // TODO a null check + return was removed from here for createdBlock - NEEDS TESTING, then delete this message

        // Create and set the SimulinkReference of the source block
        MatlabCommand getReferenceBlockFQN = commandFactory.getParam().addParam(createdBlock.getSimulinkRef().getFQN()).addParam("ReferenceBlock");
        String sourceBlockFQN = MatlabString.getMatlabStringData(getReferenceBlockFQN.execute());

        // If no ReferenceBlock is set, check the AncestorBlock. It might be set in case of disabled links.
        if ("".equals(sourceBlockFQN)) {
        	MatlabCommand getAncestorBlockFQN = commandFactory.getParam().addParam(createdBlock.getSimulinkRef().getFQN()).addParam("AncestorBlock");
            sourceBlockFQN = MatlabString.getMatlabStringData(getAncestorBlockFQN.execute());
        }

        // Create source ref if the FQN is not empty
        String sourceBlockName = null;
        String sourceBlockQualifier = null;
        if ("".equals(sourceBlockFQN)) {
            // If empty, create source reference according to the type of the block

            // In case of a bad link (e.g. a library is missing) use the 'SourceType' property value as the block type
            // if it contains usable information
            if (blockType.equals("Reference")) {
                // Get the reference's source type and source block
            	MatlabCommand getSourceType = commandFactory.getParam().addParam(createdBlock.getSimulinkRef().getFQN()).addParam("SourceType");
                String sourceType = MatlabString.getMatlabStringData(getSourceType.execute());

                MatlabCommand getSourceBlock = commandFactory.getParam().addParam(createdBlock.getSimulinkRef().getFQN()).addParam("SourceBlock");
                sourceBlockFQN = MatlabString.getMatlabStringData(getSourceBlock.execute());
                if (!sourceType.equals("") && !sourceType.equals("Unknown")) {
                    // If set, set it as the type of the block
                    // TODO blockType is not used after this assignment!
                    blockType = sourceType;
                }
            } else if (blockType.equals("SubSystem")) {
                // In this special case, we know which block is the source block
                // There is too much block with type SubSystem anyway...
                sourceBlockFQN = "simulink/Ports & Subsystems/Subsystem";
            } else {
                // Find the reference block by type in the basic library named 'simulink'
            	MatlabCommand openSimulinkLibrary = commandFactory.loadSytem().addParam("simulink");
                openSimulinkLibrary.execute();

				MatlabCommand findPotentialSourceBlocks = commandFactory.findSystem().addParam("simulink")
						.addParam("Type").addParam("Block").addParam("BlockType").addParam(blockType);
				IVisitableMatlabData potentialSourceBlockHandles = findPotentialSourceBlocks.execute();

                SourceBlockGetterVisitor sourceBlockNameGetter = new SourceBlockGetterVisitor();

                // A block with the given type was found in the current library
                if (potentialSourceBlockHandles != null) {
                    CellMatlabData potentialSourceBlockNames = new CellMatlabData();
                    for (IVisitableMatlabData potentialSourceBlockHandle : CellMatlabData
                            .getCellMatlabDataData(potentialSourceBlockHandles)) {
                    	MatlabCommand getFullName = commandFactory.getFullName().addParam(potentialSourceBlockHandle);
                        IVisitableMatlabData potentialSourceBlockName = getFullName.execute();
                        potentialSourceBlockNames.addData(potentialSourceBlockName);
                    }
                    potentialSourceBlockNames.acceptDataVisitor(sourceBlockNameGetter);
                }

                // If the found block is not found in the 'simulink' library, then look further in all the other
                // libraries
                if (sourceBlockNameGetter.getSourceBlockFQN() == null) {

                    IVisitableMatlabData libnames = null;
                    // TODO embed script code to source here
                    MatlabCommand libraryCollector = commandFactory.customCommand("library_collector", 1);
                    libnames = libraryCollector.execute();

                    // Look in each library until a block with the same type is found
                    for (IVisitableMatlabData libname : CellMatlabData.getCellMatlabDataData(libnames)) {
                    	MatlabCommand loadLibrary = commandFactory.loadSytem().addParam(libname);
                        loadLibrary.execute();

                        MatlabCommand findFurtherPotentialSourceBlocks = commandFactory.findSystem().addParam(libname).addParam("FindAll").addParam("On")
                                .addParam("Lookundermasks").addParam("All").addParam("Type").addParam("Block")
                                .addParam("BlockType").addParam(blockType);
						IVisitableMatlabData furtherPotentialSourceBlockHandles = findFurtherPotentialSourceBlocks.execute();

                        if (furtherPotentialSourceBlockHandles != null) {
                        	MatlabCommand getFullNames = commandFactory.getFullName().addParam(furtherPotentialSourceBlockHandles);
                            IVisitableMatlabData furtherPotentialSourceBlockNames = getFullNames.execute();
                            furtherPotentialSourceBlockNames.acceptDataVisitor(sourceBlockNameGetter);
                        }
                        if (sourceBlockNameGetter.getSourceBlockFQN() != null) {
                            break;
                        }
                    }
                }
                // Cache the found source block FQN
                sourceBlockFQN = sourceBlockNameGetter.getSourceBlockFQN();

            }

        }

        if (sourceBlockFQN == null || sourceBlockFQN.equals("")) {
            logger.warning("The reference block could not be determined for block: "
                    + createdBlock.getSimulinkRef().getFQN());
        } else {
            // Calculate the parameters of the EMF block object
            sourceBlockName = sourceBlockFQN.lastIndexOf('/') == -1 ? sourceBlockFQN : sourceBlockFQN
                    .substring(sourceBlockFQN.lastIndexOf('/') + 1);
            sourceBlockQualifier = sourceBlockFQN.lastIndexOf('/') == -1 ? null : sourceBlockFQN.substring(0,
                    sourceBlockFQN.lastIndexOf('/'));
        }

        // Set the parameters of the EMF block object
        createdBlock.setSourceBlockRef(SimulinkUtil.createLinkReference(sourceBlockName, sourceBlockQualifier));

        // When creating subsystems, the link status has to be checked
        if (createdBlock instanceof SubSystem) {
        	MatlabCommand getLinkStatus = commandFactory.getParam().addParam(createdBlock.getSimulinkRef().getFQN()).addParam("LinkStatus");
            String linkStatus = MatlabString.getMatlabStringData(getLinkStatus.execute());
            // If the link is active, the above command in matlab returns the string "resolved"
            // Other possible values:
            // "resolved" - active link
            // "none" - no link
            // "unresolved" - the referenced library block is missing, BUT: the block is linked!! (if it wasn't so, only
            // a block with a disabled link could be seen)
            // "implicit" - the link is active, but refers to a block, that is not linked further (e.g. a gain block
            // inside a block that is linked to a library block(that also contains a corresponding gain block))
            // See more at http://www.mathworks.co.uk/help/simulink/ug/working-with-library-links.html#brknia1-1
            // "inactive" - the link is disabled
            boolean disabledLink = !"resolved".equals(linkStatus) && !"implicit".equals(linkStatus)
                    && !"unresolved".equals(linkStatus);
            if (disabledLink) {
                // disable the link, when it is not resolved, implicit nor unresolved
                // in other words: disable the link, when "none" or "inactive"
                createdBlock.getSourceBlockRef().setDisabled(true);
            }
        }

        // Return the ready block
        return createdBlock;
    }

    /**
     * Creates and sets the simulink reference for a simulink element
     * 
     * @param name
     *            the name of the Simulink element
     * @param parentSimRef
     *            the qualifier of the Simulink element
     * @param element
     *            the SimulinkElement object itself
     */
    private void createAndSetSimulinkRef(String name, SimulinkReference parentSimRef, SimulinkElement element) {
        IdentifierReference blockSimRef = SimulinkUtil.createIdentifierReference(name, parentSimRef == null ? null
                : parentSimRef.getFQN());
        element.setSimulinkRef(blockSimRef);
    }

    /**
     * Create the port objects and set the reference to the corresponding port block
     * 
     * @throws SimulinkApiException
     */
    private void createPorts() {

        logger.debug("Creating ports...");
        
        // Create the port provider object needed for port import
        PortProvider portProvider = new PortProvider();

        // Iterate over each block
        for (Block parentBlock : blocks.values()) {

            // Obtain port handles description struct
            String parentBlockFQN = parentBlock.getSimulinkRef().getFQN();
            MatlabCommand getPortHandlesStruct = commandFactory.getParam().addParam(parentBlockFQN).addParam("PortHandles");
            StructMatlabData portHandles = StructMatlabData.asStructMatlabData(getPortHandlesStruct.execute());

            // Process outports
            List<IVisitableMatlabData> outportHandles = CellMatlabData.getCellMatlabDataData(portHandles
                    .getData("Outport"));
            for (IVisitableMatlabData iVisitableMatlabData : outportHandles) {
                Handle outportHandle = Handle.asHandle(iVisitableMatlabData);
                createAndAddPort(parentBlock, portProvider, outportHandle, "Outport");
            }
            
            // Process state ports
            List<IVisitableMatlabData> stateHandles = CellMatlabData.getCellMatlabDataData(portHandles
                    .getData("State"));
            for (IVisitableMatlabData iVisitableMatlabData : stateHandles) {
                Handle outportHandle = Handle.asHandle(iVisitableMatlabData);
                createAndAddPort(parentBlock, portProvider, outportHandle, "Outport");
            }
            
            // Process inports
            List<IVisitableMatlabData> inportHandles = CellMatlabData.getCellMatlabDataData(portHandles
                    .getData("Inport"));
            for (IVisitableMatlabData iVisitableMatlabData : inportHandles) {
                Handle inportHandle = Handle.asHandle(iVisitableMatlabData);
                createAndAddPort(parentBlock, portProvider, inportHandle, "Inport");
            }

            // Process triggerports
            List<IVisitableMatlabData> triggerportHandles = CellMatlabData.getCellMatlabDataData(portHandles
                    .getData("Trigger"));
            for (IVisitableMatlabData iVisitableMatlabData : triggerportHandles) {
                Handle triggerportHandle = Handle.asHandle(iVisitableMatlabData);
                createAndAddPort(parentBlock, portProvider, triggerportHandle, "Trigger");
            }

            // Process enableports
            List<IVisitableMatlabData> enableportHandles = CellMatlabData.getCellMatlabDataData(portHandles
                    .getData("Enable"));
            for (IVisitableMatlabData iVisitableMatlabData : enableportHandles) {
                Handle enableportHandle = Handle.asHandle(iVisitableMatlabData);
                createAndAddPort(parentBlock, portProvider, enableportHandle, "Enable");
            }
        }
        logger.debug("Ports created");
    }

    /**
     * Creates ports for the given parent block. Also connects the port blocks to the corresponding ports.
     * 
     * @param parent
     *            the block who holds the port
     * @param portProvider
     *            the provider object for the port adapters
     * @param portHandle
     *            the currently processed port handle
     * @param portType
     *            the type of the port (written in a string)
     */
    private void createAndAddPort(Block parent, PortProvider portProvider, Handle portHandle, String portType) {
        // Get the port adapter that contains block creation and processing logic
        IPortAdapter portAdapter = portProvider.adapt(portType);
        // Setting the name of the port according to its port number
        MatlabCommand getPortNumber = commandFactory.getParam().addParam(portHandle).addParam("PortNumber");
        Integer portNumber = Handle.getHandleData(getPortNumber.execute()).intValue();
        Port port = null;
        // TODO for now handle state ports the same way as we would handle outports
        if (portType.equalsIgnoreCase("outport") || portType.equalsIgnoreCase("state")) {
            port = portAdapter.createPort(parent, portHandle, outPorts);
            createAndSetSimulinkRef("outport." + portNumber.toString(), parent.getSimulinkRef(), port);
            cachedOutPortHandles.put((OutPort) port, Handle.getHandleData(portHandle));
        } else {
            port = portAdapter.createPort(parent, portHandle, inPorts);
            createAndSetSimulinkRef("inport." + portNumber.toString(), parent.getSimulinkRef(), port);
        }

        // Tells if the block contains created and registered subblocks
        boolean isParent = parents.contains(parent);
        if (isParent) {
            // Obtaining the considerable set of OutPortBlocks and InPortBlocks
            Set<InPortBlock> inPortBlockSet = inPortBlocks.get(parent.getSimulinkRef().getFQN());
            Set<OutPortBlock> outPortBlockSet = outPortBlocks.get(parent.getSimulinkRef().getFQN());

            PortBlock portBlock = portAdapter.connectToBlock(port, portHandle, portNumber, inPortBlockSet,
                    outPortBlockSet, this);

            // Creating the reference between the port and the portBlock
            if (portBlock != null)
                // It is possible in Simulink to create port in a subsystem without portblock by writing
                // higher portnumber to an existing block
                if (!((portBlock instanceof InPortBlock) && shadowInports.keySet().contains(portBlock)))
                    portBlock.setPort(port);
        }
        // else {
        // If a block has no sub blocks
        // No actions
        // }
    }

    /**
     * Creates connections between ports
     * 
     * TODO: revisit naming, see REQ-025 "all signals shall be named" Where does the signal name go in the model?
     * 
     * @throws SimulinkApiException
     */
    private void createConnections() throws SimulinkApiException {
        logger.debug("Creating connections...");
        // Processing the lines on the diagram
        for (OutPort outp : outPorts.values()) {
            Double outHandle = cachedOutPortHandles.get(outp);

            MatlabCommand getLineHandles = commandFactory.getParam().addParam(outHandle).addParam("Line");
            IVisitableMatlabData lineHandle = getLineHandles.execute();

            // If there is a line going out from the outport
            if (Handle.getHandleData(lineHandle) > -0.9) {

            	MatlabCommand getInputPortHandles = commandFactory.getParam().addParam(lineHandle).addParam("DstPortHandle");
                IVisitableMatlabData inputPortHandles = getInputPortHandles.execute();

                // Iterate over all connected input ports
                for (IVisitableMatlabData data : CellMatlabData.getCellMatlabDataData(inputPortHandles)) {
                    Handle dstPortHandle = Handle.asHandle(data);

                    // There is a connection on the diagram that leads to nowhere
                    // For it has no effect, skip it
                    if (dstPortHandle.getData() < -0.9) {
                        continue;
                    }

                    // Create a connection named line
                    SingleConnection line = SimulinkFactory.eINSTANCE.createSingleConnection();

                    // Add the destination input port to line
                    line.setTo(inPorts.get(dstPortHandle.getData()));

                    // TODO in the following lines pay attention to cases, when blocks in the model are
                    // commented out, but their connections still present. In such cases a nullPointerException
                    // is thrown if an inport handle is queried of a commented block.

                    // Naming the line according to the source and the destination
                    MatlabCommand getSrcParent = commandFactory.get().addParam(cachedOutPortHandles.get(outp)).addParam("Parent");
                    String srcParentName = MatlabString.getMatlabStringData(getSrcParent.execute());
                    String srcParentLocalName = srcParentName.substring(srcParentName.lastIndexOf('/') + 1);

                    MatlabCommand getDstParent = commandFactory.get().addParam(dstPortHandle).addParam("Parent");
                    String dstParentName = MatlabString.getMatlabStringData(getDstParent.execute());
                    String dstParentLocalName = dstParentName.substring(dstParentName.lastIndexOf('/') + 1);

                    String source = srcParentLocalName + ":" + outPorts.get(cachedOutPortHandles.get(outp)).getName();
                    String destination = dstParentLocalName + ":" + inPorts.get(dstPortHandle.getData()).getName();
                    String lineFQN = "from: " + source + " -- to: " + destination;

                    createAndSetSimulinkRef(lineFQN, outp.getSimulinkRef(), line);

                    // Set line name attribute
                    String lineName = "";

                    // Obtain the name from Simulink
                    MatlabCommand getLineName = commandFactory.getParam().addParam(lineHandle).addParam("Name");
                    lineName = MatlabString.getMatlabStringData(getLineName.execute());
                    // Set the line name (empty is considered not set)
                    line.setLineName(Strings.emptyToNull(lineName));

                    if (outp.getConnection() != null) {
                        MultiConnection mc = null;
                        if (outp.getConnection() instanceof SingleConnection) {
                            // Add the existing and the newly created SingleConnection to the newly created
                            // MultiConnection
                            mc = SimulinkFactory.eINSTANCE.createMultiConnection();
                            String mcName = outp.getConnection().getName();
                            createAndSetSimulinkRef(mcName, outp.getSimulinkRef(), mc);
                            mc.getConnections().add((SingleConnection) outp.getConnection());
                            mc.getConnections().add(line);
                            outp.setConnection(mc);
                        } else {
                            // Get the existing MultiConnection and add the newly created SingleConnection
                            mc = (MultiConnection) outp.getConnection();
                            mc.getConnections().add(line);
                        }
                        mc.getSimulinkRef().setName(mc.getName().concat(" ; " + destination));
                        mc.setLineName(lineName);
                    } else {
                        // Add add the SingleConnection to the line
                        outp.setConnection(line);
                    }
                }
            }
            // else {
            // There was no line connected to the output

        }
        logger.debug("Connections created");
    }

    /**
     * Creates mappings for bus selectors. Also sets the mapping path and destination outport for the mapping, but the
     * source remains unset.
     */
    private void createMappings() {
        logger.debug("Processing bus selectors...");
        for (BusSelector busSelector : busSelectorToDestinationPorts.keySet()) {

            // List<Handle> srcPortHandleList = busSelectorToSourcePorts.get(busSelector);
            List<Handle> dstPortHandleList = busSelectorToDestinationPorts.get(busSelector);

            // List<OutPort> srcOutPortList = new LinkedList<OutPort>();
            List<OutPort> dstOutPortList = new LinkedList<OutPort>();

            for (int i = 0; i < dstPortHandleList.size(); i++) {
                dstOutPortList.add(outPorts.get(Handle.getHandleData(dstPortHandleList.get(i))));
            }

            Property outputSignals = null;
            EList<Property> properties = busSelector.getProperties();
            for (Property property : properties) {
                if ("OutputSignals".equalsIgnoreCase(property.getName())) {
                    outputSignals = property;
                }
            }

            String[] outputSignalsString = outputSignals.getValue().split(",");

            for (int i = 0; i < outputSignalsString.length; i++) {

                BusSignalMapping busSignalMapping = SimulinkFactory.eINSTANCE.createBusSignalMapping();

                busSignalMapping.setMappingTo(dstOutPortList.get(i));
                busSignalMapping.setMappingPath(outputSignalsString[i]);

                busSelector.getMappings().add(busSignalMapping);

            }
        }
        logger.debug("Bus selectors processed");
    }

    /**
     * @return the defaultSavePath
     */
    public String getDefaultSavePath() {
        return defaultSavePath;
    }

    /**
     * @param defaultSavePath the defaultSavePath to set
     */
    public void setDefaultSavePath(String defaultSavePath) {
        this.defaultSavePath = defaultSavePath;
    }

}
