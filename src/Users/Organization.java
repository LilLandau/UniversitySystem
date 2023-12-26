package Users;
import java.util.*;

import database.DataBase;
/**
 * @author Danial
 * This class is made for creating students organizations
*/
public class Organization {
	/**
	 * Fields are describing organization
	*/
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
	
	/**
	 * This method is adding student to organization
	 * @param student to add
	 * @throws StudentAlreadyInOrganizationException if student is already in organization
	*/
	public void addStudent(Student s) throws StudentAlreadyInOrganizationException {
		if (members.contains(s)) {
			throw new StudentAlreadyInOrganizationException("The student is already a member of the organization");
		}
		members.add(s);
	}
	
	/**
	 * This method is removing student from organization
	 * @param student to remove
	 * @throws StudentAlreadyInOrganizationException if student is already removed from organization
	*/
	public void removeStudent(Student s) throws StudentIsNotInOrganizationException {
		if (!members.contains(s)) {
			throw new StudentIsNotInOrganizationException("The student is not in organization");
		}
		members.remove(s);
	}
}
