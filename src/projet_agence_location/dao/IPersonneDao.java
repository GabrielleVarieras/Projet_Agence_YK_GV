package projet_agence_location.dao;

import projet_agence_location.model.Personne;

public interface IPersonneDao extends IManagerDao<Personne> {

	public Personne getbyLoginAndPwd (String login, String password);
}
