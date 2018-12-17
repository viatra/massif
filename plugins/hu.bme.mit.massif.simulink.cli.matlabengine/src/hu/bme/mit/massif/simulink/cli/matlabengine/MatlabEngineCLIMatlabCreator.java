/*******************************************************************************
 * Copyright (c) 2010-2018, Barnabas, Reischl Barnabás
 * All rights reserved. This program and the accompanying materials 
 * are made available under the terms of the Eclipse Public License v1.0 
 * which accompanies this distribution, and is available at 
 * http://www.eclipse.org/legal/epl-v10.html 
 *
 * Contributors: 
 *     reischlb - initial API and implementation 
 *******************************************************************************/
package hu.bme.mit.massif.simulink.cli.matlabengine;

import hu.bme.mit.massif.communication.AbstractCommandEvaluator;
import hu.bme.mit.massif.communication.ICommandAccess;
import hu.bme.mit.massif.communication.matlabengine.MatlabEngineEvaluator;
import hu.bme.mit.massif.simulink.cli.CLIMatlabCreator;

/**
 * @author reischlb
 *
 */
public class MatlabEngineCLIMatlabCreator extends CLIMatlabCreator {

    @Override
    public AbstractCommandEvaluator<? extends ICommandAccess> getEvaluator() {
        try {
            return new MatlabEngineEvaluator(debugMode);
        } catch (Throwable e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }
}
