package Users;
import java.util.*;

public class User implements Comparable<User>{
	private String firstname;
	private String secondname;
	private String ID;
	private Date birthdate;
	private String phoneNumber;
	private String login;
	private String password;
	private String email;
	private Gender gender;
	private Address address;
	private Language language;
	
	public User(String firstname, String secondname, String ID, Date birthdate, String phoneNumber,
			String login, String password, String email, Gender gender, Address address, Language language) {
		this.firstname = firstname;
		this.secondname = secondname;
		this.ID = ID;
		this.birthdate = birthdate;
		this.phoneNumber = phoneNumber;
		this.login = login;
		this.password = password;
		this.email = email;
		this.gender = gender;
		this.address = address;
		this.language = language;
	}
	
	public boolean changePassword(String newPassword) {
		if (this.password == newPassword) return false;
		if (!newPassword.matches("^[a-zA-Z0-9]+$")) return false;
		
		boolean hasUpper = false;
		boolean hasLower = false;
		boolean hasDigit = false;
		
		for (int i = 0; i < newPassword.length(); i++) {
			char c = newPassword.charAt(i);
			
			if (Character.isUpperCase(c)) hasUpper = true;
			if (Character.isLowerCase(c)) hasLower = true;
			if (Character.isDigit(c)) hasDigit = true;
		}
		
		if (hasUpper && hasLower && hasDigit) {
			setPassword(newPassword);
			return true;
		}
		
		return false;
	}
	
	public String getID() {
		return ID;
	}
	
	//subscribe
	
	public int compareTo(User other) {
		return this.ID.compareTo(other.ID);
	}
	
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || this.getClass() != o.getClass()) return false;
		
		User user = (User)o;
		return ID.equals(user.ID);
	}
	
	public int hashCode() {
		return ID.hashCode();
	}
	
	public String getPassword() { return password; }
	private void setPassword(String newPassword) { this.password = newPassword; }
	
	public String getFirstname() { return firstname; }
	public String getSecondname() { return secondname; }
	//
}
