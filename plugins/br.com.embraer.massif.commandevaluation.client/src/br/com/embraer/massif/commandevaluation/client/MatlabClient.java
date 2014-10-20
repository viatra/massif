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
package br.com.embraer.massif.commandevaluation.client;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.List;

import br.com.embraer.massif.commandevaluation.base.MatlabRemoteInterface;
import br.com.embraer.massif.commandevaluation.exception.MatlabError;
import br.com.embraer.massif.commandevaluation.exception.MatlabOutputException;
import br.com.embraer.massif.commandevaluation.exception.MatlabPropertiesException;
import br.com.embraer.massif.commandevaluation.exception.MatlabRMIException;
import br.com.embraer.massif.commandevaluation.util.MatlabProviderProperties;
import br.com.embraer.massif.commandevaluation.util.ModelProviderUtil;

/**
 * Class responsible for invoking the remote methods in the matlab RMI server
 * to execute the eval and evals and retrieve its output
 * 
 * @author ldnascim
 */
public class MatlabClient {

    private static final String EVAL_EXECUTIONMODE = "eval";
    private static final String FEVAL_EXECUTIONMODE = "feval";

    /** Will receive the instance for the matlab remote server**/
	private MatlabRemoteInterface matlabRemote;

	/** Used to retrieve the properties (url/port) **/
	private MatlabProviderProperties serverProperties;
	private String hostAddress;
	private int hostPort;
	private String serviceName;

	/**
	 * Default Constructor
	 * @param matlabVersion Matlab version, used as an identifier
	 * 						for which matlab server the client will
	 * 						connect to
	 * @throws MatlabPropertiesException
	 * @throws MatlabRMIException
	 */
	public MatlabClient(String matlabVersion, String matlabPid) throws MatlabPropertiesException, MatlabRMIException {
		serverProperties = new MatlabProviderProperties();
		configureAndConnect(matlabVersion, matlabPid);
	}

	/**
	 * Constructor
	 * @param matlabVersion Matlab version, used as an identifier
	 * 						for which matlab server the client will
	 * 						connect to
	 * @param configPath Configuration file path
	 * @throws MatlabPropertiesException
	 * @throws MatlabRMIException
	 */
	public MatlabClient(String matlabVersion, String matlabPid,
			String configPath) throws MatlabPropertiesException, MatlabRMIException {
		serverProperties = new MatlabProviderProperties(configPath);
		configureAndConnect(matlabVersion, matlabPid);
	}

	/**
	 * Reads properties from configuration file and tries
	 * to connect to RMI server
	 * @param matlabVersion Matlab release version
	 * @param matlabPid Matlab process pid
	 * @throws MatlabPropertiesException
	 * @throws MatlabRMIException
	 */
	private void configureAndConnect(String matlabVersion, String matlabPid) throws MatlabPropertiesException, MatlabRMIException {
        String lcMatlabVersion = matlabVersion.toLowerCase();

		// try to retrieve host address
		hostAddress = serverProperties.getProperty(MatlabProviderProperties.MATLAB_SERVER_ADDRESS);
		if (hostAddress == null || hostAddress.isEmpty()) {
			MatlabPropertiesException exception =
					new MatlabPropertiesException(MatlabError.INVALID_PROPERTY_CONTENT_ERROR, null);
			exception.set("Config file: ", serverProperties.getConfigPath());
			exception.set("Host address: ", hostAddress);
			throw exception;
		}

		// try to retrieve host port
		String hostPortStr = serverProperties.getProperty(MatlabProviderProperties.MATLAB_SERVER_PORT);
		try {
			hostPort = Integer.valueOf(hostPortStr);
		} catch (NumberFormatException e) {
			MatlabPropertiesException exception =
					new MatlabPropertiesException(MatlabError.INVALID_PROPERTY_CONTENT_ERROR, e);
			exception.set("Config file: ", serverProperties.getConfigPath());
			exception.set("Host port: ", hostPortStr);
			throw exception;
		}

		// store service name based on matlab version and PID(process ID)
		serviceName = MatlabProviderProperties.MATLAB_SERVER_DEFAULT_SERVICE_NAME;
        if (!lcMatlabVersion.isEmpty())
		{
            serviceName = serviceName + lcMatlabVersion + matlabPid;
		}

		// connects to RMI server
		connectRMI();
	}


	/**
	 * Constructor
	 * @param hostAddress Host address
	 * @param hostPort Host port
	 * @param serviceName service name
	 * @throws MatlabRMIException
	 */
	public MatlabClient(String hostAddress, int hostPort, String serviceName) throws MatlabRMIException {
		this.hostAddress = hostAddress;
		this.hostPort = hostPort;
		this.serviceName = serviceName;

		// connects to RMI server
		connectRMI();
	}

