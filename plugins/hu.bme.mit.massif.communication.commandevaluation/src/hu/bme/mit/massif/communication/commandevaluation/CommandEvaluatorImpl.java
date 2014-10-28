/*******************************************************************************
 * Copyright (c) 2010-2013, Embraer S.A., Budapest University of Technology and Economics
 * All rights reserved. This program and the accompanying materials 
 * are made available under the terms of the Eclipse Public License v1.0 
 * which accompanies this distribution, and is available at 
 * http://www.eclipse.org/legal/epl-v10.html 
 *
 * Contributors: 
 *     Marton Bur, Abel Hegedus, Akos Horvath - initial API and implementation 
 *******************************************************************************/
package hu.bme.mit.massif.communication.commandevaluation;

import hu.bme.mit.massif.communication.CommandEvaluationException;
import hu.bme.mit.massif.communication.ICommandEvaluator;
import hu.bme.mit.massif.communication.datatype.CellMatlabData;
import hu.bme.mit.massif.communication.datatype.Handle;
import hu.bme.mit.massif.communication.datatype.IVisitableMatlabData;
import hu.bme.mit.massif.communication.datatype.MatlabString;
import hu.bme.mit.massif.communication.datatype.StructMatlabData;

import java.util.HashMap;
import java.util.Map;

import br.com.embraer.massif.commandevaluation.client.MatlabClient;
import br.com.embraer.massif.commandevaluation.exception.MatlabException;
import br.com.embraer.massif.commandevaluation.exception.MatlabOutputException;
import br.com.embraer.massif.commandevaluation.exception.MatlabRMIException;

/**
 * Class responsible for the low level operations with MATLAB
 * 
 * (The successor class of BasicOperationsApi utility class)
 */
public class CommandEvaluatorImpl implements ICommandEvaluator {

    private static Map<MatlabClient, CommandEvaluatorImpl> commandEvaluators = new HashMap<MatlabClient, CommandEvaluatorImpl>();

    private MatlabClient matlabClient;

    public MatlabClient getMatlabClient() {
        return matlabClient;
    }

    public void setMatlabClient(MatlabClient matlabClient) {
        this.matlabClient = matlabClient;
    }

    public CommandEvaluatorImpl() {
    }

    public CommandEvaluatorImpl(MatlabClient matlabClient) {
        this.matlabClient = matlabClient;
    }

    public static CommandEvaluatorImpl getInstance(MatlabClient matlabClient) {
        CommandEvaluatorImpl commandEvaluator = commandEvaluators.get(matlabClient);
        if (commandEvaluator == null) {
            commandEvaluator = new CommandEvaluatorImpl(matlabClient);
            commandEvaluators.put(matlabClient, commandEvaluator);
        }
        return commandEvaluator;
    }

    @Override
    public IVisitableMatlabData evaluateCommand(String command, int nargout) {

        IVisitableMatlabData result = null;
        try {

            if (nargout > 1) {
                String resultString = "[";
                for (Integer i = 0; i < nargout; i++) {
                    resultString = resultString.concat("r" + i.toString() + ",");
                }

                resultString = resultString.replaceAll(",$", "").concat("]");

                matlabClient.executeEval(resultString + " = " + command, 0);
                matlabClient.executeEval("ImporterTmpResult = " + resultString.replace("[", "{").replace("]", "}"), 0);
                result = dataRetriever();
            } else if (nargout == 1) {
                matlabClient.executeEval("ImporterTmpResult = " + command, 0);
                result = dataRetriever();
            } else {
                matlabClient.executeEval(command, 0);
                result = null;
            }

        } catch (MatlabException e) {
        	throw new CommandEvaluationException("Exception occurred while evaluating command!", e);
        }
        return result;
    }

    private IVisitableMatlabData processStruct(String structName, Object[] data) throws MatlabRMIException,
            MatlabOutputException {

        // //////
        // DEBUG
        // Get all data in the struct with the fieldnames
        Object[] _data = (Object[]) matlabClient.executeEval(structName + "(1:end)", 1)[0];

        // In case of a struct data[0] is always a String[] containing the field names
        Map<String, IVisitableMatlabData> fieldsToValues = new HashMap<String, IVisitableMatlabData>();
        Object[] structDatas = ((Object[]) _data[1]);

        IVisitableMatlabData result = null;
        if (structDatas.length <= 0) {
            // TODO null length array of struct
            return null;
        } else if (structDatas.length == 1) {
            StructMatlabData structResult = new StructMatlabData();

            for (int i = 0; i < structDatas.length; i++) {
                for (int j = 0; j < ((String[]) _data[0]).length; j++) {
                    String fieldName = ((String[]) _data[0])[j];
                    // Get the reference name for the field. Caution: MATLAB indexing
                    String currVarName = structName + "(" + (i + 1) + ")." + fieldName;

                    // Determine the type of each field
                    String type = (String) matlabClient.executeEval("class(" + currVarName + ")", 1)[0];
                    // Branch according to the type
                    IVisitableMatlabData fieldValue = null;
                    if ("struct".equals(type)) {
                        fieldValue = processStruct(currVarName, (Object[]) (((Object[]) structDatas[i])[j]));
                    } else {
                        fieldValue = processNonStruct(currVarName, type, ((Object[]) structDatas[i])[j]);
                    }
                    fieldsToValues.put(fieldName, fieldValue);
                }
            }
            structResult.setDatas(fieldsToValues);
            result = structResult;
        } else {
            CellMatlabData cellResult = new CellMatlabData();
            for (int i = 0; i < structDatas.length; i++) {
                StructMatlabData structResult = new StructMatlabData();
                for (int j = 0; j < ((String[]) _data[0]).length; j++) {
                    String fieldName = ((String[]) _data[0])[j];
                    // fieldNames.add(fieldName);
                    // Get the reference name for the field. Caution: MATLAB indexing
                    String currVarName = structName + "(" + (i + 1) + ")." + fieldName;

                    // Determine the type of each field
                    String type = (String) matlabClient.executeEval("class(" + currVarName + ")", 1)[0];
                    // Branch according to the type
                    IVisitableMatlabData fieldValue = null;
                    if ("struct".equals(type)) {
                        fieldValue = processStruct(currVarName, (Object[]) (((Object[]) structDatas[i])[j]));
                    } else {
                        fieldValue = processNonStruct(currVarName, type, ((Object[]) structDatas[i])[j]);
                    }
                    fieldsToValues.put(fieldName, fieldValue);
                }
                structResult.setDatas(fieldsToValues);
                fieldsToValues = new HashMap<String, IVisitableMatlabData>();
                cellResult.addData(structResult);
                result = cellResult;
            }
        }

        return result;
    }


