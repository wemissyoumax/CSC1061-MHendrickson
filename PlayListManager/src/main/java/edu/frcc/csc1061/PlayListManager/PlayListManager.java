package edu.frcc.csc1061.PlayListManager;

import java.util.List;

public class PlayListManager {

	public static void main(String[] args) {
		List<Integer> ll = new MyDoubleLinkedList<>();
		ll.add(1);
		ll.add(2);
		ll.add(3);
		
		for (Integer x: ll) {
			System.out.println(x + " ");
		}
		System.out.println();
	}

}
