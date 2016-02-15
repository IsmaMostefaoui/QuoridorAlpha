package com.umons.model;

public class Grid {

	private Item[][] plateau;
	
	public Grid() {
		//CONSTRUCTEUR PAR DEFAUT
		//Mode normal, grille 9x9(case)
		plateau = new Item[17][17];
	}
	
	public Grid(int length) {
		//CONSTRUCTEUR
		//Mode special, grille de longueur differente
		 plateau = new Item[length][length];
	}
	
	public void fillGrid() {
		//Rempli la grille avec les fentes et les cases
		for (int i = 0; i < plateau.length; i+=2)
			for (int j = 0; j < plateau.length; i+=2) 
				plateau[i][j] = new Item(1);
		for (int i = 0; i < plateau.length; i+=2)
			for (int j = 1; j < plateau.length; i+=2) 
				plateau[i][j] = new Item(2);
		for (int i = 1; i < plateau.length; i+=2)
			for (int j = 0; j < plateau.length; j++)
				plateau[i][j] = new Item(2);
	}
	
	/*
	TEST D'UN AFFICHAGE MAIS NE FONCTIONNE PAS

	Bug #2 Reference null lors de l'écécution de Main.java

	public String afficheGrid() {
	  String s = "";
	  //essaye d'afficher une grille vide (ne gère pas le cas ou la case possède un pion)
	  for (int i = 0; i < plateau.length; i+=2) {
			for (int j = 0; j < plateau.length; j++) {
				if (plateau[i][j].getLen() == 1){
					s += "O";
				}else{
					s+= "|";
				}
			}
			s += "________";
	  }
	  return s;
	}
	
	public void afficheGrid2(){
		for (int i = 0; i < plateau.length; i+=2) {
			for (int j = 0; j < plateau.length; j++) {
				if (plateau[i][j].getLen() == 1){
					System.out.println("O");
				}else{
					System.out.println("|");
				}
			}
			System.out.println("________");
	  }
	}
	*/
}
