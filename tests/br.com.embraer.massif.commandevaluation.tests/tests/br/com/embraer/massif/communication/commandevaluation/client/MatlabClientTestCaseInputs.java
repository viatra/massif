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
import java.util.ArrayList;
import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import br.com.embraer.massif.commandevaluation.client.MatlabClient;
import br.com.embraer.massif.commandevaluation.exception.MatlabOutputException;
import br.com.embraer.massif.commandevaluation.exception.MatlabRMIException;
import br.com.embraer.massif.commandevaluation.util.MatlabProviderProperties;

public class MatlabClientTestCaseInputs {

	private static MatlabClient matlabClient;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		String currentDir = System.getProperty("user.dir");
		currentDir = currentDir + File.separator + "testconfig";
		String configFilePath = currentDir + File.separator +
				MatlabProviderProperties.MATLAB_DEFAULT_CONFIG_FILE_NAME;
		
		matlabClient = new MatlabClient("r2012b", "3144", configFilePath);
		
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
	public void test_inputs1() throws MatlabOutputException {
		String matlab_function = "check_data_type";
		int numout = 2;
		
		Object[] argsT = new Object[1];
		argsT[0] = "abc";
		
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
		assertEquals("char", result);
		
		result = (String) output[1];
		assertEquals("abc", result);
	}
	
	@Test
	public void test_inputs2() throws MatlabOutputException {
		String matlab_function = "check_data_type";
		int numout = 2;
		
		Object[] argsT = new Object[1];
		argsT[0] = (int) 1;
		
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
		assertEquals("int32", result);
		
		result = (String) output[1];
		assertEquals("1", result);
	}
	
	@Test
	public void test_inputs3() throws MatlabOutputException {
		String matlab_function = "check_data_type";
		int numout = 2;
		
		Object[] argsT = new Object[1];
		argsT[0] = (long) 1;
		
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
		assertEquals("int32", result);
		
		result = (String) output[1];
		assertEquals("1", result);
	}
	
	@Test
	public void test_inputs5() throws MatlabOutputException {
		String matlab_function = "check_data_type";
		int numout = 2;
		
		Object[] argsT = new Object[1];
		argsT[0] = (double) 10.0101203812732632137238;
		
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
		assertEquals("double", result);
		
		result = (String) output[1];
		assertEquals("10.0101", result);
	}
	
	@Test
	public void test_inputs6() throws MatlabOutputException {
		String matlab_function = "check_data_type";
		int numout = 2;
		
		Object[] argsT = new Object[1];
		argsT[0] = (boolean) true;
		
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
		assertEquals("logical", result);
		
		result = (String) output[1];
		assertEquals("1", result);
	}
	
	@Test
	public void test_inputs7() throws MatlabOutputException {
		String matlab_function = "check_data_type";
		int numout = 2;
		
		Object[] argsT = new Object[1];
		argsT[0] = new Object[] {10.0101203812732632137238, 1, 2, 4};
		
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
		assertEquals("cell", result);
		
		Object[] result1 = (Object[]) output[1];
		assertEquals(10.010120381273262, ((double[])result1[0])[0], 0);
		assertEquals(1, ((double[])result1[1])[0], 0);
		assertEquals(2, ((double[])result1[2])[0], 0);
		assertEquals(4, ((double[])result1[3])[0], 0);
	}
	
	@Test
	public void test_inputs15() throws MatlabOutputException {
		String matlab_function = "check_data_type";
		int numout = 2;
		
		Object[] argsT = new Object[1];
		argsT[0] = new Object[] {};
		
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
		assertEquals("cell", result);
		
		String[] result1 = (String[]) output[1];
		assertArrayEquals(new String[] {}, result1);
	}
	
	@Test
	public void test_inputs16() throws MatlabOutputException {
		String matlab_function = "check_data_type";
		int numout = 2;
		
		Object[] argsT = new Object[1];
		argsT[0] = null;
		
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
		assertEquals("double", result);
		
		String result1 = (String) output[1];
		assertEquals("NaN", result1);
	}
	
