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
package br.com.embraer.massif.communication.commandevaluation.client;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import br.com.embraer.massif.commandevaluation.client.MatlabClient;
import br.com.embraer.massif.commandevaluation.exception.MatlabOutputException;
import br.com.embraer.massif.commandevaluation.exception.MatlabRMIException;
import br.com.embraer.massif.commandevaluation.util.MatlabProviderProperties;

public class MatlabClientTestCaseOutputs {

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
	public void test_output_type1() throws MatlabOutputException {
		String matlab_function = "strrep";
		int numout = 1;
		
		Object[] argsT = new Object[3];
		argsT[0] = "aabaa";
		argsT[1] = "b";
		argsT[2] = "c";
	
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
		
		String result = (String) output[0];
		assertEquals("aacaa", result);
	}
	
	@Test
	public void test_output_type2() throws MatlabOutputException {
		String matlab_function = "num2cell";
		int numout = 1;
		
		Object[] argsT = new Object[1];
		argsT[0] = 10.0101203812732632137238;
	
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
		
		Object[] result = (Object[]) output[0];
		assertEquals(10.0101203812732632137238,
				     ((double[]) result[0]) [0], 0);
	}
	
	@Test
	public void test_output_type3() throws MatlabOutputException {
		String matlab_function = "single";
		int numout = 1;
		
		Object[] argsT = new Object[1];
		argsT[0] = 10.010120391845703;
	
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
		
		double[] result = (double[]) output[0];
		assertEquals(10.0101203918457038,
				     result[0], 0);
	}
	
	@Test
	public void test_output_type4() throws MatlabOutputException {
		String matlab_function = "logical";
		int numout = 1;
		
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
		
		boolean[] result = (boolean[]) output[0];
		
		assertEquals(true, result[0]);
	}
	
	@Test
	public void test_output_type5() throws MatlabOutputException {
		String matlab_function = "logical";
		int numout = 1;
		
		Object[] argsT = new Object[1];
		argsT[0] = 0;
	
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
		
		boolean[] result = (boolean[]) output[0];
		
		assertEquals(false, result[0]);
	}
	
	@Test
	public void test_output_type6() throws MatlabOutputException {
		String matlab_function = "ones";
		int numout = 1;
		
		Object[] argsT = new Object[3];
		argsT[0] = 1;
		argsT[1] = 1;
		argsT[2] = "int8";
	
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
		
		double[] result = (double[]) output[0];
		
		assertEquals(1, result[0], 0);
	}
	
	@Test
	public void test_output_type7() throws MatlabOutputException {
		String matlab_function = "ones";
		int numout = 1;
		
		Object[] argsT = new Object[3];
		argsT[0] = 1;
		argsT[1] = 1;
		argsT[2] = 1;
		argsT[2] = "int16";
	
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
		
		double[] result = (double[]) output[0];
		
		assertEquals(1, result[0], 0);
	}
	
	@Test
	public void test_output_type8() throws MatlabOutputException {
		String matlab_function = "ones";
		int numout = 1;
		
		Object[] argsT = new Object[3];
		argsT[0] = 1;
		argsT[1] = 1;
		argsT[2] = 1;
		argsT[2] = "int32";
	
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
		
		double[] result = (double[]) output[0];
		
		assertEquals(1, result[0], 0);
	}
	
	@Test
	public void test_output_type10() throws MatlabOutputException {
		String matlab_function = "ones";
		int numout = 1;
		
		Object[] argsT = new Object[3];
		argsT[0] = 1;
		argsT[1] = 1;
		argsT[2] = 1;
		argsT[2] = "uint8";
	
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
		
		double[] result = (double[]) output[0];
		
		assertEquals(1, result[0], 0);
	}
	
	@Test
	public void test_output_type11() throws MatlabOutputException {
		String matlab_function = "ones";
		int numout = 1;
		
		Object[] argsT = new Object[3];
		argsT[0] = 1;
		argsT[1] = 1;
		argsT[2] = 1;
		argsT[2] = "uint16";
	
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
		
		double[] result = (double[]) output[0];
		
		assertEquals(1, result[0], 0);
	}
	
	@Test
	public void test_output_type12() throws MatlabOutputException {
		String matlab_function = "ones";
		int numout = 1;
		
		Object[] argsT = new Object[3];
		argsT[0] = 1;
		argsT[1] = 1;
		argsT[2] = 1;
		argsT[2] = "uint32";
	
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
		
		double[] result = (double[]) output[0];
		
		assertEquals(1, result[0], 0);
	}
	
	@Test
	public void test_output_type14() throws MatlabOutputException {
		String matlab_function = "create_array";
		int numout = 1;
		
		Object[] argsT = new Object[2];
		argsT[0] = "char";
		argsT[1] = "row";
		
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
		
		String result = (String) output[0];
		assertEquals("abc", result);
	}
	
