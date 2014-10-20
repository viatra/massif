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
package hu.bme.mit.massif.simulink.api.util;

import hu.bme.mit.massif.communication.command.MatlabCommand;
import hu.bme.mit.massif.communication.command.MatlabCommandFactory;
import hu.bme.mit.massif.communication.datatype.Handle;
import hu.bme.mit.massif.communication.datatype.IVisitableMatlabData;
import hu.bme.mit.massif.communication.datatype.MatlabString;
import hu.bme.mit.massif.communication.datatype.StructMatlabData;
import hu.bme.mit.massif.simulink.Block;
import hu.bme.mit.massif.simulink.Property;
import hu.bme.mit.massif.simulink.PropertySource;
import hu.bme.mit.massif.simulink.PropertyType;
import hu.bme.mit.massif.simulink.SimulinkFactory;
import hu.bme.mit.massif.simulink.api.exception.SimulinkApiException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * 
 * @author Abel Hegedus
 */
public final class BasicSimulinkEMFOperationsAPI {

    /**
     * Important: call this after getMaskParameters!
     * 
     * @param commandEvaluator
     * @param currentBlockHandle
     * @return
     */
    public static List<Property> getDialogParameters(MatlabCommandFactory commandFactory, Block block) {

        // Get the list of mask parameter variable names
        List<String> maskParameterNames = new ArrayList<String>();
        for (Property property : block.getProperties()) {
            maskParameterNames.add(property.getName());
        }

        // Fetch dialog parameter names
        MatlabCommand getDialogParameters = commandFactory.getParam().addParam(block.getSimulinkRef().getFQN()).addParam("DialogParameters");
        StructMatlabData dialogParametersAndAttributes = StructMatlabData.asStructMatlabData(getDialogParameters
                .execute());
        Set<String> dialogParameterNames = dialogParametersAndAttributes.getDatas().keySet();

        List<String> dialogParametersToProcess = new ArrayList<String>();

        for (String dialogParameterName : dialogParameterNames) {
            if (!maskParameterNames.contains(dialogParameterName)) {
                dialogParametersToProcess.add(dialogParameterName);
            }
        }

        List<Property> dialogProperties = new ArrayList<Property>();

        // If the dialog parameter is not among the mask parameters, process it
        for (String dialogParameter : dialogParametersToProcess) {

        	MatlabCommand getDialogParameterValue = commandFactory.getParam().addParam(block.getSimulinkRef().getFQN()).addParam(dialogParameter);
            IVisitableMatlabData dialogParameterValue = getDialogParameterValue.execute();

            if (dialogParameterValue instanceof MatlabString) {
                Property dialogProperty = SimulinkFactory.eINSTANCE.createProperty();
                dialogProperty.setName(dialogParameter);
                dialogProperty.setSource(PropertySource.DIALOG);
                dialogProperty.setType(PropertyType.STRING_PROPERTY);
                dialogProperty.setValue(MatlabString.getMatlabStringData(dialogParameterValue));
                dialogProperties.add(dialogProperty);
            }

        }

        return dialogProperties;
    }

    /**
     * Processes the mask of the given block and prepares the property list
     * 
     * @param proxy
     *            the Matlab proxy to use
     * @param currentBlockHandle
     *            the handle of the block
     * @return the list of properties based on the block mask
     * @throws SimulinkApiException
     */
    public static List<Property> getMaskParameters(MatlabCommandFactory commandFactory, Handle currentBlockHandle) {

        // TODO use mask objects
    	MatlabCommand getIsMasked = commandFactory.get().addParam(currentBlockHandle).addParam("Mask");
        String isMasked = MatlabString.getMatlabStringData(getIsMasked.execute());

        if ("on".equals(isMasked)) {

            List<Property> props = new LinkedList<Property>();

            // String maskVarNames = (String) BasicOperationsApi.getParam(matlabClient, currentBlockHandle, 1, "MaskVariables")[0];
            MatlabCommand getMaskVarNames = commandFactory.getParam().addParam(currentBlockHandle).addParam("MaskVariables");
            String maskVarNames = MatlabString.getMatlabStringData(getMaskVarNames.execute());

            // String maskVarValues = (String) BasicOperationsApi.getParam(matlabClient, currentBlockHandle, 1, "MaskValueString")[0];
            MatlabCommand getMaskVarValues = commandFactory.getParam().addParam(currentBlockHandle).addParam("MaskValueString");
            String maskVarValues = MatlabString.getMatlabStringData(getMaskVarValues.execute());
            
            String[] maskVarNamesArray = maskVarNames.split("=(&|@)(\\d*);");
            // If the only variable name in the array of variable names is an
            // empty string it means the mask is on, but has no mask variables
            if (maskVarNamesArray.length == 1 && maskVarNamesArray[0].equals(""))
                return new LinkedList<Property>();

            String[] maskVarValuesArray = convertMaskVarValuesToArray(maskVarValues);

            for (int i = 0; i < maskVarNamesArray.length; i++) {

                Property prop = SimulinkFactory.eINSTANCE.createProperty();
                prop.setName(maskVarNamesArray[i]);
                prop.setValue(maskVarValuesArray[i].equals("''") ? "" : maskVarValuesArray[i]);
                prop.setSource(PropertySource.MASK);

                createPropertyFromMaskParam(commandFactory, currentBlockHandle, maskVarNamesArray[i], prop);

                props.add(prop);

            }

            return props;
        }
        return new LinkedList<Property>();
    }

    private static void createPropertyFromMaskParam(MatlabCommandFactory commandFactory, Handle currentBlockHandle,
            String maskVarParam, Property prop) {
        String type = null;

        MatlabCommand getObjectParamters = commandFactory.customCommand("ops = get_param(" + currentBlockHandle + ",'ObjectParameters');", 0);
        getObjectParamters.execute();

        MatlabCommand getObjectParamterTypes  = commandFactory.customCommand("ops." + maskVarParam + ".Type", 1);
        type = MatlabString.getMatlabStringData(getObjectParamterTypes.execute());

        // TODO to prepare for further types apply adapter pattern instead of using if-else
        if (type == null) {
            prop.setType(PropertyType.STRING_PROPERTY);
        } else if (type.equals("real") || type.equals("double")) {
            prop.setType(PropertyType.DOUBLE_PROPERTY);
        } else if (type.equals("integer")) {
            prop.setType(PropertyType.INTEGER_PROPERTY);
        } else {
            prop.setType(PropertyType.STRING_PROPERTY);
        }
    }

    private static String[] convertMaskVarValuesToArray(String maskVarValues) {
        String[] maskVarValuesArray = null;
        String _maskVarValues = maskVarValues;
        while (_maskVarValues.contains("||")) {
            _maskVarValues = _maskVarValues.replaceFirst("\\|\\|", "\\|''\\|");
        }
        // If the last mask parameter value is also empty/not provided, insert a '' to indicate this
        if (_maskVarValues.charAt(_maskVarValues.length() - 1) == '|')
            _maskVarValues = _maskVarValues.concat("''");

        String[] splitValues = _maskVarValues.split("\\|");

        int maskVarValuesArrayLength = splitValues.length;
        if (_maskVarValues.lastIndexOf('|') == _maskVarValues.length() - 1) {
            maskVarValuesArrayLength++;
        }
        maskVarValuesArray = Arrays.copyOf(splitValues, maskVarValuesArrayLength);
        if (maskVarValuesArrayLength > splitValues.length) {
            maskVarValuesArray[splitValues.length] = "";
        }
        return maskVarValuesArray;
    }

}
