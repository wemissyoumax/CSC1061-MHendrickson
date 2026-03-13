package edu.frcc.csc1061j.SearchEngine;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.jsoup.nodes.Node;
import org.jsoup.nodes.TextNode;
import org.jsoup.select.Elements;
//For the specific page that has the amount (value) of 
// key (word) that we are searching for
public class TermCounter {
	
	private Map<String, Integer> map;
	private String url;
	
	public TermCounter(String url){
		this.url = url;
		map = new HashMap<>();
	}
	
	public String getURL() {
		return url;
	}
	
	public void processElement(Elements paras) {
		for(Node node : paras) {
			processTree(node);
		}
	}
	
	private void processTree(Node root) {
		for(Node node: new WikiNodeIterable(root)) {
			if(node instanceof TextNode) {
				processText(((TextNode) node).text());
			}
		}
	}
	//This is our regular expression (which we need to look up on our own time)
	private void processText(String text) {
		//Replace all punctuation with empty string, conver to lower case
		// and split on one or more spaces
		String[] tokens = text.replace("\\pP", "").toLowerCase().split("\\s+");
		for (int i = 0; i < tokens.length; i++) {
			String term = tokens[i];
			incrementTermCount(term);
		}
	}
	//--Ternerary Operator Example (?:)--
	// Could write it as:
	// int cnt = count == null ? 0 : count;
	// If condition is TRUE, BEFORE the colon executes
	// If condition is FALSE, AFTER colon executes
	private void incrementTermCount(String term) {
		Integer count = map.get(term);
		int cnt;
		if(count == null) {
			cnt = 0;
		} 
		else {
			cnt = count;
		}
		map.put(term, ++cnt);
	}
	
	public Set<String> getKeySet(){
		return map.keySet();
	}
	
	public Integer get(String term) {
		Integer count = map.get(term);
		int cnt = count == null ? 0 : count;
		return cnt;
	}
	
	
	public void printCounts() {
		for(String key : map.keySet()) {
			int count = map.get(key);
			System.out.println(key + "," + count);
		}
		System.out.println("Number of terms: " + map.size());
	}
	
}
