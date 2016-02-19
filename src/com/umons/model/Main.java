package com.umons.model;

public class Main {

	public static void main(String[] agrs){
		Grid plateau ;
		plateau = new Grid();
		plateau.fillGrid();
		Player joueur1 = new Player(1);
		Player joueur2 = new Player(2);
		plateau.afficheGrid(joueur1, joueur2);
	}
}
