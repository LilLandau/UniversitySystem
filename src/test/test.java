//package test;
//import database.*;
//
//import java.io.IOException;
//import java.util.Date;
//
//import Users.*;
//import database.DataBase;
//import messenger.*;
//
//public class test{
//    public static void main(String[] args){
//		User user1 = new User("Zhanserik", "Amangeldi", "22b030301", new Date(), "87054578237", "epocson",
//				"qewrty123", "amangeldi@kbtu.kz", Gender.MALE, new Address("KAZAKHSTAN", "ATYRAU", "bb", "40"), Language.ENG );
//		User user2 = new User("Alikhan", "KAssi", "22b030312", new Date(), "87054578237", "kassi",
//			"qewrty1234", "alikhan@kbtu.kz", Gender.MALE, new Address("KAZAKHSTAN", "oskemen", "bb", "40"), Language.ENG );
//
//		
//		DataBase.addUsers(user1);
//		DataBase.addUsers(user2);
//		
//		try {
//			DataBase.serializa(user1.getDatabase(), "db.ser");
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		System.out.println(user1.getDatabase().getUsers());
//		
//		user1.getMyMessenger().createChat(user2, "FIRSTCHAT");
//
//	
//		user1.getMyMessenger().sendMessageTo("FIRSTCHAT", new Message("HELLO WORLD", user1));
//	
//	
////	user2.getMyMessnger().showChat("FIRSTCHAT");
//	
//		user2.getMyMessenger().sendMessageTo("FIRSTCHAT", new Message("HELLO ZHANSERIK", user2));
//	
//	
//		user1.getMyMessenger().showChat("FIRSTCHAT");;
//		}
// }
