package projet_agence_location.presentation;

import java.text.ParseException;
import java.util.Scanner;

public class MenuPrincipale {
	
	public static void menuPrincipale() throws InterruptedException, ParseException {
		
		
		
		
		String repeat = "oui";
		while (repeat.equals("oui")) {
			System.out
					.println("\n*******************************************************");
			System.out.println("Bonjour et bienvenue !!");
			System.out.println("*******************************************************\n");
			System.out
					.println("\n***** Veuillez choisir ce que vous voudriez faire ******");
			System.out.println("\t (1) : S'authentifier");
			System.out.println("\t (2) : Créer un compte");
			System.out.println("\t (3) : Consulter les voitures disponibles");
			System.out.println("\t (4) : Quitter");
			System.out
					.println("*********************************************************\n");

			Scanner sc = new Scanner(System.in);

			int choix = sc.nextInt();

			switch (choix) {
			case 1:
				System.out.print("Chargement en cours  : ");
				for (int i = 0; i < 10; i++) {
					System.out.print("*");
					Thread.sleep(50);
				}
				MenuAuth.menuAuth();
				repeat = "non";
				break;
			case 2:
				System.out.println("Chargement en cours : ");
				for (int i = 0; i < 10; i++) {
					System.out.print("*");
					Thread.sleep(50);
				}
				MenuNewCompte.menuNewCompte();
				repeat = "non";
				break;
			case 3:
				System.out.println("Consultation des voitures : ");
				repeat = "non";
				MenuSeeAllVoitures.menuSeeAllVoitures();
				break;

			case 4:
				System.out.println("Au revoir !! A la prochaine");
				repeat = "non";
				break;
				
			default:
				System.out.println("vous avez effectué un choix erroné !!");
				System.out
						.println("voulez vous choisir une autre fois, oui/non?");
				repeat = sc.next();
				if (repeat.equals("non")) {
					System.out.println("Au revoir !!");
				}
				System.out.println();
				break;
			}
		}
	}
		
		
		
		
	

}
