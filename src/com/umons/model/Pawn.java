
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
	
	public void move(String direction) {
		/**
		 * Mutateur de Pawn, deplace pion.
		 * @param bouge le pion de une case en fonction de la direction
		 * @param ouest, est, nord, sud
		 */
		//On verra ça plus tard, en gros, ce sont des enchainement de else if plus lisible
		switch (direction) {
		case "nord":
			this.posY += 2;
			break;
		case "ouest":
			this.posX -= 2;
			break;
		case "est":
			this.posX += 2;
			break;
		case "sud":
			this.posY -= 2;
			break;
		}
	}
}
