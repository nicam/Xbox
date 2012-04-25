package ch.zhaw.ads;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.*;


public class ZuerichMarathon extends LinkedList<Competitor>{
	private long slowest = 0;
	private long fastest = 100000000;
	
	public void load (String s) {
		String[] competitorsString = s.split("\n");
		Competitor c;
		
		long compare = 0;
		
		for( String competitsString : competitorsString) {
			String[] data = competitsString.split(";");
			c = new Competitor(data[1], Integer.parseInt(data[2]), data[3], data[4]);
			compare = c.getTime();
			if (compare < fastest) {
				fastest = compare;
			}
			if (compare > slowest) {
				slowest = compare;
			}
			this.add(c);
		}
	}
	
	
	public long getSlowest() {
		return slowest;
	}
	
	public long getFastest() {
		return fastest;
	}

	List<Competitor> sort() {
		Collections.sort(this);
		return this;
	}
	
	List<Competitor> sort(Comparator<Competitor> cmp) {
		Collections.sort(this, cmp);
		return this;
	}

}
