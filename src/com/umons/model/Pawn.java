
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
	public Pawn(int number) {
		/**
		 * Constructeur par défaut de la classe Pawn
		 * @param le numero du joueur (initialisera en fonction du joueur 1 ou 2)
		 * @param place le pion au centre si pas de number valide
		 */
		//La grille comporte 17 case mais on commence à 0 donc (0 -> 16)
		this.posX = 8;
		if (number == 1) {
			this.posY = 16;
		}else if (number == 2){
			this.posY = 0;
		}else {
			//Si pas 1 ou 2, alors on le place au mileu
			this.posY = 8;
		}
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
		 * @return la position du Pion (colonne)
		 */
		return posX;
	}
	
	public void move(int x, int y) {
		/**
		 * Mutateur de Pawn, change la position du pion.
		 * @param bouge le pion en coordonnées (x, y)
		 */
	}
}
