package Users;

public class Address {
	private String country;
	private String city;
	private String street;
	private String houseNumber;
	
	public Address(String country, String city, String street, String houseNumber) {
		this.country = country;
		this.city = city;
		this.street = street;
		this.houseNumber = houseNumber;
	}
	
	public String toString() {
		return country + ", " + city + ", " + street + ", " + houseNumber;
	}
	
	public int hashCode() {
		return country.hashCode() + city.hashCode() + street.hashCode() + houseNumber.hashCode(); 
	}
	
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || this.getClass() != o.getClass()) return false;
		
		Address address = (Address)o;
		return country.equals(address.country) && city.equals(address.city) &&
				street.equals(address.street) && houseNumber.equals(address.houseNumber);
	}
}

