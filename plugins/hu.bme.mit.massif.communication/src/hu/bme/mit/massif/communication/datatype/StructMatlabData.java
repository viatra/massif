package hu.bme.mit.massif.communication.datatype;

import hu.bme.mit.massif.communication.datavisitor.IMatlabDataVisitor;

import java.util.HashMap;
import java.util.Map;

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

}
