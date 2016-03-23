package zpi.hotelweb.services;

import org.springframework.data.repository.CrudRepository;
import zpi.hotelweb.model.Reservation;

import java.util.List;

/**
 * Created by Katarzyna on 23/03/2016.
 */
public interface ReservationService {

    List<Reservation> listAll();
    Reservation getById(Long id);
    Reservation saveOrUpdate(Reservation reservation);
    void delete(Long id);
}
