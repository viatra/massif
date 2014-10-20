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
package hu.bme.mit.massif.simulink.importer.ui.dialogs;

import hu.bme.mit.massif.simulink.importer.ui.preferences.ImporterPreferencePage;
import hu.bme.mit.massif.simulink.importer.ui.preferences.PreferenceConstants;

import java.io.File;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.preference.BooleanFieldEditor;
import org.eclipse.jface.preference.FieldEditor;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.preference.StringFieldEditor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;

public class ImportSettingsDialog extends AbstractSimulinkSettingsDialog {

    private String importedModelName;
    private boolean usingFAMLeafFilter;
    private boolean usingLibraryFilter;

    public boolean isUsingFAMLeafFilter() {
        return usingFAMLeafFilter;
    }

    public boolean isUsingLibraryFilter() {
        return usingLibraryFilter;
    }

    private StringFieldEditor importedModelNameEditor;
    private IPreferenceStore store;
    private BooleanFieldEditor famLeafFilterBooleanField;
    private BooleanFieldEditor libraryFilterBooleanField;

    public ImportSettingsDialog(Shell parentShell, String exporterArgs, File targetDirectory) {
        super(parentShell, " Import Parameters", targetDirectory);
        this.importedModelName = exporterArgs;
    }

    @Override
    protected void configureShell(Shell newShell) {
        super.configureShell(newShell);
        newShell.setSize(500, 220);
    }

    @Override
    protected void buttonPressed(int buttonId) {
        if (buttonId == IDialogConstants.OK_ID) {
            importedModelName = importedModelNameEditor.getStringValue();
            usingFAMLeafFilter = famLeafFilterBooleanField.getBooleanValue();
            usingLibraryFilter = libraryFilterBooleanField.getBooleanValue();
        }
        super.buttonPressed(buttonId);
    }

    public String getImportedModelName() {
        return importedModelName;
    }

    @Override
    protected List<FieldEditor> additionalFields(Composite fieldEditorParent) {
        Label filters = new Label(fieldEditorParent, SWT.NONE);
        filters.setText("Import filters to use:");

        List<FieldEditor> fes = new LinkedList<FieldEditor>();

        famLeafFilterBooleanField = new BooleanFieldEditor("PanelFAMFilterField", "FAM Leaf filter", fieldEditorParent);
        famLeafFilterBooleanField.getDescriptionControl(fieldEditorParent).setToolTipText(
                ImporterPreferencePage.FAM_FILTER_EDITOR_TOOLTIP);
        famLeafFilterBooleanField.setPreferenceStore(store);
        famLeafFilterBooleanField.setPreferenceName(PreferenceConstants.FAM_LEAF_FILTER);
        famLeafFilterBooleanField.load();
        fes.add(famLeafFilterBooleanField);

        libraryFilterBooleanField = new BooleanFieldEditor("PanelLibraryFilterField", "Library filter",
                fieldEditorParent);
        libraryFilterBooleanField.getDescriptionControl(fieldEditorParent).setToolTipText(
                ImporterPreferencePage.LIBRARY_FILTER_EDITOR_TOOLTIP);
        libraryFilterBooleanField.setPreferenceStore(store);
        libraryFilterBooleanField.setPreferenceName(PreferenceConstants.LIBRARY_FILTER);
        libraryFilterBooleanField.load();
        fes.add(libraryFilterBooleanField);

        importedModelNameEditor = new StringFieldEditor("", "Result Model Name:", fieldEditorParent);
        importedModelNameEditor.setEmptyStringAllowed(false);
        importedModelNameEditor.setStringValue(importedModelName);
        fes.add(importedModelNameEditor);

        return fes;
    }

    public void setPreferenceStore(IPreferenceStore store) {
        this.store = store;
    }
}