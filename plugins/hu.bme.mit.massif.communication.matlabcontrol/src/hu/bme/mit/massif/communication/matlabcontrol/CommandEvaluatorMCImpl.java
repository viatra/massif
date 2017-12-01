/*******************************************************************************
 * Copyright (c) 2010, 2017, Embraer S.A., Budapest University of Technology and Economics
 * All rights reserved. This program and the accompanying materials 
 * are made available under the terms of the Eclipse Public License v1.0 
 * which accompanies this distribution, and is available at 
 * http://www.eclipse.org/legal/epl-v10.html 
 *
 * Contributors: 
 *     Abel Hegedus - initial API and implementation 
 *     Peter Lunk - Extracted common code, introduced ICommandAccess
 *******************************************************************************/
package hu.bme.mit.massif.communication.matlabcontrol;

import hu.bme.mit.massif.communication.AbstractCommandEvaluator;
import matlabcontrol.MatlabConnectionException;
import matlabcontrol.MatlabProxy;
import matlabcontrol.MatlabProxyFactory;
import matlabcontrol.MatlabProxyFactoryOptions;
import matlabcontrol.MatlabProxyFactoryOptions.Builder;

/**
 * Class responsible for the low level operations with MATLAB
 * 
 * (The successor class of BasicOperationsApi utility class)
 */
public class CommandEvaluatorMCImpl extends AbstractCommandEvaluator<MatlabControlAccess> {
		
    public CommandEvaluatorMCImpl(String matlabPath) {
        super(new MatlabControlAccess(getProxy(matlabPath)));
    }
    
    public CommandEvaluatorMCImpl(MatlabProxy proxy) {
        super(new MatlabControlAccess(proxy));
    }
    
    private static MatlabProxy getProxy(String matlabPath) {
        Builder optionsBuilder = new MatlabProxyFactoryOptions.Builder();
        if (!"".equals(matlabPath)) {
            optionsBuilder = optionsBuilder.setMatlabLocation(matlabPath);
        }
        MatlabProxyFactoryOptions options = optionsBuilder.build();
        MatlabProxyFactory factory = new MatlabProxyFactory(options);
        MatlabProxy proxy = null;
        try {
            proxy = factory.getProxy();
            
        } catch (MatlabConnectionException e) {
        }
        
        return proxy;
    }

}