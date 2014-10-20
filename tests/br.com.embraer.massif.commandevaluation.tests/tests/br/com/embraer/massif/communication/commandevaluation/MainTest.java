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
package br.com.embraer.massif.communication.commandevaluation;

import static org.junit.Assert.assertEquals;

import java.io.File;

import org.junit.BeforeClass;
import org.junit.Test;

import br.com.embraer.massif.commandevaluation.client.MatlabClient;
import br.com.embraer.massif.commandevaluation.exception.MatlabOutputException;
import br.com.embraer.massif.commandevaluation.exception.MatlabRMIException;
import br.com.embraer.massif.commandevaluation.util.MatlabProviderProperties;

/**
 * Class used to test the communication between matlab rmi client
 * and server
 * 
 * @author ldnascim
 */
public class MainTest {

	private static MatlabClient matlabClient;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		// get current directory
		String currentDir = System.getProperty("user.dir");
		currentDir = currentDir + File.separator + "testconfig";
		String configFilePath = currentDir + File.separator +
				MatlabProviderProperties.MATLAB_DEFAULT_CONFIG_FILE_NAME;

		matlabClient = new MatlabClient("r2012b", "5122", configFilePath);
	}
	
	@Test
	public void testSum() throws MatlabOutputException {
		Object[] returnOutput = null;
		try {
			returnOutput = matlabClient.executeEval("1 + 2 + 3", 1);
		} catch (MatlabRMIException e) {
			e.printStackTrace();
		}
		
		double[] doublesOutput = (double[]) returnOutput[0];
		double doubleOutput = doublesOutput[0];
		assertEquals(6.0, doubleOutput, 0);
	}

	@Test
	public void testSqrt() throws MatlabOutputException {
		Object[] returnOutput = null;
		try {
			returnOutput = matlabClient.executeFeval("sqrt", new Object[] {4}, 1);
		} catch (MatlabRMIException e) {
			e.printStackTrace();
		}
		
		double[] doublesOutput = (double[]) returnOutput[0];
		double doubleOutput = doublesOutput[0];
		assertEquals(2.0, doubleOutput, 0);
	}
}
