package fr.istic.master1.doodleplus_back_end.aux;

public class DateAux {
	private String year;
	private String month;
	private String day;
	
	public DateAux() {}
	
	public DateAux(String year, String month, String day) {
		this.year = year;
		this.month = month;
		this.day = day;
	}
	
	public String getYear() {
		return year;
	}
	
	public void setYear(String year) {
		this.year = year;
	}
	
	public String getMonth() {
		return month;
	}
	
	public void setMonth(String month) {
		this.month = month;
	}
	
	public String getDay() {
		return day;
	}
	
	public void setDay(String day) {
		this.day = day;
	}
	
	@Override
	public String toString() {
		return "DateAux [year=" + year + ", month=" + month + ", day=" + day + "]";
	}

}
