package ch.zhaw.ads;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class TreeTraversal<T extends Comparable<T>> implements Traversal<T> {

  private TreeNode<T> root;

  public TreeTraversal(TreeNode<T> root) {
      this.root = root;
  }

  private void inorder(TreeNode<T> node, Visitor<T> visitor) {
	  if (node != null) {
		  inorder(node.left, visitor);
		  visitor.visit(node.element);
		  inorder(node.right, visitor);
	  }
  }
  
  private void intervall(TreeNode<T> node, Visitor<T> visitor, T min, T max) {
	  if (node != null) {
		  if (node.element.compareTo(min) >= 0) {
			  intervall(node.left, visitor, min, max);
		  }
		  visitor.visit(node.element);
		  if (node.element.compareTo(max) < 0) {
			  intervall(node.right, visitor, min, max);
		  }
	  }
  }
  
  public void intervall(Visitor<T> vis, T min, T max) {
	  intervall(root, vis, min, max);
}
  
  public void inorder(Visitor<T> vis) {
    inorder(root, vis);
  }

  public void preorder(Visitor<T> vis) {
    throw new NotImplementedException();
  }

  public void postorder(Visitor<T> vis) {
	  throw new NotImplementedException();
  }

}