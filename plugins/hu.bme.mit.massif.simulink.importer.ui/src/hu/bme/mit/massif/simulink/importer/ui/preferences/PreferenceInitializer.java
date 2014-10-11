package hu.bme.mit.massif.simulink.importer.ui.preferences;

/*
 import org.eclipse.core.resources.IWorkspace;
 import org.eclipse.core.resources.IWorkspaceRoot;
 import org.eclipse.core.resources.ResourcesPlugin;
 */
import hu.bme.mit.massif.simulink.api.util.ImportMode;
import hu.bme.mit.massif.simulink.importer.ui.Activator;

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
        IPreferenceStore store = Activator.getDefault().getPreferenceStore();

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
