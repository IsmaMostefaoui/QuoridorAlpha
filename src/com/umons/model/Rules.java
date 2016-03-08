package com.umons.model;

/**
 * Contient toutes les méthodes (static) concernant les règles du jeu Quoridor.
 * @author isma
 * @author robin
 *
 */
public class Rules {

	private static Grid plateau;
	final int UP, DOWN, LEFT, RIGHT;
	
	
	//joueur doit être une variable d'instance, on l utilise partout
	
	/**
	 * Initialise un plateau (celui sur lequel sera appliquer toutes les règles.
	 * @param grid le plateau
	 */
	public Rules(Grid grid) {
		plateau = grid;
		UP = 0;
		DOWN = 2;
		LEFT = 3;
		RIGHT = 1;
	}

	
	/**
	 * Vérifie si un pion adverse se situe sur la position souhaitée. Le tablau de coordonnées représente l'endroit où le pion va bouger
	 * @param joueur l'instance courante du joueur qui veut bouger son pion
	 * @param tabCoord les coordonnées de l'endroit ou le pion veut bouger
	 * @return un boolean vrai si le pion peut bouger, faux sinon
	 */
	public static boolean rMovePion(Player joueur, int [] tabCoord) {
		boolean inGrid = rStillInGrid(tabCoord[0], tabCoord[1]);
		return (inGrid && !Rules.rCheckWall(joueur.getPawnX(), joueur.getPawnY() , tabCoord) && !plateau.getItem(tabCoord[1], tabCoord[0]).getFull());
	}
	
	
	//surcharge pour pouvoir utiliser la méthode avec des coordonnées indépendante
	public static boolean rMovePion(Player joueur, int x, int y) {
		boolean inGrid = rStillInGrid(x, y);
		return (inGrid && !Rules.rCheckWall(joueur.getPawnX(), joueur.getPawnY() , x, y) && !plateau.getItem(y, x).getFull());
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
		//ici, directement tester que tabcoord n'est pas hors indice, ca evite des test inutile
		int xtemp = (tabCoord[0] - joueur.getPawnX()) / 2 + joueur.getPawnX();
		int ytemp = (tabCoord[1] - joueur.getPawnY()) / 2 + joueur.getPawnY();
		return (rStillInGrid(xtemp, ytemp) && rStillInGrid(tabCoord[0], tabCoord[1]) && !rCheckWall(xtemp, ytemp, tabCoord) && plateau.getItem(ytemp, xtemp).getFull());
			
	}
	
	
	/*
	 * INUTILE FINALEMENT
	 */
	/*
	public int[] rDiagDirection(Player joueur, int[]tabCoord) {
		int[] tabDirection = new int [2];
		if (tabCoord[0] - joueur.getPawnX() == 2 && tabCoord[1] - joueur.getPawnY() == -2) {
			tabDirection[0] = RIGHT; tabDirection[1] = UP;
		}else if (tabCoord[0] - joueur.getPawnX() == -2 && tabCoord[1] - joueur.getPawnY() == -2) {
			tabDirection[0] = UP; tabDirection[1] = LEFT;
		}else if (tabCoord[0] - joueur.getPawnX() == -2 && tabCoord[1] - joueur.getPawnY() == 2) {
			tabDirection[0] = LEFT; tabDirection[1] = DOWN;
		}else if (tabCoord[0] - joueur.getPawnX() == 2 && tabCoord[1] - joueur.getPawnY() == 22) {
			tabDirection[0] = DOWN; tabDirection[1] = RIGHT;
		}else{
			tabDirection[0] = null; tabDirection[1] = null;
		}return tabDirection;
	}
	*/
	
