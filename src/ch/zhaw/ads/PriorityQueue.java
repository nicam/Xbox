package ch.zhaw.ads;

public interface PriorityQueue<T, P extends Comparable<P>> {
  // füge x in die Queue ein
  public void enqueue (T x,	P priority);
  	
  // entferne ersts Element
  public T dequeue ();	
  
  // test ob Queue leer
  public boolean isEmpty();		
  
  // leert die ganze Queue
  public void makeEmpty ();	
  
  // test ob Queue voll ist
  public boolean isFull();
}