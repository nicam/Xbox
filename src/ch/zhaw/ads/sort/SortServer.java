package ch.zhaw.ads.sort;

import java.util.Random;

import ch.zhaw.ads.*;

public class SortServer implements CommandInterpreter {

	@Override
	public String interpret(String command) throws Exception {
		String[] sizes = command.split(" ");
		long start = System.currentTimeMillis();
		long end;
		String output = "Bubble;Insertion;Selection; \n";
		Sorter[] sorters = new Sorter[4];
		
		sorters[0] = new BubbleSort();
		sorters[1] = new InsertionSort();
		sorters[2] = new SelectionSort();
		
		for (int q = 0; q < sizes.length; q++) {
			int[] valuesOrigin = this.generateData(Integer.parseInt(sizes[q]));
			for (int i = 0; i<sorters.length; i++) {
				if (sorters[i] == null) {
					continue;
				}
				output += sorters[i].test(valuesOrigin);
			}
			output += "\n";
		}

		return output;
	}

	public int[] generateData(int size) {
		int[] values = new int[size];
		Random random = new Random();
		for (int i = 0; i < size; i++) {
			values[i] = random.nextInt(1000000);
		}
		return values;
	}

}
