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
package hu.bme.mit.massif.simulink.ui.handlers;

import hu.bme.mit.massif.communication.ICommandEvaluator;
import hu.bme.mit.massif.communication.command.MatlabCommand;
import hu.bme.mit.massif.communication.command.MatlabCommandFactory;
import hu.bme.mit.massif.simulink.api.Importer;
import hu.bme.mit.massif.simulink.api.ModelObject;
import hu.bme.mit.massif.simulink.api.exception.SimulinkApiException;
import hu.bme.mit.massif.simulink.api.extension.IBlockImportFilter;
import hu.bme.mit.massif.simulink.api.extension.IParameterImportFilter;
import hu.bme.mit.massif.simulink.api.util.ImportMode;
import hu.bme.mit.massif.simulink.ui.MassifSimulinkUIPlugin;
import hu.bme.mit.massif.simulink.ui.dialogs.ImportSettingsDialog;
import hu.bme.mit.massif.simulink.ui.preferences.PreferenceConstants;
import hu.bme.mit.massif.simulink.ui.providers.ImportFilterRegistry;

import java.io.File;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.handlers.HandlerUtil;

import com.google.common.collect.Maps;

/**
 * Class to handle the import context menu command
 */
public class ImportModelHandler extends AbstractSimulinkHandler {

    protected static final String EXCEPTION_WHILE_IMPORTING = "Exception occurred while importing model!";
    protected static final String EXCEPTION_WHILE_SAVING_MODEL = "Exception occurred while saving model!";

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.core.commands.IHandler#execute(org.eclipse.core.commands. ExecutionEvent)
     */
    @Override
    public Object execute(ExecutionEvent event) throws ExecutionException {
        ISelection selection = HandlerUtil.getCurrentSelection(event);

        if (selection instanceof IStructuredSelection) {

            ImportSettings settings = prepareSettings();

            if (settings.commandEvaluator != null) {
                for (Object element : ((IStructuredSelection) selection).toList()) {
                    if (element instanceof IFile) {
                        IFile file = (IFile) element;
                        handleFile(file, settings);
                    }
                }
            }
        }
        return null;
    }

    private ImportSettings prepareSettings() {
        ImportSettings settings = new ImportSettings();
        // Import mode
        settings.traverseMode = getPreferenceStringValue(PreferenceConstants.IMPORT_TRAVERSE_MODE, ImportMode.SHALLOW.toString());

        // Command evaluator
        settings.commandEvaluator = getCommandEvaluator();
        return settings;
    }

    private static class ImportSettings {
        String traverseMode;
        ICommandEvaluator commandEvaluator;
    }

    protected void handleFile(IFile file, ImportSettings settings) {
        // Reading parameter values
        // Library/model to import
        String modelName = file.getName().substring(0, file.getName().lastIndexOf("."));
        String modelPath = file.getParent().getLocation().toOSString();

        // Result settings - path and model name
        String resultPath = getPreferenceStringValue(PreferenceConstants.IMPORT_RESULT_MODEL_PATH, "");
        String newModelName = modelName;

        Map<String, Boolean> selectedFilters = Maps.newHashMap();
        
        // If the corresponding preferences are not set, the user is prompted to select location and name
        if (resultPath == null || resultPath.equals("")) {

            ImportSettingsDialog dialog = new ImportSettingsDialog(Display.getCurrent().getActiveShell(), modelName,
                    new File(modelPath));
            IPreferenceStore store = MassifSimulinkUIPlugin.getDefault().getPreferenceStore();
            dialog.setPreferenceStore(store);
            dialog.open();

            // If the operation was cancelled, then return
            if (dialog.getReturnCode() == Dialog.CANCEL) {
                return;
            }
            resultPath = dialog.getTargetDirectory().toString();
            newModelName = dialog.getImportedModelName();
            selectedFilters = dialog.getSelectedFiltersById();
        }
        
        importModel(modelName, modelPath, newModelName, resultPath, settings,selectedFilters);

        // TODO instead, refresh on save path
        // try {
        // file.getParent().refreshLocal(IResource.DEPTH_ONE, null);
        // } catch (CoreException e) {
        // Status status = new Status(Status.ERROR, Activator.PLUGIN_ID, EXCEPTION_WHILE_IMPORTING, e);
        // Activator.getDefault().getLog().log(status);
        // }
    }

