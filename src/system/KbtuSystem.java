package system;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import database.DataBase;
import Users.*;

public class KbtuSystem {
	private User user;
	private String login = "";
	private String password = "";
	private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	public KbtuSystem() {
		
	}
	
	public void autho() throws IOException{
		while(true) {
			int chooseOfUser = 0;
			System.out.println("\n" + "-".repeat(20) + "https://wsp.kbtu.kz/" + "-".repeat(20) + "\n\n");
			System.out.println(String.format("Login: %s (1)", this.login));
			System.out.println(String.format("Password: %s (2)\n", this.password));
			System.out.println("Sign in(3)\n");
			

			chooseOfUser = reader.read() - 48;

			if(chooseOfUser == 1) {
				System.out.println("Login: ");
				reader.readLine();
				this.login = reader.readLine();
			}else if(chooseOfUser == 2) {
				System.out.println("Password: ");
				reader.readLine();
				this.password = reader.readLine();
				System.out.print(this.login);
			}else if(chooseOfUser == 3) {
				if(this.authenticateUser(this.login, this.password)) {
					this.mainPage(this.chooseUser(login));
				}else{
			    	this.login = "";
			    	this.password = "";
					continue;
				}
			}
		}
	}
	
	public void mainPage(User user) throws IOException {
		System.out.println(user);

		if(user == null) { 
			return;
		}
		this.user = user;

		user.mainPage();	
	}
	
	
	public void StudentMainPage(Student stu) {
		
	}
	
	
	
	// for autho
    private boolean authenticateUser(String username, String password) {
    	for(User u: DataBase.getUsers()) {
    		if(u.getLogin().equals(username) && u.getPassword().equals(password)) {
    			return true;
    		}
    	}
    	return false;
    }
    
    
    private User chooseUser(String name) {
    	for(User u: DataBase.getUsers()) {
    		System.out.println(u);
    		if(u.getLogin().equals(name)) {
    			return u;
    		}
    	}
		return null;
    }
}
