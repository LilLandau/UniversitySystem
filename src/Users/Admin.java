package Users;
import java.util.Date;
import java.util.Objects;

import database.DataBase;

/**
 * @author Danial
 * This class is represented admin
 * of University system
 */
public class Admin extends Employee {

	public Admin(String firstname, String secondname, String ID, Date birthdate, String phoneNumber, String login,
			String password, String email, Gender gender, Address address, Language language, double salary) {
		super(firstname, secondname, ID, birthdate, phoneNumber, login, password, email, gender, address, language, salary);
	}
	
	/**
	 * This method opens registration for students
	 */
	public void openRegistration() {
		DataBase.setRegistration(true);
	}
	
	/**
	 * This method closes registration for students
	 */
	public void closeRegistration() {
		DataBase.setRegistration(false);
	}
	
	/**
	 * @param user of the system
	 * @throws UserAlreadyExistsException if user is already in system
	 * This method adds new User to system
	 */
	public void addUser(User u) throws UserAlreadyExistsException {
		if (!DataBase.getUsers().contains(u)) {
			DataBase.getUsers().add(u);
		}
		else {
			throw new UserAlreadyExistsException("User is already exists");
		}
	}
	
	/**
	 * @param user of the system
	 * @throws UserAlreadyExistsException if user is already removed from system
	 * This method removes User from system
	 */
	public void removeUser(User u) throws UserAlreadyExistsException {
		if (DataBase.getUsers().contains(u)) {
			DataBase.getUsers().remove(u);
		}
		else {
			throw new UserAlreadyExistsException("User is already removed from system");
		}
	}
	
	/**
	 * @return returns the logs of system
	 * This method is used to get logs 
	 */
	public String seeLogs() {
		return "WRITE";
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
 