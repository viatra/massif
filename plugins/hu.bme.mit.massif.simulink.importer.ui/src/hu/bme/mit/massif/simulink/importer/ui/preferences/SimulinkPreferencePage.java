/*******************************************************************************
 * Copyright (c) 2010, 2014, Embraer S.A., Budapest University of Technology and Economics
 * All rights reserved. This program and the accompanying materials 
 * are made available under the terms of the Eclipse Public License v1.0 
 * which accompanies this distribution, and is available at 
 * http://www.eclipse.org/legal/epl-v10.html 
 *
 * Contributors: 
 *     Abel Hegedus - initial API and implementation 
 *******************************************************************************/
package hu.bme.mit.massif.simulink.importer.ui.preferences;

import hu.bme.mit.massif.communication.manager.CommandEvaluatorManager;
import hu.bme.mit.massif.simulink.importer.ui.MassifSimulinkUIPlugin;

import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.jface.preference.ComboFieldEditor;
import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.preference.IntegerFieldEditor;
import org.eclipse.jface.preference.StringFieldEditor;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;

/**
 * This class represents a preference page that is contributed to the Preferences dialog. By subclassing
 * <samp>FieldEditorPreferencePage</samp>, we can use the field support built into JFace that allows us to create a page
 * that is small and knows how to save, restore and apply itself.
 * <p>
 * This page is used to modify preferences only. They are stored in the preference store that belongs to the main
 * plug-in class. That way, preferences can be accessed directly via the preference store.
 */
public class SimulinkPreferencePage extends FieldEditorPreferencePage implements IWorkbenchPreferencePage {

    public SimulinkPreferencePage() {
        super(GRID);
        IPreferenceStore store = MassifSimulinkUIPlugin.getDefault().getPreferenceStore();
        setPreferenceStore(store);
        setDescription("Global settings for model import and model export. This configuration is required to set up the connection between a running Matlab instance.");
    }

    /**
     * Creates the field editors. Field editors are abstractions of the common GUI blocks needed to manipulate various
     * types of preferences. Each field editor knows how to save and restore itself.
     */
    @Override
	public void createFieldEditors() {

        addField(new StringFieldEditor(PreferenceConstants.HOST_ADDRESS, "Host IPv4 address:", getFieldEditorParent()));
        addField(new IntegerFieldEditor(PreferenceConstants.HOST_PORT, "Host port number:", getFieldEditorParent()));
        addField(new StringFieldEditor(PreferenceConstants.SERVICE_NAME, "Service name:", getFieldEditorParent()));
        addField(new StringFieldEditor(PreferenceConstants.MATLAB_PATH, "Path to Matlab executable", getFieldEditorParent()));
        
        String[][] connectors = processAvailableConnectors();
        addField(new ComboFieldEditor(PreferenceConstants.MATLAB_CONNECTOR, "Matlab Connector", connectors, getFieldEditorParent()));
    }

	private String[][] processAvailableConnectors() {
		Map<String, String> connectorIdNameMap = CommandEvaluatorManager.INSTANCE.getConnectorIdNameMap();
        int numberOfConnectors = connectorIdNameMap.keySet().size();
		String[][] connectors = new String[numberOfConnectors][2];
		int i = 0;
		for (Entry<String, String> entry : connectorIdNameMap.entrySet()) {
			String[] nameAndId = connectors[i];
			nameAndId[0] = entry.getValue();
			nameAndId[1] = entry.getKey();
			i++;
		}
		return connectors;
	}

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.ui.IWorkbenchPreferencePage#init(org.eclipse.ui.IWorkbench)
     */
    @Override
	public void init(IWorkbench workbench) {
    }

}