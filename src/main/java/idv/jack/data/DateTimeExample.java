package idv.jack.data;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class DateTimeExample {

    public static void main(String args[]) throws Exception {
       String dateTime = "2016-01-27 21:00:00.000";
       SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
       Date date = dateFormat.parse(dateTime);

       Calendar cal = Calendar.getInstance();
       cal.setTime(date);

       int year = cal.get(Calendar.YEAR);
       int month = cal.get(Calendar.MONTH);
       int day = cal.get(Calendar.DAY_OF_MONTH);
       int hour = cal.get(Calendar.HOUR_OF_DAY);

       System.out.println(year);
       System.out.println(month + 1);
       System.out.println(day);
       System.out.println(hour);

    }
}
