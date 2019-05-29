package projet_agence_location.presentation;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import projet_agence_location.model.Personne;
import projet_agence_location.model.Reservation;
import projet_agence_location.model.Voiture;
import projet_agence_location.service.IReservationService;
import projet_agence_location.service.IVoitureService;
import projet_agence_location.service.impl.ReservationService;
import projet_agence_location.service.impl.VoitureService;

public class MenuFaireMaResa {

	public static void reserver() throws ParseException, InterruptedException {
		Scanner sc = new Scanner(System.in);
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		IReservationService reservationService = new ReservationService();

		System.out.println("Veuillez entrer la date de début souhaitée au format dd/MM/yyyy");
		Date dd = dateFormat.parse(sc.next());
		System.out.println("Veuillez entrer la date de fin souhaitée au format dd/MM/yyyy");
		Date df = dateFormat.parse(sc.next());
		while ( df.before(dd)) {
			System.out.println("veuillez saisir une date de fin ulterieur");
			df = dateFormat.parse(sc.next());
		}
		System.out.println("Voulez-vous une assurance o/n ?");
		String choix = sc.next();
		boolean assurance = false;
		if(choix == "o") {
			 assurance = true;
		}
		Reservation resa = new Reservation(dd, df, assurance);
		System.out.println("Liste de tous les véhicules disponibles");
		IVoitureService voitureService = new VoitureService();
		List<Voiture> l = voitureService.findAll(Voiture.class);
		List<Voiture> dispo = new ArrayList<Voiture>();
		for (Voiture v : l) {
			if (v.isDisponibilite()) {
				dispo.add(v);
			}
		}
		System.out.println(dispo.toString());
		
		System.out.println("***** Veuillez choisir l'id de votre voiture ******");
		Long choix2 = sc.nextLong();
		resa.setVoiture(voitureService.findById(Voiture.class, choix2));
		resa.setPersonne(Personne.connectedUser);
		if(reservationService.addObject(resa) != null) {
			System.out.println("réservation effectuée !");
			voitureService.findById(Voiture.class, choix2).setDisponibilite(false);
			voitureService.updateObject(voitureService.findById(Voiture.class, choix2));
		}
		MenuGestion.menuGestion();
		
	}

}
