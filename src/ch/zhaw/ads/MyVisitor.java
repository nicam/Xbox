package ch.zhaw.ads;

public class MyVisitor implements Visitor<Competitor> {

	private String buffer = "";
	private int rank = 1;
	
	
	public String getString() {
		return buffer;
	}

	@Override
	public void visit(Competitor obj) {
		obj.setRank(rank);
		buffer += obj.toString() + "\n";
		rank++;
	}


}
