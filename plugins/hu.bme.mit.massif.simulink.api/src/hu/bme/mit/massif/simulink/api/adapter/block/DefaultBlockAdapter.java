/*******************************************************************************
 * Copyright (c) 2010-2013, Embraer S.A., Budapest University of Technology and Economics
 * All rights reserved. This program and the accompanying materials 
 * are made available under the terms of the Eclipse Public License v1.0 
 * which accompanies this distribution, and is available at 
 * http://www.eclipse.org/legal/epl-v10.html 
 *
 * Contributors: 
 *     Marton Bur, Abel Hegedus, Akos Horvath - initial API and implementation 
 *     Marton Bur - script-based parameter querying
 *     Marton Bur - support for parameter filtering
 *******************************************************************************/
package hu.bme.mit.massif.simulink.api.adapter.block;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import hu.bme.mit.massif.communication.command.MatlabCommand;
import hu.bme.mit.massif.communication.command.MatlabCommandFactory;
import hu.bme.mit.massif.communication.datatype.CellMatlabData;
import hu.bme.mit.massif.communication.datatype.Handle;
import hu.bme.mit.massif.communication.datatype.IVisitableMatlabData;
import hu.bme.mit.massif.communication.datatype.MatlabString;
import hu.bme.mit.massif.communication.datatype.StructMatlabData;
import hu.bme.mit.massif.simulink.Block;
import hu.bme.mit.massif.simulink.Parameter;
import hu.bme.mit.massif.simulink.SimulinkFactory;
import hu.bme.mit.massif.simulink.SimulinkReference;
import hu.bme.mit.massif.simulink.api.Importer;
import hu.bme.mit.massif.simulink.api.extension.IParameterImportFilter;

/**
 * Generic adapter for non-specific blocks. This adapter is used when no adapter is registered for a block type. The
 * process method should be called from every class subclassing it.
 */
public class DefaultBlockAdapter implements IBlockAdapter {

    @Override
    public Block getBlock(Importer traverser) {
        return SimulinkFactory.eINSTANCE.createBlock();
    }

    @Override
    public void process(Importer traverser, SimulinkReference parentSimRef, Block blockToProcess) {
        // The default block processing implementation goes here

        MatlabCommandFactory commandFactory = traverser.getCommandFactory();
        String blockFQN = blockToProcess.getSimulinkRef().getFQN();
        
        List<Parameter> blockProperties = new LinkedList<Parameter>();

        MatlabCommand getAllBlockParameters = commandFactory.customCommand("massif.get_all_block_parameters", 1).addParam(blockFQN);
        Map<String, IVisitableMatlabData> blockPropsMap = StructMatlabData.getStructMatlabDataData(getAllBlockParameters.execute());
        
        Set<IParameterImportFilter> parameterFilters = traverser.getParameterFilters();
        
        Set<Entry<String, IVisitableMatlabData>> entries = blockPropsMap.entrySet();
        for (Entry<String, IVisitableMatlabData> entry : entries) {
        	String propertyName = entry.getKey();
        	
        	boolean isFiltered = false;
        	for (IParameterImportFilter paramFilter : parameterFilters) {
				isFiltered |= paramFilter.filter(commandFactory, propertyName);
			}
        	
        	if(isFiltered) {
        		continue;
        	}

        	IVisitableMatlabData value = entry.getValue();
			Parameter prop = SimulinkFactory.eINSTANCE.createParameter();
			prop.setName(propertyName);
			
			if (value == null) {
				// Default: empty string
				prop.setType("char");
				prop.setValue("");				
				blockProperties.add(prop);	
			} else { 
				if(value instanceof MatlabString) {
					prop.setType("char");
				} else if(value instanceof Handle) {
					prop.setType("handle");
				} else if (value instanceof CellMatlabData) {
					prop.setType("cell");
				} else if(value instanceof StructMatlabData) {
					prop.setType("struct");
				}
				prop.setValue(value.toString());
				blockProperties.add(prop);
			} 
        }
        
        blockToProcess.getParameters().addAll(blockProperties);

    }

}
