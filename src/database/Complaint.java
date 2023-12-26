package database;

import java.util.Date;
import java.util.Objects;

import Users.*;

public class Complaint implements Comparable<Complaint>{
	private Teacher sender;
	private String txt;
	private Date date;
	private Student stu;
	private UrgencyLevel urgLvl;
	
	public Complaint(Teacher sender, String txt, Student stu, UrgencyLevel urgLvl) {
		this.sender = sender;
		this.txt = txt;
		this.stu = stu;
		this.date = new Date();
		this.urgLvl = urgLvl;
	}
	
	

	public Teacher getSender() {
		return sender;
	}

	public void setSender(Teacher sender) {
		this.sender = sender;
	}

	public String getTxt() {
		return txt;
	}

	public void setTxt(String txt) {
		this.txt = txt;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Student getStu() {
		return stu;
	}

	public void setStu(Student stu) {
		this.stu = stu;
	}

	public UrgencyLevel getUrgLvl() {
		return urgLvl;
	}

	public void setUrgLvl(UrgencyLevel urgLvl) {
		this.urgLvl = urgLvl;
	}

	public int hashCode() {
		return Objects.hash(date, sender, stu, txt, urgLvl);
	}

	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Complaint other = (Complaint) o;
		return Objects.equals(date, other.date) && Objects.equals(sender, other.sender)
				&& Objects.equals(stu, other.stu) && Objects.equals(txt, other.txt) && urgLvl == other.urgLvl;
	}
	
	public String toString() {
		return this.sender + "\n" + this.urgLvl + "\n" + this.stu + "\n" + this.txt;
	}
	
	public int compareTo(Complaint other) {
		if(this.urgLvl == other.urgLvl) {
			return 0;
		}else if(other.urgLvl == UrgencyLevel.LOW || this.urgLvl == UrgencyLevel.HIGH) {
			return 1;
		}else {
			return -1;
		}
	}
}
