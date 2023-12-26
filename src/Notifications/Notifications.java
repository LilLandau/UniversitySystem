package Notifications;

import java.util.Vector;

import Users.User;
import messenger.Message;

public class Notifications {
	private User owner;
	private Vector<Message> messages;
	
	public Notifications(User owner) {
		this.owner = owner;
		this.messages = new Vector<>();
	}
	
	public void addMessage(Message mess) {
		this.messages.add(mess);
	}
	
	public void showNotifications() {
		System.out.println("https://wsp.kbtu.kz/" + owner.getLogin() +"/notifications");
		System.out.println("\n\n\t  My Notifications\n\n");
		for(Message mess : messages) {
			System.out.println(mess);
		}
	}
		
	public void clearNotify() {
		this.messages.clear();
	}
	
	public String toString() {
		return "It is notification of " + this.owner.getLogin();
	}
	
	public int hashCode() {
		return this.owner.hashCode() + this.messages.hashCode();
 	}
	
	public boolean equlas(Object o) {
		if ( this == o ) return true;
		if ( o == null || this.getClass() != o.getClass()) return false;
		Notifications noty = (Notifications) o;
		return noty.owner == this.owner;	
	}
}
