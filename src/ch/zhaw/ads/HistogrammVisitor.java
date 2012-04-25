package ch.zhaw.ads;

public class HistogrammVisitor implements Visitor<Competitor> {

	private double maxTime;
	private double minTime;
	private int counter = 0;


	HistogrammVisitor(double minTime, double maxTime) {
		this.minTime = minTime;
		this.maxTime = maxTime;
	}
	
	
	public int getCount() {
		return counter;
	}

	@Override
	public void visit(Competitor obj) {
		if (obj.getTime() < maxTime && obj.getTime() >= minTime) {
			counter++;
		}
	}


}
