package com.umons.model;

public class Rules {
	
	public boolean stillInGrid(String position, int posY, int posX){
		/**
		 * Verifie si le deplacement d'un pion ne le fait pas sortir de la grille
		 * @param un String position (nord,sud,ouest,est)
		 * @param la position actuelle en Y du pion
		 * @param la position actuelle en x du pion
		 * @return True si le déplacement est possible, sinon False
		 */
		if (position.equals("nord")) {
			if (posY - 2 < 0) {
				return false;
			}
			return true;
		}
		else if (position.equals("sud")){
			if (posY + 2 > 16) {
				return false;
			}
			return true;
		}
		else if (position.equals("est")){
			if (posX + 2 > 16) {
				return false;
			}
			return true;
		}
		else if (position.equals("ouest")){
			if (posX - 2 < 0) {
				return false;
			}
			return true;
		}
		return false;
	}
}
