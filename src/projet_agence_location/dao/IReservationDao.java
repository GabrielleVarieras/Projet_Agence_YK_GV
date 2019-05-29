package projet_agence_location.dao;

import projet_agence_location.model.Reservation;

public interface IReservationDao extends IManagerDao<Reservation> {
	
	public Reservation getById(int id);

}
