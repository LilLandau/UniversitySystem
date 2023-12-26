package Users;
import java.util.*;
/**
 * @author Danial
 * This class represents graduated students (masters or ph.ds).
 * By default every graduated student is researcher
 * */

public class GraduatedStudent extends Student {
	/**
	 * The fields are researcher, which gives us a researcher functionality,
	 * degree of student and his supervisor
	 * */
	private ResearcherDecorator researcher;
	private Degree degree;
	private ResearcherDecorator supervisor;
	
	public GraduatedStudent(String firstname, String secondname, String ID, Date birthdate, String phoneNumber,
			String login, String password, String email, Gender gender, Address address, Language language,
			int yearOfStudy, Faculties faculty) {
		
		super(firstname, secondname, ID, birthdate, phoneNumber, login, password, email, gender, address, language, yearOfStudy,
				faculty);
		
		this.researcher = new ResearcherDecorator(this);
	}
	
	public void setDegree(Degree degree) {
		this.degree = degree;
	}
	public void setSupervisor(ResearcherDecorator supervisor) throws SelfSupervisorException {
		if (!this.equals(supervisor)) {
			this.supervisor = supervisor;
		}
		else {
			throw new SelfSupervisorException("Graduated student cannot be his own supervisor");
		}
	}
	
	/**
	 * @param research paper
	 * @throws ResearchPaperAlreadyAddedException if paper is already in list of works
	 * This method adds paper to all works of student
	*/
	public void addPaper(ResearchPaper p) throws ResearchPaperAlreadyAddedException {
		researcher.addPaper(p);
	}
	/**
	 * @param research paper
	 * @throws ResearchPaperAlreadyAddedException if paper is already removed from works of student
	 * This method removes paper from all works of student
	*/
	public void removePaper(ResearchPaper p) throws ResearchPaperAlreadyAddedException {
		researcher.removePaper(p);
	}
	/**
	 * This method prints all papers of student
	*/
	public void printPapers() {
		researcher.printPapers();
	} 
	public Vector <ResearchPaper> getPapers() {
		return researcher.getPapers();
	}
	
	/**
	 * @return amount of all citations of student's works
	 * This method returns the amount of citations
	*/
	public int getAmountOfCitations() {
		return researcher.getAmountOfCitations();
	}
	
	public Vector <ResearchProject> getProjects() {
		return researcher.getProjects();
	}
	
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null ||o.getClass() != this.getClass()) return false;
		
		GraduatedStudent gs = (GraduatedStudent)o;
		return this.getID().equals(gs.getID());
	}
}
