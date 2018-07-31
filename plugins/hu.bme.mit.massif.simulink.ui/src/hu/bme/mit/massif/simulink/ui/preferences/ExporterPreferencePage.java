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
package hu.bme.mit.massif.simulink.ui.preferences;

import hu.bme.mit.massif.simulink.ui.MassifSimulinkUIPlugin;
import hu.bme.mit.massif.simulink.ui.dialogs.ContainerFieldEditor;

import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.preference.RadioGroupFieldEditor;
import org.eclipse.jface.preference.StringFieldEditor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;

/**
 * Preference page class for the Simulink exporter setting customization
 */
public class ExporterPreferencePage extends FieldEditorPreferencePage implements IWorkbenchPreferencePage {

    @Override
    public void init(IWorkbench workbench) {
    }

    public ExporterPreferencePage() {
        super();
        // Set the preference store for the preference page.
        IPreferenceStore store = MassifSimulinkUIPlugin.getDefault().getPreferenceStore();
        setPreferenceStore(store);
    }

    /**
     * Creates the field editors.
     */
    public void createFieldEditors() {

        Label modelPathInformation = new Label(getFieldEditorParent(), SWT.NONE);
        modelPathInformation.setBounds(new Rectangle(0, 0, 400, 30));
        modelPathInformation.setText("You can provide a default path for the exported models."
                + "\nIf empty, you will be prompted for the required information at export time.");

        // Result model path
        ContainerFieldEditor resultModelPathEditor = new ContainerFieldEditor(
                PreferenceConstants.EXPORT_RESULT_MODEL_PATH, "Default result model location:", getFieldEditorParent());
        addField(resultModelPathEditor);

        // Result model extension
        //@formatter:off
        RadioGroupFieldEditor modelExtensionSelector= new RadioGroupFieldEditor(
                PreferenceConstants.EXPORT_RESULT_MODEL_EXTENSION, 
                "Simulink model file extension: ", 
                1,
                new String[][] {
                    {"MDL", "mdl"},
                    {"SLX", "slx"}
                },
              getFieldEditorParent());  
        //@formatter:on
        addField(modelExtensionSelector);

        // A horizontal separator on the page
        SeparatorFieldEditor separator = new SeparatorFieldEditor(getFieldEditorParent());
        addField(separator);

        Label additionalMatlabPathInformation = new Label(getFieldEditorParent(), SWT.NONE);
        additionalMatlabPathInformation.setBounds(new Rectangle(0, 0, 400, 30));
        additionalMatlabPathInformation
                .setText("You can provide additional path that are to be added to the Matlab Path."
                        + "\nIf you provide multiple paths, separate them with '|'.");

        // Additional MATLAB path
        addField(new StringFieldEditor(PreferenceConstants.EXPORT_ADDITIONAL_MATLAB_PATH, "Additional Matlab path:",
                getFieldEditorParent()));

        Label startupScriptInformation = new Label(getFieldEditorParent(), SWT.NONE);
        startupScriptInformation.setBounds(new Rectangle(0, 0, 400, 30));
        startupScriptInformation
                .setText("You can provide additional startup scripts that are to be executed in Matlab."
                        + "\nIf you provide multiple script names, separate them with '|'.");

        // Additional MATLAB script names
        addField(new StringFieldEditor(PreferenceConstants.EXPORT_SCRIPT_NAMES, "Startup script names:",
                getFieldEditorParent()));

    }

}