package projet_agence_location.service;

import projet_agence_location.model.Personne;

public interface IPersonneService extends IManagerService<Personne>{

	public Personne getbyLoginAndPwd (String login, String password);
	public void authentification(String login, String password);
}