	@Test
	public void test_output_type15() throws MatlabOutputException {
		String matlab_function = "create_array";
		int numout = 1;
		
		Object[] argsT = new Object[2];
		argsT[0] = "char";
		argsT[1] = "column";
		
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
		
		String result = (String) output[0];
		assertEquals("a\nb\nc\n", result);
	}
	
	@Test
	public void test_output_type16() throws MatlabOutputException {
		String matlab_function = "create_array";
		int numout = 1;
		
		Object[] argsT = new Object[2];
		argsT[0] = "string";
		argsT[1] = "row";
		
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
		
		String result = (String) output[0];
		assertEquals("aaabbbccc", result);
	}
	
	@Test
	public void test_output_type17() throws MatlabOutputException {
		String matlab_function = "create_array";
		int numout = 1;
		
		Object[] argsT = new Object[2];
		argsT[0] = "string";
		argsT[1] = "column";
		
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
		
		String[] result = (String[]) output[0];
		assertEquals("aaa", result[0]);
		assertEquals("bbb", result[1]);
		assertEquals("ccc", result[2]);
	}
	
	@Test
	public void test_output_type18() throws MatlabOutputException {
		String matlab_function = "create_array";
		int numout = 1;
		
		Object[] argsT = new Object[2];
		argsT[0] = "cell";
		argsT[1] = "row";
		
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
		
		Object[] result = (Object[]) output[0];
		assertEquals("aaa", (String)result[0]);
		assertEquals(3.141592653589793, ((double[]) result[1])[0], 0);
		assertEquals(true, ((boolean[]) result[2])[0]);
	}
	
	@Test
	public void test_output_type19() throws MatlabOutputException {
		String matlab_function = "create_array";
		int numout = 1;
		
		Object[] argsT = new Object[2];
		argsT[0] = "cell";
		argsT[1] = "column";
		
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
		
		Object[] result = (Object[]) output[0];
		assertEquals("aaa", (String)result[0]);
		assertEquals(3.141592653589793, ((double[]) result[1])[0], 0);
		assertEquals(true, ((boolean[]) result[2])[0]);
	}
	
	@Test
	public void test_output_type20() throws MatlabOutputException {
		String matlab_function = "create_array";
		int numout = 1;
		
		Object[] argsT = new Object[2];
		argsT[0] = "double";
		argsT[1] = "row";
		
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
		
		double[] result = (double[]) output[0];
		assertEquals(3.141592653589793, result[0], 0);
		assertEquals(6.283185307179586, result[1], 0);
		assertEquals(9.42477796076938, result[2], 0);
	}
	
	@Test
	public void test_output_type21() throws MatlabOutputException {
		String matlab_function = "create_array";
		int numout = 1;
		
		Object[] argsT = new Object[2];
		argsT[0] = "double";
		argsT[1] = "column";
		
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
		
		double[] result = (double[]) output[0];
		assertEquals(3.141592653589793, result[0], 0);
		assertEquals(6.283185307179586, result[1], 0);
		assertEquals(9.42477796076938, result[2], 0);
	}
	
	@Test
	public void test_output_type22() throws MatlabOutputException {
		String matlab_function = "create_array";
		int numout = 1;
		
		Object[] argsT = new Object[2];
		argsT[0] = "single";
		argsT[1] = "row";
		
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
		
		float[] result = (float[]) output[0];
		assertEquals(3.1415927410125732, result[0], 0);
		assertEquals(6.2831854820251465, result[1], 0);
		assertEquals(9.42477798461914, result[2], 0);
	}
	
	@Test
	public void test_output_type23() throws MatlabOutputException {
		String matlab_function = "create_array";
		int numout = 1;
		
		Object[] argsT = new Object[2];
		argsT[0] = "single";
		argsT[1] = "column";
		
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
		
		float[] result = (float[]) output[0];
		assertEquals(3.1415927410125732, result[0], 0);
		assertEquals(6.2831854820251465, result[1], 0);
		assertEquals(9.42477798461914, result[2], 0);
	}
	
	@Test
	public void test_output_type24() throws MatlabOutputException {
		String matlab_function = "create_array";
		int numout = 1;
		
		Object[] argsT = new Object[2];
		argsT[0] = "logical";
		argsT[1] = "row";
		
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
		
		boolean[] result = (boolean[]) output[0];
		assertEquals(true, result[0]);
		assertEquals(false, result[1]);
		assertEquals(true, result[2]);
	}
	
	@Test
	public void test_output_type25() throws MatlabOutputException {
		String matlab_function = "create_array";
		int numout = 1;
		
		Object[] argsT = new Object[2];
		argsT[0] = "logical";
		argsT[1] = "column";
		
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
		
		boolean[] result = (boolean[]) output[0];
		assertEquals(true, result[0]);
		assertEquals(false, result[1]);
		assertEquals(true, result[2]);
	}
	
