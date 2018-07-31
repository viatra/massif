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
package hu.bme.mit.massif.simulink.api.extension;

import hu.bme.mit.massif.communication.command.MatlabCommandFactory;

/**
 * Interface that defines the filter for importing Simulink models
 */
public interface IBlockImportFilter {

	
	/**
	 * @return the name of the filter
	 */
	String getName();
	
	/** 
	 * @return a short description for the filter implementation, and it is used as the tooltip text on the preference page
	 */
	String getDescription();
	
    /**
     * Determines if the internal content of a Simulink block should also be imported.
     * 
     * @param commandFactory
     *            the MATLAB command factory object
     * @param blockFQN
     *            the fully qualified name of the block
     * @return true if the sub-blocks of the block should not be imported (in other words: returns if the sub-blocks
     *         should be filtered)
     */
    boolean filter(MatlabCommandFactory commandFactory, String blockFQN);

}
