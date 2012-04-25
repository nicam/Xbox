package ch.zhaw.ads;


public class RankingServer implements CommandInterpreter {

	@Override
	public String interpret(String command) {
		ZuerichMarathon zm = new ZuerichMarathon();
		
		zm.load(command);
		zm.sort(); // Default comparator
//		zm.sort(new NameComperator()); // Name Comparator
//		zm.sort(new LocationComperator()); // Location Based Comparison
		StringBuilder s = new StringBuilder();
		
		int i = 1;
		for (Competitor c : zm) {
			c.setRank(i++);
			s.append(c.toString() + "\n");
		}
		
		return s.toString();
	}

}
