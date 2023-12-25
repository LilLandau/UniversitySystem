package Users;
import java.util.*;

public class ResearchProject {
	private String title;
	private Vector <ResearcherDecorator> researchers;
	private Vector <ResearchPaper> researchPapers;
	
	public ResearchProject(String title) {
		this.title = title;
		researchers = new Vector <ResearcherDecorator>();
		researchPapers = new Vector <ResearchPaper>();
	}
	
	public void addResearchPaper(ResearchPaper rp) throws ResearchPaperAlreadyAddedException {
		if (!researchPapers.contains(rp)) {
			researchPapers.add(rp);
		}
		else {
			throw new ResearchPaperAlreadyAddedException("Paper is already added");
		}
	}
	public void removeResearchPaper(ResearchPaper rp) throws ResearchPaperAlreadyAddedException {
		if (researchPapers.contains(rp)) {
			researchPapers.remove(rp);
		}
		else {
			throw new ResearchPaperAlreadyAddedException("Paper is already removed");
		}
	}
	
	public void addResearcher(ResearcherDecorator r) throws ResearcherIsAlreadyInException {
		if (!researchers.contains(r)) {
			researchers.add(r);
		}
		else {
			throw new ResearcherIsAlreadyInException("Researcher is already in project");
		}
	}
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
