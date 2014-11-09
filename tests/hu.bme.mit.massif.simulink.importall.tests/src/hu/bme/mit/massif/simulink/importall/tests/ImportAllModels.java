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
package hu.bme.mit.massif.simulink.importall.tests;


import hu.bme.mit.massif.communication.ICommandEvaluator;
import hu.bme.mit.massif.communication.command.MatlabCommand;
import hu.bme.mit.massif.communication.command.MatlabCommandFactory;
import hu.bme.mit.massif.communication.commandevaluation.CommandEvaluatorImpl;
import hu.bme.mit.massif.simulink.api.Importer;
import hu.bme.mit.massif.simulink.api.ModelObject;
import hu.bme.mit.massif.simulink.api.exception.SimulinkApiException;
import hu.bme.mit.massif.simulink.api.provider.filter.IFilterProvider;
import hu.bme.mit.massif.simulink.api.provider.filter.impl.FilterProviderImpl;
import hu.bme.mit.massif.simulink.api.util.ImportMode;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PropertyResourceBundle;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import br.com.embraer.massif.commandevaluation.client.MatlabClient;
import br.com.embraer.massif.commandevaluation.exception.MatlabRMIException;

/**
 * Test case for automation of importing all models (stored in .mdl files) located in a specified directory and its
 * sub-directories.<br>
 * <br>
 * 
 * Usage:<br>
 * 
 * 1. Specify the root directory for the models on the disk in the mdlrootdir.properties file located in the root of
 * this test project (use property "ModelRootDirectory")<br>
 * 
 * 2. Remove the <code>@Ignore</code> annotation from before the <code>getAllModelLocations</code> test case. This will
 * generate a file specified in the mdlrootdir.properties under the property "MdlFileLocations". This file will contain
 * absolute paths for all the .mdl files found in the directory. (Make sure the test case <code>importAllModels</code>
 * is supplied with the annotation <code>@Ignore</code>)<br>
 * 
 * 3. When the test exited with success, edit the file according to your needs: remove undesired (or eventually add
 * full) path for models<br>
 * 
 * 4. Supply the test <code>getAllModelLocations</code> with <code>@Ignore</code> and remove it from before
 * <code>importAllModels</code><br>
 * 
 * 5. Run <code>importAllModels</code>. Finds and runs all .m scripts found in the model directory before model opening.
 * The imported .simulink model files will be placed next to the original .mdl files
 * 
 */
public class ImportAllModels {

    private PropertyResourceBundle directoryProperties = null;
    private PropertyResourceBundle serverAddressProperties = null;
    private PropertyResourceBundle importProperties = null;

    @Before
    public void readPropertiesFile() {
        directoryProperties = getBundle(SettingStrings.MODEL_DIRECTORY_CONTAINER);
        serverAddressProperties = getBundle(SettingStrings.SERVER_ADDRESS_FILE);
        importProperties = getBundle(SettingStrings.PROPERTIES_FILE);
    }

    @Test
    public void testLocationCollector() throws FileNotFoundException, UnsupportedEncodingException {

        getAllModelLocations();

    }

    public List<String> getAllModelLocations() throws FileNotFoundException, UnsupportedEncodingException {
        String[] directory = directoryProperties.getString(SettingStrings.MODEL_DIRECTORY).split("\\|");
        String mdlLocationsFile = directoryProperties.getString(SettingStrings.MDL_LOCATIONS);

        List<String> locations = new ArrayList<String>();

        for (int i = 0; i < directory.length; i++) {
            String dir = directory[i];
            File modelRoot = new File(dir);
            File oldLocations = new File(mdlLocationsFile);
            long lastModified = oldLocations.lastModified();
            List<String> mdlLocations = getMdlFileLocations(modelRoot, lastModified);
            locations.addAll(mdlLocations);
        }

        PrintWriter writer = null;
        writer = new PrintWriter(mdlLocationsFile, "UTF-8");

        for (String string : locations) {
            writer.write(string + "\n");
            System.out.println(string);
        }

        writer.write(mdlLocationsFile + "\n");

        if (writer != null) {
            writer.close();
        }

        return locations;
    }

