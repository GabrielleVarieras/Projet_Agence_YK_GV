package projet_agence_location.presentation;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import projet_agence_location.model.Personne;
import projet_agence_location.model.Reservation;
import projet_agence_location.service.IReservationService;
import projet_agence_location.service.impl.ReservationService;

public class MenuModifierMesResa {
	
	public static void menuModifierMesResa() throws InterruptedException, ParseException {
//		IReservationService resaService = new ReservationService();
//		
//		List<Reservation> reservationsTotales = resaService.findAll(Reservation.class);
//		List<Reservation> mesResa = new ArrayList<>();
//		
//		for (Reservation r : reservationsTotales) {
//			if (r.getPersonne().getId_personne() == Personne.connectedUser.getId_personne()) {
//				mesResa.add(r);
//			}
//		}
//		System.out.println(mesResa.toString());
//		System.out.println("selectionner l'id de la reservation à modifier");
//		Scanner sc = new Scanner(System.in);
//		resaService.deleteObject(resaService.getById(sc.nextInt()));
//		System.out.println("Reservation supprimée, retour au menu précédant");
//		MenuGestion.menuGestion();
		
		System.out.println("Contacter le service client au 06.05.65.69.57");
		MenuGestion.menuGestion();
	}

}
