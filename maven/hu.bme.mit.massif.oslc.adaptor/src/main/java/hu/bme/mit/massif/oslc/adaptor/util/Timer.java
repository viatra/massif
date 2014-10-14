package hu.bme.mit.massif.oslc.adaptor.util;

public class Timer {

    private static Resolution defaultResolution = Resolution.MILISECONDS;

    private Resolution        resolution;
    private double            denum;

    private long              startTime;
    private long              delta;
    private boolean           resetOnToString;
    
    public static void setDefaultResolution(Resolution defaultResolution) {
        Timer.defaultResolution = defaultResolution;
    }
    
    public static Timer startNew() {
        Timer t = new Timer();
        t.start();
        return t;
    }

    public static Timer startNew(Resolution res) {
        Timer t = new Timer(res, true);
        t.start();
        return t;
    }

    public static Timer startNew(Resolution res, boolean resetOnToString) {
        Timer t = new Timer(res, resetOnToString);
        t.start();
        return t;
    }

    private Timer() {
        this(defaultResolution, true);
    }

    private Timer(Resolution res, boolean resetOnToString) {
        this.resetOnToString = resetOnToString;
        startTime = -1;

        this.resolution = res;

        switch (res) {
        case SECONDS:
            denum = 10e9;
            break;
        case MILISECONDS:
            denum = 10e6;
            break;
        case NANOSECONDS:
            denum = 1;
            break;
        }
    }

    public void start() {
        if (startTime != -1)
            reset();
        startTime = System.nanoTime();
    }

    public void stop() {
        if (startTime == -1)
            return;
        delta = System.nanoTime() - startTime;
        startTime = -1;
    }

    public void reset() {
        delta = 0;
        startTime = -1;
    }

    public double get() {
        return delta / denum;
    }

    public double getAndReset() {
        double ret = delta / denum;
        reset();
        return ret;
    }

    @Override
    public String toString() {

        double time = get();
        if (resetOnToString) {
            reset();
        }
        return time + " " + resolution;
    }
    
    public static enum Resolution {
        SECONDS("s"), MILISECONDS("ms"), NANOSECONDS("ns");

        private String sh;

        Resolution(String sh) {
            this.sh = sh;
        }

        @Override
        public String toString() {
            return sh;
        }
    }
}
