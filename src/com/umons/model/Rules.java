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
		 * @parm les coordonées (x, y) de la case a verifier
		 * @return vari si la case vide, faux sinon
		 */
		System.out.println("ok1");
		boolean inGrid = (x >= 0 && x < plateau.getLen() && y >= 0 && y < plateau.getLen());
		System.out.println("ok2");
		if (inGrid) {
			System.out.println("ok3");
			boolean caseFull = plateau.getItem(y, x).getFull();
			return !(caseFull);
		}else {
			System.out.println("ok else");
			return false;
		}
	}
	
	public static boolean rMoveWall(int x, int y) {
		/**
		 * Test si la fente en face du pion est occupe ou non
		 */
		return true;
	}
}
