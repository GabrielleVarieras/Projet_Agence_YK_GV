package projet_agence_location.service.impl;

import projet_agence_location.dao.IPersonneDao;
import projet_agence_location.dao.impl.PersonneDao;
import projet_agence_location.model.Personne;
import projet_agence_location.service.IPersonneService;

public class PersonneService extends ManagerService<Personne> implements IPersonneService {

	IPersonneDao pdao = new PersonneDao();
	
	@Override
	public Personne getbyLoginAndPwd(String login, String password) {
		return pdao.getbyLoginAndPwd(login, password);
	}
	
//	public void authentification() {
//		for (Personne p : pdao.findAll(Personne.class)) {
//			System.out.println(p.toString());
//			if (getbyLoginAndPwd("login", "password") != null) {
//				Personne.connectedUser = p;
//			}
//			
//		}
	public void authentification( String login, String password) {
	for (Personne p : pdao.findAll(Personne.class)) {
		if (p.getLogin().equals(login) && p.getPassword().equals(password)){
			Personne.connectedUser = p;
		}
		
		}
	}
}
