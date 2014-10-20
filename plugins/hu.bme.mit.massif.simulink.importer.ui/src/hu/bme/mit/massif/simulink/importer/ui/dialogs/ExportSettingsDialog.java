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
import java.util.Collections;
import java.util.List;

import org.eclipse.jface.preference.FieldEditor;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Shell;

public class ExportSettingsDialog extends AbstractSimulinkSettingsDialog {
    public ExportSettingsDialog(Shell parentShell, File targetDirectory) {
        super(parentShell, "Export Parameters", targetDirectory);
	}

    @Override
    protected List<FieldEditor> additionalFields(Composite fieldEditorParent) {
        return Collections.emptyList();
    }
}