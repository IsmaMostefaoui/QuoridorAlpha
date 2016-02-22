
package com.umons.model;

public class Pawn {

	private int posY;
	private int posX;
	
	/*public Pawn(int posX,int posY){
		/**
		 * Constructeur de la classe Pawn 
		 * @param position de x
		 * @param position de y 
		 
		this.posX = posX;
		this.posY = posY;
		
	}*/
	public Pawn(int number, Grid grid) {
		/**
		 * Constructeur par défaut de la classe Pawn
		 * connecte le pion à l'item(1)(la case)
		 * @param le numero du joueur (initialisera en fonction du joueur 1 ou 2)
		 * @param la grille sur laquelle il sera pose (car besoin de remplir la case)
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
		//connection avec la case
		//Rempli la case du joueur 2
		grid.setItemInGrid(0, 8, true);
		//Rempli la case du joueur 1
		grid.setItemInGrid(16, 8, true);
	}
		
	public int getY() {
		/**
		 * Accesseur
		 * @return la position en y du Pion (LIGNE)
		 */
		return posY;	
	}
	
	public int getX(){
		/**
		 * Accesseur
		 * @return la position du Pion (COLONNE)
		 */
		return posX;
	}
	
	public boolean move(String direction, Grid grid) {
		/**
		 * Mutateur de Pawn, deplace pion.
		 * @param bouge le pion d'une case en fonction de la direction
		 * @param ouest, est, nord, sud
		 */
		//On verra ça plus tard, en gros, ce sont des enchainements de else if plus lisible
		switch (direction) {
		//permet d'enlever de la grille le pion et de le remmettre sur les nouvelles coordonees
		case "nord":
			if (Rules.rMove(this.posX, posY)) { //ici c'est x, y car la methode s occupe de l inversement ligne colonne
				grid.setItemInGrid(this.posY, this.posX, false);
				this.posY -= 2;
				grid.setItemInGrid(this.posY, this.posX, true);
				return true;
			}else {
				return false;
			}
		case "ouest":
			if (Rules.rMove(this.posX, posY)){
				grid.setItemInGrid(this.posY, this.posX, false);
				this.posX -= 2;
				grid.setItemInGrid(this.posY, this.posX, true);
				return true;
			}else {
				return false;
			}
		case "est":
			if (Rules.rMove(this.posX, posY)) {
				grid.setItemInGrid(this.posY, this.posX, false);
				this.posX += 2;
				grid.setItemInGrid(this.posY, this.posX, true);
				return true;
			}else {
				return false;
			}
		case "sud":
			if (Rules.rMove(this.posX, posY)) {
				grid.setItemInGrid(this.posY, this.posX, false);
				this.posY += 2;
				grid.setItemInGrid(this.posY, this.posX, true);
				return true;
			}else {
				return false;
			}
		}
		//si le gars n a pas saisi la bonne direction
		return false;
	}
}
