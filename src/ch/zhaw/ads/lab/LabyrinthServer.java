package ch.zhaw.ads.lab;

import java.awt.Color;

import ch.zhaw.ads.*;
import ch.zhaw.ads.route.*;


public class LabyrinthServer implements CommandInterpreter {

	ServerGraphics g = new ServerGraphics();
	
	Graph<DijkstraVertex<Edge<DijkstraVertex<Edge<String>>>>, Edge<DijkstraVertex<Edge<String>>>> graph = new AdjListGraph<DijkstraVertex<Edge<DijkstraVertex<Edge<String>>>>, Edge<DijkstraVertex<Edge<String>>>>(DijkstraVertex.class, Edge.class);

	DijkstraVertex<Edge<DijkstraVertex<Edge<String>>>> goal;
	
	@Override
	public String interpret(String command) throws Exception {
		
		String[] rows = command.split("\n");
		g.setColor(new Color(150, 150, 150));
		for (String row : rows) {
			String[] parts = row.split(" ");
			this.drawPath(g, parts[0], parts[1], false);
			
			graph.addEdge(parts[0], parts[1], 1d);
			graph.addEdge(parts[1], parts[0], 1d);
			
		}
		g.setColor(new Color(255, 0, 0));
		goal = graph.findNode("3-0");
		this.search(graph.findNode("0-6"));
		this.walkBack("3-0");
		
		return g.getTrace();
	}

	private void walkBack(String destination) {
		DijkstraVertex<Edge<DijkstraVertex<Edge<String>>>> endNode = this.graph.findNode(destination);
		DijkstraVertex<Edge<DijkstraVertex<Edge<String>>>> node = endNode.getPrev();
				
		drawPath(g, node.getName(), endNode.getName(), true);
		
		while(node != null){
			if (node.getPrev() != null) {
				drawPath(g, node.getName(), node.getPrev().getName(), true);
			}
			node = node.getPrev();
		}
	}
	
	boolean search (DijkstraVertex<Edge<DijkstraVertex<Edge<String>>>> currentNode) {
		currentNode.setMark(true);
		
		if (currentNode == goal) {
			return true;
		} else {
			for (Edge<DijkstraVertex<Edge<String>>> obj : currentNode.getEdges()) {
				DijkstraVertex<Edge<DijkstraVertex<Edge<String>>>> n = (DijkstraVertex) obj.getDest();
				if (!n.getMark()) {
					if (this.search(n)) { 
						n.setPrev(currentNode);
						return true;
					}
				}
			} 
		}
		currentNode.setMark(false);
		return false;
	}

	
	final double SCALE = 10;
	private void drawPath(ServerGraphics g, String from, String to, boolean mouse) {
		double scale = 10;
		double xh0 = from.charAt(0) - '0';
		double yh0 = from.charAt(2) - '0';
		double xh1 = to.charAt(0) - '0';
		double yh1 = to.charAt(2) - '0';
		double x0 = Math.min(xh0,xh1)/SCALE;
		double y0 = Math.min(yh0,yh1)/SCALE;
		double x1 = Math.max(xh0,xh1)/SCALE;
		double y1 = Math.max(yh0,yh1)/SCALE;
		double w = 1/SCALE;
		if (mouse) {
			g.drawLine(x0+w/2,y0+w/2,x1+w/2,y1+w/2);
		} else {
			if (y0 == y1) {
				g.fillRect(x0,y0,x1-x0+w,w);
			} else {
				g.fillRect(x0,y0,w,y1-y0+w);
			}
		}
	}

}
