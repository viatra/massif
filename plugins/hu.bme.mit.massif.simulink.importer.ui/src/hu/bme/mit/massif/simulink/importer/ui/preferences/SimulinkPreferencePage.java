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
package hu.bme.mit.massif.simulink.importer.ui.preferences;

import hu.bme.mit.massif.simulink.importer.ui.Activator;

import org.eclipse.jface.preference.ComboFieldEditor;
import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.preference.IntegerFieldEditor;
import org.eclipse.jface.preference.RadioGroupFieldEditor;
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
        IPreferenceStore store = Activator.getDefault().getPreferenceStore();
        setPreferenceStore(store);
        setDescription("Global settings for model import and model export. This configuration is required to set up the connection between a running Matlab instance.");
    }

    /**
     * Creates the field editors. Field editors are abstractions of the common GUI blocks needed to manipulate various
     * types of preferences. Each field editor knows how to save and restore itself.
     */
    public void createFieldEditors() {

        // Matlab session's PID is not necessary for now
        // addField(new StringFieldEditor(PreferenceConstants.PREFERRED_MATLAB_PID, "Preferred Matlab PID:",
        // getFieldEditorParent()));
        addField(new StringFieldEditor(PreferenceConstants.HOST_ADDRESS, "Host IPv4 address:", getFieldEditorParent()));
        addField(new IntegerFieldEditor(PreferenceConstants.HOST_PORT, "Host port number:", getFieldEditorParent()));
        addField(new StringFieldEditor(PreferenceConstants.SERVICE_NAME, "Service name:", getFieldEditorParent()));
        addField(new RadioGroupFieldEditor(PreferenceConstants.MATLAB_CONNECTOR, "Matlab Connector", 1, new String[][]{
        		new String[]{"Command Evaluation Server", PreferenceConstants.COMMAND_EVALUATION_SERVER_ID},
        		new String[]{"MatlabControl", PreferenceConstants.MATLAB_CONTROL_ID}
        }, getFieldEditorParent(),true));
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.ui.IWorkbenchPreferencePage#init(org.eclipse.ui.IWorkbench)
     */
    public void init(IWorkbench workbench) {
    }

}