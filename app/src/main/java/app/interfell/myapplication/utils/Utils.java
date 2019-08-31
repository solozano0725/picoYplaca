package app.interfell.myapplication.utils;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Utils {

    public static boolean isHourInIntervalAM(String target) {
        return ((target.compareTo(CommonConstants.AM_BEGIN) >= 0)
                && (target.compareTo(CommonConstants.AM_END) <= 0));
    }

    public static boolean isHourInIntervalPM(String target) {
        return ((target.compareTo(CommonConstants.PM_BEGIN) >= 0)
                && (target.compareTo(CommonConstants.PM_END) <= 0));
    }

    public static String setFormatHour(int hour)  {
        if(hour<10){
            return "0"+hour;
        }
        return String.valueOf(hour);
    }

    public static String getDateTimeSystem(){
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Calendar cal = Calendar.getInstance();
        return dateFormat.format(cal);
    }


}
