package ch.zhaw.ads.route;

import java.util.*;

public class AdjListGraph<V extends Vertex,E extends Edge> implements Graph<V,E> {
	private List<V> nodes = new LinkedList<V>();
	private Class nodeClass;
	private Class edgeClass;

	public AdjListGraph(Class nKind, Class eKind) {
		nodeClass = nKind;
		edgeClass = eKind;
	}

	// füge Knoten hinzu, gebe alten zurück falls Knoten schon existiert
	public V addNode (String name) {
		V node = findNode(name);
		if (node == null) {
			try {
				node = (V)nodeClass.newInstance();
				node.setName(name);
				nodes.add(node);
			}
			catch (Exception e) {
				return null;
			}

		}
		return node;
	}

	// füge gerichtete Kante hinzu
	public void addEdge (String source, String dest, double weight) {
		V src = addNode(source);
		V dst = addNode(dest);
		try {
			E edge = (E)edgeClass.newInstance();
			edge.setDest(dst);
			edge.setWeight(weight);
			src.addEdge(edge);
		}
		catch (Exception e){}
	}  	

	// finde den Knoten anhand seines Namens
	public V findNode(String name) {
		for (V node : nodes) {
			if (node.getName().equals(name)) return node;		
		}
		return null;
	}

	// Iterator über alle Knoten
	public Iterable<V> getNodes(){
		return nodes;
	}
}