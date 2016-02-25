package com.umons.model;

public class Rules {
	//est Parent de Pawn et de Grid
	private static Grid plateau;
	
	public Rules(Grid grid) {
		plateau = grid;
	}
	
	public static boolean rMovePion(int x, int y) {
		/**
		 * Test si la case ou le pion veut aller est occupé ou non
		 * Permet de gerer le face to face
		 * @param les coordonées (x, y) de la case a verifier
		 * @return vari si la case vide, faux sinon
		 */
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
}	
	
