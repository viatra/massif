/*******************************************************************************
 * Copyright (c) 2010-2013, Embraer S.A., Budapest University of Technology and Economics
 * All rights reserved. This program and the accompanying materials 
 * are made available under the terms of the Eclipse Public License v1.0 
 * which accompanies this distribution, and is available at 
 * http://www.eclipse.org/legal/epl-v10.html 
 *
 * Contributors: 
 *     Marton Bur, Abel Hegedus, Akos Horvath - initial API and implementation 
 *     Krisztian Gabor Mayer - additional features      
 *******************************************************************************/
package hu.bme.mit.massif.simulink.api.adapter.block;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;

import hu.bme.mit.massif.communication.command.MatlabCommand;
import hu.bme.mit.massif.communication.command.MatlabCommandFactory;
import hu.bme.mit.massif.communication.datatype.MatlabString;
import hu.bme.mit.massif.simulink.Block;
import hu.bme.mit.massif.simulink.SimulinkFactory;
import hu.bme.mit.massif.simulink.SimulinkModel;
import hu.bme.mit.massif.simulink.SubSystem;
import hu.bme.mit.massif.simulink.api.Importer;
import hu.bme.mit.massif.simulink.api.ModelObject;
import hu.bme.mit.massif.simulink.api.dto.AbstractImporterDTO;
import hu.bme.mit.massif.simulink.api.dto.BlockDTO;
import hu.bme.mit.massif.simulink.api.exception.SimulinkApiException;
import hu.bme.mit.massif.simulink.api.extension.impl.ReferencingImportFilter;
import hu.bme.mit.massif.simulink.api.util.ISimulinkAPILogger;
import hu.bme.mit.massif.simulink.api.util.ImportMode;

/**
 * Adapter class for the subsystem
 */
public class SubSystemAdapter extends DefaultBlockAdapter {

    private static final String DATE_FORMAT = "EEE MMM dd HH:mm:ss yyyy";
    private static ReferencingImportFilter referencingFilter = new ReferencingImportFilter();

    @Override
    public Block getBlock(ImportMode importMode) {
        return SimulinkFactory.eINSTANCE.createSubSystem();
    }

    @Override
    public void process(BlockDTO dto) {
        super.process(dto);
        MatlabCommandFactory commandFactory = dto.getCommandFactory();
        SubSystem subSys = (SubSystem) dto.getBlockToProcess();
        String blockFQN = subSys.getSimulinkRef().getFQN();

        MatlabCommand getTagValue = commandFactory.getParam().addParam(blockFQN).addParam("Tag");
        String tagValue = MatlabString.getMatlabStringData(getTagValue.execute());

        subSys.setTag(tagValue);

        if (ImportMode.REFERENCING == dto.getImportMode()) {
            // If the block is filtered, create the referenced library
            if (referencingFilter.filter(commandFactory, blockFQN)) {
            	MatlabCommand getReferenceBlockFQN = commandFactory.getParam().addParam(blockFQN).addParam("ReferenceBlock");
                String sourceBlockFQN = MatlabString.getMatlabStringData(getReferenceBlockFQN.execute());

                int endIndex = sourceBlockFQN.indexOf("/");
                String libraryName = sourceBlockFQN.substring(0, endIndex);

                Set<String> libs = dto.getLibrariesBeingImported();
                if (!libs.contains(libraryName) && !libraryName.startsWith("simulink")) {
                    libs.add(libraryName);
                    traverseReferencedLibrary(dto, libraryName, commandFactory, ImportMode.REFERENCING);
                }

            }

        }
    }

    private SimulinkModel traverseReferencedLibrary(final AbstractImporterDTO importerDTO, String libraryName,
            MatlabCommandFactory commandFactory, ImportMode importMode) {

        Map<String, SimulinkModel> libraryRegistry = importerDTO.getReferencedLibraries();

        if (libraryRegistry.get(libraryName) != null) {
            return libraryRegistry.get(libraryName);
        }

        ModelObject referencedLibrary = new ModelObject(libraryName, commandFactory.getCommandEvaluator());
        Importer referencedLibraryTraverser = new Importer(referencedLibrary, importerDTO.getLogger());
        referencedLibraryTraverser.registerBlockFilters(importerDTO.getBlockFilters());
        referencedLibraryTraverser.registerParameterFilters(importerDTO.getParameterFilters());

        referencedLibraryTraverser.getReferencedLibraries().putAll(libraryRegistry);

        Set<String> librariesBeingImported = importerDTO.getLibrariesBeingImported();
        referencedLibraryTraverser.getLibrariesBeingImported().addAll(librariesBeingImported);

        String referencesFolderPath = importerDTO.getDefaultSavePath() + File.separator + importerDTO.getReferencesFolderName()
                + AbstractImporterDTO.REFERENCES_FOLDER_SUFFIX;
        String referencedLibPath = referencesFolderPath + File.separator + libraryName + ".simulink";

        SimulinkModel actualLibrary = checkLibrary(libraryName, commandFactory, referencedLibPath,
                importerDTO.getLogger());

        if (actualLibrary == null) {
            try {
                referencedLibraryTraverser.setDefaultSavePath(importerDTO.getDefaultSavePath());
                referencedLibraryTraverser.setReferencesFolderName(importerDTO.getReferencesFolderName());
                referencedLibraryTraverser.traverseAndCreateEMFModel(importMode);
                actualLibrary = referencedLibraryTraverser.getSimulinkModel();
            } catch (SimulinkApiException e) {
                importerDTO.getLogger().error("Error during importing the library " + libraryName, e);
            }
        } 
        
        librariesBeingImported.remove(libraryName);

        libraryRegistry.putAll(referencedLibraryTraverser.getReferencedLibraries());
        if (actualLibrary != null) {
            libraryRegistry.put(actualLibrary.getSimulinkRef().getFQN(), actualLibrary);
        }

        return actualLibrary;
    }

    private SimulinkModel checkLibrary(String libraryName, MatlabCommandFactory commandFactory,
            String referencedLibPath, ISimulinkAPILogger logger) {
        File f = new File(referencedLibPath);
        if (f.exists()) {
            // Obtain a new resource set
            ResourceSet rs = new ResourceSetImpl();
            Resource libraryResource = rs.getResource(URI.createFileURI(referencedLibPath), true);
            if (libraryResource.getContents() != null) {
                EObject resourceContent = libraryResource.getContents().get(0);

                if (resourceContent instanceof SimulinkModel) {
                    SimulinkModel simulinkLibrary = (SimulinkModel) resourceContent;
                    String libraryDateString = simulinkLibrary.getVersion();
                    SimpleDateFormat format = new SimpleDateFormat(DATE_FORMAT, Locale.ENGLISH);
                    try {
                        Date importedLibraryDate = format.parse(libraryDateString);

                        MatlabCommand loadSystem = commandFactory.loadSytem().addParam(libraryName);
                        loadSystem.execute();

                        MatlabCommand getModificationDate = commandFactory.getParam().addParam(libraryName).addParam("LastModifiedDate");
                        String lastModificationDate = MatlabString.getMatlabStringData(getModificationDate.execute());
                        Date matlabLibraryDate = format.parse(lastModificationDate);

                        if (matlabLibraryDate.compareTo(importedLibraryDate) < 1) {
                            return (SimulinkModel) resourceContent;
                        }

                    } catch (ParseException e) {
                        logger.error("Library last modification date could not be determined for library "
                                + libraryName + ". Skipping importing.");
                    }
                }
            }
        }
        return null;
    }

}
