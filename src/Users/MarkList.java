package Users;
import java.util.*;

import database.DataBase;
/**
 * @author Danial
 * This class represents mark list for some student. Used in Transcript
*/

public class MarkList {
	/**
	 * Fields of class represents course for which mark list is made for and vector of marks
	*/
	private Course course;
	private Vector <Double> marks;
	
	public MarkList() {
		this.course = null;
		this.marks = new Vector <Double>();
		DataBase.addMarks(this);
	}
	
	public MarkList(Course course) {
		this.course = course;
		this.marks = new Vector <Double>();
	}
	
	/**
	 * This method shows marks
	*/
	public void showMarks() {
		if (!marks.isEmpty()) {
			for (Double mark: marks) {
				System.out.print(mark + " ");
			}
			System.out.println();
		}
		else {
			System.out.println("Mark List is empty");
		}
	}
	
	/**
	 * This method is adding mark to mark list
	 * @param mark
	*/
	public void addMark(double mark) {
		mark = (Double)mark;
		marks.add(mark);
	}
	
	
	public Vector <Double> getMarkList() {
		return marks;
	}
	
	public void setCourse(Course course) {
		this.course = course;
	}
	
	public String getMarks() {
		String s = "";
		for (Double mark: marks) {
			s += mark + " ";
		}
		
		return s;
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
