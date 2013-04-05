/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package streamfish;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author HJ
 */
public class StreamFish {

	/**
	 * @param args the command line arguments
	 */
	private String databasedriver;
	private Connection con;

	public StreamFish() {
		try {
			databasedriver = "org.apache.derby.jdbc.ClientDriver";
			Class.forName(databasedriver);  // laster inn driverklassen
			String databasenavn = "jdbc:derby://db.stud.aitel.hist.no/streamfish;user=sfdb;password=XEnhdPy8";
			con = DriverManager.getConnection(databasenavn);
		} catch (SQLException ex) {
			Logger.getLogger(StreamFish.class.getName()).log(Level.SEVERE, null, ex);
		} catch (ClassNotFoundException ex) {
			Logger.getLogger(StreamFish.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
	
	public Menu[] getMenus(){
		
		Statement stm;
		ResultSet res;
		Menu[] menus;
		int teller = 0;
		
		try {
			stm = con.createStatement();
			res = stm.executeQuery("select count(*) antall from menu");
			res.next();
			int ant = res.getInt("antall");
			menus = new Menu[ant];
			Opprydder.lukkResSet(res);
			
			res = stm.executeQuery("select * from menu");
			
			while(res.next()){
				int menuId = res.getInt("menu_id");
				String menuName = res.getString("menu_name");
				int price = res.getInt("price");
				String description = res.getString("description");
				boolean busi = false;
				menus[teller] = new Menu(menuId, menuName, price, description);
				teller++;
			}
			
			return menus;
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return null;
	}
	
	public Customer[] getCustomers(String s){
		Statement stm;
		ResultSet res;
		Customer[] customers;
		int teller = 0;
		
		try {
			stm = con.createStatement();
			res = stm.executeQuery("select count(*) antall from customer where customer_name like '" + s.toLowerCase() + "%' or customer_name like '" + s.toUpperCase() + "%'");
			res.next();
			int ant = res.getInt("antall");
			customers = new Customer[ant];
			Opprydder.lukkResSet(res);
			
			res = stm.executeQuery("select * from customer where customer_name like '" + s.toLowerCase() + "%' or customer_name like '" + s.toUpperCase() + "%'");
			
			while(res.next()){
				int customerId = res.getInt("customer_id");
				String customerName = res.getString("customer_name");
				int phone = res.getInt("phone");
				int business = Integer.parseInt(res.getString("business"));
				boolean busi = false;
				if(business == 1){
					busi = true;
				}
				customers[teller] = new Customer(customerId, customerName, phone, busi);
				teller++;
			}
			return customers;
		} catch (SQLException ex) {
			System.err.println(ex);
			ex.printStackTrace();
		}
		
		
		return null;
	}
	
	public int addOrder(Order order){
		Statement stm;
		try {
			stm = con.createStatement();
			int succ = stm.executeUpdate("insert into orders (DELIVERY_DATE, ADDRESS, NR_PERSONS, EMPL_ID, MENU_ID,CUSTOMER_ID) values('" + order.getDeliveryDate() + "' , '" + order.getAddress() + "', " + order.getNrPersons() + ", " + order.getEmplId() + ", " + order.getMenuId() + " , " + order.getCustomerId() +  ")");
			Opprydder.lukkSetning(stm);
			return succ;

		} catch (SQLException ex) {
			System.err.println(ex);
		}


		return -1;
	}
	
	public int addCustomer(Customer customer) {
		Statement stm;
		int isbusiness = 0;
		if (customer.isBusiness()) {
			isbusiness = 1;
		}
		
		try {
			stm = con.createStatement();
			int succ = stm.executeUpdate("insert into customer (CUSTOMER_NAME, PHONE, BUSINESS) values('" + customer.getCustomerName() + "' , '" + customer.getPhoneNumber() + "', '" + isbusiness + "')");
			Opprydder.lukkSetning(stm);
			return succ;

		} catch (SQLException ex) {
			System.err.println(ex);
		}


		return -1;
	}

	public void close() {
		try {
			con.close();

		} catch (SQLException ex) {
			Logger.getLogger(StreamFish.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
}