	@Test
	public void test_inputs18() throws MatlabOutputException {
		String matlab_function = "return_cell_array";
		int numout = 1;
		
		Object[] argsT = new Object[2];
		argsT[0] = 0;
		argsT[1] = 0;
		
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
		assertArrayEquals(new String[] {}, result);
	}
	
	@Test
	public void test_inputs19() throws MatlabOutputException {
		String matlab_function = "return_cell_array";
		int numout = 1;
		
		Object[] argsT = new Object[2];
		argsT[0] = 1;
		argsT[1] = 1;
		
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
		assertEquals(1, ((double[])result[0])[0], 0);
	}
	
	@Test
	public void test_inputs20() throws MatlabOutputException {
		String matlab_function = "return_cell_array";
		int numout = 1;
		
		Object[] argsT = new Object[2];
		argsT[0] = 2;
		argsT[1] = 1;
		
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
		assertEquals(1.0, ((double[])result[0])[0], 0);
		assertEquals(2.0, ((double[])result[1])[0], 0);
	}
	
	@Test
	public void test_inputs21() throws MatlabOutputException {
		String matlab_function = "return_cell_array";
		int numout = 1;
		
		Object[] argsT = new Object[2];
		argsT[0] = 1;
		argsT[1] = 2;
		
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
		assertEquals(1.0, ((double[])result[0])[0], 0);
		assertEquals(2.0, ((double[])result[1])[0], 0);
	}
	
	@Test
	public void test_inputs22() throws MatlabOutputException {
		String matlab_function = "return_cell_array";
		int numout = 1;
		
		Object[] argsT = new Object[2];
		argsT[0] = 3;
		argsT[1] = 1;
		
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
		assertEquals(1.0, ((double[])result[0])[0], 0);
		assertEquals(2.0, ((double[])result[1])[0], 0);
		assertEquals(3.0, ((double[])result[2])[0], 0);
	}
	
	@Test
	public void test_inputs23() throws MatlabOutputException {
		String matlab_function = "return_cell_array";
		int numout = 1;
		
		Object[] argsT = new Object[2];
		argsT[0] = 1;
		argsT[1] = 3;
		
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
		assertEquals(1.0, ((double[])result[0])[0], 0);
		assertEquals(2.0, ((double[])result[1])[0], 0);
		assertEquals(3.0, ((double[])result[2])[0], 0);
	}
	
	@Test
	public void test_inputs25() throws MatlabOutputException {
		String matlab_function = "return_prefixed_cell_array";
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
		
		String[] result = (String[]) output[0];
		assertArrayEquals(new String[] {}, result);
	}
	
	@Test
	public void test_inputs26a() throws MatlabOutputException {
		String matlab_function = "return_prefixed_cell_array";
		int numout = 1;
		
		Object[] argsT = new Object[1];
		argsT[0] = 8;
		
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
		assertEquals("a", result[0]);
	}
	
	@Test
	public void test_inputs26() throws MatlabOutputException {
		String matlab_function = "return_prefixed_cell_array";
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
		
		Object[] result = (Object[]) output[0];
		assertArrayEquals(new String[] {}, (String[])result[0]);
	}
	
	@Test
	public void test_inputs26b() throws MatlabOutputException {
		String matlab_function = "return_prefixed_cell_array";
		int numout = 1;
		
		Object[] argsT = new Object[1];
		argsT[0] = 11;
		
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
		assertArrayEquals(new String[] {}, (String[])(((Object[])result[0])[0]));
	}
	
	@Test
	public void test_inputs27() throws MatlabOutputException {
		String matlab_function = "return_prefixed_cell_array";
		int numout = 1;
		
		Object[] argsT = new Object[1];
		argsT[0] = 2;
		
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
		assertArrayEquals(new String[] {}, ((String[])result[0]));
		assertArrayEquals(new String[] {}, ((String[])result[1]));
	}
	
