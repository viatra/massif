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
