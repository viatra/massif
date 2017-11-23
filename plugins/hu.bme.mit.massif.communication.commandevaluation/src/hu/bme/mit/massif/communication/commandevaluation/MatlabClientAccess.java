/*******************************************************************************
 * Copyright (c) 2010-2017, LunkP, Peter Lunk
 * All rights reserved. This program and the accompanying materials 
 * are made available under the terms of the Eclipse Public License v1.0 
 * which accompanies this distribution, and is available at 
 * http://www.eclipse.org/legal/epl-v10.html 
 *
 * Contributors: 
 *     lunkpeter - initial API and implementation 
 *******************************************************************************/
package hu.bme.mit.massif.communication.commandevaluation;

import br.com.embraer.massif.commandevaluation.client.MatlabClient;
import br.com.embraer.massif.commandevaluation.exception.MatlabOutputException;
import br.com.embraer.massif.commandevaluation.exception.MatlabRMIException;
import hu.bme.mit.massif.communication.ICommandAccess;

/**
 * @author lunkpeter
 *
 */
public class MatlabClientAccess implements ICommandAccess{

    private final MatlabClient matlabClient;
    
    public MatlabClientAccess(MatlabClient matlabClient) {
        this.matlabClient = matlabClient;
    }
    
    @Override
    public Object[] executeFeval(String name, Object[] inputArgs, int numberOfOutputs) throws MatlabOutputException, MatlabRMIException {
        return matlabClient.executeFeval(name, inputArgs, numberOfOutputs);
    }

    @Override
    public Object[] executeEval(String command, int numberOfOutputs) throws MatlabOutputException, MatlabRMIException {
        return matlabClient.executeEval(command, numberOfOutputs);
    }

}
