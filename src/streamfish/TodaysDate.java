/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package streamfish;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 *
 * @author NorC
 */
public class TodaysDate {

    public TodaysDate() {
    }

    public static String getDate() {
        Calendar currentDate = Calendar.getInstance(); //Get the current date
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MMM/dd"); //format it as per your requirement
        String dateNow = formatter.format(currentDate.getTime());

        return dateNow;
    }
}
