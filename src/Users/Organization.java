package Users;
import java.util.*;

import database.DataBase;

public class Organization {
	private String name;
	private int amountOfMembers;
	private Student president;
	private Vector <Student> members;
	
	protected Organization(String name, Student president) {
		this.name = name;
		this.president = president;
		
		this.members = new Vector <Student>();
		members.add(president);
		this.amountOfMembers = members.size();
		DataBase.addOrg(this);
	}
	
	public String getName() {
		return name;
	}
	public Student getPresident() {
		return president;
	}
	public Vector <Student> getMembers() {
		return members;
	}
	public int getAmountOfMembers() {
		return amountOfMembers;
	}
	
	public String getInfo() {
		return "Organization name: " + name + "/nPresident name: " + president.getFirstname()
				+ " " + president.getSecondname() + "/nAmount of Members: " + amountOfMembers; 
	}
	
	public void addStudent(Student s) throws StudentAlreadyInOrganizationException {
		if (members.contains(s)) {
			throw new StudentAlreadyInOrganizationException("The student is already a member of the organization");
		}
		members.add(s);
	}
	
	public void removeStudent(Student s) throws StudentIsNotInOrganizationException {
		if (!members.contains(s)) {
			throw new StudentIsNotInOrganizationException("The student is not in organization");
		}
		members.remove(s);
	}
}
