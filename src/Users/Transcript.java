package Users;
import java.util.*;
import java.util.Map.Entry;

import database.DataBase;

public class Transcript {
	private double averageGPA;
	private int totalCredits;
	private HashMap <Integer, HashMap <Course, MarkList>> semesters;
	
	public Transcript() {
		this.averageGPA = 0.0;
		this.totalCredits = 0;
									//yearOfStudy
		this.semesters = new HashMap <Integer, HashMap <Course, MarkList>>();
		DataBase.addTranscripts(this);
	}
	
	public boolean addMark(Integer semester, Course course, double mark) {
		HashMap <Course, MarkList> courseInSemester = semesters.get(semester);
		if (courseInSemester == null) return false;
		MarkList markList = courseInSemester.get(course);
		markList.addMark(mark);
		return true;
	}
	
	public void addCourse(Integer yearOfStudy, Course course) {
		HashMap <Course, MarkList> cur = new HashMap <>();
		cur.put(course, new MarkList(course));
		semesters.put(yearOfStudy, cur);
	}
	
	public double getAverageGPA() {
		calculateAverageGPA();
		return averageGPA;
	}
	
	public int getTotalCredits() {
		calculateTotalCredits();
		return totalCredits;
	}
	
	private void calculateAverageGPA() {
		double sumOfMarks = 0.0;
		int sumOfCredits = 0;
		for (int i = 0; i < semesters.size(); i++) {
			for (Entry <Course, MarkList> cur: semesters.get(i).entrySet()) {
				sumOfMarks += (cur.getValue().getTotalMark() * cur.getKey().getCredits());
				sumOfCredits += cur.getKey().getCredits();
			}
		}
		
		averageGPA = sumOfMarks / sumOfCredits;
	}
	
	private void calculateTotalCredits() {
		for (int i = 0; i < semesters.size(); i++) {
			for (Entry <Course, MarkList> cur: semesters.get(i).entrySet()) {
				totalCredits += cur.getKey().getCredits();
			}
		}
	}
	
	public HashMap <Integer, HashMap <Course, MarkList>> getSemesters() {
		return semesters;
	}
	
	public void showInfo() {
		if (!semesters.isEmpty()) {
			System.out.println("The transcript is Empty");
		}
		else {
			for (int i = 0; i < semesters.size(); i++) {
				System.out.println(i + "semster:");
				for (Entry <Course, MarkList> cur: semesters.get(i).entrySet()) {
					System.out.println(cur.getKey().getNameCourse() + ": " + cur.getValue().getMarks());
					System.out.println("Total mark: " + cur.getValue().getTotalMark());
				}
			}
		}
	}
}
