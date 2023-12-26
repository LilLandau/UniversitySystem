package Users;
import java.io.IOException;
import java.util.*;

/**
 * @author Danial
 * This class is decorator to researcher. Class is using like a field in graduated student
 * and other researchers
*/
public class ResearcherDecorator extends User {
	/**
	 * These fields are requirements for proper work for decorator
	 * user is the core, that we pass to the decorator for making it researcher
	*/
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
	
	/**
	 * This method is used to add paper to researcher's works
	 * @param research paper to add
	 * @throws ResearchPaperAlreadyAddedException if paper is already in works
	*/
	public void addPaper(ResearchPaper p) throws ResearchPaperAlreadyAddedException{
		if (!papers.contains(p)) {
			papers.add(p);
		}
		else {
			throw new ResearchPaperAlreadyAddedException("Paper is already added");
		}
	}
	/**
	 * This method is used to remove paper from researcher's works
	 * @param research paper to remove
	 * @throws ResearchPaperAlreadyAddedException if paper is already removed from works
	*/
	public void removePaper(ResearchPaper p) throws ResearchPaperAlreadyAddedException {
		if (papers.contains(p)) {
			papers.remove(p);
		}
		else {
			throw new ResearchPaperAlreadyAddedException("Paper is already removed");
		}
	}
	/**
	 * This method is printing all works of researcher
	*/
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
	
	
	public void mainPage() throws IOException {
		System.out.println("https://wsp.kbtu.kz/" + this.getLogin());
		int chooseOfTeach;
		
		System.out.println("BaseFuctionality (1)");
		System.out.println("Teacher's Functionality (2)");
		
		chooseOfTeach = reader.read();
		if(chooseOfTeach == 1) {
			super.mainPage();
		}else if (chooseOfTeach == 2) {
			
			System.out.println("Put marks      (1)");
			chooseOfTeach = reader.read() - 48;
			
			if(chooseOfTeach == 1) {

			}
		}
		
	}
	
	
	
	
	public Vector <ResearchProject> getProjects() {
		return projects;
	}
	
	/**
	 * This method calculates H-index of researcher
	 * @return h if works exist, otherwise returns 0
	*/
	public int calculateHindex() {

		Vector<Integer> temp = new Vector<>();
		this.papers.sort(new ComparatorByCitations());
		for(ResearchPaper p : this.papers) {
			temp.add(p.getCitationIndex());
		}
		
		int n = temp.size();
		for( int i = 0; i < n; i++) {
			int h =  n - i;
			if(temp.get(i) >= h) {
				return h;
			}
		}
		
		return 0;
	}
}
