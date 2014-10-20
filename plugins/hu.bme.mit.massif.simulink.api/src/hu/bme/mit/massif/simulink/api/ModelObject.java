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
package hu.bme.mit.massif.simulink.api;

import hu.bme.mit.massif.communication.ICommandEvaluator;
import hu.bme.mit.massif.communication.command.MatlabCommandFactory;

import java.util.HashSet;
import java.util.Set;

/**
 * This class represents the Simulink model in the API, but not to be confused with SimulinkModel. Instances of this
 * class are associated with an individual model in Simulink and with a command evaluator object that can execute given
 * MATLAB commands.
 */
public class ModelObject {

    /**
     * Stores the Simulink model's load path
     */
    private String loadPath;

    /**
     * Filter set for the importer. Filters are used to determine which subsystems should be further traversed.
     */
    private Set<String> applicableFilters;

    /**
     * Common attributes for each MATLAB Simulink objects
     */
    protected final String fullyQualifiedName;

    /**
      * 
      */
    protected final ICommandEvaluator commandEvaluator;

	private MatlabCommandFactory commandFactory;

    /**
     * Returns the associated command evaluator object
     * 
     * @return the command evaluator object
     */
    public ICommandEvaluator getCommandEvaluator() {
        return commandEvaluator;
    }

    /**
     * Returns the created command factory
     * 
     * @return the command evaluator object
     */
    public MatlabCommandFactory getCommandFactory() {
    	return commandFactory;
    }

	/**
     * Constructor
     * 
     * @param modelName
     *            the model name in Simulink
     * @param commandEvaluator
     *            the associated ICommandEvaluator object
     */
    public ModelObject(String modelName, ICommandEvaluator commandEvaluator) {
        this.commandEvaluator = commandEvaluator;
        this.commandFactory = new MatlabCommandFactory(commandEvaluator);
        this.fullyQualifiedName = modelName;
    }

    /**
     * List of filter identifiers that are to be applied on the current model
     * 
     * @return the copy of the applicableFilters collection
     */
    public Set<String> getApplicableFilters() {
        if (applicableFilters == null) {
            return new HashSet<String>();
        }
        return new HashSet<String>(applicableFilters);
    }

    /**
     * Registers a filter identifier into the list of applicable filters
     * 
     * @param filterId
     *            the identifier of the filter to be used
     */
    public void registerApplicableFilters(String filterId) {
        if (applicableFilters == null) {
            applicableFilters = new HashSet<String>();
        }
        if (filterId != null && !"".equals(filterId)) {
            applicableFilters.add(filterId);
        }
    }

    /**
     * @return the model load path in Simulink
     */
    public String getLoadPath() {
        return loadPath;
    }

    /**
     * @param loadPath
     *            the model load path in Simulink
     */
    public void setLoadPath(String loadPath) {
        this.loadPath = loadPath;
    }

    /**
     * Getter for the FQN of the MATLAB model
     * 
     * @return a String containing the full name
     */
    public String getFullyQualifiedName() {
        return fullyQualifiedName;
    }

}
