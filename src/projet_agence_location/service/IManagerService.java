package projet_agence_location.service;

import java.util.ArrayList;

public interface IManagerService <T> {
	
	T addObject (T Obj);
	T updateObject(T Obj);
	boolean deleteObject(T Obj);
	boolean resetTable(T Obj);
	
	T findById(Class<?> clazz,Long id);
	public ArrayList<T> findAll(Class<?> clazz);

}