    private IVisitableMatlabData dataRetriever() throws MatlabRMIException, MatlabOutputException {
        IVisitableMatlabData result = null;
        String type = (String) matlabClient.executeEval("class(ImporterTmpResult)", 1)[0];
        Object[] data = matlabClient.executeEval("ImporterTmpResult(1:end)", 1);
        // Switch according to the result of type = class(ImporterTmpResult)
        if (type.equals("struct")) {
            result = processStruct("ImporterTmpResult", data);
        } else {
            result = processNonStruct("ImporterTmpResult", type, data[0]);
        }
        return result;
    }

    private IVisitableMatlabData processNonStruct(String name, String type, Object data) throws MatlabRMIException,
            MatlabOutputException {
        IVisitableMatlabData result = null;

        if (type.equals("double")) {
            if (data instanceof double[]) {
                if (((double[]) data).length == 1) {
                    Handle handle = new Handle();
                    handle.setData((((double[]) data)[0]));
                    result = handle;
                } else {
                    double[] handles = (double[]) data;
                    CellMatlabData compositeData = new CellMatlabData();
                    for (int i = 0; i < handles.length; i++) {
                        Handle handle = new Handle();
                        handle.setData((((double[]) (data))[i]));
                        compositeData.addData(handle);
                    }
                    result = compositeData;
                }
            } else if (((Object[]) (data)).length > 1) {
                CellMatlabData compositeData = new CellMatlabData();
                for (int j = 0; j < ((Object[]) (data)).length; j++) {
                    // Most of the times values are stored in an array of one element
                    // TODO check if iteration with i is really needed, or can be indexed with 0
                    for (int i = 0; i < ((double[]) ((Object[]) (data))[j]).length; i++) {
                        Handle handle = new Handle();
                        handle.setData(((double[]) ((Object[]) (data))[j])[i]);
                        compositeData.addData(handle);
                    }
                }
                result = compositeData;
            }
        } else if (type.equals("char")) {
            // TODO handle char arrays
            MatlabString string = new MatlabString();
            String charData = (String) data;
            string.setData(charData.replaceAll("\n", " "));
            // string.setData(((String) (data[0])).replace("\n"," "));
            result = string;
        } else if (type.equals("cell")) {
            CellMatlabData cellData = new CellMatlabData();
            result = processCell((Object[]) data, cellData);
        }
        return result;
    }

    private CellMatlabData processCell(Object[] datas, CellMatlabData cellData) {

        for (Object data : datas) {
            if (data instanceof Object[]) {
                CellMatlabData containedCellData = new CellMatlabData();
                containedCellData = processCell(((Object[]) data), containedCellData);
                cellData.addData(containedCellData);
            } else if (data instanceof double[]) {
                double[] doubleData = (double[]) data;
                if (doubleData.length == 1) {
                    Handle handle = new Handle();
                    handle.setData(doubleData[0]);
                    cellData.addData(handle);
                } else {
                    CellMatlabData containedArrayData = new CellMatlabData();
                    for (int i = 0; i < doubleData.length; i++) {
                        Handle handle = new Handle();
                        handle.setData(doubleData[i]);
                        containedArrayData.addData(handle);
                    }
                    cellData.addData(containedArrayData);
                }
            } else if (data instanceof String[]) {
                String[] stringData = (String[]) data;
                if (stringData.length == 1) {
                    MatlabString string = new MatlabString();
                    string.setData(stringData[0]);
                    cellData.addData(string);
                } else {
                    CellMatlabData containedArrayData = new CellMatlabData();
                    for (int i = 0; i < stringData.length; i++) {
                        MatlabString string = new MatlabString();
                        string.setData(stringData[i]);
                        containedArrayData.addData(string);
                    }
                    cellData.addData(containedArrayData);
                }

            } else if (data instanceof String) {
                MatlabString string = new MatlabString();
                string.setData((String) data);
                cellData.addData(string);
            }

        }
        return cellData;
    }

    @Override
    public IVisitableMatlabData evaluateCommands(String[] commandStrings, int outputArgumentCount) {
        IVisitableMatlabData result = null;
        if (commandStrings.length > 1) {
            result = new CellMatlabData();
            for (String commandString : commandStrings) {
                CellMatlabData.asCellMatlabData(result).getDatas()
                        .add(evaluateCommand(commandString, outputArgumentCount));
            }
        } else if (commandStrings.length == 1){
            result = evaluateCommand(commandStrings[0], outputArgumentCount);
        }
        return result;
    }

}