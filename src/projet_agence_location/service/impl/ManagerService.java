package projet_agence_location.service.impl;

import java.util.ArrayList;

import projet_agence_location.dao.IManagerDao;
import projet_agence_location.dao.impl.ManagerDao;
import projet_agence_location.service.IManagerService;

public class ManagerService<T> implements IManagerService<T> {

	IManagerDao<T> mdao = new ManagerDao<T>();

	@Override
	public T addObject(T Obj) {
		// TODO Auto-generated method stub
		
		return mdao.addObject(Obj);
	}

	@Override
	public T updateObject(T Obj) {
		// TODO Auto-generated method stub
		return mdao.updateObject(Obj);
	}

	@Override
	public boolean deleteObject(T Obj) {
		// TODO Auto-generated method stub
		return mdao.deleteObject(Obj);
	}

	@Override
	public boolean resetTable(T Obj) {
		// TODO Auto-generated method stub
		return mdao.resetTable(Obj);
	}

	@Override
	public T findById(Class<?> clazz, Long id) {
		// TODO Auto-generated method stub
		return mdao.findById(clazz, id);
	}

	@Override
	public ArrayList<T> findAll(Class<?> clazz) {
		// TODO Auto-generated method stub
		return mdao.findAll(clazz);
	}

}
