package com.umons.model;

public class Grid {

	private Item[][] plateau;
<<<<<<< HEAD
=======
	public Pawn pion = new Pawn();
	
>>>>>>> 5ff4f167fac9dc5e59005e9d92b5db8421838efe
	public Grid() {
		//CONSTRUCTEUR PAR DEFAUT
		//Mode normal, grille 9x9(case)
		plateau = new Item[17][17];
	}
	
	public Grid(int length) {
		//CONSTRUCTEUR
		//Mode special, grille de longueur differente
		 plateau = new Item[length][length];
	}
	
	public void fillGrid() {
		//Rempli la grille avec les fentes et les cases
		for (int i = 0; i < plateau.length; i+=2) {
			for (int j = 0; j < plateau.length; j+=2) {
				plateau[i][j] = new Item(1);
			}
		}
		for (int i = 0; i < plateau.length; i+=2) {
			for (int j = 1; j < plateau.length; j+=2) { 
				plateau[i][j] = new Item(2);
			}
		}
		for (int i = 1; i < plateau.length; i+=2) {
			for (int j = 0; j < plateau.length; j++) {
				plateau[i][j] = new Item(2);
			}
		}
	}
	


	public void afficheGrid(){
		for (int i = 0; i < plateau.length; i+=2) {
			for (int j = 0; j < plateau.length; j++) {
				if (plateau[i][j].getLen() == 1){ // si on tombe sur une case
					System.out.print("O");
					//Affiche l'emplacement du pion #bug3
				}
				else if (pion.getY() == i & pion.getX() == j) {
					System.out.print("P");
				}else{
					System.out.print(" "); // si on tombe sur une fente
				}
			}
			System.out.print("\n                 \n");
		if (i < 16){ 
			// Ajout de ce 'if' pour que la grille ne se finisse pas par des murs (dans l'affichage)
			System.out.print("\n------------------\n");
		}
	  }
	}
	
}
