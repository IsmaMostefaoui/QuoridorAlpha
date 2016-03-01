package com.umons.model;

/**
 * Modélise une grille.
 * Possède :
 * -Une méthode pour remplir la grille
 * -Une méthode pour afficher la grille
 * @author isma
 * @author robin
 *
 */
public class Grid {
	//Herite des methodes de Rules

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
	
	/**
	 * Rempli la grille avec des cases vides et des fentes vides
	 * Laisse un espace d'un item sur chaque côté de la grille pour
	 * les ISMA ERROR (erreur d'index)
	 */
	public void fillGrid() {
		
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
	
	public void afficheGrid(Player joueur1, Player joueur2){
		//A CHNAGER IL suffit de créer 3 sous-classe de la classe item, de définir surcharger la méthode toString pour chacune des sous-classe
		//et on oublie tous ces if... Selon qu'on a un bord, une case ou une fente, elle s'affichera toute seule !!
		for (int i = 0; i < plateau.length; i++) {
			//Affiche les numéros de lignes pour faciliter les tests
			if (i<10){
				System.out.print("" + i + "  ");
			}else{
				System.out.print("" + i + " ");
			}
			//Fin de l'affichage des lignes
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
		System.out.println("    0  1  2  3  4  5  6  7  8  9 10 11 12 13 14 15 16 17 18");
	}
	
	/**
	 * Rempli ou non  la case (ATTENTION, à ne pas confondre avec (x, y)
	 * @param i est la ligne
	 * @param j la colonne
	 * @param full le caractère rempli de la case associé à la position (i, j)
	 */
	public void setItemInGrid(int i, int j, boolean full) {
		
		plateau[i][j].setFull(full);
	}
	
	/**
	 * @return la longueur du plateau
	 */
	public int getLen() {
		
		return plateau.length;
	}
	
	/**
	 * 
	 * @param i le numéro de la ligne
	 * @param j le numéro de la colonne
	 * @return un objet de type Item à l'emplacement i, j
	 */
	public Item getItem(int i, int j) {
		return plateau[i][j];
	}
}
