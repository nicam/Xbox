package ch.zhaw.ads.Stack;

import java.util.*;

public class ListStack implements Stack {

	protected List list = new LinkedList();
	
	public void push(Object x) throws StackOverflowError {
		list.add(0, x);
	}

	public Object pop() {
		return list.remove(0);
	}

	public boolean isEmpty() {
		return list.isEmpty();
	}

	public Object peek() {
		return list.get(0);
	}

	public void makeEmpty() {
		list.clear();
	}

	public boolean isFull() {
		return false;
	}

}
