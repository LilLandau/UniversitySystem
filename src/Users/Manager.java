package Users;
import java.util.Date;
import java.io.IOException;
import java.util.*;

import database.DataBase;
import messenger.Message;
/**
 * @author Danial
 * This class is made for manager functionality. It's managing all study process
 * */

public class Manager extends Employee {

	public Manager(String firstname, String secondname, String ID, Date birthdate, String phoneNumber, String login,
			String password, String email, Gender gender, Address address, Language language, double salary) {
		super(firstname, secondname, ID, birthdate, phoneNumber, login, password, email, gender, address, language, salary);
	}
	
	/**
	 * This method adds student to course
	 * @param student and course
	 * @throws StudentAlreadyOnCourseException if student is already on course and UndefinedUserException if user is undefined
	 */
	public void addStudentToCourse(Student s, Course c) throws StudentAlreadyOnCourseException, UndefinedUserException {
		if (DataBase.getCourses().contains(c) && DataBase.getUsers().contains(s)) {
			c.addStudent(s);
			s.addCourse(c);
		}
		else {
			throw new UndefinedUserException("Undefined user");
		}
	}
	
	/**
	 * This method removes student from course
	 * @param student and course
	 * @throws StudentAlreadyOnCourseException if student is already removed from course and UndefinedUserException if user is undefined
	 */
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
	
	/**
	 * This method is approving registration only for 1 student
	 * @param student and course
	*/
	private void approveRegistration(Student s, Course c){
		try {
			this.addStudentToCourse(s, c);
			DataBase.getReqToReg().remove(Map.entry(s, c));
			s.sendNotification(new Message("You are request approved(For registration to course " + c.getNameCourse()+ ")", this));
		} catch (StudentAlreadyOnCourseException e) {
			e.printStackTrace();
		} catch (UndefinedUserException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * This method is approving registration for all students
	*/
	public void approveRegistration() throws IOException {
		Vector<Map.Entry<Student, Course>> request = DataBase.getReqToReg();
		int i = 1;
		for(Map.Entry<Student, Course> itr : request) {
			System.out.println(i + ". " + itr.getKey().getFirstname() 
					+ " " + itr.getKey().getSecondname() + " " +itr.getValue().getNameCourse() );
		}
		String chooseStr;
		int choose;
		int appOrNo;
		System.out.println("If you want to approve, enter index and 1, if refuse, index and 0");
		reader.read();
		chooseStr = reader.readLine();
		choose = Integer.parseInt(chooseStr);
		appOrNo = reader.read() - 48;
		
		Student s = request.get(choose - 1).getKey();
		Course c = request.get(choose - 1).getValue();
		if(appOrNo == 1) {
			this.approveRegistration(s, c);
		}else {
			DataBase.deleteFromReqToReg(s, c);
			s.sendNotification(new Message("Your request wasn't approved to course " + c.getNameCourse(), this));
		}
	}
	
	
	public void mainPage() throws IOException {
		System.out.println("https://wsp.kbtu.kz/" + this.getLogin());
		int chooseOfTeach;
		
		System.out.println("BaseFuctionality (1)");
		System.out.println("Manager's Functionality (2)");
		
		chooseOfTeach = reader.read();
		if(chooseOfTeach == 1) {
			super.mainPage();
		}else if (chooseOfTeach == 2) {
			
			System.out.println("Approve Registration       (1)");
			System.out.println("Add student      		   (2)");
			System.out.println("Delete Student             (3)");
			System.out.println("Assign Course to Teacher   (4)");
			chooseOfTeach = reader.read() - 48;
			
			if(chooseOfTeach == 1) {
				this.approveRegistration();
			}else if(chooseOfTeach == 2) {
				// дописать
			}
		}
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