    private boolean saveModel = true;
    
    public boolean isSaveModel() {
        return saveModel;
    }

    public void setSaveModel(boolean saveModel) {
        this.saveModel = saveModel;
    }

    private void importModel(String modelName, String modelPath, final String importedModelName,
        final String resultPath, final ImportSettings settings, Map<String, Boolean> selectedFilters) {
        MatlabCommandFactory factory = new MatlabCommandFactory(settings.commandEvaluator);
    	MatlabCommand addpathModel = factory.addPath();
        addpathModel.addParam(modelPath);
        addpathModel.execute();

        // Setup MATLAB
        setup(settings.commandEvaluator, PreferenceConstants.IMPORT_ADDITIONAL_MATLAB_PATH,
            PreferenceConstants.IMPORT_STARTUP_SCRIPTS);

        // Get the model by its name
        final ModelObject model = new ModelObject(modelName, settings.commandEvaluator);
        // Set model path (without model name)
        model.setLoadPath(modelPath);

        // Add specified filters
        Set<String> selectedFilterIds = selectedFilters.keySet();
        for (String filterId : selectedFilterIds) {
        	if(selectedFilters.get(filterId)){
        		model.registerApplicableFilters(filterId);        		
        	}
		}
        
        Job job = new Job("Importing model " + modelName + "...") {
            @Override
            protected IStatus run(IProgressMonitor monitor) {
                Importer traverser = new Importer(model);
                traverser.setDefaultSavePath(resultPath);

                try {
                    saveModel = true;
                    
                    // Register applicable filters for the traverser (both block and parameter filters)
                    for (String filterId : model.getApplicableFilters()) {						
                    	IBlockImportFilter blockFilter = ImportFilterRegistry.INSTANCE.getBlockFiltersById().get(filterId);
                    	if(blockFilter != null) {
                    		traverser.registerBlockFilter(blockFilter);                    		
                    	} else {
                    		IParameterImportFilter paramFilter = ImportFilterRegistry.INSTANCE.getParameterFiltersById().get(filterId);
                    		if (paramFilter != null) {
                    			traverser.registerParameterFilter(paramFilter);
                    		} else {
                    			// Given filter is not known/not a block or parameter filter
                    			throw new SimulinkApiException("Could not register filter with ID " + filterId);
                    		}
                    	}
					}
                    
                    traverser.traverseAndCreateEMFModel(ImportMode.valueOf(settings.traverseMode));
                } catch (Exception e) {
                    Status status = new Status(Status.ERROR, MassifSimulinkUIPlugin.PLUGIN_ID, EXCEPTION_WHILE_IMPORTING, e);
                    MassifSimulinkUIPlugin.getDefault().getLog().log(status);
                    Display.getDefault().syncExec(new Runnable() {
                        @Override
                        public void run() {
                            setSaveModel(MessageDialog.openQuestion(Display.getDefault().getActiveShell(),
                                    "Error while importing model", EXCEPTION_WHILE_IMPORTING
                                            + " Do you want to save the partially created model?"));
                        }
                    });
                } finally {
                    if (saveModel) {
                        try {
                            traverser.saveEMFModel(resultPath + File.separator + importedModelName);
                        } catch (SimulinkApiException e) {
                            Status status = new Status(Status.ERROR, MassifSimulinkUIPlugin.PLUGIN_ID, EXCEPTION_WHILE_SAVING_MODEL,
                                    e);
                            MassifSimulinkUIPlugin.getDefault().getLog().log(status);
                        }
                    }
                }

                return Status.OK_STATUS;
            }
        };
        job.setUser(true);
        job.schedule();
    }

}
