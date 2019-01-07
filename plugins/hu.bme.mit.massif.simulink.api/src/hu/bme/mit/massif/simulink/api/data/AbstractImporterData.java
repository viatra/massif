/*******************************************************************************
 * Copyright (c) 2010-2013, Embraer S.A., Budapest University of Technology and Economics
 * All rights reserved. This program and the accompanying materials 
 * are made available under the terms of the Eclipse Public License v1.0 
 * which accompanies this distribution, and is available at 
 * http://www.eclipse.org/legal/epl-v10.html 
 *
 * Contributors: 
 *     Krisztián Gábor Mayer - initial API and implementation 
 *******************************************************************************/

package hu.bme.mit.massif.simulink.api.data;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import hu.bme.mit.massif.communication.command.MatlabCommandFactory;
import hu.bme.mit.massif.communication.datatype.Handle;
import hu.bme.mit.massif.communication.datatype.MatlabString;
import hu.bme.mit.massif.simulink.BusSelector;
import hu.bme.mit.massif.simulink.From;
import hu.bme.mit.massif.simulink.Goto;
import hu.bme.mit.massif.simulink.GotoTagVisibility;
import hu.bme.mit.massif.simulink.InPortBlock;
import hu.bme.mit.massif.simulink.OutPortBlock;
import hu.bme.mit.massif.simulink.SimulinkModel;
import hu.bme.mit.massif.simulink.api.Importer;
import hu.bme.mit.massif.simulink.api.extension.IBlockImportFilter;
import hu.bme.mit.massif.simulink.api.extension.IParameterImportFilter;
import hu.bme.mit.massif.simulink.api.util.ISimulinkAPILogger;
import hu.bme.mit.massif.simulink.api.util.ImportMode;

public abstract class AbstractImporterData {    
    
    /**
     * If this string is contained in the name it shows that the line in simulink originally was not named
     */       
    public static final String DERIVED_LINE_NAME_INDICATOR = "DERIVED_LINE_NAME";
    public static final String REFERENCES_FOLDER_SUFFIX = "_refs";
    
    /**
     * Shallow copied fields from Importer, please visit the Importer class, as this class wraps an Importer's fields 
     */
    private Handle handle;
    private Set<IParameterImportFilter> parameterFilters;
    private MatlabCommandFactory commandFactory;
    private Map<BusSelector, List<Handle>> busSelectorToDestinationPorts;
    private Map<String, From> forms;
    private Map<Goto, List<String>> gotos;
    private Map<String, List<GotoTagVisibility>> gotoTagVisibilities;
    private ImportMode importMode;
    private ISimulinkAPILogger logger;
    private Map<String, SimulinkModel> referencedModels;
    private Set<IBlockImportFilter> blockFilters;
    private Map<String, LinkedHashSet<InPortBlock>> inPortBlocks;
    private Map<String, InPortBlock> inPortBlocksByName;
    private Map<String, LinkedHashSet<OutPortBlock>> outPortBlocks;
    private Set<String> librariesBeingImported;
    private String defaultSavePath;
    private String referencesFolderName;
    private Map<String, SimulinkModel> referencedLibraries;
    private Map<InPortBlock, MatlabString> shadowInports;
    
    
    public AbstractImporterData(Importer importer, Handle handle) { 
        this.parameterFilters = importer.getParameterFilters();
        this.commandFactory = importer.getCommandFactory();   
        this.handle = handle; 
        this.forms = importer.getFroms(); 
        this.gotos = importer.getGotos();
        this.gotoTagVisibilities = importer.getGotoTagVisibilities();  
        this.importMode = importer.getImportMode();
        this.logger = importer.getLogger();
        this.referencedModels = importer.getReferencedModels();
        this.blockFilters = importer.getBlockFilters();
        this.inPortBlocks = importer.getInPortBlocks();
        this.inPortBlocksByName = importer.getInportBlocksByName();
        this.shadowInports = importer.getShadowInports();
        this.outPortBlocks = importer.getOutPortBlocks();
        this.librariesBeingImported = importer.getLibrariesBeingImported();
        this.defaultSavePath = importer.getDefaultSavePath();
        this.referencesFolderName = importer.getReferencesFolderName();
        this.referencedLibraries = importer.getReferencedLibraries();
    }
    
    public Handle getHandle() {
        return handle;        
    }

    public Set<IParameterImportFilter> getParameterFilters() {
        return parameterFilters;
    }

    public MatlabCommandFactory getCommandFactory() {
        return commandFactory;
    }

    public Map<BusSelector, List<Handle>> getBusSelectorToDestinationPorts() {
        return busSelectorToDestinationPorts;
    }

    public Map<String, From> getFroms() {
        return forms;
    }

    public Map<Goto, List<String>> getGotos() {
        return gotos;
    }

    public Map<String, List<GotoTagVisibility>> getGotoTagVisibilities() {
        return gotoTagVisibilities;
    }

    public ImportMode getImportMode() {
        return importMode;
    }

    public ISimulinkAPILogger getLogger() {
        return logger;
    }

    public Map<String, SimulinkModel> getReferencedModels() {
        return referencedModels;
    }

    public Set<IBlockImportFilter> getBlockFilters() {
        return blockFilters;
    }

    public Map<String, LinkedHashSet<InPortBlock>> getInPortBlocks() {
        return inPortBlocks;
    }

    public Map<String, InPortBlock> getInportBlocksByName() {
        return inPortBlocksByName;
    }

    public Map<InPortBlock, MatlabString>  getShadowInports() {
        return shadowInports;
    }

    public Map<String, LinkedHashSet<OutPortBlock>> getOutPortBlocks() {
        return outPortBlocks;
    }

    public String getDefaultSavePath() {
        return defaultSavePath;
    }
    
    public Map<String, SimulinkModel> getReferencedLibraries() {
        return referencedLibraries;
    }   
    
    public String getReferencesFolderName() {
        return referencesFolderName;
    }
    
    public Set<String> getLibrariesBeingImported() {
        return librariesBeingImported;
    }
}
