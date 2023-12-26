package database;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Vector;

import Users.Course;
import Users.Dean;
import Users.Employee;
import Users.Faculties;
import Users.MarkList;
import Users.Organization;
import Users.Student;
import Users.Teacher;
import Users.Transcript;
import Users.User;
import messenger.Chat;
import messenger.Message;
import messenger.Messenger;
import news.News;
import news.NewsBlank;
import researcher.Journal;

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
		
	private static boolean registration;
	
	
	
	private static Vector<Journal>  journals = new Vector<>();
	
	private static Vector<User> users = new Vector<User>();

	private static Vector<Course> courses = new Vector<Course>();
	
	private static Vector<MarkList> marks = new Vector<>();

	private static Vector<NewsBlank> news = News.getMessages(); 
	
	private static Vector<Transcript> transcripts = new Vector<>();
	
	private static Vector<Organization> orgs = new Vector<>();
	
	private static Vector<Messenger> messengers = new Vector<Messenger>();

	private static Vector<Map.Entry<Student, Course>> requestToRegistration = new Vector<Map.Entry<Student, Course>>(); 
	
	private static Vector<Complaint> complaints = new Vector<Complaint>();
	
	
	
	public static Vector<Dean> getDeans(){
		Vector<Dean> deans = new Vector<>();
		for(User u : users) {
			if(u instanceof Dean) {
				deans.add((Dean) u);
			}
		}
		return deans;
		
	}
	
	public static Vector<Entry<Student,Course>> getReqToReg(){
		return requestToRegistration;
	}
	
	@SuppressWarnings("unchecked")
	public static void addReqToReg(Student s, Course c) {
		((Map) requestToRegistration).put(s, c);
	}
	
	public static void deleteFromReqToReg(Student s, Course c) {
		requestToRegistration.add(Map.entry(s, c));
	}
	
	public static Vector<Complaint> getComplaints(){
		return complaints;
	}
	
	public static Vector<Complaint> getComplaintsByFaculty(Faculties fac){
		Vector<Complaint> compls = new Vector<Complaint>();
		for(Complaint compl : complaints) {
			if(compl.getStu().getFaculty().equals(fac)) {
				compls.add(compl);
			}
		}
		return compls;
	}
	
	public static void addComplaints(Complaint complaint) {
		complaints.add(complaint);
	}
	public static void deleteComplaints(Complaint complaint) {
		complaints.remove(complaint);
	}
	
	
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
	
	public static void addMessenger(Messenger mes) {
		messengers.add(mes);
	}
	
	public static boolean getRegistration() {
		return registration;
	}
	
	public static void setRegistration(boolean status) {
		registration = status;
	}
	
	
	
	
	
	public static Vector<Employee> getEmployees(){
		Vector<Employee> onlyEmp= new Vector<>();
		for(User u: users) {
			if(u instanceof Employee) {
				onlyEmp.add((Employee) u);
			}
		}
		return onlyEmp;
	}
	
	public static Vector<Student> getStudents(){
		Vector<Student> onlyStu = new Vector<>();
		for(User u : users) {
			if(u instanceof Student) {
				onlyStu.add((Student)u);
			}
		}
		return onlyStu;
	}
	
	public static Vector<Teacher> getTeacher(){
		Vector<Teacher> onlyTeach = new Vector<>();
		for(User u : users) {
			if(u instanceof Teacher) {
				onlyTeach.add((Teacher)u);
			}
			
		}
		return onlyTeach;
	}
	
	public static Vector<Student> getStudentByGPA(){
		Vector<Student> bygpa = getStudents();
		bygpa.sort(new ComparatorByGPA());
		return bygpa;
	}

	public static Vector<User> getByName(){
		Vector<User> user = new Vector<>();
		user.addAll(users);
		user.sort(new ComparatorByName());
		return user;
	}
	
	public static Vector<Journal> getJournal(){
		return journals;
	}
	
// 	СОХРАНЕНИЕ И ЗАГРУЗКА ДАННЫХ, НАДО В КАЖДОМ КОНСТРУКТОРЕ БУДЕТ ПРОПИСАТЬ, СОХРАНЕНИЕ ДАННЫХ В БД
	
	public static void saveMessengers() 
									throws IOException{
		FileOutputStream fos = new FileOutputStream("./save/messengers.ser");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(messengers);
		fos.close();
	}
	@SuppressWarnings("unchecked")
	
	public static void loadMessengers() throws IOException,
					ClassNotFoundException{
		FileInputStream fis = new FileInputStream("./save/messengers.ser");
		ObjectInputStream ois = new ObjectInputStream(fis);
		messengers = (Vector<Messenger>) ois.readObject();
		ois.close();
	}
	
	public static void save() throws IOException {
		saveNews();
		saveMarks();
		saveCourses();
		saveUsers();
		saveTranscripts();
		saveJournals();
		saveRequestToRegistration();
		
		// не забываем добавлять сюда сэйвы
	}
	
	public static void load() throws IOException, ClassNotFoundException {
		loadNews();
		loadMarks();
		loadCourses();
		loadUsers();
		loadTranscripts();
		loadJournals();
		loadRequestToRegistration();
		
		// не забываем добавлять сюда загрузки
	}


	public static void saveComplaints() throws IOException{
		FileOutputStream fos = new FileOutputStream("./save/complaints.ser");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(marks);
		fos.close();
	}
	@SuppressWarnings("unchecked")
	public static void loadComplaints() throws IOException,
					ClassNotFoundException{
		FileInputStream fis = new FileInputStream("./save/complaints.ser");
		ObjectInputStream ois = new ObjectInputStream(fis);
		complaints = (Vector<Complaint>) ois.readObject();
		ois.close();
	}
	
	public static void saveRequestToRegistration() throws IOException{
		FileOutputStream fos = new FileOutputStream("./save/RequestToReg.ser");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(requestToRegistration);
		fos.close();
	}
	
	@SuppressWarnings("unchecked")
	public static void loadRequestToRegistration() throws IOException, ClassNotFoundException{
		FileInputStream fis = new FileInputStream("./save/RequestToReg.ser");
		ObjectInputStream ois = new ObjectInputStream(fis);
		requestToRegistration = (Vector<Entry<Student, Course>>) ois.readObject();
		ois.close();
		
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
	public static void saveJournals() throws IOException{
		FileOutputStream fos = new FileOutputStream("./save/journals.ser");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(journals);
		fos.close();
	}
	@SuppressWarnings("unchecked")
	public static void loadJournals() throws IOException,
					ClassNotFoundException{
		FileInputStream fis = new FileInputStream("./save/journals.ser");
		ObjectInputStream ois = new ObjectInputStream(fis);
		journals = (Vector<Journal>) ois.readObject();
		ois.close();
	}
}
