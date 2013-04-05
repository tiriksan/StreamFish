/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package streamfish;

/**
 *
 * @author Kristian
 */
public class Menu {
	private int menuId;
	private String menuName;
	private int price;
	private String description;

	public Menu(int menuId, String menuName, int price, String description) {
		this.menuId = menuId;
		this.menuName = menuName;
		this.price = price;
		this.description = description;
	}

	public int getMenuId() {
		return menuId;
	}

	public String getMenuName() {
		return menuName;
	}

	public int getPrice() {
		return price;
	}

	public String getDescription() {
		return description;
	}

	public String toString() {
		return "ID: " + menuId + ", navn: " + menuName;
	}
}
