package news;

import java.util.Comparator;

public class ComparatorByTopic implements Comparator<NewsBlank>{
	public int compare(NewsBlank o1, NewsBlank o2) {
		if(o1.getTopic() == TopicOfNews.RESEARCH && o2.getTopic() != TopicOfNews.RESEARCH) {
			return -1;
		}else if(o1.getTopic() != TopicOfNews.RESEARCH && o2.getTopic() == TopicOfNews.RESEARCH) {
			return 1;
		}else {
			return 0;
		}
	}
}
