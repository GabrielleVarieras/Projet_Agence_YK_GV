package projet_agence_location.presentation;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

import projet_agence_location.model.Client;
import projet_agence_location.service.IPersonneService;
import projet_agence_location.service.impl.PersonneService;

public class MenuNewCompte {
	
	public static void menuNewCompte() throws ParseException {
		
		Client c = new Client();
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Entrez votre nom : ");
		c.setNom(sc.next());
		System.out.println("Entrez votre prenom : ");
		c.setPrenom(sc.next());
		System.out.println("Entrez votre login : ");
		c.setLogin(sc.next());
		System.out.println("Entrez votre mot de passe : ");
		c.setPassword(sc.next());
		System.out.println("Entrez votre email : ");
		c.setEmail(sc.next());
		System.out.println("Entrez votre numero de permis : ");
		c.setNumero_permis(sc.next());
		System.out.println("Entrez votre telephone : ");
		c.setTelephone(sc.nextInt());
		System.out.println("Entrez votre année de permis : dd/mm/yyyy");
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		c.setAnnee_permis(dateFormat.parse(sc.next()));
		
		
		IPersonneService persoService = new PersonneService();
		persoService.addObject(c);
		System.out.println("Compte Client Créé");
		
	}

}
