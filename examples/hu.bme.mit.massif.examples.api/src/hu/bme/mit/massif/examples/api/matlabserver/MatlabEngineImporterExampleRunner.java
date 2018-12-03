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
package hu.bme.mit.massif.examples.api.matlabserver;

import java.io.IOException;
import org.junit.Before;
import org.junit.Test;

import com.mathworks.engine.EngineException;
import br.com.embraer.massif.commandevaluation.exception.MatlabRMIException;
import hu.bme.mit.massif.communication.ICommandEvaluator;
import hu.bme.mit.massif.examples.api.common.MassifExampleHelper;
import hu.bme.mit.massif.examples.api.common.MatlabConnector;
import hu.bme.mit.massif.simulink.api.exception.SimulinkApiException;

/**
 * This class demonstrates how to use the Simulink Importer from code via a
 * basic example.
 * 
 * Run it as a JUnit plug-in test.
 * 
 * @author Marton Bur
 *
 */
public class MatlabEngineImporterExampleRunner {
	private ICommandEvaluator commandEvaluator;

	@Before
	public void initializeCommandEvaluator() throws MatlabRMIException, EngineException, SimulinkApiException, InterruptedException {
	    commandEvaluator = MassifExampleHelper.createCommandEvaluator(MatlabConnector.COMMAND_EVALUATION_SERVER);
	}

	@Test
	public void exampleImport() throws IOException, MatlabRMIException, SimulinkApiException {
	    MassifExampleHelper.exampleImport(commandEvaluator);
	}	
}
