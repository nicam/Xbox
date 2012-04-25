package ch.zhaw.ads;

import java.util.*;

public class SortedBinaryTree<T extends Comparable<T>> implements Tree<T> {
  private TreeNode<T> root;
  private T removed;

  private TreeNode<T> insertAt(TreeNode<T> node, T x) {
    if (node == null) {
      return new TreeNode<T>(x);
    }
    else {
      if (x.compareTo(node.element) <= 0)
        node.left = insertAt(node.left, x);
      else
        node.right = insertAt(node.right, x);
      return node;
    }
  }

  public void add (T x) {
    root = insertAt(root, x);
  }

  // find node to replace
  TreeNode<T> rep;
  private TreeNode<T> findRepAt(TreeNode<T> node) {
    if (node.right != null) {
      node.right = findRepAt(node.right);
      return node;
      }
    else {
      rep = node;
      return node.left;
    }
  }

  // remove node
  private TreeNode<T> removeAt(TreeNode<T> node, T x) {
    if (node == null) {
      return null;
    }
    else {
      if (x.compareTo(node.element) == 0) {
        // found
        removed = node.element;
        if (node.left == null) return node.right;
        else if (node.right == null) return node.left;
        else {
          node.left = findRepAt(node.left);
          rep.left = node.left;
          rep.right = node.right;
          return rep;
        }
      }
      else if (x.compareTo(node.element) <= 0)
        // search left
        node.left = removeAt(node.left, x);
      else
        // search right
        node.right = removeAt(node.right, x);
      return node;
    }
  }

  public T remove(T x) {
    removed = null;
    root = removeAt(root, x);
    return removed;
  }

  public T removeLast() {
    if (root.right != null) {
      root.right = findRepAt(root.right);
    }
    else {
      rep = root;
      root = root.left;
    }
    return rep.element;
  }

  public boolean isEmpty() {
    return root == null;
  }

  public Traversal<T> traversal() {
     return new TreeTraversal<T>(root);
  }

}