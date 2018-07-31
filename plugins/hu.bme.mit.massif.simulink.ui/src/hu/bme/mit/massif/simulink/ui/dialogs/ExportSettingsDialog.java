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
package hu.bme.mit.massif.simulink.ui.dialogs;

import hu.bme.mit.massif.simulink.ui.preferences.PreferenceConstants;

import java.io.File;
import java.util.List;

import org.eclipse.jface.preference.FieldEditor;
import org.eclipse.jface.preference.RadioGroupFieldEditor;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Shell;

import com.google.common.collect.Lists;

public class ExportSettingsDialog extends AbstractSimulinkSettingsDialog {
    private RadioGroupFieldEditor modelExtensionSelector;


    public ExportSettingsDialog(Shell parentShell, File targetDirectory) {
        super(parentShell, "Export Parameters", targetDirectory);
	}
    
    @Override
    protected List<? extends FieldEditor> additionalFields(Composite fieldEditorParent) {
        modelExtensionSelector = new RadioGroupFieldEditor(
                PreferenceConstants.EXPORT_RESULT_MODEL_EXTENSION, 
                "Simulink model file extension: ", 
                1,
                new String[][] {
                    {"MDL", "mdl"},
                    {"SLX", "slx"}
                },
                fieldEditorParent);  
        //@formatter:on
        modelExtensionSelector.setPreferenceStore(store);
        modelExtensionSelector.load();
        
        return Lists.newArrayList(modelExtensionSelector);
    }
    
    public void storeSelectedFileExtension() {
        modelExtensionSelector.setPreferenceStore(store);
        modelExtensionSelector.store();
    }
}