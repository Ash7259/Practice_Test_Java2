package data;

import java.util.Date;

public class Event {
	private String eventName;
	private String m_pDate = null;
	private String categoryName;
	@SuppressWarnings("unused") private int m_pTime = 0;

	public Event(String aa) {
		// TODO Auto-generated constructor stub
	}
	public String getEventName() { return eventName; }
	public void setEventName(String eventName) { this.eventName = eventName; }
	public String getEventDateObject() { return this.m_pDate; }
	public String getEventDate() { return this.m_pDate.toString(); }
	public void setEventDate(String pTempDate1) { this.m_pDate = pTempDate1; }
	
    public String getcategoryName() {
    	return categoryName;
    }
    public void setCategoryName(String categoryName) {
    	this.categoryName = categoryName;
    }
}