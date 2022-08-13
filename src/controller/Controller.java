package controller;
import data.Event;
import data.Records;
import data.DataStorage;

public class Controller {
	public DataStorage ds = new DataStorage();
	public Event[] getEvents() { return this.ds.getAllEvents(); }

	public void addEvent(String szName, String pTempDate1, String eCategory) { 
		Event b = new Event(eCategory);
		b.setEventName(szName);
		b.setEventDate(pTempDate1);
		b.setCategoryName(eCategory);
		this.ds.storeEvent(b);
	}
		
	public void addRecord(String n, String d, String c) { 
		Records r = new Records(n, d, c);
		r.setName(n);
		r.setDate(d);
		r.setCategory(c);
		ds.storeRecord(r);
	}

	public void editRecords(int index, Event newrec) {
		this.ds.editRecords(index, newrec);
		
	}

	public void deleteCalculation(int numRows, Records s) {
		this.ds.deleteCalculation(numRows, s);
		
	}

	public Records[] getAllCalculations() {
		return this.ds.getAllCalculations();
	}
	
	public void editPanel(int index, Records newrec) {
		this.ds.editPanel(index, newrec);
		
	}

	public void storeItem(String name) {
//		this.ds.storeItem(name);
		
	}

	public void deleteItem(int index) {
//		this.ds.deleteItem(index);
	}

	public void editItem(int index, Event newItem) {
//		this.ds.editItem(index, newItem);
	}

	public Event[] getAllItems() {
		// TODO Auto-generated method stub
		return this.ds.getAllEvents();
		// this is null eh
		// this is causing the error
		// What are items supposed to be?
		//Name, date and category entered by an user
		// mULTI TASKING LA BRO
	}
}