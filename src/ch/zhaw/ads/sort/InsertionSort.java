package ch.zhaw.ads.sort;

public class InsertionSort extends Sorter {

	InsertionSort() {
		super("InsertionSort");
	}

	@Override
	int[] sort(int[] a) {
		for (int k = 1; k < a.length; k++) {
			if (a[k] < a[k-1]){
				int x = a[k];
				int i;
				for (i = k; ((i > 0) && (a[i-1] > x));i--) {
					a[i] = a[i-1];
				}
				a[i] = x;
			}
		}
		return a;
	}

}
