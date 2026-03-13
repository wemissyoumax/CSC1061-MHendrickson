package edu.frcc.csc1061j.SearchEngine;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.jsoup.select.Elements;

public class Index {
	private Map<String, Set<TermCounter>> index = new HashMap<>();
	
	public void indexPage(String url, Elements paras) {
		TermCounter tc = new TermCounter(url);
		tc.processElement(paras);
		
		for(String key: tc.getKeySet()) {
			add(key, tc);
		}
	}
	
	private void add(String term, TermCounter tc) {
		Set<TermCounter> set = index.get(term);
		if(set == null) {
			set = new HashSet();
			index.put(term, set);
		}
		set.add(tc);
	}
	
	public String get(String term) {
		Set<TermCounter> stc =  index.get(term);
		String str = "";
		for(TermCounter tc : stc) {
			str = str + "\n\t\t" + tc.getURL();
		}
		return str;
	}
	
	public void printIndex() {
		for(String term: index.keySet()) {
			System.out.println(term);
			Set<TermCounter> stc = index.get(term);
			for(TermCounter tc : stc) {
				System.out.println("\t\t" + tc.getURL() + " " +tc.get(term));
			}
		}
	}
}
