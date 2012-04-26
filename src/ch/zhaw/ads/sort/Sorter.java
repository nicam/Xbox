package ch.zhaw.ads.sort;

abstract public class Sorter {
	private String name;
	
	Sorter(String name) {
		this.name = name;
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
		return (double)(end-start)/count + ";";	
	}

	abstract int[] sort(int[] values);
	
	protected static <K> void swap(int[] a, int i, int j)
	{ 
		int h = a[i];
		a[i] = a[j];
		a[j] = h;
	}
}
