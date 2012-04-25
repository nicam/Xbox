package ch.zhaw.ads;

import java.util.*;



public class LocationComperator implements Comparator<Competitor> {

	@Override
	public int compare(Competitor arg0, Competitor arg1) {
		return arg0.getTown().compareTo(arg1.getTown());
	}

}