	@Test
	public void test_output_type26() throws MatlabOutputException {
		String matlab_function = "create_array";
		int numout = 1;
		
		Object[] argsT = new Object[2];
		argsT[0] = "int8";
		argsT[1] = "row";
		
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
		
		byte[] result = (byte[]) output[0];
		assertEquals(10, result[0], 0);
		assertEquals(11, result[1], 0);
		assertEquals(12, result[2], 0);
	}
	
	@Test
	public void test_output_type27() throws MatlabOutputException {
		String matlab_function = "create_array";
		int numout = 1;
		
		Object[] argsT = new Object[2];
		argsT[0] = "int8";
		argsT[1] = "column";
		
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
		
		byte[] result = (byte[]) output[0];
		assertEquals(10, result[0], 0);
		assertEquals(11, result[1], 0);
		assertEquals(12, result[2], 0);
	}
	
	@Test
	public void test_output_type28() throws MatlabOutputException {
		String matlab_function = "create_array";
		int numout = 1;
		
		Object[] argsT = new Object[2];
		argsT[0] = "int16";
		argsT[1] = "row";
		
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
		
		short[] result = (short[]) output[0];
		assertEquals(10, result[0], 0);
		assertEquals(11, result[1], 0);
		assertEquals(12, result[2], 0);
	}

	@Test
	public void test_output_type29() throws MatlabOutputException {
		String matlab_function = "create_array";
		int numout = 1;
		
		Object[] argsT = new Object[2];
		argsT[0] = "int16";
		argsT[1] = "column";
		
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
		
		short[] result = (short[]) output[0];
		assertEquals(10, result[0], 0);
		assertEquals(11, result[1], 0);
		assertEquals(12, result[2], 0);
	}
	
	@Test
	public void test_output_type30() throws MatlabOutputException {
		String matlab_function = "create_array";
		int numout = 1;
		
		Object[] argsT = new Object[2];
		argsT[0] = "int32";
		argsT[1] = "row";
		
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
		
		int[] result = (int[]) output[0];
		assertEquals(10, result[0], 0);
		assertEquals(11, result[1], 0);
		assertEquals(12, result[2], 0);
	}
	
	@Test
	public void test_output_type31() throws MatlabOutputException {
		String matlab_function = "create_array";
		int numout = 1;
		
		Object[] argsT = new Object[2];
		argsT[0] = "int32";
		argsT[1] = "column";
		
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
		
		int[] result = (int[]) output[0];
		assertEquals(10, result[0], 0);
		assertEquals(11, result[1], 0);
		assertEquals(12, result[2], 0);
	}
	
	@Test
	public void test_output_type32() throws MatlabOutputException {
		String matlab_function = "create_array";
		int numout = 1;
		
		Object[] argsT = new Object[2];
		argsT[0] = "int64";
		argsT[1] = "row";
		
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
		
		long[] result = (long[]) output[0];
		assertEquals(10, result[0], 0);
		assertEquals(11, result[1], 0);
		assertEquals(12, result[2], 0);
	}
	
	@Test
	public void test_output_type33() throws MatlabOutputException {
		String matlab_function = "create_array";
		int numout = 1;
		
		Object[] argsT = new Object[2];
		argsT[0] = "int64";
		argsT[1] = "column";
		
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
		
		long[] result = (long[]) output[0];
		assertEquals(10, result[0], 0);
		assertEquals(11, result[1], 0);
		assertEquals(12, result[2], 0);
	}

	@Test
	public void test_output_type34() throws MatlabOutputException {
		String matlab_function = "create_array";
		int numout = 1;
		
		Object[] argsT = new Object[2];
		argsT[0] = "char";
		argsT[1] = "three";
		
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
		
		String result = (String) output[0];
		assertEquals("abc", result);
	}
	
	@Test
	public void test_output_type35() throws MatlabOutputException {
		String matlab_function = "create_array";
		int numout = 1;
		
		Object[] argsT = new Object[2];
		argsT[0] = "char";
		argsT[1] = "matrix";
		
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
		
		String result = (String) output[0];
		assertEquals("abc", result);
	}
	
	@Test
	public void test_output_type36() throws MatlabOutputException {
		String matlab_function = "create_array";
		int numout = 1;
		
		Object[] argsT = new Object[2];
		argsT[0] = "double";
		argsT[1] = "three";
		
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
		
		double[] result = (double[]) output[0];
		assertEquals(3.141592653589793, result[0], 0);
		assertEquals(6.283185307179586, result[1], 0);
		assertEquals(9.42477796076938, result[2], 0);
	}
	
	@Test
	public void test_output_type37() throws MatlabOutputException {
		String matlab_function = "create_array";
		int numout = 1;
		
		Object[] argsT = new Object[2];
		argsT[0] = "double";
		argsT[1] = "matrix";
		
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
		
		double[] result = (double[]) output[0];
		assertEquals(3.141592653589793, result[0], 0);
		assertEquals(6.283185307179586, result[1], 0);
		assertEquals(9.42477796076938, result[2], 0);
	}
}
