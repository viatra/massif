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