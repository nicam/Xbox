package ch.zhaw.ads.Ranking;

import java.util.*;

import ch.zhaw.ads.Competitor;

public class NameComperator implements Comparator<Competitor> {

	@Override
	public int compare(Competitor arg0, Competitor arg1) {
		return arg0.getName().compareTo(arg1.getName());
	}

}
