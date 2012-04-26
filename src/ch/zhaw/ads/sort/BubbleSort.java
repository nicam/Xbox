package ch.zhaw.ads.sort;

public class BubbleSort extends Sorter {

	BubbleSort() {
		super("BubbleSort");
	}

	@Override
	int[] sort(int[] a) {
		for (int k = a.length-1; k > 0; k--){
			for (int i = 0; i < k; i++) {
				if ( a[i] > a[i+1]) Sorter.swap(a, i, i+1);
			}
		}
		return a;
	}

}
