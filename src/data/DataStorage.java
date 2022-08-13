package data;

import java.util.Vector;

public class DataStorage {
	private Vector<Event> storage = new Vector<Event>();
	public Event[] getAllEvents() { 
		Event[] opArr= new Event[this.storage.size()];
		this.storage.toArray(opArr);
		return opArr;
	}

	public void storeEvent(Event b) { 
		this.storage.add(b);
		System.out.println("Name: " + b.getEventName());
		System.out.println("Date: " + b.getEventDate());
		System.out.println("Category: " + b.getcategoryName());
	}

	public void storeRecord(Records r) {
		
	}

	public void editRecords(int index, Event newrec) {
		this.storage.setElementAt(newrec, index);
		
	}

	public void deleteCalculation(int numRows, Records s) {
		this.storage.remove(numRows);
		this.storage.remove(s);
		
	}

	public Records[] getAllCalculations() {
		Records[] opArr = new Records[this.storage.size()];
		this.storage.toArray(opArr);
		return opArr;
	}

	public void editPanel(int index, Records newrec) {
		// TODO Auto-generated method stub
		
	}
}