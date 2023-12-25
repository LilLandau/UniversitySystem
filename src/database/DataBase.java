package database;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Vector;

import Users.Course;
import Users.MarkList;
import Users.Organization;
import Users.Transcript;
import Users.User;
import news.News;
import news.NewsBlank;

public class DataBase implements Serializable{
	private static final long serialVersionUID = 1L;

	private static DataBase database;
	
	public static DataBase 	getDataBase() {
		if(database == null) {
			database = new DataBase();
		}
		
		return database;
	}
	
	public static DataBase setDataBase(Object obj) {
	
		database = (DataBase) obj;
		return database;
	}
	private DataBase() { 
		
	}
	
	private static Vector<User> users = new Vector<User>();
	
	
	private static Vector<Course> courses = new Vector<Course>();
	
	private static Vector<MarkList> marks = new Vector<>();

	private static Vector<NewsBlank> news = News.getMessages(); 
	
	private static Vector<Transcript> transcripts = new Vector<>();
	
	private static Vector<Organization> orgs = new Vector<>();
//	private static Vector<Messenger> messengers = new Vector<Messenger>(); // Доделаю
	
	
	public static Vector<User> getUsers(){
		return users;
	}
	
	public static void addUser(User user) {
		users.add(user);
	}
	
	public static Vector<Course> getCourses(){
		return courses;
	}
	
	public static void addCourse(Course course) {
		courses.add(course);
	}
	
	public static void addMarks(MarkList mark) {
		marks.add(mark);
	}
	
	public static Vector<MarkList> getMarks(){
		return marks;
	}
	
	public static Vector<Transcript> getTranscripts(){
		return transcripts;
	}
	
	public static void addTranscripts(Transcript transcript) {
		transcripts.add(transcript);
	}
	
	public static void addOrg(Organization org) {
		orgs.add(org);
	}
	
	public static Vector<Organization> getOrgs() {
		return orgs;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

// 	СОХРАНЕНИЕ И ЗАГРУЗКА ДАННЫХ, НАДО В КАЖДОМ КОНСТРУКТОРЕ БУДЕТ ПРОПИСАТЬ, СОХРАНЕНИЕ ДАННЫХ В БД
	
//	public static void saveMessengers() 
//									throws IOException{
//		FileOutputStream fos = new FileOutputStream("./save/messengers.ser");
//		ObjectOutputStream oos = new ObjectOutputStream(fos);
//		oos.writeObject(messengers);
//		fos.close();
//	}
//	@SuppressWarnings("unchecked")
//	public static void loadMessengers() throws IOException,
//					ClassNotFoundException{
//		FileInputStream fis = new FileInputStream("./save/messengers.ser");
//		ObjectInputStream ois = new ObjectInputStream(fis);
//		messengers = (Vector<Messenger>) ois.readObject();
//		ois.close();
//	}
//	
	
	

	
	public static void save() throws IOException {
		saveNews();
		saveMarks();
		saveCourses();
		saveUsers();
		saveTranscripts();
		
		// не забываем добавлять сюда сэйвы
	}
	public static void load() throws IOException, ClassNotFoundException {
		loadNews();
		loadMarks();
		loadCourses();
		loadUsers();
		loadTranscripts();
		
		// не забываем добавлять сюда загрузки
	}
	
	
	public static void saveNews() throws IOException{
		FileOutputStream fos = new FileOutputStream("./save/news.ser");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		news = News.getMessages();
		oos.writeObject(news);
		fos.close();
	}
	@SuppressWarnings("unchecked")
	public static void loadNews() throws IOException,
					ClassNotFoundException{
		FileInputStream fis = new FileInputStream("./save/news.ser");
		ObjectInputStream ois = new ObjectInputStream(fis);
		news = (Vector<NewsBlank>) ois.readObject();
		News.setMessages(news);
		ois.close();
	}
	
	
	public static void saveMarks() 
									throws IOException{
		FileOutputStream fos = new FileOutputStream("./save/marks.ser");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(marks);
		fos.close();
	}
	@SuppressWarnings("unchecked")
	public static void loadMarks() throws IOException,
					ClassNotFoundException{
		FileInputStream fis = new FileInputStream("./save/marks.ser");
		ObjectInputStream ois = new ObjectInputStream(fis);
		marks = (Vector<MarkList>) ois.readObject();
		ois.close();
	}
	
	
	public static void saveCourses() 
									throws IOException{
		FileOutputStream fos = new FileOutputStream("./save/courses.ser");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(courses);
		fos.close();
	}
	@SuppressWarnings("unchecked")
	public static void loadCourses() throws IOException,
					ClassNotFoundException{
		FileInputStream fis = new FileInputStream("./save/courses.ser");
		ObjectInputStream ois = new ObjectInputStream(fis);
		courses = (Vector<Course>) ois.readObject();
		ois.close();
	}
	
	public static void saveUsers() 
									throws IOException{
		FileOutputStream fos = new FileOutputStream("./save/users.ser");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(users);
		fos.close();
	}
	@SuppressWarnings("unchecked")
	public static void loadUsers() throws IOException,
					ClassNotFoundException{
		FileInputStream fis = new FileInputStream("./save/users.ser");
		ObjectInputStream ois = new ObjectInputStream(fis);
		users = (Vector<User>) ois.readObject();
		ois.close();
	}
	
	public static void saveTranscripts() 
									throws IOException{
		FileOutputStream fos = new FileOutputStream("./save/transcripts.ser");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(transcripts);
		fos.close();
	}
	@SuppressWarnings("unchecked")
	public static void loadTranscripts() throws IOException,
					ClassNotFoundException{
		FileInputStream fis = new FileInputStream("./save/transcipts.ser");
		ObjectInputStream ois = new ObjectInputStream(fis);
		transcripts = (Vector<Transcript>) ois.readObject();
		ois.close();
	}
	
	
	
	
	
	
	
	

	
	
	
	
	
}
