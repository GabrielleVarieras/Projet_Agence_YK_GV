package projet_agence_location.service;

import projet_agence_location.model.Reservation;

public interface IReservationService extends IManagerService<Reservation>{

	public Reservation getById(int id);
}
