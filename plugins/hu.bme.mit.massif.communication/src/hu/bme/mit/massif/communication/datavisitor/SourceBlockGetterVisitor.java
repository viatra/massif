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
package hu.bme.mit.massif.communication.datavisitor;

import java.util.List;

import hu.bme.mit.massif.communication.datatype.CellMatlabData;
import hu.bme.mit.massif.communication.datatype.Handle;
import hu.bme.mit.massif.communication.datatype.IVisitableMatlabData;
import hu.bme.mit.massif.communication.datatype.Logical;
import hu.bme.mit.massif.communication.datatype.MatlabString;
import hu.bme.mit.massif.communication.datatype.StructMatlabData;

public class SourceBlockGetterVisitor implements IMatlabDataVisitor {

    private String sourceBlockFQN;

    private SourceBlockHint hint;
    
    public void setSourceBlockHint(SourceBlockHint hint) {
    	this.hint = hint;
    }
    
    public String getSourceBlockFQN() {
        return sourceBlockFQN;
    }

    @Override
    public void visit(CellMatlabData compositeData) {
        List<IVisitableMatlabData> dataList = compositeData.getDatas();
        int startIndex = 0;
        boolean notFloating = true;
        if(hint != null) {
        	Object hintObject = hint.getHint(SourceBlockHintKeys.IS_FLOATING_SCOPE);
        	if(hintObject != null) {
				notFloating = !((Boolean) hintObject).booleanValue();
        	}
        }
		for (int i = startIndex; i < dataList.size(); i++) {
			IVisitableMatlabData fqn = dataList.get(i);
			boolean isDesiredScopeType = fqn.toString().contains("Floating") ^ notFloating;
			if (!fqn.toString().contains("Commonly Used Blocks") && isDesiredScopeType) {
                sourceBlockFQN = MatlabString.getMatlabStringData(fqn);
                break;
            }
		}
    }

    @Override
    public void visit(Handle handle) {
        // TODO Get name for handle
        throw new UnsupportedOperationException("Not (yet) implemented!");
    }

    @Override
    public void visit(MatlabString matlabString) {
        // It is a single block
        // If it is not from the commonly used blocks lib, set it as source
        if (!matlabString.getData().contains("Commonly Used Blocks")) {
            sourceBlockFQN = matlabString.getData();
        }
    }

    @Override
    public void visit(StructMatlabData structMatlabData) {
        // TODO Unsupported operation?
        throw new UnsupportedOperationException("Not implemented!");
    }
    
	@Override
	public void visit(Logical logical) {
        // TODO Unsupported operation?
        throw new UnsupportedOperationException("Not implemented!");
	}
    
}
