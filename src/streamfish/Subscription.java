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
    
    public String getDayofWeek(){
        String dayofWeek = "";
        for(int i = 0; i < 7; i++){
            if(days.charAt(i) == '1'){
                switch(i){
                    case 0:
                    dayofWeek += "Monday ";   
                    case 1:
                    dayofWeek += "Tuesday ";   
                    case 2:
                    dayofWeek += "Wednesday ";   
                    case 3:
                    dayofWeek += "Thursday ";   
                    case 4:
                    dayofWeek += "Friday ";   
                    case 5:
                    dayofWeek += "Saturday ";   
                    case 6:
                    dayofWeek += "Sunday ";   
                    break;
                }
            }
        }
        return dayofWeek;
    }
    
    public String getMenuName(Order order, GUI gui){
        if(order != null) {
        String menuName = order.getMenuName(gui);
        return menuName;
        }
        return null;
    }
    
    public String getCustomerName(Order order, GUI gui){
        if(order != null){
        String customerName = order.getCustomerName(gui);
        return customerName;
        }
        return null;
    }
    
    public String toString(){
        String text = "subscription_id:" + subscription_id + "\nduration " + duration + "\nfrom_date " + from_date + "\nto_date " + to_date + "\nstatus " + status;
        return text;
    }
}
