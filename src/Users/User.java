package Users;
import messenger.*;
import news.News;
import researcher.Journal;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.util.*;

import Notifications.Notifications;
import database.DataBase;
/**
 * This class is the main class of the user's system.
 * It represent the basic class named User
 * @author Danial
*/

public class User implements Comparable<User>, Serializable{
	/**
	 * All fields are representing basic information about system's user
	*/
	private static final long serialVersionUID = -5166686727559956025L;
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
	private News newsBoard;
	private Notifications notify;
	private Vector<Journal> subscriptions;
	private DataBase db;
	protected BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	
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
		this.newsBoard = News.getNewsBoard(); 
		this.subscriptions = new Vector<>();
		this.notify = new Notifications(this);
		DataBase.addUser(this);
	}
	
	/**
	 * This method allows to change password of authorization
	 * @param new password
	*/
	private boolean changePassword(String newPassword) {
		if (this.password == newPassword) return false;
		else if (!newPassword.matches("^[a-zA-Z0-9]+$")) return false;
		else { 
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
	public Gender getGender() { return gender; }
	public Date getBirthDate() { return birthdate; }
	public Address getAddress() { return address; }
	public Language getLanguage() { return language; }
	public String getPhoneNumber() { return phoneNumber; }
	public News getNewsBoard() {
		return this.newsBoard;
	}
	public String toString() {
		return this.firstname + " " +  this.secondname;
	}
	
	public String getEmail() {
		return this.email;
	}
	
	public String getLogin() {
		return this.login;
	}
	
	public Notifications getNotify() {
		return this.notify;
	}
	
	public void sendNotification(Message message) {
		this.notify.addMessage(message);
	}
	

	
	
	public void mainPage() throws IOException {
		while(true) {
			int chooseOfUser = 0;
			System.out.println("Welcome to the your University account " + this.firstname + " " + this.secondname + "!" );
			System.out.println("LNG: " + this.language);
			System.out.println("Change Password                (1)" ); // check 
			System.out.println("Show NewsBoard                 (2)"); // check
			System.out.println("Show Notifications             (3)");
			System.out.println("Show Subscriptions             (4)"); 
			System.out.println("Subscribe to                   (5)");
			System.out.println("Show full information about me (6)");
			System.out.println("Go Back                        (7)");
			
			chooseOfUser = reader.read() - 48;
			
			
			
			if(chooseOfUser == 1) {
				this.changePassword();
			}else if(chooseOfUser == 2) {
				News.showPublications();

			}else if(chooseOfUser == 3) {
				this.notify.showNotifications();

			}else if(chooseOfUser == 4) {
				System.out.println("https://wsp.kbtu.kz/" + this.login + "/subscriptions");
				System.out.println("\n\n\t  My Subscriptions\n\n");
				if(this.subscriptions.isEmpty()) {
					System.out.println("\t  There is nothing");
				}else {
					for(Journal j : this.subscriptions) {
						System.out.println(j);
					}
				}
			}else if(chooseOfUser == 5) {
				Vector<Journal> temp = DataBase.getJournal();
				int choose;
				System.out.println("https://wsp.kbtu.kz/journals");
				System.out.println("Choose journal for sub\n");
				System.out.println("Journals: \n");
				if(temp.isEmpty()) {
					System.out.println("\t  We don't have any journals yet :(");
				}else {
					int i = 1;
					for(Journal j : temp) {
						System.out.println(i + ". " + j);
						i++;
					}
					reader.readLine();
					choose = reader.read();
					try {
						temp.get(i - 1).addSubscriber(this);
						this.subscriptions.add(temp.get(i - 1));
					}catch(Exception e) {
						e.printStackTrace();
					}	
				}
			}
			if(chooseOfUser == 6) {
				this.showFullInfo();

			}
			reader.readLine();
			reader.readLine();
			
			
			
		}
	}
	
	public void showFullInfo() throws IOException {
		System.out.println("Firstname: " + this.firstname);
		System.out.println("Secondname: " + this.secondname);
		System.out.println("ID: " + this.ID);
		System.out.println("Birthday: " + this.birthdate);
		System.out.println("Phone number: " + this.phoneNumber);
		System.out.println("Login: " + this.login);
		System.out.println("Password: " + "*".repeat(this.password.length()));
		System.out.println("Email: " + this.email);
		System.out.println("Gender: " + this.gender);
		System.out.println("Addreess: " + this.address);
	}
	
	
	public void changePassword() throws IOException {
		while(true) {
			int choose;
			String oldpass, newpass = "", newpass2 = "";
			System.out.print("\nEnter old password: (1)");
			System.out.print("\nBack (2)");
			reader.readLine();
			choose = reader.read() - 48;
			if(choose == 1) {
				System.out.println("Old password: ");
				reader.readLine();
				oldpass = reader.readLine();
				if(oldpass.equals(this.password)) {
					System.out.println("In password should be upper, lower case and digit");
					System.out.print("\nEnter new password: ");
					newpass = reader.readLine();
					System.out.print("\nReapeat new password: ");
					newpass2 = reader.readLine();
					if(newpass.equals(newpass2)) {
						if(this.changePassword(newpass)) {
							System.out.print("\nPassword changed!!!");
							reader.readLine();
						}else {
							System.out.println("Your password there is no upper, lower case or digit");
						}
					}else {
						System.out.println("Two enter do not equal");
					}
				}else {
					continue;
				}
			}else if(choose == 2) {
				return;
			}

		}
	}
	
	
	
	
	
	
	
}
