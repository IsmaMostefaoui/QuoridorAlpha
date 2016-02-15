package com.umons.model;

public class Grid {

	private Square[][] plateau;
	
	public Grid() {
		//CONSTRUCTEUR PAR DEFAUT
		//Mode normal, grille 9x9
		plateau = new Square[9][9]; // Bug #1 : Grille initialisé avec des objets Square !
									// Or, besoin de placer des objets slot une fois sur deux
	}
	
	public Grid(int length) {
		//CONSTRUCTEUR
		//Mode special, grille de longueur differente
		 plateau = new Square[length][length];
	}
	
	public void fillGrid() {
		for (int i = 0; i < plateau.length; i+=2)
			for (int j = 0; j < plateau.length; i+=2) 
				plateau[i][j] = new Square();
		for (int i = 0; i < plateau.length; i+=2)
			for (int j = 1; j < plateau.length; i+=2) 
				plateau[i][j] = new Slot(); //Bug #1 : Impossible de transformer le type du tableau
											//Pour qu'il supporte le type Slot
	}
	/*
	 * Pas important !
	public String toString() {
	  String s = "|x|x|x|x|x|x|x|x|x|x|\n"
		+ "---------------------\n"
		+ "| | | | |O| | | | |\n"
		+ "| | | | | | | | | |\n"
		+ "| | | | | | | | | |\n"
		+ "| | | | | | | | | |\n"
		+ "| | | | | | | | | |\n"
		+ "| | | | | | | | | |\n"
		+ "| | | | | | | | | |\n"
		+ "| | | | | | | | | |\n"
		+ "| | | | |O| | | | |\n"
		+ "---------------------\n"
		+ "|x|x|x|x|x|x|x|x|x|x|\n";
	  return s;
	}
	*/
}
