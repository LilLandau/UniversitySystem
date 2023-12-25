package database;

import java.util.Comparator;

import Users.User;

public class ComparatorById implements Comparator<User>{
	public int compare(User o1, User o2) {
		return o1.getID().compareTo(o2.getID());
	}
}
