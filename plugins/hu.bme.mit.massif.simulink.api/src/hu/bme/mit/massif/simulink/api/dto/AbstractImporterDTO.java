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

package hu.bme.mit.massif.simulink.api.dto;

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

public abstract class AbstractImporterDTO {
    
    
    /**
     * If this string is contained in the name it shows that the line in simulink originally was not named
     */       
    public static final String DERIVED_LINE_NAME_INDICATOR = "DERIVED_LINE_NAME";
    public static final String REFERENCES_FOLDER_SUFFIX = "_refs";
    
    private Handle handle;
    private Set<IParameterImportFilter> parameterFilters;
    private MatlabCommandFactory commandFactory;
    private Map<BusSelector, List<Handle>> busSelectorToDestinationPorts;
    
    public AbstractImporterDTO(Importer importer, Handle handle) { 
        this.parameterFilters = importer.getParameterFilters();
        this.commandFactory = importer.getCommandFactory();   
        this.handle = handle; 
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

    /**
     * @return cache that contains bus selector - destination port mappings
     */
    public Map<BusSelector, List<Handle>> getBusSelectorToDestinationPorts() {
        return busSelectorToDestinationPorts;
    }


    /**
     * @return
     */
    public Map<String, From> getFroms() {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * @return
     */
    public Map<Goto, List<String>> getGotos() {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * @return
     */
    public Map<String, List<GotoTagVisibility>> getGotoTagVisibilities() {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * @return
     */
    public ImportMode getImportMode() {
        // TODO Auto-generated method stub
        return ImportMode.FLATTENING;
    }

    /**
     * @return
     */
    public ISimulinkAPILogger getLogger() {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * @return
     */
    public Map<String, SimulinkModel> getReferencedModels() {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * @return
     */
    public Set<IBlockImportFilter> getBlockFilters() {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * @return
     */
    public Map<String, LinkedHashSet<InPortBlock>> getInPortBlocks() {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * @return
     */
    public Map<String, InPortBlock> getInportBlocksByName() {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * @return
     */
    public Map<InPortBlock, MatlabString>  getShadowInports() {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * @return
     */
    public Map<String, LinkedHashSet<OutPortBlock>> getOutPortBlocks() {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * @return
     */
    public Set<String> getLibrariesBeingImported() {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * @return
     */
    public String getDefaultSavePath() {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * @return
     */
    public String getReferencesFolderName() {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * @return
     */
    public Map<String, SimulinkModel> getReferencedLibraries() {
        // TODO Auto-generated method stub
        return null;
    }   
}
