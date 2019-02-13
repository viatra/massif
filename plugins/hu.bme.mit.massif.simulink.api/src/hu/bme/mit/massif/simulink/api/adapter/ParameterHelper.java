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
package hu.bme.mit.massif.simulink.api.adapter;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import hu.bme.mit.massif.communication.command.MatlabCommand;
import hu.bme.mit.massif.communication.datatype.CellMatlabData;
import hu.bme.mit.massif.communication.datatype.Handle;
import hu.bme.mit.massif.communication.datatype.IVisitableMatlabData;
import hu.bme.mit.massif.communication.datatype.MatlabString;
import hu.bme.mit.massif.communication.datatype.StructMatlabData;
import hu.bme.mit.massif.simulink.Parameter;
import hu.bme.mit.massif.simulink.SimulinkFactory;
import hu.bme.mit.massif.simulink.api.data.AbstractImporterData;
import hu.bme.mit.massif.simulink.api.data.PortData;
import hu.bme.mit.massif.simulink.api.extension.IParameterImportFilter;

public class ParameterHelper {

    public static List<Parameter> collectParameters(AbstractImporterData dto) {
        List<Parameter> blockProperties = new LinkedList<Parameter>();

        MatlabCommand getAllBlockParameters = dto.getCommandFactory().customCommand("massif.get_all_parameters", 1).addParam(dto.getHandle());
        Map<String, IVisitableMatlabData> blockPropsMap = StructMatlabData.getStructMatlabDataData(getAllBlockParameters.execute());

        Set<IParameterImportFilter> parameterFilters = dto.getParameterFilters();

        Set<Entry<String, IVisitableMatlabData>> entries = blockPropsMap.entrySet();
        for (Entry<String, IVisitableMatlabData> entry : entries) {
            String propertyName = entry.getKey();

            boolean isFiltered = false;
            for (IParameterImportFilter paramFilter : parameterFilters) {
                isFiltered |= paramFilter.filter(dto.getCommandFactory(), propertyName);
            }

            if (isFiltered) {
                continue;
            }

            IVisitableMatlabData value = entry.getValue();
            Parameter prop = SimulinkFactory.eINSTANCE.createParameter();
            if (propertyName.matches(".*READONLY$")) {
                propertyName = propertyName.replace("_READONLY", "");
                prop.setReadOnly(true);
            }
            prop.setName(propertyName);

            if (value == null) {
                // Default: empty string
                prop.setType("char");
                prop.setValue("");
                blockProperties.add(prop);
            } else {
                if (value instanceof MatlabString) {
                    prop.setType("char");
                    prop.setValue(value.toString().replaceFirst("'", "").replaceAll("'$", ""));
                } else if (value instanceof Handle) {
                    prop.setType("handle");
                    prop.setValue(value.toString());
                } else if (value instanceof CellMatlabData) {
                    prop.setType("cell");
                    prop.setValue(value.toString());
                } else if (value instanceof StructMatlabData) {
                    prop.setType("struct");
                    prop.setValue(value.toString());
                }
                blockProperties.add(prop);
            }
        }
        return blockProperties;
    }

}
