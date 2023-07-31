package entity;

import java.util.Date;
import java.util.List;

public abstract class GroupHistory {
	List<View> views;
	Date date;

	public static List<GroupHistory> getInstance() {

		return null;
	}

	public List<View> getViews() {

		
		return views;
	}

	public void setViews(List<View> views) {
		this.views = views;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

}
