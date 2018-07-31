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

import hu.bme.mit.massif.communication.datavisitor.IMatlabDataVisitor;

import java.util.HashMap;
import java.util.Map;
import java.util.StringJoiner;
import java.util.Map.Entry;

public class StructMatlabData implements IVisitableMatlabData {
    private Map<String, IVisitableMatlabData> datas;

    public StructMatlabData() {
        datas = new HashMap<String, IVisitableMatlabData>();
    }

    public int size() {
        return datas.size();
    }

    public Map<String, IVisitableMatlabData> getDatas() {
        return datas;
    }

    public void addData(String fieldName, IVisitableMatlabData data) {
        datas.put(fieldName, data);
    }

    public IVisitableMatlabData getData(String fieldName) {
        return datas.get(fieldName);
    }

    public void setDatas(Map<String, IVisitableMatlabData> datas) {
        this.datas = datas;
    }

    public static StructMatlabData asStructMatlabData(IVisitableMatlabData data) {
        if (data instanceof CellMatlabData && ((CellMatlabData) data).size() == 0) {
            return new StructMatlabData();
        }
        return (StructMatlabData) data;
    }

    public static Map<String, IVisitableMatlabData> getStructMatlabDataData(IVisitableMatlabData data) {
        return asStructMatlabData(data).datas;
    }

    @Override
    public void acceptDataVisitor(IMatlabDataVisitor visitor) {
        visitor.visit(this);
    }
    
    @Override
    public String toString() {
    	StringJoiner joiner = new StringJoiner(",", "{", "}");
		for (Entry<String, IVisitableMatlabData> structEntry : getDatas().entrySet()) {
			joiner.add(structEntry.getKey().toString() + ":" + (structEntry.getValue() == null ? "" : structEntry.getValue().toString()));
		}
    	return joiner.toString();
    }

}
