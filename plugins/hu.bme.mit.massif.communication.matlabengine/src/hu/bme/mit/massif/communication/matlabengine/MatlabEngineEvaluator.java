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
import hu.bme.mit.massif.communication.datatype.Logical;
import hu.bme.mit.massif.communication.datatype.MatlabString;
import hu.bme.mit.massif.communication.datatype.StructMatlabData;

/**
 * @author Marton Bur
 */
public class MatlabEngineEvaluator extends AbstractCommandEvaluator<MatlabEngineAccess> {

	private boolean debugPrint;

	public MatlabEngineEvaluator(boolean debugPrint) throws EngineException, InterruptedException {
		super(new MatlabEngineAccess());
		this.debugPrint = debugPrint;
	}

	@Override
	public IVisitableMatlabData evaluateCommand(String command, int nargout) {
		return super.evaluateCommand(debugPrint ? command : command + ";", nargout);
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
			} else if (Boolean.class.isInstance(value) || value instanceof Boolean) {
				result = new Logical((Boolean) value);
			} else if (value instanceof Boolean[]) {
				CellMatlabData cellData = new CellMatlabData();
				for (Boolean logicalVal : (Boolean[]) value) {
					cellData.addData(new Logical(logicalVal));
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
				Struct struct = (Struct)value;
				result = processStruct(struct);
			} else if (value != null && value.getClass().getSimpleName().contentEquals("Struct[]")) {
				Object[] rawStructArray = (Object[]) value;				
				result = new CellMatlabData();
				for (Object object : rawStructArray) {
					Struct struct = (Struct)object;	
					((CellMatlabData)result).addData(processStruct(struct));
				}
			}
		}
		return result;
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
