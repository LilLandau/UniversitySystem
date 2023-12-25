package Users;
import java.util.Date;
import java.util.*;

import database.DataBase;

public class Manager extends Employee {

	public Manager(String firstname, String secondname, String ID, Date birthdate, String phoneNumber, String login,
			String password, String email, Gender gender, Address address, Language language, double salary) {
		super(firstname, secondname, ID, birthdate, phoneNumber, login, password, email, gender, address, language, salary);
	}
	
	public void addStudentToCourse(Student s, Course c) throws StudentAlreadyOnCourseException, UndefinedUserException {
		if (DataBase.getCourses().contains(c) && DataBase.getUsers().contains(s)) {
			c.addStudent(s);
		}
		else {
			throw new UndefinedUserException("Undefined user");
		}
	}
	
	public void removeStudentFromCourse(Student s, Course c) throws StudentAlreadyOnCourseException, UndefinedUserException {
		if (DataBase.getCourses().contains(c) && DataBase.getUsers().contains(s) && c.getListOfStudents().contains(s)) {
			c.removeStudent(s);
		}
		else {
			throw new UndefinedUserException("Undefined user");
		}
	}
	
	public void setLecturerToCourse(Teacher t, Course c) throws UndefinedUserException {
		if (DataBase.getCourses().contains(c) && DataBase.getUsers().contains(t)) {
			c.setLecturer(t);
		}
		else {
			throw new UndefinedUserException("Undefined user");
		}
	}
	
	public void setPracticeTeacherToCourse(Teacher t, Course c) throws UndefinedUserException {
		if (DataBase.getCourses().contains(c) && DataBase.getUsers().contains(t)) {
			c.setLecturer(t);
		}
		else {
			throw new UndefinedUserException("Undefined user");
		}
	}
	
	public void approveRegistration() {
		//to write it
	}
	
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || this.getClass() != o.getClass()) return false;
		
		Manager m = (Manager)o;
		return this.getID().equals(m.getID());
	}
	
	public int hashCode() {
		return Objects.hash(this.getID(), this.getSalary());
	}
	
}
