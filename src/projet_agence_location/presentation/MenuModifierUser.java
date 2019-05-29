package projet_agence_location.presentation;

import java.text.ParseException;
import java.util.Scanner;

import projet_agence_location.model.Agence;
import projet_agence_location.model.Client;
import projet_agence_location.model.Personne;
import projet_agence_location.model.Voiture;
import projet_agence_location.service.IAgenceService;
import projet_agence_location.service.IPersonneService;
import projet_agence_location.service.IVoitureService;
import projet_agence_location.service.impl.AgenceService;
import projet_agence_location.service.impl.PersonneService;
import projet_agence_location.service.impl.VoitureService;

public class MenuModifierUser {
	public static void menuModifierUser() throws InterruptedException, ParseException{
	IPersonneService pService = new PersonneService();
	System.out.println();
	System.out.println();

	String repeat = "oui";

	while (repeat.equals("oui")) {
		System.out.println("\n*********************************");


		// on check ce que l'admin veut faire

		

		// Sans l'annotation @supressWarnings("resource"), Eclipse va nous
		// afficher un Warning
		// Cette annotatino ne va pas rien changer par rapport à l'exécution
		// de l'applicatino!
		// C'est juste pour éliminer les Warnings dans le code source
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		
		IPersonneService personneService = new PersonneService();			
			for (Personne p : personneService.findAll(Personne.class)) {
				if(Personne.connectedUser.getId_personne() == p.getId_personne()){
					System.out.println("entrez le nom : ");
					p.setNom(sc.next());
					System.out.println("entrez le prenom : ");
					p.setPrenom(sc.next());
					System.out.println("entrez le login : ");
					p.setLogin(sc.next());
					System.out.println("entrez le mot de passe : ");
					p.setPassword(sc.next());
					System.out.println("entrez l'email : ");
					p.setEmail(sc.next());
					personneService.updateObject(p);
				}
			}
			MenuGestion.menuGestion();
			repeat = "non";
			
	}
	}
}
