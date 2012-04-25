package ch.zhaw.ads;

public class PriorityQueueItem<T, P extends Comparable<P>> implements Comparable<PriorityQueueItem<T, P>> {
	
	// priority
	public P priority;

	// element
	public T element;
	
	PriorityQueueItem(T element, P priority) {
		this.priority = priority;
		this.element = element;
	}
	
	public T getElement() {
		return element;
	}
	

	@Override
	public int compareTo(PriorityQueueItem<T, P> o) {
		return this.priority.compareTo(o.priority);
	}

}
