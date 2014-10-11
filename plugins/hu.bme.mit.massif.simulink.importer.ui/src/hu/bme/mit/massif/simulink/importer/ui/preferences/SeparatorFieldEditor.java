package hu.bme.mit.massif.simulink.importer.ui.preferences;

import org.eclipse.jface.preference.FieldEditor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;

/**
 * A field editor for adding separator to a preference page.
 */
public class SeparatorFieldEditor extends FieldEditor {
    /**
     * The separator label representing a line on the preference page
     */
    private Label separator;

    /**
     * All separators can use the same preference name because they don't store any preferences.
     * @param parent the field editor's parent
     */
    public SeparatorFieldEditor(Composite parent) {
        super("separator", "", parent);
    }

    /**
     * Adjusts the field editor to be displayed correctly for the given number of columns.
     */
    @Override
    protected void adjustForNumColumns(int numColumns) {
        ((GridData) separator.getLayoutData()).horizontalSpan = numColumns;
    }

    /**
     * Fills the field editor's controls into the given parent.
     */
    @Override
    protected void doFillIntoGrid(Composite parent, int numColumns) {
        separator = new Label(parent, SWT.HORIZONTAL | SWT.SEPARATOR);

        GridData gridData = new GridData();
        gridData.horizontalSpan = numColumns;
        gridData.horizontalAlignment = GridData.FILL;
        gridData.verticalAlignment = GridData.CENTER;
        // This needs to be set to true in order to achieve automatic resizing of the component
        gridData.grabExcessHorizontalSpace = true;
        gridData.grabExcessVerticalSpace = false;

        // Set the layout data for the separator
        separator.setLayoutData(gridData);
    }

    /**
     * Returns the number of controls in the field editor.
     */
    public int getNumberOfControls() {
        return 1;
    }

    protected void doLoad() {
        // Nothing is persisted
    }

    protected void doLoadDefault() {
        // Nothing is persisted
    }

    protected void doStore() {
        // Nothing is persisted
    }
}