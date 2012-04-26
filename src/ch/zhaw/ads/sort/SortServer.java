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
		Sorter[] sorters = new Sorter[3];
		
		sorters[0] = new BubbleSort();
		sorters[1] = new InsertionSort();
		sorters[2] = new SelectionSort();
		
		Thread threads[] = new Thread[3];
		
		for (int q = 0; q < sizes.length; q++) {
			int[] valuesOrigin = this.generateData(Integer.parseInt(sizes[q]));
						
			for (int i = 0; i<sorters.length; i++) {
				if (sorters[i] == null) {
					continue;
				}
				sorters[i].setValues(valuesOrigin);
				threads[i] = new Thread(sorters[i]);
				threads[i].start();
			}
			
			threads[0].join();
			threads[1].join();
			threads[2].join();
			
			for (int i = 0; i<sorters.length; i++) {
				if (sorters[i] == null) {
					continue;
				}
				output += sorters[i].getTime();
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
