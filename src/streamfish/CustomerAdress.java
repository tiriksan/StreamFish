package streamfish;

/**
 * @author Sindre
 */
public class CustomerAdress {
	private String adress;
        private int zipCode;
        private String city;
        private int customerID;

	public CustomerAdress(String adress, int zip, String city, int cusID) {
		this.adress = adress;
                this.zipCode = zip;
                this.city = city;
                this.customerID = cusID;
	}

	public int getCustomerID() {
		return customerID;
	}

	public String getAdress() {

		return adress;
	}
	public int getZipCode() {
		return zipCode;
	}

	public String getCity() {
		return city;
	}

	public String toString() {
		return ("Adress: " + adress + ", ZIP: " + zipCode +", City: "+city);
	}
}

