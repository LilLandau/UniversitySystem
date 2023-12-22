package Users;
import java.util.*;

public class Course {
	private Teacher lecturer;
	private Teacher practiceTeacher;
	private String name;
	private String code;
	private int credits;
	private Vector <Course> prerequisites;
	private Vector <CourseFile> courseFiles;
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
	
}
