package Users;
import java.io.IOException;
import java.util.*;

import database.Complaint;
import database.DataBase;
/**
 * This class provides teacher's functionality in the system
 * @author Danial
*/

public class Teacher extends Employee {
	private Faculties faculty;
	private Vector <Student> students;
	private HashMap <Course, Vector <Student>> courses = new HashMap<Course, Vector<Student>>();
	private double rating;
	private double rateNumber;
	private double rateSum;
	public Teacher(String firstname, String secondname, String ID, Date birthdate, String phoneNumber,
			String login, String password, String email, Gender gender, Address address, Language language, double salary, 
			Faculties faculty) {
		
		super(firstname, secondname, ID, birthdate, phoneNumber,
			login, password, email, gender, address, language, salary);
		students = new Vector<Student>();
		this.faculty = faculty;	
	}
	
	/**
	 * This method prints all students of teacher
	*/
	public void viewStudents() {
		int i = 1;
		for(Student stu : students) {
			System.out.println(i + ". " + stu.getSecondname() + " " + stu.getFirstname());
			i++;
		}
		
	}
	
	/**
	 * This method puts mark to students marks
	 * @param student, course and mark to put
	*/
	private void putMark(Student s, Course course, double mark) {
		s.getTranscript().addMark(s.getYearOfStudy(), course, mark);
	}
	
	/**
	 * This method sending complaint to teacher
	 * @param teacher as sender, text of the complaint, student and urgency level
	*/
	private void sendComplaint(Teacher sender, String txt, Student stu, UrgencyLevel urglvl) {
		DataBase.addComplaints(new Complaint(sender, txt, stu, urglvl));
	}
	
	public void sendComplaint() throws IOException {
		viewStudents();
		System.out.println("First txt, second stu(number), last UrgencyLevel(1 - Low, 2 - Medium, 3 - High)");
		String txt = reader.readLine();
		String chooseStuStr = reader.readLine();
		int chooseStu = Integer.parseInt(chooseStuStr);
		int urglvl = reader.read() - 48;
		Vector<UrgencyLevel> urglvls = new Vector<UrgencyLevel>();
		urglvls.add(UrgencyLevel.LOW);
		urglvls.add(UrgencyLevel.MEDIUM);
		urglvls.add(UrgencyLevel.HIGH);
		try {
			sendComplaint(this, txt, students.get(chooseStu - 1), urglvls.get(urglvl));
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	/**
	 * This method adds file to course
	 * @param course to which to add file and file itself
	 * @throws NoAccessToCourseException if teacher don't have access to this course
	*/
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
		return rating;
	}
	public void setRate(double rate) {
		this.rating = rate;
	}
	public void rate(double rate) {
		this.rateNumber++;
		this.rateSum += rate;
		this.rating = this.rateSum / this.rateNumber;
	}
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!super.equals(o)) return false;
		if (o == null  || o.getClass() != this.getClass()) return false;
		
		Teacher other = (Teacher)o;
		return this.faculty == other.faculty && this.courses == other.courses
				&& this.rating == other.rating;
	}
	
	public int hashCode() {
		return Objects.hash(super.hashCode(), faculty, courses, rating);
	}
	
	public void mainPage() throws IOException {
		System.out.println("https://wsp.kbtu.kz/" + this.getLogin());
		int chooseOfTeach;
		
		System.out.println("BaseFuctionality (1)");
		System.out.println("Teacher's Functionality (2)");
		
		chooseOfTeach = reader.read();
		if(chooseOfTeach == 1) {
			super.mainPage();
		}else if (chooseOfTeach == 2) {
			
			System.out.println("Put marks      (1)");
			System.out.println("Send Complaint (2)");
			System.out.println("Show Students  (3)");
			chooseOfTeach = reader.read() - 48;
			
			if(chooseOfTeach == 1) {
				this.putMarks();
			}else if(chooseOfTeach == 2) {
				this.sendComplaint();
			}else if(chooseOfTeach == 3) {
				this.viewStudents();
			}
		}
	}
	public void showFullInfo() throws IOException {
		super.showFullInfo();
		System.out.println("Rating: " + this.getRate());
	}
	
	public void putMarks() throws IOException {
		Vector<Course> courses = new Vector<>(); 
		courses.addAll(this.courses.keySet());
		int i = 1;
		int j = 1;
		for(Course cour : courses) {
			System.out.println(i + ". " + cour + ": ");
			for(Student stu : this.courses.get(cour)) {
				System.out.println("\t" + j + ". " + stu.getSecondname() + " " + stu.getFirstname());
			}
		}

		int chooseCour = 0;
		int chooseStu = 0;
		while(true){
			
			int choose;
			System.out.println(String.format("Course(number): %s     (1)", chooseCour));
			System.out.println(String.format("Student(number): %s    (2)", chooseStu));
			System.out.println("Put Mark ->       (3)");
			System.out.println("Back                (4)");
			
			choose = reader.read() - 48;
			
			if(choose == 1) {
				chooseCour = reader.read() - 48;
			}else if(choose == 2) {
				chooseStu = reader.read() - 48;
			}else if(choose == 3) {
				try {
					System.out.println("Mark: ");
					this.putMark(this.courses.get(chooseCour-1).get(chooseStu - 1), courses.get(chooseCour - 1), reader.read());
					System.out.println("Mark puted");
				}catch(Exception e) {
					e.printStackTrace();
				}
			}else if(choose == 4) {
				return;
			}
		}
		
		
	}
}
