/*******************************************************************************
 * Copyright (c) 2010-2013, Embraer S.A., Budapest University of Technology and Economics
 * All rights reserved. This program and the accompanying materials 
 * are made available under the terms of the Eclipse Public License v1.0 
 * which accompanies this distribution, and is available at 
 * http://www.eclipse.org/legal/epl-v10.html 
 *
 * Contributors: 
 *     Krisztian Gabor Mayer - initial API and implementation 
 *******************************************************************************/
package hu.bme.mit.massif.simulink.api.dto;

import java.util.Map;
import java.util.Set;

import hu.bme.mit.massif.communication.datatype.Handle;
import hu.bme.mit.massif.simulink.InPort;
import hu.bme.mit.massif.simulink.InPortBlock;
import hu.bme.mit.massif.simulink.OutPort;
import hu.bme.mit.massif.simulink.OutPortBlock;
import hu.bme.mit.massif.simulink.api.Importer;

public class PortDTO extends AbstractImporterDTO{
    
    private Map<Double, InPort> inPorts;
    private Map<Double, OutPort> outPorts;
    private Set<InPortBlock> inPortBlockSet;
    private Set<OutPortBlock> outPortBlockSet;
    
    public PortDTO(Importer importer, Handle portHandle, Map<Double, InPort> inPorts, Map<Double, OutPort> outPorts) {
        super(importer, portHandle);
        this.inPorts = inPorts;
        this.outPorts = outPorts;
    }
    
    public Map<Double, InPort> getInPorts(){
        return inPorts;        
    }

    public Map<Double, OutPort> getOutPorts() {
        return outPorts;
    }

    public Set<InPortBlock> getInPortBlockSet() {
        return inPortBlockSet;
    }

    public void setInPortBlockSet(Set<InPortBlock> inPortBlockSet) {
        this.inPortBlockSet = inPortBlockSet;
    }

    public Set<OutPortBlock> getOutPortBlockSet() {
        return outPortBlockSet;
    }
    
    public void setOutPortBlockSet(Set<OutPortBlock> outPortBlockSet) {
        this.outPortBlockSet = outPortBlockSet;
    }
}
