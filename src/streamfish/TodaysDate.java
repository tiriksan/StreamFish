package streamfish;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;
import java.util.Locale;

/**
 *
 * @author NorC
 */
public class TodaysDate {

    public TodaysDate() {
    }

    public static String getDate() {
        TimeZone tz = TimeZone.getTimeZone("Europe/Oslo");
        Calendar currentDate = Calendar.getInstance(tz, Locale.ENGLISH); //Get the current date
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MMM/dd"); //format it as per your requirement
        String dateNow = formatter.format(currentDate.getTime());

        return dateNow;
    }
    
    public String getDateDB() {
        TimeZone tz = TimeZone.getTimeZone("Europe/Oslo");
        Calendar currentDate = Calendar.getInstance(tz, Locale.ENGLISH);
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String dateNow = formatter.format(currentDate.getTime());
        
        return dateNow;
    }
    
    public static void main(String[] args) {
//        String[] timezones = TimeZone.getAvailableIDs();
//        for (String tz : timezones) {
//            System.out.println(tz);
//        }
        TodaysDate td = new TodaysDate();
        System.out.println(td.getDateDB());
    }
}
