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
package hu.bme.mit.massif.simulink.importer.ui.handlers;

import hu.bme.mit.massif.communication.ICommandEvaluator;
import hu.bme.mit.massif.communication.command.MatlabCommandFactory;
import hu.bme.mit.massif.simulink.SimulinkModel;
import hu.bme.mit.massif.simulink.api.Exporter;
import hu.bme.mit.massif.simulink.api.exception.SimulinkApiException;
import hu.bme.mit.massif.simulink.importer.ui.MassifSimulinkUIPlugin;
import hu.bme.mit.massif.simulink.importer.ui.dialogs.ExportSettingsDialog;
import hu.bme.mit.massif.simulink.importer.ui.preferences.PreferenceConstants;

import java.io.File;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.preference.PreferenceStore;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.handlers.HandlerUtil;

/**
 * @author Abel Hegedus
 * 
 */
public class ExportModelHandler extends AbstractSimulinkHandler {

    protected static final String EXCEPTION_WHILE_EXPORTING = "Exception occurred while exporting model!";
    protected static final String EXCEPTION_WHILE_SAVING = "Exception occurred while saving exported model!";

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.core.commands.IHandler#execute(org.eclipse.core.commands. ExecutionEvent)
     */
    @Override
    public Object execute(ExecutionEvent event) throws ExecutionException {
        ISelection selection = HandlerUtil.getCurrentSelection(event);

        if (selection instanceof IStructuredSelection) {

            final ICommandEvaluator evaluator = getCommandEvaluator();

            if (evaluator != null) {
                for (Object element : ((IStructuredSelection) selection).toList()) {
                    if (element instanceof IFile) {
                        IFile file = (IFile) element;

                        handleFile(evaluator, file);
                    }
                }
            }
        }
        return null;
    }

    private void handleFile(final ICommandEvaluator evaluator, IFile file) {
        // Reading parameter values
        // Library/model to export
        String modelName = file.getName().substring(0, file.getName().lastIndexOf("."));// bundle.getString("ModelName");
        String modelPath = file.getParent().getLocation().toOSString();

        // Result settings - path and model name
        String resultPath = getPreferenceStringValue(PreferenceConstants.EXPORT_RESULT_MODEL_PATH, "");

        // If the corresponding preferences are not set, the user is prompted to select location and name
        if (resultPath == null || resultPath == "") {

            ExportSettingsDialog dialog = new ExportSettingsDialog(Display.getCurrent().getActiveShell(),
                    new File(modelPath));
            IPreferenceStore store = MassifSimulinkUIPlugin.getDefault().getPreferenceStore();
            dialog.setPreferenceStore(store);
            dialog.open();

            // If the operation was cancelled, then return
            if (dialog.getReturnCode() == Dialog.CANCEL) {
                return;
            }

            dialog.storeSelectedFileExtension();
            
            resultPath = dialog.getTargetDirectory().toString();
        }
        // TODO is final needed? If the model is moved, finalResultPath stays unchanged
        // why?
        final String finalResultPath = resultPath;

        try {
            exportModel(evaluator, modelName, modelPath, finalResultPath);

            // TODO proper exception handling
        } catch (SimulinkApiException e) {
            Status status = new Status(Status.ERROR, MassifSimulinkUIPlugin.PLUGIN_ID, EXCEPTION_WHILE_EXPORTING, e);
            MassifSimulinkUIPlugin.getDefault().getLog().log(status);
        }

        // try {
        // // TODO call refresh on the savepath
        // file.getParent().refreshLocal(IResource.DEPTH_ONE, null);
        // } catch (CoreException ex) {
        // ex.printStackTrace();
        // }
    }

    private void exportModel(final ICommandEvaluator evaluator, String modelName, String modelPath,
        final String finalResultPath) throws SimulinkApiException {
        // Setup MATLAB
        setup(evaluator, PreferenceConstants.EXPORT_ADDITIONAL_MATLAB_PATH, PreferenceConstants.EXPORT_SCRIPT_NAMES);

        // In the current state of the development
        // the exporter needs to be instantiated
        // This may change later
        final Exporter exporter = new Exporter();

        final SimulinkModel loadedModel = exporter.loadSimulinkModel("file:/" + modelPath
                + File.separator + modelName);

        Job job = new Job("Exporting model " + modelName + "...") {
            @Override
            protected IStatus run(IProgressMonitor monitor) {

                try {
                	MatlabCommandFactory factory = new MatlabCommandFactory(evaluator);
                    exporter.export(loadedModel, factory);
                } catch (SimulinkApiException e) {
                    Status status = new Status(Status.ERROR, MassifSimulinkUIPlugin.PLUGIN_ID, EXCEPTION_WHILE_EXPORTING, e);
                    MassifSimulinkUIPlugin.getDefault().getLog().log(status);
                }

                String newModelName = loadedModel.getSimulinkRef().getFQN();

                // Model name to save the imported Simulink library
                String exportedModelName = finalResultPath + File.separator + newModelName;

                try {
                    IPreferenceStore store = MassifSimulinkUIPlugin.getDefault().getPreferenceStore();
                    String extension = store.getString(PreferenceConstants.EXPORT_RESULT_MODEL_EXTENSION);
                    exporter.saveSimulinkModel(exportedModelName, extension);
                } catch (SimulinkApiException e) {
                    Status status = new Status(Status.ERROR, MassifSimulinkUIPlugin.PLUGIN_ID, EXCEPTION_WHILE_SAVING, e);
                    MassifSimulinkUIPlugin.getDefault().getLog().log(status);
                }

                return Status.OK_STATUS;
            }
        };

        job.setUser(true);
        job.schedule();
    }

}
