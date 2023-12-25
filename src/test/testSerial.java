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
			DataBase.loadUsers();
			DataBase.loadNews();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	
		
    	User user1 = DataBase.getUsers().get(0);
    	User user2 = DataBase.getUsers().get(1);
    	
    	System.out.println(user1 + " " + user2);
		
		News.showPublications();;
		
		
		
		try {
			DataBase.saveUsers();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(DataBase.getUsers());
		}
 }
