package com.umons.model;

public class Rules {
	//est Parent de Pawn et de Grid
	private static Grid plateau;
	
	public Rules(Grid grid) {
		plateau = grid;
	}

	/**
	 * Test si la case ou le pion veut aller est occupé ou non
	 * Permet de gerer le face to face
	 * @param les coordonées (x, y) de la case a verifier
	 * @return vari si la case vide, faux sinon
	 */
	public static boolean rMovePion(int x, int y) {
		
		boolean inGrid = (x >= 0 && x < plateau.getLen() && y >= 0 && y < plateau.getLen());
		if (inGrid) {
			boolean caseFull = plateau.getItem(y, x).getFull();
			return !(caseFull);
		}else {
			return false;
		}
	}
	
	/* Inutile pour l'instant, attente de mise a jour
	public static boolean rFaceToFace(int x, int y) {
		return (rMovePion(x, y) && !(plateau.getItem(y, x).getFull()));
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
}	

	
