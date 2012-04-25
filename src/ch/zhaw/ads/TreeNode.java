package ch.zhaw.ads;

class TreeNode <T extends Comparable<T>>{
  T element;
  /* references to descendants */
  TreeNode<T> left,right;

  TreeNode (T elem ) {
    element = elem;
  }
}