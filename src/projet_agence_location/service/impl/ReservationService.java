package projet_agence_location.service.impl;

import projet_agence_location.dao.IReservationDao;
import projet_agence_location.dao.impl.ReservationDao;
import projet_agence_location.model.Reservation;
import projet_agence_location.service.IReservationService;

public class ReservationService extends ManagerService<Reservation> implements IReservationService {

	IReservationDao rdao= new ReservationDao();
	
	@Override
	public Reservation getById(int id) {
		return rdao.getById(id);
	}

}
