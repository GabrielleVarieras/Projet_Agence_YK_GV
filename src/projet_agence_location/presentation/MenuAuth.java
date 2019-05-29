package projet_agence_location.presentation;

import java.text.ParseException;
import java.util.Scanner;

import projet_agence_location.model.Personne;
import projet_agence_location.service.IPersonneService;
import projet_agence_location.service.impl.PersonneService;

public class MenuAuth {

	public static void menuAuth() throws InterruptedException, ParseException {
		System.out.println();
		System.out.println();

		// Cette variable sert pour la boucle while juste apr�s.
		// Si la valeur est toujours "oui" on r�p�te le m�me traitement.
		String repeat = "oui";

		while (repeat.equals("oui")) {
			System.out.println();
			System.out.println("\n*******************************************");
			System.out.println("******* Vous etes a la page de login *******");
			System.out.println("*******************************************\n");

			Scanner sc = new Scanner(System.in);
			System.out.print("\t Saissez votre login   : ");
			String login = sc.next();
			System.out.print(" \t Saissez votre mot de passe : ");
			String mdp = sc.next();

			System.out.println();
			System.out.println("****** Verification en cours ******");
			System.out.print("Chargement en cours : ");

			// Chargement avec Thred.sleep()
			for (int i = 0; i < 10; i++) {
				System.out.print("*");
				Thread.sleep(50);
			}

			// L� on va v�rifi� si l'email et le mot de passe existe dans la
			// liste
			  IPersonneService servicePersonne = new PersonneService();
			  servicePersonne.authentification(login, mdp);
			  

			// Si l'utilisateur a mal saisie le mot de passe ou l'�mail on va
			// afficher un message
			// Et lui demander de r�essayer � nouveau
			if (Personne.connectedUser == null) {
				System.out.println("login ou mot de passe incorrecte !!");
				System.out.println("voulez vous r�essayer � nouveau? (oui/non) ?!");
				repeat = sc.next();
				if (repeat.equals("non")) {
					MenuPrincipale.menuPrincipale();
				}
			} else {
				// Si les coordonn�es sont correctes on va arr�ter avec la
				// boucle while
				// On affecte donc la valeur "non" � la variable <repeat>
				repeat = "non";
				System.out.println();
				// On affiche un message pour l'utilisateur et on le redirige
				// vers la page menu Gestion
				System.out.println("F�licitation vous etes logg�");
				MenuGestion.menuGestion();
			}

		}
	}

}
