package Users;
import java.util.*;

public class GraduatedStudent extends Student {
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
	
	public void addPaper(ResearchPaper p) throws ResearchPaperAlreadyAddedException {
		researcher.addPaper(p);
	}
	public void removePaper(ResearchPaper p) throws ResearchPaperAlreadyAddedException {
		researcher.removePaper(p);
	}
	public void printPapers() {
		researcher.printPapers();
	} 
	public Vector <ResearchPaper> getPapers() {
		return researcher.getPapers();
	}
	
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
