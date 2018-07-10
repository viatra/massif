/*******************************************************************************
 * Copyright (c) 2010-2017, IncQuery Labs Ltd., Embraer S.A., Budapest University of Technology and Economics
 * All rights reserved. This program and the accompanying materials 
 * are made available under the terms of the Eclipse Public License v1.0 
 * which accompanies this distribution, and is available at 
 * http://www.eclipse.org/legal/epl-v10.html 
 *
 * Contributors: 
 *     Marton Bur, Abel Hegedus, Akos Horvath - initial API and implementation 
 *     Peter Lunk - Extracted common code, introduced ICommandAccess
 *******************************************************************************/
package hu.bme.mit.massif.communication.commandevaluation;

import br.com.embraer.massif.commandevaluation.client.MatlabClient;
import hu.bme.mit.massif.communication.AbstractCommandEvaluator;

/**
 * Class responsible for the low level operations with MATLAB
 * 
 * (The successor class of BasicOperationsApi utility class)
 */
public class CommandEvaluatorImpl extends AbstractCommandEvaluator<MatlabClientAccess>{

    public CommandEvaluatorImpl(MatlabClient matlabClient) {
        super(new MatlabClientAccess(matlabClient));
    }


}