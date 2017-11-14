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

import java.io.File;
import java.util.List;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.preference.FieldEditor;
import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.preference.StringFieldEditor;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;

public abstract class AbstractSimulinkSettingsDialog extends Dialog {

    protected File targetDirectory;
    private FieldEditorPreferencePage page;
    private ContainerFieldEditor targetDirectoryEditor;
    private String dialogTitle;

    protected IPreferenceStore store;
    
    public AbstractSimulinkSettingsDialog(Shell parentShell, String dialogTitle, File targetDirectory) {
        super(parentShell);
        this.dialogTitle = dialogTitle;
        this.targetDirectory = targetDirectory;
    }

    @Override
    protected void configureShell(Shell newShell) {
        super.configureShell(newShell);
        newShell.setText(dialogTitle);
        newShell.setMinimumSize(500, 170);
    }

    @Override
    protected Control createContents(Composite parent) {
        Control control = super.createContents(parent);
        parent.pack(true);
        return control;
    }

    @Override
    protected Control createDialogArea(Composite parent) {
        Composite composite = (Composite) super.createDialogArea(parent);

        page = new FieldEditorPreferencePage(FieldEditorPreferencePage.GRID) {
            @Override
            public void createControl(Composite parentComposite) {
                noDefaultAndApplyButton();
                super.createControl(parentComposite);
            }

            @Override
            protected void createFieldEditors() {
                Composite fieldEditorParent = getFieldEditorParent();
                targetDirectoryEditor = new ContainerFieldEditor("", "Target directory:", fieldEditorParent);
                targetDirectoryEditor.setEmptyStringAllowed(false);
                targetDirectoryEditor.setValidateStrategy(StringFieldEditor.VALIDATE_ON_KEY_STROKE);
                targetDirectoryEditor.setStringValue(targetDirectory.getPath());
                addField(targetDirectoryEditor);

                List<? extends FieldEditor> additionalFields = additionalFields(fieldEditorParent);
                for (FieldEditor fieldEditor : additionalFields) {
                    addField(fieldEditor);
                }
            }

            @Override
            protected void updateApplyButton() {
                updateButtons(isValid());
                super.updateApplyButton();
            }
        };

        page.createControl(composite);
        Control pageControl = page.getControl();
        pageControl.setLayoutData(new GridData(GridData.FILL_BOTH));
        return pageControl;
    }

    protected abstract List<? extends FieldEditor> additionalFields(Composite fieldEditorParent);

    @Override
    protected void createButtonsForButtonBar(Composite parent) {
        super.createButtonsForButtonBar(parent);
        updateButtons(page.isValid());
    }

    private void updateButtons(boolean isValid) {
        Button okButton = getButton(IDialogConstants.OK_ID);
        if (okButton != null) {
            okButton.setEnabled(isValid);
        }
    }

    @Override
    protected void buttonPressed(int buttonId) {
        if (buttonId == IDialogConstants.OK_ID) {
            targetDirectory = new File(targetDirectoryEditor.getStringValue());
        }
        super.buttonPressed(buttonId);
    }

    public File getTargetDirectory() {
        return targetDirectory;
    }

    public void setPreferenceStore(IPreferenceStore store) {
        this.store = store;
    }

}