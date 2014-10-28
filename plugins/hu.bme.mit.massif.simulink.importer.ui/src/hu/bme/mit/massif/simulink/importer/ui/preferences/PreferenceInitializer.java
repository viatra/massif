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

/*
 import org.eclipse.core.resources.IWorkspace;
 import org.eclipse.core.resources.IWorkspaceRoot;
 import org.eclipse.core.resources.ResourcesPlugin;
 */
import hu.bme.mit.massif.simulink.api.util.ImportMode;
import hu.bme.mit.massif.simulink.importer.ui.MassifSimulinkUIPlugin;

import org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer;
import org.eclipse.jface.preference.IPreferenceStore;

/**
 * Class used to initialize default preference values.
 */
public class PreferenceInitializer extends AbstractPreferenceInitializer {

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer#initializeDefaultPreferences()
     */
    public void initializeDefaultPreferences() {
        IPreferenceStore store = MassifSimulinkUIPlugin.getDefault().getPreferenceStore();

        // Global
        store.setDefault(PreferenceConstants.HOST_ADDRESS, "127.0.0.1");
        store.setDefault(PreferenceConstants.HOST_PORT, 1098);

        // Import
        store.setDefault(PreferenceConstants.IMPORT_TRAVERSE_MODE, ImportMode.SHALLOW.toString());
        store.setDefault(PreferenceConstants.IMPORT_RESULT_MODEL_PATH, "");
        store.setDefault(PreferenceConstants.FAM_LEAF_FILTER, true);
        store.setDefault(PreferenceConstants.LIBRARY_FILTER, false);

        // Export
        store.setDefault(PreferenceConstants.EXPORT_RESULT_MODEL_PATH, "");
    }

}
