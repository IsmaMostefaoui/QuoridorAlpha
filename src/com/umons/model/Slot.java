package com.umons.model;

public class Slot {

	private boolean full;
	
	public Slot() {
		//CONSTRUCTEUR PAR DEFAUT
		this.full = false;
	}
	
	public Slot(boolean full) {
		this.full = full;
	}
	
	public boolean getFull() {
		return full;
	}
}
