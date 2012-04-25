package ch.zhaw.ads;

import java.text.*;
import java.util.*;

public class Competitor implements Comparable<Competitor> {
	private String name;
	private String town;
	private String firstName;
	private Calendar time;
	private int jg;
	private int startNr;
	private int rank;

	public Competitor (String name, int jg, String country, String time) {
		String[] fullname = name.split(" ");
		this.name = fullname[0];
		this.firstName = fullname[1];
		this.jg = jg;
		this.town = country;
		this.time = setTime(time);
	}
	
	public Competitor (double time) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis((long)time);
		this.time = calendar;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	public Calendar setTime(String time) {
		DateFormat df = new SimpleDateFormat("hh:mm:ss.SS");
		try {
			Date timeObject = df.parse(time);
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(timeObject);
			return calendar;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public long getTime() {
		return time.getTimeInMillis();
	}

	private String getFormatedTime() {
		return this.time.get(Calendar.HOUR_OF_DAY)+":"+this.time.get(Calendar.MINUTE)+":"+this.time.get(Calendar.SECOND)+"."+this.time.get(Calendar.MILLISECOND);
	}

	public String getName() {
		return name;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public String getTown() {
		return this.town;
	}

	public String toString() {
		return rank + " " +  name + " " + firstName + " " +  town + " " + this.getFormatedTime();
	}

	@Override
	public int compareTo(Competitor arg0) {
		return (int) (this.getTime() - arg0.getTime());
	}

}