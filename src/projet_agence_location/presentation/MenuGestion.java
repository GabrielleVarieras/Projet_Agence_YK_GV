package projet_agence_location.presentation;

import java.text.ParseException;
import java.util.Scanner;

import projet_agence_location.model.Admin;
import projet_agence_location.model.Client;
import projet_agence_location.model.Personne;

public class MenuGestion {

	public static void menuGestion() throws InterruptedException, ParseException {
		System.out.println();
		System.out.println();

		String repeat = "oui";

		while (repeat.equals("oui")) {
			System.out.println("\n*********************************");
			// On affiche un message de "Bonjour" en cancat�nant la le nom de
			// l'uilisateur connect�
			System.out.println(
					" Bonjour " + Personne.connectedUser.getNom() + " - " + Personne.connectedUser.getPrenom());

			// On v�rifie si l'utilisateur est un Admin avec cette condition ou
			// pas.
			if (Personne.connectedUser instanceof Admin) {
				// Si c'est le cas, on va demander � l'Admin s'il veut g�rer les
				// utilisateurs ou les produits.
				// ou bien quitter l'application.
				System.out.println("\t (1) : Voir les r�servations ");
				System.out.println("\t (2) : Voir le parc de voiture ");
				System.out.println("\t (3) : Ajouter/Supprimer des voitures");
				System.out.println("\t (4) : Retourner � la page d'accueil");
			} else {
				// S'il s'agit d'un simple Utilisateur,
				// Il pourra que acheter un produit ou quitter l'application.s
				System.out.println("\t (1) : Modifier mon compte ");
				System.out.println("\t (2) : Modifier mes r�servations ");
				System.out.println("\t (3) : R�server ");
				System.out.println("\t (4) : Retourner � la page d'accueil ");
			}

			// Sans l'annotation @supressWarnings("resource"), Eclipse va nous
			// afficher un Warning
			// Cette annotatino ne va pas rien changer par rapport � l'ex�cution
			// de l'applicatino!
			// C'est juste pour �liminer les Warnings dans le code source
			@SuppressWarnings("resource")
			Scanner sc = new Scanner(System.in);
			System.out.println("***** Veuillez choisir ce que vous voudriez faire ******");
			int choix = sc.nextInt();
			switch (choix) {
			case 1:
				if (Personne.connectedUser instanceof Admin) {
					System.out.println("Liste de toutes les r�servations");
					repeat = "non";
					MenuSeeAllResa.menuSeeAllResa();
				} else if (Personne.connectedUser instanceof Client) {
					System.out.println("Modifier mon compte ");
					repeat = "non";
					MenuModifierUser.menuModifierUser();
				}
				break;
			case 2:
				if (Personne.connectedUser instanceof Admin) {
					System.out.println("Liste de toutes les voitures");
					repeat = "non";
					MenuSeeAllVoitures.menuSeeAllVoitures();
				} else if (Personne.connectedUser instanceof Client) {
					System.out.println("Modification de mes r�servations");
					repeat = "non";
					MenuModifierMesResa.menuModifierMesResa();
				}
				break;
			case 3:
				if (Personne.connectedUser instanceof Admin) {
					System.out.println("Ajouter ou Supprimer une voiture");
					
					repeat = "non";
					MenuGestionVoitures.menuGestionVoiture();

				} else if (Personne.connectedUser instanceof Client) {
					System.out.println("Reservation ");
					repeat = "non";
					MenuFaireMaResa.reserver();
				}
				break;

			case 4:
				System.out.println("Au revoirs !! ");
				repeat = "non";
				MenuPrincipale.menuPrincipale();
				break;
			
			default:
				System.out.println("vous avez rentr� un choix incorrecte ");
				System.out.println("voulez vous re-essayer  oui/non !!");
				repeat = sc.next();
				break;
			}

		}
	}
}
