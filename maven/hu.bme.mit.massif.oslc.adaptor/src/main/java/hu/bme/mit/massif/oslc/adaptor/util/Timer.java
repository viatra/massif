/*******************************************************************************
 * Copyright (c) 2010-2013, Embraer S.A., Budapest University of Technology and Economics
 * All rights reserved. This program and the accompanying materials 
 * are made available under the terms of the Eclipse Public License v1.0 
 * which accompanies this distribution, and is available at 
 * http://www.eclipse.org/legal/epl-v10.html 
 *
 * Contributors: 
 *     Robert Doczi, Akos Horvath - initial API and implementation 
 *******************************************************************************/
package hu.bme.mit.massif.oslc.adaptor.util;

/**
 * High resolution timer for measuring performance.
 * 
 * @author Dóczi Róbert
 *
 */
public class Timer {

    private static Resolution defaultResolution = Resolution.MILISECONDS;

    private Resolution        resolution;

    private long              startTime;
    private long              delta;
    private boolean           resetOnToString;
    
    public static void setDefaultResolution(Resolution defaultResolution) {
        Timer.defaultResolution = defaultResolution;
    }
    
    /**
     * Creates a new timer with the default resolution (Miliseconds).
     * @return The timer instance.
     */
    public static Timer create() {
        Timer t = new Timer();
        return t;
    }

    /**
     * Creates a new timer with the specified resolution.
     * @param res The resolution of the timer.
     * @return The timer instance.
     */
    public static Timer create(Resolution res) {
        Timer t = new Timer(res, true);
        return t;
    }

    /**
     * Creates a new timer with the specified resolution.
     * @param res The resolution of the timer.
     * @param resetOnToString Whether to reset the timer if toString is called on it.
     * @returnThe timer instance.
     */
    public static Timer create(Resolution res, boolean resetOnToString) {
        Timer t = new Timer(res, resetOnToString);
        return t;
    }
    
    /**
     * Creates a new timer with the default resolution (Miliseconds) and starts it.
     * @return The timer instance.
     */
    public static Timer startNew() {
        Timer t = new Timer();
        t.start();
        return t;
    }

    /**
     * Creates a new timer with the specified resolution and starts it.
     * @param res The resolution of the timer.
     * @return The timer instance.
     */
    public static Timer startNew(Resolution res) {
        Timer t = new Timer(res, true);
        t.start();
        return t;
    }

    /**
     * Creates a new timer with the specified resolution and starts it.
     * @param res The resolution of the timer.
     * @param resetOnToString Whether to reset the timer if toString is called on it.
     * @returnThe timer instance.
     */
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
    }

    /**
     * Starts the timer.
     */
    public void start() {
        if (startTime != -1)
            reset();
        startTime = System.nanoTime();
    }

    /**
     * Stops the timer.
     */
    public void stop() {
        if (startTime == -1)
            return;
        delta = System.nanoTime() - startTime;
        startTime = -1;
    }

    /**
     * Resets the timer.
     */
    public void reset() {
        delta = 0;
        startTime = -1;
    }

    /**
     * Gets the passed time since the last start of the timer.
     * @return The passed time.
     */
    public double get() {
        double ret;
        if(startTime == -1) // if the timer is stopped
            ret = delta;
        else // if the timer is still running
            ret = System.nanoTime() - startTime;
        return ret / resolution.denum;
    }

    /**
     * Gets the passed time since the last start of the timer and resets it.
     * @return The passed time.
     */
    public double getAndReset() {
        double ret = get();
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
    
    /**
     * This enum represents the supported timer resolutions.
     * @author Dóczi Róbert
     *
     */
    public static enum Resolution {
        SECONDS("s", 1e9), MILISECONDS("ms", 1e6), MICROSECONDS("µs", 1e3), NANOSECONDS("ns", 1);

        private String sh;
        private double denum;

        Resolution(String sh, double denum) {
            this.sh = sh;
            this.denum = denum;
        }

        @Override
        public String toString() {
            return sh;
        }
    }
}
