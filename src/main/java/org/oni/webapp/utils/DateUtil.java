package org.oni.webapp.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * This is the date and time utility class.
 * @author DungTV
 */
public class DateUtil {

    /** default format */
//    private static final String DEFAULT_FORMAT = "yyyy/MM/dd HH:mm";
    private static final String DEFAULT_FORMAT = "EEE, MMM d, yyyy";
    
    private static final DateFormat FORMAT = createDateFormat();
    /*
     * Constructor
     */
    private DateUtil() {
        // do nothing
    }

    /**
     * generate a common DateFormat.
     * @return common DateFormat
     */
    public static DateFormat createDateFormat() {

        DateFormat format = new SimpleDateFormat(DEFAULT_FORMAT);
        return format;
    }

    /**
     * format the date and time.
     * @param date datetime
     * @return The formatted string
     */
    public static String format(Date date) {

       
        String str = FORMAT.format(date);
        return str;
    }
}
