package zpi.hotelweb.services.impl;

import org.springframework.stereotype.Service;
import zpi.hotelweb.model.Reservation;
import zpi.hotelweb.services.ReservationService;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import java.util.List;

/**
 * Created by Katarzyna on 23/03/2016.
 */
@Service
public class ReservtionServiceImpl implements ReservationService {

    private EntityManagerFactory entityManagerFactory;

    @PersistenceUnit
    public void setEntityManagerFactory(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }

    @Override
    public List<Reservation> listAll() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        return entityManager.createQuery("from RESERVATION", Reservation.class).getResultList();
    }

    @Override
    public Reservation getById(Long id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        return entityManager.find(Reservation.class, id);
    }

    @Override
    public Reservation saveOrUpdate(Reservation reservation) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Reservation savedReservation = entityManager.merge(reservation);
        entityManager.getTransaction().commit();
        return savedReservation;
    }

    @Override
    public void delete(Long id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.remove(entityManager.find(Reservation.class, id));
        entityManager.getTransaction().commit();
    }
}
