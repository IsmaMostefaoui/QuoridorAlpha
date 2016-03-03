package com.umons.model;

/**
 * Modélise un joueur.
 * Il possède :
 * -Une méthode pour bouger un pion
 * -Une méthode pour poser des murs
 * -Une varibale du nombre de murs restants (private avec accesseur)
 * -Deux varibale pour la position du pion
 * @author isma
 *
 */
public class Player{
	//faire hériter de Rules
	//Mur
	private int numberOfWall;
	//Pion
	private int posY;
	private int posX;
	
	/**
	 *Initialise les murs, le pion (1 ou 2)[les places respectivement sur chacun de leur côté] et la connection avec les cases [case full ou non]
	 * @param number est le "numero" du joueur (joueur 1 ou 2)
	 * @param grid un objet de type Grid representant le plateau sur lequel va se deplacer le pion
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
	 * Pose un mur sur la grille en remplissant les items de type 2. Affiche du texte !
	 * @param grid grille du jeu
	 * @param position prend "horizontal" ou "vertical"
	 * @param x prend la position en x de l'extremite gauche du mur horizontal, ou la colonne pour un mur vertical
	 * @param y prend la position en y de l'extremite supperieur du mur vertical, ou la ligne pour un mur horizontal
	 * @return un boolean, true si le mur à été placé, sinon false
	 */
	public boolean putWall(Grid grid, String position, int x, int y){
		
		if (position.equals("horizontal") && Rules.rPutWall(position, x, y) && Rules.rSlotFull(position, x, y)) {
			for (int j = x; j < x + 3; j++) {
				grid.setItemInGrid(y, j, true);
			}
			numberOfWall--; //anticipation pour quand on va devoir check si il a encore des murs etc...
			return true;
			
		}else if (position.equals("vertical") && Rules.rPutWall(position, x, y) && Rules.rSlotFull(position, x, y)) {
			for (int i = y; i < y + 3; i++) {
				grid.setItemInGrid(i, x, true);
			}
			numberOfWall--;
			return true;
		}
		System.out.println("impossible de placer un mur à cet endroit");
		return false; 
	}
	
	
	/**
	 * Transforme des entrées "direction" en coordonées (x, y) sur le plateau
	 * @param direction un String correspondant à la direction entré par le joueur ("z", "q", etc...)
	 * @return un tableau de int correspondant aux coordonnées (x, y) de la case où le joueur veut déplacer son pion
	 */
	public int[] stringToCoord(String direction) {
		// tableau de la forme {x, y}
		int[] tabCoord = new int[2];
		switch (direction) {
		case "z":
			tabCoord[0] = posX; tabCoord[1] = posY -2;
			return tabCoord;
		case "s":
			tabCoord[0] = posX; tabCoord[1] = posY +2;
			return tabCoord;
		case "d":
			tabCoord[0] = posX+2; tabCoord[1] = posY;
			return tabCoord;
		case "q":
			tabCoord[0] = posX-2; tabCoord[1] = posY;
			return tabCoord;
		case "dbd":
			tabCoord[0] = posX+2; tabCoord[1] = posY+2;
			return tabCoord;
		case "dbg":
			tabCoord[0] = posX-2; tabCoord[1] = posY+2;
			return tabCoord;
		case "dhg":
			tabCoord[0] = posX-2; tabCoord[1] = posY-2;
			return tabCoord;
		case "dhd":
			tabCoord[0] = posX+2; tabCoord[1] = posY-2;
			return tabCoord;
		default:
			return null;
		}
	}
	
	
	/**
	 * Deplace le pion selon une direction (donné en tableau de coordonnées (x, y))
	 * @param grid un objet de type Grid representant le tableau sur lequel le pion doit se deplacer
	 * @param tabCoord tableau des coordonnées représentant les coordonnées de l'endroit où le pion va se déplacer
	 */
	public boolean move(Grid grid, int[] tabCoord) {
		if (Rules.rMovePion(tabCoord[0], tabCoord[1]) && !(Rules.rcheckWall(this, tabCoord))) {
			grid.setItemInGrid(posY, posX, false);
			posX = tabCoord[0]; posY = tabCoord[1]; /* Je fait la mise à jour du pion sur le plateau ici, parce que vu qu'on appelle 
														stringToCoord avant move dans Main, si je
			/* 										 * fait la mise à jour dans stringToCoord, les coordonées du pion vont directement changer
			 * Ici, il suffit de changer posX et 
			 * PosY puisque ça corresond déjà au 
			 * bonne coordonées.					
			 */
												   /* et une fois arriver ici, faire grid.setItemInGrid(posY, posX, false); et ennsuite 
													 * grid.setItemInGrid(posY, posX, true); reviendra à vider la case du pion
													 * puis a la remplir... Puisque les coordonées du pion sont changé, dans le premier appel
													 *  à la méthode les posX et posY sont les même que dans le deuxième appel à setItemInGrid();
													 */
			grid.setItemInGrid(tabCoord[1], tabCoord[0], true);
			return true;
		}else if (Rules.rMovePion(tabCoord[0], tabCoord[1]) && !(Rules.rcheckWall(this, tabCoord))){
			grid.setItemInGrid(posY, posX, false);
			posX = tabCoord[0]; posY = tabCoord[1];
			grid.setItemInGrid(tabCoord[1], tabCoord[0], true);
			return true;
		}else{
			return false;
		}
	}
	
	
	
	
	/*
	 * Deplace le pion selon une direction. Affcihe du texte pour "dd" et "dg"
	 * @param direction un String ("z", "s", "d", "q") resp. (nord, sud, est, ouest)
	 * @param grid un objet de type Grid representant le tableau sur lequel le pion doit se deplacer
	 
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
			if (!Rules.rMovePion(posX, posY+2) &&  !Rules.rMovePion(posX, posY+3) && Rules.rMovePion(posX+2, posY+2)) {
				grid.setItemInGrid(posY, posX, false);
				posX += 2;
				posY += 2;
				grid.setItemInGrid(posY, posX, true);
				return true;
			}else {
				System.out.println("Vous n'êtes pas autorisé à allez sur la digonale de droite !");
				return false;
			}
		case "dg":
			if (!Rules.rMovePion(posX, posY+2) &&  !Rules.rMovePion(posX, posY+3) && Rules.rMovePion(posX+2, posY+2)) {
				grid.setItemInGrid(posY, posX, false);
				posX -= 2;
				posY += 2;
				grid.setItemInGrid(posY, posX, true);
				return true;
			}else {
				System.out.println("Vous n'êtes pas autorisé à allez sur la digonale de gauche !!");
				return false;
			}
		}
		//si le gars n a pas saisi la bonne direction
		return false;
	}
	*/
	
	/**
	 * @return numberOfWall un int représentant le nombre de mur restant du joueur courant
	 */
	public int getNumberOfWall() {
		
		return numberOfWall;
	}
	
	/**
	 * Accesseur
	 * @return posY la position en y du Pion (LIGNE)
	 */
	public int getPawnY() {
		
		return posY;	
	}
	
	/**
	 * Accesseur
	 * @return posX la position du Pion (COLONNE)
	 */
	public int getPawnX(){
		
		return posX;
	}
}
