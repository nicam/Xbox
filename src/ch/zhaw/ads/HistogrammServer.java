package ch.zhaw.ads;

public class HistogrammServer implements CommandInterpreter {

	private SortedBinaryTree<Competitor> tree = new SortedBinaryTree();

	private String output;

	private long slowest = 0;
	private long fastest = 100000000;

	@Override
	public String interpret(String command) throws Exception {
		ServerGraphics sg = new ServerGraphics();

		this.fillTree(command);

		TreeTraversal<Competitor> trav = (TreeTraversal<Competitor>) tree.traversal();
		
		double iteration = (slowest - fastest) / 40f;
		double minTime = fastest;
		double maxTime = minTime + iteration;
		double xPos = 0, width = 1f/40f;
		long start = System.nanoTime();

		for (int i = 0; i < 40; i++) {
			Competitor minC = new Competitor(minTime);
			Competitor maxC = new Competitor(maxTime);
			HistogrammVisitor my = new HistogrammVisitor(minTime, maxTime);
			trav.intervall(my, minC, maxC);
			//trav.inorder(my);

			sg.drawRect(xPos, 0, width, (my.getCount()/300f));
			minTime = maxTime;
			maxTime = maxTime + iteration;
			xPos += width;
		}
		System.out.println("Execution Time: " + (System.nanoTime() - start));

		return sg.getTrace();
	}

	private void fillTree(String command) {
		String[] competitorsString = command.split("\n");
		Competitor c;
		long compare = 0;

		for( String competitsString : competitorsString) {
			String[] data = competitsString.split(";");
			c = new Competitor(data[1], Integer.parseInt(data[2]), data[3], data[4]);
			compare = c.getTime();
			if (compare < fastest) {
				fastest = compare;
			}
			if (compare > slowest) {
				slowest = compare;
			}
			tree.add(c);
		}
	}

}
