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
package hu.bme.mit.massif.simulink.api.tests;

import hu.bme.mit.massif.communication.ICommandEvaluator;
import hu.bme.mit.massif.communication.command.MatlabCommandFactory;
import hu.bme.mit.massif.communication.commandevaluation.CommandEvaluatorImpl;
import hu.bme.mit.massif.simulink.api.Importer;
import hu.bme.mit.massif.simulink.api.ModelObject;
import hu.bme.mit.massif.simulink.api.exception.SimulinkApiException;
import hu.bme.mit.massif.simulink.api.provider.filter.IFilterProvider;
import hu.bme.mit.massif.simulink.api.provider.filter.impl.FilterProviderImpl;
import hu.bme.mit.massif.simulink.api.util.ImportMode;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
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

    private PropertyResourceBundle bundle = null;

    @Before
    public void readPropertiesFile() {
        bundle = getBundle();
    }

    @Ignore
    @Test
    public void getAllModelLocations() throws FileNotFoundException, UnsupportedEncodingException {
        String directory = bundle.getString(SettingStrings.MODEL_DIRECTORY);
        String mdlLocationsFile = bundle.getString(SettingStrings.MDL_LOCATIONS);

        List<String> mdlLocations = new LinkedList<String>();
        File modelRoot = new File(directory);
        getMdlFileLocations(modelRoot, mdlLocations);

        PrintWriter writer = null;
        writer = new PrintWriter(mdlLocationsFile, "UTF-8");

        for (String string : mdlLocations) {
            writer.write(string + "\n");
            System.out.println(string);
        }

        if (writer != null) {
            writer.close();
        }
    }

//    @Ignore
    @Test
    public void importAllModels() throws IOException, MatlabRMIException, SimulinkApiException {
        String mdlLocationsFile = bundle.getString(SettingStrings.MDL_LOCATIONS);

        InputStream fis = new FileInputStream(SettingStrings.PROPERTIES_FILE);
        PropertyResourceBundle matlabProperties = new PropertyResourceBundle(fis);
        fis.close();

        MatlabCommandFactory commandFactory = new MatlabCommandFactory(createCommandEvaluator(matlabProperties));

        fis = new FileInputStream(mdlLocationsFile);
        BufferedReader br = new BufferedReader(new InputStreamReader(fis, Charset.forName("UTF-8")));
        String mdlFileName = null;
        while ((mdlFileName = br.readLine()) != null) {
            int lastSeparator = mdlFileName.lastIndexOf('\\');
            String modelPath = mdlFileName.substring(0, lastSeparator + 1);
            String modelName = mdlFileName.substring(lastSeparator + 1, mdlFileName.length() - 4);

            System.out.println("Importing model: " + modelPath+modelName);
            
            commandFactory.addPath().addParam(modelPath).execute();

            // Model name to save the imported Simulink library
            String importedModelName = mdlFileName.replace(".mdl", "");

            // Import mode
            Integer traverseModeInt = Integer.parseInt(matlabProperties.getString(SettingStrings.TRAVERSE_MODE));
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
                	commandFactory.run().addParam(file.getAbsolutePath()).execute();
                }
            }

            ModelObject testModel = new ModelObject(modelName, commandFactory.getCommandEvaluator());
            testModel.setLoadPath(modelPath);

            // Import each model using the FAM Leaf filter
            testModel.registerApplicableFilters("famfilter");

            IFilterProvider filterProvider = new FilterProviderImpl();
            
            Importer traverser = new Importer(testModel, filterProvider);
            traverser.traverseAndCreateEMFModel(traverseMode);
            traverser.saveEMFModel(importedModelName);

            commandFactory.closeSystem().addParam(modelName).execute();
        }
        // Done with the file
        br.close();
        br = null;
        fis = null;

    }

    private ICommandEvaluator createCommandEvaluator(PropertyResourceBundle matlabProperties) throws MatlabRMIException {
        String hostAddress = matlabProperties.getString(SettingStrings.HOST_ADDRESS);
        int hostPort = Integer.parseInt(matlabProperties.getString(SettingStrings.HOST_PORT));
        String serviceName = matlabProperties.getString(SettingStrings.SERVICE_NAME);

        Map<String, Object> evaluatorParameters = new HashMap<String, Object>();
        evaluatorParameters.put("hostAddress", hostAddress);
        evaluatorParameters.put("hostPort", hostPort);
        evaluatorParameters.put("serviceName", serviceName);

        MatlabClient matlabClient = new MatlabClient(hostAddress, hostPort, serviceName);
        return new CommandEvaluatorImpl(matlabClient);
    }

    // Recursive function to get all .mdl files in the directory
    private void getMdlFileLocations(File root, List<String> mdlLocations) {
        if (root.isDirectory()) {
            File[] subFiles = root.listFiles();
            for (File file : subFiles) {
                getMdlFileLocations(file, mdlLocations);
            }
        } else {
            String extension = "";
            int i = root.getAbsolutePath().lastIndexOf('.');
            if (i > 0) {
                extension = root.getAbsolutePath().substring(i + 1);
            }
            if (extension.equals("mdl")) {
                mdlLocations.add(root.getAbsolutePath());
            }
        }

    }

    // Read the corresponding properties file
    private PropertyResourceBundle getBundle() {
        PropertyResourceBundle bundle = null;
        FileInputStream fis = null;
        try {
            try {
                fis = new FileInputStream(SettingStrings.MODEL_DIRECTORY_CONTAINER);
                bundle = new PropertyResourceBundle(fis);
            } catch (FileNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        } finally {
            try {
                fis.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return bundle;
    }

}
