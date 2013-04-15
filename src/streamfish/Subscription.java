/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package streamfish;

/**
 *
 * @author NorC
 */
public class Subscription {
    private int subscription_id;
    private int duration;
    private String from_date;
    private String to_date;
    private String days;
    private char status;

    public Subscription(int subscription_id, int duration, String from_date, String to_date, String days, char status) {
        this.subscription_id = subscription_id;
        this.duration = duration;
        this.from_date = from_date;
        this.to_date = to_date;
        this.days = days;
        this.status = status;
    }

    public Subscription(int duration, String from_date, String to_date, String days, char status) {
        this.duration = duration;
        this.from_date = from_date;
        this.to_date = to_date;
        this.days = days;
        this.status = status;
    }

    public int getSubscription_id() {
        return subscription_id;
    }

    public int getDuration() {
        return duration;
    }

    public String getFrom_date() {
        return from_date;
    }

    public String getTo_date() {
        return to_date;
    }

    public char getStatus() {
        return status;
    }

    public String getDays() {
        return days;
    }
    
    public String toString(){
        String text = "subscription_id:" + subscription_id + "\nduration " + duration + "\nfrom_date " + from_date + "\nto_date " + to_date + "\nstatus " + status;
        return text;
    }
}
