package com.umons.model;
//test branch robin182
public class Grid {

	private Item[][] plateau;
	
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
				if (plateau[i][j].getLen() == 1){
					System.out.print("O");
				}else{
					System.out.print("|");
				}
			}
			System.out.print("\n------------------\n");
	  }
	}
}
