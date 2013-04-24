package streamfish;

/**
 * @author Sindre
 */
public class CustomerAddress {
	private String adress;
        private String zipCode;
        private String city;
        private int customerID;

	public CustomerAddress(String adress, String zip, String city, int cusID) {
		this.adress = adress;
                this.zipCode = zip;
                this.city = city;
                this.customerID = cusID;
	}
        public CustomerAddress(String adress, String zip, String city) {
		this.adress = adress;
                this.zipCode = zip;
                this.city = city;
	}

	public int getCustomerID() {
		return customerID;
	}

	public String getAdress() {

		return adress;
	}
	public String getZipCode() {
		return zipCode;
	}

	public String getCity() {
		return city;
	}

	public String toString() {
		return ("Adress: " + adress + ", ZIP: " + zipCode +", City: "+city);
	}
}

