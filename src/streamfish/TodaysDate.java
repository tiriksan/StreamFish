package streamfish;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;

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
	
	public static String getADate(int days){
		TimeZone tz = TimeZone.getTimeZone("Europe/Oslo");
        Calendar currentDate = Calendar.getInstance(tz, Locale.ENGLISH); //Get the current date
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MMM/dd"); //format it as per your requirement
        currentDate.add(Calendar.DATE, days);
		String date = formatter.format(currentDate.getTime());

        return date;
	}

    public String getDateDB() {
        TimeZone tz = TimeZone.getTimeZone("Europe/Oslo");
        Calendar currentDate = Calendar.getInstance(tz, Locale.ENGLISH);
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String dateNow = formatter.format(currentDate.getTime());

        return dateNow;
    }
	
	public static String getADateAddMonth(int month){
		TimeZone tz = TimeZone.getTimeZone("Europe/Oslo");
        Calendar currentDate = Calendar.getInstance(tz, Locale.ENGLISH); //Get the current date
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MMM/dd"); //format it as per your requirement
        currentDate.add(Calendar.MONTH, month);
		String date = formatter.format(currentDate.getTime());

        return date;
	}

    public static int getDay() {
        Calendar currentDate = Calendar.getInstance(Locale.ENGLISH);
        SimpleDateFormat formatter = new SimpleDateFormat("EEE");
        String day = formatter.format(currentDate.getTime());
        int today;
        if (day.equals("ma") || (day.equals("mo"))) {
            today = 0;
        } else if (day.equals("ti") || (day.equals("ty") || day.equals("tu"))) {
            today = 1;
        } else if (day.equals("on") || (day.equals("we"))) {
            today = 2;
        } else if (day.equals("to") || (day.equals("th"))) {
            today = 3;
        } else if (day.equals("fr")) {
            today = 4;
        } else if (day.equals("lø") || (day.equals("la") || day.equals("sa"))) {
            today = 5;
        } else if (day.equals("sø") || (day.equals("su"))) {
            today = 6;
        } else {
            return -1;
        }
        return today;
    }

    public static void main(String[] args) {
//        String[] timezones = TimeZone.getAvailableIDs();
//        for (String tz : timezones) {
//            System.out.println(tz);
//        }
        TodaysDate td = new TodaysDate();
        System.out.println(Calendar.DAY_OF_WEEK_IN_MONTH);
        System.out.println(td.getDateDB());
        Calendar cal = Calendar.getInstance();
        System.out.println(cal.getTime());
        System.out.println(cal.get(Calendar.DAY_OF_WEEK_IN_MONTH));
        System.out.println(td.getDay());
    }
}
