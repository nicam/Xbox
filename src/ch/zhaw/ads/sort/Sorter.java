package ch.zhaw.ads.sort;

abstract public class Sorter implements Runnable {
	private String name;
	protected int[] values;
	private String output;
	
	Sorter(String name) {
		this.name = name;
	}
	
	void setValues(int[] values) {
		this.values = values;
	}
	
	public String getTime() {
		return this.output;
	}

	public void run() {
		output = this.test(values);
	}
	
	String test(int[] values) {
		int [] copy = (int[])values.clone();
		long start = System.currentTimeMillis();
		long end;
		int count = 0;

		do {
			this.sort(copy);
			count++;
			end = System.currentTimeMillis();
		} while (end - start < 1000);
		return (long)(end-start)/count + ";";	
	}

	abstract int[] sort(int[] values);
	
	protected static <K> void swap(int[] a, int i, int j)
	{ 
		int h = a[i];
		a[i] = a[j];
		a[j] = h;
	}
}
