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

import hu.bme.mit.massif.communication.command.MatlabCommandFactory;
import hu.bme.mit.massif.communication.commandevaluation.CommandEvaluatorImpl;
import hu.bme.mit.massif.simulink.SimulinkModel;
import hu.bme.mit.massif.simulink.api.Exporter;
import hu.bme.mit.massif.simulink.api.exception.SimulinkApiException;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.PropertyResourceBundle;

import org.junit.BeforeClass;
import org.junit.Test;

import br.com.embraer.massif.commandevaluation.client.MatlabClient;
import br.com.embraer.massif.commandevaluation.exception.MatlabRMIException;

/**
 * This is for demonstration and testing purposes (for trying out) only. Run it as a JUnit plug-in test with the desired
 * plug-in configuration
 * 
 */
public class ExporterApiTest {

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

        try {
            MatlabClient matlabClient = new MatlabClient(hostAddress, hostPort, serviceName);
            commandFactory = new MatlabCommandFactory(new CommandEvaluatorImpl(matlabClient));
        } catch (MatlabRMIException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Test
    public void testMain() throws SimulinkApiException, IOException {

        // The proxy for the current MATLAB session

        try {

            // Reading the configuration file
            PropertyResourceBundle bundle = null;
            FileInputStream fis = new FileInputStream(SettingStrings.PROPERTIES_FILE);
            try {
                bundle = new PropertyResourceBundle(fis);
            } finally {
                fis.close();
            }

            // Reading parameter values from a properties file

            // EMF model name to read
            String modelName = bundle.getString(SettingStrings.EXPORT_MODEL_NAME);
            String modelPath = bundle.getString(SettingStrings.EXPORT_MODEL_PATH);

            // Additional MATLAB paths
            String[] pathArray = bundle.getString(SettingStrings.EXPORTER_ADDITIONAL_PATH).split("\\|");

            // Setup MATLAB
            setup(commandFactory, pathArray);

            // In the current state of the development
            // the exporter needs to be instantiated
            // This may change later
            Exporter exporter = new Exporter();

            SimulinkModel loadedModel = exporter.loadSimulinkModel(modelPath + modelName);

            exporter.export(loadedModel, commandFactory);

            // TODO While testing, it is not always a good idea to save the model immediately
            // exporter.saveSimulinkModel(loadedModel.getSimulinkRef().getFQN());

        } catch (Exception e) {
            throw new SimulinkApiException("Error occured", e);
        } finally {
        }

    }

    private void setup(MatlabCommandFactory commandFactory, String[] pathArray) {
        // Adding additional places to MATLAB path
        for (String scriptPath : pathArray) {
        	commandFactory.addPath().addParam(scriptPath).execute();
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
