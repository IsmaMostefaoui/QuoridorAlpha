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
		
		
		
		Grid plateau;
		plateau = new Grid();
		//Initialsie les règle !!
		Rules rules = new Rules(plateau);
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
		boolean posOk = false;
		boolean wallOk = false;
		int x = 0;
		int y = 0;
		do {
			if (tour == 1) {
				do {
					System.out.print("Joueur 1, à vous de jouer. Pion ou mur ? (1 ou 2)");
					choix = sc.nextInt();
					sc.nextLine();
				}while (choix != 1 && choix != 2);
				if (choix == 1) {
					do {
						System.out.print("Joueur 1, à vous de jouer. Ou voulez-vous aller ? >> ");
						direction = sc.nextLine();
						System.out.println();
						posOk = joueur1.move(direction, plateau);
					}while (!posOk);
					plateau.afficheGrid(joueur1, joueur2);
					System.out.println();
					posOk = false;
					tour++;
				}else if (choix == 2){
					System.out.print("Joueur 1 ,à vous de jouer. Ou voulez-vous le mettre ? (position) >> ");
					positionWall = sc.nextLine();
					do {
						System.out.print("Position en X (colonne) >> ");
						x = Integer.parseInt(sc.nextLine());
					}while (x < 0 || x > plateau.getLen());
					do {
						System.out.print("Position en Y (ligne) >> ");
						y = Integer.parseInt(sc.nextLine());
					}while (y < 0 || x > plateau.getLen());
					do {
						do {
							System.out.print("Position en X (colonne) >> ");
							x = Integer.parseInt(sc.nextLine());
						}while (x < 0 || x > plateau.getLen());
						do {
							System.out.print("Position en Y (ligne) >> ");
							y = Integer.parseInt(sc.nextLine());
						}while (y < 0 || x > plateau.getLen());
						System.out.println();//ERRREUR 404
						wallOk = joueur1.putWall(plateau,positionWall,x,y);
						//L'affichage du message "impossible de placer un mur à cet endroit" est dans le code de putWall
						
					}while (!wallOk);
					plateau.afficheGrid(joueur1, joueur2);
					wallOk = false;
					tour++;
			
				}
			}else {
				do {
					System.out.print("Joueur 2, à vous de jouer. Pion ou mur ? (1 ou 2)");
					choix = sc.nextInt();
					sc.nextLine();
				}while (choix != 1 && choix != 2);
				if (choix == 1) {
					do {
						System.out.print("Joueur 2, à vous de jouer. Ou voulez-vous aller ? >> ");
						direction = sc.nextLine();
						System.out.println();
						posOk = joueur2.move(direction, plateau);
						
					}while (!posOk);
					plateau.afficheGrid(joueur1, joueur2);
					System.out.println();
					posOk = false;
					tour--;
				}else if (choix == 2) {
					do {
						System.out.print("Joueur 2 ,à vous de jouer. Ou voulez-vous le mettre ? (position) >> ");
						positionWall = sc.nextLine();
						System.out.print("Position en X (colonne) >> ");
						x = Integer.parseInt(sc.nextLine());
						System.out.print("Position en Y (ligne) >> ");
						y = Integer.parseInt(sc.nextLine());
						System.out.println();
						wallOk = joueur2.putWall(plateau,positionWall,x,y);
						//L'affichage du message "impossible de placer un mur à cet endroit" est dans le code de putWall
					}while (!wallOk);
					plateau.afficheGrid(joueur1, joueur2);
					wallOk = false;
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
