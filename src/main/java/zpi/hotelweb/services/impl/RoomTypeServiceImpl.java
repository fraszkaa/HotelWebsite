package zpi.hotelweb.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import zpi.hotelweb.model.RoomType;
import zpi.hotelweb.services.RoomTypeService;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

/**
 * Created by Katarzyna on 23/03/2016.
 */
public class RoomTypeServiceImpl implements RoomTypeService{

    @Autowired
    private EntityManagerFactory entityManagerFactory;

    @Override
    public List<RoomType> listAll() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        return entityManager.createQuery("from ROOM_TYPE", RoomType.class).getResultList();
    }

    @Override
    public RoomType getById(Long id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        return entityManager.find(RoomType.class, id);
    }

    @Override
    public RoomType saveOrUpdate(RoomType reservation) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        RoomType savedRoomType = entityManager.merge(reservation);
        entityManager.getTransaction().commit();
        return savedRoomType;
    }

    @Override
    public void delete(Long id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.remove(entityManager.find(RoomType.class, id));
        entityManager.getTransaction().commit();
    }
}
