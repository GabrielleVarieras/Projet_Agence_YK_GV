package projet_agence_location.dao.impl;

import java.util.ArrayList;


import org.hibernate.Session;
import org.hibernate.Transaction;

import projet_agence_location.dao.IManagerDao;
import projet_agence_location.util.HibernateUtil;

public class ManagerDao<T> extends HibernateUtil implements IManagerDao<T> {
	
	@SuppressWarnings("static-access")
	Session hibernateSession = this.getSessionFactory().openSession();


	@Override
	public T addObject(T Obj) {
		// TODO Auto-generated method stub
		Transaction tr = hibernateSession.beginTransaction();
		@SuppressWarnings("unchecked")
		T Entity = (T) hibernateSession.save(Obj);
		this.hibernateSession.flush();
		tr.commit();
		return  Entity;	
	}

	@SuppressWarnings("unchecked")
	@Override
	public T updateObject(T Obj) {
		// TODO Auto-generated method stub
		Transaction tr = hibernateSession.beginTransaction();
		T Entity = (T) hibernateSession.merge(Obj);
		this.hibernateSession.flush();
		tr.commit();
		return  Entity;
	}

	@Override
	public boolean deleteObject(T Obj) {
		// TODO Auto-generated method stub
		Transaction tr = hibernateSession.beginTransaction();
		hibernateSession.delete(Obj);
		this.hibernateSession.flush();
		tr.commit();
		return false;
	}

	@Override
	public boolean resetTable(T Obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@SuppressWarnings("unchecked")
	@Override
	public T findById(Class<?> clazz,Long id) {
		// TODO Auto-generated method stub
		return (T) hibernateSession.get(clazz, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public ArrayList<T> findAll(Class<?> clazz) {
		ArrayList<T> tableau = (ArrayList<T>) hibernateSession.createQuery("FROM " +clazz.getName()).list();
		// TODO Auto-generated method stub
		return tableau;
	}

}