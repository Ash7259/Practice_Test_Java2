package data;

public class Records {
	private String name;
	private String date;
	private String category;
	
	public Records(String n, String d, String c) {
		this.name=n;
		this.date=d;
		this.category=c;
		
	}

	public String getName() {
	 	 return name; 
	}

	public void setName(String name) { 
		 this.name = name; 
	}

	public String getDate() {
	 	 return date; 
	}

	public void setDate(String date) { 
		 this.date = date; 
	} 
	
	public String getCategory() {
	 	 return category; 
	}

	public void setCategory(String category) { 
		 this.category = category; 
	}

}