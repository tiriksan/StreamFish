package streamfish;

/**
 * @author HJ
 */
class Orderinfo {
    private String customerName;
    private String address;
    private String phone;
    private String menu;
    private int numberOfPersons;
    private int price;
    private String salesperson;
    
    public Orderinfo(String cn, String ad, String ph, String me, int nr, int pr, String sa) {
        customerName = cn;
        address = ad;
        phone = ph;
        menu = me;
        numberOfPersons = nr;
        price = pr;
        salesperson = sa;
    }
    
    public String getCustomerName() {
        return customerName;
    }
    
    public String getAddress() {
        return address;
    }
    
    public String getPhone() {
        return phone;
    }
    
    public String getMenu() {
        return menu;
    }
    
    public int getNumberOfPersons() {
        return numberOfPersons;
    }
    
    public int getPrice() {
        return price;
    }
    
    public String getSalesperson() {
        return salesperson;
    }
}
