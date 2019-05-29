package projet_agence_location.presentation;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import projet_agence_location.model.Admin;
import projet_agence_location.model.Client;
import projet_agence_location.model.Personne;
import projet_agence_location.model.Voiture;
import projet_agence_location.service.IVoitureService;
import projet_agence_location.service.impl.VoitureService;

public class MenuSeeAllVoitures {
	
	public static void menuSeeAllVoitures() throws InterruptedException, ParseException {
		
		IVoitureService voitureService = new VoitureService();

		
		if(Personne.connectedUser instanceof Admin) {
			System.out.println("Liste de tous les véhicules");
			System.out.println(voitureService.findAll(Voiture.class).toString());
			MenuGestion.menuGestion();
		}
		else {
			System.out.println("Liste de tous les véhicules disponibles");
			List<Voiture> l = voitureService.findAll(Voiture.class);
			List<Voiture> dispo = new ArrayList<Voiture>();
			for (Voiture v : l) {
				if (v.isDisponibilite()) {
					dispo.add(v);
				}
			}
			System.out.println(dispo.toString());
			MenuPrincipale.menuPrincipale();
		}

	}

}
