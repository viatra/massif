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
package hu.bme.mit.massif.communication.datatype;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used to store information about buses gained from Simulink BusObjects.
 */
public class BusSignal {

    private String signalName;
    private List<BusSignal> signalsInBus;

    public String getSignalName() {
        return signalName;
    }

    public void setSignalName(String signalName) {
        this.signalName = signalName;
    }

    public List<BusSignal> getSignalsInBus() {
        return signalsInBus;
    }

    public BusSignal() {
        signalsInBus = new ArrayList<BusSignal>();
    }
    
    @Override
    public String toString() {
        String signal = "";
        if (signalName != null) {
            signal += signalName;
        }
        if (signalsInBus != null && !signalsInBus.isEmpty()) {
            signal += signalsInBus.toString();
        }
        return signal;
    }

}
