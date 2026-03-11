package edu.frcc.csc1061.MyBookTree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;

public class MyBookTree implements Iterable<MyBookNode>{
	private MyBookNode root;
	
	public MyBookTree(String title) {
		//myBokNode(Title, chapNum, secNum, subSecNum)
		root = new MyBookNode(title, 0, 0, 0);
	}
	
	public boolean addBookNode(String title, int chapNum, int secNum, 
			int subSecNum) {
		MyBookNode node = new MyBookNode(title, chapNum, secNum, subSecNum);
		//This is a chapter
		if(secNum == 0) {
			root.getChildNodes().add(node);
			Collections.sort(root.getChildNodes());
			return true;
		}
		//Section node
		if(subSecNum ==0) {
			for(MyBookNode chap : root.getChildNodes()) {
				if(chap.getChapNum() == chapNum) {
					chap.getChildNodes().add(node);
					Collections.sort(chap.getChildNodes());
					return true;
				}
			}
		}
		//This is a subsection node
		for(MyBookNode chap : root.getChildNodes()) {
			if(chap.getChapNum() == chapNum) {
				for(MyBookNode sec : chap.getChildNodes()) {
					if(sec.getSecNum() == secNum) {
						sec.getChildNodes().add(node);
						Collections.sort(sec.getChildNodes());
						return true;
					}
				}
			}
		}
		return false;
	}

	@Override
	public Iterator<MyBookNode> iterator() {
		return new RecursiveIterator();
	}
	
	private class RecursiveIterator implements Iterator<MyBookNode> {
		Deque<MyBookNode> queue = new ArrayDeque<>();
		
		public RecursiveIterator() {
			preorder(root);
		}
		//As it sees the nodes, it throws them in the queue
		// ------------------------------------------------
		// This block goes through the tree and sees who has children or not, preorderly
		// (Ex: A, B, D, E, C, F, G)
		// B has two children, E & F, and C has two children, F & G
		// The loop goes through and if E doesn't have children, it "pops" back up to B to find F
		private void preorder(MyBookNode node) {
			queue.add(node);
			if(node.getChildNodes() == null
					|| node.getChildNodes().isEmpty()) {
				return;
			}
			for(MyBookNode child : node.getChildNodes()) {
				preorder(child);
			}
		}
		@Override
		public boolean hasNext() {
			return !queue.isEmpty();
		}
		//This is our remove function
		//Removes the first item in the queue and moves on to the next in queue
		@Override
		public MyBookNode next() {
			return queue.removeFirst();
		}
	}
	
	private class MyBookIterator implements Iterator<MyBookNode> {
		Deque<MyBookNode> stack;
		public MyBookIterator() {
			stack = new ArrayDeque<>();
			stack.push(root);
		}
		
		@Override
		public boolean hasNext() {
			if(!stack.isEmpty()) {
				return true;
			}
			return false;
		}

		@Override
		public MyBookNode next() {
			MyBookNode node = stack.pop();
			List<MyBookNode> children = node.getChildNodes();
			//Cannot modify original list, make copy
			List<MyBookNode> copy = new ArrayList<>(children);
			Collections.reverse(copy);
			for(MyBookNode child : copy) {
				stack.push(child);
			}
			return node;
		}
		
	}
}
