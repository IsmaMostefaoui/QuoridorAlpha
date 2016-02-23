package com.umons.model;

public class Player{
	//faire hériter de Rules
	
	//Mur
	private int numberOfWall;
	//Pion
	private int posY;
	private int posX;
	
	public Player(int number, Grid grid) {
		/**
		 *Initialise les murs, le pion (1 ou 2) et la connection avec les cases
		 * @param number est le "numero" du joueur (joueur 1 ou 2)
		 **/
		numberOfWall = 10;
		//initialisation du pion
		posX = 8;
		if (number == 1) {
			posY = 16;
		}else if (number == 2){
			posY = 0;
		}else {
			//Si pas 1 ou 2, alors on le place au mileu
			posY = 8;
		}
		//connection avec la case
		//Rempli la case du joueur 2
		grid.setItemInGrid(0, 8, true);
		//Rempli la case du joueur 1
		grid.setItemInGrid(16, 8, true);
	}
	
	public void putWall(Grid grid, String position, int x, int y){
		/**
		 * Pose un mur sur la grille en remplissant un les item de type 2
		 */
		if (position.equals("horizontal")){
			//appele aux verif de Rules
			for (int j = y; j < y + 3; j++){
				grid.setItemInGrid(x, j, true);
			}
		}else {
			//appele aux verif
			for (int i = x; i < x + 3; i++){
				grid.setItemInGrid(i, y, true);	
			}
		}
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
	
	//Accesseur des murs
	public int getNumberOfWall() {
		/**
		 * @return le nombre de mur du joueur de type int
		 */
		return numberOfWall;
	}
	
	//Accesseur du pion
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
	
}
