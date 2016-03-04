package com.umons.model;

/**
 * Contient toutes les méthodes (static) concernant les règles du jeu Quoridor.
 * @author isma
 * @author robin
 *
 */
public class Rules {

	private static Grid plateau;

	
	
	/**
	 * Initialise un plateau (celui sur lequel sera appliquer toutes les règles.
	 * @param grid le plateau
	 */
	public Rules(Grid grid) {
		plateau = grid;
	}
	
	
	

	/**
	 * Vérifie si un pion adverse se situe sur la position souhaitée. Le tablau de coordonnées représente l'endroit où le pion va bouger
	 * @param x un int représentant les coordonées des colonnes
	 * @param y un int représentant les coordonées des lignes
	 * @return un boolean vrai si le pion peut bouger, faux sinon
	 */
	public static boolean rMovePion(Player joueur, int [] tabCoord) {
		boolean inGrid = rStillInGrid(tabCoord[0], tabCoord[1]);
		return (inGrid && !Rules.rCheckWall(joueur.getPawnX(), joueur.getPawnY() , tabCoord) && !plateau.getItem(tabCoord[1], tabCoord[0]).getFull());
	}
	
	
	
	
	/**
	 * vérifie si le pion ne sort pas de la grille
	 * @param tabCoord la future position du pion
	 * @return true si le déplacement est autorisé,sinon false
	 */
	public static boolean rStillInGrid(int x, int y) {
		return ((x >= 0) && (x < plateau.getLen()) && (y >= 0 && y < plateau.getLen()));
		
	}
	
	
	
	/**
	 * @param joueur une instance de Player
	 * @param tabCoord un Tableau de coordonnée provenant de la Méthode StringToCoord()
	 * @return un tableau comprenant la 'distance' entre la position actuelle du pion en la position souhaitée
	 */
	public static int[] rDeplacement(Player joueur, int[] tabCoord) {
		int xtemp = Math.abs(tabCoord[0] - joueur.getPawnX());
		int ytemp = Math.abs(tabCoord[1] - joueur.getPawnY());
		int[] tabDeplacement = { xtemp, ytemp };
		return tabDeplacement;
	} 
		
	
	
	
	/**
	 * Vérifie si le joueur est dans une situation de faceToFace
	 * @param joueur une instance de la class Player
	 * @param tabCoord un tableau de type int contenant les coordonées (x, y) correspondant à la position ou le pion compte se rendre
	 * @return true si le joueur peu sauter au dessus du Pion adverse(pas de mur derriere,pas en dehors du plateau de jeu),sinon false
	 */
	public static boolean rFaceToFace (Player joueur, int[] tabCoord) {
		int xtemp = (tabCoord[0] - joueur.getPawnX()) / 2 + joueur.getPawnX();
		int ytemp = (tabCoord[1] - joueur.getPawnY()) / 2 + joueur.getPawnY();
		return (rStillInGrid(xtemp, ytemp) && !rCheckWall(xtemp, ytemp, tabCoord) && plateau.getItem(ytemp, xtemp).getFull());
			
	}
	
	
	
	/**
	 * Vérifie si le mur peut être posé aux coordonées souhaitées
	 * @param pos prend un String "horizontal" ou "vertical"
	 * @param x prend la position en x de l'extremite gauche du mur horizontal, ou la colonne pour un mur vertical
	 * @param y prend la position en y de l'extremite supperieur du mur vertical, ou la ligne pour un mur horizontal
	 * @return un boolean, true si le mur peut potentiellement être posé à cette position, sinon false
	 */
	public static boolean rPutWall(String pos, int x, int y) {
		return ( (pos.equals("horizontal") && x % 2 != 0 && y % 2 == 0) || (pos.equals("vertical") && x % 2 == 0 && y % 2 != 0));
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

	/**
	 * Check si un mur se situe dans la direction souhaitée
	 * @param joueur l'instance du joueur courant
	 * @param tabCoord un tableau de type int contenant les coordonées (x, y) correspondant à la position ou le pion compte se rendre
	 * @return true s'il y a un mur false sinon
	 */
	public static boolean rCheckWall(int xPion, int yPion, int[] tabCoord) {
		if (rStillInGrid(tabCoord[0], tabCoord[1])) {
			int ytemp = tabCoord[1] - yPion;
			int xtemp = tabCoord[0] - xPion;
			ytemp = yPion + ytemp/2;
			xtemp = xPion + xtemp/2;		
			return plateau.getItem(ytemp, xtemp).getFull();
		}else {
			return false;
		}
	}
	
}
	

	
