package system;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import Users.Address;
import Users.Employee;
import Users.Gender;
import Users.Language;
import Users.User;
import database.DataBase;

public class AuthorizationConsole {
    public static void main(String[] args) throws IOException {
    	
    	
    	KbtuSystem sys1 = new KbtuSystem();
		User user1 = new User("Zhanserik", "Amangeldi", "22b030301", new Date(), "87054578237", "epocson",
				"qewrty123", "amangeldi@kbtu.kz", Gender.MALE, new Address("KAZAKHSTAN", "ATYRAU", "bb", "40"), Language.ENG );
		Employee user2 = new Employee("Alikhan", "KAssi", "22b030312", new Date(), "87054578237", "kassi",
			"qewrty1234", "alikhan@kbtu.kz", Gender.MALE, new Address("KAZAKHSTAN", "oskemen", "bb", "40"), Language.ENG, 10);
		
    	System.out.println(DataBase.getUsers());
    	sys1.autho();
//        // Initialize dummy users (replace with real user data)
//        users.put("user1", "password1");
//        users.put("user2", "password2");
//
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//
//        System.out.print("Enter username: ");
//        String username = reader.readLine();
//
//        System.out.print("Enter password: ");
//        String password = reader.readLine();
//
//        if (authenticateUser(username, password)) {
//            System.out.println("Authentication successful. Welcome, " + username + "!");
//        } else {
//            System.out.println("Authentication failed. Invalid username or password.");
//        }
    }
}
