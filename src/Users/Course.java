package Users;
import java.io.Serializable;
import java.util.*;

import database.DataBase;

/**
 * @author Danial
 * This class contains all information about some
 * courses taken at the university*/
public class Course implements Serializable{
	/**
	 * Fields are representing all information about course
	 * including prerequisites, course files, list of students
	 * and attendance calendar
	 */
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
		DataBase.addCourse(this);
	}
	
	/**
	 * This method adds student to course. Used by manager
	 * @param student who enrolls in the course
	 * @throws StudentAlreadyOnCourseException if student is already on course
	 * 
	 */
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
	
	/**
	 * This method removes student from course. Used by manager
	 * @param student who kicked from course
	 * @throws StudentAlreadyOnCourseException if student is already removed from course
	 * 
	 */
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
	
	/**
	 * This method adds file to course. Used by Teacher
	 * @param file for adding
	 */
	public void addFile(CourseFile file) {
		courseFiles.add(file);
	}
	
	/**
	 * This method removes file from course. Used by Teacher
	 * @param file for removing
	 */
	public boolean removeFile(CourseFile file) {
		if (courseFiles.contains(file)) {
			courseFiles.remove(file);
			return true;
		}
		return false;
	}
	
	/**
	 * This method shows attendance statistics about every student
	 */
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

	public void setLecturer(Teacher t) {
		this.lecturer = t;
	}
	public void setPracticeTeacher(Teacher t) {
		this.practiceTeacher = t;
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
	
	/**
	 * This method shows prerequisites for current course
	 */
	public void showPrerequisitese() {
		System.out.println(this.prerequisites);
	}
	
}