	public static boolean rDiagFace(Player joueur, int[] tabCoord) {
		int xPion = joueur.getPawnX(); //parce que c'est chiant d ecrire a chaque joueur.getPawnX()
		int yPion = joueur.getPawnY();
		System.out.println("test des condition du return dans la premiere condition dans diag: " + plateau.getItem(yPion-2, xPion).getFull());
		if (tabCoord[0] - joueur.getPawnX() == 2 && tabCoord[1] - joueur.getPawnY() == -2) { //soit il est bloqué en haut, soit a droite
			//donc on vérifie si c'est le cas
			//attention je ne test pas le stillingrid, je dois encore trouver une façon de raccourcir ce bordel
			//en gros l'idée c'est qu'il peut bouger en diagonal que si la case en face de lui, ou a droite de lui est occupé avec un mur en face
			return (plateau.getItem(yPion-2, xPion).getFull() && rCheckWall(xPion, yPion-2, xPion, yPion-4)) || (plateau.getItem(yPion, xPion+2).getFull() && rCheckWall(xPion+2, yPion, xPion+4, yPion));
		}else if (tabCoord[0] - joueur.getPawnX() == -2 && tabCoord[1] - joueur.getPawnY() == -2) {
			return (plateau.getItem(yPion-2, xPion).getFull() && rCheckWall(xPion, yPion-2, xPion, yPion-4)) || (plateau.getItem(yPion, xPion-2).getFull() && rCheckWall(xPion-2, yPion, xPion-4, yPion));
		}else if (tabCoord[0] - joueur.getPawnX() == -2 && tabCoord[1] - joueur.getPawnY() == 2) {
			return (plateau.getItem(yPion, xPion-2).getFull() && rCheckWall(xPion-2, yPion, xPion-4, yPion)) || (plateau.getItem(yPion+2, xPion).getFull() && rCheckWall(xPion, yPion+2, xPion, yPion+4));
		}else if (tabCoord[0] - joueur.getPawnX() == 2 && tabCoord[1] - joueur.getPawnY() == 2) {
			return (plateau.getItem(yPion+2, xPion).getFull() && rCheckWall(xPion, yPion+2, xPion, yPion+4)) || (plateau.getItem(yPion, xPion+2).getFull() && rCheckWall(xPion+2, yPion, xPion+4, yPion));
		}return false;
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
	 * @param xPion la coordonnée x du pion
	 * @param yPion la coordonnée y du pion
	 * @param tabCoord un tableau de type int contenant les coordonées (x, y) correspondant à la position ou le pion compte se rendre
	 * @return true s'il y a un mur false sinon
	 */
	public static boolean rCheckWall(int xPion, int yPion, int[] tabCoord) {
		if (rStillInGrid(tabCoord[0], tabCoord[1])) {
			int ytemp = tabCoord[1] - yPion;
			int xtemp = tabCoord[0] - xPion; // inutile non ? Puisque c'est le meme calcul que dans facetoface
			ytemp = yPion + ytemp/2;
			xtemp = xPion + xtemp/2;
			return plateau.getItem(ytemp, xtemp).getFull();
		}else {
			return false;
		}
	}
	
	
	//surcharge de checkWall pour pourvoir l'utiliser avec des coordonnées indépendante
	/**
	 * Check si un mur se situe dans la direction souhaitée
	 * @param xPion la coordonnée x du pion
	 * @param yPion la coordonnée y du pion
	 * @param x et y les coordonées (x, y) correspondant à la position sur laquelle le pion compte se rendre
	 * @return true s'il y a un mur false sinon
	 */
	public static boolean rCheckWall(int xPion, int yPion, int x, int y) {
		if (rStillInGrid(x, y)) { //ATTENTIO, quand on regarde s'il n'y a pas de mur, on ne regarde plus si la postion est dans la grille
								  // car quand on fait !rChecWall(), on aura vrai si l'item est vide en position ytemp et xtemp
								  // mais on a aussi vrai quand rStillInGrid(x, y) retourne faux, et qu'on entre pas de le if !!!
								  // a regler urgent !
			int ytemp = y - yPion;
			int xtemp = x - xPion; // inutile non ? Puisque c'est le meme calcul que dans facetoface
			ytemp = yPion + ytemp/2; // mettre un test de stillingrid des qu'un param peut potentielment nous causer probleme
			xtemp = xPion + xtemp/2; // donc a changer, je crois
			return plateau.getItem(ytemp, xtemp).getFull();
		}else {
			return false;
		}
	}
	
}
	

	
