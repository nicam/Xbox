package ch.zhaw.ads;

public class Priority implements Comparable<Priority> {
	
	public Priority(int value) {
		this.value = value;
	}
	
	private int value;

	@Override
	public int compareTo(Priority o) {
		if (value > o.value) {
			return 1;
		}
		if (value < o.value) {
			return -1;
		}
		return 0;
	}

}
