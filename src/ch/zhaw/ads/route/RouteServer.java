package ch.zhaw.ads.route;

import ch.zhaw.ads.*;

public class RouteServer implements CommandInterpreter {

	Graph<DijkstraVertex<Edge<DijkstraVertex<Edge<String>>>>, Edge<DijkstraVertex<Edge<String>>>> graph = new AdjListGraph<DijkstraVertex<Edge<DijkstraVertex<Edge<String>>>>, Edge<DijkstraVertex<Edge<String>>>>(DijkstraVertex.class, Edge.class);

	@Override
	public String interpret(String command) throws Exception {

		String[] destinations = command.split("\n");

		for (String line: destinations) {
			String[] parts = line.split(" ");
			graph.addEdge(parts[0], parts[1], Double.parseDouble(parts[2]));
			graph.addEdge(parts[1], parts[0], Double.parseDouble(parts[2]));
		}

		this.breadthFirstSearch("Winterthur");
		return this.walkBack("Lugano");
	}
	
	private String walkBack(String destination) {
		String output = "";
		DijkstraVertex<Edge<DijkstraVertex<Edge<String>>>> endNode = this.graph.findNode(destination);
		DijkstraVertex<Edge<DijkstraVertex<Edge<String>>>> node = endNode.getPrev();
		
		output = endNode.getName();
		
		while(node != null){
			output = node.getName() + " => " + output;
			node = node.getPrev();
		}
		
		return output + "\n" + "Total Distance: " + endNode.getDist();
	}


	private void breadthFirstSearch(String start) {
		BinaryTreeProrityQueue<DijkstraVertex<Edge<DijkstraVertex<Edge<String>>>>, Double> q = new BinaryTreeProrityQueue<DijkstraVertex<Edge<DijkstraVertex<Edge<String>>>>, Double>();
		DijkstraVertex<Edge<DijkstraVertex<Edge<String>>>> startNode = graph.findNode(start);
		startNode.setDist(0);
		q.enqueue(startNode, 0d);
		while (!q.isEmpty()) {
			DijkstraVertex<Edge<DijkstraVertex<Edge<String>>>> current = q.dequeue();
			current.setMark(true);
			for (Edge<DijkstraVertex<Edge<String>>> edge : current.getEdges()) {
				DijkstraVertex<Edge<DijkstraVertex<Edge<String>>>> n = (DijkstraVertex)edge.getDest();
				if (!n.getMark()) {
					double dist = edge.getWeight() + current.getDist();
					if ((n.getPrev() == null) || (dist < n.dist)) {
						n.setDist(dist);
						n.setPrev(current);
						q.enqueue(n,-n.getDist());
					}
				}
			}
		}
	}

}
