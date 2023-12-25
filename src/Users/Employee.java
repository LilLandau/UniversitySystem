package Users;
import java.util.Date;
import java.util.Objects;

import messenger.Messenger;
import news.News;
import news.NewsBlank;
import news.TopicOfNews;

public class Employee extends User {
	private static final long serialVersionUID = -8206113627892566318L;
	private double salary;
	private Messenger messenger;
	
	public Employee(String firstname, String secondname, String ID, Date birthdate, String phoneNumber,
			String login, String password, String email, Gender gender, Address address, Language language, double salary) {
		
		super(firstname, secondname, ID, birthdate, phoneNumber,
				login, password, email, gender, address, language);
		this.salary = salary;
		this.messenger = new Messenger(this);
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
	
	public void makeNews(String tittle, String fullTxt, TopicOfNews topic) {
		News.makePublication(new NewsBlank(tittle, fullTxt, this, topic));
	}
	
	public void deletePublication(String tittle) {
		News.deletePublication(tittle, this);
	}
	
	public Messenger getMyMessenger() {
		return this.messenger;
	}
}
