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

import hu.bme.mit.massif.simulink.api.extension.ISimulinkImportFilter;
import hu.bme.mit.massif.simulink.api.util.ImportMode;
import hu.bme.mit.massif.simulink.importer.ui.MassifSimulinkUIPlugin;
import hu.bme.mit.massif.simulink.importer.ui.dialogs.ContainerFieldEditor;
import hu.bme.mit.massif.simulink.importer.ui.providers.ImportFilterRegistry;

import java.util.Map;

import org.eclipse.jface.preference.BooleanFieldEditor;
import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.preference.RadioGroupFieldEditor;
import org.eclipse.jface.preference.StringFieldEditor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;

/**
 * Preference page class for the Simulink importer setting customization
 */
public class ImporterPreferencePage extends FieldEditorPreferencePage implements IWorkbenchPreferencePage {

    @Override
    public void init(IWorkbench workbench) {
    }

    public ImporterPreferencePage() {
        super();
        // Set the preference store for the preference page.
        IPreferenceStore store = MassifSimulinkUIPlugin.getDefault().getPreferenceStore();
        setPreferenceStore(store);
    }

    /**
     * Creates the field editors.
     */
    public void createFieldEditors() {

        Label traverseModeInformation = new Label(getFieldEditorParent(), SWT.NONE);
        traverseModeInformation.setBounds(new Rectangle(0, 0, 300, 30));
        traverseModeInformation.setText("Set the traversal strategy of the importer."
                + "\nCases differ in handling model references.");

        // Traverse mode
        RadioGroupFieldEditor importModePickerEditor = new RadioGroupFieldEditor(
                PreferenceConstants.IMPORT_TRAVERSE_MODE, "Traverse mode:", 1, new String[][] {
                        { "&Shallow (only the model reference block is imported)", ImportMode.SHALLOW.toString() },
                        { "&Deep (the models referred by the imported model are also imported as an individual model)", ImportMode.DEEP.toString() },
                        { "&Flattening (the model references are resolved and are imported as though they were part of the same model)", ImportMode.FLATTENING.toString() }, 
                        { "&Referencing (all linked subsystem blocks' library is imported as an individual model)", ImportMode.REFERENCING.toString() } 
                },
                getFieldEditorParent());
        addField(importModePickerEditor);

        Label modelPathInformationPlaceholder = new Label(getFieldEditorParent(), SWT.NONE);
        modelPathInformationPlaceholder.setBounds(new Rectangle(0, 0, 300, 15));
        modelPathInformationPlaceholder.setText("");
        Label modelPathInformation = new Label(getFieldEditorParent(), SWT.NONE);
        modelPathInformation.setBounds(new Rectangle(0, 0, 400, 30));
        modelPathInformation.setText("You can provide a default path for the imported models."
                + "\nIf empty, you will be prompted for the required information at import time.");

        // Result model path
        ContainerFieldEditor resultModelPathEditor = new ContainerFieldEditor(
                PreferenceConstants.IMPORT_RESULT_MODEL_PATH, "Default result model location:", getFieldEditorParent());

        // A horizontal separator on the page
        SeparatorFieldEditor separator = new SeparatorFieldEditor(getFieldEditorParent());
        addField(separator);

        // Import filter
        // TODO magic string elimination
        Label filterInformation = new Label(getFieldEditorParent(), SWT.NONE);
        filterInformation.setBounds(new Rectangle(0, 0, 300, 15));
        filterInformation.setText("Import filters to use by default:");

        
        Map<String, ISimulinkImportFilter> filtersById = ImportFilterRegistry.INSTANCE.getFiltersById();
        Map<String, String> filterNamesById = ImportFilterRegistry.INSTANCE.getFilterNamesById();
        Map<String, String> filterTooltipsById = ImportFilterRegistry.INSTANCE.getFilterTooltipsById();
        for (String filterId : filtersById.keySet()) {
        	Composite filterCheckboxParent = getFieldEditorParent();
        	BooleanFieldEditor filterCheckbox = new BooleanFieldEditor(filterId,filterNamesById.get(filterId), filterCheckboxParent);
        	filterCheckbox.getDescriptionControl(filterCheckboxParent).setToolTipText(filterTooltipsById.get(filterId));
        	addField(filterCheckbox);			
		}
        

		// TODO set this, makes the setting more user friendly
		// resultModelPathEditor.setFilterPath(path);

        addField(resultModelPathEditor);

        Label additionalMatlabPathInformation = new Label(getFieldEditorParent(), SWT.NONE);
        additionalMatlabPathInformation.setBounds(new Rectangle(0, 0, 400, 30));
        additionalMatlabPathInformation
                .setText("You can provide additional path that are to be added to the Matlab Path."
                        + "\nIf you provide multiple paths, separate them with '|'.");

        // Additional MATLAB path
        addField(new StringFieldEditor(PreferenceConstants.IMPORT_ADDITIONAL_MATLAB_PATH, "Additional Matlab path:",
                getFieldEditorParent()));

        Label startupScriptInformation = new Label(getFieldEditorParent(), SWT.NONE);
        startupScriptInformation.setBounds(new Rectangle(0, 0, 400, 30));
        startupScriptInformation
                .setText("You can provide additional startup scripts that are to be executed in Matlab."
                        + "\nIf you provide multiple script names, separate them with '|'.");

        // Additional MATLAB script names
        addField(new StringFieldEditor(PreferenceConstants.IMPORT_STARTUP_SCRIPTS, "Startup script names:",
                getFieldEditorParent()));

    }

}