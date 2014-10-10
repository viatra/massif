package br.com.embraer.transima.matlab.commandevaluation.client;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import br.com.embraer.transima.matlab.commandevaluation.client.MatlabClient;
import br.com.embraer.transima.matlab.commandevaluation.exception.MatlabOutputException;
import br.com.embraer.transima.matlab.commandevaluation.exception.MatlabRMIException;
import br.com.embraer.transima.matlab.commandevaluation.util.MatlabProviderProperties;

public class MatlabClientTestCasePerformance {

private static MatlabClient matlabClient;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		String currentDir = System.getProperty("user.dir");
		currentDir = currentDir + File.separator + "testconfig";
		String configFilePath = currentDir + File.separator +
				MatlabProviderProperties.MATLAB_DEFAULT_CONFIG_FILE_NAME;
		
		matlabClient = new MatlabClient("R2010bSP", "3876", configFilePath);
		
		// get script tests current directory
		String scriptDirTests = System.getProperty("user.dir");
		scriptDirTests = scriptDirTests + File.separator + "scriptsfortests";
		
		Object[] argsT = new Object[1];
		argsT[0] = scriptDirTests;
		
		// add scripts folder to matlab path
		matlabClient.executeFeval("addpath", argsT, 0);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		// get current directory
		String currentDir = System.getProperty("user.dir");
		currentDir = currentDir + File.separator + "scriptsfortests";

		Object[] argsT = new Object[1];
		argsT[0] = currentDir;

		// remove scripts folder from matlab path
		matlabClient.executeFeval("rmpath", argsT, 0);
	}
	

	@Test
	public void test_performance1() throws MatlabOutputException {
		String matlab_function = "return_cell_array_different_size";
		long tic = System.currentTimeMillis();
		int numout = 2;
		
		Object[] argsT = new Object[1];
		argsT[0] = 1;
		
		Object[] output = null;
		try {
			output = matlabClient.executeFeval(matlab_function,
					argsT, numout);
		} catch (MatlabRMIException e) {
			fail("Exception occurred: " + e.getMessage());
		}
		
		if (output == null || output[0] == null)
		{
			fail("Unexpected error occurred");
		}
		
		long toc = System.currentTimeMillis();
		long elapsed_time_long = toc - tic;
		double elapsed_time = (double)elapsed_time_long/1000.0;
		
		Object[] result = (Object[]) output[0];
		double matlab_elapsed_time = ((double[])output[1])[0];
		
		System.out.println(String.format("Elapsed_time = %s Matlab_elapsed_time = %s", elapsed_time, matlab_elapsed_time));
		assertTrue(result.length == 10);
		assertTrue(elapsed_time < matlab_elapsed_time);
	}
}