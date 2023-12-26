package news;

import java.io.Serializable;
import java.util.Date;

import Notifications.Notifications;
import Users.Employee;

public class NewsBlank implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -720693964450125444L;
	private String tittle;
	private String fullTxt;
	private Employee author;
	private TopicOfNews topic;
	private Date date;
	
	public NewsBlank(String tittle, String fullTxt, Employee author, TopicOfNews topic) {
		this.tittle = tittle;
		this.fullTxt = fullTxt;
		this.author = author;
		this.setTopic(topic);
		this.date = new Date();
	}

	public String getTittle() {
		return tittle;
	}

	public void setTittle(String tittle) {
		this.tittle = tittle;
	}

	public String getFullTxt() {
		return fullTxt;
	}

	public void setFullTxt(String fullTxt) {
		this.fullTxt = fullTxt;
	}

	public Employee getAuthor() {
		return author;
	}

	public void setAuthor(Employee author) {
		this.author = author;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "\t" + this.tittle + "\n" + authoEnter(this.fullTxt) + "\n\n"
				+ this.author + "\t" + this.date + "\n" + "-".repeat(20);
	}
	
	public String authoEnter(String txt) {
		String str = "";
		for(int i = 0; i < txt.length(); i++) {
			str += txt.charAt(i);
			if(i%30 > 25 && txt.charAt(i) == ' ') {
				str += "\n";
			}
			
		}
		return str;
	}

	public TopicOfNews getTopic() {
		return topic;
	}

	public void setTopic(TopicOfNews topic) {
		this.topic = topic;
	}
	
	
	public int hashCode() {
		return this.tittle.hashCode() + this.author.hashCode() + this.date.hashCode();
 	}
	
	public boolean equlas(Object o) {
		if ( this == o ) return true;
		if ( o == null || this.getClass() != o.getClass()) return false;
		NewsBlank newsBlank = (NewsBlank) o;
		return newsBlank.tittle == this.tittle && newsBlank.author == this.author && newsBlank.date.equals(this.date);	
	}
	
}
