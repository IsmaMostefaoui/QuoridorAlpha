package com.umons.model;

public class Item {
	/*
	 * Regroupe la modelisation du slot et du square
	 * (resp. la fente pour le mur et les case pour les pions)
	 */
	private boolean full;
	private int len; //1 pour square et 2 pour slot
	
	public Item(int len) {
		//Constructeur par defaut, initialise l'item à false
		this.full = false;
		this.len = len;
	}
	
	public Item(boolean full, int len) {
		this.full = full;
		this.len = len;
	}
	
	public boolean getFull() {
		/**
		 * Accesseur du caractere rempli de la case
		 */
		return full;
	}
	
	public void setFull(boolean full) {
		/**
		 * Mutateur pour full
		 * @param le caractere rempli ou non de l'Item
		 */
		this.full = full;
	}
	
	public int getLen() {
		//1 == Square
		//2 == Slot
		return len;
	}

}
