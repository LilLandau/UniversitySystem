package database;

import java.util.Comparator;

import Users.User;

public class ComparatorByName implements Comparator<User>{
	public int compare(User o1, User o2) {
		return o1.getSecondname().compareTo(o2.getSecondname());
	}
}
