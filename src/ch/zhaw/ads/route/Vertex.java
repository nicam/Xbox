
package ch.zhaw.ads.route;

import java.util.*;

public interface Vertex<E>  {

	public String getName();
	
	public void setName(String name);
	  
    public Iterable<E> getEdges();
    
    public void addEdge(E edge);
 
}