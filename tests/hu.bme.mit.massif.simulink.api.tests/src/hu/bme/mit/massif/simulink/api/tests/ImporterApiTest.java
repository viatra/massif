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

import static java.lang.Math.max;
import static org.junit.Assert.assertTrue;
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
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.PropertyResourceBundle;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import br.com.embraer.massif.commandevaluation.client.MatlabClient;
import br.com.embraer.massif.commandevaluation.exception.MatlabRMIException;

/**
 * This is for demonstration and testing purposes (for trying out) only. Run it as a JUnit plug-in test with the desired
 * plug-in configuration
 * 
 * 
 * 
 */
public class ImporterApiTest {

    /**
     * The command evaluator object used throughout a test session
     */
    private static MatlabCommandFactory commandFactory;

    /**
     * Setup function to connect to MATLAB
     * 
     * @throws FileNotFoundException
     * @throws IOException
     * @throws SimulinkApiException
     */
    @BeforeClass
    public static void createFactory() throws FileNotFoundException, IOException, SimulinkApiException {
        PropertyResourceBundle bundle = null;
        bundle = getBundle();

        // String MatlabPID = bundle.getString(SettingStrings.MATLAB_PID);
        String hostAddress = bundle.getString(SettingStrings.HOST_ADDRESS);
        int hostPort = Integer.parseInt(bundle.getString(SettingStrings.HOST_PORT));
        String serviceName = bundle.getString(SettingStrings.SERVICE_NAME);

        Map<String, Object> evaluatorParameters = new HashMap<String, Object>();
        evaluatorParameters.put("hostAddress", hostAddress);
        evaluatorParameters.put("hostPort", hostPort);
        evaluatorParameters.put("serviceName", serviceName);

        // Begin the line below with // to use the Embraer version of matlab provider, 
        // and begin with a single / to use the open-source matlab control
        
        //*/
        try {
            MatlabClient matlabClient = new MatlabClient(hostAddress, hostPort, serviceName);
            commandFactory = new MatlabCommandFactory( new CommandEvaluatorImpl(matlabClient));
        } catch (MatlabRMIException e) { System.err.println("error"); /* Failed to connect */ }
        /*/
        commandEvaluator = new CommandEvaluatorMCImpl();
        //*/
    }

    /**
     * Test case to import a model that can be found on the MATLAB path
     * 
     * @throws SimulinkApiException
     * @throws IOException
     */
    @Ignore
    @Test
    public void modelByName() throws SimulinkApiException, IOException {

        // Reading the configuration file
        PropertyResourceBundle bundle = null;
        bundle = getBundle();

        // Reading parameter values

        // Library to import and map to the FAM Ecore
        String modelName = bundle.getString(SettingStrings.IMPORT_MODEL_NAME);
        String modelPath = bundle.getString(SettingStrings.IMPORT_MODEL_PATH);

        // Model name to save the imported Simulink library
        String importedModelName = bundle.getString(SettingStrings.IMPORTER_ADDITIONAL_PATH);

        // Additional MATLAB paths
        String[] pathArray = bundle.getString(SettingStrings.IMPORTER_ADDITIONAL_PATH).split("\\|");

        // Import mode
        Integer traverseModeInt = Integer.parseInt(bundle.getString(SettingStrings.TRAVERSE_MODE));
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

        
        // Filter names
        String[] filterArray = bundle.getString(SettingStrings.FILTER).split("\\|");

        // Startup scripts
        String[] scriptArray = bundle.getString(SettingStrings.STARTUP).split("\\|");

        importModel(modelName, modelPath, importedModelName, traverseMode, pathArray, filterArray, scriptArray);
    }

    //@Ignore
    @SuppressWarnings("javadoc")
    @Test
    public void emptyModelTest() throws Exception {
        runTest("empty_model", ImportMode.DEEP, new String[] {}, new String[] {});
    }

    //@Ignore
    @SuppressWarnings("javadoc")
    @Test
    public void simpleIntegratorTest() throws Exception {
        runTest("simple_integrator", ImportMode.DEEP, new String[] {}, new String[] {});
    }

    //@Ignore
    @Test
    public void simpleIOPortsTest() throws Exception {
        runTest("simple_io_ports", ImportMode.DEEP, new String[] {}, new String[] {});
    }

    //@Ignore
    @SuppressWarnings("javadoc")
    @Test
    public void complexWithSubsystemsTest() throws Exception {
        runTest("complex_with_subsystems", ImportMode.DEEP, new String[] {}, new String[] {});
    }

    //@Ignore
    @SuppressWarnings("javadoc")
    @Test
    public void blockWithApostrophes() throws Exception {
        runTest("block_with_apostrophes", ImportMode.DEEP, new String[] {}, new String[] {});
    }

    //@Ignore
    @SuppressWarnings("javadoc")
    @Test
    public void modelWithMulticonnection() throws Exception {
        runTest("model_multiconnection", ImportMode.DEEP, new String[] {}, new String[] {});
    }

    //@Ignore
    @SuppressWarnings("javadoc")
    @Test
    public void modelWithStateflow() throws Exception {
        runTest("complex_with_stateflow", ImportMode.DEEP, new String[] {}, new String[] {});
    }

    //@Ignore
    @SuppressWarnings("javadoc")
    @Test
    public void modelWithGotoTagVisibilty() throws Exception {
        runTest("simple_with_goto_tag_visibility", ImportMode.DEEP, new String[] {}, new String[] {});
    }

