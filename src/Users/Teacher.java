package Users;
import java.util.*;

public class Teacher extends Employee {
	private Faculties faculty;
	private HashMap <Course, Vector <Student>> courses;
	private double rate;
	
	public Teacher(String firstname, String secondname, String ID, Date birthdate, String phoneNumber,
			String login, String password, String email, Gender gender, Address address, Language language, double salary, 
			Faculties faculty) {
		
		super(firstname, secondname, ID, birthdate, phoneNumber,
			login, password, email, gender, address, language, salary);
		
		this.faculty = faculty;	
	}
	
	public void viewStudents() {
		//write
	}
	
	public void putMark(Student s, Course course, double mark) {
		s.getTranscript().addMark(s.getYearOfStudy(), course, mark);
	}
	
	public void sendComplaint() {
		//realize logic URGENCY-LEVEL
	}
	
	public void addCourseFile(Course course, CourseFile file) throws NoAccessToCourseException {
		if (course.getLecturer() == this || course.getPracticeTeacher() == this) {
			course.addFile(file);
		}
		else {
			throw new NoAccessToCourseException("You don't have access to this course");
		}
	}
	
	public Faculties getFaculty() {
		return faculty;
	}
	public HashMap <Course, Vector <Student>> getCourses() {
		return courses;
	}
	public double getRate() {
		return rate;
	}
	public void setRate(double rate) {
		this.rate = rate;
	}
	
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!super.equals(o)) return false;
		if (o == null  || o.getClass() != this.getClass()) return false;
		
		Teacher other = (Teacher)o;
		return this.faculty == other.faculty && this.courses == other.courses
				&& this.rate == other.rate;
	}
	
	public int hashCode() {
		return Objects.hash(super.hashCode(), faculty, courses, rate);
	}
	
}
