package com.umons.model;

public class Rules {
	//est Parent de Pawn et de Grid
	private static Grid plateau;
	
	public Rules(Grid grid) {
		plateau = grid;
	}
	
	public static boolean rMove(int x, int y) {
		/**
		 * Test le deplacement d'un pion (hors grille, obstacle, ...)
		 */
		System.out.println("ok1");
		boolean inGrid = (x >= 0 && x < plateau.getLen() && y >= 0 && y < plateau.getLen());
		System.out.println("ok2");
		if (inGrid) {
			System.out.println("ok3");
			boolean caseNord = plateau.getItem(y+2, x).getFull();
			System.out.println("ok4");
			boolean caseSud = plateau.getItem(y-2, x).getFull();
			System.out.println("ok5");
			boolean caseOuest = plateau.getItem(y, x-2).getFull();
			System.out.println("ok6");
			boolean caseEst = plateau.getItem(y, x+2).getFull();
			System.out.println("ok7");
			boolean obstacle = caseNord && caseSud && caseOuest && caseEst;
			System.out.println("ok8");
			return (obstacle);
		}else {
			System.out.println("ok else");
			return false;
		}
	}
}
