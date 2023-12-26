package test;
import java.io.IOException;

import java.util.Date;

import Users.*;
import database.DataBase;
import messenger.*;
import news.News;

public class testSerial{
    public static void main(String[] args){

		

    	try {
    		DataBase.loadMessengers();
			DataBase.loadUsers();
			DataBase.loadNews();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
//    	
//    	Employee user1 = new Employee("Zhanserik", "Amangeldi", "22b030301", new Date(), "87054578237", "epocson",
//				"qewrty123", "amangeldi@kbtu.kz", Gender.MALE, new Address("KAZAKHSTAN", "ATYRAU", "bb", "40"), Language.ENG, 20);
//		Employee user2 = new Employee("Alikhan", "KAssi", "22b030312", new Date(), "87054578237", "kassi",
//			"qewrty1234", "alikhan@kbtu.kz", Gender.MALE, new Address("KAZAKHSTAN", "oskemen", "bb", "40"), Language.ENG, 10);
//    	
//    	
//		user1.getMyMessenger().createChat(user2, "FIRSTCHAT");
//
//		
//		user1.getMyMessenger().sendMessageTo("FIRSTCHAT", new Message("HELLO WORLD", user1));
//		
//		
////		user2.getMyMessnger().showChat("FIRSTCHAT");
//		
//		user2.getMyMessenger().sendMessageTo("FIRSTCHAT", new Message("HELLO ZHANSERIK", user2));
		
    	System.out.println(((Employee)DataBase.getUsers().get(5)).getMyMessenger().getChats());		
    	((Employee)DataBase.getUsers().get(5)).getMyMessenger().showChat("FIRSTCHAT");
		try {
			DataBase.saveMessengers();
			DataBase.saveUsers();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		System.out.println(DataBase.getUsers());
		}
 }
