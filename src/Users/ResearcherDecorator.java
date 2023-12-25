package Users;
import java.util.*;

public class ResearcherDecorator extends User {
	private User user;
	private Vector <ResearchPaper> papers;
	private Vector <ResearchProject> projects;
	
	public ResearcherDecorator(User user) {
		super(user.getFirstname(), user.getSecondname(), user.getID(), user.getBirthDate(), user.getPhoneNumber(), 
				user.getLogin(), user.getPassword(), user.getEmail(), user.getGender(), user.getAddress(), user.getLanguage());
		
		this.user = user;
		this.papers = new Vector <ResearchPaper>();
		this.projects = new Vector <ResearchProject>();
	}
	
	public Vector <ResearchPaper> getPapers() {
		return papers;
	}
	
	public void addPaper(ResearchPaper p) throws ResearchPaperAlreadyAddedException{
		if (!papers.contains(p)) {
			papers.add(p);
		}
		else {
			throw new ResearchPaperAlreadyAddedException("Paper is already added");
		}
	}
	public void removePaper(ResearchPaper p) throws ResearchPaperAlreadyAddedException {
		if (papers.contains(p)) {
			papers.remove(p);
		}
		else {
			throw new ResearchPaperAlreadyAddedException("Paper is already removed");
		}
	}
	public void printPapers() {
		int i = 1;
		for (ResearchPaper paper: papers) {
			System.out.println(i + ". " + paper.getDoi() + " " + paper.getTitle());
			++i;
		}
	}
	
	public int getAmountOfCitations() {
		int total = 0;
		for (ResearchPaper paper: papers) {
			total += paper.getCitationIndex();
		}
		
		return total;
	}
	
	public Vector <ResearchProject> getProjects() {
		return projects;
	}
}
