package projet_agence_location.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import projet_agence_location.dao.IPersonneDao;
import projet_agence_location.model.Personne;

public class PersonneDao extends ManagerDao<Personne> implements IPersonneDao {

	@SuppressWarnings("static-access")
	@Override
	public Personne getbyLoginAndPwd(String login, String password) {
		Criteria criteria = this.getSessionFactory().openSession().createCriteria(Personne.class);
		criteria.add(Restrictions.eq("login", login));
		criteria.add(Restrictions.eq("password", password));
		return (Personne) criteria.uniqueResult();
	}
}
