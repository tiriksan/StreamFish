package streamfish;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Kristian
 */
public class GUI extends JFrame implements WindowListener {

	private ArrayList<JPanel> panels = new ArrayList<JPanel>();
	private StreamFish db;
	public int employee_id;

	public GUI() {
		db = new StreamFish();
		addWindowListener(this);

        Login_screen login = new Login_screen(this);
		//MainMenu mainMenu = new MainMenu(this);

		panels.add(login);
		panels.add(new MainMenu(this));
		add(login);
		login.setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setVisible(true);
		pack();
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		double width = screenSize.getWidth();
		double heigth = screenSize.getHeight();
		Dimension frameSize = getSize();
		setLocation((int)width/2-(int)frameSize.getWidth()/2,(int) heigth/2-(int)frameSize.getHeight()/2);
	}

	public void byttVindu(JPanel remove, JPanel add) {
		remove(remove);
		add(add);
		pack();
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		double width = screenSize.getWidth();
		double heigth = screenSize.getHeight();
		Dimension frameSize = getSize();
		setLocation((int)width/2-(int)frameSize.getWidth()/2,(int) heigth/2-(int)frameSize.getHeight()/2);
	}


	public boolean registerOrder(Order order) {
		int suc = db.addOrder(order);
		if (suc > 0) {
			return true;
		}
		return false;
	}

	public boolean registerCustomer(Customer customer) {
		int suc = db.addCustomer(customer);
		if (suc > 0) {
			return true;
		}
		return false;
	}

	public boolean changeCustomerStatus(Customer customer) {
		int succ = db.changeCustomerStatus(customer);
		if (succ == 1) {
			return true;
		}
		return false;
	}

	public Customer[] getCustomers(String s, boolean status) {
		return db.getCustomers(s, status);
	}

	public Customer getCustomer(int i) {
		return db.getCustomer(i);
	}

	public boolean updateCustomer(Customer customer) {
		int succ = db.updateCustomer(customer);
		if (succ == 1) {
			return true;
		}
		return false;
	}

	public boolean addCustomerAddress(CustomerAddress customer) {
		int succ = db.addCustomerAddress(customer);
		if (succ == 1) {
			return true;
		}
		return false;
	}
	
	public boolean registrerSubscription(Subscription subscription, Order order) {
		if(db.registerSubscription(subscription, order) == 1){
			return true;
		} 
		return false;
	}
	void registerMenu(Menu menu, ArrayList<Integer> dishID) {
		db.registerMenu(menu, dishID);
	}

	public Orderinfo[] getTodaysTasks(String sok) {
		return db.getTodaysTasks(sok);
	}
        
        public Orderinfo[] getTodaysTasks2(String sok) {
            return db.getTodaysTasks2(sok);
        }
        
        public Order getOrderfromSub(Subscription subscription){
            return db.getOrder(subscription);
        }

	public Order[] getOrders(Customer customer) {
		return db.getOrder(customer);
	}
	public Subscription[] getSubscriptions(String text) {
		return db.getSubscriptions(text);
	}
	public Employee[] getEmployee(){
		return db.getEmployees();
	}

	public boolean changeOrderStatus(int orderID) {
		int succ = db.changeOrderStatus(orderID);
		if (succ == 1) {
			return true;
		}
		return false;
	}

	public CustomerAddress[] getAddress(int custid) {
		return db.getAddress(custid);
	}

	public Menu[] getMenus() {
		return db.getMenus();
	}
	
	public Dish getDish(int id){
		return db.getDish(id);
	}
        
	public Employee getUserAuthorization(String username, String password) {
		return db.userAuthorization(username, password);
	}
        public Dish[] getDishes(String name){
            return db.getDishes(name);
        }
        public String checkIngForDish(Dish dish){
            return db.checkIngForDish(dish);
        }
        public boolean addDish(Dish dish){
            if(db.addDish(dish) == 1){
                return true;
            }
            return false ;
        }

	public Ingredient[] getIngredients(String name) {
		return db.getIngredients(name);
	}

	public boolean addIngredient(Ingredient ing) {
		if (db.addIngredient(ing) == 1) {
			return true;
		}
		return false;
	}

	public boolean updateIngredient(Ingredient ingToUpdate, Ingredient ing) {
		int succ = db.updateIngredient(ingToUpdate, ing);
		if (succ == 1) {
			MainMenu main = (MainMenu) panels.get(1);
			main.updt();
			return true;
		}
		return false;
	}
        
        public boolean setDeliveredOrders() {
            int succ = db.setDeliveredOrders();
            if (succ != -1) {
                return true;
            }
            return false;
        }
        
        public ArrayList<String[]> getMenuSalesStats(String fromDate, String toDate, int ant, boolean top) {
            return db.getMenuSalesStats(fromDate, toDate, ant, top);
        }

	public static void main(String[] args) {
		new GUI();
	}

	@Override
	public void windowOpened(WindowEvent e) {
	}

	@Override
	public void windowClosing(WindowEvent e) {
		db.close();
	}

	@Override
	public void windowClosed(WindowEvent e) {
	}

	@Override
	public void windowIconified(WindowEvent e) {
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
	}

	@Override
	public void windowActivated(WindowEvent e) {
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
	}

	
}