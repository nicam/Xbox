package ch.zhaw.ads.route;

import java.util.*;

public interface Graph<V,E> {

  // f�ge Knoten hinzu, tue nichts, falls Knoten schon existiert
  public  V addNode (String name);
  
  // finde den Knoten anhand seines Namens
  public V findNode(String name);

  // Iterator �ber alle Knoten des Graphen
  public Iterable<V> getNodes();
  
  // f�ge gerichtete und gewichtete Kante hinzu
  public void addEdge(String source, String dest, double weight);


}