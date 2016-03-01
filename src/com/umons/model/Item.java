package com.umons.model;
/**
	 * Regroupe la modelisation du slot et du square
	 * (resp. la fente pour le mur et les case pour les pions)
	 */
public class Item {
	
	private boolean full;
	private int type; //1 pour square et 2 pour slot
	
	/**
	 * Initialise un item
	 * @param type un int représentant le type de l'item (1, 2 ou 3)
	 */
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
	 *@return un boolean si l'item (de n'importe quel type) est rempli, faux sinon
	 */
	public boolean getFull() {
		
		return full;
	}
	
	/**
	 * Rempli un item
	 * @param full un boolean vrai si la case est remplie, faux sinon
	 */
	public void setFull(boolean full) {
		
		this.full = full;
	}
	/**
	 * @return le type de l'item
	 */
	public int getType() {
		//1 == Square
		//2 == Slot
		//3 == Bord
		return type;
	}

}
