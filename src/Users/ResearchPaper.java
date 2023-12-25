package Users;
import java.util.*;

public class ResearchPaper {
	private String title;
	private ResearcherDecorator author;
	private String doi;
	private Date publicationDate;
	private int citationIndex;
	private State state;
	
	public ResearchPaper(String title, ResearcherDecorator author, Date publicationDate) {
		this.title = title;
		this.author = author;
		this.publicationDate = publicationDate;
		this.state = State.INPROCESS;
		//можно изменить при лучшем варианте
		this.doi = author + "/" + publicationDate.toInstant().toString().substring(10);
	}
	
	public void makeCitation(ResearchPaper rp) {
		if (!this.getAuthor().equals(rp)) {
			rp.increaseCitationIndex();
		}
	}
	
	protected void increaseCitationIndex() {
		++citationIndex;
	}
	
	public void publish() throws PaperAlreadyPublishedException {
		if (!state.equals(State.PUBLISHED)) {
			state = State.PUBLISHED;
		}
		else {
			throw new PaperAlreadyPublishedException("The paper is already published");
		}
	}
	
	public void freeze() {
		state = State.FREEZED;
	}
	
	public String getTitle() {
		return title;
	}
	public ResearcherDecorator getAuthor() {
		return author;
	}
	public String getDoi() {
		return doi;
	}
	public Date getPublicationDate() {
		return publicationDate;
	}
	public int getCitationIndex() {
		return citationIndex;
	}
	public State getState() {
		return state;
	}
	
	public boolean equals(Object o) {
		if (this == o) return true;
		if (this.getClass() != o.getClass()) return false;
		
		ResearchPaper rp = (ResearchPaper)o;
		return this.getDoi().equals(rp.getDoi());
	}
	
	public int hashCode() {
		return Objects.hash(title, author, doi);
	}
}
