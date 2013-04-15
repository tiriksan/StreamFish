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
	
	public Order(int menuId, int customerID, int emplId, int nrPersons, String deliveryDate, String deliveryTime, String address, int subId) {
		this.menuId = menuId;
		this.customerId = customerID;
		this.emplId = emplId;
		this.nrPersons = nrPersons;
		this.deliveryDate = deliveryDate;
		this.address1 = address;
		this.deliveryTime = deliveryTime;
		this.subId = subId;
	}
	
	public Order(int orderId, int menuId, int customerID, int emplId, int nrPersons, String deliveryDate, String deliveryTime, String address, int subId) {
		this.orderId = orderId;
		this.menuId = menuId;
		this.customerId = customerID;
		this.emplId = emplId;
		this.nrPersons = nrPersons;
		this.deliveryDate = deliveryDate;
		this.address1 = address;
		this.deliveryTime = deliveryTime;
		this.subId = subId;
	}

	public Order(int menuId, int customerID, int emplId, int nrPersons, String deliveryDate, String deliveryTime, CustomerAddress address) {
		this.menuId = menuId;
		this.customerId = customerID;
		this.emplId = emplId;
		this.nrPersons = nrPersons;
		this.deliveryDate = deliveryDate;
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