package com.umons.model;

public class Item {
	/*
	 * Regroupe la modelisation du slot et du square
	 * (resp. la fente pour le mur et les case pour les pions)
	 */
	private boolean full;
	private int type; //1 pour square et 2 pour slot
	
	public Item(int type) {
		//Constructeur par defaut, initialise l'item à false
		this.full = false;
		this.type = type;
	}
	
	public Item(boolean full, int type) {
		this.full = full;
		this.type = type;
	}
	
	/**
	 * Accesseur du caractere rempli de la case
	 */
	public boolean getFull() {
		
		return full;
	}
	
	/**
	 * Mutateur pour full
	 * @param le caractere rempli ou non de l'Item
	 */
	public void setFull(boolean full) {
		
		this.full = full;
	}
	
	public int getType() {
		//1 == Square
		//2 == Slot
		//3 == Bord
		return type;
	}

}
