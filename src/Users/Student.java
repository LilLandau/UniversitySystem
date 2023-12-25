package Users;
import java.util.*;

public class Student extends User {
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
	
	public void viewCourses() {
		for (Course c: courses) {
			System.out.println(c.getCodeCourse() + " " + c.getNameCourse());
		}
	}
	
	public void viewTranscript () {
		transcript.showInfo();
	}
	
	
	public void viewTeachers() {
		for (Course c: courses) {
			System.out.println(c.getLecturer().getFirstname() + " " + c.getLecturer().getSecondname() 
					+ " - " + c.getNameCourse());
		}
	}
	
	public void rateTeacher(Teacher t, double rate) throws NoAccessToCourseException, TeacherIsNotRatedException {
		if (t.haveStudent(this)) {
			t.setCntRate(t.getCntRate() + 1);
			t.setRate((t.getRate() + rate) / t.getCntRate());
		}
		else {
			throw new NoAccessToCourseException("You don't have access to this teacher");
		}
	}
	
	public void createOrganization(String organizationName) {
		this.headOfOrganization = true;
		Organization org = new Organization(organizationName, this);
		//database.add(org) -- Добавил в конструктор
	}
	
	public boolean isMemberOfOrganization(Organization o) {
		return o.getMembers().contains(this);
	}
	
	public boolean isHeadOfOrganization() {
		return headOfOrganization;
	}
	
	public boolean registerForCourse() {
		//write
		return true;
	}
	
	public Transcript getTranscript() {
		return transcript;
	}
	
	public int getYearOfStudy() {
		return yearOfStudy;
	}
}
