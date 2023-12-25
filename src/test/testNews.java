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
		
		user1.getNewsBoard().showPublications();
		DataBase.addUser(user1);
		DataBase.addUser(user2);
		System.out.println("BEFORE");
		
		user2.makeNews("hello", "hello world! i am amangeldi zhanserik and i test my code for news system in my uni project", TopicOfNews.RESEARCH);
		
		

		user2.makeNews("hello2", "tuduc", TopicOfNews.ETC); 
		user2.makeNews("hello1", "tuduc", TopicOfNews.RESEARCH); 
		user2.makeNews("hello5", "tuduc", TopicOfNews.ETC); 
		user2.makeNews("hello3", "tuduc", TopicOfNews.ACADEMIC); 
		user2.makeNews("hello10", "tuduc", TopicOfNews.ETC); 
		user2.makeNews("hello9", "tuduc", TopicOfNews.ETC); 
		user2.makeNews("hello6", "tuduc", TopicOfNews.ETC); 
		user2.makeNews("hello4", "tuduc", TopicOfNews.RESEARCH); 
		user2.makeNews("hello7", "tuduc", TopicOfNews.ETC); 
		user2.makeNews("hello8", "tuduc", TopicOfNews.ACADEMIC); 
		user2.makeNews("hello13", "tuduc", TopicOfNews.ETC); 
		user2.makeNews("hello112", "tuduc", TopicOfNews.RESEARCH);
		user1.getNewsBoard().showPublications();
		
		try {
			DataBase.saveNews();
			DataBase.saveUsers();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
	}
}
