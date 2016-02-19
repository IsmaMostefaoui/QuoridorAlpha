package com.umons.model;

public class Main {

	public static void main(String[] agrs){
		Grid plateau ;
		plateau = new Grid();
		plateau.fillGrid();
		Player joueur1 = new Player(1);
		Player joueur2 = new Player(2);
		System.out.println("**********Grille initiale :***********");
		plateau.afficheGrid(joueur1, joueur2);
		System.out.println("*******Deplacement de joueur 1********");
		joueur1.getPawn().move("sud");
		plateau.afficheGrid(joueur1, joueur2);
		System.out.println("*******Deplacement de joueur 2********");
		joueur2.getPawn().move("nord");
		plateau.afficheGrid(joueur1, joueur2);
	}
}
