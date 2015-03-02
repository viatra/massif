/*******************************************************************************
 * Copyright (c) 2010-2015, Embraer S.A., Budapest University of Technology and Economics
 * All rights reserved. This program and the accompanying materials 
 * are made available under the terms of the Eclipse Public License v1.0 
 * which accompanies this distribution, and is available at 
 * http://www.eclipse.org/legal/epl-v10.html 
 *
 * Contributors: 
 *     Abel Hegedus - initial API and implementation 
 *******************************************************************************/
package hu.bme.mit.massif.simulink.presentation.handlers;

import hu.bme.mit.massif.simulink.SimulinkElement;
import hu.bme.mit.massif.simulink.api.util.SimulinkUtil;
import hu.bme.mit.massif.simulink.presentation.SimulinkEditorPlugin;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.handlers.HandlerUtil;

/**
 * @author Abel Hegedus
 *
 */
public class ResetQualifierHandler extends AbstractHandler {

    @Override
    public Object execute(ExecutionEvent event) throws ExecutionException {
        ISelection selection = HandlerUtil.getCurrentSelection(event);

        if (selection instanceof IStructuredSelection) {
            for (Object element : ((IStructuredSelection) selection).toList()) {
                if (element instanceof SimulinkElement) {
                    SimulinkElement slElem = (SimulinkElement) element;
                    String qualifier = slElem.getSimulinkRef().getQualifier();
                    
                    boolean resetRequested = MessageDialog.openConfirm(HandlerUtil.getActiveShell(event), "Reset qualifier on chilren",
                            "Do you want to reset the qualifier on children elements of " + slElem.getName() +
                            " based on " + qualifier + "?\nResetting will be performed on all transitively contained elements.");
                    if(resetRequested) {
                        try {
                            SimulinkUtil.changeRootQualifier(slElem, qualifier);
                        } catch (IllegalArgumentException e) {
                            String errorMsg = "Could not reset qualifier on children of " + slElem.getSimulinkRef().getFQN();
                            MessageDialog.openError(HandlerUtil.getActiveShell(event), "Reset qualifier on children",
                                    errorMsg + ":\n" + e.getLocalizedMessage() + "\nSee error log for details.");
                            Status status = new Status(Status.ERROR, SimulinkEditorPlugin.getPlugin().getSymbolicName(), errorMsg, e);
                            SimulinkEditorPlugin.getPlugin().getLog().log(status);
                        }
                    }
                }
            }
        }
        return null;
    }

}
