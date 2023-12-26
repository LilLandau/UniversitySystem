package researcher;

import java.util.Vector;

import Users.Employee;
import Users.Organization;
import Users.User;
import messenger.Message;

public class Journal {
	private String name;
	private Organization publisher;
	private int rating = 0;
	private int rateSum = 0;
	private int rateNumber = 0;
	private Employee editor;
	private Vector<User> subscribers;
	private Vector<ResearchPaper> projects;
	
	public Journal(String name, Organization publisher, Employee editor) {
		this.name = name;
		this.publisher = publisher;
		this.editor = editor;
		subscribers = new Vector<>();
		projects = new Vector<>();
	}
	
	
	
	public void addSubscriber(User u) {
		this.subscribers.add(u);
	}
	
	public void addResearch(ResearchPaper research) {
		this.projects.add(research);
		this.makesNewsLetter(research);
	}
	
	public void addRate(int rate) {
		this.rateSum += rate;
		this.rateNumber++;
		this.rating = this.rateSum / this.rateNumber;
	}
	
	private void makesNewsLetter(ResearchPaper res) {
		Message mess = new Message("Hello we make new publication, and you can read our new ResearchPaper " +  this.name, this.editor);
		
		for(User user : subscribers) {
			user.sendNotification(mess);
		}
	}
	
	private int getRate() {
		return this.rating;
	}
	
	private void setRate(int rate) {
		this.rating = rate;
	}
}
