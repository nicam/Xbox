package ch.zhaw.ads;

/* interface of Tree ADT */
public interface Tree<T> {
  /* add an element to the tree */
  public void add(T o);
  /* remove an element; returns the element if found else return null */
  public T remove(T o);
  /* remove last element of the tree */
  public T removeLast();
  /* test if tree is empty */
  public boolean isEmpty();
  /* returns instance of class that implements traversal interface */
  public Traversal<T> traversal();
}