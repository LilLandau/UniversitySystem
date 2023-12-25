package database;

import java.util.Comparator;

import Users.Student;

public class ComparatorByGPA implements Comparator<Student>{
	public int compare(Student o1, Student o2) {
		if(o1.getTranscript().getAverageGPA() > o2.getTranscript().getAverageGPA()) {
			return 1;
		}else if(o1.getTranscript().getAverageGPA() < o2.getTranscript().getAverageGPA()) {
			return -1;
		}else {
			return 0;
		}
	}
}
