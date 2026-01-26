package com.maxwell.oop;

public class Radio {
	private static final int MAX_VOLUME = 11;
	private int volume = 0;
	private boolean hasAntenna = false;
	
	public int getVolume() {
		return volume;
		
	}
	public void setVolume(int volume) {
		this.volume = volume;
	}
	public boolean hasAntenna() {
		return hasAntenna;
	}
	public void setHasAntenna(boolean hasAntenna) {
		this.hasAntenna = hasAntenna;
	}
	@Override
	public String toString() {
		return "Radio [volume=" + volume + ", hasAntenna=" + hasAntenna + "]";
	}
	
	
	
}
