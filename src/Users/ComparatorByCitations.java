package Users;

import java.util.Comparator;

public class ComparatorByCitations implements Comparator<ResearchPaper>{
	public int compare(ResearchPaper p1, ResearchPaper p2) {
		return Integer.compare(p1.getCitationIndex(), p2.getCitationIndex());
	}
}
