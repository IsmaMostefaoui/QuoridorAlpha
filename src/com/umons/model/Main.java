package com.umons.model;
import java.util.Scanner;

public class Main {

	public static void main(String[] agrs){
		/*
		Grid plateau ;
		plateau = new Grid();
		plateau.fillGrid();
		Player joueur1 = new Player(1, plateau);
		Player joueur2 = new Player(2, plateau);
		System.out.println("**********Grille initiale :***********");
		System.out.println();
		plateau.afficheGrid(joueur1, joueur2);
		System.out.println();
		System.out.println("*******Deplacement de joueur 2********");
		System.out.println();
		joueur2.getPawn().move("sud", plateau);
		plateau.afficheGrid(joueur1, joueur2);
		System.out.println();
		System.out.println("*******Deplacement de joueur 1********");
		System.out.println();
		joueur1.getPawn().move("nord", plateau);
		plateau.afficheGrid(joueur1, joueur2);
		*/
		Grid plateau ;
		plateau = new Grid();
		plateau.fillGrid();
		Player joueur1 = new Player(1, plateau);
		Player joueur2 = new Player(2, plateau);
		System.out.println("***DEBUT DU TEST***");
		plateau.afficheGrid(joueur1, joueur2);
		boolean stop = false;
		int tour = 1;
		String direction = "";
		String status = "";
		int choix = 0;
		Scanner sc = new Scanner(System.in);
		String positionWall = "";
		int x = 0;
		int y = 0;
		do {
			if (tour == 1) {
				System.out.print("Joueur 1, à vous de jouer. Pion ou mur ? (1 ou 2)");
				choix = sc.nextInt();
				sc.nextLine();
				if (choix == 1) {
					System.out.print("Joueur 1, à vous de jouer. Ou voulez-vous aller ? >> ");
					direction = sc.nextLine();
					System.out.println();
					joueur1.getPawn().move(direction, plateau);
					plateau.afficheGrid(joueur1, joueur2);
					System.out.println();
					tour++;
				}else{
					System.out.print("Joueur 1, à vous de jouer. Ou voulez-vous le mettre ? (position) >> ");
					positionWall = sc.nextLine();
					System.out.print("x >> ");
					x = Integer.parseInt(sc.nextLine());
					System.out.print("y >> ");
					y = Integer.parseInt(sc.nextLine());
					joueur1.putWall(plateau, positionWall, x, y);
					plateau.afficheGrid(joueur1, joueur2);
					tour++;
				}
			}else {
				System.out.print("Joueur 2, à vous de jouer. Pion ou mur ? (1 ou 2)");
				choix = sc.nextInt();
				sc.nextLine();
				if (choix == 1) {
					System.out.print("Joueur 2, à vous de jouer. Ou voulez-vous aller ? >> ");
					direction = sc.nextLine();
					System.out.println();
					joueur2.getPawn().move(direction, plateau);
					plateau.afficheGrid(joueur1, joueur2);
					System.out.println();
					tour--;
				}else{
					System.out.print("Joueur 2, à vous de jouer. Ou voulez-vous le mettre ? (position) >> ");
					positionWall = sc.nextLine();
					System.out.print("x >> ");
					x = Integer.parseInt(sc.nextLine());
					System.out.print("y >> ");
					y = Integer.parseInt(sc.nextLine());
					joueur2.putWall(plateau, positionWall, x, y);
					plateau.afficheGrid(joueur1, joueur2);
					tour--;
				}
			if (status == "yes")
				stop = true;
			else
				stop = false;
			}
		}while (!stop);
	}
}
