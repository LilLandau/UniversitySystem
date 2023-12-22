package Users;
import java.util.Date;
import java.util.Objects;

public class Employee extends User {
	private double salary;
	//private messenger
	
	public Employee(String firstname, String secondname, String ID, Date birthdate, String phoneNumber,
			String login, String password, String email, Gender gender, Address address, Language language, double salary) {
		
		super(firstname, secondname, ID, birthdate, phoneNumber,
				login, password, email, gender, address, language);
		this.salary = salary;
	}
	
	public double getSalary() { return salary; }
	protected void setSalary(double newSalary) { this.salary = newSalary; }
	
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!super.equals(o)) return false;
		if (o == null  || o.getClass() != this.getClass()) return false;
		
		Employee other = (Employee)o;
		return this.getSalary() == other.getSalary();
	}
	
	public int hashCode() {
		return Objects.hash(super.hashCode(), salary);
	}
	
}
