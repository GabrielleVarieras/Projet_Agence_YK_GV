package projet_agence_location.presentation;

import java.text.ParseException;

import projet_agence_location.model.Reservation;
import projet_agence_location.service.IReservationService;
import projet_agence_location.service.impl.ReservationService;

public class MenuSeeAllResa {
	
	public static void menuSeeAllResa() throws InterruptedException, ParseException {
		
		IReservationService resaService = new ReservationService();
		System.out.println(resaService.findAll(Reservation.class).toString());
		
		MenuGestion.menuGestion();
		
		
	}

}
