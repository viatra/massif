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

import java.io.File;

import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.preference.StringButtonFieldEditor;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.dialogs.ContainerSelectionDialog;

/**
 * A field editor for an date preference.
 */
public class ContainerFieldEditor extends StringButtonFieldEditor {

	
    public ContainerFieldEditor(String name, String labelText, Composite parent) {
        init(name, labelText);
        setErrorMessage(JFaceResources
                .getString("ContainerFieldEditor.errorMessage"));//$NON-NLS-1$
        setChangeButtonText(JFaceResources.getString("openBrowse"));//$NON-NLS-1$
        setValidateStrategy(VALIDATE_ON_FOCUS_LOST);
        createControl(parent);
    }

	
	@Override
	protected String changePressed() {
        File f = new File(getTextControl().getText());
        if (!f.exists()) {
			f = null;
		}
        File d = getDirectory(f);
        if (d == null) {
			return null;
		}

        return d.getAbsolutePath();
	}

	
    /**
     * Helper that opens the directory chooser dialog.
     * @param startingDirectory The directory the dialog will open in.
     * @return File File or <code>null</code>.
     * 
     */
    private File getDirectory(File startingDirectory) {

    	ContainerSelectionDialog containerDialog = new ContainerSelectionDialog(getShell(), null, true, "Please select a location in the workspace");
        /*if (startingDirectory != null) {
			fileDialog.setFilterPath(startingDirectory.getPath());
		}*/
        /*else if (filterPath != null) {
        	fileDialog.setFilterPath(filterPath.getPath());
        }*/
        int dialogReturnCode = containerDialog.open();
        if (dialogReturnCode != Dialog.CANCEL) {

        	Object[] resultArray = containerDialog.getResult();
        	if(resultArray != null){
        		Object result = resultArray[0];
        		IPath relativePath = (IPath)result;
        		
				IWorkspace workspace = ResourcesPlugin.getWorkspace();
				File workspaceDirectory = workspace.getRoot().getLocation().toFile();
				String absolutePath = workspaceDirectory.getAbsoluteFile().toURI().toString().replaceAll("/$", "").replaceFirst("file:/", "") + URI.createFileURI(relativePath.toString()).toString();
				
        		return new File(absolutePath);
        	}

        }

        return null;
    }
	
	
}