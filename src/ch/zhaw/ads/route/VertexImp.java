package ch.zhaw.ads.route;

import java.util.*;

public class VertexImp<E> implements Vertex<E>  {
    protected String name;   // Name
    protected List<E> edges;  // Kanten
       
	
    public VertexImp(){
	   edges  = new LinkedList<E>( ); 
    }
	  
	  	
    public VertexImp(String name){
    	super();
        this.name = name;                
    }
	  
	public String getName() {return name;}
	
	public void setName(String name) {this.name = name;}
	  
    public Iterable<E> getEdges(){
    	return edges;
    }
    
    public void addEdge(E edge){
    	edges.add(edge);
   	} 
 
}