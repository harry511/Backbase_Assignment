package com.backbase.utilities;

import java.text.SimpleDateFormat;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

public class TimeValidator {
	
	/** 
	 * Verifies either given date is in 'yyyy-MM-dd'T'HH:mm:ss.ms'Z'' format or not
	 * @param timeStamp
	 * @return boolean
	 */
	public static boolean isValidDate(String timeStamp) {
        boolean valid = true;
        try {
        	SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.ms'Z'");
        	formatter.parse(timeStamp);
        } catch (Exception e) {
            valid = false;
        }
        return valid;
    }

}