    // Non-existent example model
    @Ignore
    @SuppressWarnings("javadoc")
    @Test
    public void modelComplexWithSimpower() throws Exception {
        runTest("complex_with_simpower", ImportMode.DEEP, new String[] {}, new String[] {});
    }

    //@Ignore
    @SuppressWarnings("javadoc")
    @Test
    public void modelNestedSubsystems() throws Exception {
        runTest("nested_subsystems", ImportMode.DEEP, new String[] {}, new String[] {});
    }

    /**
     * Runs a generic test case. It will open a Simulink model (from a set of cases in the <tt>cases</tt> directory,
     * generate a Simulink Ecore from it and compare the result with a gold standard, that is, an Ecore file that is
     * supposed to be correct.
     * 
     * The folders inside <tt>cases</tt> are numbered for ease of usage by human beings. These numbers are not
     * considered part of the test name and are ignored by <tt>runTest</tt>.
     * 
     * @param testName
     *            The name of a test directory, without the number. So, if the directory name is "
     *            <tt>01 - empty_model</tt>", the test name should be "<tt>empty_model</tt>".
     * 
     * @param traverseMode
     *            The way to traverse the model. See {@link #importModel}
     * 
     * @param filters
     *            Filters to be used during traversal. See {@link #importModel}
     * 
     * 
     * @param startupScriptArray
     *            Startup scripts that will be run before the model is loaded. See {@link #importModel}
     * 
     * @throws IOException
     *             If any of the files needed by the test case is not found.
     * 
     * @throws SimulinkApiException
     *             If something goes wrong with the Simulink interface
     * 
     **/
    public void runTest(final String testName, ImportMode traverseMode, String[] filters, String[] startupScriptArray)
            throws SimulinkApiException, IOException {

        final File casesDir = new File("cases");
        if (!casesDir.exists()) {
            throw new FileNotFoundException("Test case directory not found: " + casesDir.getAbsolutePath());
        }

        final File[] testCases = casesDir.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                if (name.length() > 5 && name.regionMatches(5, testName, 0, max(name.length() - 5, testName.length()))) {
                    return true;
                } else {
                    return false;
                }
            }
        });

        if (testCases.length > 1) {
            StringBuilder testCasesFound = new StringBuilder();
            for (File f : testCases) {
                testCasesFound.append(f.getAbsolutePath());
                testCasesFound.append(", ");
            }

            throw new Error("Found more test cases with the given name than "
                    + "expected. This may be an error in this code or in the "
                    + "cases directory structure. The following files were " + "found: " + testCasesFound.toString());
        } else if (testCases.length == 0) {
            throw new FileNotFoundException("Could not find test case: " + testName);
        }

        File testDir = testCases[0];

        // Finally we have enough information to import the model

        // FIXME: Currently this excludes sxl files.
        File testModel = new File(testDir, testName + ".mdl");
        assertTrue(testModel.exists());

        String modelPath = testModel.getParentFile().getAbsolutePath();
        String resultPath = testModel.getAbsolutePath() + "_test";
        String[] pathArray = new String[] {};

        importModel(testName, modelPath, resultPath, traverseMode, pathArray, filters, startupScriptArray);

    }

    /**
     * Runs a test of the importer. It will open a Simulink model, generate a Simulink Ecore from it and save it.
     * 
     * @param modelName
     *            Name of the model that will be imported.
     * @param modelPath
     *            Place where the imported model resides.
     * @param importedModelName
     *            Name of the file that will hold the generated Ecore
     * @param importMode
     *            Traverse model when importing: 1 - shallow import, 2 - deep import, 3 - Flattening import
     * @param pathArray
     *            An array of things that should be added to Matlab's path
     * @param filters
     *            An array of filters that should be used when importing the model
     * @param startupScriptArray
     *            An array of scripts that should be executed before opening the model
     * @throws SimulinkApiException
     * @throws IOException
     */
    public void importModel(String modelName, String modelPath, String importedModelName, ImportMode importMode,
            String[] pathArray, String[] filters, String[] startupScriptArray) throws SimulinkApiException, IOException {

        // Setup MATLAB
        setup(modelPath, pathArray, startupScriptArray);

        ModelObject testModel = new ModelObject(modelName, commandFactory.getCommandEvaluator());
        testModel.setLoadPath(modelPath);

        // Add specified filters
        for (String s : filters)
            testModel.registerApplicableFilters(s);

        try {
            IFilterProvider filterProvider = new FilterProviderImpl();
            
            Importer importer = new Importer(testModel, filterProvider);
            importer.traverseAndCreateEMFModel(importMode);
            importer.saveEMFModel(importedModelName);

        } finally {
            // Automated exiting in the end, whatever happened while testing
        	commandFactory.closeSystem().addParam(modelName).execute();
        }
    }

    private void setup(String modelPath, String[] pathArray, String[] startupScriptArray) {

        // Set MATLAB path
    	commandFactory.addPath().addParam(modelPath).execute();

        for (String scriptPath : pathArray) {
        	commandFactory.addPath().addParam(scriptPath).execute();
        }

        // Execute setup scripts
        for (String scriptName : startupScriptArray) {
        	commandFactory.customCommand(scriptName, 0).execute();
        }

    }

    private static PropertyResourceBundle getBundle() throws FileNotFoundException, IOException {
        PropertyResourceBundle bundle;
        FileInputStream fis = new FileInputStream(SettingStrings.PROPERTIES_FILE);
        try {
            bundle = new PropertyResourceBundle(fis);
        } finally {
            fis.close();
        }
        return bundle;
    }
}
