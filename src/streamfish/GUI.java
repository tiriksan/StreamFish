package streamfish;

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
	}

	public void byttVindu(JPanel remove, JPanel add) {
		remove(remove);
		add(add);
		pack();
	}

	public void byttVindu(JPanel remove, String newWindow) {
		remove(remove);
		for (JPanel jp : panels) {
			if (jp.getClass().getName().equals(newWindow)) {
				add(jp);
			}
		}
		pack();
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
			MainMenu main = (MainMenu) panels.get(1);
			main.updt();
			return true;
		}
		return false;
	}

	public boolean changeCustomerStatus(Customer customer) {
		int succ = db.changeCustomerStatus(customer);
		if (succ == 1) {
			MainMenu main = (MainMenu) panels.get(1);
			main.updt();
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
			MainMenu main = (MainMenu) panels.get(1);
			main.updt();
			return true;
		}
		return false;
	}

	public boolean addCustomerAddress(CustomerAddress customer) {
		int succ = db.addCustomerAddress(customer);
		if (succ == 1) {
			MainMenu main = (MainMenu) panels.get(1);
			main.updt();
			return true;
		}
		return false;
	}

	public Orderinfo[] getTodaysTasks() {
		return db.getTodaysTasks();
	}

	public Order[] getOrders(Customer customer) {
		return db.getOrderCustomer(customer);
	}

	public boolean changeOrderStatus(int orderID) {
		int succ = db.changeOrderStatus(orderID);
		if (succ == 1) {
			MainMenu main = (MainMenu) panels.get(1);
			main.updt();
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

	public Employee getUserAuthorization(String username, String password) {
		return db.userAuthorization(username, password);
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