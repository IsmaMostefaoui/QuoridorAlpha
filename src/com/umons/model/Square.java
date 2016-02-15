
package com.umons.model;

public class Square {

	private boolean busy;
	
	public Square() {
		//CONSTRUCTEUR PAR DEFAUT
		this.busy = false;
	}
	
	public Square(boolean busy) {
		this.busy = busy;
	}
	
	public boolean getBusy() {
		return busy;
	}
	
	/*
	public void setBusy(Boolean busy) {
		this.busy = busy;
	}
	*/
}
