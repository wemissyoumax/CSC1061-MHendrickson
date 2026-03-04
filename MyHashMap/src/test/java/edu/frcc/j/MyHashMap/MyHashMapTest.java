package edu.frcc.j.MyHashMap;

import java.util.Map;

public class MyHashMapTest {

	public static void main(String[] args) {
		Map<String, Integer> map = new MyHashMap();
		map.put("3", 3);
		map.put("5", 5);
		map.put("1", 1);
		
		System.out.println("Entries in Map");
		for(String key : map.keySet()) {
			System.out.print(key + ' ');
		}
		System.out.println();
		map.remove("5");
		
		System.out.println("After Remove Entries in Map");
		for(String key : map.keySet()) {
			System.out.print(key + ' ');
		}
	}

}