	/**
	 * Connect to the matlab RMI server
	 * @throws MatlabRMIException
	 */
	private void connectRMI() throws MatlabRMIException {
		Exception exception = null;

		// create to find and bind RMI registry for matlab server
		try {
			Registry registry = LocateRegistry.getRegistry(hostPort);
			matlabRemote = (MatlabRemoteInterface) registry.lookup(serviceName);
		} catch (RemoteException e) {
			exception = e;
		} catch (NotBoundException e) {
			exception = e;
		}

		// if exception occurred, thrown it
		if (exception != null) {
			MatlabRMIException rmiException =
					new MatlabRMIException(MatlabError.CONNECTING_RMI_ERROR, exception);
			rmiException.set("Host port", hostPort);
			rmiException.set("Service name", matlabRemote);
			throw rmiException;
		}
	}

	/**
	 * Executes feval("function evaluation") command in the matlab RMI server
	 * and retrieves its output(if any is expected)
	 * @param name Function name
	 * @param inputArgs Array of objects containing the function inputs
	 * @param numberOfOutputs Number of outputs
	 * @return Array of objects containing the feval output
	 * @throws MatlabRMIException
	 * @throws MatlabOutputException
	 * @throws RemoteException
	 */
	public Object[] executeFeval(String name, Object[] inputArgs,
			int numberOfOutputs) throws MatlabRMIException, MatlabOutputException {
		Object[] returnOutput = null;
		try {
			returnOutput =
					matlabRemote.executeFeval(name, inputArgs, numberOfOutputs);
		} catch (RemoteException e) {
            MatlabRMIException exception = prepareMatlabRMIException(FEVAL_EXECUTIONMODE, name, inputArgs,
                numberOfOutputs, e);
			throw exception;
		}
		return returnOutput;
	}

    private MatlabRMIException prepareMatlabRMIException(String executionMode, String command, Object[] inputArgs,
        int numberOfOutputs, RemoteException e) {
        MatlabRMIException exception = new MatlabRMIException(MatlabError.INVOKING_COMMAND_ON_MATLAB_ERROR, e);
        exception.set("Type:", executionMode);
        exception.set("Command:", command);
        exception.set("Input arguments", ModelProviderUtil.convertArrayToString(inputArgs, ","));
        exception.set("Number of output arguments", numberOfOutputs);
        return exception;
    }

	/**
	 * Executes eval("evaluation") command in the matlab RMI server
	 * and retrieves its output(if any is expected)
	 * @param command Evaluation command to be executed
	 * @param numberOfOutputs Number of outputs
	 * @return Array of objects containing the eval output
	 * @throws MatlabRMIException
	 * @throws MatlabOutputException
	 * @throws RemoteException
	 */
	public Object[] executeEval(String command, int numberOfOutputs) throws MatlabRMIException, MatlabOutputException {
		Object[] returnOutput = null;
		try {
			returnOutput =
					matlabRemote.executeEval(command, numberOfOutputs);
		} catch (RemoteException e) {
            MatlabRMIException exception = prepareMatlabRMIException(EVAL_EXECUTIONMODE, command, new Object[0],
                numberOfOutputs, e);
			throw exception;
		}
		return returnOutput;
	}

	/**
	 * Retrieves the current loaded and opened models in matlab
	 * @return List of strings containing the names of the models
	 * @throws MatlabRMIException
	 * @throws MatlabOutputException
	 * @throws RemoteException
	 */
	public List<String> getOpenedModels() throws MatlabRMIException, MatlabOutputException {
		List<String> openedModels  = new ArrayList<String>();

		String command = "find_system";
		Object[] inputsArgs = new Object[2];
		inputsArgs[0] = "SearchDepth";
		inputsArgs[1] = 0;

		// retrieves all loaded models
		Object[] returnOutput = null;
		try {
			returnOutput =
					matlabRemote.executeFeval(command, inputsArgs, 1);
		} catch (RemoteException e1) {
            MatlabRMIException exception = prepareMatlabRMIException(FEVAL_EXECUTIONMODE, command, inputsArgs, 1, e1);
			throw exception;
		}
		if (returnOutput != null && returnOutput.length > 0 &&
				returnOutput[0] != null) {
			String[] modelNames = (String[]) returnOutput[0];

			if (modelNames.length > 0) {
				// retrieve if the models are really "opened"
				for (int i = 0; i < modelNames.length; i++) {

					// check if is visible
					command = "get_param";
					inputsArgs = new Object[2];
					inputsArgs[0] = modelNames[i];
					inputsArgs[1] = "Shown";
					try {
						returnOutput =
								matlabRemote.executeFeval(command, inputsArgs, 1);
					} catch (RemoteException e) {
                        MatlabRMIException exception = prepareMatlabRMIException(FEVAL_EXECUTIONMODE, command,
                            inputsArgs, 1, e);
						throw exception;
					}

					if (returnOutput != null && returnOutput.length > 0
							&& returnOutput[0] != null) {
						String showStatus = (String) returnOutput[0];
						showStatus = showStatus.toLowerCase();

						// if status is "on" then the model is loaded and opened
						if (showStatus.equals("on")) {
							openedModels.add(modelNames[i]);
						}
					}
				}
			}
		}

		return openedModels;
	}
}