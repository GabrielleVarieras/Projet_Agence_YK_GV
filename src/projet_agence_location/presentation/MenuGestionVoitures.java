package projet_agence_location.presentation;

import java.text.ParseException;
import java.util.Scanner;

import projet_agence_location.model.Admin;
import projet_agence_location.model.Agence;
import projet_agence_location.model.Personne;
import projet_agence_location.model.Voiture;
import projet_agence_location.service.IAgenceService;
import projet_agence_location.service.IVoitureService;
import projet_agence_location.service.impl.AgenceService;
import projet_agence_location.service.impl.VoitureService;

public class MenuGestionVoitures {

	public static void menuGestionVoiture() throws InterruptedException, ParseException {
		
		IVoitureService vService = new VoitureService();
		System.out.println();
		System.out.println();

		String repeat = "oui";

		while (repeat.equals("oui")) {
			System.out.println("\n*********************************");
			System.out.println("Voulez vous : ");

			// on check ce que l'admin veut faire


			System.out.println("\t (1) : Ajouter une voiture ");
			System.out.println("\t (2) : Supprimer une voiture ");
			System.out.println("\t (3) : retour ");
			

			// Sans l'annotation @supressWarnings("resource"), Eclipse va nous
			// afficher un Warning
			// Cette annotatino ne va pas rien changer par rapport à l'exécution
			// de l'applicatino!
			// C'est juste pour éliminer les Warnings dans le code source
			@SuppressWarnings("resource")
			Scanner sc = new Scanner(System.in);
			System.out.println("***** Veuillez choisir ce que vous voudriez faire ******");
			int choix = sc.nextInt();
			
			
			switch (choix) {
			case 1:
				System.out.println("entrez la marque de la voiture : ");
				String marque = sc.next();
				System.out.println("entrez l'immatricultation : ");
				String immatriculation = sc.next();
				System.out.println("entrez la categorie du vehicule : ");
				String categorie_vehicule = sc.next();
				
				boolean etat_voiture = true;
				
				System.out.println("entrez le nombre de place : ");
				int nombre_de_place = sc.nextInt();
				System.out.println("entrez la couleur de la voiture : ");
				String couleur = sc.next();
				
				boolean disponibilite = true;
				
				System.out.println("entrez le kilometrage de la voiture : ");
				int kilometrage = sc.nextInt();
				System.out.println("entrez le prix de location : ");
				double prix_location = sc.nextDouble();
				System.out.println("entrez l'id de l'agence : ");
				IAgenceService aService = new AgenceService();
				Agence agencen = aService.findById(Agence.class, sc.nextLong());

				
				Voiture v = new Voiture(marque, immatriculation, categorie_vehicule, etat_voiture, nombre_de_place, 
						couleur, disponibilite, kilometrage, prix_location, agencen);
				vService.addObject(v);
				
				System.out.println("Voiture ajouée avec succes");
				repeat = "non";
				MenuGestion.menuGestion();
				break;
			case 2:
				System.out.println( vService.findAll(Voiture.class).toString());
				System.out.println("Selectionner l'id de la voiture à supprimer");
				long id = sc.nextLong();
				vService.deleteObject(vService.findById(Voiture.class, id));
	
				
				System.out.println("Voiture supprimer avec succes");
				repeat = "non";
				MenuGestion.menuGestion();
				break;
			case 3:
				repeat = "non";
				MenuGestion.menuGestion();
				break;

			default:
				System.out.println("vous avez rentré un choix incorrecte ");
				System.out.println("voulez vous re-essayer  oui/non !!");
				repeat = sc.next();
				break;
			}
		}

	}
}
