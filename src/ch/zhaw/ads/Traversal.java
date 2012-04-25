package ch.zhaw.ads;

/* interface of Traversal ADT */
public interface Traversal<T> {
  /* traverse elements of tree in preorder */
  public void preorder(Visitor<T> vistor);
  /* traverse elements of tree in inorder */
  public void inorder(Visitor<T> vistor);
  /* traverse elements of tree in postorder */
  public void postorder(Visitor<T> vistor);
}
