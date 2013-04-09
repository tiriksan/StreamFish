package streamfish;

public class Customer {

	private int CUSTOMER_ID;
	private double priceReduction;
	private double percentageReduction = 1.0;
	private String customerName;
	private int phone;
	private boolean business = false;

	public Customer(int customer_id, String customerName, int phone, boolean business) {
		if (customerName == null || customerName.trim().equals("")) {
			throw new IllegalArgumentException("Customer's name is required.");
		}
		if (phone > 99999999 || phone < 00000000) {
                    javax.swing.JOptionPane.showMessageDialog(null, "Customer's phone number cannot exceed eight digits.");
                    throw new NumberFormatException("Customer's phone number cannot exceed eight digits.");
                        
		}
		this.CUSTOMER_ID = customer_id;
		this.customerName = customerName;
		this.phone = phone;
		this.business = business;
	}

	public Customer(String customerName, int phone, boolean business) {
		if (customerName == null || customerName.trim().equals("")) {
			throw new IllegalArgumentException("Customer's name is required.");
		}
		if (phone > 99999999 || phone < 00000000) {
			throw new NumberFormatException("Customer's phone number cannot exceed eight digits.");
		}
		customerName = customerName.replace(";", "");
		this.customerName = customerName;
		this.phone = phone;
		this.business = business;
	}

	public Customer(int customer_id, String customerName, int phone) {
		if (customerName == null || customerName.trim().equals("")) {
			throw new IllegalArgumentException("Customer's name is required.");
		}
		if (phone > 99999999 || phone < 00000000) {
			throw new NumberFormatException("Customer's phone number cannot exceed eight digits.");
		}
		this.CUSTOMER_ID = customer_id;
		this.customerName = customerName;
		this.phone = phone;
	}

	public int getCustomerID() {
		return CUSTOMER_ID;
	}

	public String getCustomerName() {
		return customerName;
	}

	public int getPhoneNumber() {
		return phone;
	}

	public boolean isBusiness() {
		return business;
	}

	public double getPriceReduction() {
		priceReduction = (business) ? percentageReduction : 1.0;
		return priceReduction;
	}

	public void setCustomerName(String newName) {
		if (newName == null || newName.trim().equals("")) {
			throw new IllegalArgumentException("Customer's name is required.");
		}
		customerName = newName;
	}

	public void setPhoneNumber(int newPhone) {
		if (newPhone > 99999999 || newPhone < 00000000) {
			throw new NumberFormatException("Customer's phone number cannot exceed eight digits.");
		}
		phone = newPhone;
	}

	public void setBusiness(boolean change) {
		if (business != change) {
			business = change;
		}
	}

	public void setPercentageReduction(double newPercentage) {
		if (newPercentage > 0.0 && newPercentage < 1.0) {
			percentageReduction = newPercentage;
		}
	}

	@Override
	public String toString() {
		String info = "Customer ID: " + CUSTOMER_ID + ", name: " + customerName
				+ ", phonenumber: " + phone;
		info += (business) ? ", bedrift med "
				+ (100 - (100 * getPriceReduction())) + "% rabatt" : "";
		return info;
	}

	public static void main(String[] args) {
		Customer priv1 = new Customer(1, "Håkon Jarle Hassel", 92881009);
		Customer priv2 = new Customer(2, "Per Persen", 10120455);
		Customer bedr1 = new Customer(3, "Evry", 99778866, true);

		System.out.println(priv1);
		System.out.println(bedr1);
		System.out.println(priv2);

		bedr1.setPercentageReduction(0.85);
		System.out.println(bedr1);
	}
}
