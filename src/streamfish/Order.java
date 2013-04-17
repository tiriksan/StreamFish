/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package streamfish;

/**
 *
 * @author Kristian
 */
public class Order {

	private int orderId;
	private int menuId;
	private int customerId;
	private int emplId;
	private int subId;
	private int nrPersons;
	private String deliveryDate;
	private String deliveryTime;
	private CustomerAddress address;
	private String address1;

	//Order med id,dato og CustomerAddress adresse
	public Order(int orderId, int menuId, int customerID, int emplId, int nrPersons, String deliveryDate, String deliveryTime, CustomerAddress address) {
		this.orderId = orderId;
		this.menuId = menuId;
		this.customerId = customerID;
		this.emplId = emplId;
		this.nrPersons = nrPersons;
		this.deliveryDate = deliveryDate;
		this.address = address;
		this.deliveryTime = deliveryTime;
	}

	//Order med id, dato og String adresse
	public Order(int orderId, int menuId, int customerID, int emplId, int nrPersons, String deliveryDate, String deliveryTime, String address) {
		this.orderId = orderId;
		this.menuId = menuId;
		this.customerId = customerID;
		this.emplId = emplId;
		this.nrPersons = nrPersons;
		this.deliveryDate = deliveryDate;
		this.address1 = address;
		this.deliveryTime = deliveryTime;

	}

	//Order uten id, med dato og subscription
	public Order(int menuId, int customerID, int emplId, int nrPersons, String deliveryDate, String deliveryTime, CustomerAddress address, int subId) {
		this.menuId = menuId;
		this.customerId = customerID;
		this.emplId = emplId;
		this.nrPersons = nrPersons;
		this.deliveryDate = deliveryDate;
		this.address = address;
		this.deliveryTime = deliveryTime;
		this.subId = subId;
	}

	//Order med id, dato og subId
	public Order(int orderId, int menuId, int customerID, int emplId, int nrPersons, String deliveryDate, String deliveryTime, CustomerAddress address, int subId) {
		this.orderId = orderId;
		this.menuId = menuId;
		this.customerId = customerID;
		this.emplId = emplId;
		this.nrPersons = nrPersons;
		this.deliveryDate = deliveryDate;
		this.address = address;
		this.deliveryTime = deliveryTime;
		this.subId = subId;
	}

	//Order uten id og sub, med dato og CustomerAddress
	public Order(int menuId, int customerID, int emplId, int nrPersons, String deliveryDate, String deliveryTime, CustomerAddress address) {
		this.menuId = menuId;
		this.customerId = customerID;
		this.emplId = emplId;
		this.nrPersons = nrPersons;
		this.deliveryDate = deliveryDate;
		this.deliveryTime = deliveryTime;
		this.address = address;
	}

	//Order som brukes når man skal registrere en subscription(for å få info om customer, menu og address
	public Order(int menuId, int customerID, int emplId, int nrPersons, String deliveryTime , CustomerAddress address) {
		this.menuId = menuId;
		this.customerId = customerID;
		this.emplId = emplId;
		this.nrPersons = nrPersons;
		this.deliveryTime = deliveryTime;
		this.address = address;
	}

	public int getOrderId() {
		return orderId;
	}

	public int getMenuId() {
		return menuId;
	}

	public int getCustomerId() {
		return customerId;
	}

	public int getEmplId() {
		return emplId;
	}
        
        public String getEmpName(GUI gui){
            Employee [] employee = gui.getEmployee();
            for (Employee emp : employee) {
                if(emp.getEmplID() == getEmplId()){
                    return emp.getUsername();
                }
            }
            return null;
        }
        
        public String getMenuName(GUI gui){
            Menu [] menu = gui.getMenus();
            for(Menu mnu : menu){
                if(mnu.getMenuId() == getMenuId()){
                    return mnu.getMenuName();
                }
            }
            return null;
        }

	public int getNrPersons() {
		return nrPersons;
	}

	public String getDeliveryDate() {
		return deliveryDate;
	}

	public int getSubId() {
		return subId;
	}

	public String getAddress1() {
		return address1;
	}

	public String getDeliveryTime() {
		return deliveryTime;
	}

	public CustomerAddress getAddress() {
		return address;
	}

	@Override
	public String toString() {
		String res = "";
		res += "ID: " + orderId + " | Delivery date and time: " + deliveryDate + ", " + deliveryTime + " | Menu: " + menuId + ", Empl-ID:" + emplId;
		return res;
	}
}