package fr.istic.master1.doodleplus_back_end.aux;

public class HeureAux {
	private String hour;
	private String minute;
	private String second;
	
	public HeureAux() {}
	
	public HeureAux(String hour, String minute, String second) {
		super();
		this.hour = hour;
		this.minute = minute;
		this.second = second;
	}

	public String getHour() {
		return hour;
	}

	public void setHour(String hour) {
		this.hour = hour;
	}

	public String getMinute() {
		return minute;
	}

	public void setMinute(String minute) {
		this.minute = minute;
	}

	public String getSecond() {
		return second;
	}

	public void setSecond(String second) {
		this.second = second;
	}

	@Override
	public String toString() {
		return "HeureAux [hour=" + hour + ", minute=" + minute + ", second=" + second + "]";
	}
}
