package com.umons.model;

public class Player{
	//faire hériter de Rules
	//Mur
	private int numberOfWall;
	//Pion
	private int posY;
	private int posX;
	
	/**
	 *Initialise les murs, le pion (1 ou 2) et la connection avec les cases
	 * @param number est le "numero" du joueur (joueur 1 ou 2)
	 **/
	public Player(int number, Grid grid) {
		
		numberOfWall = 10;
		//initialisation du pion
		posX = 9;
		if (number == 1) {
			posY = 17;
		}else if (number == 2){
			posY = 1;
		}else {
			//Si pas 1 ou 2, alors on le place au mileu
			posY = 9;
		}
		//connection avec la case
		//Rempli la case du joueur 2
		grid.setItemInGrid(1, 9, true);
		//Rempli la case du joueur 1
		grid.setItemInGrid(17, 9, true);
	}
	
	/**
	 * Pose un mur sur la grille en remplissant les item de type 2
	 */
	public void putWall(Grid grid, String position, int x, int y){
		
		if (position.equals("horizontal") && Rules.rPutWall(position, x, y)){
			for (int j = x; j < x + 3; j++) {
				grid.setItemInGrid(y, j, true);
			}
		}else if (Rules.rPutWall(position, x, y)) {
			for (int i = y; i < y + 3; i++) {
				grid.setItemInGrid(i, x, true);	
			}
		}
	}
	
	/**
	 * Mutateur de Pawn, deplace pion.
	 * @param bouge le pion d'une case en fonction de la direction
	 * @param ouest, est, nord, sud
	 */
	public boolean move(String direction, Grid grid) {
		
		//On verra ça plus tard, en gros, ce sont des enchainements de else if plus lisible
		switch (direction) {
		//permet d'enlever de la grille le pion et de le remmettre sur les nouvelles coordonees
		case "z":
			if (Rules.rMovePion(posX, posY-2)) { //ici c'est x, y car la methode s occupe de l inversement ligne colonne, -2 car tout en bas
				grid.setItemInGrid(posY, posX, false);
				posY -= 2;
				grid.setItemInGrid(posY, posX, true);
				return true;
			}else if (Rules.rMovePion(posX, posY-4)){
				//Saute pion
				grid.setItemInGrid(posY, posX, false);
				posY -= 4;
				grid.setItemInGrid(posY, posX, true);
				return true;
			}else {
				return false;
			}
		case "q":
			if (Rules.rMovePion(posX-2, posY)){
				grid.setItemInGrid(posY, posX, false);
				posX -= 2;
				grid.setItemInGrid(posY, posX, true);
				return true;
			}else if (Rules.rMovePion(posX-4, posY)){
				//Saute pion
				grid.setItemInGrid(posY, posX, false);
				posX -= 4;
				grid.setItemInGrid(posY, posX, true);
				return true;
			}else {
				return false;
			}
		case "d":
			if (Rules.rMovePion(posX+2, posY)) {
				grid.setItemInGrid(posY, posX, false);
				posX += 2;
				grid.setItemInGrid(posY, posX, true);
				return true;
			}else if (Rules.rMovePion(posX+4, posY)){
				//Saute pion
				grid.setItemInGrid(posY, posX, false);
				posX += 4;
				grid.setItemInGrid(posY, posX, true);
				return true;
			}else {
				return false;
			}
		case "s":
			if (Rules.rMovePion(posX, posY+2)) {
				grid.setItemInGrid(posY, posX, false);
				posY += 2;
				grid.setItemInGrid(posY, posX, true);
				return true;
			}else if (Rules.rMovePion(posX, posY+4)){
				//Saute pion
				grid.setItemInGrid(posY, posX, false);
				posY += 4;
				grid.setItemInGrid(posY, posX, true);
				return true;
			}else {
				return false;
			}
		case "dd":
			if (!Rules.rMovePion(posX, posY+2) && (!Rules.rMovePion(posX, posY+4)) && Rules.rMovePion(posX+2, posY+2)) {
				grid.setItemInGrid(posY, posX, false);
				posX+=2;
				posY += 4;
				grid.setItemInGrid(posY, posX, true);
			}
		}
		//si le gars n a pas saisi la bonne direction
		return false;
	}
	
	/**
	 * @return le nombre de mur du joueur de type int
	 */
	public int getNumberOfWall() {
		
		return numberOfWall;
	}
	
	/**
	 * Accesseur
	 * @return la position en y du Pion (LIGNE)
	 */
	public int getPawnY() {
		
		return posY;	
	}
	
	/**
	 * Accesseur
	 * @return la position du Pion (COLONNE)
	 */
	public int getPawnX(){
		
		return posX;
	}
}
