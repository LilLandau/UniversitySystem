package test;

import java.io.IOException;
import java.util.Date;

import Users.Address;
import Users.Employee;
import Users.Gender;
import Users.Language;
import Users.User;
import database.DataBase;
import messenger.Message;
import news.TopicOfNews;

public class testNews {
	public static void main(String[] args) {
		User user1 = new User("Zhanserik", "Amangeldi", "22b030301", new Date(), "87054578237", "epocson",
				"qewrty123", "amangeldi@kbtu.kz", Gender.MALE, new Address("KAZAKHSTAN", "ATYRAU", "bb", "40"), Language.ENG );
		Employee user2 = new Employee("Alikhan", "KAssi", "22b030312", new Date(), "87054578237", "kassi",
			"qewrty1234", "alikhan@kbtu.kz", Gender.MALE, new Address("KAZAKHSTAN", "oskemen", "bb", "40"), Language.ENG, 10);
		
		user1.getNotify().addMessage(new Message("GO", user2));
		
		user1.getNotify().showNotifications();
		
		
		
    	
	}
}
