package system;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import database.DataBase;
import Users.User;

public class KbtuSystem {
	private User user;
	private String login = "";
	private String password = "";
	private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	private DataBase db = DataBase.getDataBase();
	public KbtuSystem() {
		
	}
	
	public void autho() throws IOException{
		while(true) {
			int chooseOfUser = 0;
			System.out.println("\n" + "-".repeat(20) + "https://wsp.kbtu.kz/" + "-".repeat(20) + "\n\n");
			System.out.println(String.format("Login: %s (1)", this.login));
			System.out.println(String.format("Password: %s (2)\n", this.password));
			System.out.println("Sign in(3)\n");
			System.out.print("\nI do not remember my login or password(4)\n");
			

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
				if(this.authenticateUser(this.login, password)) {
					this.mainPage(this.chooseUser(login));
				}else{

			    	this.login = "";
			    	this.password = "";
					continue;
				}
			}else if(chooseOfUser == 4) {
				String email = "";
				System.out.print("email: ");
				reader.readLine();
				email = reader.readLine();
				if(this.checkEmail(email)) {
	    			System.out.println("\n\nWe send message to your email!");
				}else {
	    			System.out.println("\n\nIncorrect email!");
				}
			}
		}
	}
	
	public void mainPage(User user) {
		if(user == null) { 
			return;
		}
		this.user = user; 
	}
	
	
	
	
	
	
	// for autho
    private boolean authenticateUser(String username, String password) {
    	for(User u: DataBase.getUsers()) {
    		if(u.getLogin() == username) {
    			return true;
    		}
    	}
    	return false;
    }
    
    private boolean checkEmail(String email) {
    	for(User u: db.getUsers()) {
    		if(u.getEmail() == email) {
    			return true;
    		}
    	}
    	return false;
    }
    
    private User chooseUser(String name) {
    	for(User u: db.getUsers()) {
    		if(u.getFirstname() == name) {
    			return u;
    		}
    	}
		return null;
    }
}
