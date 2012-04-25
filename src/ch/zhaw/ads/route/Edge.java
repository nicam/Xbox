package ch.zhaw.ads.route;

public class Edge<V> implements Comparable<Edge<V>>
{
    protected V dest;  // Zielknoten der Kante
    protected double weight;  // Kantengewicht

    public Edge() {}
    
    public Edge(V dest, double weight) {
        this.dest = dest;
        this.weight = weight;
    }
    
    public String toString() {
    	return (String)dest;
    }
	
	public void setDest(V node) {this.dest = node;}
	public V getDest() {return dest;}
	
	public void setWeight(double w) {this.weight = w;}
    double getWeight() {return weight;}

    
    
	@Override
	public int compareTo(Edge<V> o) {
		return (int)(o.weight - this.weight);
		
	}
}