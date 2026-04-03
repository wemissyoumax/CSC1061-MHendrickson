package edu.frcc.csc.j.MyTreeSet;

import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Iterator;
import java.util.Queue;
import java.util.Set;

public class MyTreeSet <E extends Comparable<E>> implements Set <E>{
	private Node root = null;
	private int size = 0;
	
	private class Node{
		protected E data;
		protected Node lChild;
		protected Node rChild;
		protected int height;
		
		public Node(E data) {
			this.data = data;
			height = 0;
		}
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean contains(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterator<E> iterator() {
		return InOrderRecursive;
	}
	
	private class InOrderRecursive implements Iterator<E>{
		private Queue<E> queue = new ArrayDeque<>();
		public InOrderRecursive() {
			inorder(root);
		}
		private void inorder(Node node) {
			if(node ==  null) {
				return;
			}
			inorder(node.lChild);
			queue.add(node.data);
			inorder(node.rChild);
		}
		@Override
		public boolean hasNext() {
			return !queue.isEmpty();
		}
		@Override
		public E next() {
			return queue.remove();
		}
	}

	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T[] toArray(T[] a) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean add(E data) {
		if(root == null) {
			root = new Node(data);
			size++;
			return true;
		}
		Node current = root;
		Node parent = null;
		while(current != null) {
			if(data.compareTo(current.data) < 0) {
				parent = current;
				current = current.lChild;
			} else {
				return false;
			}
		}
		return false;
	}

	@Override
	public boolean remove(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addAll(Collection<? extends E> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}

}
