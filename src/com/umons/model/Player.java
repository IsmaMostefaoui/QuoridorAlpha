package com.umons.model;

public class Player {

	private int numberOfWall;
	private Wall wall;
	private Pawn pion;
	
	public Player(int number) {
		/**
		 * @param number est le "numero" du joueur (joueur 1 ou 2)
		 **/
		numberOfWall = 10;
		pion = new Pawn(number);
		wall = new Wall();
	}
	
	public Pawn getPawn() {
		/**
		 * @return le pion associe aux joueur
		 */
		return pion;
	}
	
	public int getNumberOfWall() {
		/**
		 * @return le nombre de mur du joueur de type int
		 */
		return numberOfWall;
	}
}
