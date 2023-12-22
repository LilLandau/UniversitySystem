package Users;
import java.util.*;

public class MarkList {
	private Course course;
	private Vector <Double> marks;
	
	public MarkList() {
		this.course = null;
		this.marks = new Vector <Double>();
	}
	
	public MarkList(Course course) {
		this.course = course;
		this.marks = new Vector <Double>();
	}
	
	public void addMark(double mark) {
		mark = (Double)mark;
		marks.add(mark);
	}
	
	
	public Vector <Double> getMarks() {
		return marks;
	}
	
	public void setCourse(Course course) {
		this.course = course;
	}
	
	public Course getCourse() {
		return course;
	}
	
	public double getTotalMark() {
		Double total = 0.0;
		for (Double mark: marks) {
			total += mark;
		}
		
		return total;
	}
}
