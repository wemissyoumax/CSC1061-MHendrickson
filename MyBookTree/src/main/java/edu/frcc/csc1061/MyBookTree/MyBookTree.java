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
		return new MyBookIterator();
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
