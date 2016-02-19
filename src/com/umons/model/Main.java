package com.umons.model;

public class Main {

	public static void main(String[] agrs){
		Grid plateau ;
		plateau = new Grid();
		plateau.fillGrid();
		Player joueur1 = new Player(1, plateau);
		Player joueur2 = new Player(2, plateau);
		System.out.println("**********Grille initiale :***********");
		System.out.println();
		plateau.afficheGrid(joueur1, joueur2);
		System.out.println();
		System.out.println("*******Deplacement de joueur 1********");
		System.out.println();
		joueur1.getPawn().move("sud", plateau);
		plateau.afficheGrid(joueur1, joueur2);
		System.out.println();
		System.out.println("*******Deplacement de joueur 2********");
		System.out.println();
		joueur2.getPawn().move("nord", plateau);
		plateau.afficheGrid(joueur1, joueur2);
	}
}
