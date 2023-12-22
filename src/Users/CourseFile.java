package Users;

public class CourseFile {
	private String fileName;
	private Course course;
	private Teacher owner;
	
	public CourseFile(String fileName, Course course, Teacher owner) {
		this.fileName = fileName;
		this.course = course;
		this.owner = owner;
	}
	
	public Teacher getOwner() { return owner; }
	public Course getCourse() { return course; }
	public String getName() { return fileName; }
}
