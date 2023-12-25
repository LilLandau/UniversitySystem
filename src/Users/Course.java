package Users;
import java.io.Serializable;
import java.util.*;

import database.DataBase;

public class Course implements Serializable {
	private static final long serialVersionUID = -8267169132804394841L;
	private Teacher lecturer;
	private Teacher practiceTeacher;
	private String name;
	private String code;
	private int credits;
	private Vector <Course> prerequisites;
	private Vector <CourseFile> courseFiles;
	private Vector <Student> listOfStudents;
	private HashMap <Student, Vector <Boolean>> attendance;
	
	public Course(Teacher lecturer, Teacher practiceTeacher, String name, String code, int credits) {
		this.lecturer = lecturer;
		this.practiceTeacher = practiceTeacher;
		this.name = name;
		this.code = code;
		this.credits = credits;
		this.prerequisites = new Vector <Course>();
		this.courseFiles = new Vector <CourseFile>();
		this.attendance = new HashMap <Student, Vector <Boolean>>();
		this.listOfStudents = new Vector <Student>();
		DataBase.addCourse(this);
	}
	
	public void addStudent(Student s) throws StudentAlreadyOnCourseException {
		if (!listOfStudents.contains(s) && !attendance.containsKey(s)) {
			listOfStudents.add(s);
			attendance.put(s, new Vector <Boolean>());
		}
		else if (!listOfStudents.contains(s) && attendance.containsKey(s)) {
			listOfStudents.add(s);
		}
		else if (listOfStudents.contains(s) && !attendance.containsKey(s)) {
			attendance.put(s, new Vector <Boolean>());
		}
		else {
			throw new StudentAlreadyOnCourseException("Student is already on course");
		}
	}
	
	public void removeStudent(Student s) throws StudentAlreadyOnCourseException {
		if (listOfStudents.contains(s) && attendance.containsKey(s)) {
			listOfStudents.remove(s);
			attendance.remove(s);
		}
		else if (listOfStudents.contains(s) && !attendance.containsKey(s)) {
			listOfStudents.remove(s);
		}
		else if (!listOfStudents.contains(s) && attendance.containsKey(s)) {
			attendance.remove(s);
		}
		else {
			throw new StudentAlreadyOnCourseException("Student is already NOT on course");
		}
	}
	
	public void setLecturer(Teacher t) {
		this.lecturer = t;
	}
	public void setPracticeTeacher(Teacher t) {
		this.practiceTeacher = t;
	}	
	
	public void addFile(CourseFile file) {
		courseFiles.add(file);
	}
	
	public boolean removeFile(CourseFile file) {
		if (courseFiles.contains(file)) {
			courseFiles.remove(file);
			return true;
		}
		return false;
	}
	
	public void showAttendance() {
		for (Map.Entry<Student, Vector <Boolean>> entry: attendance.entrySet()) {
			Student student = entry.getKey();
			Vector <Boolean> dates = entry.getValue();
			int countDate = 0;
			
			for (Boolean date: dates) {
				if (date) countDate++;
			}
			
			System.out.println(student.getFirstname() + " " + student.getSecondname() +
					": " + countDate);
		}
	}
	
	public int getCredits() { return credits; }
	public Teacher getLecturer() { return lecturer; }
	public Teacher  getPracticeTeacher() { return practiceTeacher; }
	public String getNameCourse() { return name; }
	public String getCodeCourse() { return code; }
	public Vector <Course> getPrerequisites() { return prerequisites; }
	public Vector <CourseFile> getCourseFiles() { return courseFiles; }
	public void addPrerequisites(Course course) {
		this.prerequisites.add(course);
	}
	public HashMap <Student, Vector <Boolean>> getAttendance() {
		return attendance;
	}
	public Vector <Student> getListOfStudents() {
		return listOfStudents;
	}
	
	public void showPrerequisitese() {
		System.out.println(this.prerequisites);
	}
	
}
