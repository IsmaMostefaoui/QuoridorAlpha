package com.umons.model;

public class Grid {

	private Item[][] plateau;
	
	public Grid() {
		//CONSTRUCTEUR PAR DEFAUT
		//Mode normal, grille 9x9(case)
		plateau = new Item[19][19];
	}
	
	public Grid(int length) {
		//CONSTRUCTEUR
		//Mode special, grille de longueur differente
		 plateau = new Item[length][length];
	}
	
	public void fillGrid() {
		/**
		 * Rempli la grille avec des cases vide et des fentes vide
		 * Laisse un espace d'un item sur chaque cote de la grille pour
		 * les isma error
		 */
		for (int i = 1; i < plateau.length-1; i+=2) {
			for (int j = 1; j < plateau.length-1; j+=2) {
				plateau[i][j] = new Item(1);
			}
		}
		for (int i = 1; i < plateau.length-1; i+=2) {
			for (int j = 2; j < plateau.length-1; j+=2) { 
				plateau[i][j] = new Item(2);
			}
		}
		for (int i = 2; i < plateau.length-1; i+=2) {
			for (int j = 1; j < plateau.length-1; j++) {
				plateau[i][j] = new Item(2);
			}
		}
		//Rempli les espaces d'item de type 3 et les met en true pour simuler le bord
		for (int i = 0; i < plateau.length; i++) {
			plateau[0][i] = new Item(3);
			plateau[0][i].setFull(true);
			plateau[18][i] = new Item(3);
			plateau[18][i].setFull(true);
			plateau[i][0] = new Item(3);
			plateau[i][0].setFull(true);
			plateau[i][18] = new Item(3);
			plateau[i][18].setFull(true);
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
					if (joueur1.getPawnX() == j && joueur1.getPawnY() == i) {
						System.out.print("[1]");
					}else if (joueur2.getPawnX() == j && joueur2.getPawnY() == i) {
						System.out.print("[2]");
					}else if (plateau[i][j].getType() == 3) {
						System.out.print("###");
					}else {
						System.out.print("***");
					}
				}else if (plateau[i][j].getType() == 1) {
					System.out.print("[ ]");
				}else {
					System.out.print("   ");
				}
			}
			System.out.println();
		}
		System.out.println(" 0  1  2  3  4  5  6  7  8  9 10 11 12 13 14 15 16 17 18");
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
	
	public int getLen() {
		/**
		 * @return la fausse longueur du plateau
		 */
		return plateau.length;
	}
	
	public Item getItem(int i, int j) {
		return plateau[i][j];
	}
}
