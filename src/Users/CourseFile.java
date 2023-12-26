package Users;
import java.io.Serializable;

/**
 * @author Danial
 * This class is used by Course class to
 * contain information about files used during course
*/
public class CourseFile implements Serializable{
	/**
	 * Fields are containing information about file*/
	private static final long serialVersionUID = -720885203459331518L;
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
	
	public String toString() {
		return this.fileName + " " + this.course;
	}
	
	public int hashCode() {
		return this.fileName.hashCode() + this.course.hashCode() + this.owner.hashCode();  
	}
	
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || this.getClass() != o.getClass()) return false;
		
		CourseFile file = (CourseFile)o;
		return file.fileName.equals(this.fileName) && this.course.equals(this.course) && this.owner.equals(file.owner);
	}
	
	
	
}
