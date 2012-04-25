package ch.zhaw.ads.route;

public class DijkstraVertex<E> implements Vertex<E> {
	Vertex<E> decorated;
    boolean mark;
    DijkstraVertex<E> prev;
    double dist;
	
    public DijkstraVertex() {
        decorated = new VertexImp<E>();
    }
    
	@Override
	public String getName() {
		return decorated.getName();
	}

	@Override
	public void setName(String name) {
		decorated.setName(name);
	}

	@Override
	public Iterable<E> getEdges() {
		return decorated.getEdges();
	}

	@Override
	public void addEdge(E edge) {
		decorated.addEdge(edge);
	}
	
	public void setDist(double dist) {
		this.dist = dist;
	}
	
	public void setMark(boolean mark) {
		this.mark = mark;
	}

	public double getDist() {
		return dist;
	}
	
	public boolean getMark() {
		return mark;
	}
	
	public void setPrev(DijkstraVertex<E> p) {
       prev = p;
	}
	
	    public DijkstraVertex<E> getPrev() {
	       return prev;
	}
	
}
