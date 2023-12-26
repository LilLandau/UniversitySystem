package test;
import database.*;

import java.io.IOException;
import java.util.Date;

import Users.*;
import database.DataBase;
import messenger.*;
import news.TopicOfNews;

public class test{
    public static void main(String[] args) throws IOException{
		Employee user1 = new Employee("Zhanserik", "Amangeldi", "22b030301", new Date(), "87054578237", "epocson",
				"qewrty123", "amangeldi@kbtu.kz", Gender.MALE, new Address("KAZAKHSTAN", "ATYRAU", "bb", "40"), Language.ENG, 10);
    	
		user1.makeNews("NEW Reasearch", "HELLO TOGEHER WAS PUBLISHED NEW RESEARCH", TopicOfNews.RESEARCH);

		user1.makeNews("NEW Reasearch", "HELLO TOGEHER WAS PUBLISHED NEW RESEARCH", TopicOfNews.RESEARCH);
		user1.makeNews("NEW Reasearch", "HELLO TOGEHER WAS PUBLISHED NEW RESEARCH", TopicOfNews.RESEARCH);
		
		user1.mainPage();
		}
 }
