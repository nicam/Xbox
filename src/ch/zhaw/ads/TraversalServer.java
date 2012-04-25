package ch.zhaw.ads;

public class TraversalServer implements CommandInterpreter {

	private SortedBinaryTree<Competitor> tree = new SortedBinaryTree();
	
	private String output;
	
	@Override
	public String interpret(String command) throws Exception {
		ZuerichMarathon zm = new ZuerichMarathon();
		
		zm.load(command);
				
		int i = 1;
		for (Competitor c : zm) {
			tree.add(c);
			i++;
		}
		
		TreeTraversal<Competitor> trav = (TreeTraversal<Competitor>) tree.traversal();
		MyVisitor my = new MyVisitor();
		trav.inorder(my);
		
		return my.getString();
	}
}
