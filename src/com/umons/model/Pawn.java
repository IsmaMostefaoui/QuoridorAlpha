
package com.umons.model;

public class Pawn {

	private int posY;
	private int posX;
	
	public Pawn(int posX,int posY){
		/**
		 * Constructeur de le classe Pawn 
		 * @param position de x
		 * @param position de y 
		 */
		this.posX = posX;
		this.posY = posY;
	}
	public Pawn() {
		/**
		 * Constructeur par défaut de la classe Pawn, initialise x = 7 et y = 16
		 */
		this.posX = 8;
		this.posY = 17;//
	}
		
	public int getY() {
		/**
		 * Accesseur
		 * @return la position en y du Pion (ligne)
		 */
		return posY;	
	}
	
	public int getX(){
		/**
		 * Accesseur
		 * @return la position en  du Pion (colonne)
		 */
		return posX;
	}
	
	public void move(int x) {
		/**
		 * Mutateur de Pawn, change la position du pion.
		 * @param x nouvelle coordonnée en x du pion
		 * @param y nouvelle coordonnée en y du pion
		 *
		 */
		}
	}
	