package br.com.embraer.transima.matlab.commandevaluation;

import static org.junit.Assert.assertEquals;

import java.io.File;

import org.junit.BeforeClass;
import org.junit.Test;

import br.com.embraer.transima.matlab.commandevaluation.client.MatlabClient;
import br.com.embraer.transima.matlab.commandevaluation.exception.MatlabOutputException;
import br.com.embraer.transima.matlab.commandevaluation.exception.MatlabRMIException;
import br.com.embraer.transima.matlab.commandevaluation.util.MatlabProviderProperties;

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
