package edu.frcc.csc1061.MyBookTree;

import java.util.ArrayList;
import java.util.List;

public class MyBookNode implements Comparable<MyBookNode> {
	private String title;
	private int chapNum;
	private int secNum;
	private int subSecNum;
	private List<MyBookNode> childNodes;
	
	public MyBookNode(String title, int chapNum, int secNum,
			int subSecNum) {
		this.title = title;
		this.chapNum = chapNum;
		this.secNum = secNum;
		this.subSecNum = subSecNum;
		this.childNodes = new ArrayList<>();
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getChapNum() {
		return chapNum;
	}

	public void setChapNum(int chapNum) {
		this.chapNum = chapNum;
	}

	public int getSecNum() {
		return secNum;
	}

	public void setSecNum(int secNum) {
		this.secNum = secNum;
	}

	public int getSubSecNum() {
		return subSecNum;
	}

	public void setSubSecNum(int subSecNum) {
		this.subSecNum = subSecNum;
	}

	public List<MyBookNode> getChildNodes() {
		return childNodes;
	}
	
	@Override
	public String toString() {
		if(chapNum == 0) {
			return title;
		}
		if(secNum == 0) {
			return "\t" + chapNum + " " + title;
		}
		if(subSecNum == 0) {
			return "\t\t" + secNum + " " + title;
		}
		return "\t\t\t" + chapNum + "." + secNum + "." + subSecNum + " " + title;
	}

	@Override
	public int compareTo(MyBookNode o) {
		if(this.chapNum < o.chapNum) {
			return -1;
		} else if (chapNum > o.chapNum) {
			return 1;
		}
		//Chapter nums are equal, check sec nums
		if(secNum < o.secNum) {
			return -1;
		} else if(secNum > o.secNum) {
			return 1;
		}
		//Chapter and section nums are equal, check subsection nums
		if(subSecNum < o.subSecNum) {
			return -1;
		} else if(subSecNum > o.subSecNum) {
			return 1;
		}
		return 0;
	}
	
}
