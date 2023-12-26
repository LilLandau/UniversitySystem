package news;

import java.io.Serializable;
import java.util.Vector;

import Users.Employee;

public class News implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -2310335023062874599L;
	private static  News instance;
	private static Vector<NewsBlank> messages = new Vector<NewsBlank>();
	private News() {
	}
	
	public static News getNewsBoard() {
		if(instance == null) {
			instance = new News();
		}
		
		return instance;
	}
	
	public static void makePublication(NewsBlank message) {
		if(message.getAuthor() instanceof Employee) {
			messages.add(message);
		}
	}
	public static void showPublications() {
		System.out.println("https://wsp.kbtu.kz/newsboard");
		System.out.println("\n\n\t  NEWS BOARD \n\n");
		messages.sort(new ComparatorByTopic());
		for(NewsBlank message: messages) {
			System.out.println(message);
		}
	}
	public static void deletePublication(String tittle, Employee emp) {
		for(NewsBlank news: messages) {
			if(news.getAuthor() == emp && news.getTittle() == tittle) {
				messages.remove(news);
				System.out.println("SUccesfully deleted");
			}
		}
		System.out.println("We cannot find that news");
	}
	
	public static Vector<NewsBlank> getMessages(){
		return messages;
	}
	public static void setMessages(Vector<NewsBlank> news){
		messages = news;
	}
	
	
}	

