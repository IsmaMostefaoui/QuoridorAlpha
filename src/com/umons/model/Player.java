package com.umons.model;

public class Player {
	//faire hériter de Rules
	private int numberOfWall;
	private Wall wall;
	private Pawn pion;
	
	public Player(int number, Grid grid) {
		/**
		 * @param number est le "numero" du joueur (joueur 1 ou 2)
		 **/
		numberOfWall = 10;
		pion = new Pawn(number, grid);
		wall = new Wall();
	}
	
	public void putWall(Grid grid, String position, int x, int y){
		if (position.equals("horizontal")){
			//appele aux verif de Rules
			for (int j = x; j < x + 3; j++){
				grid.setItemInGrid(y, j, true);
			}
		}else {
			//appele aux verif
			for (int i = y; i < y + 3; i++){
				grid.setItemInGrid(i, x, true);	
			}
		}
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
