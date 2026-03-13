package edu.frcc.csc1061j.SearchEngine;

import java.io.IOException;
import java.util.Scanner;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Driver {
	
	private static Scanner scn = new Scanner(System.in);
	
	public static void main(String[] args) throws IOException{
		WikiFetcher wf = new WikiFetcher();
		Index index = new Index();
		
		String url = "https://en.wikipedia.org/wiki/Java_(programming_language)";
		Elements paragraphs = wf.fetchWikipedia(url);
		TermCounter tc = new TermCounter(url);
		tc.processElement(paragraphs);
		tc.printCounts();
		index.indexPage(url, paragraphs);
		index.printIndex();
		
		url = "https://en.wikipedia.org/wiki/Java";
		paragraphs = wf.fetchWikipedia(url);
		index.indexPage(url, paragraphs);
		
		System.out.print("Enter search term: ");
		String term = scn.next().toLowerCase();
		System.out.println(index.get(term));
	}
}
