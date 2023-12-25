package Users;

import java.util.Date;
import java.util.Objects;

import database.DataBase;

public class Admin extends Employee {

	public Admin(String firstname, String secondname, String ID, Date birthdate, String phoneNumber, String login,
			String password, String email, Gender gender, Address address, Language language, double salary) {
		super(firstname, secondname, ID, birthdate, phoneNumber, login, password, email, gender, address, language, salary);
	}
	
	public void openRegistration() {
		//to write
	}
	
	public void closeRegistration() {
		//to write
	}
	
	public void addUser(User u) throws UserAlreadyExistsException {
		if (!DataBase.getUsers().contains(u)) {
			DataBase.getUsers().add(u);
		}
		else {
			throw new UserAlreadyExistsException("User is already exists");
		}
	}
	
	public void removeUser(User u) throws UserAlreadyExistsException {
		if (DataBase.getUsers().contains(u)) {
			DataBase.getUsers().remove(u);
		}
		else {
			throw new UserAlreadyExistsException("User is already removed from system");
		}
	}
	
	public String seeLogs() {
		//to write
	}
	
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null  || o.getClass() != this.getClass()) return false;
		
		Admin a = (Admin)o;
		return this.getID().equals(a.getID());
	}
	
	public int hashCode() {
		return Objects.hash(this.getID(), this.getSalary());
	}
}
 