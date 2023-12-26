package Users;
import java.util.*;
/**
 * This class represents project as a class
 * @author Danial
*/
public class ResearchProject {
	/**
	 * These fields representing research team and their's papers 
	*/
	private String title;
	private Vector <ResearcherDecorator> researchers;
	private Vector <ResearchPaper> researchPapers;
	
	public ResearchProject(String title) {
		this.title = title;
		researchers = new Vector <ResearcherDecorator>();
		researchPapers = new Vector <ResearchPaper>();
	}
	
	/**
	 * This method is adding paper to team's works
	 * @param research paper to add
	 * @throws ResearchPaperAlreadyAddedException if paper is already added to team's works
	 * */
	public void addResearchPaper(ResearchPaper rp) throws ResearchPaperAlreadyAddedException {
		if (!researchPapers.contains(rp)) {
			researchPapers.add(rp);
		}
		else {
			throw new ResearchPaperAlreadyAddedException("Paper is already added");
		}
	}
	
	/**
	 * This method removes distinct paper from team's works
	 * @param research paper to remove
	 * @throws ResearchPaperAlreadyAddedException if paper is already removed from works
	*/
	public void removeResearchPaper(ResearchPaper rp) throws ResearchPaperAlreadyAddedException {
		if (researchPapers.contains(rp)) {
			researchPapers.remove(rp);
		}
		else {
			throw new ResearchPaperAlreadyAddedException("Paper is already removed");
		}
	}
	
	/**
	 * This method adds new member to the team
	 * @param researcher to add
	 * @throws ResearcherIsAlreadyInException if researcher is already in team
	*/
	public void addResearcher(ResearcherDecorator r) throws ResearcherIsAlreadyInException {
		if (!researchers.contains(r)) {
			researchers.add(r);
		}
		else {
			throw new ResearcherIsAlreadyInException("Researcher is already in project");
		}
	}
	/**
	 * This method removes distinct member from project team
	 * @param researcher to remove
	 * @throws ResearcherIsAlreadyInException if researcher is already removed
	*/
	public void removeResearcher(ResearcherDecorator r) throws ResearcherIsAlreadyInException {
		if (researchers.contains(r)) {
			researchers.remove(r);
		}
		else {
			throw new ResearcherIsAlreadyInException("Researcher is already removed from project");
		}
	}
	
	public String getTitle() {
		return title;
	}
	public Vector <ResearcherDecorator> getResearchers() {
		return researchers;
	}
	public Vector <ResearchPaper> getResearchPaper() {
		return researchPapers;
	}
}