    @Ignore
    @Test
    public void importAllModels() throws IOException, MatlabRMIException, SimulinkApiException {
        ICommandEvaluator commandEvaluator = createCommandEvaluator();
        MatlabCommandFactory factory = new MatlabCommandFactory(commandEvaluator);
        
        List<String> modelLocations = getAllModelLocations();
        for (String mdlFileName : modelLocations) {

            int lastSeparator = mdlFileName.lastIndexOf('\\');
            String modelPath = mdlFileName.substring(0, lastSeparator + 1);
            String modelName = mdlFileName.substring(lastSeparator + 1, mdlFileName.length() - 4);

            System.out.println("Importing model: " + modelPath+modelName);
            
            MatlabCommand addModelPath = factory.addPath();
            addModelPath.addParam(modelPath);
            addModelPath.execute();

            // Model name to save the imported Simulink library
            String importedModelName = mdlFileName.replace(".mdl", "");

            // Import mode
            Integer traverseModeInt = Integer.parseInt(importProperties.getString(SettingStrings.TRAVERSE_MODE));
            ImportMode traverseMode;
            switch (traverseModeInt) {
            case 2:
                traverseMode = ImportMode.DEEP;
                break;
            case 3:
                traverseMode = ImportMode.FLATTENING;
                break;

            default:
                traverseMode = ImportMode.SHALLOW;
                break;
            }

            // List<String> scriptList = new LinkedList<String>();
            File modelRoot = new File(modelPath);

            // Startup scripts
            for (File file : modelRoot.listFiles()) {
                if (file.getName().endsWith(".m")) {
                    // scriptList.add(file.getAbsolutePath());
                    MatlabCommand script = factory.run();
                    script.addParam(file.getAbsolutePath());
                    script.execute();
                }
            }

            ModelObject testModel = new ModelObject(modelName, commandEvaluator);
            testModel.setLoadPath(modelPath);

            // Import each model using the FAM Leaf filter
            testModel.registerApplicableFilters("famfilter");
            
            IFilterProvider filterProvider = new FilterProviderImpl();

            Importer traverser = new Importer(testModel, filterProvider);
            traverser.traverseAndCreateEMFModel(traverseMode);
            traverser.saveEMFModel(importedModelName);

            MatlabCommand closeSystem = factory.closeSystem();
            closeSystem.addParam(modelName);
            closeSystem.execute();
        }

    }

    private ICommandEvaluator createCommandEvaluator() throws MatlabRMIException {
        String hostAddress = importProperties.getString(SettingStrings.HOST_ADDRESS);
        int hostPort = Integer.parseInt(importProperties.getString(SettingStrings.HOST_PORT));
        String serviceName = serverAddressProperties.getString(SettingStrings.SERVICE_NAME);

        MatlabClient matlabClient = new MatlabClient(hostAddress, hostPort, serviceName);
        return new CommandEvaluatorImpl(matlabClient);
    }

    // Recursive function to get all .mdl files in the directory
    private List<String> getMdlFileLocations(File root, long modifiedSince) {
        List<String> mdlLocations = new LinkedList<String>();
        if (root.isDirectory()) {
            File[] subFiles = root.listFiles();
            for (File file : subFiles) {
                mdlLocations.addAll(getMdlFileLocations(file, modifiedSince));
            }
        } else {
            String extension = "";
            int i = root.getAbsolutePath().lastIndexOf('.');
            if (i > 0) {
                extension = root.getAbsolutePath().substring(i + 1);
            }
            if (extension.equals("mdl") && root.lastModified() > modifiedSince) {
                mdlLocations.add(root.getAbsolutePath());
            }
        }
        return mdlLocations;
    }

    // Read the corresponding properties file
    private PropertyResourceBundle getBundle(String propertyFileName) {
        PropertyResourceBundle bundle = null;
        FileInputStream fis = null;
        try {
            try {
                fis = new FileInputStream(propertyFileName);
                bundle = new PropertyResourceBundle(fis);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } finally {
            try {
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return bundle;
    }

}
