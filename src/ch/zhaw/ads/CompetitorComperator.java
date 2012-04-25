package ch.zhaw.ads;

import java.util.Comparator;


public class CompetitorComperator implements Comparator<Competitor> {

	@Override
	public int compare(Competitor arg0, Competitor arg1) {
		if (arg0.getTime() < arg1.getTime()) {
			return 1;
		}
		if (arg0.getTime() > arg1.getTime()) {
			return -1;
		}
		return 0;
	}

}
