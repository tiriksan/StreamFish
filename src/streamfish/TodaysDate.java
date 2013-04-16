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
	
	public String getDateDB() {
		TimeZone tz = TimeZone.getTimeZone("Europe/Oslo");
		Calendar currentDate = Calendar.getInstance(tz, Locale.ENGLISH);
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		String dateNow = formatter.format(currentDate.getTime());
		
		return dateNow;
	}
	
	public int getDay() {
		Calendar currentDate = Calendar.getInstance(Locale.ENGLISH);
		SimpleDateFormat formatter = new SimpleDateFormat("EEE");
		String day = formatter.format(currentDate.getTime());
		if (day.equals("ma")) {
			int today = Integer.parseInt(day);
		} else if (day.equals("ti")) {
			int today = Integer.parseInt(day);
		} else if (day.equals("on")) {
			int today = Integer.parseInt(day);
		} else if (day.equals("to")) {
			int today = Integer.parseInt(day);
		} else if (day.equals("fr")) {
			int today = Integer.parseInt(day);
		} else if (day.equals("lø")) {
			int today = Integer.parseInt(day);
		} else if (day.equals("sø")) {
			int today = Integer.parseInt(day);
		}
		return -1;
		
	}
	
	public static void main(String[] args) {
//        String[] timezones = TimeZone.getAvailableIDs();
//        for (String tz : timezones) {
//            System.out.println(tz);
//        }
		TodaysDate td = new TodaysDate();
		System.out.println(td.getDateDB());
		Calendar cal = Calendar.getInstance();
		System.out.println(cal.getTime());
		System.out.println(cal.get(Calendar.DAY_OF_WEEK_IN_MONTH));
	}
}
