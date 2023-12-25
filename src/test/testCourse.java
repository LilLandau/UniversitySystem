package test;

import java.io.IOException;

import Users.Course;
import Users.User;
import database.DataBase;
import news.News;

public class testCourse {
	 public static void main(String[] args){

	    	try {
				DataBase.loadUsers();
				DataBase.loadNews();
				DataBase.loadCourses();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
//	    	User user1 = DataBase.getUsers().get(0);
//	    	User user2 = DataBase.getUsers().get(1);
//	    	
//	    	Course course1 = new Course(null, null, "ABC", "Z!@(#", 12);
//	    	Course course2 = new Course(null, null, "ABd", "Z!@(#", 12);
//	    	course1.addPrerequisites(course2);
	    	
	    	
//	    	try {
//				DataBase.saveCourses();
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
	    	DataBase.getCourses().get(1).showPrerequisitese();;
	    	
	    	
	}
}
