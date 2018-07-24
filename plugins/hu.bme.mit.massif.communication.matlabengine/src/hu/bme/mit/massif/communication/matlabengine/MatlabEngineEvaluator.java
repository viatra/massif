/*******************************************************************************
 * Copyright (c) 2010-2018, IncQuery Labs Ltd., logi.cals GmbH, McGill University 
 * All rights reserved. This program and the accompanying materials 
 * are made available under the terms of the Eclipse Public License v1.0 
 * which accompanies this distribution, and is available at 
 * http://www.eclipse.org/legal/epl-v10.html 
 *
 * Contributors: 
 *     Marton Bur - initial API and implementation 
 *******************************************************************************/
package hu.bme.mit.massif.communication.matlabengine;

import java.lang.reflect.Field;
import java.util.Map.Entry;
import java.util.Set;

import com.mathworks.engine.EngineException;
import com.mathworks.matlab.types.Struct;

import hu.bme.mit.massif.communication.AbstractCommandEvaluator;
import hu.bme.mit.massif.communication.datatype.CellMatlabData;
import hu.bme.mit.massif.communication.datatype.Handle;
import hu.bme.mit.massif.communication.datatype.IVisitableMatlabData;
import hu.bme.mit.massif.communication.datatype.MatlabString;
import hu.bme.mit.massif.communication.datatype.StructMatlabData;

/**
 * @author Marton Bur
 */
public class MatlabEngineEvaluator extends AbstractCommandEvaluator<MatlabEngineAccess> {

	public MatlabEngineEvaluator() throws EngineException, InterruptedException {
		super(new MatlabEngineAccess());
	}

	@Override
	protected IVisitableMatlabData dataRetriever() throws Exception {
		Object[] data = commandAccess.executeEval("GetImporterTmpResult", 1);

		IVisitableMatlabData result = convertToMatlabData(data);
		return result;
	}

	/**
	 * The converter function based on the official documentation here:
	 * https://www.mathworks.com/help/matlab/matlab_external/data-type-conversions.html
	 * 
	 * Some cases are omitted (e.g., Character[] array) since they never come up
	 * according to the documentation
	 * 
	 * @param rawData the data returned by the MatlabEngine
	 * @return the converted Massif internal IVisitableMatlabData representation
	 */
	private IVisitableMatlabData convertToMatlabData(Object[] rawData) {
		IVisitableMatlabData result = null;
		if (rawData.length > 1) {
			// TODO investigate when is Object[] returned by the MatlabEngine
		} else {
			Object value = rawData[0];
			if (Double.class.isInstance(value) || value instanceof Double) {
				result = new Handle((Double) value);
			} else if (value instanceof double[]) {
				CellMatlabData cellData = new CellMatlabData();
				for (Double doubleVal : (double[]) value) {
					cellData.addData(new Handle(doubleVal));
				}
				result = cellData;
			} else if (value instanceof String) {
				result = new MatlabString((String) value);
			} else if (value instanceof String[]) {
				CellMatlabData cellData = new CellMatlabData();
				for (String stringVal : (String[]) value) {
					cellData.addData(new MatlabString(stringVal.replaceAll("\n", " ")));
				}
				result = cellData;
			} else if (value instanceof Character) {
				String strVal = value.toString();
				result = new MatlabString(strVal.replaceAll("\n", " "));
			} else if (value instanceof Character[]) {
				// TODO I'm not sure if this case happens
			} else if (value != null && value.getClass().getSimpleName().contentEquals("Struct")) {
				// XXX this hack should be removed after issue #89 is closed
				// This piece of code basically moves the data from one struct to the other
				Struct struct = extractStructContents(value);
				result = processStruct(struct);
			} else if (value != null && value.getClass().getSimpleName().contentEquals("Struct[]")) {
				// XXX this hack should be removed after issue #89 is closed
				// This piece of code basically moves the data from one struct to the other
				Object[] rawStructArray = (Object[]) value;				
				result = new CellMatlabData();
				for (Object object : rawStructArray) {
					Struct struct = extractStructContents(object);	
					((CellMatlabData)result).addData(processStruct(struct));
				}
			}
		}
		return result;
	}

	private Struct extractStructContents(Object value) {
		Struct struct = new Struct();
		Field[] fields = value.getClass().getDeclaredFields();
		for (Field field : fields) {
			if (java.lang.reflect.Modifier.isFinal(field.getModifiers())) {
				// Don't bother if field is final
				continue;
			}
			try {
				String fieldName = field.getName();
				field.setAccessible(true);
				Object fieldValue = field.get(value);
				Field fieldToSet = Struct.class.getDeclaredField(fieldName);
				fieldToSet.setAccessible(true);
				fieldToSet.set(struct, fieldValue);
			} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException
					| SecurityException e) {
				e.printStackTrace();
			}
		}
		return struct;
	}

	private IVisitableMatlabData processStruct(Struct structObject) {
		// TODO investigate if there is a chance to get an actual array of structs with
		// an arbitrary number of structs
		Set<Entry<String, Object>> structEntries = structObject.entrySet();
		StructMatlabData struct = new StructMatlabData();
		for (Entry<String, Object> entry : structEntries) {
			struct.addData(entry.getKey(), convertToMatlabData(new Object[] { entry.getValue() }));
		}
		return struct;
	}

}
