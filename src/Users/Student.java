package Users;
import java.io.IOException;
import java.util.*;

import database.DataBase;
/**
 * This class represents students as users in university system
 * @author Danial */

public class Student extends User {
	/**
	 * These fields are describing the students information
	*/
	private int yearOfStudy;
	private double GPA;
	private int credits;
	private Faculties faculty;
	private Degree degree = Degree.BACHELOR;
	private Transcript transcript;
	private Vector <Course> courses;
	private boolean headOfOrganization;
	
	public Student(String firstname, String secondname, String ID, Date birthdate, String phoneNumber,
			String login, String password, String email, Gender gender, Address address, Language language,
			int yearOfStudy, Faculties faculty) {
		
		super(firstname, secondname, ID, birthdate, phoneNumber,
				login, password, email, gender, address, language);
		
		this.yearOfStudy = yearOfStudy;
		this.faculty = faculty;
		
		this.transcript = new Transcript();
		this.courses = new Vector <Course>();
		this.headOfOrganization = false;
	}
	
	/**
	 * This method adds course to enroll
	 * @param course to add
	*/
	public void addCourse(Course c) {
		courses.add(c);
	}
	
	/**
	 * This method prints all courses to enroll
	*/
	public void viewCourses() {
		for (Course c: courses) {
			System.out.println(c.getCodeCourse() + " " + c.getNameCourse());
		}
	}
	
	/**
	 * This method prints transcript
	*/
	public void viewTranscript () {
		this.transcript.showInfo();
	}
	
	/**
	 * This method prints all teachers of all courses that enrolling
	*/
	public void viewTeachers() {
		for (Course c: courses) {
			System.out.println(c.getLecturer().getFirstname() + " " + c.getLecturer().getSecondname() 
					+ " - " + c.getNameCourse());
		}
	}
	
	/**
	 * This method made for rating teacher in system
	 * @param teacher to rate and rate itself
	*/
	private void rateTeacher(Teacher t, double rate) {
		t.rate(rate);
	}
		
	public void rateTeacher() throws IOException {
		Vector<Course> courses = DataBase.getCourses();
		int i = 1;
		
		for(Course cour : courses) {
			System.out.println(i + ". " + cour.getLecturer().getFirstname() + " " + cour.getLecturer().getSecondname());
			i++;
		}
		
		int chooseCour = 0;
		System.out.println("Choose Teacher(Number): ");
		chooseCour = reader.read() - 48;
		System.out.println("Your Rate: ");
		reader.readLine();
		String ratingstr = reader.readLine();
		double rating = Double.parseDouble(ratingstr);
		this.rateTeacher(courses.get(chooseCour - 1).getLecturer(), rating);
		registerForCourse(courses.get(chooseCour - 1));
	}
	
	/**
	 * This method allows us to create an organization
	 * @param name of organization
	*/
	public void createOrganization(String organizationName) {
		this.headOfOrganization = true;
		Organization org = new Organization(organizationName, this);
	}
	
	/**
	 * This method checks is student organization's member
	 * @param organization
	 * @return answer in boolean type
	*/
	public boolean isMemberOfOrganization(Organization o) {
		return o.getMembers().contains(this);
	}
	
	/**
	 * This method checks is student head of organization
	 * @return answer in boolean type
	*/
	public boolean isHeadOfOrganization() {
		return headOfOrganization;
	}
	
	/**
	 * This method provides us to registration
	 * @param course to register
	*/
	private void registerForCourse(Course c) {
		if(!DataBase.getRegistration() || this.credits + c.getCredits() > 21 || this.courses.contains(c)) { 
			System.out.println("Sending request is not possible");
		}else {
			DataBase.addReqToReg(this, c);
			System.out.println("Request was send");
		}	
	}
	
	public void regToCourse() throws IOException {
		Vector<Course> courses = DataBase.getCourses();
		int i = 1;
		
		for(Course cour : courses) {
			System.out.println(i + ". " + cour);
			i++;
		}
		
		int chooseCour = 0;
		System.out.println("Choose Course(Number): ");
		chooseCour = reader.read() - 48;
		registerForCourse(courses.get(chooseCour - 1));
	}
	
	
	public Transcript getTranscript() {
		return transcript;
	}
	
	public int getYearOfStudy() {
		return yearOfStudy;
	}
	
	
	
	
	public void mainPage() throws IOException {
		while(true) {
			System.out.println("https://wsp.kbtu.kz/" + this.getLogin());
			System.out.println("LNG: " + this.getLanguage());
			int chooseOfStu;
			System.out.println("BaseFuctionality           (1)");
			System.out.println("Student's Functionality    (2)");
			System.out.println("Go Back                    (3)");
			
			chooseOfStu = reader.read();
			if(chooseOfStu == 1) {
				super.mainPage();
			}else if (chooseOfStu == 2) {
				System.out.println("https://wsp.kbtu.kz/" + this.getLogin());
				System.out.println("LNG: " + this.getLanguage());
				System.out.println("Registrate to Course    (1)");
				System.out.println("Rate the Teacher        (2)");
				System.out.println("Check the Transcript    (3)");
				System.out.println("Show Courses            (4)");
				System.out.println("View Teachers           (5)");
				System.out.println("Go back                 (6)");
				chooseOfStu = reader.read() - 48;
				
				if(chooseOfStu == 1) {
					this.regToCourse();
				}else if(chooseOfStu == 2) {
					this.rateTeacher();
				}else if(chooseOfStu == 3) {
					this.showFullInfo();
				}else if(chooseOfStu == 4) {
					this.viewCourses();
				}else if(chooseOfStu == 5) {
					this.viewTeachers();
				}else if(chooseOfStu == 6) {
					break;
				}
			}	
			reader.readLine();
		}
	}

	public Faculties getFaculty() {
		return faculty;
	}

	public void setFaculty(Faculties faculty) {
		this.faculty = faculty;
	}
}
