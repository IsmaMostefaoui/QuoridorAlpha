package com.umons.model;

public class Rules {
	
	public static boolean rPutWall(String pos, int x, int y) {
		if (pos.equals("horizontal")) {
			if (x % 2 == 0 && y % 2 != 0) {
				//verifie si le mur n'est pas sur une case
				return true;
			}
			return false;
			
		}else {
			if (x % 2 != 0 && y % 2 == 0) {
				//verifie si le mur n'est pas sur une case
				return true;
			}
			return false;
		}
	}
		
}
	
