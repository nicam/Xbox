package ch.zhaw.ads;

public class BinaryTreeProrityQueue<T, P extends Comparable<P>> implements PriorityQueue<T, P> {

	SortedBinaryTree<PriorityQueueItem<T, P>> tree = new SortedBinaryTree<PriorityQueueItem<T, P>>();
	
	@Override
	public void enqueue(T element, P priority) {
		PriorityQueueItem<T, P> q = new PriorityQueueItem<T, P>(element, priority);
		tree.add(q);
	}

	@Override
	public T dequeue() {
		return tree.removeLast().getElement();
	}

	@Override
	public boolean isEmpty() {
		return tree.isEmpty();
	}

	@Override
	public void makeEmpty() {
		tree = new SortedBinaryTree<PriorityQueueItem<T, P>>();
	}

	@Override
	public boolean isFull() {
		return false;
	}

}
