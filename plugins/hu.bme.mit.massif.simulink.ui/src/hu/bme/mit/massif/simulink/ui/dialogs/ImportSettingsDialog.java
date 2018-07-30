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

import hu.bme.mit.massif.simulink.api.extension.IBlockImportFilter;
import hu.bme.mit.massif.simulink.ui.providers.ImportFilterRegistry;

import java.io.File;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.preference.BooleanFieldEditor;
import org.eclipse.jface.preference.FieldEditor;
import org.eclipse.jface.preference.StringFieldEditor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;

import com.google.common.collect.Maps;

public class ImportSettingsDialog extends AbstractSimulinkSettingsDialog {

	private String importedModelName;
	private Map<String, BooleanFieldEditor> filterSelectors = Maps.newHashMap();
	private Map<String, Boolean> filterSelections = Maps.newHashMap();

	public Map<String, Boolean> getSelectedFiltersById() {
		return filterSelections;
	}

	private StringFieldEditor importedModelNameEditor;


	public ImportSettingsDialog(Shell parentShell, String exporterArgs, File targetDirectory) {
		super(parentShell, " Import Parameters", targetDirectory);
		this.importedModelName = exporterArgs;
	}

	@Override
	protected void buttonPressed(int buttonId) {
		if (buttonId == IDialogConstants.OK_ID) {
			importedModelName = importedModelNameEditor.getStringValue();
			Set<String> filterIds = filterSelectors.keySet();
			for (String filterId : filterIds) {
				BooleanFieldEditor fieldEditor = filterSelectors.get(filterId);
				filterSelections.put(filterId, fieldEditor.getBooleanValue());
			}
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

		Map<String, IBlockImportFilter> filtersById = ImportFilterRegistry.INSTANCE.getBlockFiltersById();
		for (String filterId : filtersById.keySet()) {
			IBlockImportFilter filter = filtersById.get(filterId);
			BooleanFieldEditor filterCheckbox = new BooleanFieldEditor(filterId, filter.getName(), fieldEditorParent);
			filterCheckbox.setPreferenceStore(store);
			filterCheckbox.setPreferenceName(filterId);
			filterCheckbox.load();
			filterCheckbox.getDescriptionControl(fieldEditorParent).setToolTipText(filter.getDescription());
			fes.add(filterCheckbox);
			filterSelectors.put(filterId, filterCheckbox);
		}

		importedModelNameEditor = new StringFieldEditor("", "Result Model Name:", fieldEditorParent);
		importedModelNameEditor.setEmptyStringAllowed(false);
		importedModelNameEditor.setStringValue(importedModelName);
		fes.add(importedModelNameEditor);

		return fes;
	}

}