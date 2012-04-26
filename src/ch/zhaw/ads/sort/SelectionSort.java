package ch.zhaw.ads.sort;

public class SelectionSort extends Sorter {

	SelectionSort() {
		super("SelectionSort");
	}

	@Override
	int[] sort(int[] a) {
		for (int k = 0; k < a.length; k++){
			int min = k;
			for (int i = k+1; i < a.length; i ++) {
				if (a[i] < a[min]) min = i;
			}
			if (min != k) swap (a, min, k);
		}
		return a;
	}

}
