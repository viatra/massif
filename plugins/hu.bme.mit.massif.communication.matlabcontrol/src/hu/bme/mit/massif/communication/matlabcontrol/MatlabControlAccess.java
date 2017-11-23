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
package hu.bme.mit.massif.communication.matlabcontrol;

import hu.bme.mit.massif.communication.ICommandAccess;
import matlabcontrol.MatlabInvocationException;
import matlabcontrol.MatlabProxy;

/**
 * @author lunkpeter
 *
 */
public class MatlabControlAccess implements ICommandAccess{

    private final MatlabProxy proxy;
    
    public MatlabControlAccess(MatlabProxy proxy) {
        this.proxy = proxy;
    }
    
    @Override
    public Object[] executeFeval(String name, Object[] inputArgs, int numberOfOutputs) throws MatlabInvocationException {
        return proxy.returningFeval(name, numberOfOutputs, inputArgs);
    }

    @Override
    public Object[] executeEval(String command, int numberOfOutputs) throws MatlabInvocationException {
        return proxy.returningEval(command, numberOfOutputs);
    }

}
