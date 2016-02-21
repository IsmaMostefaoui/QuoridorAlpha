package com.umons.model;

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
	
	/*
	 public void afficheGrid(Player joueur1, Player joueur2){
		for (int i = 0; i < plateau.length; i+=2) {
			for (int j = 0; j < plateau.length; j++) {
				if (joueur1.getPawn().getY()== i && joueur1.getPawn().getX() == j) {
					System.out.print("1"); //Fix bug #3 (voir classe Pawn)
				}else if (joueur2.getPawn().getY() == i && joueur2.getPawn().getX() == j){
					System.out.print("2");
				}else if (plateau[i][j].getLen() == 1){ // si on tombe sur une case
					System.out.print("O");
				}else{
					System.out.print(" "); // si on tombe sur une fente
				}
			}
			System.out.print("\n                 \n");
		}
	}
	 */

	public void afficheGrid(Player joueur1, Player joueur2){
		for (int i = 0; i < plateau.length; i++) {
			for (int j = 0; j < plateau.length; j++) {
				if (plateau[i][j].getFull()) {
					if (joueur1.getPawn().getX() == j && joueur1.getPawn().getY() == i) {
						System.out.print("1");
					}else if (joueur2.getPawn().getX() == j && joueur2.getPawn().getY() == i) {
						System.out.print("2");
					}else {
						System.out.print("X");
					}
				}else if (plateau[i][j].getLen() == 1) {
					System.out.print("O");
				}else {
					System.out.print(" ");
				}
			}
			System.out.println();
		}
	}
	
	public void setItemInGrid(int i, int j, boolean full) {
		/**
		 * Rempli ou non  la case
		 * @param la position (i, j) de l'item a modifier
		 * @param i est la ligne et j la colonne (ATTENTION, a ne pas confondre avec (x, y)
		 * @param le caractere rempli de la case associe a la position (i, j)
		 */
		plateau[i][j].setFull(full);
	}
}
