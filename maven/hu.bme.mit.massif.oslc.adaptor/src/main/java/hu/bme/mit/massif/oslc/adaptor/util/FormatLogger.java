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

import java.io.IOException;

import org.apache.log4j.FileAppender;
import org.apache.log4j.Layout;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;

/**
 * Optimized logger interface allowing the use of string formatter syntax. This is
 * a better solution than passing the already formatted string to the logger, since 
 * the toString()-s will only be evaluated if it is necessary (specified log level is enabled).
 * 
 * @author Dóczi Róbert
 *
 */
public class FormatLogger {

    public static FormatLogger getLogger(Class<?> clazz) {
        return new FormatLogger(Logger.getLogger(clazz));
    }

    public static FormatLogger getLogger(String className) {
        return new FormatLogger(Logger.getLogger(className));
    }

    private Logger logger;

    public FormatLogger(Logger logger) {
        this.logger = logger;
        
        Layout layout = new PatternLayout("%d{ISO8601}:\t%-5p [%t]: %m%n");
        
        try {
            FileAppender appender = new FileAppender(layout, AdaptorProperties.logLocation);
            
            logger.addAppender(appender);
            logger.setLevel(AdaptorProperties.logLevel);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void info(String formatString, Object... args) {
        log(Level.INFO, formatString, args);
    }

    public void debug(String formatString, Object... args) {
        log(Level.DEBUG, formatString, args);
    }

    public void error(String formatString, Object... args) {
        log(Level.ERROR, formatString, args);
    }

    public void fatal(String formatString, Object... args) {
        log(Level.FATAL, formatString, args);
    }

    public void warn(String formatString, Object... args) {
        log(Level.WARN, formatString, args);
    }

    public void info(String formatString, Throwable t, Object... args) {
        log(Level.INFO, formatString, args, t);
    }

    public void debug(String formatString, Throwable t, Object... args) {
        log(Level.DEBUG, formatString, args, t);
    }

    public void error(String formatString, Throwable t, Object... args) {
        log(Level.ERROR, formatString, args, t);
    }

    public void fatal(String formatString, Throwable t, Object... args) {
        log(Level.FATAL, formatString, args, t);
    }

    public void warn(String formatString, Throwable t, Object... args) {
        log(Level.WARN, formatString, args, t);
    }

    private void log(Level level, String formatString, Object[] args) {
        if (logger.isEnabledFor(level)) {
            logger.log(level, String.format(formatString, args));
        }
    }

    private void log(Level level, String formatString, Object[] args, Throwable t) {
        if (logger.isEnabledFor(level)) {
            logger.log(level, String.format(formatString, args), t);
        }
    }
}