	@Test
	public void test_inputs27a() throws MatlabOutputException {
		String matlab_function = "return_prefixed_cell_array";
		int numout = 1;
		
		Object[] argsT = new Object[1];
		argsT[0] = 9;
		
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
		assertEquals("a", result[0]);
		assertEquals("b", result[1]);
	}
	
	@Test
	public void test_inputs27b() throws MatlabOutputException {
		String matlab_function = "return_prefixed_cell_array";
		int numout = 1;
		
		Object[] argsT = new Object[1];
		argsT[0] = 10;
		
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
		assertEquals("a", result[0]);
		assertEquals("b", result[1]);
	}
	
	@Test
	public void test_inputs28() throws MatlabOutputException {
		String matlab_function = "return_prefixed_cell_array";
		int numout = 1;
		
		Object[] argsT = new Object[1];
		argsT[0] = 3;
		
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
		assertEquals("a", ((String[])result[0])[0]);
		assertEquals("b", ((String[])result[1])[0]);
	}
	
	@Test
	public void test_inputs29() throws MatlabOutputException {
		String matlab_function = "return_prefixed_cell_array";
		int numout = 1;
		
		Object[] argsT = new Object[1];
		argsT[0] = 4;
		
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
		assertEquals("a", ((String[])result[0])[0]);
		assertEquals("b", ((String[])result[1])[0]);
		assertEquals("c", result[2]);
	}
	
	@Test
	public void test_inputs30() throws MatlabOutputException {
		String matlab_function = "return_prefixed_cell_array";
		int numout = 1;
		
		Object[] argsT = new Object[1];
		argsT[0] = 5;
		
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
		assertEquals("a", ((String[])result[0])[0]);
		assertEquals("b", ((String[])result[1])[0]);
		assertEquals("c", result[2]);
	}
	
	@Test
	public void test_inputs31() throws MatlabOutputException {
		String matlab_function = "return_prefixed_cell_array";
		int numout = 1;
		
		Object[] argsT = new Object[1];
		argsT[0] = 6;
		
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
		
		Object[] result1 = (Object[]) result[0];
		assertEquals("a", ((String[])result1[0])[0]);
		assertEquals("b", ((String[])result1[1])[0]);
		assertEquals("c", result1[2]);
		
		Object[] result2 = (Object[]) result[1];
		assertEquals("a", ((String[])result2[0])[0]);
		assertEquals("b", ((String[])result2[1])[0]);
		assertEquals("c", result2[2]);
	}
	
	@Test
	public void test_inputs32() throws MatlabOutputException {
		String matlab_function = "return_prefixed_cell_array";
		int numout = 1;
		
		Object[] argsT = new Object[1];
		argsT[0] = 7;
		
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
		
		Object[] result1 = (Object[]) result[0];
		assertEquals("a", ((String[])result1[0])[0]);
		assertEquals("b", ((String[])result1[1])[0]);
		assertEquals("c", result1[2]);
		
		Object[] result2 = (Object[]) result[1];
		assertEquals("a", ((String[])result2[0])[0]);
		assertEquals("b", ((String[])result2[1])[0]);
		assertEquals("c", result2[2]);
	}
	
	@Test
	public void test_inputs33() throws MatlabOutputException {
		String matlab_function = "return_prefixed_cell_array";
		int numout = 1;
		
		Object[] argsT = new Object[1];
		argsT[0] = 12;
		
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
		assertEquals("abc", result[0]);
		assertEquals("gcb", result[1]);
		assertEquals("hyg", result[2]);
	}
	
	@Test
	public void test_inputs34() throws MatlabOutputException {
		String matlab_function = "check_data_type";
		int numout = 2;
		
		Object[] argsT = new Object[1];
		List<Integer> lista = new ArrayList<Integer>();
		lista.add(2);
		argsT[0] = lista;
		
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
		assertEquals("java.util.ArrayList", result);
		
		assertTrue(output[1] instanceof ArrayList);
	}
}
