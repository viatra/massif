/*******************************************************************************
 * Copyright (c) 2010-2013, Embraer S.A., Budapest University of Technology and Economics
 * All rights reserved. This program and the accompanying materials 
 * are made available under the terms of the Eclipse Public License v1.0 
 * which accompanies this distribution, and is available at 
 * http://www.eclipse.org/legal/epl-v10.html 
 *
 * Contributors: 
 *     Rodrigo Rizzi Starr, Lincoln Nascimento - initial API and implementation 
 *******************************************************************************/
package br.com.embraer.massif.commandevaluation.server;

import java.io.File;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.URISyntaxException;
import java.net.URL;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.RMIClientSocketFactory;
import java.rmi.server.RMIServerSocketFactory;
import java.rmi.server.RMISocketFactory;
import java.rmi.server.UnicastRemoteObject;

import br.com.embraer.massif.commandevaluation.base.MatlabRemoteInterface;
import br.com.embraer.massif.commandevaluation.exception.MatlabError;
import br.com.embraer.massif.commandevaluation.exception.MatlabPropertiesException;
import br.com.embraer.massif.commandevaluation.exception.MatlabRMIException;
import br.com.embraer.massif.commandevaluation.util.MatlabProviderProperties;
import br.com.embraer.massif.commandevaluation.util.TimeLimitedClientSocketFactory;

/**
 * Entry point for the matlab RMI server execution
 * 
 * @author ldnascim
 */
public class ServerEntryPoint {

    /** RMI Server Host address and port **/
    private String hostAddress;
    private int hostPort;

    /** RMI service name */
    private String serviceName;

    private boolean debug;

    /** RMI server registry */
    private Registry registry;
    private MatlabRemoteInterface matlabRemote;

    /**
     * Reads the host address and host port from the properties file
     * 
     * @throws MatlabPropertiesException
     */
    private void readProperties(String filePath) throws MatlabPropertiesException {
        String realFilePath = filePath;
        // if path was not given, try to load from the jar directory
        if (realFilePath.isEmpty()) {
            try {
                File jarFile = new File(ServerEntryPoint.class.getProtectionDomain().getCodeSource().getLocation()
                        .toURI());
                String jarFolder = jarFile.getParent();
                realFilePath = jarFolder + File.separator + MatlabProviderProperties.MATLAB_DEFAULT_CONFIG_FILE_NAME;

                printMessage("Configuration path not provided, " + "considering the following path: " + realFilePath);
            } catch (URISyntaxException e1) {
                throw new MatlabPropertiesException(MatlabError.RETRIEVE_JAR_LOCATION_ERROR, e1);
            }
        }

        MatlabProviderProperties serverProperties = new MatlabProviderProperties(realFilePath);

        // get host address
        hostAddress = serverProperties.getProperty(MatlabProviderProperties.MATLAB_SERVER_ADDRESS);
        printMessage("Host address = " + hostAddress);

        // if host address was not provided, thrown an exception
        if (hostAddress == null || hostAddress.isEmpty()) {
            MatlabPropertiesException exception = new MatlabPropertiesException(
                    MatlabError.INVALID_PROPERTY_CONTENT_ERROR, null);
            exception.set("Config file", serverProperties.getConfigPath());
            exception.set(MatlabProviderProperties.MATLAB_SERVER_ADDRESS, hostAddress);
            throw exception;
        }

        // get host port
        String hostPortStr = serverProperties.getProperty(MatlabProviderProperties.MATLAB_SERVER_PORT);
        printMessage("Host port: " + hostPortStr);

        try {
            hostPort = Integer.valueOf(hostPortStr);
        } catch (NumberFormatException e) {
            MatlabPropertiesException exception = new MatlabPropertiesException(
                    MatlabError.INVALID_PROPERTY_CONTENT_ERROR, e);
            exception.set("Config file", serverProperties.getConfigPath());
            exception.set(MatlabProviderProperties.MATLAB_SERVER_PORT, hostPortStr);
            throw exception;
        }

        // get debug mode
        String debugStr = serverProperties.getProperty(MatlabProviderProperties.MATLAB_SERVER_DEBUG_MODE);
        printMessage("Debug mode: " + debugStr);
        debug = Boolean.valueOf(debugStr);

        serviceName = MatlabProviderProperties.MATLAB_SERVER_DEFAULT_SERVICE_NAME;
    }

    /**
     * Starts the RMI server using as parameter the matlab version
     * 
     * @param matlabVersion
     *            Matlab version
     * @throws MatlabPropertiesException
     * @throws MatlabRMIException
     */
    public void startRMIServer(String matlabVersion, String matlabPid, String configFilePath)
            throws MatlabPropertiesException, MatlabRMIException {
        readProperties(configFilePath);

        String realMatlabVersion = matlabVersion.toLowerCase();
        // if matlab version was provided concatenates with prefix
        if (!realMatlabVersion.isEmpty()) {
            serviceName = serviceName + realMatlabVersion + matlabPid;
        }

        StringBuilder sb = new StringBuilder("Starting Matlab RMI Server...\n");
        sb.append("-----------------------------\n");
        sb.append("Address = " + hostAddress + "\n");
        sb.append("port = " + hostPort + "\n");
        sb.append("serviceName = " + serviceName + "\n");
        sb.append("-----------------------------\n");
        printMessage(sb.toString());

        // Reads server policy from file
        URL url = ServerEntryPoint.class.getResource("/server.policy");
        if (url != null) {
            System.setProperty("java.security.policy", url.toString());
        }

        // sets RMI security manager
        if (System.getSecurityManager() == null) {
            System.setSecurityManager(new SecurityManager());
        }

        // creates RMI server registry
        try {
            // Create the remote object and keep a hard reference to it in order to avoid garbage collection.
            matlabRemote = new MatlabRemoteImpl(debug);

            // Add custom socket factory - the answer time is limited for the server (time limit is set in the
            // implementation of the client socket factory)
            RMIClientSocketFactory csf = new TimeLimitedClientSocketFactory();

            // Export the remote object and set the custom client and the default server socket factories
            MatlabRemoteInterface stub = (MatlabRemoteInterface) UnicastRemoteObject.exportObject(matlabRemote, 0, csf,
                new RMIServerSocketFactory() {

                    @Override
                    public ServerSocket createServerSocket(int arg0) throws IOException {
                        return RMISocketFactory.getDefaultSocketFactory().createServerSocket(arg0);
                    }

                });

            // Bind the remote object to the corresponding service name
            registry = LocateRegistry.createRegistry(hostPort);
            registry.rebind(serviceName, stub);

            printMessage("Matlab RMI Server Started!");
        } catch (RemoteException e) {
            MatlabRMIException exception = new MatlabRMIException(MatlabError.CREATE_RMI_SERVER_ERROR, e);
            exception.set("Host port", hostPort);
            exception.set("Service name", serviceName);
            throw exception;
        }
    }

    private static void printMessage(String message) {
        System.out.println(message);
    }
}
