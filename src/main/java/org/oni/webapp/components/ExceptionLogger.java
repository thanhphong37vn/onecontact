
package org.oni.webapp.components;

import java.lang.Thread.UncaughtExceptionHandler;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * This is a class that performs the log output when an exception occurs.
 * @author DungTV
 */
@Component
@Aspect
@Order(1)
public class ExceptionLogger {

    static {
        // Output to log exceptions that occur in the thread
        Thread.setDefaultUncaughtExceptionHandler(new UncaughtExceptionHandler() {
            
            public void uncaughtException(Thread thread, Throwable t) {

                if (t instanceof Exception) {
                    ExceptionLogger.log((Exception) t, thread.getClass());
                }
            }
        });
    }
    

    /**
     * log an exception.
     * @param ex exception
     * @param clazz Class that has occurred
     */
    public static void log(Exception ex, Class<?> clazz) {        

        Log log = LogFactory.getLog(clazz);
        log.error(ex.getLocalizedMessage(), ex);
    }

}
