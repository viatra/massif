package hu.bme.mit.massif.communication.datavisitor;

import java.util.HashMap;
import java.util.Map;

public class SourceBlockHint {

	private Map<String, Object> hints;
	
	public SourceBlockHint() {
		hints = new HashMap<String, Object>();
	}
	
	public void addHint(String key, Object value) {
		hints.put(key, value);
	}
	
	public Object getHint(String key) {
		return hints.get(key);
	}
	
}
