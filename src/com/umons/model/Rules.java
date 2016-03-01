package com.umons.model;

/**
 * Contient toutes les méthodes (static) concernant les règles du jeu Quoridor.
 * @author isma
 * @author robin
 *
 */
public class Rules {
	//est Parent de Pawn et de Grid
	private static Grid plateau;

	/**
	 * Initialise un plateau (celui sur lequel sera appliquer toutes les règles.
	 * @param grid le plateau
	 */
	public Rules(Grid grid) {
		plateau = grid;
	}

	/**
	 * Vérifie si un pion peut ou pas bouger. Les coordonnées représentent l'endroit où le pion va bouger
	 * @param x un int représentant les coordonées des colonnes
	 * @param y un int représentant les coordonées des lignes
	 * @return un boolean vrai si le pion peut bouger, faux sinon
	 */
	public static boolean rMovePion(int x, int y) {
		/*
		 * A changer ! TODO 
		 * Reprendre la méthode de checkWall...
		 * Ajouter la validation
		 */
		
		boolean inGrid = (x >= 0 && x < plateau.getLen() && y >= 0 && y < plateau.getLen());
		if (inGrid) {
			boolean caseFull = plateau.getItem(y, x).getFull();
			return !(caseFull);
		}else {
			return false;
		}
	}
	
	
	
	/*
	public static boolean rFaceToFace(int x, int y) {
		
	}*/

	
	
	
	/**
	 * Vérifie si le mur peut être posé aux coordonées souhaitées
	 * @param pos prend un String "horizontal" ou "vertical"
	 * @param x prend la position en x de l'extremite gauche du mur horizontal, ou la colonne pour un mur vertical
	 * @param y prend la position en y de l'extremite supperieur du mur vertical, ou la ligne pour un mur horizontal
	 * @return un boolean, true si le mur peut potentiellement être posé à cette position, sinon false
	 */
	public static boolean rPutWall(String pos, int x, int y) {
		if (pos.equals("horizontal")) {
			if (x % 2 != 0 && y % 2 == 0) {
				//verifie si le mur n'est pas sur une case
					return true;
				}
				return false;
		}else {
			if (x % 2 == 0 && y % 2 != 0) {
				//verifie si le mur n'est pas sur une case
				return true;
			}
			return false;
		}
	}
	
	/**
	 * Vérifie si le mur est placé dans une fente(Slot) libre
	 * @param position prend un String "horizontal" ou "vertical"
	 * @param x prend la position en x de l'extremite gauche du mur horizontal, ou la colonne pour un mur vertical
	 * @param y prend la position en y de l'extremite supperieur du mur vertical, ou la ligne pour un mur horizontal
	 * @return un boolean, true si le mur peut potentiellement être posé à cette position, sinon false
	 */
	public static boolean rSlotFull (String position, int x, int y) {
		//Pour la verification d'un MUR
		if (position.equals("horizontal")) {
			for (int j = x; j < x + 3; j++) {
				if (plateau.getItem(y,j).getFull()) {
					return false;	
				}
			}
			return true;
		}else {
			for (int i = y; i < y + 3; i++) {
				if (plateau.getItem(i, x).getFull()) {
					return false;
				}
			}
			return true;
		}
	}

	/**
	 * Check si un mur se situe dans la direction souhaitée
	 * @param joueur l'instance du joueur courant
	 * @param tabCoord un tableau de type int contenant les coordonées (x, y) correspondant à la position ou le pion compte se rendre
	 * @return true s'il y a un mur false sinon
	 */
	public static boolean rcheckWall(Player joueur, int[] tabCoord) {
		//Pour la verification d'un PION
		int ytemp = tabCoord[1] - joueur.getPawnY();
		int xtemp = tabCoord[0] - joueur.getPawnX();
		ytemp = joueur.getPawnY() + ytemp/2;
		xtemp = joueur.getPawnX() + xtemp/2;
		return plateau.getItem(ytemp, xtemp).getFull();
	}
}	

	
