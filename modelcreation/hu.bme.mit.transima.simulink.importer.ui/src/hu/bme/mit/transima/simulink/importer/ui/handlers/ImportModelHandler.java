package hu.bme.mit.transima.simulink.importer.ui.handlers;

import hu.bme.mit.transima.simulink.api.Importer;
import hu.bme.mit.transima.simulink.api.ModelObject;
import hu.bme.mit.transima.simulink.api.exception.SimulinkApiException;
import hu.bme.mit.transima.simulink.api.util.ImportMode;
import hu.bme.mit.transima.simulink.communication.ICommandEvaluator;
import hu.bme.mit.transima.simulink.communication.command.MatlabCommand;
import hu.bme.mit.transima.simulink.communication.command.MatlabCommandFactory;
import hu.bme.mit.transima.simulink.importer.ui.Activator;
import hu.bme.mit.transima.simulink.importer.ui.dialogs.ImportSettingsDialog;
import hu.bme.mit.transima.simulink.importer.ui.preferences.PreferenceConstants;

import java.io.File;

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

        boolean usingFAMFilter = false;
        boolean usingLibraryFilter = false;
        
        // If the corresponding preferences are not set, the user is prompted to select location and name
        if (resultPath == null || resultPath.equals("")) {

            ImportSettingsDialog dialog = new ImportSettingsDialog(Display.getCurrent().getActiveShell(), modelName,
                    new File(modelPath));
            IPreferenceStore store = Activator.getDefault().getPreferenceStore();
            dialog.setPreferenceStore(store);
            dialog.open();

            // If the operation was cancelled, then return
            if (dialog.getReturnCode() == Dialog.CANCEL) {
                return;
            }
            resultPath = dialog.getTargetDirectory().toString();
            newModelName = dialog.getImportedModelName();
            usingFAMFilter = dialog.isUsingFAMLeafFilter();
            usingLibraryFilter = dialog.isUsingLibraryFilter();
        }
        
        importModel(modelName, modelPath, newModelName, resultPath, settings,usingFAMFilter,usingLibraryFilter);

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
        final String resultPath, final ImportSettings settings, boolean usingFAMFilter, boolean usingLibraryFilter) {
        MatlabCommandFactory factory = new MatlabCommandFactory(settings.commandEvaluator);
    	MatlabCommand addpathModel = factory.addPath();
        addpathModel.addParam(modelPath);
        addpathModel.execute();

        // Setup MATLAB
        setup(settings.commandEvaluator, PreferenceConstants.IMPORT_ADDITIONAL_MATLAB_PATH,
            PreferenceConstants.IMPORT_STARTUP_SCRIPTS);

        // Get the model by its name
        final ModelObject testModel = new ModelObject(modelName, settings.commandEvaluator);
        // Set model path (without model name)
        testModel.setLoadPath(modelPath);

        // Add specified filters
        // We only have specific filters
        if(usingFAMFilter){
            testModel.registerApplicableFilters("famfilter");
        }
        if(usingLibraryFilter){
            testModel.registerApplicableFilters("library");
        }
        Job job = new Job("Importing model " + modelName + "...") {
            @Override
            protected IStatus run(IProgressMonitor monitor) {

                Importer traverser = new Importer(testModel);
                traverser.setDefaultSavePath(resultPath);

                try {
                    saveModel = true;
                    traverser.traverseAndCreateEMFModel(ImportMode.valueOf(settings.traverseMode));
                } catch (Exception e) {
                    Status status = new Status(Status.ERROR, Activator.PLUGIN_ID, EXCEPTION_WHILE_IMPORTING, e);
                    Activator.getDefault().getLog().log(status);
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
                            Status status = new Status(Status.ERROR, Activator.PLUGIN_ID, EXCEPTION_WHILE_SAVING_MODEL,
                                    e);
                            Activator.getDefault().getLog().log(status);
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
