package edu.frcc.csc.j.MyTreeMap;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

public class MyTreeMap<K extends Comparable<K>,V> implements Map<K,V>{
	private Node root = null;
	private int size = 0;
	
	private class Node {
		protected K key;
		protected V value;
		protected Node lChild;
		protected Node rChild;
	}
	
	public Node (K key, V value) {
		this.key = key;
		this.value = value;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return root == null;
	}

	@Override
	public boolean containsKey(Object key) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean containsValue(Object value) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public V get(Object key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public V put(K key, V value) {
		if(root == null) {
			root = new Node(key, value);
			size++;
			return null;
		}
		Node parent = null;
		Node current = root;
		while(current != null) {
			parent = current;
			if(key.compareTo(current.key) < 0) {
				current = current.lChild;
			} else if (key.compareTo(current.key) > 0) {
				current = current.rChild;
			} else {
				V oldVal = current.value;
				current.value = value;
				return oldVal;
			}
		}
		Node newNode = new Node(key, value);
		if(key.compareTo(parent.key) < 0) {
			parent.lChild = newNode;
		} else {
			parent.rChild = newNode;
		}
		size++;
		return null;
	}

	@Override
	public V remove(Object key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void putAll(Map<? extends K, ? extends V> m) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Set<K> keySet() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<V> values() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<Entry<K, V>> entrySet() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
	
	
