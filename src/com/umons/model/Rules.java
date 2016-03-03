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
	 * Vérifie si un pion peut ou pas bouger. Les coordonnées représentent l'endroit où le pion va bouger
	 * @param x un int représentant les coordonées des colonnes
	 * @param y un int représentant les coordonées des lignes
	 * @return un boolean vrai si le pion peut bouger, faux sinon
	 */
	public static boolean rMovePion(int [] tabCoord) {
		/* 
		 * Reprendre la méthode de checkWall...
		 * Ajouter la validation
		 */
		if (rStillInGrid(tabCoord)) {
			boolean caseFull = plateau.getItem(tabCoord[1], tabCoord[0]).getFull();
			return !(caseFull);
		}else {
			return false;
		}
	}
	
	
	/**
	 * vérifie si le pion ne sort pas de la grille
	 * @param tabCoord la future position du pion
	 * @return true si le déplacement est autorisé,sinon false
	 */
	public static boolean rStillInGrid(int[] tabCoord) {
		boolean inGrid = (tabCoord[0] >= 0 && tabCoord[0] < plateau.getLen() && tabCoord[1] >= 0 && tabCoord[1] < plateau.getLen());
		return inGrid;
	}
	
	/**
	 * 
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
		
	
	/*
	public static boolean rFaceToFace(Player joueur,int[] tabCoord) {
		//S'il veut se déplacer sur une des case en diagonale
		if ( Math.abs(joueur.getPawnX() - tabCoord[0]) == 4 && Math.abs(joueur.getPawnY() - tabCoord[1]) == 4 ) {
			//c'est que la case en face, à côté ou derrière lui est occupé.Ou alors, présence d'un mur !! Vérifié alors que c'est bien le cas
			int coordObstacleX = (joueur.getPawnX() - tabCoord[0]) + joueur.getPawnX(); //les coordonneés de la case où il est censé
			int coordObstacleY = (joueur.getPawnY() - tabCoord[1]) + joueur.getPawnY(); //il y avoir un obstacle justifiant le face to face
			return (plateau.getItem(coordObstacleY, coordObstacleX).getFull() && !());
		}
	}
	*/
	public static boolean rFaceToFace (Player joueur, int[] tabCoord) {
		int xtemp = (tabCoord[0] - joueur.getPawnX()) / 2 + joueur.getPawnX();
		int ytemp = (tabCoord[1] - joueur.getPawnY()) / 2 + joueur.getPawnY();
		boolean verif1 = !rCheckWall(xtemp, ytemp, tabCoord);
		boolean verif2 = rStillInGrid(tabCoord);
		boolean verif3 = plateau.getItem(ytemp, xtemp).getFull();
		return (verif1 && verif2 && verif3);
			
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
		/*
		if (pos.equals("horizontal") ) {
			if (x % 2 != 0 && y % 2 == 0) {
				//verifie si le mur n'est pas sur une case
					return true;
				}
				return false;
		}else if (pos.equals("vertical")){
			if (x % 2 == 0 && y % 2 != 0) {
				//verifie si le mur n'est pas sur une case
				return true;
			}
			return false;
		}
		*/
	}
	
	/**
	 * Vérifie si le mur est placé dans une fente(Slot) libre
	 * @param position prend un String "horizontal" ou "vertical"
	 * @param x prend la position en x de l'extremite gauche du mur horizontal, ou la colonne pour un mur vertical
	 * @param y prend la position en y de l'extremite supperieur du mur vertical, ou la ligne pour un mur horizontal
	 * @return un boolean, true si le mur peut potentiellement être posé à cette position, sinon false
	 */
	public static boolean rSlotFull (String position, int x, int y) {
		//Pour la verification de l'éxistence d'un MUR sur un slot déjà occupé
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
		
		int ytemp = tabCoord[1] - yPion;
		int xtemp = tabCoord[0] - xPion;
		ytemp = yPion + ytemp/2;
		xtemp = xPion + xtemp/2;
		return plateau.getItem(ytemp, xtemp).getFull();
	
		}
	}
	

	
